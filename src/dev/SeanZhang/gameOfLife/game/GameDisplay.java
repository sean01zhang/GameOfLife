package dev.SeanZhang.gameOfLife.game;

//import statements
import com.sun.glass.events.KeyEvent;
import dev.SeanZhang.utils.Utils;
import java.awt.Color;
import javax.swing.ImageIcon;
import javax.swing.JFrame;

/**
 * This class will be mainly responsible for input and output outside the JPanel.
 * @author Sean Zhang and only Sean Zhang
 */
public class GameDisplay extends JFrame {

    //ImageIcon will be used to store the icon of the application
    ImageIcon logo;

    /**
     * Constructor for the GameDisplay class. This class is responsible for
     * input and graphics outside of the JPanel.
     */
    public GameDisplay() {
        //sets the icon of the JFrame to an image stored at a specific directory in the project.
        logo = new ImageIcon(getClass().getResource("/res/logo/GameOfLife.png"));
        setIconImage(logo.getImage());
        //initializes all the graphical components to the JFrame in this class.
        initComponents();
    } //end of constructor.

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        startStopButton = new javax.swing.JButton();
        speedSlider = new javax.swing.JSlider();
        speedLabel = new javax.swing.JLabel();
        presetCombo = new javax.swing.JComboBox<>();
        clearButton = new javax.swing.JButton();
        gBoardWidthTF = new javax.swing.JTextField();
        gb = new dev.SeanZhang.gameOfLife.game.GameBoard();
        widthButton = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        toggleCol = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Game Of Life");
        setResizable(false);
        setSize(new java.awt.Dimension(820, 600));

        startStopButton.setText("Start");
        startStopButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                startStopButtonMousePressed(evt);
            }
        });

        speedSlider.setMaximum(200);
        speedSlider.setMinimum(1);
        speedSlider.setValue(100);
        speedSlider.setInverted(true);
        speedSlider.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                speedSliderStateChanged(evt);
            }
        });

        speedLabel.setText("Speed");

        presetCombo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Custom", "Glider Gun", "Pulsar", "Random" }));
        presetCombo.setToolTipText("");
        presetCombo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                presetComboActionPerformed(evt);
            }
        });

        clearButton.setText("Clear Screen");
        clearButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                clearButtonMousePressed(evt);
            }
        });

        gBoardWidthTF.setForeground(new java.awt.Color(204, 204, 204));
        gBoardWidthTF.setText("Enter Width");
        gBoardWidthTF.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                gBoardWidthTFMouseClicked(evt);
            }
        });
        gBoardWidthTF.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                gBoardWidthTFKeyPressed(evt);
            }
        });

        gb.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        javax.swing.GroupLayout gbLayout = new javax.swing.GroupLayout(gb);
        gb.setLayout(gbLayout);
        gbLayout.setHorizontalGroup(
            gbLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 596, Short.MAX_VALUE)
        );
        gbLayout.setVerticalGroup(
            gbLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 596, Short.MAX_VALUE)
        );

        widthButton.setText("Enter");
        widthButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                widthButtonMouseClicked(evt);
            }
        });

        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/res/logo/GamOfLife_Small.png"))); // NOI18N

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Game of Life");

        toggleCol.setText("Toggle Colors");
        toggleCol.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                toggleColMousePressed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(gb, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(80, 80, 80)
                        .addComponent(startStopButton))
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addComponent(presetCombo, javax.swing.GroupLayout.PREFERRED_SIZE, 181, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(30, 30, 30)
                        .addComponent(gBoardWidthTF, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(5, 5, 5)
                        .addComponent(widthButton))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addComponent(speedSlider, javax.swing.GroupLayout.PREFERRED_SIZE, 147, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(3, 3, 3)
                        .addComponent(speedLabel))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(60, 60, 60)
                        .addComponent(toggleCol))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(62, 62, 62)
                        .addComponent(clearButton))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(gb, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(170, 170, 170)
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(240, 240, 240)
                        .addComponent(startStopButton))
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(clearButton)
                .addGap(16, 16, 16)
                .addComponent(presetCombo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(gBoardWidthTF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(widthButton))
                .addGap(27, 27, 27)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(speedSlider, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(speedLabel))
                .addGap(24, 24, 24)
                .addComponent(toggleCol))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    //used as a toggle for the buttons as they will have two states.
    int hasStarted = -1;

    /**
     * This method will start and stop the JPanel from updating itself with the
     * gameLoop.
     *
     * @param evt passed to the method so that it is eligible to listen for
     * mouse aspects
     */
    private void startStopButtonMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_startStopButtonMousePressed
        //toggles the has started variable
        hasStarted *= -1;
        //toggles whether or not the paintComponent updates itself with the gameEngine (basically preventing the gameEngine from ticking)
        gb.toggleTick();

        //sets the text of the button to be consistent with what the button is set to.
        if (gb.returnTick()) {
            startStopButton.setText("Stop");
        } else {
            startStopButton.setText("Start");
        }
    }//GEN-LAST:event_startStopButtonMousePressed

    /**
     * This method will set all tiles to dead, or clears it. This is done by
     * setting the Game Engine's gameBoard values to -1 and then stops the
     * paintComponent from updating itself with the game engine.
     *
     * @param evt passed to the method so that it is eligible to listen for
     * mouse aspects
     */
    private void clearButtonMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_clearButtonMousePressed
        //clears the screen
        gb.getGameEngine().clearScreen();
        //if the paintComponent was updating itself using the Game engine, this is stopped.
        if (gb.returnTick()) {
            gb.toggleTick();
            startStopButton.setText("Start");
        }
    }//GEN-LAST:event_clearButtonMousePressed

    /**
     * This method will change the width when the user presses the enter key in
     * the width text field.
     *
     * @param evt passed to the method so that it is eligible to listen for key
     * events
     */
    private void gBoardWidthTFKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_gBoardWidthTFKeyPressed
        //activates only when enter has been pressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            //sets width of the board in terms of tiles
            gb.setGWidth(Integer.parseInt(gBoardWidthTF.getText()));
            //this grays out the text, "Enter Width" in the text field.
            gBoardWidthTF.setForeground(new Color(204, 204, 204));
            //resets text to "Enter Width"
            gBoardWidthTF.setText("Enter Width");
        } //end of if statement
    }//GEN-LAST:event_gBoardWidthTFKeyPressed

    /**
     * This method changes the speed at which the paintComponents redraws at.
     * The lower the value, the faster it is.
     *
     * @param evt is passed to the method so that it is eligible to listen for
     * changes in the slider.
     */
    private void speedSliderStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_speedSliderStateChanged
        //sets the timer to the value of the slider.
        gb.setTimer((int) speedSlider.getValue());
    }//GEN-LAST:event_speedSliderStateChanged

    /**
     * This method allows the user to choose from a variety of preset game of
     * life board layouts.
     *
     * @param evt passed to the method so that it is eligible to listen for
     * changes in the combo
     */
    private void presetComboActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_presetComboActionPerformed
        //this takes in the chosen index of the preset in the combo box and stores it.
        int chosenPreset = presetCombo.getSelectedIndex();

        //switch statement for determining which map to generate
        switch (chosenPreset) {
            case 0:
                //custon, no need to generate any map.
                break;

            case 1:
                //generates map from the file directory specified.
                genMap("src/res/presets/preset1.txt");
                break;

            case 2:
                //generates map from the file directory specified.
                genMap("src/res/presets/preset2.txt");
                break;

            case 3:
                //generates map randomly with a 50% chance of a live square.
                randomMap();
                break;
        }

        //sets timer to speedSlider's value.
        gb.setTimer(speedSlider.getValue());
    }//GEN-LAST:event_presetComboActionPerformed

    /**
     * This method is responsible for the reformatting of the text field when a
     * user clicks on it.
     */
    private void gBoardWidthTFMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_gBoardWidthTFMouseClicked
        //sets text field to black
        gBoardWidthTF.setForeground(Color.BLACK);
        //sets textField text to nothing.
        gBoardWidthTF.setText("");
    }//GEN-LAST:event_gBoardWidthTFMouseClicked

    /**
     * This method will change the width when the user presses this button.
     *
     * @param evt passed to the method so that it is eligible to listen for
     * mouse aspects
     */
    private void widthButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_widthButtonMouseClicked
        //sets width of the game board in terms of tiles
        try {
            gb.setGWidth(Integer.parseInt(gBoardWidthTF.getText()));
        } catch (Exception e) {
        }
        //resets the formatting when it is not highlighted.
        gBoardWidthTF.setForeground(new Color(204, 204, 204));
        gBoardWidthTF.setText("Enter Width");
    }//GEN-LAST:event_widthButtonMouseClicked

    /**
     * Color toggle method. This method changes the way the paintComponent draws
     * things.
     */
    private void toggleColMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_toggleColMousePressed
        //toggles the color option preset
        gb.toggleC();
    }//GEN-LAST:event_toggleColMousePressed

    /**
     * This method generates a random map with a 50% chance of generating an
     * alive tile.
     */
    public void randomMap() {
        //clears screen so that all tiles are dead.
        gb.getGameEngine().clearScreen();
        for (int i = 0; i < gb.getGWidth(); i++) {
            for (int j = 0; j < gb.getGWidth(); j++) {
                //if the randomly generated number is one, then run the following code:
                if (Math.round(Math.random()) > 0) {
                    //toggles value from (we know that it will always be -1) to 1 to indicate that it is alive.
                    gb.getGameEngine().toggleValue(i, j);
                } //end of if statement
            }
        } //end of nested for loop
    } //end of randomMap method
    
    /**
     * This method generates a new map from the text file parameter taken in.
     * @param path the location of the file preset.
     */
    public void genMap(String path) {
        //init objects for file reading
        String file = Utils.loadFileAsString(path);
        //this splits the file with white spaces.
        String[] brokenFile = file.split("\\s+");
        //this is the minimum width the grid has to be for this to work. 
        int w = Utils.parseInt(brokenFile[0]);
        //if it is not, then just set it as your width.
        if (gb.width < w) {
            //sets width to varaible w
            gb.setGWidth(w);
        }
        //Seta all values inside the 2D array, to -1 (or dead)
        gb.getGameEngine().clearScreen();
        //loops through the for array
        for (int i = 1; i < brokenFile.length; i++) {
            if (Utils.parseInt(brokenFile[i]) > 0) {
                //toggles the value of gameEngine[i][j] to 1 if there was a 1 in the file.
                gb.getGameEngine().toggleValue((i - 1) % w, ((i - 1) / w));
            }
        }
    }

    /**
     * Main method
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(GameDisplay.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(GameDisplay.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(GameDisplay.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(GameDisplay.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new GameDisplay().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton clearButton;
    private javax.swing.JTextField gBoardWidthTF;
    private dev.SeanZhang.gameOfLife.game.GameBoard gb;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JComboBox<String> presetCombo;
    private javax.swing.JLabel speedLabel;
    private javax.swing.JSlider speedSlider;
    private javax.swing.JButton startStopButton;
    private javax.swing.JButton toggleCol;
    private javax.swing.JButton widthButton;
    // End of variables declaration//GEN-END:variables

}
