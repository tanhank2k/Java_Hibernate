package com.Views;

import com.DAO.TeacherDAO;

import java.awt.*;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LoginScreen extends JFrame {

    private JPanel contentPane;
    private JTextField txtUserName;
    private JPasswordField txtPassword;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    LoginScreen frame = new LoginScreen();
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
    public LoginScreen() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 496, 343);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        JLabel lblNewLabel_2 = new JLabel("COURSE REGISTRATION SYSTEM");
        lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 18));
        lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
        lblNewLabel_2.setBounds(80, 23, 331, 62);
        contentPane.add(lblNewLabel_2);

        JLabel lblNewLabel = new JLabel("Username");
        lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 13));
        lblNewLabel.setBounds(51, 128, 78, 30);
        contentPane.add(lblNewLabel);

        txtUserName = new JTextField();
        txtUserName.setBounds(139, 135, 274, 19);
        contentPane.add(txtUserName);
        txtUserName.setColumns(10);

        JButton btnSignIn = new JButton("SIGN IN");
        btnSignIn.setFont(new Font("Tahoma", Font.BOLD, 15));
        btnSignIn.setBounds(183, 261, 96, 35);
        contentPane.add(btnSignIn);

        JLabel lblPassword = new JLabel("Password");
        lblPassword.setFont(new Font("Tahoma", Font.PLAIN, 13));
        lblPassword.setBounds(51, 181, 78, 30);
        contentPane.add(lblPassword);

        txtPassword = new JPasswordField();
        txtPassword.setBounds(139, 188, 274, 19);
        contentPane.add(txtPassword);

        JComboBox comboBoxRole = new JComboBox(new String[]{"Teacher", "Student"});
        comboBoxRole.setBounds(341, 233, 87, 21);
        contentPane.add(comboBoxRole);

        JLabel lblNewLabel_1 = new JLabel("Sign in as");
        lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 12));
        lblNewLabel_1.setBounds(378, 218, 58, 13);
        contentPane.add(lblNewLabel_1);

        btnSignIn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String user = txtUserName.getText();
                String pass = String.valueOf(txtPassword.getPassword());

                boolean result = TeacherDAO.SignIn(user,pass);
                if (result){
                    LoginScreen.this.dispose();
                    JFrame frame = new JFrame();
                    frame.setBounds(100, 100, 786, 390);
                    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                    frame.getContentPane().setLayout(new CardLayout(0,0));
                    frame.add(new PanelMainScreenTeacher(frame));
                    frame.setVisible(true);
                }
                else {
                    JOptionPane.showMessageDialog(LoginScreen.this, "Username or password incorrect!!!.");
                }
            }
        });
    }
}
