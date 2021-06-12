package com.Views;

import java.awt.*;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JButton;
import javax.swing.JMenuItem;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PanelMainStudent extends JFrame {

    private JPanel contentPane;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                   // PanelMainStudent frame = new PanelMainStudent();
                    //frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    /**
     * Create the frame.
     */
    public PanelMainStudent(int idStudent) {
        setBackground(SystemColor.menu);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 496, 343);

        JMenuBar menuBar = new JMenuBar();
        setJMenuBar(menuBar);

        JMenu menuName = new JMenu("New menu");
        menuBar.add(menuName);

        JMenuItem itmenuProfile = new JMenuItem("Profile");
        menuName.add(itmenuProfile);

        JMenuItem itmenuSignOut = new JMenuItem("Sign out");
        menuName.add(itmenuSignOut);

        itmenuProfile.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                PanelMainStudent.this.dispose();
                Profile profile = new Profile(idStudent,"Student");
                profile.setVisible(true);
            }
        });
        itmenuSignOut.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                PanelMainStudent.this.dispose();
                LoginScreen loginScreen = new LoginScreen();
                loginScreen.setVisible(true);
            }
        });
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        GridBagLayout gbl_contentPane = new GridBagLayout();
        gbl_contentPane.columnWidths = new int[]{231, 236, 0};
        gbl_contentPane.rowHeights = new int[]{132, 0};
        gbl_contentPane.columnWeights = new double[]{0.0, 0.0, Double.MIN_VALUE};
        gbl_contentPane.rowWeights = new double[]{1.0, Double.MIN_VALUE};
        contentPane.setLayout(gbl_contentPane);

        JButton btnRegistered = new JButton("REGISTERED COURSE");
        btnRegistered.setFont(new Font("Tahoma", Font.BOLD, 18));
        GridBagConstraints gbc_btnNewButton_2 = new GridBagConstraints();
        gbc_btnNewButton_2.fill = GridBagConstraints.BOTH;
        gbc_btnNewButton_2.insets = new Insets(0, 0, 0, 5);
        gbc_btnNewButton_2.gridx = 0;
        gbc_btnNewButton_2.gridy = 0;
        contentPane.add(btnRegistered, gbc_btnNewButton_2);

        JButton btnRegister = new JButton("REGISTER COURSE");
        btnRegister.setFont(new Font("Tahoma", Font.BOLD, 18));
        GridBagConstraints gbc_btnRegister = new GridBagConstraints();
        gbc_btnRegister.fill = GridBagConstraints.BOTH;
        gbc_btnRegister.gridx = 1;
        gbc_btnRegister.gridy = 0;
        contentPane.add(btnRegister, gbc_btnRegister);

        btnRegister.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                PanelMainStudent.this.dispose();
                JFrame frame = new JFrame();
                frame.setBounds(100, 100, 786, 410);
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.getContentPane().setLayout(new CardLayout(0,0));
                frame.add(new PanelStudentRegistrationCourse(frame,idStudent));
                JMenuBar menuBar = new JMenuBar();
                frame.setJMenuBar(menuBar);

                JMenu menuName = new JMenu("New menu");
                menuBar.add(menuName);

                JMenuItem itmenuProfile = new JMenuItem("Profile");
                menuName.add(itmenuProfile);

                JMenuItem itmenuSignOut = new JMenuItem("Sign out");
                menuName.add(itmenuSignOut);

                itmenuProfile.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        frame.dispose();
                        Profile profile = new Profile(idStudent,"Student");
                        profile.setVisible(true);
                    }
                });
                itmenuSignOut.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        frame.dispose();
                        LoginScreen loginScreen = new LoginScreen();
                        loginScreen.setVisible(true);
                    }
                });
                frame.setVisible(true);
            }
        });

        btnRegistered.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                PanelMainStudent.this.dispose();
                JFrame frame = new JFrame();
                frame.setBounds(100, 100, 786, 410);
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.getContentPane().setLayout(new CardLayout(0,0));
                frame.add(new PanelStudentRegistered(frame,idStudent));
                JMenuBar menuBar = new JMenuBar();
                frame.setJMenuBar(menuBar);

                JMenu menuName = new JMenu("New menu");
                menuBar.add(menuName);

                JMenuItem itmenuProfile = new JMenuItem("Profile");
                menuName.add(itmenuProfile);

                JMenuItem itmenuSignOut = new JMenuItem("Sign out");
                menuName.add(itmenuSignOut);

                itmenuProfile.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        frame.dispose();
                        Profile profile = new Profile(idStudent,"Student");
                        profile.setVisible(true);
                    }
                });
                itmenuSignOut.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        frame.dispose();
                        LoginScreen loginScreen = new LoginScreen();
                        loginScreen.setVisible(true);
                    }
                });
                frame.setVisible(true);
            }
        });



    }
}
