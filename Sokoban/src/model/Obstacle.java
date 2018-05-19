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
public class Obstacle extends BaseObject {
        private Color oColor;
        
        
    public Obstacle(final Color color, int oX, int oY) {
        super(oX, oY);
        this.oColor = color;
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
