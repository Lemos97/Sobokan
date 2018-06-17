/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author bruno
 */
public class Obstacle extends BaseObject {       
    public Obstacle(int oX, int oY, int lvlNum) {
        super(oX, oY);
        this.setImage("Obstacle"+lvlNum);
    }
}
