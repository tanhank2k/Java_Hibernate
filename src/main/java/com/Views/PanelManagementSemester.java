package com.Views;
import com.DAO.SemesterDAO;
import com.Model.SemesterEntity;

import javax.swing.*;
import java.awt.*;
import javax.swing.border.EmptyBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Date;
import java.util.List;

public class PanelManagementSemester extends JPanel {
    private JTable table ;
    private JTextField txtID;
    private JTextField txtSemester;
    private JTextField txtYear;
    private JTextField txtDateStart;
    private JTextField txtDateEnd;

    /**
     * Create the panel.
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

        table.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
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


        JButton btnCreate = new JButton("New Semester");
        btnCreate.setMargin(new Insets(2, 2, 2, 2));
        btnCreate.setBounds(375, 287, 100, 21);
        contentPane.add(btnCreate);

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
            }
        });


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