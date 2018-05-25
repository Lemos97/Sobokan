/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;
import javax.swing.JPanel;

/**
 *
 * @author bruno
 */
public final class Board extends JPanel{
    private Player player;
    private Floor floor;
    public static final char EMPTY = ' ';
    public static final char PLAYER = '@';
    public static final char BLOCK = '$';
    public static final char TARGET = '.';
    public static final char WALL = '#';
    private char[][] targets;
    private char[][] world;

    private int linhas, colunas;


    public Board() {
         this("##############\n"
           + "#   #        #\n"
           + "#  #     $   #\n"
           + "#      #    .#\n"
           + "#  @    #    #\n"
           + "#          # #\n"
           + "#   #        #\n"
           + "##############\n", 1);
    }

    public Board(String board, int lvlNum) {
        String[] lines = board.split("\n");
        int maior = lines[0].length();
        for (int l = 1; l < lines.length; l++) {
            if (lines[l].length() > maior) {
                maior = lines[l].length();
            }

        }
        floor = new Floor(1);
        this.linhas = lines.length;
        this.colunas = maior;
        world = new char[lines.length][];
        targets = new char[lines.length][maior];
        for (int i = 0; i < lines.length; i++) {
            world[i] = lines[i].toCharArray();
        }
    }

    public String toString() {
        StringBuilder txt = new StringBuilder();
        for (char[] line : world) {
            txt.append(new String(line) + "\n");
        }
        return txt.toString();
    }

    private int[] getPlayerPosition() {
        for (int y = 0; y < world.length; y++) {
            for (int x = 0; x < world[y].length; x++) {
                if (world[y][x] == PLAYER) {
                    return new int[]{x, y};
                }
            }
        }
        return null;
    }

    public void getTargetPosition() {
        for (int y = 0; y < world.length; y++) {
            for (int x = 0; x < world[y].length; x++) {
                if (world[y][x] == TARGET) {
                    targets[y][x] = TARGET;
                } else {
                    targets[y][x] = EMPTY;
                }
            }
        }
    }

    private boolean isPositionValid(int x, int y) {
        return x >= 0 && y >= 0 && y < world.length && x < world[y].length;
    }

    private boolean isMoveAbleTo(int x, int y, int dx, int dy) {
        return isPositionValid(x + dx, y + dy) && (world[y + dy][x + dx] == EMPTY
                || world[y + dy][x + dx] == BLOCK || world[y + dy][x + dx] == TARGET);

    }

    private void moveTo(int x, int y, int dx, int dy, int dir) {
        if (isMoveAbleTo(x, y, dx, dy)) {

            //Move jogador para o alvo
            if (world[y + dy][x + dx] == TARGET) {
                world[y][x] = EMPTY;
                world[y + dy][x + dx] = PLAYER;
            }
            //Move jogador para posição vazia
            if (world[y + dy][x + dx] == EMPTY) {
                world[y][x] = EMPTY;
                world[y + dy][x + dx] = PLAYER;
            } else if (world[y + dy][x + dx] == BLOCK) {//Move jogador para posição de bloco
                switch (dir) {
                    case 1://Move jogador para a direita
                        if (world[y + dy][x + dx + 1] != WALL) {
                            world[y][x] = EMPTY;
                            world[y + dy][x + dx] = PLAYER;
                            world[y + dy][x + dx + 1] = BLOCK;

                        }
                        break;
                    case 2://Move jogador para baixo
                        if (world[y + dy + 1][x + dx] != WALL) {
                            world[y][x] = EMPTY;
                            world[y + dy][x + dx] = PLAYER;
                            world[y + dy + 1][x + dx] = BLOCK;

                        }
                        break;
                    case 3://Move jogador para esquerda
                        if (world[y + dy][x + dx - 1] != WALL) {
                            world[y][x] = EMPTY;
                            world[y + dy][x + dx] = PLAYER;
                            world[y + dy][x + dx - 1] = BLOCK;

                        }
                        break;
                    case 4://Move jogador para cima
                        if (world[y + dy - 1][x + dx] != WALL) {
                            world[y][x] = EMPTY;
                            world[y + dy][x + dx] = PLAYER;
                            world[y + dy - 1][x + dx] = BLOCK;
                        }
                        break;
                }
            }
        }
        for (y = 0; y < world.length; y++) {
            for (x = 0; x < world[y].length; x++) {
                if (targets[y][x] == TARGET && world[y][x] == EMPTY) {
                    world[y][x] = TARGET;
                }
            }
        }
    }

    public void moveRight() {
        int[] pos = getPlayerPosition();
        moveTo(pos[0], pos[1], +1, 0, 1);

    }

    public void moveLeft() {
        int[] pos = getPlayerPosition();
        moveTo(pos[0], pos[1], -1, 0, 3);

    }

    public void moveUp() {
        int[] pos = getPlayerPosition();
        moveTo(pos[0], pos[1], 0, -1, 4);

    }

    public void moveDown() {
        int[] pos = getPlayerPosition();
        moveTo(pos[0], pos[1], 0, +1, 2);

    }

     public boolean isComplete() {
        for(int l=0; l < world.length; l++) 
            for(int c=0; c < world[l].length; c++)
                if (world[l][c] == '.' && targets[l][c]!= '$')
                    return false;
        return true;
    }

    @Override
    public void paint(Graphics g) {
        float dc = ((float) this.getWidth()) / colunas;
        float dl = ((float) this.getHeight()) / linhas;

        for (int l = 0; l < linhas; l++) {
            for (int c = 0; c < colunas; c++) {
                if (world[l][c] == WALL) {
                    g.setColor(Color.BLACK);
                }
                if (world[l][c] == TARGET) {
                    g.setColor(Color.CYAN);
                }
                if (world[l][c] == BLOCK) {
                    g.setColor(Color.GREEN);
                }
                g.fillRect(Math.round(c * dc), Math.round(l * dl), Math.round(dc), Math.round(dl));
                if (world[l][c] == EMPTY) {
                    g.drawImage(floor.getImage(), Math.round(c * dc), Math.round(l * dl), Math.round(dc), Math.round(dl), null);
                }
                if (world[l][c] == PLAYER) {
                    player = new Player(l, c);
                    g.drawImage(player.getImage(), Math.round(c * dc), Math.round(l * dl), Math.round(dc), Math.round(dl), null);
                }
            }
        }
    }
}