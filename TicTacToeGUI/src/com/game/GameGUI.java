package com.game;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;


public class GameGUI implements ActionListener {
        private JFrame frame;
        private JButton[][] buttons = new JButton[3][3];
        private JLabel label = new JLabel("Player X's turn");
        private JPanel panel = new JPanel(new GridLayout(3,3));

        public static char currentPlayer = 'X';
        public static char[] boardArray = new char[] {'1', '2', '3', '4', '5', '6', '7', '8', '9'}; //array used to reset logic board
        private static JFrame oldFrame; //helps close old frames
        private int moveCount = 0; //keeps track for tie
        public static int move = 0;
        private Board gameBoard = new Board(); //define a board object (just 3x3 array of 1-9)
        public static boolean gamePlaying = true;

    
    public GameGUI(){  
        if(oldFrame!= null)
        {
            oldFrame.dispose(); //check if any extra frames, if so, dispose
        }
        frame = new JFrame("Conj's Tic-Tac-Toe");
        oldFrame = frame; //set new frame equal to old frame so we can correctly get rid of it

            
            panel.setBorder(BorderFactory.createEmptyBorder(10,10,10,10));
            panel.setBackground(Color.BLACK);

            for(int i = 0 ; i<3; i++){ //create 3x3 array of buttons, used for board
                for(int j = 0; j<3; j++)
                {
                    buttons[i][j] = new JButton("");
                    buttons[i][j].setFont(new Font("Arial", Font.PLAIN, 60));
                    buttons[i][j].addActionListener(this);
                    buttons[i][j].setBackground(Color.BLACK);
                    panel.add(buttons[i][j]);
                }
            }

            label.setForeground(Color.YELLOW);

            JPanel infoPanel = new JPanel();
            infoPanel.setBackground(Color.BLACK);
            infoPanel.add(label);
            JButton clearButton = new JButton("RESTART"); //clears board and restarts
            JButton changeMode = new JButton("Change Mode"); //takes user back to introGUI

            changeMode.addActionListener(this);
            clearButton.addActionListener(this);

            infoPanel.add(clearButton);
            infoPanel.add(changeMode);

            frame.setLayout(new BorderLayout());
            frame.add(panel, BorderLayout.CENTER);
            frame.add(infoPanel, BorderLayout.SOUTH);
            frame.setBackground(Color.BLACK);
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setSize(500,500);
            frame.setLocationRelativeTo(null);
            frame.setVisible(true);
        }

        public void actionPerformed(ActionEvent e){
            JButton clickedButton = (JButton) e.getSource();

            if(clickedButton.getText().equals("")){ //if clicked on an empty button (user is making a move)
                int count = 0;
                clickedButton.setText(Character.toString(currentPlayer)); //display the current players symbol on the button
                moveCount++;
                for(int i = 0; i<3; i++) //create an array of the current state of the board that is being displayed to the user
                {
                    for(int j = 0; j<3; j++) // we use this array to send the current state of the game to the logic part of the game
                    {
                        String buttonText = buttons[i][j].getText();
                        if(!buttonText.isEmpty())//make sure button isnt empty
                        {
                        if(buttonText.charAt(0) == 'O' || buttonText.charAt(0) == 'X')
                        {
                            boardArray[count] = buttonText.charAt(0);
                            move = count+1; //this tells the logic the move the user made (int 1-9)
                        }
                        }
                        count++;
                    }
                }
            if(IntroGUI.mode == 1) //2 player mode
            {
                getUserMove(); 
            }


        //AI Mode
        else if (IntroGUI.mode == 2)
        {
            gameBoard = updateBoard(gameBoard); //update logic based on move user just made
            gamePlaying = gameBoard.checkWin(gameBoard); //check to see if a player won
            if(!gamePlaying) //if game winning == false then we end and open the endGUI
            {
                EndGUI.displayString = currentPlayer+"'s Won!";
                new EndGUI();
                char[] array = new char[] {'1', '2', '3', '4', '5', '6', '7', '8', '9'}; 
                boardArray = array; //reset the array since a new game may be started
            }
            
            else if(moveCount == 9) //check for tie
            {
                EndGUI.displayString = "Game Over! It was a Tie!";
                new EndGUI();
                char[] array = new char[] {'1', '2', '3', '4', '5', '6', '7', '8', '9'};
                boardArray = array; //reset array
            }

            else{

            currentPlayer = (currentPlayer == 'X') ? 'O' : 'X'; //change player accordingly
            label.setText("Player "+currentPlayer+"'s turn");
                

            int aiMove = 0;
            aiMove = gameBoard.smartMove(gameBoard, currentPlayer);
            if(aiMove == 0) //if no "smart move" can be chosen
            {
                gameBoard.placeRandMove(gameBoard, currentPlayer); //randomly place a move
            }
            else gameBoard.placeMove(aiMove, gameBoard, currentPlayer); //place the smart move
            updateDiplay(); //update the display according to the computer/random move
            gamePlaying = gameBoard.checkWin(gameBoard); //check to see if someone won
            moveCount++; //increment in case of tie
            if(!gamePlaying) //check for win
            {
                EndGUI.displayString = currentPlayer+"'s Won!";
                new EndGUI();
                char[] array = new char[] {'1', '2', '3', '4', '5', '6', '7', '8', '9'};
                boardArray = array;
            }
            
            else if(moveCount == 9) //check for tie
            {
                EndGUI.displayString = "Game Over! It was a Tie!";
                new EndGUI();
                char[] array = new char[] {'1', '2', '3', '4', '5', '6', '7', '8', '9'};
                boardArray = array;
            }

            currentPlayer = (currentPlayer == 'X') ? 'O' : 'X'; //change player
            label.setText("Player "+currentPlayer+"'s turn");
        }
        }
                
            }
            else if(clickedButton.getText().equals("RESTART")) //if clicked the restart button
            {
                for(int i = 0; i<3; i++) //clear board
                {
                    for(int j = 0; j<3; j++)
                    {
                        buttons[i][j].setText("");
                    }
                }
                currentPlayer = 'X'; //reset player
                label.setText("Player "+currentPlayer+"'s turn");
                int count = 0;
                char[] array = new char[] {'1', '2', '3', '4', '5', '6', '7', '8', '9'};
                for(int i = 0; i<3; i++) //reset the board and array
                {
                    for (int j = 0; j<3; j++){
                        gameBoard.board[i][j] = array[count];
                        count++;
                    }
                }
                boardArray = array;
                moveCount = 0; //reset moveCount
                
            }

            else if(clickedButton.getText().equals("Change Mode")){
                frame.dispose();
                new IntroGUI(); //go back to intro
                char[] array = new char[] {'1', '2', '3', '4', '5', '6', '7', '8', '9'};
                boardArray = array;
                moveCount = 0;
                
            }
            
        }
        
        public static Board updateBoard(Board gameBoard) //takes changes made to GUI and updates logic board
        {
            int count = 0;
            for(int i = 0; i<3; i++)
            {
            for(int j = 0; j<3; j++)
            {
                gameBoard.board[i][j] = GameGUI.boardArray[count];
                count++;
            }
        }
            return gameBoard;
        }



        public void updateDiplay(){ //takes changes from logicboard and updates display
            int count = 0;
            for(int i = 0; i<3; i++)
            {
            for(int j = 0; j<3; j++)
            {
                boardArray[count] = gameBoard.board[i][j];
                count++;
            }
        }
        count = 0;
        for(int i = 0; i < 3; i++)
        {
            for(int j = 0; j< 3; j++)
            {
                char temp = boardArray[count];
                if(temp == 'O' || temp == 'X')
                {
                    buttons[i][j].setText(Character.toString(temp));
                    
                }
                count++;
            }
        }
        }

        public void getUserMove(){ //takes information from GUI and checks if there is a winner or tir
            gameBoard = updateBoard(gameBoard);
            gamePlaying = gameBoard.checkWin(gameBoard); //check to see if someone won
            if(!gamePlaying)
            {
                EndGUI.displayString = currentPlayer+"'s Won!";
                new EndGUI();
                char[] array = new char[] {'1', '2', '3', '4', '5', '6', '7', '8', '9'};
                boardArray = array;
            }
            
            else if(moveCount == 9) //check for tie
            {
                EndGUI.displayString = "Game Over! It was a Tie!";
                new EndGUI();
                char[] array = new char[] {'1', '2', '3', '4', '5', '6', '7', '8', '9'};
                boardArray = array;
            }
            currentPlayer = (currentPlayer == 'X') ? 'O' : 'X';
            label.setText("Player "+currentPlayer+"'s turn");   //change player
        }


        

        public static void main(String[] args){
            
            new GameGUI();
            
        }
}
