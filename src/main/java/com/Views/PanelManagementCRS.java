package com.Views;

import com.DAO.CRS_DAO;
import com.DAO.SemesterDAO;
import com.DAO.SubjectDAO;
import com.Model.CourseregistrationsessionEntity;
import com.Model.SubjectEntity;
import lombok.SneakyThrows;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.Component;
import java.awt.Font;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class PanelManagementCRS extends JPanel {
    private JTextField txtID;
    private JTextField txtName;
    private JTextField txtSemester;
    private JTextField txtYear;
    private JTextField txtStart;
    private JTextField txtEnd;
    private JTextField txtSemesterCurr;
    private JTextField txtYearCurr;

    /**
     * Create the panel.
     */
    public PanelManagementCRS(JFrame jFrame) {
        setLayout(null);

        JPanel contentPane = new JPanel();
        contentPane.setLayout(null);
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        contentPane.setBounds(0, 0, 772, 349);
        add(contentPane);

        JScrollPane scrollPane = new JScrollPane();
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
                        "ID", "Name CRS", "Semester", "Year", "Date Start", "Date End"
                },0
        );

        List<CourseregistrationsessionEntity> CRSessions = CRS_DAO.getAllSession();
        Object[] semesterCurr = SemesterDAO.getSemesterCurr();
        String Semester = (String) semesterCurr[4];
        int Year = (int) semesterCurr[5];
        for (var sesseion:CRSessions) {
            int id = sesseion.getId();
            String Name = sesseion.getNameCRS();
            Date start = sesseion.getDateStart();
            Date end = sesseion.getDateEnd();

            Object[] data = {id, Name, Semester, Year,start,end};

            tableModel.addRow(data);

        }

        tableModel.fireTableDataChanged();

        table_2.setModel(tableModel);
        table_2.getColumnModel().getColumn(1).setPreferredWidth(221);
        table_2.getColumnModel().getColumn(2).setPreferredWidth(84);
        table_2.getColumnModel().getColumn(5).setPreferredWidth(100);

        JPopupMenu popupMenu = new JPopupMenu();
        addPopup(table_2, popupMenu);

        JMenuItem itmenuNew = new JMenuItem("New");
        popupMenu.add(itmenuNew);

        JMenuItem itmenuDelete = new JMenuItem("Delete");
        popupMenu.add(itmenuDelete);


        JButton btnNewCRS = new JButton("New CRS");
        btnNewCRS.setBounds(348, 286, 115, 21);
        contentPane.add(btnNewCRS);

        JPanel panel = new JPanel();
        panel.setLayout(null);
        panel.setBounds(541, 53, 221, 183);
        contentPane.add(panel);

        JLabel lbID = new JLabel("ID");
        lbID.setBounds(0, 1, 125, 18);
        panel.add(lbID);

        txtID = new JTextField();
        txtID.setColumns(10);
        txtID.setBounds(95, 1, 125, 18);
        panel.add(txtID);

        JLabel lblNewLabel_1 = new JLabel("Name CRS");
        lblNewLabel_1.setBounds(0, 29, 125, 18);
        panel.add(lblNewLabel_1);

        txtName = new JTextField();
        txtName.setColumns(10);
        txtName.setBounds(95, 29, 125, 18);
        panel.add(txtName);

        JLabel lblNewLabel_2 = new JLabel("Semester");
        lblNewLabel_2.setBounds(0, 57, 125, 18);
        panel.add(lblNewLabel_2);

        txtSemester = new JTextField();
        txtSemester.setColumns(10);
        txtSemester.setBounds(95, 57, 125, 18);
        panel.add(txtSemester);

        JLabel lblNewLabel_3 = new JLabel("Year");
        lblNewLabel_3.setBounds(0, 85, 125, 18);
        panel.add(lblNewLabel_3);

        txtYear = new JTextField();
        txtYear.setColumns(10);
        txtYear.setBounds(95, 85, 125, 18);
        panel.add(txtYear);

        JLabel lblNewLabel_3_1 = new JLabel("Date Start");
        lblNewLabel_3_1.setBounds(0, 113, 125, 18);
        panel.add(lblNewLabel_3_1);

        txtStart = new JTextField();
        txtStart.setColumns(10);
        txtStart.setBounds(95, 113, 125, 18);
        panel.add(txtStart);

        JLabel lblNewLabel_3_2 = new JLabel("Date End");
        lblNewLabel_3_2.setBounds(0, 141, 125, 18);
        panel.add(lblNewLabel_3_2);

        txtEnd = new JTextField();
        txtEnd.setColumns(10);
        txtEnd.setBounds(95, 141, 125, 18);
        panel.add(txtEnd);

        JButton btnExit = new JButton("Exit");
        btnExit.setBounds(677, 328, 85, 21);
        contentPane.add(btnExit);

        JButton btnSave = new JButton("Save");
        btnSave.setBounds(677, 257, 85, 21);
        contentPane.add(btnSave);

        JLabel lblNewLabel = new JLabel("Semester Current");
        lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 13));
        lblNewLabel.setBounds(10, 32, 115, 13);
        contentPane.add(lblNewLabel);

        txtSemesterCurr = new JTextField();
        txtSemesterCurr.setEditable(false);
        txtSemesterCurr.setColumns(10);
        txtSemesterCurr.setBounds(135, 30, 47, 19);
        contentPane.add(txtSemesterCurr);

        JLabel lblNewLabel_4 = new JLabel("Year");
        lblNewLabel_4.setFont(new Font("Tahoma", Font.PLAIN, 13));
        lblNewLabel_4.setBounds(208, 33, 45, 13);
        contentPane.add(lblNewLabel_4);

        txtYearCurr = new JTextField();
        txtYearCurr.setEditable(false);
        txtYearCurr.setColumns(10);
        txtYearCurr.setBounds(248, 30, 47, 19);
        contentPane.add(txtYearCurr);

        JButton btnCancel = new JButton("Cancel");
        btnCancel.setBounds(582, 257, 85, 21);
        contentPane.add(btnCancel);

        setStatus(btnSave, btnCancel, false);
        txtID.setEditable(false);
        txtSemester.setEditable(false);
        txtYear.setEditable(false);

        table_2.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                txtID.setText(table_2.getValueAt(table_2.getSelectedRow(),0).toString());
                txtName.setText(table_2.getValueAt(table_2.getSelectedRow(),1).toString());
                txtSemester.setText(table_2.getValueAt(table_2.getSelectedRow(),2).toString());
                txtYear.setText(table_2.getValueAt(table_2.getSelectedRow(),3).toString());
                txtStart.setText(table_2.getValueAt(table_2.getSelectedRow(),4).toString());
                txtEnd.setText(table_2.getValueAt(table_2.getSelectedRow(),5).toString());
            }
        });
        btnNewCRS.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setText("");
                setStatus(btnSave,btnCancel,true);
                txtSemester.setText(Semester);
                txtYear.setText(String.valueOf(Year));

            }
        });

        btnSave.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String Name = txtName.getText();

                Date start = null;
                try {
                    start = new SimpleDateFormat("yyyy-MM-dd").parse(txtStart.getText());
                } catch (ParseException parseException) {
                    parseException.printStackTrace();
                }
                Date end = null;
                try {
                    end = new SimpleDateFormat("yyyy-MM-dd").parse(txtEnd.getText());
                } catch (ParseException parseException) {
                    parseException.printStackTrace();
                }

                CRS_DAO.AddNewSession(Name,start,end);
                Reload(tableModel);

            }
        });

        btnCancel.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setStatus(btnSave,btnCancel, false);
                setText("");
            }
        });

        btnExit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
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

    public void setStatus(JButton btnSave, JButton btnCancel, boolean status){
        //txtID.setEditable(status);
        txtName.setEditable(status);
        //txtSemester.setEditable(status);
        //txtYear.setEditable(status);
        txtStart.setEditable(status);
        txtEnd.setEditable(status);
        btnSave.setVisible(status);
        btnCancel.setVisible(status);
    }

    public void setText(String str){
        txtID.setText(str);
        txtName.setText(str);
        txtSemester.setText(str);
        txtYear.setText(str);
        txtStart.setText(str);
        txtEnd.setText(str);
    }

    public void Reload(DefaultTableModel tableModel){
        List<CourseregistrationsessionEntity> CRSessions = CRS_DAO.getAllSession();
        tableModel.setRowCount(0);
        Object[] semesterCurr = SemesterDAO.getSemesterCurr();
        String Semester = (String) semesterCurr[4];
        int Year = (int) semesterCurr[5];
        for (var sesseion:CRSessions) {
            int id = sesseion.getId();
            String Name = sesseion.getNameCRS();
            Date start = sesseion.getDateStart();
            Date end = sesseion.getDateEnd();


            Object[] data = {id, Name, Semester, Year,start,end};

            tableModel.addRow(data);

        }
        tableModel.fireTableDataChanged();
    }


}
