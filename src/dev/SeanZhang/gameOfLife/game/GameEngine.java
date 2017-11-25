package dev.SeanZhang.gameOfLife.game;

import dev.SeanZhang.utils.Utils;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;
import javax.swing.Timer;

/**
 * The GameEngine class will be responsible for providing information on the gameBoard to other classes.
 * @author Sean Zhang and Only Sean Zhang
 */
public class GameEngine {
    //since my board is a square, the number of squares for both width and height 
    //are the same.
    private int widthInTiles;
    //these are my gameBoards. The placeholder is used so that the gameBoard can
    //be updated at the end. 
    private int[][] placeholder;
    private int[][] gameBoard;
    
    /**
     * Constructor for GameEngine Class
     * @param widthInTiles Takes in the wanted width/height (in tiles) for initialization of the 2D arrays.
     */
    public GameEngine(int widthInTiles) {
        //sets the size of the two board Variables 
        setBoardSize(widthInTiles);
        //sets all values in the gameBoard to -1
        clearScreen();
    }
    
    /**
     * This method is used to access the array, GameBoard, from other classes.
     * @return Returns the gameBoard variable stored in the GameEngine class. 
     */
    public int[][] getGameBoard() {
        return gameBoard;
    }
    
    /**
     * Re-Sizes the Board Size within the GameEngine
     * @param widthInTiles used to re-set the width of the arrays.
     */
    public void setBoardSize(int widthInTiles) {
        //assigns the parameter, widthInTiles to the variable in the class
        this.widthInTiles=widthInTiles;
        //initializes the two arrays with the dimensions as the parameter taken in
        placeholder=new int[widthInTiles][widthInTiles];
        gameBoard=new int[widthInTiles][widthInTiles];
        //sets all of the values in the gameBoard 2D array to -1
        clearScreen();
    } //end of setBoardSize method
    
    /**
     * This method sets all values inside the 2-Dimensional Array, gameBoard to dead, or -1.
     * This would "clear" the screen in the paintComponent, since all tiles are dead.
     */
    public void clearScreen() {
        //this block of code assigns every single value in the gameBoard array to -1.
        //this is done by looping through the array and using the Arrays.fill method
        //to fill in the sub-arrays within.
        for( int i = 0; i < gameBoard.length; i++ ) {
            Arrays.fill(gameBoard[i],-1);
        } //end of for loop
    }//end of clearScreen method
    
    /**
     * This method toggles (from -1 to 1 or from 1 to -1) the value stored at (x,y) of the gameBoard 2D array variable. 
     * This method will be useful in setting specific values inside the gameBoard array.
     * @param x This gets the x index of where you want to access the gameBoard array.
     * @param y This gets the y index of where you want to access the gameBoard array.
     */
    public void toggleValue(int x, int y) {
        //by multiplying it by -1, the value at index [y][x] is toggled 
        //(in between -1 and 1) and stored.
        gameBoard[y][x] *=-1;
    } //end of toggleValue method.

    /**
     * Updates the gameBoard based on the Conway's Game Of Life board rules.
     */
    public void tickBoard() {
        //copies the 2D array gameBoard to 2D array placeholder
        for( int i = 0; i < gameBoard.length; i++ ) {
            placeholder[i] = gameBoard[i].clone();
        }
        
        //goes through the entire 2d plane of tiles
        for(int i=0;i<gameBoard.length;i++) {
            for (int j=0;j<gameBoard[0].length;j++) {
                //counts number of neighbors
                int count=0;
                
                //goes through all the neighboring tiles of the current tile
                for(int y=-1;y<=1;y++) {
                    for(int x=-1;x<=1;x++) {
                        if(x==0 && y==0) { } else {
                            try {
                                if(gameBoard[y+i][x+j]>0) { count++;}
                            } catch(Exception e) {} //end of try-catch
                        } //end of if block
                    }}//end of nested for loop
                
                //checks rules for automation
                if(count<2 || count>=4) {
                    placeholder[i][j]=-1;
                } else if(count ==3) {
                    placeholder[i][j]=1;
                }

        } } //end of nested for loop
        
        
        //copies the updated array, placeholder to the original gameBoard array.
        for( int i = 0; i < gameBoard.length; i++ ) {
            gameBoard[i] = placeholder[i].clone();
        } //end of for loop.
        
        
    } //end of method    
} //end of gameEngine class

/*
    PSEUDOCODE FOR METHOD TICKBOARD()
    Given two 2D arraylists: 1 is a placeholder, the other is the gameboard.
        upadtes placeholder to equal gameboard
        COUNTED 2D LOOP: Loops through the 2D array by row, then column.
            create a temporary count varaible
            
            COUNTED 2D LOOP: Loops through all the tiles (including itself) around the tile
                DECISION: if the index is itself, then ignore. Otherwise:
                    TRY-CATCH: catchs the error if it tries to access an index out of the range
                        DECISION: If the value at the tile next to the current tile is alive,
                                  add one to the count
                        END OF DECISION            
                    END OF TRY-CATCH    
                END OF DECISION
                
            DECISION: Checks rules for automation: (These updates are assigned to the placeholder)
                        - If the cell has less than 2 or more than 3 neighbors, it dies.
                        - If the cell has 3 neighbors, it lives or becomes existent.
                        - Otherwise, do not change the state of the cell
        END OF COUNTED 2D LOOP
        
        Assign gameBoard to the values of placeholder.    
    END OF UPDATE METHOD
        
*/ 
