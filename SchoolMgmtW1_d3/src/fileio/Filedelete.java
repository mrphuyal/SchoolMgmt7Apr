package fileio;
import java.io.File;

public class Filedelete {
	
public void delete(String delelocation) {
	 File file = new File(delelocation); 
     if(file.exists() && file.isFile()) {
         if(file.delete()) 
         { 
             System.out.println("File deleted successfully"); 
         } 
         else
         { 
             System.out.println("Failed to delete the file"); 
         }     	 
     }else {
    	 System.out.println("file doesnot exist");
     }

}

}
//public static void main(String[] args) 
//{ 
//   filedelete del = new filedelete();
//   del.delete();
//} 
//public void delete() {
// 	File delfile = new File("C:\\Users\\Desktop\\deletefile.txt"); 
// 
// 	if(delfile.delete()==true) 
//    { 
//        System.out.println("File deleted successfully"); 
//    } 
//    else
//    { 
//        System.out.println("Failed to delete the file");
//    } 