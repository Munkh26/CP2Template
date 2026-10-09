package com.example;

import javax.swing.*; 
import java.util.*;
import java.awt.*;
import java.awt.event.*;

public class HelloWorldSwing {
    /**
     * Create the GUI and show it.  For thread safety,
     * this method should be invoked from the
     * event-dispatching thread.
     */
    private static JLabel labelChange;

    private static void createAndShowGUI() {
        //Create and set up the window.
        JFrame frame = new JFrame("HelloWorldSwing");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel panel = new JPanel();

        //Add the ubiquitous "Hello World" label.
        JLabel label = new JLabel("Hello World");
        labelChange = label;
        JButton button = new JButton("press me");
        button.addActionListener(new myListener());

        panel.add(labelChange);
        panel.add(button);
        frame.getContentPane().add(panel);
        
        //Display the window.
        frame.pack();
        frame.setVisible(true);

        Container pane = frame.getContentPane();
        pane.setLayout(new GridLayout(3, 3));
        for (int i = 0; i < 9; i++) {
            pane.add(new JButton(Integer.toString(i)));
        }

    }

    public static class myListener implements ActionListener            
    {  
        public void actionPerformed(ActionEvent event) { 
            labelChange.setText("you did it");

        }
    }


    public static void main(String[] args) {
        //Schedule a job for the event-dispatching thread:
        //creating and showing this application's GUI.
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                createAndShowGUI();
            }
        });
    }
}
