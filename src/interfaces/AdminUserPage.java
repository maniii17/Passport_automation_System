package interfaces;

import java.awt.EventQueue;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.table.DefaultTableModel;

import Main.ConnectionDb;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;
import java.awt.Color;

public class AdminUserPage extends JFrame {

    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    private JTable table;
    private JTextField status_1;
    private JTextField date;
    private JTextField id;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    AdminUserPage frame = new AdminUserPage();
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
    public AdminUserPage() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 799, 546);
        contentPane = new JPanel();
        contentPane.setBackground(new Color(95, 158, 160));
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

        setContentPane(contentPane);
        contentPane.setLayout(null);

        JScrollPane scrollPane = new JScrollPane();
        scrollPane.setBounds(20, 147, 755, 147);
        contentPane.add(scrollPane);

        table = new JTable();
        scrollPane.setViewportView(table);

        JLabel lblNewLabel = new JLabel("");
        lblNewLabel.setBounds(276, 10, 46, 13);
        contentPane.add(lblNewLabel);

        JLabel lblNewLabel_1 = new JLabel("Enter Passport Status");
        lblNewLabel_1.setFont(new Font("Times New Roman", Font.BOLD, 13));
        lblNewLabel_1.setBounds(35, 358, 167, 13);
        contentPane.add(lblNewLabel_1);

        status_1 = new JTextField();
        status_1.setBounds(196, 355, 282, 19);
        contentPane.add(status_1);
        status_1.setColumns(10);

        date = new JTextField();
        date.setBounds(196, 391, 282, 19);
        contentPane.add(date);
        date.setColumns(10);

        JButton btnNewButton = new JButton("Enter ");
        btnNewButton.setBounds(248, 464, 85, 21);
        btnNewButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String passportStatus = status_1.getText();  // Get passport status from JTextField
                String appointmentDateStr = date.getText();  // Get appointment date from JTextField
                long identityNumber = Long.parseLong(id.getText()); // Get identity number from JTextField

                // Convert appointmentDateStr to java.sql.Date
                Date appointmentDate = null;
                try {
                    SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
                    java.util.Date parsedDate = dateFormat.parse(appointmentDateStr);
                    appointmentDate = new java.sql.Date(parsedDate.getTime());
                } catch (ParseException ex) {
                    ex.printStackTrace(); // Handle the error appropriately
                    return;
                }

                try {
                    ConnectionDb ob = new ConnectionDb();
                    Connection conn = ob.connectDB();
                    
                    // Prepare the INSERT statement
                    String insertQuery = "INSERT INTO ApplicantStatus (IdentityNumber, PassportStatus, AppointmentDate) VALUES (?, ?, ?)";
                    PreparedStatement insertStatement = conn.prepareStatement(insertQuery);
                    
                    // Get values from text fields
                    long identityNumber1 = Long.parseLong(id.getText());
                    String passportStatus1 = status_1.getText();
                    String appointmentDateStr1 = date.getText();
                    
                    // Convert appointmentDateStr to java.sql.Date
                    Date appointmentDate1 = null;
                    try {
                        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
                        
                        java.util.Date parsedDate = dateFormat.parse(appointmentDateStr1);
                        appointmentDate1 = new java.sql.Date(parsedDate.getTime());
                    } catch (ParseException ex) {
                        ex.printStackTrace(); // Handle the error appropriately
                        return;
                    }
                    
                    // Set values in the prepared statement
                    insertStatement.setLong(1, identityNumber1);
                    insertStatement.setString(2, passportStatus1);
                    insertStatement.setDate(3, appointmentDate1);
                    
                    // Execute the INSERT statement
                    int rowsInserted = insertStatement.executeUpdate();

                    if (rowsInserted > 0) {
                        System.out.println("Applicant status inserted successfully for Identity Number: " + identityNumber1);
                    } else {
                        System.out.println("Failed to insert applicant status.");
                    }
                    
                } catch (SQLException e1) {
                    e1.printStackTrace();
                    System.out.println("Failed to insert applicant status.");
                }
            }
        });
        contentPane.add(btnNewButton);

        JButton btnNewButton_1 = new JButton("Back");
        btnNewButton_1.setBounds(375, 464, 85, 21);
        btnNewButton_1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
                new Admin().setVisible(true);
            }
        });
        contentPane.add(btnNewButton_1);

        JLabel lblNewLabel_2 = new JLabel("Assign an Appointment date ");
        lblNewLabel_2.setFont(new Font("Times New Roman", Font.BOLD, 13));
        lblNewLabel_2.setBounds(35, 394, 153, 13);
        contentPane.add(lblNewLabel_2);

        JLabel lblNewLabel_3 = new JLabel("Enter Applicant's Identity Number");
        lblNewLabel_3.setFont(new Font("Times New Roman", Font.BOLD, 13));
        lblNewLabel_3.setBounds(35, 76, 200, 13);
        contentPane.add(lblNewLabel_3);

        id = new JTextField();
        id.setBounds(234, 62, 262, 50);
        contentPane.add(id);
        id.setColumns(10);

        // Populate the table with applicant details
        try {
            ConnectionDb ob = new ConnectionDb();
            Connection conn = ob.connectDB();
            String sql = "SELECT * FROM Applicant";
            PreparedStatement statement = conn.prepareStatement(sql);
            ResultSet resultSet = statement.executeQuery();

            // Get metadata from the result set
            ResultSetMetaData metaData = resultSet.getMetaData();
            int columnCount = metaData.getColumnCount();

            DefaultTableModel model = new DefaultTableModel();
            for (int columnIndex = 1; columnIndex <= columnCount; columnIndex++) {
                model.addColumn(metaData.getColumnLabel(columnIndex));
            }

            // Add rows to the model
            while (resultSet.next()) {
                Object[] row = new Object[columnCount];
                for (int i = 0; i < columnCount; i++) {
                    row[i] = resultSet.getObject(i + 1);
                }
                model.addRow(row);
            }

            // Set the model to the table
            table.setModel(model);
            
            JLabel lblNewLabel_4 = new JLabel("Admin Dashboard");
            lblNewLabel_4.setBounds(286, 10, 180, 42);
            lblNewLabel_4.setFont(new Font("Times New Roman", Font.BOLD, 15));
            contentPane.add(lblNewLabel_4);
            
            JLabel lblNewLabel_5 = new JLabel("Applicant Data ");
            lblNewLabel_5.setFont(new Font("Times New Roman", Font.BOLD, 14));
            lblNewLabel_5.setBounds(310, 122, 138, 13);
            contentPane.add(lblNewLabel_5);
            
            JLabel dateformat = new JLabel("('YYYY-MM-DD')");
            dateformat.setBounds(490, 394,100, 13);
            contentPane.add(dateformat);

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}