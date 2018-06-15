/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import Controlers.FileReader;
import java.util.ArrayList;

/**
 *
 * @author Alexandre
 */
public class Level {
    private String levelLayout;
    private int levelId;
   
    public Level(){}
    
    public String getSavedLayoutLevel(Level level){
        FileReader levelsFile = new FileReader();
        
        ArrayList<Level> levels = levelsFile.GetAllLevels();
        
        for(Level l : levels){
            if (l.levelId == level.getLevelId()){
                return l.levelLayout;
            }    
        }
        
        return level.getLevelLayout();
    }
    
    /**
     * @return the LevelId
     */
    public int getLevelId(){
        return this.levelId;
    }
    
     /**
     * @param vectorX to set vectorX
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
