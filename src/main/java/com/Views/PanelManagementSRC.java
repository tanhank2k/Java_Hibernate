package com.Views;
import com.DAO.CourseDAO;
import com.DAO.SRC_DAO;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import java.awt.SystemColor;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.Component;
import java.awt.Font;
import java.util.Date;
import java.util.List;

public class PanelManagementSRC extends JPanel {
    private JTextField txtMSSV;
    private JTextField txtStudentName;
    private JTextField txtSubjectCode;
    private JTextField txtSubjectName;
    private JTextField txtTeacherName;
    private JTextField txtStudyTime;
    private JTextField txtRegistrationTime;
    private JTextField txtStudent;

    /**
     * Create the panel.
     */
    public PanelManagementSRC(JFrame jFrame) {
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
        table_2.setModel(new DefaultTableModel(
                new Object[][] {
                        {null, "", null, null, null, null, null},
                        {null, null, null, null, null, null, null},
                        {"", null, null, null, null, null, null},
                        {null, null, null, null, null, null, null},
                        {"", null, null, null, null, null, null},
                },
                new String[] {
                        "MSSV", "Student Name", "Subject Code", "Subject Name", "Teacher Name", "Study Time", "Registration Time"
                }
        ));
        table_2.getColumnModel().getColumn(0).setPreferredWidth(69);
        table_2.getColumnModel().getColumn(1).setPreferredWidth(84);
        table_2.getColumnModel().getColumn(6).setPreferredWidth(115);

        DefaultTableModel tableModel = (DefaultTableModel) table_2.getModel();

        List<Object[]> students = SRC_DAO.getStudentInCourse("5");
        tableModel.setRowCount(0);
        for (Object[] student:students) {
            int mssv = (int)student[0];
            String subName = (String) student[2];
            String subCode = (String) student[3];
            String teacherName = (String) student[4];
            String StudyTime = (String) student[5];
            Date RegistrationTime = (Date) student[6];
            String studentName = (String) student[1];



            Object [] data = new Object[] {mssv,studentName,subName,subCode,teacherName,StudyTime,RegistrationTime};
            tableModel.addRow(data);
            tableModel.fireTableDataChanged();
        }

        JPopupMenu popupMenu = new JPopupMenu();
        addPopup(table_2, popupMenu);

        JMenuItem itmenuNew = new JMenuItem("New");
        popupMenu.add(itmenuNew);

        JMenuItem itmenuEdit = new JMenuItem("Edit");
        popupMenu.add(itmenuEdit);

        JMenuItem itmenuDelete = new JMenuItem("Delete");
        popupMenu.add(itmenuDelete);

        JPanel panel = new JPanel();
        panel.setLayout(null);
        panel.setBounds(541, 53, 221, 205);
        contentPane.add(panel);

        JLabel lbMSSV = new JLabel("MSSV");
        lbMSSV.setBounds(0, 1, 125, 18);
        panel.add(lbMSSV);

        txtMSSV = new JTextField();
        txtMSSV.setEditable(false);
        txtMSSV.setColumns(10);
        txtMSSV.setBounds(95, 1, 125, 18);
        panel.add(txtMSSV);

        JLabel lblNewLabel_1 = new JLabel("Student Name");
        lblNewLabel_1.setBounds(0, 29, 125, 18);
        panel.add(lblNewLabel_1);

        txtStudentName = new JTextField();
        txtStudentName.setEditable(false);
        txtStudentName.setColumns(10);
        txtStudentName.setBounds(95, 29, 125, 18);
        panel.add(txtStudentName);

        JLabel lblNewLabel_2 = new JLabel("Subject Code");
        lblNewLabel_2.setBounds(0, 57, 125, 18);
        panel.add(lblNewLabel_2);

        txtSubjectCode = new JTextField();
        txtSubjectCode.setEditable(false);
        txtSubjectCode.setColumns(10);
        txtSubjectCode.setBounds(95, 57, 125, 18);
        panel.add(txtSubjectCode);

        JLabel lblNewLabel_3 = new JLabel("Subject Name");
        lblNewLabel_3.setBounds(0, 85, 125, 18);
        panel.add(lblNewLabel_3);

        txtSubjectName = new JTextField();
        txtSubjectName.setEditable(false);
        txtSubjectName.setColumns(10);
        txtSubjectName.setBounds(95, 85, 125, 18);
        panel.add(txtSubjectName);

        JLabel lblNewLabel_3_1 = new JLabel("Teacher Name");
        lblNewLabel_3_1.setBounds(0, 113, 125, 18);
        panel.add(lblNewLabel_3_1);

        txtTeacherName = new JTextField();
        txtTeacherName.setEditable(false);
        txtTeacherName.setColumns(10);
        txtTeacherName.setBounds(95, 113, 125, 18);
        panel.add(txtTeacherName);

        JLabel lblNewLabel_3_2 = new JLabel("Study Time");
        lblNewLabel_3_2.setBounds(0, 141, 125, 18);
        panel.add(lblNewLabel_3_2);

        txtStudyTime = new JTextField();
        txtStudyTime.setEditable(false);
        txtStudyTime.setColumns(10);
        txtStudyTime.setBounds(95, 141, 125, 18);
        panel.add(txtStudyTime);

        JLabel lblNewLabel_3_3 = new JLabel("Registration Time");
        lblNewLabel_3_3.setBounds(0, 170, 125, 18);
        panel.add(lblNewLabel_3_3);

        txtRegistrationTime = new JTextField();
        txtRegistrationTime.setEditable(false);
        txtRegistrationTime.setColumns(10);
        txtRegistrationTime.setBounds(95, 170, 125, 18);
        panel.add(txtRegistrationTime);

        JButton btnExit = new JButton("Exit");
        btnExit.setBounds(677, 318, 85, 21);
        contentPane.add(btnExit);



        JLabel lblNewLabel = new JLabel("Information");
        lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 13));
        lblNewLabel.setBounds(542, 22, 147, 21);
        contentPane.add(lblNewLabel);

        txtStudent = new JTextField();
        txtStudent.setColumns(10);
        txtStudent.setBounds(61, 32, 96, 19);
        contentPane.add(txtStudent);

        JLabel lblNewLabel_4 = new JLabel("Student");
        lblNewLabel_4.setBounds(10, 33, 45, 13);
        contentPane.add(lblNewLabel_4);

        JButton btnSearch = new JButton("Search");
        btnSearch.setBounds(167, 32, 65, 21);
        contentPane.add(btnSearch);

        JComboBox comboBox = new JComboBox();
        comboBox.setEditable(true);
        comboBox.setBounds(410, 32, 65, 21);
        contentPane.add(comboBox);

        JLabel lblNewLabel_5 = new JLabel("Course");
        lblNewLabel_5.setHorizontalAlignment(SwingConstants.RIGHT);
        lblNewLabel_5.setBounds(360, 35, 45, 13);
        contentPane.add(lblNewLabel_5);

        btnExit.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                jFrame.setContentPane(new PanelMainScreenTeacher(jFrame));
                jFrame.setVisible(true);
            }
        });

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
