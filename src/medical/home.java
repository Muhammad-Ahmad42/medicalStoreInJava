package medical;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JTextArea;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;
import java.awt.Font;
import javax.swing.ImageIcon;

public class home extends JFrame {

    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    private JTextField textField;

    public home() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(0, -18, 876, 735);
        contentPane = new JPanel();
        contentPane.setBackground(new Color(0, 255, 255));
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

        setContentPane(contentPane);
        contentPane.setLayout(null);

        JButton btnmedicine = new JButton("Medicine");
        btnmedicine.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                new medicine().setVisible(true);
            }
        });
        btnmedicine.setFont(new Font("Tahoma", Font.BOLD, 12));
        btnmedicine.setBounds(21, 161, 152, 37);
        contentPane.add(btnmedicine);

        JButton btncompanies = new JButton("Companies");
        btncompanies.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                new companies().setVisible(true);
            }
        });
        btncompanies.setFont(new Font("Tahoma", Font.BOLD, 12));
        btncompanies.setBounds(21, 230, 152, 37);
        contentPane.add(btncompanies);

        JButton btnviewsellrecords = new JButton("View Sell Records");
        btnviewsellrecords.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                new sellRecord().setVisible(true);
            }
        });
        btnviewsellrecords.setFont(new Font("Tahoma", Font.BOLD, 12));
        btnviewsellrecords.setBounds(21, 301, 152, 37);
        contentPane.add(btnviewsellrecords);

        JButton btnnewsales = new JButton("New Sales");
        btnnewsales.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                new sales().setVisible(true);
            }
        });
        btnnewsales.setFont(new Font("Tahoma", Font.BOLD, 12));
        btnnewsales.setBounds(21, 368, 152, 37);
        contentPane.add(btnnewsales);

        JButton btnchangepassword = new JButton("Change Password");
        btnchangepassword.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                new changePassword().setVisible(true);
            }
        });
        btnchangepassword.setFont(new Font("Tahoma", Font.BOLD, 12));
        btnchangepassword.setBounds(21, 435, 152, 37);
        contentPane.add(btnchangepassword);

        JButton btnsearch = new JButton("Search");
        btnsearch.setFont(new Font("Tahoma", Font.BOLD, 12));
        btnsearch.setBounds(679, 161, 152, 37);
        contentPane.add(btnsearch);

        textField = new JTextField();
        textField.setFont(new Font("Tahoma", Font.BOLD, 12));
        textField.setBounds(183, 165, 459, 30);
        contentPane.add(textField);
        textField.setColumns(10);

        JButton btnabout = new JButton("About");
        btnabout.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                new about().setVisible(true);
            }
        });
        btnabout.setFont(new Font("Tahoma", Font.BOLD, 12));
        btnabout.setBounds(21, 512, 152, 37);
        contentPane.add(btnabout);

        JButton btnlogout = new JButton("Log Out");
        btnlogout.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                logout();
            }
        });
        btnlogout.setFont(new Font("Tahoma", Font.BOLD, 12));
        btnlogout.setBounds(21, 585, 152, 37);
        contentPane.add(btnlogout);

        JTextArea textArea = new JTextArea();
        textArea.setFont(new Font("Tahoma", Font.BOLD, 14));
        textArea.setBounds(183, 230, 648, 392);
        contentPane.add(textArea);

        JLabel lblNewLabel_1 = new JLabel("Medical Store Management System");
        lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 28));
        lblNewLabel_1.setBounds(273, 40, 507, 59);
        contentPane.add(lblNewLabel_1);
        
        JLabel lblNewLabel = new JLabel("");
        lblNewLabel.setIcon(new ImageIcon("C:\\Users\\SHABBIR TRADERS\\Desktop\\images.jpg"));
        lblNewLabel.setBounds(35, 21, 228, 111);
        contentPane.add(lblNewLabel);
    }

    private void logout() {
        // Assuming you have a login class to redirect to the login page
        new login().setVisible(true);
        dispose();  // Close the current home window
    }
}
