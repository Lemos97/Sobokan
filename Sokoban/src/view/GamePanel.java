/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JPanel;
import javax.swing.Timer;
import model.Player;

/**
 *
 * @author bruno
 */
public class GamePanel extends JPanel{
    private static final int DEFAULT_WIDTH = 320;
    private static final int DEFAULT_HEIGHT = DEFAULT_WIDTH / 12 * 9;
    private static final int SCALE = 2;
    private final int timerDelay;
    private final Timer timer;

    
    public GamePanel() {
        super();
        this.setPreferredSize(new Dimension(220 * SCALE,DEFAULT_HEIGHT * SCALE));
        this.setMinimumSize(new Dimension(220 * SCALE,DEFAULT_HEIGHT * SCALE));
        this.setMaximumSize(new Dimension(DEFAULT_WIDTH * SCALE,DEFAULT_HEIGHT * SCALE));
        this.setBackground(Color.yellow);
        
        this.setVisible(true);
        timerDelay = 500;
        timer = new Timer(timerDelay, gameTimer);
        timer.start();
    }
    
    public void paintComponent(Graphics g){
        //super.paintComponent(g);
        
        //g.drawRect(150, 50, 10, 10);
        Player player = new Player(Color.white);
        player.paintComponent(g);
        
    }
    
    
    
    public void redraw(){
        this.repaint();
    }
    
    ActionListener gameTimer = new ActionListener(){
        @Override
        public void actionPerformed(ActionEvent evt){
            redraw();
        }        
    };
    
}
