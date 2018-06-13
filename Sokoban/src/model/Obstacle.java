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
public class Obstacle extends BaseObject {
        private Color oColor;
        
        
    public Obstacle(int oX, int oY, int lvlNum) {
        super(oX, oY);
        this.setImage("Obstacle"+lvlNum);
    }

    /**
     * @return the oColor
     */
    public Color getoColor() {
        return oColor;
    }

    /**
     * @param oColor the oColor to set
     */
    public void setoColor(Color oColor) {
        this.oColor = oColor;
    }
}
