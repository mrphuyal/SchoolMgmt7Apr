package csv;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import pojoclass.TeacherPojo;

public class Teacher {
	private List<Map<String, Object>> teachers = new ArrayList<Map<String, Object>>();
//	private List<TeacherPojo> teachers = new ArrayList<TeacherPojo>();
	private int myId;

	public void newTeacher(Map<String, Object> tdetails, File file) throws IOException {
		BufferedWriter bw = new BufferedWriter(new FileWriter(file));
//		if())
		this.teachers.add(tdetails);
		System.out.println(this.teachers.size());
		for (int i = 0; i < this.teachers.size(); i++) {
			Map<String, Object> row = this.teachers.get(i);
			String value = String.valueOf(row.get("ID")) + "," + String.valueOf(row.get("FirstName")) + ","
					+ String.valueOf(row.get("LastName")) + "," + String.valueOf(row.get("PhoneNumber"));
			System.out.println(value);
			bw.write(value);
			bw.newLine();
		}
//		BufferedReader br = new BufferedReader(new FileReader(file));
		bw.flush();
		bw.close();

	}

	public List<Map<String, Object>> getAllTeachers() {
		return this.teachers;
	}

	public void updateData(Map<String, Object> tempTeacher) {
		// TODO Auto-generated method stub
		this.teachers.add(tempTeacher);
		

	}

	public int idNumber() {
		// TODO Auto-generated method stub
		
		for (int i = 0; i < this.teachers.size(); i++) {
			int x = Integer.valueOf((String) this.teachers.get(i).get("ID"));
			if (x >= myId) {
				myId = x;
			}
		}

		return this.myId + 1;
	}

	public void teachersAfterEdit(List<Map<String, Object>> updatedList, File file) throws IOException {
		BufferedWriter bw = new BufferedWriter(new FileWriter(file));
		System.out.println(updatedList.size());
		for (int i = 0; i < updatedList.size(); i++) {
			Map<String, Object> row = updatedList.get(i);
			String value = String.valueOf(row.get("ID")) + "," + String.valueOf(row.get("FirstName")) + ","
					+ String.valueOf(row.get("LastName")) + "," + String.valueOf(row.get("PhoneNumber"));
			System.out.println(value);
			bw.write(value);
			bw.newLine();
		}
		bw.flush();
		bw.close();
		this.teachers = updatedList;
	}

}
