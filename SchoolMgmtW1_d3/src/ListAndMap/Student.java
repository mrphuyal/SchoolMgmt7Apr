package ListAndMap;

import java.util.List;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Student {

	private List<Map<String, Object>> students = new ArrayList<Map<String, Object>>();

	public void newStudent(Map<String, Object> sdetails) {
		this.students.add(sdetails);
		
	}
	

}
