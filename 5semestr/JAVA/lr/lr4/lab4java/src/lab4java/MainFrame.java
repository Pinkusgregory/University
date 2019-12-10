package lab4java;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JScrollPane;
import javax.swing.JButton;
import javax.swing.JFileChooser;

import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import javax.swing.JLabel;

public class MainFrame extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textFieldAddAuthor;
	private JTextField textFieldAddYearOfPublishing;
	private JTextField textFieldAddAmounfOfPages;
	private JTextField textFieldAddPublishingHouse;
	private JTextField textFieldDeleteAuthor;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainFrame frame = new MainFrame();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public MainFrame() {
		setTitle("Lab4");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 514, 420);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(0, 0, 498, 211);
		contentPane.add(scrollPane);
		
		BookTable Table = new BookTable();
		scrollPane.setViewportView(Table);

		JButton btnAddButton = new JButton("Add");
		btnAddButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Table.addRow(new Book(textFieldAddAuthor.getText(), Integer.valueOf(textFieldAddYearOfPublishing.getText()), Integer.valueOf((textFieldAddAmounfOfPages.getText())), textFieldAddPublishingHouse.getText()));
				textFieldAddAuthor.setText("");
				textFieldAddYearOfPublishing.setText("");
				textFieldAddAmounfOfPages.setText("");
				textFieldAddPublishingHouse.setText("");
			}
		});
		btnAddButton.setBounds(399, 256, 89, 23);
		contentPane.add(btnAddButton);
		
		JButton btnDeleteButton = new JButton("Delete");
		btnDeleteButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Table.deleteRow(textFieldDeleteAuthor.getText());
				textFieldDeleteAuthor.setText("");
			}
		});
		btnDeleteButton.setBounds(383, 305, 105, 23);
		contentPane.add(btnDeleteButton);
		
		JButton btnSortButton = new JButton("Sort");
		btnSortButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Table.sort();
			}
		});
		btnSortButton.setBounds(399, 222, 89, 23);
		contentPane.add(btnSortButton);
		
		JButton btnAddFileButton = new JButton("Add from file");
		btnAddFileButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JFileChooser fileChooser = new JFileChooser();
	            fileChooser.setCurrentDirectory(new File(System.getProperty("user.dir")));
	            int res = fileChooser.showDialog(MainFrame.this, "Load from file");
	            if(res == JFileChooser.APPROVE_OPTION) {
	                try {
						Table.read(fileChooser.getSelectedFile());
					} catch (IOException e1) {
						e1.printStackTrace();
					}
	            }

			}
		});
		btnAddFileButton.setBounds(10, 345, 186, 23);
		contentPane.add(btnAddFileButton);
		
		JButton btnWriteFileButton = new JButton("Write in file");
		btnWriteFileButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JFileChooser fileChooser = new JFileChooser();
	            fileChooser.setCurrentDirectory(new File(System.getProperty("user.dir")));
	            int res = fileChooser.showDialog(MainFrame.this, "Save to file");
	            if(res == JFileChooser.APPROVE_OPTION) {
	                Table.write(fileChooser.getSelectedFile());
	            }

			}
		});
		btnWriteFileButton.setBounds(268, 345, 186, 23);
		contentPane.add(btnWriteFileButton);
		
		textFieldAddAuthor = new JTextField();
		textFieldAddAuthor.setBounds(0, 257, 86, 20);
		contentPane.add(textFieldAddAuthor);
		textFieldAddAuthor.setColumns(10);
		
		JLabel labelAddAuthor = new JLabel("\u0410\u0432\u0442\u043E\u0440");
		labelAddAuthor.setLabelFor(textFieldAddAuthor);
		labelAddAuthor.setBounds(21, 239, 46, 14);
		contentPane.add(labelAddAuthor);
		
		textFieldAddYearOfPublishing = new JTextField();
		textFieldAddYearOfPublishing.setColumns(10);
		textFieldAddYearOfPublishing.setBounds(96, 257, 86, 20);
		contentPane.add(textFieldAddYearOfPublishing);
		
		JLabel labelAddYearOfPublishing = new JLabel("\u0413\u043E\u0434 \u0438\u0437\u0434\u0430\u043D\u0438\u044F");
		labelAddYearOfPublishing.setLabelFor(textFieldAddYearOfPublishing);
		labelAddYearOfPublishing.setBounds(96, 239, 86, 14);
		contentPane.add(labelAddYearOfPublishing);
		
		textFieldAddAmounfOfPages = new JTextField();
		textFieldAddAmounfOfPages.setColumns(10);
		textFieldAddAmounfOfPages.setBounds(192, 257, 101, 20);
		contentPane.add(textFieldAddAmounfOfPages);
		
		JLabel labelAddAmounfOfPages = new JLabel("\u041A\u043E\u043B-\u0432\u043E \u0441\u0442\u0440\u0430\u043D\u0438\u0446");
		labelAddAmounfOfPages.setLabelFor(textFieldAddAmounfOfPages);
		labelAddAmounfOfPages.setBounds(192, 239, 101, 14);
		contentPane.add(labelAddAmounfOfPages);
		
		textFieldAddPublishingHouse = new JTextField();
		textFieldAddPublishingHouse.setColumns(10);
		textFieldAddPublishingHouse.setBounds(303, 257, 86, 20);
		contentPane.add(textFieldAddPublishingHouse);
		
		JLabel labelAddPublishingHouse = new JLabel("\u0418\u0437\u0434\u0430\u0442\u0435\u043B\u044C\u0441\u0442\u0432\u043E");
		labelAddPublishingHouse.setLabelFor(textFieldAddPublishingHouse);
		labelAddPublishingHouse.setBounds(303, 239, 86, 14);
		contentPane.add(labelAddPublishingHouse);
		
		textFieldDeleteAuthor = new JTextField();
		textFieldDeleteAuthor.setColumns(10);
		textFieldDeleteAuthor.setBounds(202, 308, 138, 20);
		contentPane.add(textFieldDeleteAuthor);
		
		JLabel labelDeleteAuthor = new JLabel("\u0410\u0432\u0442\u043E\u0440");
		labelDeleteAuthor.setLabelFor(textFieldDeleteAuthor);
		labelDeleteAuthor.setBounds(223, 290, 117, 14);
		contentPane.add(labelDeleteAuthor);
	}
}
