package com.Views;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class PanelMainScreenTeacher extends JPanel {

    /**
     * Create the panel.
     */
    public PanelMainScreenTeacher(JFrame jFrame) {

        JPanel contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        add(contentPane);
        GridBagLayout gbl_contentPane = new GridBagLayout();
        gbl_contentPane.columnWidths = new int[]{254, 254, 254, 0};
        gbl_contentPane.rowHeights = new int[]{105, 105, 105, 0};
        gbl_contentPane.columnWeights = new double[]{0.0, 0.0, 0.0, Double.MIN_VALUE};
        gbl_contentPane.rowWeights = new double[]{0.0, 0.0, 0.0, Double.MIN_VALUE};
        contentPane.setLayout(gbl_contentPane);

        JButton btnSemester = new JButton("Management Semester");
        btnSemester.setFont(new Font("Tahoma", Font.PLAIN, 13));
        GridBagConstraints gbc_btnSemester = new GridBagConstraints();
        gbc_btnSemester.fill = GridBagConstraints.BOTH;
        gbc_btnSemester.insets = new Insets(0, 0, 5, 5);
        gbc_btnSemester.gridx = 0;
        gbc_btnSemester.gridy = 0;
        contentPane.add(btnSemester, gbc_btnSemester);
        btnSemester.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                jFrame.setContentPane(new PanelManagementSemester(jFrame));
                jFrame.setVisible(true);
            }
        });


        JButton btnCourse = new JButton("Management Course");
        btnCourse.setFont(new Font("Tahoma", Font.PLAIN, 13));
        GridBagConstraints gbc_btnCourse = new GridBagConstraints();
        gbc_btnCourse.fill = GridBagConstraints.BOTH;
        gbc_btnCourse.insets = new Insets(0, 0, 5, 5);
        gbc_btnCourse.gridx = 1;
        gbc_btnCourse.gridy = 0;
        contentPane.add(btnCourse, gbc_btnCourse);

        JButton btnSubject = new JButton("Management Subject");
        btnSubject.setFont(new Font("Tahoma", Font.PLAIN, 13));
        GridBagConstraints gbc_btnSubject = new GridBagConstraints();
        gbc_btnSubject.fill = GridBagConstraints.BOTH;
        gbc_btnSubject.insets = new Insets(0, 0, 5, 0);
        gbc_btnSubject.gridx = 2;
        gbc_btnSubject.gridy = 0;
        contentPane.add(btnSubject, gbc_btnSubject);

        JButton btnClass = new JButton("Management Class");
        btnClass.setFont(new Font("Tahoma", Font.PLAIN, 13));
        GridBagConstraints gbc_btnClass = new GridBagConstraints();
        gbc_btnClass.fill = GridBagConstraints.BOTH;
        gbc_btnClass.insets = new Insets(0, 0, 5, 5);
        gbc_btnClass.gridx = 0;
        gbc_btnClass.gridy = 1;
        contentPane.add(btnClass, gbc_btnClass);

        JButton btnTeacher = new JButton("Management Teacher");
        btnTeacher.setFont(new Font("Tahoma", Font.PLAIN, 13));
        GridBagConstraints gbc_btnTeacher = new GridBagConstraints();
        gbc_btnTeacher.fill = GridBagConstraints.BOTH;
        gbc_btnTeacher.insets = new Insets(0, 0, 5, 5);
        gbc_btnTeacher.gridx = 1;
        gbc_btnTeacher.gridy = 1;
        contentPane.add(btnTeacher, gbc_btnTeacher);

        btnTeacher.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                jFrame.setContentPane(new PanelManagementTeacher(jFrame));
                jFrame.setVisible(true);
            }
        });

        JButton btnNewButton_2_1_2_2_1 = new JButton("Management Student Registration Course");
        btnNewButton_2_1_2_2_1.setToolTipText("Management Course Registration Session");
        btnNewButton_2_1_2_2_1.setFont(new Font("Tahoma", Font.PLAIN, 13));
        GridBagConstraints gbc_btnNewButton_2_1_2_2_1 = new GridBagConstraints();
        gbc_btnNewButton_2_1_2_2_1.fill = GridBagConstraints.BOTH;
        gbc_btnNewButton_2_1_2_2_1.insets = new Insets(0, 0, 5, 0);
        gbc_btnNewButton_2_1_2_2_1.gridx = 2;
        gbc_btnNewButton_2_1_2_2_1.gridy = 1;
        contentPane.add(btnNewButton_2_1_2_2_1, gbc_btnNewButton_2_1_2_2_1);

        JButton btnCRS = new JButton("Management Course Registration Session");
        btnCRS.setToolTipText("Management Course Registration Session");
        btnCRS.setFont(new Font("Tahoma", Font.PLAIN, 13));
        GridBagConstraints gbc_btnCRS = new GridBagConstraints();
        gbc_btnCRS.fill = GridBagConstraints.BOTH;
        gbc_btnCRS.insets = new Insets(0, 0, 0, 5);
        gbc_btnCRS.gridx = 0;
        gbc_btnCRS.gridy = 2;
        contentPane.add(btnCRS, gbc_btnCRS);

        JButton btnStudent = new JButton("Management Student");
        btnStudent.setFont(new Font("Tahoma", Font.PLAIN, 13));
        GridBagConstraints gbc_btnStudent = new GridBagConstraints();
        gbc_btnStudent.fill = GridBagConstraints.BOTH;
        gbc_btnStudent.gridx = 2;
        gbc_btnStudent.gridy = 2;
        contentPane.add(btnStudent, gbc_btnStudent);

    }

}
