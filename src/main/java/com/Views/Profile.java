package com.Views;

import com.DAO.ClassDAO;
import com.DAO.StudentDAO;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JTextField;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JButton;

public class Profile extends JFrame {

    private JPanel contentPane;
    private JTextField txtMSSV;
    private JTextField txtName;
    private JTextField txtGender;
    private JTextField txtDoB;
    private JTextField txtAddress;
    private JTextField txtPhone;
    private JTextField txtClass;
    private JTextField txtUser;
    private JTextField txtPass;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    //Profile frame = new Profile();
                   // frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    /**
     * Create the frame.
     */
    public Profile(int id, String role) {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 376, 396);

        JMenuBar menuBar = new JMenuBar();
        setJMenuBar(menuBar);

        JMenu menuName = new JMenu("New menu");
        menuBar.add(menuName);

        JMenuItem itmenuProfile = new JMenuItem("Profile");
        menuName.add(itmenuProfile);

        JMenuItem itmenuSignOut = new JMenuItem("Sign out");
        menuName.add(itmenuSignOut);

        if (role.equals("Student")){
            initialize(id);
        }
        else{
            Profile.this.setContentPane(new PanelProfileTeacher(Profile.this,id));
        }



    }

    public void initialize(int idStudent){
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        JPanel panel = new JPanel();
        panel.setLayout(null);
        panel.setBounds(10, 10, 317, 317);
        contentPane.add(panel);

        JLabel lbID = new JLabel("MSSV");
        lbID.setBounds(0, 1, 125, 18);
        panel.add(lbID);

        txtMSSV = new JTextField();
        txtMSSV.setColumns(10);
        txtMSSV.setBounds(95, 1, 212, 18);
        panel.add(txtMSSV);

        JLabel lblNewLabel_1 = new JLabel("Student Name");
        lblNewLabel_1.setBounds(0, 29, 125, 18);
        panel.add(lblNewLabel_1);

        txtName = new JTextField();
        txtName.setColumns(10);
        txtName.setBounds(95, 29, 212, 18);
        panel.add(txtName);

        JLabel lblNewLabel_2 = new JLabel("Gender");
        lblNewLabel_2.setBounds(0, 57, 125, 18);
        panel.add(lblNewLabel_2);

        txtGender = new JTextField();
        txtGender.setColumns(10);
        txtGender.setBounds(95, 57, 212, 18);
        panel.add(txtGender);

        JLabel lblNewLabel_3 = new JLabel("Date of birth");
        lblNewLabel_3.setBounds(0, 85, 125, 18);
        panel.add(lblNewLabel_3);

        txtDoB = new JTextField();
        txtDoB.setColumns(10);
        txtDoB.setBounds(95, 85, 212, 18);
        panel.add(txtDoB);

        JLabel lblNewLabel_3_1 = new JLabel("Address");
        lblNewLabel_3_1.setBounds(0, 113, 125, 18);
        panel.add(lblNewLabel_3_1);

        txtAddress = new JTextField();
        txtAddress.setColumns(10);
        txtAddress.setBounds(95, 113, 212, 18);
        panel.add(txtAddress);

        JLabel lblNewLabel_3_2 = new JLabel("Phone");
        lblNewLabel_3_2.setBounds(0, 141, 125, 18);
        panel.add(lblNewLabel_3_2);

        txtPhone = new JTextField();
        txtPhone.setColumns(10);
        txtPhone.setBounds(95, 141, 212, 18);
        panel.add(txtPhone);

        JLabel lblNewLabel_3_3 = new JLabel("Class");
        lblNewLabel_3_3.setBounds(0, 170, 125, 18);
        panel.add(lblNewLabel_3_3);

        txtClass = new JTextField();
        txtClass.setColumns(10);
        txtClass.setBounds(95, 170, 212, 18);
        panel.add(txtClass);

        JLabel lblNewLabel_3_4 = new JLabel("Username");
        lblNewLabel_3_4.setBounds(0, 198, 125, 18);
        panel.add(lblNewLabel_3_4);

        txtUser = new JTextField();
        txtUser.setColumns(10);
        txtUser.setBounds(95, 198, 212, 18);
        panel.add(txtUser);

        JLabel lblNewLabel_3_5 = new JLabel("Password");
        lblNewLabel_3_5.setBounds(0, 226, 125, 18);
        panel.add(lblNewLabel_3_5);

        txtPass = new JTextField();
        txtPass.setColumns(10);
        txtPass.setBounds(95, 226, 212, 18);
        panel.add(txtPass);

        JButton btnEdit = new JButton("Edit");
        btnEdit.setBounds(222, 254, 85, 21);
        panel.add(btnEdit);

        JButton btnNewPassword = new JButton("New Password");
        btnNewPassword.setBounds(95, 254, 117, 21);
        panel.add(btnNewPassword);

        JButton btnExit = new JButton("Exit");
        btnExit.setBounds(222, 286, 85, 21);
        panel.add(btnExit);

        txtMSSV.setEditable(false);
        txtName.setEditable(false);
        txtGender.setEditable(false);
        txtDoB.setEditable(false);
        txtAddress.setEditable(false);
        txtPhone.setEditable(false);
        txtClass.setEditable(false);
        txtUser.setEditable(false);
        txtPass.setEditable(false);

        Object[] student = StudentDAO.getStudent(idStudent);
        txtMSSV.setText((String) student[4]);
        txtName.setText((String) student[7]);
        txtGender.setText((String) student[3]);
        txtDoB.setText(String.valueOf((Date) student[2]));
        txtAddress.setText((String) student[1]);
        txtPhone.setText((String) student[6]);
        txtClass.setText(ClassDAO.getClassName((int) student[9]));
        txtUser.setText((String) student[8]);
        txtPass.setText((String) student[5]);

        btnEdit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (btnEdit.getText().equals("Edit")){
                    setStatus(true);
                    btnEdit.setText("Save");
                    btnNewPassword.setText("Cancel");
                }
                else{
                    String MSSV=txtMSSV.getText();
                    String Name=txtName.getText();
                    String Gender=txtGender.getText();
                    Date DoB= null;
                    try {
                        DoB = new SimpleDateFormat("yyyy-MM-dd").parse(txtDoB.getText());
                    } catch (ParseException parseException) {
                        parseException.printStackTrace();
                    }
                    String Address=txtAddress.getText();
                    String Phone=txtPhone.getText();
                    String Clazz=txtClass.getText();
                    String User=txtUser.getText();
                    String Pass=txtPass.getText();
                   StudentDAO.UpdateStudentPass(MSSV,Name,Clazz,Gender,DoB,Address,Phone,User,Pass);

                   reset(btnEdit,btnNewPassword,idStudent);

                }
            }
        });

        btnNewPassword.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (btnNewPassword.getText().equals("New Password")){
                    txtPass.setEditable(true);
                    btnEdit.setText("Save");
                    btnNewPassword.setText("Cancel");
                }
                else{

                    setStatus(false);
                    txtPass.setEditable(false);

                    btnEdit.setText("Edit");
                    btnNewPassword.setText("New Password");
                }
            }
        });

        btnExit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Profile.this.dispose();
                PanelMainStudent panelMainStudent = new PanelMainStudent(idStudent);
                panelMainStudent.setVisible(true);
            }
        });
    }

    public void setStatus(boolean status){
        txtName.setEditable(status);
        txtGender.setEditable(status);
        txtDoB.setEditable(status);
        txtAddress.setEditable(status);
        txtPhone.setEditable(status);
        txtUser.setEditable(status);

    }

    public void reset(JButton btnEdit, JButton btnNewPassword, int idStudent){

        Object[] student = StudentDAO.getStudent(idStudent);
        txtMSSV.setText((String) student[4]);
        txtName.setText((String) student[7]);
        txtGender.setText((String) student[3]);
        txtDoB.setText(String.valueOf((Date) student[2]));
        txtAddress.setText((String) student[1]);
        txtPhone.setText((String) student[6]);
        txtClass.setText(ClassDAO.getClassName((int) student[9]));
        txtUser.setText((String) student[8]);
        txtPass.setText((String) student[5]);

        setStatus(false);
        txtPass.setEditable(false);
        btnEdit.setText("Edit");
        btnNewPassword.setText("New Password");

    }
}
