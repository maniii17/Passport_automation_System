package interfaces;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JOptionPane;
import java.awt.Color;
import java.awt.Rectangle;

public class ApplicantInterface extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField id;
	private JTextField fname;
	private JTextField mname;
	private JTextField lname;
	private JTextField pob;
	private JTextField dob;
	private JTextField address;
	private JTextField contactno;
	private JTextField email;
	private JTextField gender;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ApplicantInterface frame = new ApplicantInterface();
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
	public ApplicantInterface() {
		setBounds(new Rectangle(0, 0, 1000, 600));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 794, 566);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(95, 158, 160));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Apply Passport");
		lblNewLabel.setBounds(304, 10, 152, 31);
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 18));
		contentPane.add(lblNewLabel);
		
		JLabel identitynumber = new JLabel("Identity Number");
		identitynumber.setFont(new Font("Times New Roman", Font.BOLD, 14));
		identitynumber.setBounds(42, 87, 138, 13);
		contentPane.add(identitynumber);
		
		JLabel lblNewLabel_1 = new JLabel("First Name");
		lblNewLabel_1.setFont(new Font("Times New Roman", Font.BOLD, 14));
		lblNewLabel_1.setBounds(42, 126, 96, 13);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_3 = new JLabel("Middle Name ");
		lblNewLabel_3.setFont(new Font("Times New Roman", Font.BOLD, 14));
		lblNewLabel_3.setBounds(42, 168, 119, 13);
		contentPane.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("Last Name ");
		lblNewLabel_4.setFont(new Font("Times New Roman", Font.BOLD, 14));
		lblNewLabel_4.setBounds(42, 210, 96, 13);
		contentPane.add(lblNewLabel_4);
		
		id = new JTextField();
		id.setBounds(171, 86, 487, 19);
		contentPane.add(id);
		id.setColumns(10);
		
		fname = new JTextField();
		fname.setBounds(171, 125, 487, 19);
		contentPane.add(fname);
		fname.setColumns(10);
		
		mname = new JTextField();
		mname.setBounds(171, 167, 487, 19);
		contentPane.add(mname);
		mname.setColumns(10);
		
		lname = new JTextField();
		lname.setBounds(171, 209, 487, 19);
		contentPane.add(lname);
		lname.setColumns(10);
		
		JLabel lblNewLabel_5 = new JLabel("Gender");
		lblNewLabel_5.setFont(new Font("Times New Roman", Font.BOLD, 14));
		lblNewLabel_5.setBounds(42, 249, 96, 13);
		contentPane.add(lblNewLabel_5);
		
		JLabel lblNewLabel_6 = new JLabel("Place of birth");
		lblNewLabel_6.setFont(new Font("Times New Roman", Font.BOLD, 14));
		lblNewLabel_6.setBounds(42, 289, 96, 13);
		contentPane.add(lblNewLabel_6);
		
		JLabel lblNewLabel_7 = new JLabel("Birth Year");
		lblNewLabel_7.setFont(new Font("Times New Roman", Font.BOLD, 14));
		lblNewLabel_7.setBounds(42, 331, 96, 13);
		contentPane.add(lblNewLabel_7);
		
		pob = new JTextField();
		pob.setBounds(171, 288, 487, 19);
		contentPane.add(pob);
		pob.setColumns(10);
		
		dob = new JTextField();
		dob.setBounds(171, 330, 71, 19);
		contentPane.add(dob);
		dob.setColumns(10);
		
		JLabel lblNewLabel_8 = new JLabel("Address");
		lblNewLabel_8.setFont(new Font("Times New Roman", Font.BOLD, 14));
		lblNewLabel_8.setBounds(42, 369, 82, 13);
		contentPane.add(lblNewLabel_8);
		
		JLabel lblNewLabel_9 = new JLabel("Contact Number");
		lblNewLabel_9.setFont(new Font("Times New Roman", Font.BOLD, 14));
		lblNewLabel_9.setBounds(42, 399, 119, 13);
		contentPane.add(lblNewLabel_9);
		
		JLabel lblNewLabel_10 = new JLabel("Email");
		lblNewLabel_10.setFont(new Font("Times New Roman", Font.BOLD, 14));
		lblNewLabel_10.setBounds(42, 436, 45, 13);
		contentPane.add(lblNewLabel_10);
		
		address = new JTextField();
		address.setBounds(171, 368, 487, 19);
		contentPane.add(address);
		address.setColumns(10);
		
		contactno = new JTextField();
		contactno.setBounds(171, 398, 487, 19);
		contentPane.add(contactno);
		contactno.setColumns(10);
		
		email = new JTextField();
		email.setBounds(171, 435, 487, 19);
		contentPane.add(email);
		email.setColumns(10);
		
		JButton btnNewButton = new JButton("Apply");
		btnNewButton.setBackground(new Color(128, 128, 128));
		btnNewButton.setFont(new Font("Times New Roman", Font.BOLD, 13));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				 String IdentityNumber = id.getText();
				    int IdNumber = Integer.parseInt(IdentityNumber);
				    String FirstName = fname.getText();
				    String MiddleName = mname.getText();
				    String LastName = lname.getText();
				    String Gender = gender.getText();
				    String Placeofbirth = pob.getText();
				    int Dateofbirth = Integer.parseInt(dob.getText()); // Parsing to integer
				    String Address = address.getText();
				    int ContactNumber = Integer.parseInt(contactno.getText()); // Parsing to integer
				    String Email = email.getText();
				    
				    // Call the method with integer parameters
				    Applicant ob = new Applicant(ContactNumber, Email, Email, Email, Email, Email, ContactNumber, Email, ContactNumber, Email);
				    ob.insertApplicant(IdNumber, FirstName, MiddleName, LastName, Gender, Placeofbirth, Dateofbirth, Address, ContactNumber, Email);
			
					 String message = "Application submitted successfully!";
			         JOptionPane.showMessageDialog(contentPane, message, "Application Submitted", JOptionPane.INFORMATION_MESSAGE);
			
			}
		});

		
		btnNewButton.setBounds(200, 487, 85, 21);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Clear");
		btnNewButton_1.setBackground(new Color(169, 169, 169));
		btnNewButton_1.setFont(new Font("Times New Roman", Font.BOLD, 13));
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
				
				
				id.setText("");
				fname.setText("");
				mname.setText("");
				lname.setText("");
				gender.setText("");
				pob.setText("");
				dob.setText("");
				address.setText("");
				contactno.setText("");
				email.setText("");
				
			}
		});
		btnNewButton_1.setBounds(325, 487, 85, 21);
		contentPane.add(btnNewButton_1);
		
		gender = new JTextField();
		gender.setBounds(171, 249, 71, 19);
		contentPane.add(gender);
		gender.setColumns(10);
		
		JButton btnNewButton_2 = new JButton("Back");
		btnNewButton_2.setBackground(new Color(169, 169, 169));
		btnNewButton_2.setFont(new Font("Times New Roman", Font.BOLD, 13));
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				new home_page().setVisible(true);
				
			}
		});
		btnNewButton_2.setBounds(453, 487, 85, 21);
		contentPane.add(btnNewButton_2);
		
		JLabel lblNewLabel_2 = new JLabel("A Sri Lankan citizen by descent or by registration can apply");
		lblNewLabel_2.setFont(new Font("Times New Roman", Font.BOLD, 12));
		lblNewLabel_2.setBounds(200, 42, 404, 13);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_11 = new JLabel("(Enter the year only)");
		lblNewLabel_11.setBounds(242, 332, 150, 13);
		contentPane.add(lblNewLabel_11);
		
		JLabel lblNewLabel_12 = new JLabel("(Male/Female)");
		lblNewLabel_12.setBounds(242, 250, 100, 13);
		contentPane.add(lblNewLabel_12);
	}
}
