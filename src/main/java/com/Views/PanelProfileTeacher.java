package com.Views;
import com.DAO.StudentDAO;
import com.DAO.TeacherDAO;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class PanelProfileTeacher extends JPanel {
    private JTextField txtName;
    private JTextField txtDob;
    private JTextField txtAddress;
    private JTextField txtPhone;
    private JTextField txtPos;
    private JTextField txtUser;
    private JTextField txtPass;

    /**
     * Create the panel.
     */
    public PanelProfileTeacher(JFrame jFrame, int id) {
        setLayout(null);

        JPanel panel = new JPanel();
        panel.setLayout(null);
        panel.setBounds(0, 0, 317, 317);
        add(panel);

        JLabel lblTeachername = new JLabel("TeacherName");
        lblTeachername.setBounds(0, 1, 125, 18);
        panel.add(lblTeachername);

        txtName = new JTextField();
        txtName.setColumns(10);
        txtName.setBounds(95, 1, 212, 18);
        panel.add(txtName);

        JLabel lblNewLabel_1 = new JLabel("Date of birth");
        lblNewLabel_1.setBounds(0, 29, 125, 18);
        panel.add(lblNewLabel_1);

        txtDob = new JTextField();
        txtDob.setColumns(10);
        txtDob.setBounds(95, 29, 212, 18);
        panel.add(txtDob);

        JLabel lblNewLabel_2 = new JLabel("Address");
        lblNewLabel_2.setBounds(0, 57, 125, 18);
        panel.add(lblNewLabel_2);

        txtAddress = new JTextField();
        txtAddress.setColumns(10);
        txtAddress.setBounds(95, 57, 212, 18);
        panel.add(txtAddress);

        JLabel lblNewLabel_3_1 = new JLabel("Phone");
        lblNewLabel_3_1.setBounds(0, 85, 125, 18);
        panel.add(lblNewLabel_3_1);

        txtPhone = new JTextField();
        txtPhone.setColumns(10);
        txtPhone.setBounds(95, 85, 212, 18);
        panel.add(txtPhone);

        JLabel lblNewLabel_3_2 = new JLabel("Position");
        lblNewLabel_3_2.setBounds(0, 113, 125, 18);
        panel.add(lblNewLabel_3_2);

        txtPos = new JTextField();
        txtPos.setColumns(10);
        txtPos.setBounds(95, 113, 212, 18);
        panel.add(txtPos);

        JLabel lblNewLabel_3_3 = new JLabel("Username");
        lblNewLabel_3_3.setBounds(0, 142, 125, 18);
        panel.add(lblNewLabel_3_3);

        txtUser = new JTextField();
        txtUser.setColumns(10);
        txtUser.setBounds(95, 142, 212, 18);
        panel.add(txtUser);

        JLabel lblNewLabel_3_4 = new JLabel("Password");
        lblNewLabel_3_4.setBounds(0, 170, 125, 18);
        panel.add(lblNewLabel_3_4);

        txtPass = new JTextField();
        txtPass.setColumns(10);
        txtPass.setBounds(95, 170, 212, 18);
        panel.add(txtPass);

        JButton btnEdit = new JButton("Edit");
        btnEdit.setBounds(222, 197, 85, 21);
        panel.add(btnEdit);

        JButton btnExit = new JButton("Exit");
        btnExit.setBounds(222, 286, 85, 21);
        panel.add(btnExit);

        JButton btnNewpass = new JButton("New Password");
        btnNewpass.setBounds(95, 197, 117, 21);
        panel.add(btnNewpass);

        txtName.setEditable(false);
        txtDob.setEditable(false);
        txtAddress.setEditable(false);
        txtPhone.setEditable(false);
        txtPos.setEditable(false);
        txtUser.setEditable(false);
        txtPass.setEditable(false);

        Object[] teacher = TeacherDAO.getTeacher(id);
        txtName.setText((String) teacher[6]);
        txtDob.setText(String.valueOf((Date) teacher[2]));
        txtAddress.setText((String) teacher[1]);
        txtPhone.setText((String) teacher[5]);
        txtPos.setText((String) teacher[6]);
        txtUser.setText((String) teacher[7]);
        txtPass.setText((String) teacher[3]);


        btnEdit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (btnEdit.getText().equals("Edit")){
                    setStatus(true);
                    btnEdit.setText("Save");
                    btnNewpass.setText("Cancel");
                }
                else{
                    String Pos=txtPos.getText();
                    String Name=txtName.getText();
                    Date Dob= null;
                    try {
                        Dob = new SimpleDateFormat("yyyy-MM-dd").parse(txtDob.getText());
                    } catch (ParseException parseException) {
                        parseException.printStackTrace();
                    }
                    String Address=txtAddress.getText();
                    String Phone=txtPhone.getText();
                    String User=txtUser.getText();
                    String Pass=txtPass.getText();

                    TeacherDAO.UpdateTeacherPass(String.valueOf(id),Name,Dob,Address,Phone,Pos,User,Pass);

                    reset(btnEdit,btnNewpass,id);
                    setStatus(false);
                    txtPass.setEditable(false);
                }
            }
        });




        btnExit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                jFrame.dispose();
                JFrame frame = new JFrame();
                frame.setBounds(100, 100, 786, 410);
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.getContentPane().setLayout(new CardLayout(0,0));
                frame.add(new PanelMainScreenTeacher(frame));
                JMenuBar menuBar = new JMenuBar();
                frame.setJMenuBar(menuBar);

                JMenu menuName = new JMenu("New menu");
                menuBar.add(menuName);

                JMenuItem itmenuProfile = new JMenuItem("Profile");
                menuName.add(itmenuProfile);

                JMenuItem itmenuSignOut = new JMenuItem("Sign out");
                menuName.add(itmenuSignOut);

                itmenuProfile.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        frame.dispose();
                        Profile profile = new Profile(id,"Teacher");
                        profile.setVisible(true);
                    }
                });
                itmenuSignOut.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        frame.dispose();
                        LoginScreen loginScreen = new LoginScreen();
                        loginScreen.setVisible(true);
                    }
                });
                frame.setVisible(true);
            }
        });

        btnNewpass.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (btnNewpass.getText().equals("New Password")){
                    txtPass.setEditable(true);
                    btnEdit.setText("Save");
                    btnNewpass.setText("Cancel");
                }
                else{
                    reset(btnEdit,btnNewpass,id);
                    txtPass.setEditable(false);
                }
            }
        });

    }

    public void setStatus(boolean status){
        txtName.setEditable(status);
        txtPos.setEditable(status);
        txtDob.setEditable(status);
        txtAddress.setEditable(status);
        txtPhone.setEditable(status);
        txtUser.setEditable(status);
    }

    public void reset(JButton btnEdit, JButton btnNewpass, int id){
        Object[] teacher =TeacherDAO.getTeacher(id);
        txtName.setText((String) teacher[6]);
        txtDob.setText(String.valueOf((Date) teacher[2]));
        txtAddress.setText((String) teacher[1]);
        txtPhone.setText((String) teacher[5]);
        txtPos.setText((String) teacher[6]);
        txtUser.setText((String) teacher[7]);
        txtPass.setText((String) teacher[3]);

        btnEdit.setText("Edit");
        btnNewpass.setText("New Password");
    }

}

