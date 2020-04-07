package fileio;

import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.Scanner;

public class Application {
	public static void main(String[] args) throws IOException {
		Application app = new Application();
		FileMover filemover = new FileMover();
		Filedelete filedel = new Filedelete();

//		Scanner s1 = new Scanner(System.in);
//		System.out.println("Enter Origin File path: ");
//		String origin = s1.nextLine();
//		System.out.println("Enter Destination File path: ");
//		String destination = s1.nextLine();

		File source = new File("C:\\Users\\Sudip\\Desktop\\Class\\file5.txt");
		File destf = new File("C:\\Users\\Sudip\\Desktop\\Destination\\file11.txt");
		String deletelocation = "C:\\Users\\Sudip\\Desktop\\deletefile.txt";
		
		app.listFiles("C:\\Users\\Sudip\\Desktop");
		
//	filedel.delete(deletelocation);
//		filedel.delete();														///////////////
		// File source = new File(origin);
		// File destf = new File(destination);
		filedel.delete(deletelocation);
		Path originpath = source.toPath();
		Path destpath = destf.toPath();

//		System.out.println("Confirm Move? Y/N");
//		String s = s1.nextLine();
//		Boolean conf = s.equals("Y");
//		if (conf == true) {

//		System.out.println("Move requested !");
//		filemover.moveFile(originpath, destpath);

//
//		} else {
//			System.out.println("Move request denied !");
//		}

	}

	public void listFiles(String dir) {
		File directory = new File(dir);
		if(directory.isDirectory()) {
		File[] files = directory.listFiles();
		System.out.println(files);
		Arrays.sort(files);

		for (File f : files) {
			if (f.isFile()) {
				System.out.println("File: " + f.getName());
			}
			}
		}
	}
}
