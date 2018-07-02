package NIO;

import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class DirectoryExample {

	public static void main(String ... args) throws Exception {
		Path path1 = Paths.get("/users/jang/git/fileTest3");
		Path path2 = Paths.get("/users/jang/git/fileTest3", "file.txt");
		
		if(Files.notExists(path1)) {
			Files.createDirectories(path1);
		} else {
			System.out.println("exist dir");
		}
		
		if(Files.notExists(path2)) {
			Files.createFile(path2);
		}
		
		Path path3 = Paths.get("/users/jang/git/fileTest3");
		DirectoryStream<Path> directoryStream = Files.newDirectoryStream(path3);
		for(Path path : directoryStream) {
			if(Files.isDirectory(path)) {
				System.out.println("[directory] : " + path.getFileName());
			} else {
				System.out.println("[file] : " + path.getFileName() + ", [size] : " + Files.size(path));
			}
		}
	}
}
