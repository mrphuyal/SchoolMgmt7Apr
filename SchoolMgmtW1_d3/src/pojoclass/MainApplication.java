package pojoclass;

import java.util.List;
import java.util.Scanner;

public class MainApplication {
	int studentId, teacherId, bookId, sportId;
	Teacher teacher = new Teacher();
	Student student = new Student();
	Library library = new Library();
	Sports sports = new Sports();
	TeacherPojo teacherpojo = new TeacherPojo();

	Scanner in = new Scanner(System.in);

	public static void main(String[] args) throws Exception {
		MainApplication mainApp = new MainApplication();
		mainApp.mainMenu();

	}

	public void mainMenu() throws Exception {

		System.out.println(
				"Select option: A - Teacher Management, B - Student Management, C - Library Management, D - Sports Management");
		String selection = in.nextLine();
		switch (selection) {
		case "A":
			teacherMenu();
			break;
		case "B":
			studentMenu();
			break;
		case "C":
			libraryMenu();
		case "D":
			sportsMenu();
		default:
			mainMenu();
			break;
		}
	}

	private void sportsMenu() throws Exception {
		System.out
				.println("Select Option: A - Add Sports, B - Edit Entry, C - Remove Entry, D - Display all Entries: ");
		String selectedAction = in.nextLine();
		switch (selectedAction) {
		case "A":
			SportsPojo sportspojo = new SportsPojo();
			sportId = 10;
//			sports.sportId();															////////////////////
			sportspojo.setId(String.valueOf(sportId));
			System.out.println("Add Sports Menu");
			System.out.println("Enter Sport Name: ");
			sportspojo.setSportName(in.nextLine());
			System.out.println("Enter Player Name: ");
			sportspojo.setPlayerName(in.nextLine());
			sports.addSport(sportspojo);
			mainMenu();
			break;
		case "B":
			SportsPojo sportsPojo = new SportsPojo();
			List<SportsPojo> tempList = sports.getAll();
			System.out.println("Enter Sport ID to Edit: ");
			String editId = in.nextLine();
			for (int i = 0; i < tempList.size(); i++) {
				if (tempList.get(i).getId().equals(editId)) {
					tempList.remove(i);
					sportsPojo.setId(editId);
					System.out.println("Enter Sport Name: ");
					sportsPojo.setSportName(in.nextLine());
					System.out.println("Enter Player Name: ");
					sportsPojo.setPlayerName(in.nextLine());
					tempList.add(sportsPojo);
					sports.updateList(tempList);

					break;
				}

			}
			mainMenu();
			break;
		case "C":
			List<SportsPojo> tempList1 = sports.getAll(); ////
			System.out.println("Enter Sport ID to Edit: ");
			String editId1 = in.nextLine(); ////
			for (int i = 0; i < tempList1.size(); i++) {
				if (tempList1.get(i).getId().equals(editId1)) {
					tempList1.remove(i);
					sports.updateList(tempList1);

					break;
				}

			}
			mainMenu();
			break;
		case "D":
			List<SportsPojo> allPojo = sports.getAll();
			System.out.println("ID\tSportName\tPlayerName");
			for (int i = 0; i < allPojo.size(); i++) {
				System.out.println(allPojo.get(i).getId() + "\t" + allPojo.get(i).getSportName() + "\t\t"
						+ allPojo.get(i).getPlayerName() );
			}
			mainMenu();
			break;
		default:
			mainMenu();
			break;
		}
	}

	private void libraryMenu() throws Exception {
		System.out.println("Select Option: A - Add Book, B - Edit Book, C - Remove Book, D - Display all Entries: ");
		String selectedAction = in.nextLine();
		switch (selectedAction) {
		case "A":
			LibraryPojo librarypojo = new LibraryPojo();
			bookId = library.getId();
			librarypojo.setId(String.valueOf(bookId));
			System.out.println("Add New Book Details Here !!!");
			System.out.println("Enter Book Name: ");
			librarypojo.setBookName(in.nextLine());
			System.out.println("Enter Publisher Name: ");
			librarypojo.setPublisher(in.nextLine());
			System.out.println("Book Issued to: ");
			librarypojo.setIssuedTo(in.nextLine());
			library.addBook(librarypojo);
			mainMenu();
			break;
		case "B":
			LibraryPojo librarypojo1 = new LibraryPojo(); ////////////////////////////
			List<LibraryPojo> tempList = library.getAll();
			System.out.println("Enter Book Id to edit: ");
			String editId = in.nextLine();
			for (int i = 0; i < tempList.size(); i++) {
				if (tempList.get(i).getId().equals(editId)) {
					tempList.remove(i);
					System.out.println("Enter Book Name: ");
					librarypojo1.setBookName(in.nextLine());
					System.out.println("Enter Publisher Name: ");
					librarypojo1.setPublisher(in.nextLine());
					System.out.println("Book Issued to: ");
					librarypojo1.setIssuedTo(in.nextLine());
					librarypojo1.setId(editId);
					tempList.add(librarypojo1);
					library.updateBooks(tempList);
					break;
				}
			}
			mainMenu();
			break;

		case "C":
			System.out.println("Enter Book ID to Remomve: ");
			String deleteId = in.nextLine();
			List<LibraryPojo> tempList1 = library.getAll();
			for (int i = 0; i < tempList1.size(); i++) {
				if (tempList1.get(i).getId().equals(deleteId)) {
					tempList1.remove(i);
				}
			}
			library.updateBooks(tempList1);
			mainMenu();
			break;
		case "D":
			List<LibraryPojo> allPojo = library.getAll();
			System.out.println("ID\tBookName\tPublisher\tIssuedTo");
			for (int i = 0; i < allPojo.size(); i++) {
				System.out.println(allPojo.get(i).getId() + "\t" + allPojo.get(i).getBookName() + "\t\t"
						+ allPojo.get(i).getPublisher() + "\t\t" + allPojo.get(i).getIssuedTo());
			}
			mainMenu();
			break;
		default:
			mainMenu();
			break;
		}
	}

	private void studentMenu() throws Exception {
		System.out.println(
				"Select Option: A - Add Student, B - Edit Student, C - Remove Student, D - Display all Entries: ");
		String selectedAction = in.nextLine();
		switch (selectedAction) {
		case "A":
			StudentPojo studentpojo = new StudentPojo();
			studentId = student.getId();
			studentpojo.setId(String.valueOf(studentId));

			System.out.println("Add New Student Details Here !!!");
			System.out.println("Enter First Name: ");
			studentpojo.setfName(in.nextLine());
			System.out.println("Enter Last Name: ");
			studentpojo.setlName(in.nextLine());
			System.out.println("Enter Phone Number: ");
			studentpojo.setPhNumber(in.nextLine());
			student.addStudent(studentpojo);
			mainMenu();
			break;
		case "B":
			StudentPojo studentpojo1 = new StudentPojo();
			List<StudentPojo> tempList = student.getAll();
			System.out.println("Enter Student Id to edit: ");
			String editId = in.nextLine();
			for (int i = 0; i < tempList.size(); i++) {
				if (tempList.get(i).getId().equals(editId)) {
					tempList.remove(i);

					System.out.println("Enter First Name: ");
					String fName = in.nextLine();
					System.out.println("Enter Last Name: ");
					String lname = in.nextLine();
					System.out.println("Enter Phone Number: ");
					String phnumber = in.nextLine();
					studentpojo1.setId(editId);
					studentpojo1.setfName(fName);
					studentpojo1.setlName(lname);
					studentpojo1.setPhNumber(phnumber);
					tempList.add(studentpojo1);
					student.updateStudents(tempList);
					break;
				}
			}
			mainMenu();
			break;

		case "C":
			System.out.println("Enter Student ID number to edit: ");
			String deleteId = in.nextLine();
			List<StudentPojo> tempList1 = student.getAll();
			for (int i = 0; i < tempList1.size(); i++) {
				if (tempList1.get(i).getId().equals(deleteId)) {
					tempList1.remove(i);
				}
			}
			student.updateStudents(tempList1);
			mainMenu();
			break;
		case "D":
			List<StudentPojo> allPojo = student.getAll();
			System.out.println("ID\tFirstName\tLastName\tPhoneNumber");
			for (int i = 0; i < allPojo.size(); i++) {
				System.out.println(allPojo.get(i).getId() + "\t" + allPojo.get(i).getfName() + "\t\t"
						+ allPojo.get(i).getlName() + "\t\t" + allPojo.get(i).getPhNumber());
			}
			mainMenu();
			break;
		default:
			mainMenu();
			break;
		}

	}

	public void teacherMenu() throws Exception {
		System.out.println(
				"Select Option: A - Add Teacher, B - Edit Teacher, C - Remove Teacher, D - Display all Entries: ");
		String selectedAction = in.nextLine();
		switch (selectedAction) {
		case "A":
			TeacherPojo teacherpojo = new TeacherPojo();
			teacherId = teacher.getId();
			teacherpojo.setId(String.valueOf(teacherId));
			System.out.println("Add New Teacher Details Here !!!");
			System.out.println("Enter First Name: ");
			teacherpojo.setfName(in.nextLine());
			System.out.println("Enter Last Name: ");
			teacherpojo.setlName(in.nextLine());
			System.out.println("Enter Phone Number: ");
			teacherpojo.setPhNumber(in.nextLine());
			teacher.addTeacher(teacherpojo);
			mainMenu();
			break;
		case "B":
			TeacherPojo teacherpojo1 = new TeacherPojo();
			List<TeacherPojo> tempList = teacher.getAll();
			System.out.println("Enter Teacher Id to edit: ");
			String editId = in.nextLine();
			for (int i = 0; i < tempList.size(); i++) {
				if (tempList.get(i).getId().equals(editId)) {
					tempList.remove(i);
					System.out.println("Enter Name: ");
					String fName = in.nextLine();
					System.out.println("Enter Last Name: ");
					String lname = in.nextLine();
					System.out.println("Enter Phone Number: ");
					String phnumber = in.nextLine();
					teacherpojo1.setId(editId);
					teacherpojo1.setfName(fName);
					teacherpojo1.setlName(lname);
					teacherpojo1.setPhNumber(phnumber);
					tempList.add(teacherpojo1);
					teacher.updateTeachers(tempList);
					break;
				}
			}
			mainMenu();
			break;

		case "C":
			System.out.println("Enter Teacher ID number to edit: ");
			String deleteId = in.nextLine();
			List<TeacherPojo> tempList1 = teacher.getAll();
			for (int i = 0; i < tempList1.size(); i++) {
				if (tempList1.get(i).getId().equals(deleteId)) {
					tempList1.remove(i);
				}
			}
			teacher.updateTeachers(tempList1);
			mainMenu();
			break;
		case "D":
			List<TeacherPojo> allPojo = teacher.getAll();
			System.out.println("ID\tFirstName\tLastName\tPhoneNumber");
			for (int i = 0; i < allPojo.size(); i++) {
				System.out.println(allPojo.get(i).getId() + "\t" + allPojo.get(i).getfName() + "\t\t"
						+ allPojo.get(i).getlName() + "\t\t" + allPojo.get(i).getPhNumber());
			}
			mainMenu();
			break;
		default:
			mainMenu();
			break;
		}

	}
}
