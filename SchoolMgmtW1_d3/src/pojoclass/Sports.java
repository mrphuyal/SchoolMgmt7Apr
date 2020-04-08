package pojoclass;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.List;

public class Sports {
	private List<SportsPojo> allSports = new ArrayList<>();
	private int sportId;
	String sportLocation = "C:\\Users\\Sudip\\Desktop\\JavaClass\\data\\sport.csv";

	public Sports() {
		readFromFile(sportLocation);
	}

	private void readFromFile(String sportLocation) {
		try {
			BufferedReader br = new BufferedReader(new FileReader(sportLocation));
			String line;
			while ((line = br.readLine()) != null) {
				SportsPojo sportspojo = new SportsPojo();
				String[] arr = line.split(",");
				sportspojo.setId(arr[0]);
				sportspojo.setSportName(arr[1]);
				sportspojo.setPlayerName(arr[2]);
				this.allSports.add(sportspojo);
			}
			br.close();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public void addSport(SportsPojo sportspojo) throws Exception {
		this.allSports.add(sportspojo);
		writeToFile(allSports);
	}

	public void writeToFile(List<SportsPojo> updatedSports) throws Exception {
		BufferedWriter bw = new BufferedWriter(new FileWriter(sportLocation));
		for (int i = 0; i < updatedSports.size(); i++) {
			String valueToWrite = updatedSports.get(i).getId() + "," + updatedSports.get(i).getSportName() + ","
					+ updatedSports.get(i).getPlayerName();
			bw.write(valueToWrite);
			bw.newLine();
		}
		bw.flush();
		bw.close();
	}

	public List<SportsPojo> getAll() {
		return this.allSports;
	}

	public void updateList(List<SportsPojo> tempList) throws Exception {
		this.allSports = tempList;
		writeToFile(this.allSports);
	}

	public int sportId() {
		for (int i = 0; i < allSports.size(); i++) {
			int x = Integer.valueOf(this.allSports.get(i).getId());
			if(x>=sportId) {
				sportId=x+1;
				
			}
		}
		return sportId;
	}

	
}
