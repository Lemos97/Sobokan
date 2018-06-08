/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.awt.Graphics;
import java.util.ArrayList;
import javax.swing.JPanel;

/**
 *
 * @author bruno
 */
public final class Board extends JPanel {
    public Player player;
    private Floor floor;
    private Wall wall;
    private Obstacle obstacle;
    private ArrayList<String> gameStates = new ArrayList<String>();
    public String gameResetState;
    public static final char EMPTY = ' ';
    public static final char PLAYER = '@';
    public static final char BLOCK = '$';
    public static final char TARGET = '.';
    public static final char WALL = '#';
    private char[][] targets;
    private char[][] world;
    private int linhas, colunas, gameStateIter = 0, lvlNum;
    private boolean undoRedoEnable = false;

    
    
    public int getLvlNum(){return lvlNum;}
    
    public Board(Level board, int pX, int pY) {
        this.lvlNum = lvlNum;
        String[] lines = board.getLevelLayout().split("\n");
        int maior = lines[0].length();
        for (int l = 1; l < lines.length; l++) {
            if (lines[l].length() > maior) {
                maior = lines[l].length();
            }
        }
        gameResetState = board.getLevelLayout();
        player = new Player(pX, pY);
        floor = new Floor(lvlNum);
        wall = new Wall(lvlNum);
    }
    
    public void setWorld(String board) {
        String[] lines = board.split("\n");
        int maior = lines[0].length();
        for (int l = 1; l < lines.length; l++) {
            if (lines[l].length() > maior) {
                maior = lines[l].length();
            }
        }
        this.linhas = lines.length;
        this.colunas = maior;
        world = new char[lines.length][];
        targets = new char[lines.length][maior];
        for (int i = 0; i < lines.length; i++) {
            world[i] = lines[i].toCharArray();
        }
        getTargetPosition();
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
        for (int l = 0; l < world.length; l++) {
            for (int c = 0; c < world[l].length; c++) {
                if (world[l][c] == '.' && targets[l][c] != '$') {
                    return false;
                }
            }
        }
        return true;
    }
   
    public void paint(Graphics g) {
        float dc = ((float) this.getWidth()) / colunas;
        float dl = ((float) this.getHeight()) / linhas;
        
        for (int l = 0; l < linhas; l++) {
            for (int c = 0; c < colunas; c++) {
                if (world[l][c] == TARGET) {
                    obstacle = new Obstacle(l, c);
                    obstacle.setImage("Fate");
                    g.drawImage(obstacle.getImage(), Math.round(c * dc), Math.round(l * dl), Math.round(dc), Math.round(dl), null);
                }
                if (world[l][c] == BLOCK) {
                    obstacle = new Obstacle(l, c);
                    g.drawImage(obstacle.getImage(), Math.round(c * dc), Math.round(l * dl), Math.round(dc), Math.round(dl), null);
                }
                if (world[l][c] == WALL) {
                    g.drawImage(wall.getImage(), Math.round(c * dc), Math.round(l * dl), Math.round(dc), Math.round(dl), null);
                }
                if (world[l][c] == EMPTY) {
                    g.drawImage(floor.getImage(), Math.round(c * dc), Math.round(l * dl), Math.round(dc), Math.round(dl), null);
                }
                if (world[l][c] == PLAYER) {
                    g.drawImage(floor.getImage(), Math.round(c * dc), Math.round(l * dl), Math.round(dc), Math.round(dl), null);
                    g.drawImage(player.getImage(), Math.round(c * dc), Math.round(l * dl), Math.round(dc), Math.round(dl), null);
                }
            }
        }
    }
    
    public void setGameStates(String state) {
        gameStates.add(state);
        if (gameStates.size() <= 4) {
            this.gameStateIter += 1;
        } else {
            gameStates.remove(0);
        }
    }
    
    public int getGameStateIter(){
        return this.gameStateIter;
    }
    
    public String getGameStatesUndo() {
        this.undoRedoEnable = true;
        if(this.gameStateIter > 0)
            this.gameStateIter -= 1; 
        return gameStates.get(this.gameStateIter);
    }
    
    public String getGameStatesRedo() {
        this.undoRedoEnable = true;
        if (this.gameStateIter < 3)
            this.gameStateIter += 1;
        return gameStates.get(this.gameStateIter);
    }
    
    public boolean getUndoRedoFalse(){
        return this.undoRedoEnable;
    }
    public void setUndoRedoFalse(){
        this.undoRedoEnable = false;
    }
    
    public void setGameStatesToNull(String board){
        gameStates.clear();
        gameStates.add(board);
        this.gameStateIter = 0;
    }
    
    public int getGameStatesSize() {
        return gameStates.size();
    }
}
