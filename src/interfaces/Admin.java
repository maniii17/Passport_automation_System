package interfaces;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.HashMap;
import java.awt.event.ActionEvent;
import java.awt.Color;

public class Admin extends JFrame {

    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    private JTextField id;
    private JTextField username;
    private JTextField password;
    private HashMap<String, String> adminCredentials; // here is to Store admin's usernames and passwords

    public static void main(String[] args) {
        Admin frame = new Admin();
        frame.setVisible(true);
    }

    public Admin() {
     
        adminCredentials = new HashMap<>();
     
        adminCredentials.put("admin", "password");

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 755, 455);
        contentPane = new JPanel();
        contentPane.setBackground(new Color(95, 158, 160));
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        JLabel lblNewLabel = new JLabel("System User Login");
        lblNewLabel.setBounds(266, 26, 182, 60);
        lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 17));
        contentPane.add(lblNewLabel);

        JLabel lblNewLabel_1 = new JLabel("Admin ID");
        lblNewLabel_1.setFont(new Font("Times New Roman", Font.BOLD, 14));
        lblNewLabel_1.setBounds(78, 117, 64, 13);
        contentPane.add(lblNewLabel_1);

        JLabel lblNewLabel_2 = new JLabel("Username");
        lblNewLabel_2.setFont(new Font("Times New Roman", Font.BOLD, 14));
        lblNewLabel_2.setBounds(78, 169, 64, 13);
        contentPane.add(lblNewLabel_2);

        JLabel lblNewLabel_3 = new JLabel("Password");
        lblNewLabel_3.setFont(new Font("Times New Roman", Font.BOLD, 14));
        lblNewLabel_3.setBounds(78, 222, 64, 13);
        contentPane.add(lblNewLabel_3);

        id = new JTextField();
        id.setBounds(187, 115, 261, 19);
        contentPane.add(id);
        id.setColumns(10);

        username = new JTextField();
        username.setBounds(187, 167, 261, 19);
        contentPane.add(username);
        username.setColumns(10);

        password = new JTextField();
        password.setBounds(187, 220, 261, 19);
        contentPane.add(password);
        password.setColumns(10);

        JButton btnNewButton = new JButton("Back");
        btnNewButton.setBackground(new Color(128, 128, 128));
        btnNewButton.setFont(new Font("Times New Roman", Font.BOLD, 13));
        btnNewButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
                new home_page().setVisible(true);
            }
        });
        btnNewButton.setBounds(421, 310, 85, 21);
        contentPane.add(btnNewButton);

        JButton btnNewButton_1 = new JButton("Clear");
        btnNewButton_1.setBackground(new Color(128, 128, 128));
        btnNewButton_1.setFont(new Font("Times New Roman", Font.BOLD, 13));
        btnNewButton_1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

                id.setText("");
                username.setText("");
                password.setText("");
            }
        });
        btnNewButton_1.setBounds(266, 310, 85, 21);
        contentPane.add(btnNewButton_1);

        JButton btnNewButton_2 = new JButton("Log In");
        btnNewButton_2.setBackground(new Color(128, 128, 128));
        btnNewButton_2.setFont(new Font("Times New Roman", Font.BOLD, 13));
        btnNewButton_2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {  String enteredId = id.getText();
            String enteredUsername = username.getText();
            String enteredPassword = password.getText();
            
        
            if (enteredId.equals("1") && enteredUsername.equals("admin") && enteredPassword.equals("1234")) {

                setVisible(false);
                new AdminUserPage().setVisible(true);
            } else {
 
                JOptionPane.showMessageDialog(contentPane, "Invalid admin ID, username, or password. Please try again.", "Login Failed", JOptionPane.ERROR_MESSAGE);
            }
        }
    });
        btnNewButton_2.setBounds(127, 310, 85, 21);
        contentPane.add(btnNewButton_2);
    }
}
