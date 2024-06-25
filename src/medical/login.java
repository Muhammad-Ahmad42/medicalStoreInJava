package medical;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class login extends JFrame {

    private static final long serialVersionUID = 1L;
    public static final String data = "password.txt"; 
    private JPanel contentPane;
    private JTextField tfLoginEmail;
    private JPasswordField tfLoginPassword;

    public login() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 843, 544);
        contentPane = new JPanel();
        contentPane.setBackground(new Color(255, 255, 255));
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        JTextPane txtpnLogin = new JTextPane();
        txtpnLogin.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        txtpnLogin.setEditable(false);
        txtpnLogin.setText("Enter your credentials to Login");
        txtpnLogin.setBounds(280, 46, 241, 51);
        contentPane.add(txtpnLogin);

        JTextPane txtpnWelcomeBack = new JTextPane();
        txtpnWelcomeBack.setEditable(false);
        txtpnWelcomeBack.setFont(new Font("Tahoma", Font.BOLD, 30));
        txtpnWelcomeBack.setText("Welcome Back");
        txtpnWelcomeBack.setBounds(251, 11, 252, 57);
        contentPane.add(txtpnWelcomeBack);

        JTextPane txtpnEmail = new JTextPane();
        txtpnEmail.setEditable(false);
        txtpnEmail.setFont(new Font("Tahoma", Font.PLAIN, 15));
        txtpnEmail.setText("Email");
        txtpnEmail.setBounds(240, 84, 82, 40);
        contentPane.add(txtpnEmail);

        tfLoginEmail = new JTextField();
        tfLoginEmail.setBounds(250, 126, 289, 51);
        contentPane.add(tfLoginEmail);
        tfLoginEmail.setColumns(10);

        JTextPane txtpnPassword = new JTextPane();
        txtpnPassword.setFont(new Font("Tahoma", Font.PLAIN, 15));
        txtpnPassword.setText("Password");
        txtpnPassword.setEditable(false);
        txtpnPassword.setBounds(240, 188, 76, 32);
        contentPane.add(txtpnPassword);

        tfLoginPassword = new JPasswordField();
        tfLoginPassword.setBounds(251, 231, 289, 57);
        contentPane.add(tfLoginPassword);
        tfLoginPassword.setColumns(10);

        JButton btnSubmitLogin = new JButton("Login");
        btnSubmitLogin.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String email1 = tfLoginEmail.getText();
                String password1 = new String(tfLoginPassword.getPassword());

                if (email1.isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Email is Missing...");
                    return;
                }
                if (password1.isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Password is Missing....");
                    return;
                }

                BufferedReader br = null;
                boolean loggedIn = false;
                try {
                    br = new BufferedReader(new FileReader(data));
                    String line;

                    while ((line = br.readLine()) != null) {
                        String[] arr = line.split(",");
                        if (arr.length >= 3 && arr[1].equals(email1) && arr[2].equals(password1)) {
                            loggedIn = true;
                            break;
                        }
                    }

                    if (loggedIn) {
                        JOptionPane.showMessageDialog(null, "Login Successful!");
                        java.awt.EventQueue.invokeLater(new Runnable() {
                            public void run() {
                                new home().setVisible(true);
                            }
                        });
                        dispose(); // Close login frame after successful login
                    } else {
                        JOptionPane.showMessageDialog(null,
                                "Invalid email or password. Please check your credentials or sign up.");
                    }
                } catch (IOException ex) {
                    ex.printStackTrace();
                } finally {
                    try {
                        if (br != null)
                            br.close();
                    } catch (IOException ex) {
                        ex.printStackTrace();
                    }
                }
            }
        });
        btnSubmitLogin.setFont(new Font("Tahoma", Font.BOLD, 16));
        btnSubmitLogin.setBackground(new Color(0, 128, 255));
        btnSubmitLogin.setBounds(254, 299, 252, 51);
        contentPane.add(btnSubmitLogin);

        JTextPane txtpnOr = new JTextPane();
        txtpnOr.setEditable(false);
        txtpnOr.setFont(new Font("Tahoma", Font.PLAIN, 15));
        txtpnOr.setText("Or");
        txtpnOr.setBounds(378, 361, 49, 32);
        contentPane.add(txtpnOr);

        JTextPane txtpnDontHaveAn = new JTextPane();
        txtpnDontHaveAn.setFont(new Font("Tahoma", Font.PLAIN, 15));
        txtpnDontHaveAn.setEditable(false);
        txtpnDontHaveAn.setText("Don't have an account?");
        txtpnDontHaveAn.setBounds(254, 392, 173, 39);
        contentPane.add(txtpnDontHaveAn);

        JButton btnMoveToSignUp = new JButton("Sign Up");
        btnMoveToSignUp.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                java.awt.EventQueue.invokeLater(new Runnable() {
                    public void run() {
                        signUp signUp = new signUp();
                        signUp.setVisible(true);
                    }
                });
                dispose();
            }
        });
        btnMoveToSignUp.setFont(new Font("Tahoma", Font.BOLD, 17));
        btnMoveToSignUp.setBackground(new Color(0, 128, 255));
        btnMoveToSignUp.setBounds(437, 392, 108, 23);
        contentPane.add(btnMoveToSignUp);
    }
}
