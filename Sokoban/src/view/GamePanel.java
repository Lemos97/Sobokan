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

/**
 *
 * @author bruno
 */
public class GamePanel extends JPanel{
    private static final int DEFAULT_WIDTH = 800;
    private static final int DEFAULT_HEIGHT = 600;
    private final int timerDelay;
    private final Timer timer;

    
    public GamePanel() {
        super();
        this.setPreferredSize(new Dimension(DEFAULT_WIDTH,DEFAULT_HEIGHT));
        this.setVisible(true);
        this.setBackground(Color.BLACK);
        this.setMinimumSize(new Dimension(DEFAULT_WIDTH,DEFAULT_HEIGHT));
        timerDelay = 1000;
        timer = new Timer(timerDelay, gameTimer);
        timer.start();
    }
    
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        g.setColor(Color.RED);
        g.drawRect(10, 10, 10, 10);
        
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
