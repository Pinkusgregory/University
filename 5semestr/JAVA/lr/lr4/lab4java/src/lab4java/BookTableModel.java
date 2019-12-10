package lab4java;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Collections;
import java.util.LinkedList;

import javax.swing.table.AbstractTableModel;

public class BookTableModel extends AbstractTableModel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private final String[] headers = { "Author", "Year of publishing", "Amount of pages", "Publishing house" };
	@SuppressWarnings("unused")
	private BookColumnModel columnModel;
	private LinkedList<Book> books = new LinkedList<Book>();

	public BookTableModel(BookColumnModel columnModel) {
		this.columnModel = columnModel;
	}

	public String[] getHeaders() {
		return headers;
	}

	@Override
	public int getColumnCount() {
		return headers.length;
	}

	@Override
	public Class<?> getColumnClass(int columnIndex) {
		switch (columnIndex) {
		case 0:
			return String.class;
		case 1:
			return Integer.class;
		case 2:
			return Integer.class;
		case 3:
			return String.class;
		}
		return null;
	}

	@Override
	public String getColumnName(int columnIndex) {
		return headers[columnIndex];
	}

	@Override
	public int getRowCount() {
		return books.size();
	}

	@Override
	public boolean isCellEditable(int rowIndex, int columnIndex) {
		return super.isCellEditable(rowIndex, columnIndex);
	}

	@Override
	public Object getValueAt(int i, int j) {
		if (i >= books.size()) {
			return null;
		}
		Book book = books.get(i);
		switch (j) {
		case 0:
			return book.getAuthor();
		case 1:
			return book.getYearOfPublishing();
		case 2:
			return book.getAmountOfPages();
		case 3:
			return book.getPublishingHouse();
		}
		return null;
	}

	@Override
	public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
		Book book = books.get(rowIndex);
		switch (columnIndex) {
		case 0:
			book.setAuthor(String.valueOf(aValue));
			break;
		case 1:
			book.setYearOfPublishing(Integer.valueOf(String.valueOf(aValue)));
			break;
		case 2:
			book.setAmountOfPages(Integer.valueOf(String.valueOf(aValue)));
			break;
		case 3:
			book.setPublishingHouse(String.valueOf(aValue));
			break;
		}

	}

	public void addRow(Book book) {
		books.add(book);
		fireTableDataChanged();
		fireTableStructureChanged();
	}

	public void deleteRow(String authorField) {
		for (int i = 0; i < books.size(); i++) {
			if (books.get(i).author.equals(authorField)) {
				books.remove(books.get(i));
				fireTableDataChanged();
				fireTableStructureChanged();
			}
		}
	}

	@SuppressWarnings("resource")
	public void read(File file) throws IOException {
		BufferedReader br = new BufferedReader(new FileReader(file));
		{
			String line = br.readLine();
			String[] temp = line.split(",");
			books.add(new Book(temp[0], Integer.parseInt(temp[1]), Integer.parseInt(temp[2]), temp[3]));

			while ((line = br.readLine()) != null) {
				temp = line.split(",");
				books.add(new Book(temp[0], Integer.parseInt(temp[1]), Integer.parseInt(temp[2]), temp[3]));
			}
		}
		fireTableDataChanged();
		fireTableStructureChanged();
	}

	public void sort() {
		Collections.sort(books, new BookComparator());
		fireTableDataChanged();
		fireTableStructureChanged();
	}

}
