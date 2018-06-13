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

    public Player(int x, int y, int lvlId) {
        super(x, y);
        this.setImage("PlayerSprites/"+lvlId+"_Down");
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
    
    /**
     * @return the vectorX
     */
    public int getVX(){
        return this.vectorX;
    }
    
     /**
     * @param vectorX to set vectorX
     */
    public void setVX(int vectorX){
        this.vectorX = vectorX;
    }
    
    /**
     * @return the vectorY
     */
    public int getVY() {
        return this.vectorY;
    }
    
    /**
     * @param vectorY to set vectorY
     */
    public void setVY(int vectorY) {
        this.vectorY = vectorY;
    }
}
