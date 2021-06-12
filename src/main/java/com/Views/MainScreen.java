package com.Views;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class MainScreen {

    private JFrame frame;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {

                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    /**
     * Create the application.
     */
    public MainScreen(JPanel panel,int id, String role) {
        initialize(panel,id,role);
    }

    /**
     * Initialize the contents of the frame.
     */
    private void initialize(JPanel panel, int id, String role) {
        frame = new JFrame();
        frame.setBounds(100, 100, 786, 410);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setLayout(new CardLayout(0,0));
        frame.add(panel);

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
                Profile profile = new Profile(id,role);
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

}
