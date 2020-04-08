package interfaceandextend;

import java.util.List;

public interface CRUDService {
	void readFromFile(); // reads csv file

	void saveToFile() throws Exception; // saves list to file

	List getAll();

	String getNextId();

	Object getById(String id);

//	void add() throws Exception;

	void delete(String deleteId) throws Exception;

	void update(List tempList) throws Exception;

	void add(Object pojo) throws Exception;


}
