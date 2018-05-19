/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author Alexandre
 */
class BaseObject {
     private int xPos;
     private int yPos;
     
     public BaseObject(int x, int y){
         this.xPos = x;
         this.yPos = y;   
     }
     
       /**
     * @return the x
     */
    public int getX() {
        return xPos;
    }

    /**
     * @param x the x to set
     */
    public void setX(int x) {
        this.xPos = x;
    }

    /**
     * @return the y
     */
    public int getY() {
        return yPos;
    }

    /**
     * @param y the y to set
     */
    public void setY(int y) {
        this.yPos = y;
    }

}
