package nio_p;

import java.io.IOException;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.attribute.FileTime;
import java.time.Instant;

public class FileMain {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		Path pp = Paths.get("ppp");
		
		System.out.println(pp);
		System.out.println(Files.isDirectory(pp));
		System.out.println(Files.isRegularFile(pp));
//		System.out.println(Files.newDirectoryStream(pp)); 
		
		//폴더속 파일들 불러오기
		DirectoryStream<Path> ds = Files.newDirectoryStream(pp);
		String res = "";
		for (Path path : ds) {
			
			if(Files.size(path)==0)
				res = "<DIR>\t\t";
			else {
				res = "\t\t";	
			}
			
			FileTime aa = Files.getLastModifiedTime(path);
			
			Object aaa = aa;
			String [] aaaa = aaa.toString().split("T");
			String [] aaaaa = aaaa[1].split("[.]");
			String aaaaaa = aaaa[0] + "\t" + aaaaa[0];
		
			
			System.out.println(aaaaaa + "\t" + res + Files.size(path) + "\t" + path.getName(1));
		}
		
		
		System.out.println("-----------------------------");
		
		pp = Paths.get("ppp/aaa.jpg");
		System.out.println(pp);
		System.out.println(Files.isDirectory(pp));
		System.out.println(Files.isRegularFile(pp));
		System.out.println(Files.getLastModifiedTime(pp));
		System.out.println(Files.size(pp));
		System.out.println(Files.getOwner(pp));
		System.out.println(Files.isHidden(pp));
		System.out.println(Files.isReadable(pp));
		System.out.println(Files.isWritable(pp));
		System.out.println("파일명 : " + pp.getFileName());
		System.out.println("현재 디렉토리명 : " + pp.getParent().getFileName());
		System.out.println("디렉토리 경로 수  : " + pp.getNameCount());
		
		System.out.println("-----------------------------");
		
		for (int i = 0; i < pp.getNameCount(); i++) {
			System.out.println(pp.getName(i)); 
			
		}
		
		
	}

}
