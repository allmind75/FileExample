package NIO;

import java.nio.file.Path;
import java.nio.file.Paths;

public class PathExample {

	public static void main(String ... args) {
		Path path = Paths.get("/users/jang/git/fileTest/file.md");
		System.out.println("[File Name] : " + path.getFileName());
		System.out.println("[Parent Dir] : " + path.getParent().getFileName());
		System.out.println("[중첩경로수 path.getNameCount()] " + path.getNameCount());
		
		for(int i=0 ; i<path.getNameCount() ; i++) {
			System.out.print(path.getName(i));
			if(i != path.getNameCount() - 1) 
				System.out.print("/");
		}
		
		
		
	}
}
