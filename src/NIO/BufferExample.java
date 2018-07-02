package NIO;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.channels.FileChannel;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.EnumSet;

public class BufferExample {

	public static void main(String ... args) throws Exception {
		Path from = Paths.get("/users/jang/git/fileTest/test.jpg");
		Path to1 = Paths.get("/users/jang/git/fileTest2/test2.jpg");
		Path to2 = Paths.get("/users/jang/git/fileTest3/test3.jpg");
		
		long size = Files.size(from);
		
		FileChannel fileChannel_from = FileChannel.open(from);
		FileChannel fileChannel_to1 = FileChannel.open(to1, 
				EnumSet.of(StandardOpenOption.CREATE, StandardOpenOption.WRITE));
		FileChannel fileChannel_to2 = FileChannel.open(to2,
				EnumSet.of(StandardOpenOption.CREATE, StandardOpenOption.WRITE));
		
		ByteBuffer nonDirectBuffer = ByteBuffer.allocate((int) size);//파일 크기만큼 JVM 힙 메모리에 버퍼 생성
		ByteBuffer directBuffer = ByteBuffer.allocateDirect((int) size).order(ByteOrder.nativeOrder());//운영체제가 관리하는 메모리에 버퍼 생성
		
		System.out.println("ByteOrder.nativeOrder : " + ByteOrder.nativeOrder());
		System.out.println("nonDirectBuffer.capacity : " + nonDirectBuffer.capacity() + "byte");
		System.out.println("directBuffer.capacity : " + directBuffer.capacity() + "byte");
		
		long start, end;
		
		start = System.nanoTime();
		for(int i=0 ; i<100 ; i++) {
			fileChannel_from.read(nonDirectBuffer);
			nonDirectBuffer.flip();
			fileChannel_to1.write(nonDirectBuffer);
			nonDirectBuffer.clear();
		}
		end = System.nanoTime();
		System.out.println("nonDirect : " + (end-start) + "ns");
		
		fileChannel_from.position(0);
		
		start = System.nanoTime();
		for(int i=0 ; i<100 ; i++) {
			fileChannel_from.read(directBuffer);
			directBuffer.flip();
			fileChannel_to2.write(directBuffer);
			directBuffer.clear();
		}
		end = System.nanoTime();
		System.out.println("direct : " + (end-start) + "ns");
		
		fileChannel_from.close();
		fileChannel_to1.close();
		fileChannel_to2.close();
		
	}
}
