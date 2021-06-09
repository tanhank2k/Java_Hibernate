package com.company;
import javax.swing.*;
public class Main {

    public static void main(String[] args) {
	// write your code here
        JFrame jFrame = new JFrame();
        JButton jButton = new JButton("Click");
        jButton.setBounds(130,50,100,40);

        jFrame.setTitle("Test");
        jFrame.add(jButton);

        jFrame.setSize(400,200);
        jFrame.setLayout(null);
        jFrame.setVisible(true);
    }
}
