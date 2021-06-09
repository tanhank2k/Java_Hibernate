package com.Views;
import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import java.awt.GridLayout;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;
import javax.swing.Box;
import java.awt.Component;
import java.awt.Dimension;
import javax.swing.JLabel;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.SystemColor;
import javax.swing.JMenuItem;
import javax.swing.JCheckBox;
import java.awt.Font;
import javax.swing.JToolBar;
import javax.swing.SpringLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class MainScreenTeacher extends JFrame {

    private JPanel contentPane;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    MainScreenTeacher frame = new MainScreenTeacher();
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
    public MainScreenTeacher() {
        setBackground(SystemColor.menu);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 786, 386);

        JMenuBar menuBar = new JMenuBar();
        menuBar.setBackground(SystemColor.textHighlight);
        setJMenuBar(menuBar);

        JMenu btnTeacherName = new JMenu("Name");
        btnTeacherName.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
            }
        });
        menuBar.add(btnTeacherName);

        JMenuItem imenuProfile = new JMenuItem("Profile");
        imenuProfile.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
            }
        });
        btnTeacherName.add(imenuProfile);

        JMenuItem imenuExit = new JMenuItem("Exit");
        imenuExit.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
            }
        });
        btnTeacherName.add(imenuExit);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        GridBagLayout gbl_contentPane = new GridBagLayout();
        gbl_contentPane.columnWidths = new int[]{249, 249, 249, 0};
        gbl_contentPane.rowHeights = new int[]{105, 105, 105, 0};
        gbl_contentPane.columnWeights = new double[]{0.0, 0.0, 0.0, Double.MIN_VALUE};
        gbl_contentPane.rowWeights = new double[]{0.0, 0.0, 0.0, Double.MIN_VALUE};
        contentPane.setLayout(gbl_contentPane);

        JButton btnSemester = new JButton("Management Semester");
        btnSemester.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
            }
        });
        btnSemester.setFont(new Font("Tahoma", Font.PLAIN, 13));
        GridBagConstraints gbc_btnSemester = new GridBagConstraints();
        gbc_btnSemester.fill = GridBagConstraints.BOTH;
        gbc_btnSemester.insets = new Insets(0, 0, 5, 5);
        gbc_btnSemester.gridx = 0;
        gbc_btnSemester.gridy = 0;
        contentPane.add(btnSemester, gbc_btnSemester);

        JLabel label = new JLabel("");
        GridBagConstraints gbc_label = new GridBagConstraints();
        gbc_label.fill = GridBagConstraints.BOTH;
        gbc_label.insets = new Insets(0, 0, 5, 5);
        gbc_label.gridx = 1;
        gbc_label.gridy = 0;
        contentPane.add(label, gbc_label);

        JButton btnClass = new JButton("Management Class");
        btnClass.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
            }
        });
        btnClass.setFont(new Font("Tahoma", Font.PLAIN, 13));
        GridBagConstraints gbc_btnClass = new GridBagConstraints();
        gbc_btnClass.fill = GridBagConstraints.BOTH;
        gbc_btnClass.insets = new Insets(0, 0, 5, 0);
        gbc_btnClass.gridx = 2;
        gbc_btnClass.gridy = 0;
        contentPane.add(btnClass, gbc_btnClass);

        JButton btnCRS = new JButton("Management Course Registration Session");
        btnCRS.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
            }
        });
        btnCRS.setToolTipText("Management Course Registration Session");
        btnCRS.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            }
        });

        JButton btnSubject = new JButton("Management Subject");
        btnSubject.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
            }
        });
        btnSubject.setFont(new Font("Tahoma", Font.PLAIN, 13));
        GridBagConstraints gbc_btnSubject = new GridBagConstraints();
        gbc_btnSubject.fill = GridBagConstraints.BOTH;
        gbc_btnSubject.insets = new Insets(0, 0, 5, 5);
        gbc_btnSubject.gridx = 0;
        gbc_btnSubject.gridy = 1;
        contentPane.add(btnSubject, gbc_btnSubject);

        JButton btnTeacher = new JButton("Management Teacher");
        btnTeacher.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
            }
        });
        btnTeacher.setFont(new Font("Tahoma", Font.PLAIN, 13));
        btnTeacher.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            }
        });
        GridBagConstraints gbc_btnTeacher = new GridBagConstraints();
        gbc_btnTeacher.fill = GridBagConstraints.BOTH;
        gbc_btnTeacher.insets = new Insets(0, 0, 5, 5);
        gbc_btnTeacher.gridx = 1;
        gbc_btnTeacher.gridy = 1;
        contentPane.add(btnTeacher, gbc_btnTeacher);
        btnCRS.setFont(new Font("Tahoma", Font.PLAIN, 13));
        GridBagConstraints gbc_btnCRS = new GridBagConstraints();
        gbc_btnCRS.fill = GridBagConstraints.BOTH;
        gbc_btnCRS.insets = new Insets(0, 0, 5, 0);
        gbc_btnCRS.gridx = 2;
        gbc_btnCRS.gridy = 1;
        contentPane.add(btnCRS, gbc_btnCRS);

        JButton btnStudent = new JButton("Management Student");
        btnStudent.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
            }
        });
        btnStudent.setFont(new Font("Tahoma", Font.PLAIN, 13));
        GridBagConstraints gbc_btnStudent = new GridBagConstraints();
        gbc_btnStudent.fill = GridBagConstraints.BOTH;
        gbc_btnStudent.insets = new Insets(0, 0, 0, 5);
        gbc_btnStudent.gridx = 0;
        gbc_btnStudent.gridy = 2;
        contentPane.add(btnStudent, gbc_btnStudent);

        JLabel label_1 = new JLabel("");
        GridBagConstraints gbc_label_1 = new GridBagConstraints();
        gbc_label_1.fill = GridBagConstraints.BOTH;
        gbc_label_1.insets = new Insets(0, 0, 0, 5);
        gbc_label_1.gridx = 1;
        gbc_label_1.gridy = 2;
        contentPane.add(label_1, gbc_label_1);

        JButton btnSRC = new JButton("Management Student Registration Course");
        btnSRC.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
            }
        });
        btnSRC.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            }
        });
        btnSRC.setToolTipText("Management Course Registration Session");
        btnSRC.setFont(new Font("Tahoma", Font.PLAIN, 13));
        GridBagConstraints gbc_btnSRC = new GridBagConstraints();
        gbc_btnSRC.fill = GridBagConstraints.BOTH;
        gbc_btnSRC.gridx = 2;
        gbc_btnSRC.gridy = 2;
        contentPane.add(btnSRC, gbc_btnSRC);
    }
}