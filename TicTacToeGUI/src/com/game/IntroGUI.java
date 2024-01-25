package com.game;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class IntroGUI implements ActionListener {
    private JFrame frame = new JFrame("Conj's Tic-Tac-Toe");
    private JLabel label = new JLabel("Welcome to Conj's Tic-Tac-Toe!");
    private JButton friendButton = new JButton("Play with a Friend!");
    private JButton aiButton = new JButton("Play against the Computer!");
    public static int mode = 0;

    public IntroGUI(){ //constructor to make intro GUI, allows user to select game mode
        JPanel panel = new JPanel(new GridLayout(3, 1));
        panel.setBorder(BorderFactory.createEmptyBorder(85, 55, 85, 55));
        panel.add(label, BorderLayout.NORTH);
        panel.setBackground(Color.BLACK);

        label.setFont(new Font("Arial", Font.PLAIN, 20));
        label.setHorizontalAlignment(SwingConstants.CENTER);
        label.setForeground(Color.YELLOW);

        aiButton.setFont(new Font("Arial", Font.PLAIN, 15)); //button to play against computer
        aiButton.addActionListener(this);

        friendButton.setFont(new Font("Arial", Font.PLAIN, 15)); // button to play against a friend 
        friendButton.addActionListener(this);
        
        panel.add(aiButton, BorderLayout.SOUTH);
        panel.add(friendButton, BorderLayout.SOUTH);
        
        frame.add(panel, BorderLayout.CENTER);
        frame.setBackground(Color.BLACK);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 400);
        frame.setLocationRelativeTo(null); //put in middle of screen
        frame.setVisible(true);
    }


    public void actionPerformed(ActionEvent e) { //listens for click on a specific button
        JButton clickedButton = (JButton) e.getSource();
        if(clickedButton == friendButton){
            mode = 1; //play against a friend
            new GameGUI();
            frame.dispose(); //get rid of current frame
        }

        else if(clickedButton == aiButton){
            mode = 2; //play against computer
            new GameGUI();
            frame.dispose(); //get rid of current frame
        }
    }

    public static void main(String[] args){
        new IntroGUI(); //create a new IntroGUI to open it
    }

}
