package csv;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Student {
	List<Map<String, Object>> students = new ArrayList<>();

	public void newStudent(Map<String, Object> sdetails, File file) throws IOException {
		BufferedWriter bw = new BufferedWriter(new FileWriter(file));
		this.students.add(sdetails);
//		System.out.println(this.students.size());
		for (int i = 0; i < this.students.size(); i++) {
			Map<String, Object> row = this.students.get(i);
			String value = String.valueOf(row.get("ID")) + "," + String.valueOf(row.get("FirstName")) + ","
					+ String.valueOf(row.get("LastName")) + "," + String.valueOf(row.get("PhoneNumber"));
			System.out.println(value);
			bw.write(value);
			bw.newLine();
		}
		bw.flush();
		bw.close();

	}

	public List<Map<String, Object>> getAllStudents() {
		// TODO Auto-generated method stub
		return this.students;
	}

	public void updateData(Map<String, Object> tempStudent) {
		// TODO Auto-generated method stub
		this.students.add(tempStudent);
	}

	public int idNumber() {
		// TODO Auto-generated method stub
		return this.students.size() + 1;
	}

	public void studentsAfterEdit(List<Map<String, Object>> updatedList, File file) throws Exception {

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
		this.students = updatedList;

	}
}
