/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.awt.Color;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

/**
 *
 * @author bruno
 */
public final class Board {
    private char[][] boardData = new char[20][20];
    private int obsNumber = new Random().nextInt(10);
        
    private Player player;
    private ArrayList<Obstacle> obstacles = new ArrayList<Obstacle>();
    private Obstacle obstacle;


    
    public Board(){
        //Board clear até saber como representer as coisas
        System.out.println(obsNumber);

        player = new Player(Color.RED);
        
        for (int i = 0; i < obsNumber; i++){
            obstacle = new Obstacle(Color.WHITE, new Random().nextInt(20), new Random().nextInt(20));
            obstacles.add(obstacle);
        }
        getBoardData();
        
    }
    
    public String toString(){
        StringBuilder str = new StringBuilder();
        char [][] temp = getBoardData();
        
        for (int i = 0; i< temp.length; i++){
            for (int j = 0; j< temp.length; j++){
               str.append(temp[i][j]);
            }
            str.append("\n");
        }
        return str.toString();
    }
    
    public char[][] getBoardData(){
        int x = player.getX();
        int y = player.getY();
        int oX;
        int oY;
        for (int i = 0; i< boardData.length; i++){
                for (int j = 0; j< boardData.length; j++){
                    for(int o = 0; o < obstacles.size(); o++){
                        oX = obstacles.get(o).getX();
                        oY = obstacles.get(o).getY();

                        if (x == j && y == i) {
                            boardData[i][j] = 'P';
                        }else if (oX == j && oY == i && boardData[i][j] != 'P') {
                            boardData[i][j] = 'O';
                        } else if (boardData[i][j] != 'P' || boardData[i][j] != 'O'){
                            boardData[i][j] = 'x';
                        }
                    }
            }
        }
        return boardData;
    }
}
