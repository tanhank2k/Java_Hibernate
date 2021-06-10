package com.Views;
import com.DAO.SemesterDAO;
import com.DAO.TeacherDAO;
import com.Model.SemesterEntity;
import com.Model.TeacherEntity;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;
import java.awt.SystemColor;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.Font;
import java.awt.Component;
import java.util.Date;
import java.util.List;

public class PanelManagementTeacher extends JPanel {
    private JTable table_2;
    private JTextField txtID;
    private JTextField txtName;
    private JTextField txtDoB;
    private JTextField txtAddress;
    private JTextField txtPhone;
    private JTextField txtPosition;
    private JTextField txtUsername;
    private JTextField txtPassword;
    private JTextField txtSearch;

    /**
     * Create the panel.
     */
    public PanelManagementTeacher(JFrame jFrame) {
        setLayout(null);

        JPanel contentPane = new JPanel();
        contentPane.setLayout(null);
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        contentPane.setBounds(0, 0, 772, 349);
        add(contentPane);

        JScrollPane scrollPane = new JScrollPane();
        scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
        scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
        scrollPane.setBounds(10, 53, 465, 222);



        JTable table_2 = new JTable();
        table_2.setSurrendersFocusOnKeystroke(true);
        table_2.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);
        table_2.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
            }
        });
        List<TeacherEntity> teachers = TeacherDAO.getAllSTeacher();
        DefaultTableModel tableModel = new DefaultTableModel( new String[] {
                "ID", "Teacher Name", "Date of Birth", "Address", "Phone", "Position", "Username", "Password"
        },0) {

            @Override
            public boolean isCellEditable(int row, int column) {
                //all cells false
                return false;
            }
        };
        for (var teacher:teachers) {
            int id = teacher.getId();
            String Name = teacher.getTeacherName();
            Date DoB = teacher.getDateOfBitrh();
            String Address = teacher.getAddress();
            String Phone = teacher.getPhone();
            String Position = teacher.getPosition();
            String Username = teacher.getUsername();
            String Password = teacher.getPassword();


            Object[] data = {id, Name, DoB,Address,Phone, Position, Username, Password};

            tableModel.addRow(data);

        }
        table_2.setModel(tableModel);
        scrollPane.setViewportView(table_2);

        table_2.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                txtID.setText(table_2.getValueAt(table_2.getSelectedRow(),0).toString());
                txtName.setText(table_2.getValueAt(table_2.getSelectedRow(),1).toString());
                txtDoB.setText(table_2.getValueAt(table_2.getSelectedRow(),3).toString());
                txtAddress.setText(table_2.getValueAt(table_2.getSelectedRow(),2).toString());
                txtPhone.setText(table_2.getValueAt(table_2.getSelectedRow(),4).toString());
                txtPosition.setText(table_2.getValueAt(table_2.getSelectedRow(),5).toString());
                txtUsername.setText(table_2.getValueAt(table_2.getSelectedRow(),6).toString());
                txtPassword.setText(table_2.getValueAt(table_2.getSelectedRow(),7).toString());
            }
        });
        table_2.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
        JPopupMenu popupMenu = new JPopupMenu();
        addPopup(table_2, popupMenu);

        JMenuItem itmenuEdit = new JMenuItem("Edit");
        itmenuEdit.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
            }
        });
        popupMenu.add(itmenuEdit);

        JMenuItem itmenuDelete = new JMenuItem("Delete");
        popupMenu.add(itmenuDelete);
        contentPane.add(scrollPane);

        JButton btnNewSubject = new JButton("New Teacher");
        btnNewSubject.setBounds(348, 286, 115, 21);
        contentPane.add(btnNewSubject);


        JPanel panel = new JPanel();
        panel.setLayout(null);
        panel.setBounds(541, 53, 221, 254);
        contentPane.add(panel);

        JLabel lbID = new JLabel("ID");
        lbID.setBounds(0, 1, 125, 18);
        panel.add(lbID);

        txtID = new JTextField();
        txtID.setColumns(10);
        txtID.setBounds(95, 1, 125, 18);
        panel.add(txtID);

        JLabel lblNewLabel_2 = new JLabel("Teacher Name");
        lblNewLabel_2.setBounds(0, 29, 125, 18);
        panel.add(lblNewLabel_2);

        txtName = new JTextField();
        txtName.setColumns(10);
        txtName.setBounds(95, 29, 125, 18);
        panel.add(txtName);

        JLabel lblNewLabel_3 = new JLabel("Date of birth");
        lblNewLabel_3.setBounds(0, 57, 125, 18);
        panel.add(lblNewLabel_3);

        txtDoB = new JTextField();
        txtDoB.setColumns(10);
        txtDoB.setBounds(95, 57, 125, 18);
        panel.add(txtDoB);

        JLabel lblNewLabel_3_1 = new JLabel("Address");
        lblNewLabel_3_1.setBounds(0, 85, 125, 18);
        panel.add(lblNewLabel_3_1);

        txtAddress = new JTextField();
        txtAddress.setColumns(10);
        txtAddress.setBounds(95, 85, 125, 18);
        panel.add(txtAddress);

        JLabel lblNewLabel_3_2 = new JLabel("Phone");
        lblNewLabel_3_2.setBounds(0, 113, 125, 18);
        panel.add(lblNewLabel_3_2);

        txtPhone = new JTextField();
        txtPhone.setColumns(10);
        txtPhone.setBounds(95, 113, 125, 18);
        panel.add(txtPhone);

        JLabel lblNewLabel_3_3 = new JLabel("Position");
        lblNewLabel_3_3.setBounds(0, 142, 125, 18);
        panel.add(lblNewLabel_3_3);

        txtPosition = new JTextField();
        txtPosition.setColumns(10);
        txtPosition.setBounds(95, 142, 125, 18);
        panel.add(txtPosition);

        JLabel lblNewLabel_3_4 = new JLabel("Username");
        lblNewLabel_3_4.setBounds(0, 170, 125, 18);
        panel.add(lblNewLabel_3_4);

        txtUsername = new JTextField();
        txtUsername.setColumns(10);
        txtUsername.setBounds(95, 170, 125, 18);
        panel.add(txtUsername);

        JLabel lblNewLabel_3_5 = new JLabel("Password");
        lblNewLabel_3_5.setBounds(0, 198, 125, 18);
        panel.add(lblNewLabel_3_5);

        txtPassword = new JTextField();
        txtPassword.setColumns(10);
        txtPassword.setBounds(95, 198, 125, 18);
        panel.add(txtPassword);

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
        btnSave.setEnabled(false);
        btnSave.setBounds(677, 318, 85, 21);
        contentPane.add(btnSave);

        JMenuBar menuBar = new JMenuBar();
        menuBar.setBackground(SystemColor.textHighlight);
        menuBar.setBounds(0, 0, 772, 22);
        contentPane.add(menuBar);

        JButton btnResetPassword = new JButton("Reset password");
        btnResetPassword.setBounds(551, 318, 116, 21);
        contentPane.add(btnResetPassword);

        btnResetPassword.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                String Name = btnResetPassword.getText();

                if (Name == "Cancel"){
                    txtID.setEditable(false);
                    txtID.setText("");

                    txtName.setEditable(false);
                    txtName.setText("");

                    txtDoB.setEditable(false);
                    txtDoB.setText("");

                    txtAddress.setEditable(false);
                    txtAddress.setText("");

                    txtPhone.setEditable(false);
                    txtPhone.setText("");

                    txtPosition.setEditable(false);
                    txtPosition.setText("");

                    txtUsername.setEditable(false);
                    txtUsername.setText("");

                    txtPassword.setEditable(false);
                    txtPassword.setText("");

                    txtSearch.setEditable(false);
                    txtSearch.setText("");

                    btnSave.setEnabled(false);
                    btnNewSubject.setEnabled(true);
                    btnResetPassword.setText("Reset password");
                }
            }
        });

        JLabel lblNewLabel = new JLabel("Teacher Information");
        lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 13));
        lblNewLabel.setBounds(542, 22, 147, 21);
        contentPane.add(lblNewLabel);

        JLabel lblNewLabel_1 = new JLabel("Teacher");
        lblNewLabel_1.setBounds(5, 32, 50, 13);
        contentPane.add(lblNewLabel_1);

        txtSearch = new JTextField();
        txtSearch.setBounds(53, 28, 134, 19);
        contentPane.add(txtSearch);
        txtSearch.setColumns(10);

        btnNewSubject.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                txtID.setEditable(true);
                txtID.setText("");

                txtName.setEditable(true);
                txtName.setText("");

                txtDoB.setEditable(true);
                txtDoB.setText("");

                txtAddress.setEditable(true);
                txtAddress.setText("");

                txtPhone.setEditable(true);
                txtPhone.setText("");

                txtPosition.setEditable(true);
                txtPosition.setText("");

                txtUsername.setEditable(true);
                txtUsername.setText("");

                txtPassword.setEditable(true);
                txtPassword.setText("");

                txtSearch.setEditable(true);
                txtSearch.setText("");

                btnSave.setEnabled(true);
                btnNewSubject.setEnabled(false);
                btnResetPassword.setText("Cancel");

            }
        });
        JButton btnSearch = new JButton("Search");
        btnSearch.setBounds(197, 28, 85, 21);
        contentPane.add(btnSearch);

        txtID.setEditable(false);
        txtName.setEditable(false);
        txtDoB.setEditable(false);
        txtAddress.setEditable(false);
        txtPhone.setEditable(false);
        txtPosition.setEditable(false);
        txtUsername.setEditable(false);
        txtPassword.setEditable(false);
        txtSearch.setEditable(false);
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
