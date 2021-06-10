package com.Views;

import com.DAO.TeacherDAO;
import com.Model.TeacherEntity;

import javax.swing.JPanel;
import javax.swing.JPopupMenu;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JButton;

import java.awt.Component;
import java.awt.GridLayout;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

import java.awt.SystemColor;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Date;
import java.util.List;

public class PanelManagementSubject extends JPanel {
    private JTextField txtID;
    private JTextField txtName;
    private JTextField txtCode;
    private JTextField txtCredits;
    private JTextField txtSearch;

    /**
     * Create the panel.
     */
    public PanelManagementSubject() {
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
        List<TeacherEntity> teachers = TeacherDAO.getAllSTeacher();
        DefaultTableModel tableModel = new DefaultTableModel(new String[] {
                "ID", "Subject Name", "Subject Code", "Number of credits"
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

