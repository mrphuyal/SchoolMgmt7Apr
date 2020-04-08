package interfaceandextend;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.List;

public class StudentService implements CRUDService {
	private List<StudentPojo> allStudents = new ArrayList<>();
	String studentLocation = "C:\\Users\\Sudip\\Desktop\\JavaClass\\data\\student.csv";

	public StudentService() {
		readFromFile();
	}

	@Override
	public void readFromFile() {
		try {
			BufferedReader br = new BufferedReader(new FileReader(studentLocation));
			String line;
			while ((line = br.readLine()) != null) {
				StudentPojo studentpojo = new StudentPojo();
				String[] arr = line.split(",");
				studentpojo.setId(arr[0]);
				studentpojo.setFirstName(arr[1]);
				studentpojo.setLastName(arr[2]);
				studentpojo.setPhNumber(arr[3]);
				this.allStudents.add(studentpojo);
			}
			br.close();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	@Override
	public void saveToFile() throws Exception {
		BufferedWriter bw = new BufferedWriter(new FileWriter(studentLocation));
		for (int i = 0; i < this.allStudents.size(); i++) {
			String valueToWrite = this.allStudents.get(i).getId() + "," + this.allStudents.get(i).getFirstName() + ","
					+ this.allStudents.get(i).getLastName() + "," + this.allStudents.get(i).getPhNumber();
			bw.write(valueToWrite);
			bw.newLine();
		}
		bw.flush();
		bw.close();
	}

	@Override
	public List getAll() {
		// TODO Auto-generated method stub
		return this.allStudents;
	}

	@Override
	public String getNextId() {
		int id = 0;
		for (int i = 0; i < this.allStudents.size(); i++) {
			int x= Integer.valueOf(this.allStudents.get(i).getId());
			if(x>=id) {
				id=x+1;
			}
			
		}
		return String.valueOf(id);
		
	}

	@Override
	public StudentPojo getById(String id) {
		for (int i = 0; i < this.allStudents.size(); i++) {
			if (this.allStudents.get(i).equals(id)) {
				return this.allStudents.get(i);
			}
		}
		return null;
	}

	@Override
	public void delete(String deleteId) throws Exception {
		// TODO Auto-generated method stub
		for (int i = 0; i < allStudents.size(); i++) {
			if (allStudents.get(i).getId().equals(deleteId)) {
				allStudents.remove(i);
				break;
			}
		}
		System.out.println("Student Id " + deleteId + " deleted sucessfully ! from Student service");
		saveToFile();
	}

	@Override
	public void update(List tempList) throws Exception {
		// TODO Auto-generated method stub
		this.allStudents = tempList;
		saveToFile();

	}

	public void add(StudentPojo studentpojo) throws Exception {
		this.allStudents.add(studentpojo);
		saveToFile();

	}

	@Override
	public void add(Object pojo) throws Exception {
		// TODO Auto-generated method stub
		
	}

}
