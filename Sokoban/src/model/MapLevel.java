/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.ArrayList;

/**
 *
 * @author Alexandre
 */
public class MapLevel {   
    public static ArrayList<Obstacle> obstacles = new ArrayList();
    public static Player player;

    public MapLevel() {
        player = new Player(100, 100); 
        obstacles.add(new Obstacle(200,200));
        obstacles.add(new Obstacle(500,200));
        obstacles.add(new Obstacle(200,500));
        obstacles.add(new Obstacle(50,50));
        obstacles.add(new Obstacle(300,300));
        
    }
}
