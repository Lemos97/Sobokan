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
public class Floor extends BaseObject {  
    public Floor(int lvlNum) {
        super(1, 1);
        this.setImage("FloorLvl"+lvlNum);
    }
}
