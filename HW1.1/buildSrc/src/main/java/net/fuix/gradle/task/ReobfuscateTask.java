package net.fuix.gradle.task;

import net.md_5.specialsource.JarMapping;
import net.md_5.specialsource.JarRemapper;
import net.md_5.specialsource.provider.ClassLoaderProvider;
import net.md_5.specialsource.provider.JointProvider;
import org.gradle.api.DefaultTask;
import org.gradle.api.file.FileCollection;
import org.gradle.api.file.FileVisitDetails;
import org.gradle.api.file.FileVisitor;
import org.gradle.api.tasks.*;
import org.gradle.api.tasks.incremental.IncrementalTaskInputs;
import org.gradle.api.tasks.incremental.InputFileDetails;
import net.fuix.gradle.util.DirectoryClassRepo;
import net.fuix.gradle.util.RepoInheritanceProvider;
import net.fuix.gradle.util.FileUtils;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLClassLoader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class ReobfuscateTask extends DefaultTask {

	@InputDirectory
	private File inputDir;

	@InputFiles
	private List<File> srg = new ArrayList<>();
	private FileCollection classpath;

	@OutputDirectory
	private File outputDir = new File(getProject().getBuildDir(), getName());
	private DirectoryClassRepo classRepo;
	private JarRemapper remapper;

	public void addSrg(File srg) { this.srg.add(srg); }
	public void addSrg(String srg) { this.srg.add(getProject().file(srg)); }

	public File getInputDir() { return inputDir; }
	public void setInputDir(File inputDir) { this.inputDir = inputDir; }

	public FileCollection getClasspath() { return classpath; }
	public void setClasspath(FileCollection classpath) { this.classpath = classpath; }

	public File getOutputDir() { return outputDir; }
	public void setOutputDir(File outputDir) { this.outputDir = outputDir; }

	@TaskAction
	void doAction(IncrementalTaskInputs inputs) throws IOException {
		initRemapper();
		if(!inputs.isIncremental()) {
			org.apache.commons.io.FileUtils.cleanDirectory(outputDir);
			getProject().fileTree(inputDir).visit(new FileVisitor(){
				@Override
				public void visitDir(FileVisitDetails dirDetails) { }

				@Override
				public void visitFile(FileVisitDetails fileDetails)
				{
					processClass(fileDetails.getPath());
				}
			});
		} else {
			inputs.outOfDate((InputFileDetails detals) -> processClass(detals.getFile()));

			Set<File> dirsToCheck = new HashSet<File>();
			inputs.removed((InputFileDetails detals) -> {
				File file = new File(outputDir, getRelPath(detals.getFile()));
				file.delete();
				dirsToCheck.add(file.getParentFile());
			});

			for(File file : dirsToCheck)
				if(file.exists() && FileUtils.isDirEmptyRecursive(file.toPath())) {
					org.apache.commons.io.FileUtils.deleteDirectory(file);
					File parent = file.getParentFile();
					if(FileUtils.isDirEmpty(parent.toPath()))
						org.apache.commons.io.FileUtils.deleteDirectory(parent);
				}
		}
	}

	private String getRelPath(File file) {
		return FileUtils.getRelativePath(inputDir, file);
	}

	private void processClass(File file) {
		if(file.isDirectory()) return;
		processClass(getRelPath(file));
	}

	private File resolveFile(String path) {
		return new File(inputDir, path);
	}

	private void processClass(String path) {
		try {
			byte[] bytes = remapper.remapClassFile(org.apache.commons.io.FileUtils.readFileToByteArray(resolveFile(path)), classRepo);
			org.apache.commons.io.FileUtils.writeByteArrayToFile(new File(outputDir, remapper.map(path.substring(0, path.length() - 6))+".class"), bytes);
		} catch(IOException e) {
			throw new RuntimeException(e);
		}
	}

	private void initRemapper() throws IOException {
		JarMapping mapping = new JarMapping();
		for(File file : srg)
			mapping.loadMappings(file);
		classRepo = new DirectoryClassRepo(inputDir);
		JointProvider inheritanceProviders = new JointProvider();
		inheritanceProviders.add(new RepoInheritanceProvider(classRepo));
		if(this.classpath != null) {
			inheritanceProviders.add(new ClassLoaderProvider(new URLClassLoader(toUrls(this.classpath))));
		}
		mapping.setFallbackInheritanceProvider(inheritanceProviders);

		this.remapper = new JarRemapper(null, mapping);
	}

	private static URL[] toUrls(FileCollection collection) throws MalformedURLException {
		ArrayList<URL> urls = new ArrayList<URL>();

		for(File file : collection.getFiles()) urls.add(file.toURI().toURL());

		return urls.toArray(new URL[urls.size()]);
	}
}
