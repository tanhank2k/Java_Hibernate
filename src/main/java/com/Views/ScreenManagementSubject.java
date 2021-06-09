import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JButton;
import java.awt.GridBagLayout;
import javax.swing.JLabel;
import java.awt.GridBagConstraints;
import javax.swing.JTextField;
import java.awt.Insets;
import java.awt.GridLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JPopupMenu;
import java.awt.Component;
import javax.swing.JMenuItem;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JMenuBar;
import java.awt.SystemColor;
import javax.swing.JMenu;
import javax.swing.ListSelectionModel;

public class ScreenManagementSubject extends JFrame {

    private JPanel contentPane;
    private JTable table;
    private JTextField txtID;
    private JTextField txtSubjectName;
    private JTextField txtSubjectCode;
    private JTextField txtCredits;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    ScreenManagementSubject frame = new ScreenManagementSubject();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    /**
     * Create the frame.
     */
    public ScreenManagementSubject() {
        setTitle("Management Subject\r\n");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 786, 386);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

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
                        {null, null, "", null},
                        {null, null, null, null},
                        {null, "", null, null},
                        {null, null, null, null},
                        {null, "", null, null},
                },
                new String[] {
                        "ID", "Subject Name", "Subject Code", "Number of credits"
                }
        ));

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
        panel.add(txtID);
        txtID.setColumns(10);

        JLabel lblNewLabel_1 = new JLabel("Subject Name");
        panel.add(lblNewLabel_1);

        txtSubjectName = new JTextField();
        panel.add(txtSubjectName);
        txtSubjectName.setColumns(10);

        JLabel lblNewLabel_2 = new JLabel("Subject code");
        panel.add(lblNewLabel_2);

        txtSubjectCode = new JTextField();
        panel.add(txtSubjectCode);
        txtSubjectCode.setColumns(10);

        JLabel lblNewLabel_3 = new JLabel("Number of credits");
        panel.add(lblNewLabel_3);

        txtCredits = new JTextField();
        panel.add(txtCredits);
        txtCredits.setColumns(10);

        JButton btnExit = new JButton("Exit");
        btnExit.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            }
        });
        btnExit.setBounds(677, 328, 85, 21);
        contentPane.add(btnExit);

        JButton btnSave = new JButton("Save");
        btnSave.setBounds(677, 167, 85, 21);
        contentPane.add(btnSave);

        JMenuBar menuBar = new JMenuBar();
        menuBar.setBackground(SystemColor.textHighlight);
        menuBar.setBounds(0, 0, 772, 22);
        contentPane.add(menuBar);

        JMenu btnTeacherName = new JMenu("Name");
        menuBar.add(btnTeacherName);

        JMenuItem imenuProfile = new JMenuItem("Profile");
        btnTeacherName.add(imenuProfile);

        JMenuItem imenuExit = new JMenuItem("Exit");
        btnTeacherName.add(imenuExit);
        table_2.getColumnModel().getColumn(1).setPreferredWidth(221);
        table_2.getColumnModel().getColumn(2).setPreferredWidth(84);
        table_2.getColumnModel().getColumn(3).setPreferredWidth(100);
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
