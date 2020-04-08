package pojoclass;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.List;
//import java.util.Scanner;

public class Teacher {
	private List<TeacherPojo> allTeachers = new ArrayList<TeacherPojo>();
	private int teacherId;
//	Scanner in = new Scanner(System.in);
	String teacherLocation = "C:\\Users\\Sudip\\Desktop\\JavaClass\\data\\teacher.csv";

	public Teacher() {
		readFromFile(teacherLocation);
	}

	public void addTeacher(TeacherPojo teacherpojo) throws Exception {
		this.allTeachers.add(teacherpojo);
		writeToFile(allTeachers);
	}

	public void updateTeachers(List<TeacherPojo> updatedteachers) throws Exception {
		writeToFile(updatedteachers);
		this.allTeachers = updatedteachers;
	}

	public List<TeacherPojo> getAll() {
		return this.allTeachers;
	}

	public int getId() {
		for (int i = 0; i < this.allTeachers.size(); i++) {
			int x = Integer.valueOf(this.allTeachers.get(i).getId());
			if (x >= teacherId) {
				teacherId = x + 1;
			}
		}
		return teacherId;
	}

	public void writeToFile(List<TeacherPojo> updatedteachers) throws Exception {
		BufferedWriter bw = new BufferedWriter(new FileWriter(teacherLocation));
		for (int i = 0; i < updatedteachers.size(); i++) {
			String valueToWrite = updatedteachers.get(i).getId() + "," + updatedteachers.get(i).getfName() + ","
					+ updatedteachers.get(i).getlName() + "," + updatedteachers.get(i).getPhNumber();
			bw.write(valueToWrite);
			bw.newLine();
		}
		bw.flush();
		bw.close();
	}

	public void readFromFile(String teacherLocation) {
//		String filePath = "C:\\Users\\Sudip\\Desktop\\JavaClass\\data\\teacher.csv";
		try {
			BufferedReader br = new BufferedReader(new FileReader(teacherLocation));
			String line;
			while ((line = br.readLine()) != null) {
				TeacherPojo teacherpojo = new TeacherPojo();
				String[] arr = line.split(",");
				teacherpojo.setId(arr[0]);
				teacherpojo.setfName(arr[1]);
				teacherpojo.setlName(arr[2]);
				teacherpojo.setPhNumber(arr[3]);
				this.allTeachers.add(teacherpojo);

//				System.out.println(this.allTeachers.size());
			}
			br.close();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
