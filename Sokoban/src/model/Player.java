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
public class Player extends BaseObject {
    private boolean isSecond = false;

    // FORGOT TO IMPLEMENT THE USAGE OF THE isSecond property.. 
    //but it should be fine to change to it instead of checking is 
    //board.player2 != null checking if player.isSecond == true/false should be the same.
    public Player(int x, int y) {
        super(x, y);
        this.setImage("PlayerSprites/1_Down");
    }

    public Player(int x, int y, boolean isSecond) {
        super(x, y);
        this.setImage("PlayerSprites/2_Down");
        this.isSecond = isSecond;
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
