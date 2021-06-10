package com.Views;

import com.Model.SemesterEntity;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTable;
import java.awt.BorderLayout;
import javax.swing.JScrollBar;
import javax.swing.JSlider;
import javax.swing.JScrollPane;
import javax.swing.JButton;
import java.awt.Insets;
import javax.swing.JPanel;
import java.awt.Color;
import javax.swing.JTextPane;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.JPopupMenu;
import java.awt.Component;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JMenuItem;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import javax.swing.JMenuBar;
import java.awt.SystemColor;
import java.util.Date;
import java.util.List;
import javax.swing.JMenu;

public class ScreenManagementSemester {

    private JFrame frmScreenManagementSemester;
    private JTable table_2;
    private JTextField txtID;
    private JTextField txtSemester;
    private JTextField txtYear;
    private JTextField txtDateStart;
    private JTextField txtDateEnd;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    ScreenManagementSemester window = new ScreenManagementSemester();
                    window.frmScreenManagementSemester.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    /**
     * Create the application.
     */
    public ScreenManagementSemester() {
        initialize();
    }

    /**
     * Initialize the contents of the frame.
     */
    private void initialize() {
        frmScreenManagementSemester = new JFrame();
        frmScreenManagementSemester.setTitle("Management Semester");
        frmScreenManagementSemester.setBounds(100, 100, 786, 386);
        frmScreenManagementSemester.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frmScreenManagementSemester.getContentPane().setLayout(null);

        JScrollPane scrollPane = new JScrollPane();
        scrollPane.setBounds(10, 56, 465, 222);
        frmScreenManagementSemester.getContentPane().add(scrollPane);

        table_2 = new JTable();
        //table_2.setEnabled(false);
        try {
            SessionFactory factory = new Configuration().configure().buildSessionFactory();

            Session session = factory.openSession();
            String hql = "From SemesterEntity";
            Query query = session.createQuery(hql);
            List<SemesterEntity> results = query.list();

            DefaultTableModel tableModel = new DefaultTableModel(
                    new Object[][] {},
                    new String[] {
                            "ID", "Semester", "Year", "DateStart", "DateEnd"
                    }){
                @Override
                public boolean isCellEditable(int row, int column) {
                    //all cells false
                    return false;
                }
            };
            for (var data:results) {
                int id = data.getId();
                String Name = data.getSemesterName();
                int year = data.getYear();
                Date dateStart = data.getDateStart();
                Date dateEnd = data.getDateEnd();

                Object [] row = {id,Name,year,dateStart,dateEnd};
                tableModel.addRow(row);
            }

            table_2.setModel(tableModel);
        }catch (Throwable ex){
            ex.printStackTrace();
        }

        scrollPane.setViewportView(table_2);

        JPopupMenu popupMenu = new JPopupMenu();
        addPopup(table_2, popupMenu);

        JMenuItem btnSetSemesterCurrent = new JMenuItem("Set Semester Current");
        popupMenu.add(btnSetSemesterCurrent);

        JMenuItem btnEdit = new JMenuItem("Edit");
        popupMenu.add(btnEdit);

        JMenuItem btnDelete = new JMenuItem("Delete");
        popupMenu.add(btnDelete);

        JButton btnCreate = new JButton("New Semester");
        btnCreate.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                
            }
        });
        btnCreate.setMargin(new Insets(2, 2, 2, 2));
        btnCreate.setBounds(375, 288, 100, 21);
        frmScreenManagementSemester.getContentPane().add(btnCreate);

        JButton btnExit = new JButton("Exit");
        btnExit.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
            }
        });
        btnExit.setBounds(677, 318, 85, 21);
        frmScreenManagementSemester.getContentPane().add(btnExit);

        JPanel panel = new JPanel();
        panel.setBounds(559, 56, 203, 222);
        frmScreenManagementSemester.getContentPane().add(panel);
        panel.setLayout(null);

        JLabel lblID = new JLabel("ID ");
        lblID.setBounds(39, 13, 18, 13);
        lblID.setHorizontalAlignment(SwingConstants.RIGHT);
        panel.add(lblID);

        txtID = new JTextField();
        txtID.setBounds(62, 10, 136, 19);
        txtID.setColumns(10);
        panel.add(txtID);

        JLabel lblSemester = new JLabel("Semester");
        lblSemester.setBounds(0, 54, 55, 13);
        lblSemester.setHorizontalAlignment(SwingConstants.RIGHT);
        panel.add(lblSemester);

        JLabel lblYear = new JLabel("Year");
        lblYear.setBounds(31, 95, 26, 13);
        lblYear.setHorizontalAlignment(SwingConstants.RIGHT);
        panel.add(lblYear);

        JLabel lblDatestart = new JLabel("DateStart");
        lblDatestart.setBounds(-3, 136, 55, 13);
        lblDatestart.setHorizontalAlignment(SwingConstants.RIGHT);
        panel.add(lblDatestart);

        JLabel lblDateend = new JLabel("DateEnd");
        lblDateend.setBounds(-3, 177, 55, 13);
        lblDateend.setHorizontalAlignment(SwingConstants.RIGHT);
        panel.add(lblDateend);

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

        JMenuBar menuBar = new JMenuBar();
        menuBar.setBackground(SystemColor.textHighlight);
        menuBar.setBounds(0, 0, 772, 22);
        frmScreenManagementSemester.getContentPane().add(menuBar);

        JMenu btnTeacherName = new JMenu("Name");
        menuBar.add(btnTeacherName);

        JMenuItem imenuProfile = new JMenuItem("Profile");
        btnTeacherName.add(imenuProfile);

        JMenuItem imenuExit = new JMenuItem("Exit");
        btnTeacherName.add(imenuExit);

        table_2.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                txtID.setText(table_2.getValueAt(table_2.getSelectedRow(),0).toString());
                txtSemester.setText(table_2.getValueAt(table_2.getSelectedRow(),1).toString());
                txtYear.setText(table_2.getValueAt(table_2.getSelectedRow(),2).toString());
                txtDateStart.setText(table_2.getValueAt(table_2.getSelectedRow(),3).toString());
                txtDateEnd.setText(table_2.getValueAt(table_2.getSelectedRow(),4).toString());

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
}
