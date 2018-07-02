package NIO;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class FileExample {

	public static void main(String ... args) throws Exception {
		Path path = Paths.get("/users/jang/git/fileTest/file.md");

		System.out.println("Files.isDirectory : " + Files.isDirectory(path));
		System.out.println("Files.isRegularFile : " + Files.isRegularFile(path));
		System.out.println("getLastModifiedTime : " + Files.getLastModifiedTime(path));
		System.out.println("size : " + Files.size(path) + "byte");
		System.out.println();
		System.out.println();
	}
}
