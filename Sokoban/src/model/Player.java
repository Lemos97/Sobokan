/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.awt.Color;
import java.awt.Graphics;

/**
 *
 * @author bruno
 */
public class Player extends BaseObject{
        private Color pColor;
        private int vectorX = 10;
        private int vectorY = 10;       

    public Player(final Color color, int x, int y){
        super(x, y);
        this.pColor = color;
    }
  
    /**
     * @return the pColor
     */
    public Color getpColor() {
        return pColor;
    }

    /**
     * @param pColor the pColor to set
     */
    public void setpColor(Color pColor) {
        this.pColor = pColor;
    }
    
    public int getVX(){
        return this.vectorX;
    }
    
    public void setVX(int vectorX){
        this.vectorX = vectorX;
    }
    
    public int getVY(){
        return this.vectorY;
    }
    
    public void setVY(int vectorY){
        this.vectorY = vectorY;
    }
    
    public void paintComponent(Graphics g){
        //super.paintComponent(g);
        g.setColor(this.getpColor());
        g.drawRect(this.getX(), this.getY(), 10, 10);
    }
}
