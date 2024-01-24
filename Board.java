import java.util.Scanner;
import java.util.Random;

public class Board {
        public char[][] board;
         static Scanner scanner = new Scanner(System.in); //initalize scanner to get usr input
         
        public Board() {
            this.board = new char[][]{ //define the board
                {'1', '2', '3'},
                {'4', '5', '6'},
                {'7', '8', '9'}
            };
        }
    
        public void printBoard(Board gameBoard){ //method to print the board
            System.out.println();
            for(char[] row : board)
            {
                for(char cell : row)
                {
                    System.out.print(cell);
                }
                System.out.println();
            }
            System.out.println();
            }

        
            
            public  void placeMove(int move, Board gameBoard, char currentPlayer){ //takes the user input of move and puts it in the correct position and chekcs to see if it is an avialable move

                switch(move){
                    case 1:
                        if(gameBoard.board[0][0] == 'X' || gameBoard.board[0][0] == 'O')
                        {
                            
                        }
                        else gameBoard.board[0][0] = currentPlayer;
                        break;
                    case 2:
                        if(gameBoard.board[0][1] == 'X' || gameBoard.board[0][1] == 'O')
                        {
                            
                        }
                        else gameBoard.board[0][1] = currentPlayer;
                        break;
                    case 3:
                        if(gameBoard.board[0][2] == 'X' || gameBoard.board[0][2] == 'O')
                        {
                            
                        }
                        else gameBoard.board[0][2] = currentPlayer;
                        break;
                    case 4:
                        if(gameBoard.board[1][0] == 'X' || gameBoard.board[1][0] == 'O')
                        {
                            
                        }
                        else gameBoard.board[1][0] = currentPlayer;
                        break;
                    case 5:
                        if(gameBoard.board[1][1] == 'X' || gameBoard.board[1][1] == 'O')
                        {
                            
                        }
                        else gameBoard.board[1][1] = currentPlayer;
                        break;
                    case 6:
                        if(gameBoard.board[1][2] == 'X' || gameBoard.board[1][2] == 'O')
                        {
                            
                        }
                        else gameBoard.board[1][2] = currentPlayer;
                        break;
                    case 7:
                        if(gameBoard.board[2][0] == 'X' || gameBoard.board[2][0] == 'O')
                        {
                            
                        }
                        else gameBoard.board[2][0] = currentPlayer;
                        break;
                    case 8:
                        if(gameBoard.board[2][1] == 'X' || gameBoard.board[2][1] == 'O')
                        {
                            
                        }
                        else gameBoard.board[2][1] = currentPlayer;
                        break;
                    case 9:
                        if(gameBoard.board[2][2] == 'X' || gameBoard.board[2][2] == 'O')
                        {
                            
                        }
                        else gameBoard.board[2][2] = currentPlayer;
                        break;
                    default:
                        
                }
            }
    


           
        public  boolean checkVertical(char[] array){ //checks to see if three in a row vertically
            if(array[0] == array[3] && array[3] == array[6])
            {
                return false; //false means the game is over
            }
            if(array[1] == array[4] && array[4] == array[7])
            {
                return false;
            }
            if(array[2] == array[5] && array[5] == array[8])
            {
                return false;
            }
            return true; //true if none of the vertical lines are the same
        }
    
        public boolean checkHorizontal(char[] array){ //same as vertical but horizontal
            if(array[0] == array[1] && array[1] == array[2])
            {
                return false;
            }
            if(array[3] == array[4] && array[4] == array[5])
            {
                return false;
            }
            if(array[6] == array[7] && array[7] == array[8])
            {
                return false;
            }
            return true;
        }
    
         public boolean checkDiagonal(char[] array){ //same as previous, but diagonal
            if(array[0] == array[4] && array[4] == array[8])
            {
                return false;
            }
            if(array[2] == array[4] && array[4] == array[6])
            {
                return false;
            }
            return true;
        }
    
       
    
        public boolean checkWin(Board gameBoard){ //puts elements from board into an array to check if a player has won
            char[] array = new char[9];
            int p = 0;
            int j = 0;
            for(int i = 0; i<3;i++)
            {
                j=0;
                while(j<3)
                {
                    array[p] = gameBoard.board[i][j];
                    j++;
                    p++;
                }
            }
            boolean gamePlaying = true;
            gamePlaying = checkHorizontal(array); //check each possible way someone could win
            if(!gamePlaying)
            {
                //System.out.println("Game Over! Player "+player.playerNumber+" won!");
                return false;
            }
            gamePlaying = checkVertical(array);
            if(!gamePlaying)
            {
                //System.out.println("Game Over! Player "+player.playerNumber+" won!");
                return false;
            }
            gamePlaying = checkDiagonal(array);
            if(!gamePlaying)
            {
                //System.out.println("Game Over! Player "+player.playerNumber+" won!");
                return false;
            }
            return true;
    
        }


        public int randMoveCheck(int move, Board gameBoard, char currentPlayer){ //takes the user input of move and puts it in the correct position and chekcs to see if it is an avialable move

        switch(move){
            case 1:
                if(gameBoard.board[0][0] == 'X' || gameBoard.board[0][0] == 'O')
                {
                    return 1;
                }
                else 
                {
                    gameBoard.board[0][0] = currentPlayer;
                    return 0;
                }
                
            case 2:
                if(gameBoard.board[0][1] == 'X' || gameBoard.board[0][1] == 'O')
                {
                    return 1;
                }
                else gameBoard.board[0][1] = currentPlayer; return 0;
                
            case 3:
                if(gameBoard.board[0][2] == 'X' || gameBoard.board[0][2] == 'O')
                {
                    return 1;
                }
                else gameBoard.board[0][2] = currentPlayer; return 0;
                
            case 4:
                if(gameBoard.board[1][0] == 'X' || gameBoard.board[1][0] == 'O')
                {
                    return 1;
                }
                else gameBoard.board[1][0] = currentPlayer; return 0;
                
            case 5:
                if(gameBoard.board[1][1] == 'X' || gameBoard.board[1][1] == 'O')
                {
                    return 1; 
                }
                else gameBoard.board[1][1] = currentPlayer; return 0;
                
            case 6:
                if(gameBoard.board[1][2] == 'X' || gameBoard.board[1][2] == 'O')
                {
                    return 1;
                }
                else gameBoard.board[1][2] = currentPlayer; return 0;
                
            case 7:
                if(gameBoard.board[2][0] == 'X' || gameBoard.board[2][0] == 'O')
                {
                    return 1;
                }
                else gameBoard.board[2][0] = currentPlayer; return 0;
                
            case 8:
                if(gameBoard.board[2][1] == 'X' || gameBoard.board[2][1] == 'O')
                {
                    return 1;
                }
                else gameBoard.board[2][1] = currentPlayer; return 0;
                
            case 9:
                if(gameBoard.board[2][2] == 'X' || gameBoard.board[2][2] == 'O')
                {
                    return 1;
                }
                else gameBoard.board[2][2] = currentPlayer; return 0;
                
            default:
                return 1;

        }
    }


    public void placeRandMove(Board gameBoard, char currentPlayer)
    {
        int[] cornerArray = new int[4]; //make an array for each corner
        int i = 0;
        Random random = new Random();
        int check = 1;
        if(gameBoard.board[0][0] != 'X' && gameBoard.board[0][0] != 'O')
        {
            cornerArray[i] = Character.getNumericValue(gameBoard.board[0][0]);
            i++; //only put in array if it is a makeable move
        }
        if(gameBoard.board[0][2] != 'X' && gameBoard.board[0][2] != 'O')
        {
            cornerArray[i] = Character.getNumericValue(gameBoard.board[0][2]);
            i++;
        }
        if(gameBoard.board[2][0] != 'X' && gameBoard.board[2][0] != 'O')
        {
            cornerArray[i] = Character.getNumericValue(gameBoard.board[2][0]);
            i++;
        }
        if(gameBoard.board[2][2] != 'X' && gameBoard.board[2][2] != 'O')
        {
            cornerArray[i] = Character.getNumericValue(gameBoard.board[2][2]);
            i++;
        }
        if(i>0) //if any corners are available, randomly pick a corner to place a move
        {
        int index = random.nextInt((i - 0) + 0) + 0;
        check = randMoveCheck(cornerArray[index], gameBoard, currentPlayer);
        }
        if(i == 0) //if all corners are taken, randomly pick a move
        {
        while(check == 1) //make sure the move was avaiable and keep generating until it works
        {
            int move =  random.nextInt((9 - 1) + 1) + 1;
            check = randMoveCheck(move, gameBoard, currentPlayer);
        }
    }
    }

    public int checkWinCurrent(char current[], char p) //checks to see if there are two elements that are the same in a row, column or diagonal, that can let the computer win
    {
        if(current[0] == current[1] && p == current[0])
        {
            if(current[2] != 'X' && current[2] != 'O')
            {
                int temp = Character.getNumericValue(current[2]);
                return temp;
            }
        }

        if(current[1] == current[2] && p == current[1])
        {
            if(current[0] != 'X' && current[0] != 'O')
            {
                int temp = Character.getNumericValue(current[0]);
                return temp;
            }
        }

        if(current[0] == current[2] && p == current[0])
        {
            if(current[1] != 'X' && current[1] != 'O')
            {
                int temp = Character.getNumericValue(current[1]);
                return temp;
            }
        }

        return 0;
    }

     public int checkCurrent(char current[]) //same a sprevious function, but looks to block, not to win
    {
        if(current[0] == current[1])
        {
            if(current[2] != 'X' && current[2] != 'O')
            {
                int temp = Character.getNumericValue(current[2]);
                return temp;
            }
        }

        if(current[1] == current[2])
        {
            if(current[0] != 'X' && current[0] != 'O')
            {
                int temp = Character.getNumericValue(current[0]);
                return temp;
            }
        }

        if(current[0] == current[2])
        {
            if(current[1] != 'X' && current[1] != 'O')
            {
                int temp = Character.getNumericValue(current[1]);
                return temp;
            }
        }

        return 0;
    }

    public int smartMove(Board gameBoard, char currentPlayer) //uses checkWinCurrent and checkCurrent to see where best move is
    {
        if(gameBoard.board[1][1] != 'X' && gameBoard.board[1][1] != 'O')
        {
            return 5; //if middle is empty, pick middle
        }
        char array[] = new char[3];
        int count = 0;
        int temp = 0;
        for(int i = 0; i<3; i++) //all horizonatal combos
        {
            count = 0;
            for(int j = 0; j<3; j++)
            {
                array[count] = gameBoard.board[i][j];
                count++;
            }
            temp = checkWinCurrent(array, currentPlayer); //checks to see if computer can win on a specific move
            if(temp!=0)
            {
                return temp; //if so, return it
            }
            
        }


        for(int i = 0; i<3; i++) //vertical version
        {
            count = 0;
            for(int j = 0; j<3; j++)
            {
                array[count] = gameBoard.board[j][i];
                count++;
            }
            temp = checkWinCurrent(array, currentPlayer);
            if(temp!=0)
            {
                return temp;
            }
        }


        count = 0;
        for(int i = 0; i<3; i++) //diagonal version
        {
            
            int j = i;
            array[count] = gameBoard.board[i][j];
            count++;
        }
        temp = checkWinCurrent(array, currentPlayer);
            if(temp!=0)
            {
                return temp;
            }
        

        int w = 2;
        count = 0;
        for(int i = 0; i<3; i++) //diagonal version
        {
            array[count] = gameBoard.board[w][i];
            count++;
            w--;
        }
        temp = checkWinCurrent(array, currentPlayer);
            if(temp!=0)
            {
                return temp;
            }
        


            //check to block


            for(int i = 0; i<3; i++) //horizontal
        {
            count = 0;
            for(int j = 0; j<3; j++)
            {
                array[count] = gameBoard.board[i][j];
                count++;
            }
            
            temp = checkCurrent(array);
            if(temp!=0)
            {
                return temp;
            }
        }


        for(int i = 0; i<3; i++) //vertical
        {
            count = 0;
            for(int j = 0; j<3; j++)
            {
                array[count] = gameBoard.board[j][i];
                count++;
            }
            
            temp = checkCurrent(array);
            if(temp!=0)
            {
                return temp;
            }
        }


        count = 0;
        for(int i = 0; i<3; i++) //diagonal
        {
            array[count] = gameBoard.board[i][i];
            count++;
        }
        
        temp = checkCurrent(array);
        if(temp!=0)
            {

                return temp;
            }

        count = 0;
        for (int i = 0, j = 2; i < 3; i++, j--) //diagonal
        {
            array[count] = gameBoard.board[j][i];
            //System.out.println(array[count]);
            count++;
            
        }
        
        temp = checkCurrent(array);
        if(temp!=0)
            {
                return temp;
            }

        

        return temp;
    }

    public void closeScanner()
        {
            scanner.close();    //close the scanner
        }
        
    
        // Other methods as needed
    
    
}
