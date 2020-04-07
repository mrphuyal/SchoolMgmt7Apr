package fileio;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.Scanner;

public class FileMover {

	public void moveFile(Path fileorigin, Path filedest) throws IOException {
		try {
		System.out.println("Trying...");
		Files.move(fileorigin, filedest);
	//	Files.move(fileorigin, filedest, StandardCopyOption.REPLACE_EXISTING);
		System.out.println("Copy Sucessful !");
	} catch (Exception e) {
	System.out.println("Error !");	
	}
	}


}
