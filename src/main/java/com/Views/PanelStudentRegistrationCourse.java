package com.Views;

import com.DAO.CourseDAO;
import com.DAO.SRC_DAO;
import com.Service.RegistrationCourse;

import javax.swing.*;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.List;

import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;

public class PanelStudentRegistrationCourse extends JPanel {
    private JTextField txtCourse;
    private JTextField txtSemester;
    private JTextField txtSlelected;

    /**
     * Create the panel.
     */
    public PanelStudentRegistrationCourse(JFrame jFrame, int IDStudent) {
        setLayout(null);

        JScrollPane scrollPane = new JScrollPane();
        scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
        scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
        scrollPane.setBounds(10, 56, 752, 222);
        add(scrollPane);

        JTable table_2 = new JTable();

        table_2.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);
        table_2.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
            }
        });
        scrollPane.setViewportView(table_2);
        table_2.setModel(new DefaultTableModel(
                new Object[][] {
                        {null,null, null, "", null, null, null, null, null, null},
                        {null,null, null, null, null, null, null, null, null, null},
                        {null,null, "", null, null, null, null, null, null, null},
                        {null,null, null, null, null, null, null, null, null, null},
                        {null,null, "", null, null, null, null, null, null, null},
                },new String[] {
                        "Registration","CourseID","Subject Code", "Subject Name", "Credits", "Teacher Name", "Room", "Date on School", "Period", "Limited"
                }
        ) {
            Class[] columnTypes = new Class[] {
                    Boolean.class, Object.class,Object.class, Object.class, Object.class, Object.class, Object.class, Object.class, Object.class, Object.class
            };
            public Class getColumnClass(int columnIndex) {
                return columnTypes[columnIndex];
            }
            boolean[] columnEditables = new boolean[] {
                    true, false, false,false, false, false, false, false, false, false
            };
            public boolean isCellEditable(int row, int column) {
                return columnEditables[column];
            }
        });
        DefaultTableModel tableModel = (DefaultTableModel) table_2.getModel();
        List<Object[]> courses = RegistrationCourse.getAllCourseInCurr_SRC("1");
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


            Object [] data = new Object[] {false,id, subCode, subName,NoC,teacherName,roomName,DoS,period,studentMax};
            tableModel.addRow(data);
            tableModel.fireTableDataChanged();
        }

        //table_2.setModel(tableModel);
        table_2.getColumnModel().getColumn(1).setPreferredWidth(69);
        table_2.getColumnModel().getColumn(2).setPreferredWidth(84);


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
        lblNewLabel.setBounds(520, 291, 182, 13);
        add(lblNewLabel);

        txtSlelected = new JTextField();
        txtSlelected.setColumns(10);
        txtSlelected.setBounds(712, 288, 50, 19);
        add(txtSlelected);

        table_2.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                txtSlelected.setText(String.valueOf(getIndexSelected(table_2).size()));
            }
        });


        btnSave.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                List selecteds = getIndexSelected(table_2);
                List<Object[]> registered = RegistrationCourse.getCourseRegisteredCurr_SRC("1");

                if (selecteds.size() + registered.size()>3){

                    JOptionPane.showMessageDialog(jFrame,"Students can register up to 8 subjects");
                }
                else{
                    for (int i=0;i< selecteds.size();i++){
                        String subCode = table_2.getValueAt((Integer) selecteds.get(i),2).toString();
                        String courseID =  table_2.getValueAt((Integer) selecteds.get(i),1).toString();
                        SRC_DAO.AddNewSRC(1,subCode,courseID);
                    }

                }

                Reload(tableModel,"1");
            }
        });

        btnExit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                jFrame.dispose();
                PanelMainStudent mainStudent = new PanelMainStudent(IDStudent);
                mainStudent.setVisible(true);
            }
        });

    }

    public List getIndexSelected(JTable table){
        List indexs = new ArrayList();
        for (int i=0;i<table.getModel().getRowCount();i++){
            if (table.getValueAt(i,0)!=null){
                if (table.getValueAt(i,0).toString().equals("true")){
                    indexs.add(i);
                }
            }

        }

        return indexs;
    }

    public void Reload(DefaultTableModel tableModel, String idStudent){
        List<Object[]> courses = RegistrationCourse.getAllCourseInCurr_SRC(idStudent);
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


            Object [] data = new Object[] {false,id, subCode, subName,NoC,teacherName,roomName,DoS,period,studentMax};
            tableModel.addRow(data);
            tableModel.fireTableDataChanged();
        }
    }
}
