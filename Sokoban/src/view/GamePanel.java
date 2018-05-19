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
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.JPanel;
import javax.swing.Timer;
import model.Board;
import model.Player;

/**
 *
 * @author bruno
 */
public class GamePanel extends JPanel implements KeyListener{
    private static final int DEFAULT_WIDTH = 320;
    private static final int DEFAULT_HEIGHT = (DEFAULT_WIDTH / 12) * 9;
    private static final int SCALE = 2;
    private final int timerDelay;
    private final Timer timer;
    public Player player;

    
    public GamePanel() {
        super();
        addKeyListener(this);
        this.setPreferredSize(new Dimension(DEFAULT_WIDTH * SCALE,DEFAULT_HEIGHT * SCALE));
        this.setMinimumSize(new Dimension(DEFAULT_WIDTH * SCALE,DEFAULT_HEIGHT * SCALE));
        this.setMaximumSize(new Dimension(DEFAULT_WIDTH * SCALE,DEFAULT_HEIGHT * SCALE));
       
        player = new Player(Color.GREEN, 10, 10);
        this.setVisible(true);
        timerDelay = 500;
        timer = new Timer(timerDelay, gameTimer);
        timer.start();
        
    }
    
     public void addNotify() {
        super.addNotify();
        requestFocus();
    }
    
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        this.setBackground(Color.red);
       

        player.paintComponent(g);
    }

    public void redraw(){
        this.repaint();
    }
    
    ActionListener gameTimer = new ActionListener(){
        @Override
        public void actionPerformed(ActionEvent evt){
            //redraw();
        }        
    };

    @Override
    public void keyTyped(KeyEvent e) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void keyPressed(KeyEvent e) {
        int key = e.getKeyCode();
        switch (key) {
            case KeyEvent.VK_UP:
                if((player.getY() - player.getVY()) > 0){
                    player.setY(player.getY() - player.getVY());
                }
                break;
            case KeyEvent.VK_DOWN:
                if((player.getY() + player.getVY()) < this.getHeight() - 10){
                    player.setY(player.getY() + player.getVY());
                }
                break;
            case KeyEvent.VK_LEFT:
                if((player.getX() - player.getVX()) > 0){
                    player.setX(player.getX() - player.getVX());
                }
                break;
            case KeyEvent.VK_RIGHT:
                if((player.getX() + player.getVX()) < this.getWidth() - 10){
                    player.setX(player.getX() + player.getVX());
                }
                break;
        }
        this.repaint();
    }

    @Override
    public void keyReleased(KeyEvent e) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
