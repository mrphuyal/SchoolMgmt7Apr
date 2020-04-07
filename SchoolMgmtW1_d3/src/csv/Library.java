package csv;

import java.util.List;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Map;

public class Library {

	List<Map<String, Object>> books = new ArrayList<>();

	public void updateData(Map<String, Object> tempBooks) {
		this.books.add(tempBooks);
	}

	public int idNumber() {
		return this.books.size() + 1;
	}

	public void newBook(Map<String, Object> bookdetails, File file) throws Exception {
		BufferedWriter bw = new BufferedWriter(new FileWriter(file));
		this.books.add(bookdetails);
//		System.out.println(this.books.size());
		for (int i = 0; i < this.books.size(); i++) {
			Map<String, Object> row = this.books.get(i);
			String value = String.valueOf(row.get("ID")) + "," + String.valueOf(row.get("Title")) + ","
					+ String.valueOf(row.get("Publisher")) + "," + String.valueOf(row.get("IssuedTo"));
			System.out.println(value);
			bw.write(value);
			bw.newLine();
		}
		bw.flush();
		bw.close();
	}

	public List<Map<String, Object>> getAllBooks() {
		return this.books;
	}

	public void booksAfterEdit(List<Map<String, Object>> tempBookList, File file) throws Exception {
		BufferedWriter bw = new BufferedWriter(new FileWriter(file));
//		System.out.println(tempBookList.size());

		for (int i = 0; i < tempBookList.size(); i++) {
			Map<String, Object> row = tempBookList.get(i);
			String value = String.valueOf(row.get("ID")) + "," + String.valueOf(row.get("Title")) + ","
					+ String.valueOf(row.get("Publisher")) + "," + String.valueOf(row.get("IssuedTo"));
			System.out.println(value);
			bw.write(value);
			bw.newLine();
		}
		bw.flush();
		bw.close();
		this.books = tempBookList;

	}

}
