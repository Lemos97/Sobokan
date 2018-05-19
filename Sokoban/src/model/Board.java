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

    public Board(Player p) {
        //Board clear até saber como representer as coisas
        this.toString(p);
    }

    public String toString(Player p) {
        StringBuilder str = new StringBuilder();
        char[][] temp = getBoardData(p);

        for (int i = 0; i < temp.length; i++) {
            for (int j = 0; j < temp.length; j++) {
                str.append(temp[i][j]);
            }
            str.append("\n");
        }
        return str.toString();
    }

    public char[][] getBoardData(Player player) {
        int x = player.getX();
        int y = player.getY();
        for (int i = 0; i < boardData.length; i++) {
            for (int j = 0; j < boardData.length; j++) {
                if (x == j && y == i) {
                    boardData[i][j] = 'P';
                } else {
                    boardData[i][j] = 'x';
                }
            }
        }
        return boardData;
    }
}
