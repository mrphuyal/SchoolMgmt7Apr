package interfaceandextend;

import java.util.List;
import java.util.Scanner;

public class MainApplication {
	Scanner in = new Scanner(System.in);
	TeacherService teacherService = new TeacherService();
	StudentService studentService = new StudentService();

	public static void main(String[] args) throws Exception {
		MainApplication mainapp = new MainApplication();
		mainapp.mainMenu();
	}

	private void mainMenu() throws Exception {
		System.out.println("Main Menu!");
		System.out.println("Select option: A - Teacher Management, B - Student Management, C - Library Management, D - Sports Management: ");
		String selectedOption = in.nextLine();
		switch (selectedOption) {
		case "A":
			teacherMenu();
			mainMenu();
			break;
		case "B":
			studentMenu();
			mainMenu();
		default:
			mainMenu();
			break;
		}

	}

	private void studentMenu() throws Exception {
		StudentPojo studentpojo = new StudentPojo();
		List<StudentPojo> tempStudents = studentService.getAll();

		System.out.println(
				"Select Option: A - Add Student, B - Edit Student, C - Remove Student, D - Display all Enries: ");
		String selectedOption = in.nextLine();
		switch (selectedOption) {
		case "A":
			String id = studentService.getNextId();
			System.out.println("Student ID is: " + id);
			System.out.println("Enter First Name: ");
			String firstName = in.nextLine();
			System.out.println("Enter Last Name: ");
			String lastName = in.nextLine();
			System.out.println("Enter Phone Number: ");
			String phNumber = in.nextLine();
			studentpojo.setId(id);
			studentpojo.setFirstName(firstName);
			studentpojo.setLastName(lastName);
			studentpojo.setPhNumber(phNumber);
			studentService.add(studentpojo);
			break;
		case "B":
			System.out.println("Enter Student Id to Update: ");
			String editId = in.nextLine();
			for (int i = 0; i < tempStudents.size(); i++) {
				if (tempStudents.get(i).getId().equals(editId)) {
					tempStudents.remove(i);
				}
			}
			System.out.println("Enter First Name: ");
			studentpojo.setFirstName(in.nextLine());
			System.out.println("Enter Last Name: ");
			studentpojo.setLastName(in.nextLine());
			System.out.println("Enter Phone Number: ");
			studentpojo.setPhNumber(in.nextLine());
			studentpojo.setId(editId);
			tempStudents.add(studentpojo);
			studentService.update(tempStudents);
			System.out.println("Student Id " + editId + " updated sucessfully !");
			break;
		case "C":
			System.out.println("Enter Id to delete: ");
			String deleteId = in.nextLine();
			for (int i = 0; i < tempStudents.size(); i++) {
				if (tempStudents.get(i).getId().equals(deleteId)) {
					tempStudents.remove(i);
					break;
				}
			}
			studentService.update(tempStudents);
			System.out.println("Student Id " + deleteId + " deleted sucessfully !");
			break;
		case "D":
			System.out.println("****************************************");
			System.out.println("\tDisplaying total " + tempStudents.size() + " Entries!");
			System.out.println("****************************************");
			System.out.println("ID\tF Name\tL Name\tPh Number");
			for (int i = 0; i < tempStudents.size(); i++) {
				System.out.println(tempStudents.get(i).getId() + "\t" + tempStudents.get(i).getFirstName() + "\t"
						+ tempStudents.get(i).getLastName() + "\t" + tempStudents.get(i).getPhNumber());
			}
			System.out.println("****************************************");
			break;
		default:
			mainMenu();
			break;
		}
	}

	private void teacherMenu() throws Exception {
		TeacherPojo teacherpojo = new TeacherPojo();
		List<TeacherPojo> tempTeachers = teacherService.getAll();
		System.out.println(
				"Select Option: A - Add Teacher, B - Edit Teacher, C - Remove Teacher, D - Display all Enries: ");
		String selectedOption = in.nextLine();
		switch (selectedOption) {
		case "A":
			String id = teacherService.getNextId();
			System.out.println("Teacher ID is: " + id);
			System.out.println("Enter First Name: ");
			String firstName = in.nextLine();
			System.out.println("Enter Last Name: ");
			String lastName = in.nextLine();
			System.out.println("Enter Phone Number: ");
			String phNumber = in.nextLine();
			teacherpojo.setId(id);
			teacherpojo.setFirstName(firstName);
			teacherpojo.setLastName(lastName);
			teacherpojo.setPhNumber(phNumber);
			teacherService.add(teacherpojo);
			break;
		case "B":
			System.out.println("Enter Teacher Id to Update: ");
			String editId = in.nextLine();
			for (int i = 0; i < tempTeachers.size(); i++) {
				if (tempTeachers.get(i).getId().equals(editId)) {
					tempTeachers.remove(i);
				}
			}
			System.out.println("Enter First Name: ");
			teacherpojo.setFirstName(in.nextLine());
			System.out.println("Enter Last Name: ");
			teacherpojo.setLastName(in.nextLine());
			System.out.println("Enter Phone Number: ");
			teacherpojo.setPhNumber(in.nextLine());
			teacherpojo.setId(editId);
			tempTeachers.add(teacherpojo);
			teacherService.update(tempTeachers);
			System.out.println("Teacher Id " + editId + " updated sucessfully !");
			break;
		case "C":
			System.out.println("Enter Id to delete: ");
			String deleteId = in.nextLine();
			teacherService.delete(deleteId);
//			for (int i = 0; i < tempTeachers.size(); i++) {
//				if (tempTeachers.get(i).getId().equals(deleteId)) {
//					tempTeachers.remove(i);
//					break;
//				}
//			}
//			teacherService.update(tempTeachers);
//			System.out.println("Teacher Id " + deleteId + " deleted sucessfully !");
			break;
		case "D":
			System.out.println("*****************************************");
			System.out.println("*\tDisplaying total " + tempTeachers.size() + " Entries!\t*");
			System.out.println("*****************************************");
			System.out.println("ID\tF Name\tL Name\tPh Number");
			for (int i = 0; i < tempTeachers.size(); i++) {
				System.out.println(tempTeachers.get(i).getId() + "\t" + tempTeachers.get(i).getFirstName() + "\t"
						+ tempTeachers.get(i).getLastName() + "\t" + tempTeachers.get(i).getPhNumber());
			}
			System.out.println("****************************************");
			break;
		default:
			mainMenu();
			break;
		}
	}
}
