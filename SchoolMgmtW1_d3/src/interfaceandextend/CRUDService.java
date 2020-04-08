package interfaceandextend;

import java.util.List;

public interface CRUDService {
	void readFromFile(); // reads csv file

	void saveToFile() throws Exception; // saves list to file

	List getAll();

//	void getById();

	void update();

	void delete();

	void add();

	String getNextId();

	TeacherPojo getById(String id);

	void add(TeacherPojo newTeacher) throws Exception;

	void delete(String deleteId);

}
