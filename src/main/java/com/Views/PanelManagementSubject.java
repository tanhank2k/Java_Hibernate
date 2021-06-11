package com.Views;

import com.DAO.SubjectDAO;
import com.DAO.TeacherDAO;
import com.Model.SubjectEntity;
import com.Model.TeacherEntity;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;

import java.awt.Component;
import java.awt.GridLayout;

import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Date;
import java.util.List;

public class PanelManagementSubject extends JPanel {
    private  boolean isCreate = true;
    private JTextField txtID;
    private JTextField txtName;
    private JTextField txtCode;
    private JTextField txtCredits;
    private JTextField txtSearch;

    /**
     * Create the panel.
     */
    public PanelManagementSubject(JFrame jFrame) {
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
        table_2.setSurrendersFocusOnKeystroke(true);
        table_2.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);
        table_2.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
            }
        });

        DefaultTableModel tableModel = new DefaultTableModel(new String[] {
                "ID", "Subject Name", "Subject Code", "Number of credits"
        },0) {

            @Override
            public boolean isCellEditable(int row, int column) {
                //all cells false
                return false;
            }
        };

        List<SubjectEntity> subjects = SubjectDAO.getAllSubject();
        for (var subject:subjects) {
            int id = subject.getId();
            String Name = subject.getSubjectName();
            String code = subject.getSubjectCode();
            int credits = subject.getNumberOfCredits();


            Object[] data = {id, Name, code, credits};

            tableModel.addRow(data);

        }
        table_2.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
        table_2.setModel(tableModel);
        scrollPane.setViewportView(table_2);

        table_2.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                txtID.setText(table_2.getValueAt(table_2.getSelectedRow(),0).toString());
                txtName.setText(table_2.getValueAt(table_2.getSelectedRow(),1).toString());
                txtCode.setText(table_2.getValueAt(table_2.getSelectedRow(),2).toString());
                txtCredits.setText(table_2.getValueAt(table_2.getSelectedRow(),3).toString());
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


        JButton btnNewSubject = new JButton("New Subject");
        btnNewSubject.setBounds(348, 286, 115, 21);
        contentPane.add(btnNewSubject);

        JPanel panel = new JPanel();
        panel.setBounds(541, 53, 221, 104);
        contentPane.add(panel);
        panel.setLayout(new GridLayout(0, 2, -30, 10));

        JLabel lbID = new JLabel("ID");
        panel.add(lbID);

        txtID = new JTextField();
        txtID.setColumns(10);
        panel.add(txtID);

        JLabel lblNewLabel_1 = new JLabel("Subject Name");
        panel.add(lblNewLabel_1);

        txtName = new JTextField();
        txtName.setColumns(10);
        panel.add(txtName);

        JLabel lblNewLabel_2 = new JLabel("Subject code");
        panel.add(lblNewLabel_2);

        txtCode = new JTextField();
        txtCode.setColumns(10);
        panel.add(txtCode);

        JLabel lblNewLabel_3 = new JLabel("Number of credits");
        panel.add(lblNewLabel_3);

        txtCredits = new JTextField();
        txtCredits.setColumns(10);
        panel.add(txtCredits);

        JButton btnExit = new JButton("Exit");
        btnExit.setBounds(677, 328, 85, 21);
        contentPane.add(btnExit);

        JButton btnSave = new JButton("Save");
        btnSave.setBounds(677, 167, 85, 21);
        contentPane.add(btnSave);

        JMenuBar menuBar = new JMenuBar();
        menuBar.setBackground(SystemColor.textHighlight);
        menuBar.setBounds(0, 0, 772, 22);
        contentPane.add(menuBar);

        JLabel lblNewLabel = new JLabel("Subject");
        lblNewLabel.setBounds(10, 33, 45, 13);
        contentPane.add(lblNewLabel);

        txtSearch = new JTextField();
        txtSearch.setBounds(52, 30, 134, 19);
        contentPane.add(txtSearch);
        txtSearch.setColumns(10);

        JButton btnSearch = new JButton("Search");
        btnSearch.setBounds(204, 29, 85, 21);
        contentPane.add(btnSearch);

        JButton btnCancel = new JButton("Cancel");
        btnCancel.setBounds(571, 167, 85, 21);
        contentPane.add(btnCancel);

        btnCancel.setVisible(false);
        btnSave.setEnabled(false);
        txtID.setEditable(false);
        setStatus(btnSave,btnCancel,false);


        btnNewSubject.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                isCreate = true;
                setStatus(btnSave,btnCancel,true);

            }
        });

        btnSave.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String Name = txtName.getText();
                String Code= txtCode.getText();
                int credits = Integer.parseInt(txtCredits.getText());
                if (isCreate){

                    SubjectDAO.AddNewSubject(Name,Code,credits);

                }else {
                    SubjectDAO.UpdateSubject(txtID.getText(),Name,Code,credits);
                }

                Reload(tableModel);
                setText("");
                setStatus(btnSave,btnCancel,false);
            }

        });

        btnCancel.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                txtID.setText("");
                setText("");
                setStatus(btnSave,btnCancel,false);
            }
        });

        itmenuNew.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                isCreate = true;
                setStatus(btnSave,btnCancel,true);
                setText("");
                txtID.setText("");
            }
        });

        itmenuEdit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                isCreate = false;
                setStatus(btnSave,btnCancel, true);
            }
        });

        itmenuDelete.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                SubjectDAO.DeleteSubject(Integer.parseInt(table_2.getValueAt(table_2.getSelectedRow(),0).toString()));
                Reload(tableModel);
                setText("");
            }
        });

        btnSearch.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String search = txtSearch.getText();
                List<Object[]> results = SubjectDAO.SearchSubject(search);

                tableModel.setRowCount(0);
                for (Object[] subject:results) {
                    int id = (int) subject[0];
                    String Name = (String) subject[1];
                    String code = (String) subject[2];
                    int credits = (int) subject[3];


                    Object[] data = {id, Name, code, credits};

                    tableModel.addRow(data);

                }

                tableModel.fireTableDataChanged();
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

        txtName.setEditable(status);
        txtCode.setEditable(status);
        txtCredits.setEditable(status);
        btnCancel.setVisible(status);
        btnSave.setVisible(status);
        btnSave.setEnabled(status);

    }

    public void setText(String str){
        txtID.setText(str);
        txtName.setText(str);
        txtCode.setText(str);
        txtCredits.setText(str);
    }

    public void Reload(DefaultTableModel tableModel){

        List<SubjectEntity> subjects = SubjectDAO.getAllSubject();
        tableModel.setRowCount(0);
        for (var subject:subjects) {
            int id = subject.getId();
            String Name = subject.getSubjectName();
            String code = subject.getSubjectCode();
            int credits = subject.getNumberOfCredits();


            Object[] data = {id, Name, code, credits};

            tableModel.addRow(data);

        }

        tableModel.fireTableDataChanged();
    }

}

