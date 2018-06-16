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
        private boolean isSecond = false;

        
    // FORGOT TO IMPLEMENT THE USAGE OF THE isSecond property.. 
    //but it should be fine to change to it instead of checking is 
    //board.player2 != null checking if player.isSecond == true/false should be the same.
    public Player(int x, int y) {
        super(x, y);
        this.setImage("PlayerSprites/1_Down");
    }
    
    public Player(int x, int y, boolean isSecond){
        super(x, y);
        this.setImage("PlayerSprites/2_Down");
        this.isSecond = isSecond;
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
    /**
     * Returns false if the player isnt the second player,
     * Return true if the player is the second player,
     * @return the vectorY
     */
    public boolean isSecond(){
        return this.isSecond;
    }
}
