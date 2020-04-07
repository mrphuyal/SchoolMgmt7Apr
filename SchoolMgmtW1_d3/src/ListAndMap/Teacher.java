package ListAndMap;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Teacher {
	private List<Map<String, Object>> teachers = new ArrayList<Map<String, Object>>();

	public void newTeacher(Map<String, Object> info) {
		this.teachers.add(info);
	}

	public List<Map<String, Object>> getAllTeachers() {
		return this.teachers;
	}

	public void deleteTeacher(Object id) {
		Boolean flag = false;
		for (int i = 0; i < this.teachers.size(); i++) {
			Map<String, Object> teacher = this.teachers.get(i);
			Object teacher_id = teacher.get("ID");
//			System.out.println(teacher_id);
//			System.out.println(id);
			if (teacher_id.equals(id)) { // Problem is here
				this.teachers.remove(teacher);
				System.out.println("Removed! ");
				flag = true;
				break;
			}
		}
		if (!flag) {
			System.out.println("Teacher id " + id + " does not exist!");
		}
	}

	public void editTeacher(Map<String, Object> editedteacher) {
	this.teachers.add(editedteacher);
	}

}
