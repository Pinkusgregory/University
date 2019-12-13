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
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

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
	private JTextField textFieldChangeAuthor;
	private JTextField textFieldChangeYearOfPublishing;
	private JTextField textFieldChangeAmountOfPages;
	private JTextField textFieldChangePublishingHouse;
	private int rowNumber;

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
		setBounds(100, 100, 565, 420);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(0, 0, 549, 157);
		contentPane.add(scrollPane);
		
		BookTable Table = new BookTable();
		Table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if (e.getClickCount() == 2) {
					int row = Table.rowAtPoint(e.getPoint());
					if (row > -1) {
						int realRow = Table.convertRowIndexToModel(row);
						textFieldChangeAuthor.setText(Table.getValueAt(realRow, 0).toString());
						textFieldChangeYearOfPublishing.setText(Table.getValueAt(realRow, 1).toString());
						textFieldChangeAmountOfPages.setText(Table.getValueAt(realRow, 2).toString());
						textFieldChangePublishingHouse.setText(Table.getValueAt(realRow, 3).toString());
						rowNumber = realRow;
					}
				}
			}
		});
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
		btnAddButton.setBounds(450, 256, 89, 23);
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
		btnSortButton.setBounds(450, 219, 89, 23);
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
		
		JLabel labelAddAuthor = new JLabel("Author");
		labelAddAuthor.setLabelFor(textFieldAddAuthor);
		labelAddAuthor.setBounds(21, 239, 46, 14);
		contentPane.add(labelAddAuthor);
		
		textFieldAddYearOfPublishing = new JTextField();
		textFieldAddYearOfPublishing.setColumns(10);
		textFieldAddYearOfPublishing.setBounds(96, 257, 115, 20);
		contentPane.add(textFieldAddYearOfPublishing);
		
		JLabel labelAddYearOfPublishing = new JLabel("Year of publishing");
		labelAddYearOfPublishing.setLabelFor(textFieldAddYearOfPublishing);
		labelAddYearOfPublishing.setBounds(96, 239, 115, 14);
		contentPane.add(labelAddYearOfPublishing);
		
		textFieldAddAmounfOfPages = new JTextField();
		textFieldAddAmounfOfPages.setColumns(10);
		textFieldAddAmounfOfPages.setBounds(221, 259, 101, 20);
		contentPane.add(textFieldAddAmounfOfPages);
		
		JLabel labelAddAmounfOfPages = new JLabel("Amount of pages");
		labelAddAmounfOfPages.setLabelFor(textFieldAddAmounfOfPages);
		labelAddAmounfOfPages.setBounds(221, 241, 101, 14);
		contentPane.add(labelAddAmounfOfPages);
		
		textFieldAddPublishingHouse = new JTextField();
		textFieldAddPublishingHouse.setColumns(10);
		textFieldAddPublishingHouse.setBounds(332, 259, 111, 20);
		contentPane.add(textFieldAddPublishingHouse);
		
		JLabel labelAddPublishingHouse = new JLabel("Publishing house");
		labelAddPublishingHouse.setLabelFor(textFieldAddPublishingHouse);
		labelAddPublishingHouse.setBounds(332, 241, 111, 14);
		contentPane.add(labelAddPublishingHouse);
		
		textFieldDeleteAuthor = new JTextField();
		textFieldDeleteAuthor.setColumns(10);
		textFieldDeleteAuthor.setBounds(202, 308, 138, 20);
		contentPane.add(textFieldDeleteAuthor);
		
		JLabel labelDeleteAuthor = new JLabel("Author");
		labelDeleteAuthor.setLabelFor(textFieldDeleteAuthor);
		labelDeleteAuthor.setBounds(223, 290, 117, 14);
		contentPane.add(labelDeleteAuthor);
		
		textFieldChangeAuthor = new JTextField();
		textFieldChangeAuthor.setColumns(10);
		textFieldChangeAuthor.setBounds(0, 186, 86, 20);
		contentPane.add(textFieldChangeAuthor);
		
		JLabel labelChangeAuthor = new JLabel("Author");
		labelChangeAuthor.setBounds(21, 168, 46, 14);
		contentPane.add(labelChangeAuthor);
		
		textFieldChangeYearOfPublishing = new JTextField();
		textFieldChangeYearOfPublishing.setColumns(10);
		textFieldChangeYearOfPublishing.setBounds(96, 186, 115, 20);
		contentPane.add(textFieldChangeYearOfPublishing);
		
		JLabel labelChangeYearOfPublishing = new JLabel("Year of publishing");
		labelChangeYearOfPublishing.setBounds(96, 168, 115, 14);
		contentPane.add(labelChangeYearOfPublishing);
		
		textFieldChangeAmountOfPages = new JTextField();
		textFieldChangeAmountOfPages.setColumns(10);
		textFieldChangeAmountOfPages.setBounds(221, 188, 101, 20);
		contentPane.add(textFieldChangeAmountOfPages);
		
		JLabel labelChangeAmountOfPages = new JLabel("Amount of pages");
		labelChangeAmountOfPages.setBounds(221, 170, 101, 14);
		contentPane.add(labelChangeAmountOfPages);
		
		textFieldChangePublishingHouse = new JTextField();
		textFieldChangePublishingHouse.setColumns(10);
		textFieldChangePublishingHouse.setBounds(332, 188, 111, 20);
		contentPane.add(textFieldChangePublishingHouse);
		
		JLabel labelChangePublishingHouse = new JLabel("Publishing house");
		labelChangePublishingHouse.setBounds(332, 170, 111, 14);
		contentPane.add(labelChangePublishingHouse);
		
		JButton btnChange = new JButton("Change");
		btnChange.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Table.setRow(new Book(textFieldChangeAuthor.getText(), Integer.valueOf(textFieldChangeYearOfPublishing.getText()), Integer.valueOf((textFieldChangeAmountOfPages.getText())), textFieldChangePublishingHouse.getText()),rowNumber);
				textFieldChangeAuthor.setText("");
				textFieldChangeYearOfPublishing.setText("");
				textFieldChangeAmountOfPages.setText("");
				textFieldChangePublishingHouse.setText("");
			}
		});
		btnChange.setBounds(450, 185, 89, 23);
		contentPane.add(btnChange);
	}
}
