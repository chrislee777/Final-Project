import java.awt.EventQueue;

import javax.swing.ButtonGroup;
import javax.swing.JFrame;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JMenu;
import javax.swing.JOptionPane;
import javax.swing.JToggleButton;

import java.awt.*;
import javax.swing.JButton;
import javax.swing.JSeparator;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JRadioButtonMenuItem;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.WindowEvent;

import java.util.*;

public class MinesweeperGUI implements ActionListener{
    private JFrame frmMinesweeper;
    private JToggleButton[][] tiles;
    private Container grid;

    private int width;
    private int height;
    private int mines;

    private boolean first; //first click pressed or not

    private MinesweeperBoard logic;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
                public void run() {
                    try {
                        MinesweeperGUI window = new MinesweeperGUI();
                        window.frmMinesweeper.setVisible(true);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            });
    }

    /**
     * Create the application.
     */
    public MinesweeperGUI() {
        width = 9;
        height = 9;
        mines = 10;
        first = true;
        initialize();
    }

    /**
     * Initialize the contents of the frame.
     */
    private void initialize() {
        //main frame (auto generated)
        frmMinesweeper = new JFrame();
        frmMinesweeper.setTitle("Minesweeper");
        frmMinesweeper.setBounds(100, 100, 300, 300);
        frmMinesweeper.setLayout(new BorderLayout());
        frmMinesweeper.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        //grid for tiles
        grid = new Container();
        grid.setLayout(new GridLayout(height,width));

        //creating button grid
        tiles = new JToggleButton[height][width];
        for(int r = 0; r < tiles.length; r++){
            for(int c = 0; c < tiles[0].length; c++){
                tiles[r][c] = new JToggleButton();
                tiles[r][c].addActionListener(this);
                tiles[r][c].setFocusPainted(false); //removes the blue border
                grid.add(tiles[r][c]);

            }
        }

        frmMinesweeper.add(grid,BorderLayout.CENTER);

        //all menu stuff is auto generated
        //main menu bar
        JMenuBar menuBar = new JMenuBar();
        frmMinesweeper.setJMenuBar(menuBar);

        //game menu section
        JMenu mnNewMenu = new JMenu("Game");
        menuBar.add(mnNewMenu);

        JMenuItem mntmNewMenuItem = new JMenuItem("New");
        mntmNewMenuItem.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    restart();
                }
            });
        mnNewMenu.add(mntmNewMenuItem);

        JMenuItem mntmStatistics = new JMenuItem("Statistics");
        mntmStatistics.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {

                }
            });
        mnNewMenu.add(mntmStatistics);

        JMenuItem mntmNewMenuItem_1 = new JMenuItem("Exit");
        mntmNewMenuItem_1.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    frmMinesweeper.dispatchEvent(new WindowEvent(frmMinesweeper, WindowEvent.WINDOW_CLOSING));
                }
            });
        mnNewMenu.add(mntmNewMenuItem_1);

        //mode menu section
        JMenu mnMode = new JMenu("Mode");
        menuBar.add(mnMode);

        ButtonGroup group = new ButtonGroup();

        JRadioButtonMenuItem rdbtnmntmBeginnerxMines = new JRadioButtonMenuItem("Beginner              9x9,10 Mines");
        rdbtnmntmBeginnerxMines.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    width = 9;
                    height = 9;
                    mines = 10;
                }
            });
        rdbtnmntmBeginnerxMines.setSelected(true);
        group.add(rdbtnmntmBeginnerxMines);
        mnMode.add(rdbtnmntmBeginnerxMines);

        JRadioButtonMenuItem rdbtnmntmIntermediatex = new JRadioButtonMenuItem("Intermediate       16x16, 40 mines");
        rdbtnmntmIntermediatex.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    width = 16;
                    height = 16;
                    mines = 40;
                }
            });
        group.add(rdbtnmntmIntermediatex);
        mnMode.add(rdbtnmntmIntermediatex);

        JRadioButtonMenuItem rdbtnmntmAdvancedx = new JRadioButtonMenuItem("Advanced            16x30, 99 Mines");
        rdbtnmntmAdvancedx.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    width = 30;
                    height = 16;
                    mines = 99;
                }
            });
        group.add(rdbtnmntmAdvancedx);
        mnMode.add(rdbtnmntmAdvancedx);

        //help menu section
        JMenu mnHelp = new JMenu("Help");
        menuBar.add(mnHelp);

        JMenuItem mntmAbout = new JMenuItem("About");
        mntmAbout.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    JOptionPane.showMessageDialog(null, "Made by Chris Lee, Jason Lu, Derek Chen");
                }
            });
        mnHelp.add(mntmAbout);

        //auto generated code that idk what it is so just let it stay here
        //frmMinesweeper.getContentPane().setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
    }

    //resets the game
    public void restart(){
        frmMinesweeper.remove(grid); //removes grid from the frame

        //grid for tiles
        grid = new Container();
        grid.setLayout(new GridLayout(height,width));

        //creating button grid
        tiles = new JToggleButton[height][width];
        for(int r = 0; r < tiles.length; r++){
            for(int c = 0; c < tiles[0].length; c++){
                tiles[r][c] = new JToggleButton();
                tiles[r][c].addActionListener(this);
                tiles[r][c].setFocusPainted(false); //removes the blue border
                grid.add(tiles[r][c]);

            }
        }

        frmMinesweeper.add(grid,BorderLayout.CENTER); //adds it back to the frame
        
        //solution for manually refreshing the frame without needing to resize it
        frmMinesweeper.invalidate();
        frmMinesweeper.validate();
        frmMinesweeper.repaint();

        first = true; //makes it regenerate the board at actionPeformed
    }

    // :(
    public void gameOver(){
        
        
    }

    //ACTION!!!
    public void actionPerformed(ActionEvent e) {
        // TODO Auto-generated method stub

        //action performed for tiles
        for(int r = 0; r < tiles.length; r++){
            for(int c = 0; c < tiles[0].length; c++){
                if(e.getSource().equals(tiles[r][c])){
                    //creates logic if the first button
                    if(first){
                        first = false;
                        logic = new MinesweeperBoard(height,width,mines,r,c);
                    }

                    //sets value of button
                    if(logic.getValue(r,c) != 0){
                        tiles[r][c].setText(""+logic.getValue(r,c));
                    }
                    else{
                        //if the value is 0, selects all the zeroes on the board
                        finalShowZero(r,c);
                    }

                    //makes button unselectable after clicked
                    if(!tiles[r][c].isSelected()){
                        tiles[r][c].setSelected(true);
                    }
                }
            }
        }

    }

    //returns true if there is an unclicked zero 
    public boolean nearUnclickedZero(int row, int col){
        boolean result = false;
        if(logic.getValue(row,col)==0){
            for(int r = Math.max(0,row -1); r <= Math.min(height-1,row+1); r++){
                for(int c = Math.max(0,col-1); c <= Math.min(width-1,col+1); c++){
                    if(logic.getValue(r,c)==0 && !tiles[r][c].isSelected()){
                        result = true;
                    }
                }
            }
        }
        return result;
    }

    //reveals 3v3 around a zero
    public void revealZero(int r, int c){
        if(logic.getValue(r,c)==0){
            for(int row = Math.max(0,r -1); row <= Math.min(height-1,r +1); row++){
                for(int col = Math.max(0,c -1); col <= Math.min(width-1,c +1); col++){
                    tiles[row][col].setSelected(true);
                    if(logic.getValue(row,col)!=0){
                        tiles[row][col].setText(""+logic.getValue(row,col));
                    }
                }
            }
        }
    }

    //reveals all the surrounding zeros
    public void finalShowZero(int r, int c){
        revealZero(r,c);
        for(int row = Math.max(0,r -1); row <= Math.min(height-1,r +1); row++){
            for(int col = Math.max(0,c -1); col <= Math.min(width-1,c +1); col++){
                if(nearUnclickedZero(row,col)){
                    finalShowZero(row,col); //RECURSION!!!
                }
                else{
                    if(logic.getValue(row,col)==0){
                        revealZero(row,col); //if no zeroes are unselected but still surrounding stuff is unchosen
                    }
                }
            }
        }
    }
}