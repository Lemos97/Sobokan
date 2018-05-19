/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import javax.swing.JFrame;
/**
 *
 * @author bruno
 */
@SuppressWarnings("serial")
public class GameBoard extends JFrame{
    private GamePanel panel;
    public GameBoard(){
        super("Sokoban");
        panel = new GamePanel();
        
        start();
    }
    public void start(){
        setVisible(true);
        buildGui();
    }
    
    private void buildGui(){
        //JPanel masterPanel = new JPanel();
        //masterPanel.add(panel);
        add(panel);
        pack();//let you resize the board
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(true);
        setLocationRelativeTo(null);
        
    }
}
