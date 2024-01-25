package com.game;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;


public class EndGUI implements ActionListener{
    private JFrame frame = new JFrame("Game Over!");
    private JButton restartButton = new JButton("Restart");
    private JButton exitButton = new JButton("Exit");
    private JPanel panel = new JPanel(new GridLayout(3, 1));
    public static String displayString = "";
    private JLabel label = new JLabel(displayString);

    public EndGUI(){
        panel.setBorder(BorderFactory.createEmptyBorder(10,25,10,25));
        panel.setBackground(Color.BLACK);

        restartButton.addActionListener(this);
        exitButton.addActionListener(this);

        panel.add(label, BorderLayout.NORTH);
        panel.add(restartButton);
        panel.add(exitButton);

        label.setHorizontalAlignment(SwingConstants.CENTER);
        label.setForeground(Color.YELLOW);

        frame.setLayout(new BorderLayout());
        frame.add(panel, BorderLayout.CENTER);
        frame.setBackground(Color.BLACK);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(250,250);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    public void actionPerformed(ActionEvent e){
        JButton clickedButton = (JButton) e.getSource();

        if(clickedButton.getText().equals("Restart")){ //go back to IntroGUI and allow user to pick game
            frame.dispose();
            GameGUI.gamePlaying = true;
            new IntroGUI();
        }

        else if(clickedButton.getText().equals("Exit")){ //close the game
            System.exit(0);
        }


    }

    public static void main(String[] args){
        new EndGUI();
    }
}               
