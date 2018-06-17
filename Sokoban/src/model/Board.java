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

    public ArrayList<Player> players = new ArrayList<>();
    private Floor floor;
    private Wall wall;
    private Obstacle obstacle;
    private ArrayList<String> gameStates = new ArrayList<>();
    public String gameResetState;
    public static final char EMPTY = ' ';
    public static final char PLAYER = '@';
    public static final char PLAYER2 = '£';
    public static final char BLOCK = '$';
    public static final char TARGET = '.';
    public static final char WALL = '#';
    private char[][] targets;
    private char[][] world;
    private int linhas, colunas, gameStateIter = 0;
    private static int lvlNum;
    private boolean undoRedoEnable = false;
    private ArrayList<Level> allLevels;
    public int getLvlNum() {
        return lvlNum;
    }
    public Board() {
        this(null, null);
    }

    public Board(Level boardLevel, ArrayList<Level> allLevels) {
        if (boardLevel == null) {
            return;
        }
        this.lvlNum = boardLevel.getLevelId();
        this.allLevels = allLevels;
        
        gameResetState = boardLevel.getLevelLayout();
        setWorld(gameResetState);

        String[] lines = boardLevel.getLevelLayout().split("\n");
        for (int y = 0; y < world.length; y++) {
            for (int x = 0; x < world[y].length; x++) {
                if (world[y][x] == PLAYER) {
                    players.add(new Player(x, y));
                }
                if (world[y][x] == PLAYER2) {
                    players.add(new Player(x, y, true));
                }
            }
        }
        if (players.get(0).isSecond()) {
            Player tempPlayer = players.get(0);
            players.remove(tempPlayer);
            players.add(tempPlayer);
        }
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

    @Override
    public String toString() {
        StringBuilder txt = new StringBuilder();
        for (char[] line : world) {
            txt.append(new String(line)).append("\n");
        }
        return txt.toString();
    }

    private int[] getPlayerPosition(Player p) {
        for (int y = 0; y < world.length; y++) {
            for (int x = 0; x < world[y].length; x++) {
                if (world[y][x] == PLAYER & !p.isSecond()) {
                    return new int[]{x, y};
                }
                if (world[y][x] == PLAYER2 & p.isSecond()) {
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
        return isPositionValid(x + dx, y + dy)
                && (world[y + dy][x + dx] == EMPTY
                || world[y + dy][x + dx] == BLOCK
                || world[y + dy][x + dx] == TARGET);
    }

    private void moveTo(int x, int y, int dx, int dy, int dir, Player p) {
        if (isMoveAbleTo(x, y, dx, dy)) {
            //Move jogador para o alvo
            if (world[y + dy][x + dx] == TARGET) {
                world[y][x] = EMPTY;
                if (p.isSecond()) {
                    world[y + dy][x + dx] = PLAYER2;
                } else {
                    world[y + dy][x + dx] = PLAYER;
                }
            }
            //Move jogador para posição vazia
            if (world[y + dy][x + dx] == EMPTY) {
                world[y][x] = EMPTY;
                if (p.isSecond()) {
                    world[y + dy][x + dx] = PLAYER2;
                } else {
                    world[y + dy][x + dx] = PLAYER;
                }
            } else if (world[y + dy][x + dx] == BLOCK) {//Move jogador para posição de bloco
                switch (dir) {
                    case 1://Move jogador para a direita
                        if (world[y + dy][x + dx + 1] == EMPTY || world[y + dy][x + dx + 1] == TARGET) {
                            world[y][x] = EMPTY;
                            if (p.isSecond()) {
                                world[y + dy][x + dx] = PLAYER2;
                            } else {
                                world[y + dy][x + dx] = PLAYER;
                            }
                            world[y + dy][x + dx + 1] = BLOCK;
                        }
                        break;
                    case 2://Move jogador para baixo
                        if (world[y + dy + 1][x + dx] == EMPTY || world[y + dy + 1][x + dx] == TARGET) {
                            world[y][x] = EMPTY;
                            if (p.isSecond()) {
                                world[y + dy][x + dx] = PLAYER2;
                            } else {
                                world[y + dy][x + dx] = PLAYER;
                            }
                            world[y + dy + 1][x + dx] = BLOCK;
                        }
                        break;
                    case 3://Move jogador para esquerda
                        if (world[y + dy][x + dx - 1] == EMPTY || world[y + dy][x + dx - 1] == TARGET) {
                            world[y][x] = EMPTY;

                            if (p.isSecond()) {
                                world[y + dy][x + dx] = PLAYER2;
                            } else {
                                world[y + dy][x + dx] = PLAYER;
                            }
                            world[y + dy][x + dx - 1] = BLOCK;
                        }
                        break;
                    case 4://Move jogador para cima
                        if (world[y + dy - 1][x + dx] == EMPTY || world[y + dy - 1][x + dx] == TARGET) {
                            world[y][x] = EMPTY;
                            if (p.isSecond()) {
                                world[y + dy][x + dx] = PLAYER2;
                            } else {
                                world[y + dy][x + dx] = PLAYER;
                            }
                            world[y + dy - 1][x + dx] = BLOCK;
                        }
                        break;
                }
                p.setX(x + dx);
                p.setY(y + dy);
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

    public void moveRight(Player p) {
        int[] pos = getPlayerPosition(p);
        moveTo(pos[0], pos[1], +1, 0, 1, p);
    }

    public void moveLeft(Player p) {
        int[] pos = getPlayerPosition(p);
        moveTo(pos[0], pos[1], -1, 0, 3, p);
    }

    public void moveUp(Player p) {
        int[] pos = getPlayerPosition(p);
        moveTo(pos[0], pos[1], 0, -1, 4, p);
    }

    public void moveDown(Player p) {
        int[] pos = getPlayerPosition(p);
        moveTo(pos[0], pos[1], 0, +1, 2, p);
    }

    public boolean isComplete() {
        for (int l = 0; l < world.length; l++) {
            for (int c = 0; c < world[l].length; c++) {
                if ((world[l][c] == '.' && targets[l][c] != '$') || 
                    (world[l][c] == '@' && targets[l][c] == '.') ||
                    (world[l][c] == '£' && targets[l][c] == '.')) {
                    return false;
                }
            }
        }
        return true;
    }

    public void paint(Graphics g) {
        Wall limite = new Wall(this.lvlNum);
        Floor chao = new Floor(this.lvlNum);
        float dc = ((float) this.getWidth()) / colunas;
        float dl = ((float) this.getHeight()) / linhas;
        for (int l = 0; l < linhas; l++) {
            for (int c = 0; c < colunas; c++) {
                if (world[l][c] == TARGET) {
                    obstacle = new Obstacle(l, c, this.lvlNum);
                    obstacle.setImage("Fate" + this.lvlNum);
                    g.drawImage(obstacle.getImage(), Math.round(c * dc), Math.round(l * dl), Math.round(dc), Math.round(dl), null);
                }
                if (world[l][c] == BLOCK) {
                    obstacle = new Obstacle(l, c, this.lvlNum);
                    g.drawImage(obstacle.getImage(), Math.round(c * dc), Math.round(l * dl), Math.round(dc), Math.round(dl), null);
                }
                if (world[l][c] == WALL) {
                    g.drawImage(limite.getImage(), Math.round(c * dc), Math.round(l * dl), Math.round(dc), Math.round(dl), null);
                }
                if (world[l][c] == EMPTY) {
                    g.drawImage(chao.getImage(), Math.round(c * dc), Math.round(l * dl), Math.round(dc), Math.round(dl), null);
                }
                if (world[l][c] == PLAYER) {
                    g.drawImage(chao.getImage(), Math.round(c * dc), Math.round(l * dl), Math.round(dc), Math.round(dl), null);
                    g.drawImage(players.get(0).getImage(), Math.round(c * dc), Math.round(l * dl), Math.round(dc), Math.round(dl), null);
                }
                if (world[l][c] == PLAYER2) {
                    g.drawImage(chao.getImage(), Math.round(c * dc), Math.round(l * dl), Math.round(dc), Math.round(dl), null);
                    g.drawImage(players.get(1).getImage(), Math.round(c * dc), Math.round(l * dl), Math.round(dc), Math.round(dl), null);
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

    public int getGameStateIter() {
        return this.gameStateIter;
    }

    public String getGameStatesUndo() {
        this.undoRedoEnable = true;
        if (this.gameStateIter > 0) {
            this.gameStateIter -= 1;
        }
        return gameStates.get(this.gameStateIter);
    }

    public String getGameStatesRedo() {
        this.undoRedoEnable = true;
        if (this.gameStateIter < 3) {
            this.gameStateIter += 1;
        }
        return gameStates.get(this.gameStateIter);
    }

    public boolean getUndoRedoFalse() {
        return this.undoRedoEnable;
    }

    public void setUndoRedoFalse() {
        this.undoRedoEnable = false;
    }

    public void setGameStatesToNull(String board) {
        gameStates.clear();
        gameStates.add(board);
        this.gameStateIter = 0;
    }

    public int getGameStatesSize() {
        return gameStates.size();
    }
}
