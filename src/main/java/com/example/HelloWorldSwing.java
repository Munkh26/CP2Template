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
        button.addActionListener(new myListener("you did it"));

        panel.add(labelChange);
        panel.add(button);
        frame.getContentPane().add(panel);
        
        //Display the window.
        frame.pack();
        frame.setVisible(true);

        Container pane = frame.getContentPane();
        pane.setLayout(new GridLayout(2, 2));
        for (int i = 0; i < 4; i++) {
            JButton b = new JButton(Integer.toString(i));
            if (i == 0) {
                b.addActionListener(new myListener("moon is up during day"));
            }
            else if (i == 1) {
                b.addActionListener(new myListener("Button " + i + " was pressed I suppose"));
            }
            else if (i == 2) {
                b.addActionListener(new myListener("you need money to live"));
            }
            else if (i == 3) {
                b.addActionListener(new myListener("idk what to put anymore"));
            }
            pane.add(b);
        }

    }

    public static class myListener implements ActionListener            
    {  
        private String message;
        public myListener(String text) {
            message = text;
        }

        public void actionPerformed(ActionEvent event) { 
            labelChange.setText(message);            

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
