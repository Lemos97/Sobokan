/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.awt.Color;

/**
 *
 * @author bruno
 */
public class Player {
        private int x;
        private int y;
        private Color pColor;
        

    public Player(final Color color){
        x = 10;
        y = 10;
        pColor = color;
    }

    /**
     * @return the x
     */
    public int getX() {
        return x;
    }

    /**
     * @param x the x to set
     */
    public void setX(int x) {
        this.x = x;
    }

    /**
     * @return the y
     */
    public int getY() {
        return y;
    }

    /**
     * @param y the y to set
     */
    public void setY(int y) {
        this.y = y;
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
    
}
