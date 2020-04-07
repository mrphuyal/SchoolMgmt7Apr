package pojoclass;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Student {

	private List<StudentPojo> allStudents = new ArrayList<StudentPojo>();
	private int studentId;
	Scanner in = new Scanner(System.in);
	String studentLocation = "C:\\Users\\Sudip\\Desktop\\JavaClass\\data\\student.csv";

	public Student() {													
		readFromFile(studentLocation);
	}

	public void addStudent(StudentPojo studentpojo) throws Exception {
		this.allStudents.add(studentpojo);
		writeToFile(allStudents);
	}

	public void updateStudents(List<StudentPojo> updatedstudents) throws Exception {
		writeToFile(updatedstudents);
		this.allStudents = updatedstudents;
	}

	public List<StudentPojo> getAll() {
		return this.allStudents;
	}

	public int getId() {
		for (int i = 0; i < this.allStudents.size(); i++) {
			int x = Integer.valueOf(this.allStudents.get(i).getId());
			if (x >= studentId) {
				studentId = x + 1;
			}
		}
		return studentId;
	}

	public void writeToFile(List<StudentPojo> updatedstudents) throws Exception {
		BufferedWriter bw = new BufferedWriter(new FileWriter(studentLocation));
		for (int i = 0; i < updatedstudents.size(); i++) {
			String valueToWrite = updatedstudents.get(i).getId() + "," + updatedstudents.get(i).getfName() + ","
					+ updatedstudents.get(i).getlName() + "," + updatedstudents.get(i).getPhNumber();
			bw.write(valueToWrite);
			bw.newLine();
		}
		bw.flush();
		bw.close();
	}

	public void readFromFile(String StudentLocation) {
		try {
			BufferedReader br = new BufferedReader(new FileReader(studentLocation));
			String line;
			while ((line = br.readLine()) != null) {
				StudentPojo studentpojo= new StudentPojo();
				String[] arr = line.split(",");
				studentpojo.setId(arr[0]);
				studentpojo.setfName(arr[1]);
				studentpojo.setlName(arr[2]);
				studentpojo.setPhNumber(arr[3]);
				this.allStudents.add(studentpojo);

			}
			br.close();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
