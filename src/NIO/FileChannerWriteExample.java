package NIO;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

public class FileChannerWriteExample {

	public static void main(String ... args) throws IOException {
		Path path = Paths.get("/users/jang/git/fileTest/file.md");
		Files.createDirectories(path.getParent());
		
		FileChannel fileChannel = FileChannel .open(path,
				StandardOpenOption.CREATE, StandardOpenOption.WRITE);
		
		String data = "Hello";
		Charset charset = Charset.defaultCharset();
		ByteBuffer byteBuffer = charset.encode(data);
		
		int byteCount = fileChannel.write(byteBuffer);
		System.out.println("file.md : " + byteCount + " bytes written");
		
		fileChannel.close();
	}
}
