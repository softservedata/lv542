package net.fuix.gradle.task;


import au.com.bytecode.opencsv.CSVParser;
import au.com.bytecode.opencsv.CSVReader;
import com.google.common.io.Files;
import org.gradle.api.DefaultTask;
import org.gradle.api.tasks.InputFile;
import org.gradle.api.tasks.OutputFile;
import org.gradle.api.tasks.TaskAction;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;
import java.util.HashMap;

public class GenSrgTask extends DefaultTask {

    @InputFile private File inSrg;
    @InputFile private File methodsCsv;
    @InputFile private File fieldsCsv;

    @OutputFile private File notchToMcpSrg;
    @OutputFile private File mcpToSrgSrg;
    @OutputFile private File mcpToNotchSrg;

    public static CSVReader getReader(File file) throws IOException {
        return new CSVReader(Files.newReader(file, Charset.defaultCharset()), CSVParser.DEFAULT_SEPARATOR, CSVParser.DEFAULT_QUOTE_CHARACTER, CSVParser.DEFAULT_ESCAPE_CHARACTER, 1, false);
    }

    @TaskAction
    public void doTask() throws IOException {
        HashMap<String, String> methods = new HashMap<String, String>();
        HashMap<String, String> fields = new HashMap<String, String>();

        // read methods
        CSVReader csvReader = getReader(getMethodsCsv());
        for (String[] s : csvReader.readAll()) {
            methods.put(s[0], s[1]);
        }

        // read fields
        csvReader = getReader(getFieldsCsv());
        for (String[] s : csvReader.readAll()) {
            fields.put(s[0], s[1]);
        }


        File deobfFile = getNotchToMcpSrg();
        File reobfFile = getMcpToSrgSrg();

        // verify files...
        if (!deobfFile.exists()) {
            deobfFile.getParentFile().mkdirs();
            deobfFile.createNewFile();
        }

        if (!reobfFile.exists()) {
            reobfFile.getParentFile().mkdirs();
            reobfFile.createNewFile();
        }

        // create streams
        BufferedReader srgIn = Files.newReader(getInSrg(), Charset.defaultCharset());
        BufferedWriter notch2Mcp = Files.newWriter(getNotchToMcpSrg(), Charset.defaultCharset());
        BufferedWriter mcpToSrg = Files.newWriter(getMcpToSrgSrg(), Charset.defaultCharset());
        BufferedWriter mcpToNotch = Files.newWriter(getMcpToNotchSrg(), Charset.defaultCharset());

        // IN
        // notch -> srg

        // deobf
        // notch -> mcp

        // reobf
        // mcp -> srg

        String line, temp, in, out;
        String[] split;
        while ((line = srgIn.readLine()) != null) {
            if (line.startsWith("PK:")) {
                // nobody cares about the packages.
                notch2Mcp.write(line);
                notch2Mcp.newLine();

                mcpToSrg.write(line);
                mcpToSrg.newLine();

                mcpToNotch.write(line);
                mcpToNotch.newLine();
            } else if (line.startsWith("CL:")) {
                // deobf:  no change here...
                notch2Mcp.write(line);
                notch2Mcp.newLine();

                // reobf: same classes on both sides.
                split = line.split(" "); // 0=type  1=notch  2=srg=mcp
                mcpToSrg.write("CL: "+split[2]+" "+split[2]);
                mcpToSrg.newLine();

                // output is notch
                mcpToNotch.write("CL: "+split[2]+" "+split[1]);
                mcpToNotch.newLine();
            } else if (line.startsWith("FD:")) {
                // deobf: need to rename that method.
                split = line.split(" "); // 0=type  1=notch  2=srg

                temp = split[2].substring(split[2].lastIndexOf('/')+1);
                out = split[2];

                if (fields.containsKey(temp))
                    out = split[2].replace(temp, fields.get(temp));

                notch2Mcp.write("FD: "+split[1]+" "+out);
                notch2Mcp.newLine();

                // reobf: reverse too
                mcpToSrg.write("FD: "+out+" "+split[2]);
                mcpToSrg.newLine();

                // output is notch
                mcpToNotch.write("FD: "+out+" "+split[1]);
                mcpToNotch.newLine();
            } else if (line.startsWith("MD:")) {
                // deobf: rename that method.
                split = line.split(" "); // 0=type  1-2=notch  3-4=srg
                temp = split[3].substring(split[3].lastIndexOf('/')+1);

                in = split[1] + " " + split[2]; // notch
                out = split[3] + " " + split[4]; // srg

                if (methods.containsKey(temp))
                    out = out.replace(temp, methods.get(temp)); // now MCP

                notch2Mcp.write("MD: "+in+" "+out);
                notch2Mcp.newLine();

                // reobf reverse too
                mcpToSrg.write("MD: "+out+" "+split[3]+" "+split[4]);
                mcpToSrg.newLine();

                // output is notch
                mcpToNotch.write("MD: "+out+" "+split[1]+" "+split[2]);
                mcpToNotch.newLine();
            }
        }

        srgIn.close();

        notch2Mcp.flush();
        notch2Mcp.close();

        mcpToSrg.flush();
        mcpToSrg.close();

        mcpToNotch.flush();
        mcpToNotch.close();
    }

    public File getInSrg() {
        return inSrg;
    }
    public void setInSrg(File inSrg) {
        this.inSrg = inSrg;
    }

    public File getMethodsCsv() {
        return methodsCsv;
    }
    public void setMethodsCsv(File methodsCsv) {
        this.methodsCsv = methodsCsv;
    }

    public File getFieldsCsv() {
        return fieldsCsv;
    }
    public void setFieldsCsv(File fieldsCsv) {
        this.fieldsCsv = fieldsCsv;
    }

    public File getNotchToMcpSrg() {
        return notchToMcpSrg;
    }
    public void setNotchToMcpSrg(File deobfSrg) {
        this.notchToMcpSrg = deobfSrg;
    }

    public File getMcpToSrgSrg() {
        return mcpToSrgSrg;
    }
    public void setMcpToSrgSrg(File reobfSrg) {
        this.mcpToSrgSrg = reobfSrg;
    }

    public File getMcpToNotchSrg() {
        return mcpToNotchSrg;
    }
    public void setMcpToNotchSrg(File reobfSrg) {
        this.mcpToNotchSrg = reobfSrg;
    }
}