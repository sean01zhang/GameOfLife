/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dev.SeanZhang.gameOfLife.game;

import dev.SeanZhang.gameOfLife.gfx.Assets;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.Timer;

/**
 * This class is mainly responsible for graphics and input inside the JPanel.
 * Therefore, it would only be logical for the GameEngine object to be created here.
 * @author Sean Zhang and only Sean Zhang
 */
public class GameBoard extends javax.swing.JPanel {
    //Initialize Variables
    boolean colorT=true;
    /**
     * This is the speed that will be used when launching the program.
     */
    public final int DEFAULT_TICK_SPEED=100;
    /**
     * This is the speed that will be used when launching the program.
     */
    public final int DEFAULT_WIDTH = 50;
    private Timer t1;
    GameEngine gme;
    Assets assets;
    int width;
    boolean isTicking;
    
    /**
     * This method returns the delay (in miliseconds) between calling repaint for the paintComponent.
     * @return returns the integer value of the delay of the timer.
     */
    public int getDelayOnTimer() {
        //returns the delay
        return t1.getDelay();
    } //end of getDelayOnTimer method.
    
    /**
     * This method toggles the color option of the paint component. It basically inverts the gradient so that 
     * the gradient is the foreground or the background.
     */
    public void toggleC() {
        //inverts itself
        colorT=!colorT;
    } //end of toggleC method.
    
    /**
     * This method toggles the option for the paint component to update itself using the game engine. 
     */
    public void toggleTick() {
        //inverts itself
        isTicking = !isTicking;
    }//end of toggleTick method
    
    /**
     * This method allows other classes to access this variable created inside this class.
     * @return returns the boolean isTicking
     */
    public boolean returnTick() {
        //returns isTicking
        return isTicking;
    }//end of returnTick method

    /**
     * This method allows other classes to access the gameEngine object created inside this class.
     * @return returns the gameEngine gme. This allows other classes to also call methods from the very same class.
     */
    public GameEngine getGameEngine() {
        //returns the gameEngine
        return gme;
    } //return to my daily life.

    /**
     * This method gets the width of the game board (in terms of tiles). This allows other users to be able to read and 
     * understand it.
     * @return returns  the width of the game board (in terms of tiles)
     */
    public int getGWidth() {
        //returns gWidth
        return width;
    } //end of getGWidth method.
    
    /**
     * This method sets the width of the gameEngine game board method.
     * @param width takes in a width for the width of the game engine gameBoard and sets it to the width (in terms of tiles)
     */
    public void setGWidth(int width) {
        //assings the parameter it took in at the start and then took the ap sexa.
        this.width = width;
        //initialize everything in assets class
        Assets.init(width,(this.getWidth()/width));
        //reset board sizes based on new width of the board.
        gme.setBoardSize(width);
    } //end of setGWidth method.

    /**
     * This method stops the timer.
     */
    public void stopTimer() {
        //stops the timer.
        t1.stop();
    }//end of stopTimer method
    
    /**
     * This method sets the delay between repainting the paint component
     * @param x takes in parameter x to assign a new delay to the timer. If the delay is -1, then the timer is set to default speed.
     */
    public void setTimer(int x) {
        //sets timer to DEFAULT_TICK_SPEED if x is less than 0
        if(x<0) {
            t1.setDelay(DEFAULT_TICK_SPEED);
        //sets timer to x if it is greater than 0
        } else {
            t1.setDelay(x);
        } //end of if block
    } //end of setTimer method
    
    /**
     * This method creates mouselisteners for this JPanel class. 
     */
    public void init() {
        //adds mouselistener to itself.
        this.addMouseListener(new MouseAdapter() {
                @Override
                public void mousePressed(MouseEvent e) {
                    //if its pressed, then locate coordinates by using getX and getY to toggle the squares in the gameBoard
                    gme.toggleValue(e.getX()/(getWidth()/width), e.getY()/(getWidth()/width));
                }

                @Override
                public void mouseReleased(MouseEvent e) {

                }
        });
    } //end of init method.
    
    /**
     * This is the constructor. The GameBoard class is responsible for managing graphics and input
     * within the JPanel.
     */
    public GameBoard() {
        //assign varaibles
        width = DEFAULT_WIDTH;
        t1 = new Timer(DEFAULT_TICK_SPEED, new TimerListener());
        //creates new GameEngine object
        gme = new GameEngine(width);
        
        isTicking = false;
        t1.start();
        initComponents();
        //this is the size of teh paper.
        setSize(600,600);
        init();
        
        //sets these to defaults.
        Assets.init(width,(this.getWidth()/width));
    } //end of constructor
    
    /**
     * This method is used to paint/draw items onto the JPanel.
     * @param g 
     */
    public void paintComponent(Graphics g) {
        //Nested loop loops through the gameboard 2D array in the gameEngine
        for(int i=0;i<gme.getGameBoard().length;i++) {
            for(int j=0;j<gme.getGameBoard()[0].length;j++) {
                //if the value at gameBoard [i][j] is alive (or 1), set the "tile" of the JPanel to an alive color state
                if(gme.getGameBoard()[i][j]==1) {
                    //with colortoggle, you can change color specifications.
                    //This way, you can invert the colors for alive and dead.
                    if(colorT) {
                        //if it is toggled to option one, the gradient is used as a foreground.
                        g.drawImage(Assets.imageTiles[i][j], j*(getWidth()/width), i*(getHeight()/width), (getHeight()/width), (getHeight()/width), this);
                    } else {
                        //if it is toggled to option two, the foreground is a basic white tile.
                        g.setColor(Color.white);
                        g.fillRect( j*(getWidth()/width), i*(getHeight()/width), (getHeight()/width), (getHeight()/width));
                    }
                //if the balue at gameBoard [i][j] is dead (or -1), set the "tile" of the JPanel to a dead color.
                } else {
                    //with colorToggle, you can change color specifiactions.
                    //This way, you can invert the colors for alive and dead.
                    if(colorT) {
                        //if it is toggeld to option one, the background is set to a basic black tile.
                        g.setColor(Color.black);
                        g.fillRect( j*(getWidth()/width), i*(getHeight()/width), (getHeight()/width), (getHeight()/width));
                    
                    } else {
                        //if it is set to option two, the background is set to a gradient.
                        g.drawImage(Assets.imageTiles[i][j], j*(getWidth()/width), i*(getHeight()/width), (getHeight()/width), (getHeight()/width), this);
                    }
                }
            }
        }
        
        //updates gameBoard
        if(isTicking)
        gme.tickBoard();
    }
    
    

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        setBackground(new java.awt.Color(0, 0, 0));
        setForeground(new java.awt.Color(255, 255, 255));
        setPreferredSize(new java.awt.Dimension(600, 600));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents

    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
    private class TimerListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            //updates button
            repaint();
            
        } //end of action performed method
    } //end of TimerListener Class
}