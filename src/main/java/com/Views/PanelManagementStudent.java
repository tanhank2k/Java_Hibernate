package com.Views;

import com.DAO.ClassDAO;
import com.DAO.StudentDAO;
import com.Model.StudentEntity;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;

import java.awt.SystemColor;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.Component;
import java.awt.Font;
import java.util.Date;
import java.util.List;

public class PanelManagementStudent extends JPanel {
    private JTextField txtMSSV;
    private JTextField txtName;
    private JTextField txtGender;
    private JTextField txtDoB;
    private JTextField txtAddress;
    private JTextField txtPhone;
    private JTextField txtClass;
    private JTextField txtUsername;
    private JTextField Password;
    private JTextField txtSearch;

    /**
     * Create the panel.
     */
    public PanelManagementStudent(JFrame jFrame) {
        setLayout(null);

        JPanel contentPane = new JPanel();
        contentPane.setLayout(null);
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        contentPane.setBounds(0, 0, 772, 349);
        add(contentPane);

        JScrollPane scrollPane = new JScrollPane();
        scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
        scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
        scrollPane.setBounds(10, 56, 465, 222);
        contentPane.add(scrollPane);


        JTable table_2 = new JTable();

        table_2.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);
        table_2.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
        table_2.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
            }
        });
        scrollPane.setViewportView(table_2);
        DefaultTableModel tableModel = new DefaultTableModel(new String[] {
                "MSSV", "Student Name", "Gender", "Date of Birth", "Address", "Phone", "Class", "Username", "Password"
        },0) {

            @Override
            public boolean isCellEditable(int row, int column) {
                //all cells false
                return false;
            }
        };

        List<StudentEntity> students = StudentDAO.getAllStudent();
        for (var student:students){
            String MSSV = student.getMssv();
            String Name = student.getStudentName();
            String Gender = student.getGender();
            Date DoB = student.getDateOfBitrh();
            String Address = student.getAddress();
            String Phone = student.getPhone();
            String Clazz = student.getClazzByClazz()!=null ? student.getClazzByClazz().getClassName() :"";
            String Username = student.getUsername();
            String Password = student.getPassword();

            Object[] data = new Object[] {MSSV, Name, Gender,DoB, Address, Phone, Clazz,Username, Password};
            tableModel.addRow(data);
        }

        table_2.setModel(tableModel);
        table_2.getColumnModel().getColumn(1).setPreferredWidth(69);
        table_2.getColumnModel().getColumn(2).setPreferredWidth(84);
        table_2.getColumnModel().getColumn(6).setPreferredWidth(90);
        table_2.getColumnModel().getColumn(8).setPreferredWidth(100);
        
        table_2.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                txtMSSV.setText(table_2.getValueAt(table_2.getSelectedRow(),0).toString());
                txtName.setText(table_2.getValueAt(table_2.getSelectedRow(),1).toString());
                txtGender.setText(table_2.getValueAt(table_2.getSelectedRow(),2).toString());
                txtDoB.setText(table_2.getValueAt(table_2.getSelectedRow(),3).toString());
                txtAddress.setText(table_2.getValueAt(table_2.getSelectedRow(),4).toString());
                txtPhone.setText(table_2.getValueAt(table_2.getSelectedRow(),5).toString());
                txtClass.setText(table_2.getValueAt(table_2.getSelectedRow(),6).toString());
                txtUsername.setText(table_2.getValueAt(table_2.getSelectedRow(),7).toString());
                Password.setText(table_2.getValueAt(table_2.getSelectedRow(),8).toString());
            }
        });

        JPopupMenu popupMenu = new JPopupMenu();
        addPopup(table_2, popupMenu);

        JMenuItem itmenuNew = new JMenuItem("New");
        popupMenu.add(itmenuNew);

        JMenuItem itmenuEdit = new JMenuItem("Edit");
        popupMenu.add(itmenuEdit);

        JMenuItem itmenuDelete = new JMenuItem("Delete");
        popupMenu.add(itmenuDelete);


        JButton btnNewStudent = new JButton("New Student");
        btnNewStudent.setBounds(360, 288, 115, 21);
        contentPane.add(btnNewStudent);

        JPanel panel = new JPanel();
        panel.setLayout(null);
        panel.setBounds(541, 53, 221, 254);
        contentPane.add(panel);

        JLabel lbID = new JLabel("MSSV");
        lbID.setBounds(0, 1, 125, 18);
        panel.add(lbID);

        txtMSSV = new JTextField();
        txtMSSV.setColumns(10);
        txtMSSV.setBounds(95, 1, 125, 18);
        panel.add(txtMSSV);

        JLabel lblNewLabel_1 = new JLabel("Student Name");
        lblNewLabel_1.setBounds(0, 29, 125, 18);
        panel.add(lblNewLabel_1);

        txtName = new JTextField();
        txtName.setColumns(10);
        txtName.setBounds(95, 29, 125, 18);
        panel.add(txtName);

        JLabel lblNewLabel_2 = new JLabel("Gender");
        lblNewLabel_2.setBounds(0, 57, 125, 18);
        panel.add(lblNewLabel_2);

        txtGender = new JTextField();
        txtGender.setColumns(10);
        txtGender.setBounds(95, 57, 125, 18);
        panel.add(txtGender);

        JLabel lblNewLabel_3 = new JLabel("Date of birth");
        lblNewLabel_3.setBounds(0, 85, 125, 18);
        panel.add(lblNewLabel_3);

        txtDoB = new JTextField();
        txtDoB.setColumns(10);
        txtDoB.setBounds(95, 85, 125, 18);
        panel.add(txtDoB);

        JLabel lblNewLabel_3_1 = new JLabel("Address");
        lblNewLabel_3_1.setBounds(0, 113, 125, 18);
        panel.add(lblNewLabel_3_1);

        txtAddress = new JTextField();
        txtAddress.setColumns(10);
        txtAddress.setBounds(95, 113, 125, 18);
        panel.add(txtAddress);

        JLabel lblNewLabel_3_2 = new JLabel("Phone");
        lblNewLabel_3_2.setBounds(0, 141, 125, 18);
        panel.add(lblNewLabel_3_2);

        txtPhone = new JTextField();
        txtPhone.setColumns(10);
        txtPhone.setBounds(95, 141, 125, 18);
        panel.add(txtPhone);

        JLabel lblNewLabel_3_3 = new JLabel("Class");
        lblNewLabel_3_3.setBounds(0, 170, 125, 18);
        panel.add(lblNewLabel_3_3);

        txtClass = new JTextField();
        txtClass.setColumns(10);
        txtClass.setBounds(95, 170, 125, 18);
        panel.add(txtClass);

        JLabel lblNewLabel_3_4 = new JLabel("Username");
        lblNewLabel_3_4.setBounds(0, 198, 125, 18);
        panel.add(lblNewLabel_3_4);

        txtUsername = new JTextField();
        txtUsername.setColumns(10);
        txtUsername.setBounds(95, 198, 125, 18);
        panel.add(txtUsername);

        JLabel lblNewLabel_3_5 = new JLabel("Password");
        lblNewLabel_3_5.setBounds(0, 226, 125, 18);
        panel.add(lblNewLabel_3_5);

        Password = new JTextField();
        Password.setColumns(10);
        Password.setBounds(95, 226, 125, 18);
        panel.add(Password);

        JButton btnExit = new JButton("Exit");
        btnExit.setBounds(10, 318, 85, 21);
        contentPane.add(btnExit);

        btnExit.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                jFrame.setContentPane(new PanelMainScreenTeacher(jFrame));
                jFrame.setVisible(true);
            }
        });

        JButton btnSave = new JButton("Save");
        btnSave.setBounds(677, 318, 85, 21);
        contentPane.add(btnSave);
        btnSave.setEnabled(false);

        JMenuBar menuBar = new JMenuBar();
        menuBar.setBackground(SystemColor.textHighlight);
        menuBar.setBounds(0, 0, 772, 22);
        contentPane.add(menuBar);

        JButton btnResetPassword = new JButton("Reset password");
        btnResetPassword.setBounds(551, 318, 116, 21);
        contentPane.add(btnResetPassword);

        JLabel lblNewLabel = new JLabel("Student Information");
        lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 13));
        lblNewLabel.setBounds(542, 22, 147, 21);
        contentPane.add(lblNewLabel);

        txtSearch = new JTextField();
        txtSearch.setColumns(10);
        txtSearch.setBounds(61, 32, 96, 19);
        contentPane.add(txtSearch);

        JLabel lblNewLabel_4 = new JLabel("Student");
        lblNewLabel_4.setBounds(10, 33, 45, 13);
        contentPane.add(lblNewLabel_4);

        JButton btnSearch = new JButton("Search");
        btnSearch.setBounds(167, 32, 65, 21);
        contentPane.add(btnSearch);

        JComboBox comboBox = new JComboBox(ClassDAO.getAllClassName());
        comboBox.setEditable(true);
        comboBox.setBounds(379, 32, 96, 21);
        contentPane.add(comboBox);


        JLabel lblNewLabel_5 = new JLabel("Class");
        lblNewLabel_5.setHorizontalAlignment(SwingConstants.LEFT);
        lblNewLabel_5.setBounds(348, 35, 36, 13);
        contentPane.add(lblNewLabel_5);

        txtMSSV.setEditable(false);
        txtName.setEditable(false);
        txtGender.setEditable(false);
        txtDoB.setEditable(false);
        txtAddress.setEditable(false);
        txtPhone.setEditable(false);
        txtClass.setEditable(false);
        txtUsername.setEditable(false);
        Password.setEditable(false);
    }
    private static void addPopup(Component component, final JPopupMenu popup) {
        component.addMouseListener(new MouseAdapter() {
            public void mousePressed(MouseEvent e) {
                if (e.isPopupTrigger()) {
                    showMenu(e);
                }
            }
            public void mouseReleased(MouseEvent e) {
                if (e.isPopupTrigger()) {
                    showMenu(e);
                }
            }
            private void showMenu(MouseEvent e) {
                popup.show(e.getComponent(), e.getX(), e.getY());
            }
        });
    }
}
