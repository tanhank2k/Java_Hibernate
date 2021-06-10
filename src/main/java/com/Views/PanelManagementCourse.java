package com.Views;

import com.DAO.CourseDAO;
import com.Model.CourseEntity;

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
import java.util.List;

public class PanelManagementCourse extends JPanel {
    private JTextField txtID;
    private JTextField txtSubjectCode;
    private JTextField txtSubjectName;
    private JTextField txtNoC;
    private JTextField txtTeacherName;
    private JTextField txtRoom;
    private JTextField txtDoS;
    private JTextField txtPeriod;
    private JTextField txtStudentMax;
    private JTextField txtYear;
    private JTextField txtCourse;
    private JTextField txtStudentMaxCurr;

    /**
     * Create the panel.
     */
    public PanelManagementCourse(JFrame jFrame) {
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
                "ID", "Subject Code", "Subject Name", "Number of Credits", "Teacher Name", "Room Name", "Date on School", "Period", "Student Max"
        },0) {

            @Override
            public boolean isCellEditable(int row, int column) {
                //all cells false
                return false;
            }
        };

        List<CourseEntity> courses = CourseDAO.getAllCourse();
        for (var course:courses) {
            int id = course.getId();
            String subCode = course.getSubjectCode();
            String subName = course.getSubjectName();
            int NoC = course.getNumberOfCredits();
            String teacherName = course.getTeacherName();
            String roomName = course.getRoomName();
            String DoS = course.getDateOnSchool();
            int period = course.getPeriod();
            int studentMax = course.getStudentMaximum();


            Object [] data = new Object[] {id, subCode, subName,NoC,teacherName,roomName,DoS,period,studentMax};
            tableModel.addRow(data);

        }
        table_2.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                txtID.setText(table_2.getValueAt(table_2.getSelectedRow(),0).toString());
                txtSubjectCode.setText(table_2.getValueAt(table_2.getSelectedRow(),1).toString());
                txtSubjectName.setText(table_2.getValueAt(table_2.getSelectedRow(),2).toString());
                txtNoC.setText(table_2.getValueAt(table_2.getSelectedRow(),3).toString());
                txtTeacherName.setText(table_2.getValueAt(table_2.getSelectedRow(),4).toString());
                txtRoom.setText(table_2.getValueAt(table_2.getSelectedRow(),5).toString());
                txtDoS.setText(table_2.getValueAt(table_2.getSelectedRow(),6).toString());
                txtPeriod.setText(table_2.getValueAt(table_2.getSelectedRow(),7).toString());
                txtStudentMax.setText(table_2.getValueAt(table_2.getSelectedRow(),8).toString());

            }
        });

        table_2.setModel(tableModel);
        table_2.getColumnModel().getColumn(1).setPreferredWidth(69);
        table_2.getColumnModel().getColumn(2).setPreferredWidth(84);
        table_2.getColumnModel().getColumn(8).setPreferredWidth(100);

        JPopupMenu popupMenu = new JPopupMenu();
        addPopup(table_2, popupMenu);

        JMenuItem itmenuNew = new JMenuItem("New");
        itmenuNew.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
            }
        });
        popupMenu.add(itmenuNew);

        JMenuItem itmenuEdit = new JMenuItem("Edit");
        itmenuEdit.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
            }
        });
        popupMenu.add(itmenuEdit);

        JMenuItem itmenuDelete = new JMenuItem("Delete");
        itmenuDelete.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
            }
        });
        popupMenu.add(itmenuDelete);


        JButton btnNewCourse = new JButton("New Course");
        btnNewCourse.setBounds(360, 288, 115, 21);
        contentPane.add(btnNewCourse);

        JPanel panel = new JPanel();
        panel.setLayout(null);
        panel.setBounds(541, 40, 221, 273);
        contentPane.add(panel);

        JLabel lbID = new JLabel("ID");
        lbID.setBounds(0, 1, 125, 18);
        panel.add(lbID);

        txtID = new JTextField();
        txtID.setColumns(10);
        txtID.setBounds(95, 1, 125, 18);
        panel.add(txtID);

        JLabel lblNewLabel_1 = new JLabel("Subject Code");
        lblNewLabel_1.setBounds(0, 29, 125, 18);
        panel.add(lblNewLabel_1);

        txtSubjectCode = new JTextField();
        txtSubjectCode.setColumns(10);
        txtSubjectCode.setBounds(95, 29, 125, 18);
        panel.add(txtSubjectCode);

        JLabel lblNewLabel_2 = new JLabel("Subject Name");
        lblNewLabel_2.setBounds(0, 57, 125, 18);
        panel.add(lblNewLabel_2);

        txtSubjectName = new JTextField();
        txtSubjectName.setColumns(10);
        txtSubjectName.setBounds(95, 57, 125, 18);
        panel.add(txtSubjectName);

        JLabel lblNewLabel_3 = new JLabel("Number of credits");
        lblNewLabel_3.setBounds(0, 85, 125, 18);
        panel.add(lblNewLabel_3);

        txtNoC = new JTextField();
        txtNoC.setColumns(10);
        txtNoC.setBounds(95, 85, 125, 18);
        panel.add(txtNoC);

        JLabel lblNewLabel_3_1 = new JLabel("Teacher Name");
        lblNewLabel_3_1.setBounds(0, 113, 125, 18);
        panel.add(lblNewLabel_3_1);

        txtTeacherName = new JTextField();
        txtTeacherName.setColumns(10);
        txtTeacherName.setBounds(95, 113, 125, 18);
        panel.add(txtTeacherName);

        JLabel lblNewLabel_3_2 = new JLabel("Room Name");
        lblNewLabel_3_2.setBounds(0, 141, 125, 18);
        panel.add(lblNewLabel_3_2);

        txtRoom = new JTextField();
        txtRoom.setColumns(10);
        txtRoom.setBounds(95, 141, 125, 18);
        panel.add(txtRoom);

        JLabel lblNewLabel_3_3 = new JLabel("Date On School");
        lblNewLabel_3_3.setBounds(0, 170, 125, 18);
        panel.add(lblNewLabel_3_3);

        txtDoS = new JTextField();
        txtDoS.setColumns(10);
        txtDoS.setBounds(95, 170, 125, 18);
        panel.add(txtDoS);

        JLabel lblNewLabel_3_4 = new JLabel("Period");
        lblNewLabel_3_4.setBounds(0, 198, 125, 18);
        panel.add(lblNewLabel_3_4);

        txtPeriod = new JTextField();
        txtPeriod.setColumns(10);
        txtPeriod.setBounds(95, 198, 125, 18);
        panel.add(txtPeriod);

        JLabel lblNewLabel_3_5 = new JLabel("Student Maximum");
        lblNewLabel_3_5.setBounds(0, 226, 125, 18);
        panel.add(lblNewLabel_3_5);

        txtStudentMax = new JTextField();
        txtStudentMax.setColumns(10);
        txtStudentMax.setBounds(95, 226, 125, 18);
        panel.add(txtStudentMax);


        JButton btnExit = new JButton("Exit");
        btnExit.setBounds(10, 328, 85, 21);
        contentPane.add(btnExit);

        JButton btnSave = new JButton("Save");
        btnSave.setBounds(677, 328, 85, 21);
        contentPane.add(btnSave);

        JMenuBar menuBar = new JMenuBar();
        menuBar.setBackground(SystemColor.textHighlight);
        menuBar.setBounds(0, 0, 772, 22);
        contentPane.add(menuBar);

        JLabel lblNewLabel = new JLabel("Course Information");
        lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 13));
        lblNewLabel.setBounds(542, 22, 147, 21);
        contentPane.add(lblNewLabel);

        txtCourse = new JTextField();
        txtCourse.setColumns(10);
        txtCourse.setBounds(61, 32, 96, 19);
        contentPane.add(txtCourse);

        JLabel lblNewLabel_4 = new JLabel("Course");
        lblNewLabel_4.setBounds(10, 33, 45, 13);
        contentPane.add(lblNewLabel_4);

        JButton btnSearch = new JButton("Search");
        btnSearch.setBounds(167, 32, 65, 21);
        contentPane.add(btnSearch);

        JLabel lblNewLabel_5 = new JLabel("Semester");
        lblNewLabel_5.setHorizontalAlignment(SwingConstants.RIGHT);
        lblNewLabel_5.setBounds(296, 35, 45, 13);
        contentPane.add(lblNewLabel_5);

          txtStudentMaxCurr = new JTextField();
          txtStudentMaxCurr.setEditable(false);
          txtStudentMaxCurr.setColumns(10);
          txtStudentMaxCurr.setBounds(344, 32, 50, 19);
        contentPane.add(  txtStudentMaxCurr);

        JButton btnCancel = new JButton("Cancel");
        btnCancel.setBounds(582, 328, 85, 21);
        contentPane.add(btnCancel);


        JLabel lblNewLabel_5_1 = new JLabel("Year");
        lblNewLabel_5_1.setHorizontalAlignment(SwingConstants.CENTER);
        lblNewLabel_5_1.setBounds(404, 35, 31, 13);
        contentPane.add(lblNewLabel_5_1);

        txtYear = new JTextField();
        txtYear.setEditable(false);
        txtYear.setColumns(10);
        txtYear.setBounds(438, 32, 50, 19);
        contentPane.add(txtYear);

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
