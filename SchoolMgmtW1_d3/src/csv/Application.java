package csv;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

import pojoclass.TeacherPojo;

public class Application {

	int tid = 1;
	int sid = 1;
	int bookid = 1;
	int sportid = 1;

	Scanner in = new Scanner(System.in);
	Teacher teacher = new Teacher();
	Student student = new Student();
	Library library = new Library();
	Sport sport = new Sport();

	public static void main(String[] args) throws Exception {
		Application mainapp = new Application();
		mainapp.loadTeachercsv();
		mainapp.loadSportCsv();
		mainapp.loadStudentCsv();
		mainapp.loadLibraryCsv();
		mainapp.mainMenu();
	}

	public void mainMenu() throws Exception {
		System.out.println("Please select the appropriate Option: ");
		System.out.println(
				"A - Teacher Management, B - Student Management, C - Library Management, D - Sports Management");
		String selectedOption = in.nextLine();
		if (selectedOption.equals("A")) {
			teacherLoad();
		} else if (selectedOption.equals("B")) {
			studentLoad();
		} else if (selectedOption.equals("C")) {
			libraryLoad();
		} else if (selectedOption.equals("D")) {
			sportsLoad();
		} else {
			mainMenu();
		}
	}

	private void sportsLoad() {
		String filePath = "C:\\Users\\Sudip\\Desktop\\JavaClass\\data\\sport.csv";
		File file = new File(filePath);

		try {
			BufferedReader br = new BufferedReader(new FileReader(file));
			String line;
			while ((line = br.readLine()) != null) {
				String[] arr = line.split(",");
				Map<String, Object> tempSport = new HashMap<String, Object>();
				tempSport.put("ID", arr[0]);
				tempSport.put("FirstName", arr[1]);
				tempSport.put("LastName", arr[2]);
				tempSport.put("PhoneNumber", arr[3]);
				sport.updateData(tempSport);
			}
			tid = teacher.idNumber();
			br.close();
		} catch (Exception e) {
			if (file.isFile()) {
				System.out.println("File Read Error !");
				e.printStackTrace();
			} else {
				System.out.println("File not Found !");
				e.printStackTrace();
			}
		}
	}
	private void libraryLoad() throws Exception {
		System.out.println(" Select Option; A - Add Books, B- Edit Entry, C - Remove Entry, D - View all Entries: ");
		String libraryAction = in.nextLine();
		String filePath = "C:\\Users\\Sudip\\Desktop\\JavaClass\\data\\books.csv";
		File file = new File(filePath);

		if (libraryAction.equals("A")) {
			Map<String, Object> bookdetails = new HashMap<>();
			bookdetails.put("ID", bookid);
			System.out.println("Enter Book Name: ");
			String bookname = in.nextLine();
			System.out.println("Publisher Name: ");
			String publisher = in.nextLine();
			System.out.println("Enter Book Issued to: ");
			String issued = in.nextLine();
			bookdetails.put("Title", bookname);
			bookdetails.put("Publisher", publisher);
			bookdetails.put("IssuedTo", issued);
			library.newBook(bookdetails, file);
			bookid++;
			mainMenu();
		} else if (libraryAction.equals("B")) {
			System.out.println("Enter Book ID to edit: ");
			Object editId = in.nextLine();
			List<Map<String, Object>> tempBookList = library.getAllBooks();

			Map<String, Object> editBookData = new HashMap<String, Object>();
			for (int i = 0; i < tempBookList.size(); i++) {
				if (tempBookList.get(i).get("ID").equals(editId)) {
					tempBookList.remove(i);
				}
			}

			System.out.println("Enter Book Name: ");
			String bookname = in.nextLine();
			System.out.println("Publisher Name: ");
			String publisher = in.nextLine();
			System.out.println("Enter Book Issued to: ");
			String issued = in.nextLine();
			editBookData.put("ID", editId);
			editBookData.put("Title", bookname);
			editBookData.put("Publisher", publisher);
			editBookData.put("IssuedTo", issued);
			tempBookList.add(editBookData);
			library.booksAfterEdit(tempBookList, file);

			mainMenu();
		} else if (libraryAction.equals("C")) {
			System.out.println("Enter Book ID to Remove: ");
			Object removeId = in.nextLine();
			List<Map<String, Object>> tempBookList = library.getAllBooks();
			Map<String, Object> editBookData = new HashMap<String, Object>();
			for (int i = 0; i < tempBookList.size(); i++) {
				if (tempBookList.get(i).get("ID").equals(removeId)) {
					tempBookList.remove(i);
				}
			}
			library.booksAfterEdit(tempBookList, file);

		} else if (libraryAction.equals("D")) {
			List<Map<String, Object>> bookList = library.getAllBooks();
			System.out.printf("ID \tBook Name \t Publisher \tIssued To\n");
			for (int i = 0; i < bookList.size(); i++) {
				System.out.println(bookList.get(i).get("ID") + "\t" + bookList.get(i).get("Title") + "\t\t"
						+ bookList.get(i).get("Publisher") + "\t\t" + bookList.get(i).get("IssuedTo"));
			}
			mainMenu();
		} else {
			mainMenu();
		}
	}

	private void studentLoad() throws Exception {
		System.out.println(
				"Select Option; A - Add Student, B - Edit Student, C - Remove Student, D - View all Entries: ");
		String studentAction = in.nextLine();
		String filePath = "C:\\Users\\Sudip\\Desktop\\JavaClass\\data\\student.csv";
		File file = new File(filePath);
		if (studentAction.equals("A")) {
			Map<String, Object> sdetails = new HashMap<>();
			sdetails.put("ID", sid); // How to put the entries in order?
			System.out.println("Enter First Name: ");
			String fname = in.nextLine();
			System.out.println("Enter Last Name: ");
			String lname = in.nextLine();
			System.out.println("Enter Phone Number: ");
			String phnumber = in.nextLine();
			sdetails.put("FirstName", fname);
			sdetails.put("LastName", lname);
			sdetails.put("PhoneNumber", phnumber);
			student.newStudent(sdetails, file);
			sid++;
			mainMenu();
		} else if (studentAction.equals("D")) {
			List<Map<String, Object>> studentlist = student.getAllStudents();
			System.out.printf("ID \tFirst Name \tLast Name \tPhone Number \n");

			for (int i = 0; i < studentlist.size(); i++) {
				System.out.println(studentlist.get(i).get("ID") + "\t" + studentlist.get(i).get("FirstName") + "\t\t"
						+ studentlist.get(i).get("LastName") + "\t\t" + studentlist.get(i).get("PhoneNumber"));
			}
			mainMenu();
		} else if (studentAction.equals("B")) {

			System.out.println("Enter Student ID number to edit: ");
			Object id = in.nextLine();
			List<Map<String, Object>> tempStudentList = student.getAllStudents();
			Map<String, Object> editStudentData = new HashMap<String, Object>();
			for (int i = 0; i < tempStudentList.size(); i++) {
				if (tempStudentList.get(i).get("ID").equals(id)) {
					tempStudentList.remove(i);
				}
			}
			System.out.println("Enter Name: ");
			String fname = in.nextLine();
			System.out.println("Enter Last Name: ");
			String lname = in.nextLine();
			System.out.println("Enter Phone Number: ");
			String phnumber = in.nextLine();

			editStudentData.put("ID", id);
			editStudentData.put("FirstName", fname);
			editStudentData.put("LastName", lname);
			editStudentData.put("PhoneNumber", phnumber);
			tempStudentList.add(editStudentData);

			student.studentsAfterEdit(tempStudentList, file);

			mainMenu();

		} else if (studentAction.equals("C")) {
			System.out.println("Enter Student ID number to Remove: ");
			Object id = in.nextLine();
			List<Map<String, Object>> tempStudentList = student.getAllStudents();
			Map<String, Object> editStudentData = new HashMap<String, Object>();
			for (int i = 0; i < tempStudentList.size(); i++) {
				if (tempStudentList.get(i).get("ID").equals(id)) {
					tempStudentList.remove(i);
				}
			}
			student.studentsAfterEdit(tempStudentList, file);

			mainMenu();
		} else {
			mainMenu();
		}
	}

	private void teacherLoad() throws Exception {
		System.out.println(
				"Select Option; A - Add Teacher, B - Edit Teacher, C - Remove Teacher, D - View all Entries: ");
		String teacherAction = in.nextLine();
		String filePath = "C:\\Users\\Sudip\\Desktop\\JavaClass\\data\\teacher.csv";
		File file = new File(filePath);
		if (teacherAction.equals("A")) {
			Map<String, Object> tdetails = new HashMap<>();
			tdetails.put("ID", String.valueOf(tid)); // How to put the entries in order?
			System.out.println("Enter First Name: ");
			String fname = in.nextLine();
			System.out.println("Enter Last Name: ");
			String lname = in.nextLine();
			System.out.println("Enter Phone Number: ");
			String phnumber = in.nextLine();
			tdetails.put("FirstName", fname);
			tdetails.put("LastName", lname);
			tdetails.put("PhoneNumber", phnumber);
			teacher.newTeacher(tdetails, file);
			tid++;
			mainMenu();
		} else if (teacherAction.equals("D")) {
			List<Map<String, Object>> teacherlist = teacher.getAllTeachers();
			System.out.printf("ID \tFirst Name \tLast Name \tPhone Number \n");
			for (int i = 0; i < teacherlist.size(); i++) {
				System.out.println(teacherlist.get(i).get("ID") + "\t" + teacherlist.get(i).get("FirstName") + "\t\t"
						+ teacherlist.get(i).get("LastName") + "\t\t" + teacherlist.get(i).get("PhoneNumber"));
			}
			mainMenu();
		} else if (teacherAction.equals("B")) {

			System.out.println("Enter Teacher ID number to edit: ");
			String id = in.nextLine();
			List<Map<String, Object>> tempteacherlist = teacher.getAllTeachers();

			Map<String, Object> editteacherdata = new HashMap<String, Object>();
			for (int i = 0; i < tempteacherlist.size(); i++) {
				Map<String, Object> teacher = tempteacherlist.get(i);
				String teacherId = (String) teacher.get("ID");
				System.out.println(teacherId);
				if (teacherId.equals(id)) {
					tempteacherlist.remove(i);
					break;
				}
			}
			System.out.println("Enter Name: ");
			String fname = in.nextLine();
			System.out.println("Enter Last Name: ");
			String lname = in.nextLine();
			System.out.println("Enter Phone Number: ");
			String phnumber = in.nextLine();
			editteacherdata.put("ID", id);
			editteacherdata.put("FirstName", fname);
			editteacherdata.put("LastName", lname);
			editteacherdata.put("PhoneNumber", phnumber);
			tempteacherlist.add(editteacherdata);
			teacher.teachersAfterEdit(tempteacherlist, file);
			mainMenu();

		} else if (teacherAction.equals("C")) {
			System.out.println("Enter Teacher ID number to edit: ");
			Object id = in.nextLine();
			List<Map<String, Object>> tempteacherlist = teacher.getAllTeachers();
			Map<String, Object> editteacherdata = new HashMap<String, Object>();
			for (int i = 0; i < tempteacherlist.size(); i++) {
				if (tempteacherlist.get(i).get("ID").equals(id)) {
					tempteacherlist.remove(i);
				}
			}
			teacher.teachersAfterEdit(tempteacherlist, file);
			mainMenu();
		} else {
			mainMenu();
		}
	}

	public void loadStudentCsv() {
		String filePath = "C:\\Users\\Sudip\\Desktop\\JavaClass\\data\\student.csv";
		File file = new File(filePath);
		try {
			BufferedReader br = new BufferedReader(new FileReader(file));
			String line;
			while ((line = br.readLine()) != null) {
				String[] arr = line.split(",");
				Map<String, Object> tempStudent = new HashMap<String, Object>();
				tempStudent.put("ID", arr[0]);
				tempStudent.put("FirstName", arr[1]);
				tempStudent.put("LastName", arr[2]);
				tempStudent.put("PhoneNumber", arr[3]);
				student.updateData(tempStudent);
			}
			sid = student.idNumber();
			br.close();
		} catch (Exception e) {
			if (file.isFile()) {
				System.out.println("File Read Error !");
				e.printStackTrace();
			} else {
				System.out.println("File not Found !");
				e.printStackTrace();
			}
		}
	}

	public void loadLibraryCsv() {
		String filePath = "C:\\Users\\Sudip\\Desktop\\JavaClass\\data\\books.csv";
		File file = new File(filePath);
		try {
			BufferedReader br = new BufferedReader(new FileReader(file));
			String line;
			while ((line = br.readLine()) != null) {
				String[] arr = line.split(",");
				Map<String, Object> tempBooks = new HashMap<String, Object>();
				tempBooks.put("ID", arr[0]);
				tempBooks.put("BookName", arr[1]);
				tempBooks.put("Publisher", arr[2]);
				tempBooks.put("Issued", arr[3]);
				library.updateData(tempBooks);
			}
			bookid = library.idNumber();
			br.close();

		} catch (Exception e) {
			if (file.isFile()) {
				System.out.println("File Read Error !");
				e.printStackTrace();
			} else {
				System.out.println("File not Found !");
				e.printStackTrace();
			}
		}

	}

	public void loadSportCsv() {
		String filePath = "C:\\Users\\Sudip\\Desktop\\JavaClass\\data\\sport.csv";
		File file = new File(filePath);
		try {
			BufferedReader br = new BufferedReader(new FileReader(file));
			String line;
			while ((line = br.readLine()) != null) {
				String[] arr = line.split(",");
				Map<String, Object> tempSport = new HashMap<String, Object>();
				tempSport.put("ID", arr[0]);
				tempSport.put("FirstName", arr[1]);
				tempSport.put("LastName", arr[2]);
				tempSport.put("PhoneNumber", arr[3]);
				sport.updateData(tempSport);
			}
			sportid = sport.idNumber();
			br.close();
		} catch (Exception e) {
			if (file.isFile()) {
				System.out.println("File Read Error !");
				e.printStackTrace();
			} else {
				System.out.println("File not Found !");
				e.printStackTrace();
			}
		}
	}

	public void loadTeachercsv() {
		String filePath = "C:\\Users\\Sudip\\Desktop\\JavaClass\\data\\teacher.csv";
		File file = new File(filePath);

		try {
			BufferedReader br = new BufferedReader(new FileReader(file));
			String line;
			while ((line = br.readLine()) != null) {
				String[] arr = line.split(",");
				Map<String, Object> tempTeacher = new HashMap<String, Object>();
				TeacherPojo teacherpojo = new TeacherPojo();
				teacherpojo.setId(arr[1]);
				
				tempTeacher.put("ID", arr[0]);
				tempTeacher.put("FirstName", arr[1]);
				tempTeacher.put("LastName", arr[2]);
				tempTeacher.put("PhoneNumber", arr[3]);
				teacher.updateData(tempTeacher);
			}
			tid = teacher.idNumber();
			br.close();
		} catch (Exception e) {
			if (file.isFile()) {
				System.out.println("File Read Error !");
				e.printStackTrace();
			} else {
				System.out.println("File not Found !");
				e.printStackTrace();
			}
		}
	}
}
