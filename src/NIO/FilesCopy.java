package NIO;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

public class FilesCopy {

	public static void main(String...args) throws Exception {
		Path from = Paths.get("/users/jang/git/fileTest/file.md");
		Path to = Paths.get("/users/jang/git/fileTest/file2.md");
		
		Files.copy(from,  to, StandardCopyOption.REPLACE_EXISTING);
		
	}
}
