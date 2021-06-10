package com.Views;

import com.DAO.ClassDAO;
import com.DAO.SubjectDAO;
import com.Model.ClazzEntity;
import com.Model.SubjectEntity;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;

import java.awt.SystemColor;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.Component;
import java.awt.Font;
import java.util.List;

public class PanelManagementClass extends JPanel {
    private JTextField txtID;
    private JTextField txtName;
    private JTextField txtTotalStudent;
    private JTextField txtTotalMale;
    private JTextField txtTotalFemale;
    private JTextField txtSearch;

    /**
     * Create the panel.
     */
    public PanelManagementClass(JFrame jFrame) {
        setLayout(null);

        JScrollPane scrollPane = new JScrollPane();
        scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
        scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
        scrollPane.setBounds(10, 53, 465, 222);
        add(scrollPane);

        JTable table_2 = new JTable();
        table_2.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);
        table_2.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
            }
        });
        scrollPane.setViewportView(table_2);
        DefaultTableModel tableModel = new DefaultTableModel(new String[] {
                "ID", "Class Name", "Total Student", "Total Male", "Total Female"
        },0) {

            @Override
            public boolean isCellEditable(int row, int column) {
                //all cells false
                return false;
            }
        };

        List<ClazzEntity> clazzes = ClassDAO.getAllClass();
        for (var clazz:clazzes) {
            int id = clazz.getId();
            String Name = clazz.getClassName();
            int total = clazz.getTotalStudent();
            int totalMale = clazz.getTotalMale();
            int totalFemale = clazz.getTotalFeMale();


            Object[] data = {id, Name, total, totalMale,totalFemale};

            tableModel.addRow(data);

        }
        table_2.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
        table_2.setModel(tableModel);
        scrollPane.setViewportView(table_2);
        table_2.getColumnModel().getColumn(1).setPreferredWidth(84);
        table_2.getColumnModel().getColumn(4).setPreferredWidth(100);

        table_2.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                txtID.setText(table_2.getValueAt(table_2.getSelectedRow(), 0).toString());
                txtName.setText(table_2.getValueAt(table_2.getSelectedRow(), 1).toString());
                txtTotalStudent.setText(table_2.getValueAt(table_2.getSelectedRow(), 2).toString());
                txtTotalMale.setText(table_2.getValueAt(table_2.getSelectedRow(), 3).toString());
                txtTotalFemale.setText(table_2.getValueAt(table_2.getSelectedRow(), 4).toString());
            }
        });

        JPopupMenu popupMenu_1 = new JPopupMenu();
        addPopup(table_2, popupMenu_1);

        JMenuItem itmenuNewTeacher = new JMenuItem("New Class");
        itmenuNewTeacher.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
            }
        });
        popupMenu_1.add(itmenuNewTeacher);

        JMenuItem itmenuEditTeacher = new JMenuItem("Edit");
        itmenuEditTeacher.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
            }
        });
        popupMenu_1.add(itmenuEditTeacher);

        JMenuItem itmenuDeleteTeacher = new JMenuItem("Delete");
        itmenuDeleteTeacher.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
            }
        });
        popupMenu_1.add(itmenuDeleteTeacher);

        JButton btnNewSubject = new JButton("New Class");
        btnNewSubject.setBounds(348, 286, 115, 21);
        add(btnNewSubject);

        JPanel panel = new JPanel();
        panel.setLayout(null);
        panel.setBounds(541, 53, 221, 153);
        add(panel);

        JLabel lbID = new JLabel("ID");
        lbID.setBounds(0, 1, 125, 18);
        panel.add(lbID);

        txtID = new JTextField();
        txtID.setColumns(10);
        txtID.setBounds(95, 1, 125, 18);
        panel.add(txtID);

        JLabel lblNewLabel_2 = new JLabel("Class Name");
        lblNewLabel_2.setBounds(0, 29, 125, 18);
        panel.add(lblNewLabel_2);

        txtName = new JTextField();
        txtName.setColumns(10);
        txtName.setBounds(95, 29, 125, 18);
        panel.add(txtName);

        JLabel lblNewLabel_3 = new JLabel("Total Student");
        lblNewLabel_3.setBounds(0, 57, 125, 18);
        panel.add(lblNewLabel_3);

        txtTotalStudent = new JTextField();
        txtTotalStudent.setColumns(10);
        txtTotalStudent.setBounds(95, 57, 125, 18);
        panel.add(txtTotalStudent);

        JLabel lblNewLabel_3_1 = new JLabel("Total Male");
        lblNewLabel_3_1.setBounds(0, 85, 125, 18);
        panel.add(lblNewLabel_3_1);

        txtTotalMale = new JTextField();
        txtTotalMale.setColumns(10);
        txtTotalMale.setBounds(95, 85, 125, 18);
        panel.add(txtTotalMale);

        JLabel lblNewLabel_3_2 = new JLabel("Total Female");
        lblNewLabel_3_2.setBounds(0, 113, 125, 18);
        panel.add(lblNewLabel_3_2);

        txtTotalFemale = new JTextField();
        txtTotalFemale.setColumns(10);
        txtTotalFemale.setBounds(95, 113, 125, 18);
        panel.add(txtTotalFemale);

        JButton btnExit = new JButton("Exit");
        btnExit.setBounds(677, 318, 85, 21);
        add(btnExit);
        btnExit.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                jFrame.setContentPane(new PanelMainScreenTeacher(jFrame));
                jFrame.setVisible(true);
            }
        });

        JButton btnSave = new JButton("Save");
        btnSave.setBounds(677, 216, 85, 21);
        add(btnSave);
        btnSave.setEnabled(false);

        JMenuBar menuBar = new JMenuBar();
        menuBar.setBackground(SystemColor.textHighlight);
        menuBar.setBounds(0, 0, 772, 22);
        add(menuBar);

        JLabel lblNewLabel = new JLabel("Class Information");
        lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 13));
        lblNewLabel.setBounds(542, 22, 147, 21);
        add(lblNewLabel);

        JLabel lblNewLabel_1 = new JLabel("Class");
        lblNewLabel_1.setBounds(10, 30, 45, 13);
        add(lblNewLabel_1);

        txtSearch = new JTextField();
        txtSearch.setColumns(10);
        txtSearch.setBounds(65, 28, 147, 19);
        add(txtSearch);

        JButton btnSearch = new JButton("Search");
        btnSearch.setBounds(218, 26, 85, 21);
        add(btnSearch);

        JButton btnCancel = new JButton("Cancel");
        btnCancel.setBounds(579, 216, 85, 21);
        add(btnCancel);
        btnCancel.setVisible(false);

        txtID.setEditable(false);
        txtName.setEditable(false);
        txtTotalStudent.setEditable(false);
        txtTotalMale.setEditable(false);
        txtTotalFemale.setEditable(false);
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


