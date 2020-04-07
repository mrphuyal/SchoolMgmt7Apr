package csv;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
public class Sport {

	private List<Map<String, Object>> sports = new ArrayList<Map<String, Object>>();

	public void newTeacher(Map<String, Object> sportdetails, File file) throws IOException {
		BufferedWriter bw = new BufferedWriter(new FileWriter(file));
		this.sports.add(sportdetails);
		System.out.println(this.sports.size());
		for (int i = 0; i < this.sports.size(); i++) {
			Map<String, Object> row = this.sports.get(i);
			String value = String.valueOf(row.get("ID")) + "," + String.valueOf(row.get("GameName")) + ","
					+ String.valueOf(row.get("TeamName")) + "," + String.valueOf(row.get("House"));
			System.out.println(value);
			bw.write(value);
			bw.newLine();	
		}
		bw.flush();
		bw.close();
		
	}

	public List<Map<String, Object>> getAllsports() throws IOException {
		return this.sports;
	}

	public void updateData(Map<String, Object> tempSport) {
		this.sports.add(tempSport);

	}
	public int idNumber() {
		return this.sports.size() + 1;
	}
	public void sportsAfterEdit(List<Map<String, Object>> updatedList, File file) throws IOException {
		BufferedWriter bw = new BufferedWriter(new FileWriter(file));
		System.out.println(updatedList.size());
		for (int i = 0; i < updatedList.size(); i++) {
			Map<String, Object> row = updatedList.get(i);
			String value = String.valueOf(row.get("ID")) + "," + String.valueOf(row.get("GameName")) + ","
					+ String.valueOf(row.get("TeamName")) + "," + String.valueOf(row.get("House"));
			System.out.println(value);
			bw.write(value);
			bw.newLine();
		}
		bw.flush();
		bw.close();
		this.sports = updatedList;
	}
}
