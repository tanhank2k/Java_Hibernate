package com.Views;
import com.DAO.SemesterDAO;
import com.Model.SemesterEntity;

import javax.swing.*;
import java.awt.*;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import java.awt.event.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class PanelManagementSemester extends JPanel {
    private JTable table ;
    private JTextField txtID;
    private JTextField txtSemester;
    private JTextField txtYear;
    private JTextField txtDateStart;
    private JTextField txtDateEnd;
    private JTextField txtSemesterCurr;
    private JTextField txtYearCurr;

    /**
     * Create the panel.
     *
     */
    public PanelManagementSemester(JFrame frame) {
        setLayout(null);

        JPanel contentPane = new JPanel();
        contentPane.setLayout(null);
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        contentPane.setBounds(0, 0, 772, 349);
        add(contentPane);

        JScrollPane scrollPane = new JScrollPane();
        scrollPane.setBounds(10, 56, 465, 222);
        contentPane.add(scrollPane);

        table = new JTable();
        scrollPane.setViewportView(table);
        List<SemesterEntity> semesters = SemesterDAO.getAllSemester();
        DefaultTableModel tableModel = new DefaultTableModel(new String[] {
                "ID", "Semester", "Year", "DateStart", "DateEnd"
        },0) {

            @Override
            public boolean isCellEditable(int row, int column) {
                //all cells false
                return false;
            }
        };;
        for (var semester:semesters) {
            int id = semester.getId();
            String Name = semester.getSemesterName();
            int year = semester.getYear();
            Date start = semester.getDateStart();
            Date end = semester.getDateEnd();

            Object[] data = {id, Name, year,start,end};

            tableModel.addRow(data);

        }
        table.setModel(tableModel);
        table.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);

        table.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                txtID.setText(tableModel.getValueAt(table.getSelectedRow(),0).toString());
                txtSemester.setText(tableModel.getValueAt(table.getSelectedRow(),1).toString());
                txtYear.setText(tableModel.getValueAt(table.getSelectedRow(),2).toString());
                txtDateStart.setText(tableModel.getValueAt(table.getSelectedRow(),3).toString());
                txtDateEnd.setText(tableModel.getValueAt(table.getSelectedRow(),4).toString());
            }
        });


        JPopupMenu popupMenu = new JPopupMenu();
        addPopup(table, popupMenu);

        JMenuItem itmenuSetSemesterCurr = new JMenuItem("Set Semester Current");
        popupMenu.add(itmenuSetSemesterCurr);

        JMenuItem itmenuEdit = new JMenuItem("Edit");
        popupMenu.add(itmenuEdit);

        JMenuItem itmenuDelete = new JMenuItem("Delete");
        popupMenu.add(itmenuDelete);


        JPanel panel = new JPanel();
        panel.setLayout(null);
        panel.setBounds(559, 51, 203, 222);
        contentPane.add(panel);

        JLabel lblID = new JLabel("ID ");
        lblID.setHorizontalAlignment(SwingConstants.RIGHT);
        lblID.setBounds(32, 13, 20, 13);
        panel.add(lblID);

        JLabel lblSemester = new JLabel("Semester");
        lblSemester.setHorizontalAlignment(SwingConstants.RIGHT);
        lblSemester.setBounds(-16, 54, 70, 13);
        panel.add(lblSemester);

        JLabel lblYear = new JLabel("Year");
        lblYear.setHorizontalAlignment(SwingConstants.RIGHT);
        lblYear.setBounds(12, 95, 40, 13);
        panel.add(lblYear);

        JLabel lblDatestart = new JLabel("DateStart");
        lblDatestart.setHorizontalAlignment(SwingConstants.RIGHT);
        lblDatestart.setBounds(-5, 136, 60, 13);
        panel.add(lblDatestart);

        JLabel lblDateend = new JLabel("DateEnd");
        lblDateend.setHorizontalAlignment(SwingConstants.RIGHT);
        lblDateend.setBounds(-8, 177, 60, 13);
        panel.add(lblDateend);

        txtID = new JTextField();
        txtID.setColumns(10);
        txtID.setBounds(62, 10, 131, 19);
        panel.add(txtID);

        txtSemester = new JTextField();
        txtSemester.setColumns(10);
        txtSemester.setBounds(62, 51, 131, 19);
        panel.add(txtSemester);

        txtYear = new JTextField();
        txtYear.setColumns(10);
        txtYear.setBounds(62, 92, 131, 19);
        panel.add(txtYear);

        txtDateStart = new JTextField();
        txtDateStart.setColumns(10);
        txtDateStart.setBounds(62, 133, 131, 19);
        panel.add(txtDateStart);

        txtDateEnd = new JTextField();
        txtDateEnd.setColumns(10);
        txtDateEnd.setBounds(62, 174, 131, 19);
        panel.add(txtDateEnd);

        txtID.setEditable(false);
        txtSemester.setEditable(false);
        txtYear.setEditable(false);
        txtDateStart.setEditable(false);
        txtDateEnd.setEditable(false);


        JLabel lblNewLabel = new JLabel("Semester Current ");
        lblNewLabel.setBounds(10, 32, 110, 13);
        contentPane.add(lblNewLabel);

        txtSemesterCurr = new JTextField();
        txtSemesterCurr.setBounds(120, 29, 96, 19);
        contentPane.add(txtSemesterCurr);
        txtSemesterCurr.setColumns(10);
        txtSemesterCurr.setEditable(false);

        JLabel lblYear_1 = new JLabel("Year");
        lblYear_1.setBounds(288, 33, 49, 13);
        contentPane.add(lblYear_1);

        txtYearCurr = new JTextField();
        txtYearCurr.setColumns(10);
        txtYearCurr.setBounds(322, 32, 68, 19);
        txtYearCurr.setEditable(false);
        contentPane.add(txtYearCurr);

        Object[] semesterCurr = SemesterDAO.getSemesterCurr();
        if (semesterCurr.length>0){
            txtSemesterCurr.setText(semesterCurr[4].toString());
            txtYearCurr.setText(semesterCurr[5].toString());
        }

        JButton btnCreate = new JButton("New Semester");
        btnCreate.setMargin(new Insets(2, 2, 2, 2));
        btnCreate.setBounds(375, 287, 100, 21);
        contentPane.add(btnCreate);

        JButton btnExit = new JButton("Exit");
        btnExit.setBounds(677, 318, 85, 21);
        contentPane.add(btnExit);

        btnExit.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                frame.setContentPane(new PanelMainScreenTeacher(frame));
                frame.setVisible(true);
            }
        });

        JMenuBar menuBar = new JMenuBar();
        menuBar.setBackground(SystemColor.textHighlight);
        menuBar.setBounds(0, 0, 772, 22);
        contentPane.add(menuBar);

        JButton btnSave = new JButton("Save");
        btnSave.setBounds(677, 283, 85, 21);
        contentPane.add(btnSave);
        btnSave.setVisible(false);
        //Save
        btnSave.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                Date start = null;
                Date end = null;
                String Semester = txtSemester.getText();
                int year = Integer.parseInt(txtYear.getText());
                try {
                     start = new SimpleDateFormat("yyyy-MM-dd").parse(txtDateStart.getText().toString());
                } catch (ParseException parseException) {
                    parseException.printStackTrace();
                }
                try {
                    end = new SimpleDateFormat("yyyy-MM-dd").parse(txtDateEnd.getText().toString());
                } catch (ParseException parseException) {
                    parseException.printStackTrace();
                }
                txtID.getText();
                if(!txtID.getText().equals("")){
                    //SemesterDAO.UpdateSemester(Integer.parseInt(txtID.getText()),Semester,year,start,end);
                    SemesterDAO.AddNewSemester(Semester,year,start,end);
                }else {
                    SemesterDAO.AddNewSemester(Semester,year,start,end);
                }

                tableModel.getDataVector().removeAllElements();
                //tableModel.setRowCount(0);
                tableModel.fireTableDataChanged();
                List<SemesterEntity> semesters = SemesterDAO.getAllSemester();

                for (var semester:semesters) {
                    int id = semester.getId();
                    String Name = semester.getSemesterName();
                    int years = semester.getYear();
                    Date starts = semester.getDateStart();
                    Date ends = semester.getDateEnd();

                    Object[] data = {id, Name, years,starts,ends};

                    tableModel.addRow(data);

                }
                table.setModel(tableModel);
                tableModel.fireTableDataChanged();
            }
        });

        JButton btnCancel = new JButton("Cancel");
        btnCancel.setBounds(582, 283, 85, 21);
        contentPane.add(btnCancel);
        btnCancel.setVisible(false);
        btnCancel.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                txtID.setEditable(false);
                txtID.setText("");

                txtSemester.setEditable(false);
                txtSemester.setText("");

                txtYear.setEditable(false);
                txtYear.setText("");

                txtDateStart.setEditable(false);
                txtDateStart.setText("");

                txtDateEnd.setEditable(false);
                txtDateEnd.setText("");

                btnSave.setVisible(false);
                btnCancel.setVisible(false);
            }
        });

        btnCreate.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                txtID.setEditable(true);
                txtID.setText("");

                txtSemester.setEditable(true);
                txtSemester.setText("");

                txtYear.setEditable(true);
                txtYear.setText("");

                txtDateStart.setEditable(true);
                txtDateStart.setText("");

                txtDateEnd.setEditable(true);
                txtDateEnd.setText("");

                btnSave.setVisible(true);
                btnCancel.setVisible(true);
            }
        });

        itmenuSetSemesterCurr.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                SemesterDAO.SetPresentSemester(Integer.parseInt(table.getValueAt(table.getSelectedRow(),0).toString()));

                txtSemesterCurr.setText(table.getValueAt(table.getSelectedRow(),1).toString());
                txtYearCurr.setText(table.getValueAt(table.getSelectedRow(),2).toString());
            }
        });
        itmenuEdit.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                setStatus(btnSave, btnCancel, true);
            }
        });

        itmenuEdit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                txtID.setEditable(false);
                txtID.setText(table.getValueAt(table.getSelectedRow(),0).toString());

                txtSemester.setEditable(true);
                txtSemester.setText(table.getValueAt(table.getSelectedRow(),1).toString());

                txtYear.setEditable(true);
                txtYear.setText(table.getValueAt(table.getSelectedRow(),2).toString());

                txtDateStart.setEditable(true);
                txtDateStart.setText(table.getValueAt(table.getSelectedRow(),3).toString());

                txtDateEnd.setEditable(true);
                txtDateEnd.setText(table.getValueAt(table.getSelectedRow(),4).toString());

                btnSave.setVisible(true);
                btnCancel.setVisible(true);
            }
        });

        itmenuDelete.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Date start = null;
                Date end = null;
                String Semester = txtSemester.getText();
                int year = Integer.parseInt(txtYear.getText());
                try {
                    start = new SimpleDateFormat("yyyy-MM-dd").parse(txtDateStart.getText().toString());
                } catch (ParseException parseException) {
                    parseException.printStackTrace();
                }
                try {
                    end = new SimpleDateFormat("yyyy-MM-dd").parse(txtDateEnd.getText().toString());
                } catch (ParseException parseException) {
                    parseException.printStackTrace();
                }

                setStatus(btnSave,btnCancel, false);
                SemesterDAO.DeleteSemester(Semester,year,start,end);

                setStatus(btnSave, btnCancel, false);
                tableModel.removeRow(table.getSelectedRow());
                tableModel.fireTableDataChanged();
                table.setModel(tableModel);
                tableModel.fireTableDataChanged();
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
        txtID.setEditable(status);
        txtID.setText("");

        txtSemester.setEditable(status);
        txtSemester.setText("");

        txtYear.setEditable(status);
        txtYear.setText("");

        txtDateStart.setEditable(status);
        txtDateStart.setText("");

        txtDateEnd.setEditable(status);
        txtDateEnd.setText("");

        btnSave.setVisible(status);
        btnCancel.setVisible(status);
    }


}