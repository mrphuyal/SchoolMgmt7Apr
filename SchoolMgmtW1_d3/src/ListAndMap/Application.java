package ListAndMap;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class Application {

	Scanner in = new Scanner(System.in);
	Teacher teacher = new Teacher();
	Student student = new Student();
	int tid = 1;
	int sid = 1;

	public static void main(String[] args) {

		Application menu = new Application();
		menu.mainMenu();
	}

	public void mainMenu() {
		System.out.println("Please select the appropriate Option: ");
		System.out.println(
				"A - Teacher Management, B - Student Management, C - Library Management, D - Sports Management");
		String selectedOption = in.nextLine();
		if (selectedOption.equals("A")) {
			teacherLoad();
		} else if (selectedOption.equals("B")) {
			studentLoad();
		} else {
		}
		mainMenu();
	}

	public void studentLoad() {
		System.out.println(
				"Select Option; A - Add Student, B - Edit Student, C - Remove Student, D - View all Entries: ");
		String studentAction = in.nextLine();
		switch (studentAction) {
		case "A":
			Map<String, Object> sdetails = new HashMap<>();
			sdetails.put("ID", sid);
			System.out.println("Enter First Name: ");
			String fname = in.nextLine();
			System.out.println("Enter Last Name: ");
			String lname = in.nextLine();
			System.out.println("Enter Phone Number: ");
			String phoneNumber = in.nextLine();
			sdetails.put("First Name", fname);
			sdetails.put("Last Name", lname);
			sdetails.put("Phone Number", phoneNumber);
			student.newStudent(sdetails);
			sid++;
			break;
		case "B":
			System.out.println("Enter ID to edit details: ");
			String editid = in.nextLine();

			mainMenu();
			break;
		case "C":

			mainMenu();
			break;
		default:
			mainMenu();
			break;
		}
	}

	public void teacherLoad() {
		System.out.println(
				"Select Option; A - Add Teacher, B - Edit Teacher, C - Remove Teacher, D - View all Entries: ");
		String teacherAction = in.nextLine();
		if (teacherAction.equals("A")) {
			Map<String, Object> tdetails = new HashMap<>();
			tdetails.put("ID", tid); // How to put the entries in order?
			System.out.println("Enter First Name: ");
			String fname = in.nextLine();
			System.out.println("Enter Last Name: ");
			String lname = in.nextLine();
			System.out.println("Enter Phone Number: ");
			String phnumber = in.nextLine();
			tdetails.put("First Name", fname);
			tdetails.put("Last Name", lname);
			tdetails.put("Phone Number", phnumber);
			teacher.newTeacher(tdetails);
			tid++;
			mainMenu();

		} else if (teacherAction.equals("D")) {
//			java.util.List<Map<String, String>> allTeachers = teacher.getAllTeachers();			//why not List<Map<String, Object>> Here?
			List<Map<String, Object>> teacherlist = teacher.getAllTeachers();
			System.out.printf("ID \tFirst Name \tLast Name \tPhone Number \n");
			for (int i = 0; i < teacherlist.size(); i++) {

				System.out.println(teacherlist.get(i).get("ID") + "\t" + teacherlist.get(i).get("First Name") + "\t\t"
						+ teacherlist.get(i).get("Last Name") + "\t\t" + teacherlist.get(i).get("Phone Number"));

			}

			mainMenu();
		} else if (teacherAction.equals("B")) {
			List<Map<String, Object>> updateTeacher = new ArrayList<>();
			Map<String, Object> editedteacher = new HashMap<>();
			System.out.println("Enter Teacher Id to Edit: ");
			String editid = in.nextLine();
			System.out.println("getAllTeachers.size is " + teacher.getAllTeachers().size());

//			int index = teacher.getAllTeachers().indexOf(editid);
			
//			System.out.println("Index " + index);
			for (int i = 0; i <teacher.getAllTeachers().size() ; i++) {
				if (teacher.getAllTeachers().get(i).get("ID") == Integer.valueOf(editid)) {		
	
					System.out.println("Enter First Name: ");
					String fname = in.nextLine();
					System.out.println("Enter Last Name: ");
					String lname = in.nextLine();
					System.out.println("Enter Phone Number: ");
					String phonenumber = in.nextLine();
					teacher.getAllTeachers().remove(teacher.getAllTeachers().get(i));
					editedteacher.put("ID", editid);
					editedteacher.put("First Name", fname);
					editedteacher.put("Last Name", lname);
					editedteacher.put("Phone Number", phonenumber);
					
					teacher.editTeacher(editedteacher);

					System.out.println("Edit action here! ");
					mainMenu();
					}
		}
		} else if (teacherAction.equals("C")) {
			System.out.println("Enter id to delete: ");
			Object del_id = in.nextLine();
			teacher.deleteTeacher(del_id);
			mainMenu();

		} else {
			mainMenu();
		}
			}
}

			
			
