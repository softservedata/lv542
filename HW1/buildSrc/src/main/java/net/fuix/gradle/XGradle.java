package net.fuix.gradle;

import net.fuix.gradle.task.ReobfuscateTask;
import net.fuix.gradle.util.FileUtils;
import org.gradle.api.Plugin;
import org.gradle.api.Project;
import org.gradle.api.plugins.JavaPluginConvention;
import org.gradle.api.tasks.TaskProvider;
import org.gradle.api.tasks.bundling.Jar;
import org.gradle.api.tasks.compile.JavaCompile;
import org.gradle.language.jvm.tasks.ProcessResources;
import proguard.ParseException;
import proguard.gradle.ProGuardTask;

import java.io.File;
import java.io.IOException;

public class XGradle implements Plugin<Project> {
    @Override
    public void apply(Project project) {
        /** ##################################################################################### **/

        if (project.getPluginManager().findPlugin("java") == null) project.getPluginManager().apply("java");

        JavaCompile javaCompile = (JavaCompile) project.getTasks().getByName("compileJava");
        ReobfuscateTask reobfServer = project.getTasks().create("reobfServer", ReobfuscateTask.class, task -> {
            task.setClasspath(javaCompile.getClasspath());
            task.dependsOn(javaCompile);
            task.setInputDir(javaCompile.getDestinationDir());
        });

        TaskProvider<Jar> jarServer = project.getTasks().register("jarServer", Jar.class);
        ProcessResources processResources = (ProcessResources) project.getTasks().getByName("processResources");

        jarServer.configure((task) -> {
            task.dependsOn(reobfServer, processResources);
            task.from(reobfServer.getOutputDir(), processResources);
        });

        if(((String) project.property("produce_server_jar")).equalsIgnoreCase("true"))
            project.getArtifacts().add("archives", jarServer);
    }
}
