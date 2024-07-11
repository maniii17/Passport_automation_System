package interfaces;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;
import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.ImageIcon;

public class home_page extends JFrame {

    private static final long serialVersionUID = 1L;
    private JPanel contentPane;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    home_page frame = new home_page();
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
    public home_page() {
        setTitle("Home Page");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 705, 447);
        setResizable(false); 
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        // Background image
        ImageIcon bgIcon = new ImageIcon("back.jpg");
        JLabel background = new JLabel(bgIcon);
        background.setBounds(0, 0, 705, 447);
        contentPane.add(background);

        int frameWidth = 705;
        int buttonWidth = 200;
        int buttonX = (frameWidth - buttonWidth) / 2;
        int labelX = (frameWidth - 450) / 2; 

        JButton btnNewButton = new JButton("Apply for a New Passport");
        btnNewButton.setForeground(new Color(0, 0, 0));
        btnNewButton.setBackground(new Color(128, 128, 128));
        btnNewButton.setBounds(buttonX, 150, buttonWidth, 40);
        btnNewButton.setFont(new Font("Arial", Font.BOLD, 13));
        btnNewButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                btnNewButton.setBackground(new Color(0, 100, 100)); 
            }

            @Override
            public void mouseExited(MouseEvent e) {
                btnNewButton.setBackground(new Color(0, 128, 128)); 
            }
        });
        btnNewButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
                new ApplicantInterface().setVisible(true);
            }
        });
        background.add(btnNewButton);

        JLabel lblNewLabel = new JLabel("Online Passport Application System");
        lblNewLabel.setBounds(labelX, 50, 450, 30);
        lblNewLabel.setFont(new Font("Arial", Font.BOLD, 24));
        background.add(lblNewLabel);

        JButton btnNewButton_1 = new JButton("System User");
        btnNewButton_1.setForeground(new Color(0, 0, 0));
        btnNewButton_1.setBackground(new Color(128, 128, 128));
        btnNewButton_1.setBounds(buttonX, 220, buttonWidth, 40);
        btnNewButton_1.setFont(new Font("Arial", Font.BOLD, 14));
        btnNewButton_1.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                btnNewButton_1.setBackground(new Color(0, 100, 100)); 
            }

            @Override
            public void mouseExited(MouseEvent e) {
                btnNewButton_1.setBackground(new Color(0, 128, 128)); 
            }
        });
        btnNewButton_1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
                new Admin().setVisible(true);
            }
        });
        background.add(btnNewButton_1);

        JButton btnNewButton_2 = new JButton("Check Status");
        btnNewButton_2.setForeground(new Color(0, 0, 0));
        btnNewButton_2.setBackground(new Color(128, 128, 128));
        btnNewButton_2.setBounds(buttonX, 290, buttonWidth, 40);
        btnNewButton_2.setFont(new Font("Arial", Font.BOLD, 14));
        btnNewButton_2.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                btnNewButton_2.setBackground(new Color(0, 100, 100)); 
            }

            @Override
            public void mouseExited(MouseEvent e) {
                btnNewButton_2.setBackground(new Color(0, 128, 128)); 
            }
        });
        btnNewButton_2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
                new Cheak_status_interface().setVisible(true);
            }
        });
        background.add(btnNewButton_2);
    }
}
