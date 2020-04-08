package interfaceandextend;

import java.util.Scanner;

public class MainApplication {
	Scanner in = new Scanner(System.in);
	TeacherService teacherService = new TeacherService();

	public static void main(String[] args) throws Exception {
		MainApplication mainapp = new MainApplication();
		mainapp.mainMenu();
	}

	private void mainMenu() throws Exception {
		System.out.println("Main Menu!");
		System.out.println("Select option: A - Teacher Management");
		String selectedOption = in.nextLine();
		switch (selectedOption) {
		case "A":
			teacherMenu();
			mainMenu();
			break;

		default:
			break;
		}

	}

	private void teacherMenu() throws Exception {
		System.out.println(
				"Select Option: A - Add Teacher, B - Edit Teacher, C - Remove Teacher, D - Display all Enries: ");
		String selectedOption = in.nextLine();
		switch (selectedOption) {
		case "A":
			TeacherPojo teacherpojo = new TeacherPojo();
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

		default:
			break;
		}
	}
}
