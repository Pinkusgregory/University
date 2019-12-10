package lab4java;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import javax.swing.JTable;

public class BookTable extends JTable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private BookColumnModel columnModel;
	private BookTableModel bookTableModel = new BookTableModel(null);
	
	public BookTable() {
		setAutoCreateColumnsFromModel(false);
		columnModel = new BookColumnModel(Book.class, bookTableModel.getHeaders());
		setColumnModel(columnModel);
		bookTableModel = new BookTableModel(columnModel);
		setModel(bookTableModel);
	}
	
	public void addRow(Book book) {
		bookTableModel.addRow(book);
	}
	
	public void deleteRow(String authorField) {
		bookTableModel.deleteRow(authorField);
	}
	
	public void write(File file) {
		int ColC = this.getColumnCount();
		int ItemC = this.getRowCount();
		StringBuilder sb;
		FileWriter fw = null;
		try {
			fw = new FileWriter(file);
		}catch (IOException e1) {
			e1.printStackTrace();
		}
		for (int i = 0; i < ItemC; i++) {
			sb = new StringBuilder();
			for (int j = 0; j < ColC; j++) {
				sb.append(this.getValueAt(i,j));
				if (j < ColC - 1) sb.append(',');
				if (j == ColC - 1) sb.append("\r\n");
			}
			try {
				fw.write(sb.toString());
			}catch (IOException e) {
				e.printStackTrace();
			}
			sb = null;
		}
		try {
			fw.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		bookTableModel.fireTableDataChanged();
	}
	
	public void read(File file) throws IOException {
        bookTableModel.read(file);
	}
	
	public void sort() {
		bookTableModel.sort();
	}
}
