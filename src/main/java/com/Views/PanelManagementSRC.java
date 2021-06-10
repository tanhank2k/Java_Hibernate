package com.Views;

import javax.swing.JPanel;
import javax.swing.JPopupMenu;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

import java.awt.SystemColor;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.Component;
import java.awt.Font;

public class PanelManagementSRC extends JPanel {
    private JTextField textField;
    private JTextField textField_1;
    private JTextField textField_2;
    private JTextField textField_3;
    private JTextField textField_4;
    private JTextField textField_5;
    private JTextField textField_6;
    private JTextField textField_7;

    /**
     * Create the panel.
     */
    public PanelManagementSRC() {
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
        table_2.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        table_2.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
            }
        });
        scrollPane.setViewportView(table_2);
        table_2.setModel(new DefaultTableModel(
                new Object[][] {
                        {null, null, "", null, null, null},
                        {null, null, null, null, null, null},
                        {null, "", null, null, null, null},
                        {null, null, null, null, null, null},
                        {null, "", null, null, null, null},
                },
                new String[] {
                        "ID", "Name CRS", "Semester", "Year", "Date Start", "Date End"
                }
        ));
        table_2.getColumnModel().getColumn(1).setPreferredWidth(221);
        table_2.getColumnModel().getColumn(2).setPreferredWidth(84);
        table_2.getColumnModel().getColumn(5).setPreferredWidth(100);

        JPopupMenu popupMenu = new JPopupMenu();
        addPopup(table_2, popupMenu);

        JMenuItem itmenuNew = new JMenuItem("New");
        popupMenu.add(itmenuNew);

        JMenuItem itmenuEdit = new JMenuItem("Edit");
        popupMenu.add(itmenuEdit);

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

        textField = new JTextField();
        textField.setColumns(10);
        textField.setBounds(95, 1, 125, 18);
        panel.add(textField);

        JLabel lblNewLabel_1 = new JLabel("Name CRS");
        lblNewLabel_1.setBounds(0, 29, 125, 18);
        panel.add(lblNewLabel_1);

        textField_1 = new JTextField();
        textField_1.setColumns(10);
        textField_1.setBounds(95, 29, 125, 18);
        panel.add(textField_1);

        JLabel lblNewLabel_2 = new JLabel("Semester");
        lblNewLabel_2.setBounds(0, 57, 125, 18);
        panel.add(lblNewLabel_2);

        textField_2 = new JTextField();
        textField_2.setColumns(10);
        textField_2.setBounds(95, 57, 125, 18);
        panel.add(textField_2);

        JLabel lblNewLabel_3 = new JLabel("Year");
        lblNewLabel_3.setBounds(0, 85, 125, 18);
        panel.add(lblNewLabel_3);

        textField_3 = new JTextField();
        textField_3.setColumns(10);
        textField_3.setBounds(95, 85, 125, 18);
        panel.add(textField_3);

        JLabel lblNewLabel_3_1 = new JLabel("Date Start");
        lblNewLabel_3_1.setBounds(0, 113, 125, 18);
        panel.add(lblNewLabel_3_1);

        textField_4 = new JTextField();
        textField_4.setColumns(10);
        textField_4.setBounds(95, 113, 125, 18);
        panel.add(textField_4);

        JLabel lblNewLabel_3_2 = new JLabel("Date End");
        lblNewLabel_3_2.setBounds(0, 141, 125, 18);
        panel.add(lblNewLabel_3_2);

        textField_5 = new JTextField();
        textField_5.setColumns(10);
        textField_5.setBounds(95, 141, 125, 18);
        panel.add(textField_5);

        JButton btnExit = new JButton("Exit");
        btnExit.setBounds(677, 328, 85, 21);
        contentPane.add(btnExit);

        JButton btnSave = new JButton("Save");
        btnSave.setBounds(677, 257, 85, 21);
        contentPane.add(btnSave);

        JMenuBar menuBar = new JMenuBar();
        menuBar.setBackground(SystemColor.textHighlight);
        menuBar.setBounds(0, 0, 772, 22);
        contentPane.add(menuBar);

        JLabel lblNewLabel = new JLabel("Semester Current");
        lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 13));
        lblNewLabel.setBounds(10, 32, 115, 13);
        contentPane.add(lblNewLabel);

        textField_6 = new JTextField();
        textField_6.setEditable(false);
        textField_6.setColumns(10);
        textField_6.setBounds(135, 30, 47, 19);
        contentPane.add(textField_6);

        JLabel lblNewLabel_4 = new JLabel("Year");
        lblNewLabel_4.setFont(new Font("Tahoma", Font.PLAIN, 13));
        lblNewLabel_4.setBounds(208, 33, 45, 13);
        contentPane.add(lblNewLabel_4);

        textField_7 = new JTextField();
        textField_7.setEditable(false);
        textField_7.setColumns(10);
        textField_7.setBounds(248, 30, 47, 19);
        contentPane.add(textField_7);

        JButton btnCancel = new JButton("Cancel");
        btnCancel.setBounds(582, 257, 85, 21);
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
