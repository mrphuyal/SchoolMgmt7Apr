package interfaceandextend;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.List;

public class TeacherService implements CRUDService {
	private List<TeacherPojo> allTeachers = new ArrayList<TeacherPojo>();
	String teacherLocation = "C:\\Users\\Sudip\\Desktop\\JavaClass\\data\\teacher.csv";

	public TeacherService() {
		readFromFile();
	}

	@Override
	public void readFromFile() {
		try {
			BufferedReader br = new BufferedReader(new FileReader(teacherLocation));
			String line;
			while ((line = br.readLine()) != null) {
				TeacherPojo teacherpojo = new TeacherPojo();
				String[] arr = line.split(",");
				teacherpojo.setId(arr[0]);
				teacherpojo.setFirstName(arr[1]);
				teacherpojo.setLastName(arr[2]);
				teacherpojo.setPhNumber(arr[3]);
				this.allTeachers.add(teacherpojo);
			}
			br.close();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	@Override
	public void saveToFile() throws Exception {
		// TODO Auto-generated method stub
		BufferedWriter bw = new BufferedWriter(new FileWriter(teacherLocation));
		for (int i = 0; i < this.allTeachers.size(); i++) {
			String valueToWrite = this.allTeachers.get(i).getId() + "," + this.allTeachers.get(i).getFirstName() + ","
					+ this.allTeachers.get(i).getLastName() + "," + this.allTeachers.get(i).getPhNumber();
			bw.write(valueToWrite);
			bw.newLine();
		}
		bw.flush();
		bw.close();
	}

	@Override
	public List<TeacherPojo> getAll() {
		return this.allTeachers;
	}

	@Override
	public TeacherPojo getById(String id) { // something missing
		for (int i = 0; i < this.allTeachers.size(); i++) {
			if (this.allTeachers.get(i).equals(id)) {
				return this.allTeachers.get(i);
			}
		}
		return null;
	}


	@Override
	public void delete(String deleteId) throws Exception {
		for (int i = 0; i < allTeachers.size(); i++) {
			if (allTeachers.get(i).getId().equals(deleteId)) {
				allTeachers.remove(i);
				break;
			}
		}
//		update(tempStudents);
		System.out.println("Teacher Id " + deleteId + " deleted sucessfully ! from teacher service");
		saveToFile();
	}

	public void add(TeacherPojo newTeacher) throws Exception {
	this.allTeachers.add(newTeacher);
		saveToFile();
	}

	@Override
	public String getNextId() {
		int tempId = 0;
		for (int i = 0; i < this.allTeachers.size(); i++) {
			int x = Integer.valueOf(this.allTeachers.get(i).getId());
			if (x >= tempId) {
				tempId = x + 1;
			}
		}
		return String.valueOf(tempId);
	}


	@Override
	public void update(List tempList) throws Exception {
		this.allTeachers = tempList;
		saveToFile();
		
	}

	@Override
	public void add(Object pojo) throws Exception {
		// TODO Auto-generated method stub
		
	}


}
