/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.awt.Image;
import java.io.IOException;
import javax.imageio.ImageIO;

/**
 *
 * @author Alexandre
 */
class BaseObject {
     private int xPos;
     private int yPos;
     private Image image;
     
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
    
    
     /**
     * @return the image
     */
    public Image getImage() {
        return image;
    }

    /**
     * @param image to set the image
     */
    public void setImage(String imageName) {
        try {
            this.image = ImageIO.read(getClass().getResource("/Resources/" + imageName + ".png"));
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
}
