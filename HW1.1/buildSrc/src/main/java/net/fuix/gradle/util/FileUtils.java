package net.fuix.gradle.util;

import org.gradle.api.file.FileTree;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Iterator;

public class FileUtils
{
	public static String getRelativePath(File base, File child)
	{
		return base.toURI().relativize(child.toURI()).getPath();
	}

	public static boolean isDirEmpty(final Path directory) throws IOException
	{
		try(DirectoryStream<Path> dirStream = Files.newDirectoryStream(directory))
		{
			return !dirStream.iterator().hasNext();
		}
	}

	public static boolean isDirEmptyRecursive(final Path directory) throws IOException
	{
		try(DirectoryStream<Path> dirStream = Files.newDirectoryStream(directory))
		{
			for(Iterator<Path> it = dirStream.iterator(); it.hasNext();)
			{
				Path path = it.next();
				if(!Files.isDirectory(path) || !isDirEmptyRecursive(path))
					return false;
			}
		}

		return true;
	}

	public static void setCompileFlag(FileTree source, String fileName, boolean forServer) {
		Path compileFlag = null;

		for (File file : source.getFiles()) {
			if(file.getName().equalsIgnoreCase(fileName + ".java")) {
				compileFlag = file.toPath();
				continue;
			}
		}

		if(compileFlag != null) {
			try {
				String content = new String(Files.readAllBytes(compileFlag), StandardCharsets.UTF_8);
				content = content.replaceAll("FOR_SERVER.*;", "FOR_SERVER = " + (forServer ? "true" : "false") + ";");
				Files.write(compileFlag, content.getBytes(StandardCharsets.UTF_8));
			} catch (IOException e) {
				throw new RuntimeException(e);
			}
		} else {
			throw new RuntimeException("Error. File CompileFlag (" + fileName + ") not found!");
		}
	}
}
