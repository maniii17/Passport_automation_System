package interfaces;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Color;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Date;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import Main.ConnectionDb;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextPane;

public class Cheak_status_interface extends JFrame {

    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    private JTextField aid;
    private JTable table;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    Cheak_status_interface frame = new Cheak_status_interface();
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
    public Cheak_status_interface() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 826, 584);
        contentPane = new JPanel();
        contentPane.setBackground(new Color(95, 158, 160));
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

        setContentPane(contentPane);
        contentPane.setLayout(null);

        JLabel lblNewLabel = new JLabel("Check Status");
        lblNewLabel.setBounds(298, 10, 126, 48);
        lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 17));
        contentPane.add(lblNewLabel);

        JLabel lblNewLabel_1 = new JLabel("Please Enter Identity Number here     ----------> ");
        lblNewLabel_1.setFont(new Font("Times New Roman", Font.BOLD, 14));
        lblNewLabel_1.setBounds(46, 96, 294, 72);
        contentPane.add(lblNewLabel_1);

        aid = new JTextField();
        aid.setBounds(350, 124, 231, 19);
        contentPane.add(aid);
        aid.setColumns(10);

        table = new JTable();
        table.setBackground(new Color(240, 255, 255));
        table.setBounds(167, 260, 314, 21);
        contentPane.add(table);

        JButton btnNewButton = new JButton("Enter");
        btnNewButton.setBackground(new Color(128, 128, 128));
        btnNewButton.setBounds(350, 184, 85, 21);
        contentPane.add(btnNewButton);
        btnNewButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String identityNumberStr = aid.getText();

                // Convert identityNumberStr to long
                long identityNumber = Long.parseLong(identityNumberStr);

                try {
                    ConnectionDb ob = new ConnectionDb();
                    Connection conn = ob.connectDB();

                    // SQL query to select status and appointment date based on identity number
                    String sql = "SELECT PassportStatus, AppointmentDate FROM ApplicantStatus WHERE IdentityNumber = ?";
                    PreparedStatement statement = conn.prepareStatement(sql);
                    statement.setLong(1, identityNumber);
                    ResultSet resultSet = statement.executeQuery();

                    // Create a DefaultTableModel to hold the query result
                    DefaultTableModel model = new DefaultTableModel();

                    // Add the column names to the table model
                    model.addColumn("Passport Status");
                    model.addColumn("Appointment Date");

                    // Add the query result to the table model
                    if (resultSet.next()) {
                        String passportStatus = resultSet.getString("PassportStatus");
                        Date appointmentDate = resultSet.getDate("AppointmentDate");
                        model.addRow(new Object[]{passportStatus, appointmentDate});
                    } else {
                        // No record found for the provided identity number
                        model.addRow(new Object[]{"No record found", "No record found"});
                    }

                    // Set the model to the table
                    table.setModel(model);

                    // Close the resources
                    resultSet.close();
                    statement.close();
                    conn.close();
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
            }
        });

        JButton btnNewButton_1 = new JButton("Back");
        btnNewButton_1.setBackground(new Color(105, 105, 105));
        btnNewButton_1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
                new home_page().setVisible(true);
            }
        });
        btnNewButton_1.setBounds(496, 184, 85, 21);
        contentPane.add(btnNewButton_1);
        
        JLabel lblNewLabel_2 = new JLabel(":Get real time status updates on your passport application:");
        lblNewLabel_2.setFont(new Font("Times New Roman", Font.BOLD, 12));
        lblNewLabel_2.setBounds(220, 50, 338, 31);
        contentPane.add(lblNewLabel_2);
        
        JLabel lblNewLabel_3 = new JLabel("Your passport status ");
        lblNewLabel_3.setBounds(167, 244, 160, 19);
        contentPane.add(lblNewLabel_3);
        
        JLabel lblNewLabel_4 = new JLabel("Appoitment date ");
        lblNewLabel_4.setBounds(337, 247, 110, 13);
        contentPane.add(lblNewLabel_4);
        
        JTextPane txtpnImportantNoticeTo = new JTextPane();
        txtpnImportantNoticeTo.setBackground(new Color(192, 192, 192));
        txtpnImportantNoticeTo.setFont(new Font("Times New Roman", Font.PLAIN, 14));
        txtpnImportantNoticeTo.setText("Important Notice to Applicants: \r\n\r\nDear Applicant, \r\n\r\n Please note that you should make every effort to attend your appointment on the scheduled date. Failure to do so may result in delays in processing your application.   If you encounter any issues or are unable to attend on the given date, please contact us immediately at 077561515135 for assistance, clarifications, or to reschedule your appointment.        ");
        txtpnImportantNoticeTo.setBounds(91, 332, 557, 172);
        contentPane.add(txtpnImportantNoticeTo);
    }
}
