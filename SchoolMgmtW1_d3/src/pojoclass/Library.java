package pojoclass;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Library {
	private List<LibraryPojo> allBooks= new ArrayList<LibraryPojo>();
	private int bookId;
	Scanner in = new Scanner(System.in);
	String libraryLocation = "C:\\Users\\Sudip\\Desktop\\JavaClass\\data\\books.csv";

	public Library() {													
		readFromFile(libraryLocation);
	}

	public void addBook(LibraryPojo librarypojo) throws Exception {
		this.allBooks.add(librarypojo);
		writeToFile(allBooks);
	}

	public void updateBooks(List<LibraryPojo> updatedBooks) throws Exception {
		writeToFile(updatedBooks);
		this.allBooks= updatedBooks;
	}

	public List<LibraryPojo> getAll() {
		return this.allBooks;
	}

	public int getId() {
		for (int i = 0; i < this.allBooks.size(); i++) {
			int x = Integer.valueOf(this.allBooks.get(i).getId());
			if (x >= bookId) {
				bookId = x + 1;
			}
		}
		return bookId;
	}

	public void writeToFile(List<LibraryPojo> updatedbooks) throws Exception {
		BufferedWriter bw = new BufferedWriter(new FileWriter(libraryLocation));
		for (int i = 0; i < updatedbooks.size(); i++) {
			String valueToWrite = updatedbooks.get(i).getId() + "," + updatedbooks.get(i).getBookName() + ","
					+ updatedbooks.get(i).getPublisher() + "," + updatedbooks.get(i).getIssuedTo();
			bw.write(valueToWrite);
			bw.newLine();
		}
		bw.flush();
		bw.close();
	}

	public void readFromFile(String libraryLocation) {
		try {
			BufferedReader br = new BufferedReader(new FileReader(libraryLocation));
			String line;
			while ((line = br.readLine()) != null) {
				LibraryPojo librarypojo = new LibraryPojo();
				String[] arr = line.split(",");
				librarypojo.setId(arr[0]);
				librarypojo.setBookName(arr[1]);
				librarypojo.setPublisher(arr[2]);
				librarypojo.setIssuedTo(arr[3]);
				this.allBooks.add(librarypojo);

			}
			br.close();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}


}
