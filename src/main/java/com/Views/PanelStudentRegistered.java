package com.Views;

import com.Service.RegistrationCourse;

import javax.swing.*;

import javax.swing.JPanel;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;

import javax.swing.table.DefaultTableModel;

public class PanelStudentRegistered extends JPanel {
    private JTextField txtCourse;
    private JTextField txtSemester;
    private JTextField txtSlelected;

    /**
     * Create the panel.
     */
    public PanelStudentRegistered(JFrame jFrame, int idStudent) {
        setLayout(null);

        JScrollPane scrollPane = new JScrollPane();
        scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
        scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
        scrollPane.setBounds(10, 56, 752, 222);
        add(scrollPane);

        JTable table_2 = new JTable();
        table_2.setToolTipText("");
        table_2.setSurrendersFocusOnKeystroke(true);
        table_2.setColumnSelectionAllowed(true);
        table_2.setCellSelectionEnabled(true);
        table_2.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        table_2.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
            }
        });
        scrollPane.setViewportView(table_2);
        table_2.setModel(new DefaultTableModel(
                new Object[][] {
                        {null, null, "", null, null, null, null, null, null},
                        {null, null, null, null, null, null, null, null, null},
                        {null, "", null, null, null, null, null, null, null},
                        {null, null, null, null, null, null, null, null, null},
                        {null, "", null, null, null, null, null, null, null},
                },
                new String[] {
                        "CourseID", "Subject Code", "Subject Name", "Credits", "Teacher Name", "Room", "Date on School", "Period", "Limited"
                }
        ));
        table_2.getColumnModel().getColumn(1).setPreferredWidth(69);
        table_2.getColumnModel().getColumn(2).setPreferredWidth(84);

        DefaultTableModel tableModel = (DefaultTableModel) table_2.getModel();

        List<Object[]> courses = RegistrationCourse.getCourseRegisteredCurr_SRC(String.valueOf(idStudent));

        tableModel.setRowCount(0);
        for (Object[] course:courses) {
            int id = (int) course[0];
            String subCode = (String) course[6];
            String subName = (String) course[7];
            int NoC = (int) course[2];
            String teacherName = (String) course[8];
            String roomName = (String) course[4];
            String DoS = (String) course[1];
            int period = (int) course[3];
            int studentMax = (int) course[5];


            Object [] data = new Object[] {id, subCode, subName,NoC,teacherName,roomName,DoS,period,studentMax};
            tableModel.addRow(data);
            tableModel.fireTableDataChanged();}
        JButton btnExit = new JButton("Exit");
        btnExit.setBounds(581, 328, 85, 21);
        add(btnExit);

        JButton btnSave = new JButton("Save");
        btnSave.setBounds(677, 328, 85, 21);
        add(btnSave);

        txtCourse = new JTextField();
        txtCourse.setColumns(10);
        txtCourse.setBounds(61, 32, 96, 19);
        add(txtCourse);

        JLabel lblNewLabel_4 = new JLabel("Course");
        lblNewLabel_4.setBounds(10, 33, 45, 13);
        add(lblNewLabel_4);

        JButton btnSearch = new JButton("Search");
        btnSearch.setBounds(167, 32, 65, 21);
        add(btnSearch);

        JLabel lblNewLabel_5 = new JLabel("Semester");
        lblNewLabel_5.setHorizontalAlignment(SwingConstants.RIGHT);
        lblNewLabel_5.setBounds(639, 35, 45, 13);
        add(lblNewLabel_5);

        txtSemester = new JTextField();
        txtSemester.setEditable(false);
        txtSemester.setColumns(10);
        txtSemester.setBounds(692, 32, 70, 19);
        add(txtSemester);

        JLabel lblNewLabel = new JLabel("Number of Registration Course ");
        lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
        lblNewLabel.setBounds(540, 291, 162, 13);
        add(lblNewLabel);

        txtSlelected = new JTextField();
        txtSlelected.setColumns(10);
        txtSlelected.setBounds(712, 288, 50, 19);
        add(txtSlelected);

        txtSlelected.setText(String.valueOf(courses.size()));


        btnExit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                jFrame.dispose();
                PanelMainStudent mainStudent = new PanelMainStudent(idStudent);
                mainStudent.setVisible(true);
            }
        });

    }

    public void Reload (DefaultTableModel tableModel, String idStudent){
        List<Object[]> courses = RegistrationCourse.getCourseRegisteredCurr_SRC(idStudent);
        tableModel.setRowCount(0);
        for (Object[] course:courses) {
            int id = (int) course[0];
            String subCode = (String) course[6];
            String subName = (String) course[7];
            int NoC = (int) course[2];
            String teacherName = (String) course[8];
            String roomName = (String) course[4];
            String DoS = (String) course[1];
            int period = (int) course[3];
            int studentMax = (int) course[5];

            Object [] data = new Object[] {id, subCode, subName,NoC,teacherName,roomName,DoS,period,studentMax};
            tableModel.addRow(data);
            tableModel.fireTableDataChanged();
        }
    }
}