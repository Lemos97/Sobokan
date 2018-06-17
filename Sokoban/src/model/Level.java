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
public class Level {
    private String levelLayout;
    private int levelId;
   

    /**
     * @return the LevelId
     */
    public int getLevelId(){
        return this.levelId;
    }
    
     /**
     * @param levelId to set levelId
     */
    public void setLevelId(int levelId){
        this.levelId = levelId;
    } 
    
    /**
     * @return the levelLayout
     */
    public String getLevelLayout(){
        return this.levelLayout;
    }
    
     /**
     * @param levelLayout to set levelLayout
     */
    public void setLevelLayout(String levelLayout){
        levelLayout = levelLayout.replace("\\n", "\n");
        this.levelLayout = levelLayout;
    } 
}
