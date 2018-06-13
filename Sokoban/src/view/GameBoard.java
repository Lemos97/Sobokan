/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import Controlers.FileReader;
import java.awt.Dimension;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import model.Board;
import model.Level;

/**
 *
 * @author Alexandre
 */
public class GameBoard extends JFrame {

    private FileReader a = new FileReader();
    private static final int DEFAULT_WIDTH = 480;
    private static final int DEFAULT_HEIGHT = (DEFAULT_WIDTH / 12) * 9;
    private static final int SCALE = 2;
    private int changer = 1;

    Level level;
    private Board boardLevel;

    /**
     * Creates new form GamePanel
     */
    public GameBoard(Level level) {
        this.level = level;
        this.setUndecorated(true);
        this.setPreferredSize(new Dimension(DEFAULT_WIDTH * SCALE, DEFAULT_HEIGHT * SCALE));
        this.setMinimumSize(new Dimension(DEFAULT_WIDTH * SCALE, DEFAULT_HEIGHT * SCALE));
        this.setMaximumSize(new Dimension(DEFAULT_WIDTH * SCALE, DEFAULT_HEIGHT * SCALE));
        this.setResizable(false);
        this.setLocationRelativeTo(null);
        boardLevel = new Board(level, 5, 4);
        initComponents();
        board.setWorld(boardLevel.gameResetState);
        board.setGameStatesToNull(boardLevel.gameResetState);
        buttonStateFloater();

        resetBtn.setFocusable(false);
        exitBtn.setFocusable(false);
        saveBtn.setFocusable(false);
        undoBtn.setFocusable(false);
        redoBtn.setFocusable(false);
        menuBtn.setFocusable(false);

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel = new javax.swing.JPanel();
        resetBtn = new javax.swing.JButton();
        undoBtn = new javax.swing.JButton();
        saveBtn = new javax.swing.JButton();
        exitBtn = new javax.swing.JButton();
        redoBtn = new javax.swing.JButton();
        menuBtn = new javax.swing.JButton();
        board = boardLevel;

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(0, 0, 0));
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        setType(java.awt.Window.Type.POPUP);
        addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                formKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                formKeyReleased(evt);
            }
        });

        resetBtn.setText("Reset");
        resetBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                resetBtnActionPerformed(evt);
            }
        });

        undoBtn.setText("Undo");
        undoBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                undoBtnActionPerformed(evt);
            }
        });

        saveBtn.setText("Save");
        saveBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                saveBtnActionPerformed(evt);
            }
        });

        exitBtn.setText("Exit");
        exitBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                exitBtnActionPerformed(evt);
            }
        });

        redoBtn.setText("Redo");
        redoBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                redoBtnActionPerformed(evt);
            }
        });

        menuBtn.setText("Menu");
        menuBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuBtnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanelLayout = new javax.swing.GroupLayout(jPanel);
        jPanel.setLayout(jPanelLayout);
        jPanelLayout.setHorizontalGroup(
            jPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelLayout.createSequentialGroup()
                .addComponent(resetBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(undoBtn)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(redoBtn)
                .addGap(26, 26, 26)
                .addComponent(saveBtn)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 20, Short.MAX_VALUE)
                .addComponent(menuBtn)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(exitBtn))
        );
        jPanelLayout.setVerticalGroup(
            jPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelLayout.createSequentialGroup()
                .addGroup(jPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(resetBtn)
                    .addComponent(undoBtn)
                    .addComponent(saveBtn)
                    .addComponent(exitBtn)
                    .addComponent(redoBtn)
                    .addComponent(menuBtn))
                .addGap(0, 0, Short.MAX_VALUE))
        );

        getContentPane().add(jPanel, java.awt.BorderLayout.NORTH);

        board.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                boardMousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                boardMouseReleased(evt);
            }
        });

        javax.swing.GroupLayout boardLayout = new javax.swing.GroupLayout(board);
        board.setLayout(boardLayout);
        boardLayout.setHorizontalGroup(
            boardLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        boardLayout.setVerticalGroup(
            boardLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 261, Short.MAX_VALUE)
        );

        getContentPane().add(board, java.awt.BorderLayout.CENTER);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void resetBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_resetBtnActionPerformed
        board.setWorld(boardLevel.gameResetState);
        board.setGameStatesToNull(boardLevel.gameResetState);
        buttonStateFloater();
        this.repaint();
    }//GEN-LAST:event_resetBtnActionPerformed

    private void exitBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_exitBtnActionPerformed
        Object[] options = {"Sim!", "Não."};
        int choice = JOptionPane.showOptionDialog(this, "Tem a certeza que deseja sair?", "Sair", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, options, options[1]);

        if (choice == 0) {
            System.exit(0);
        }
    }//GEN-LAST:event_exitBtnActionPerformed

    private void saveBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_saveBtnActionPerformed
        try {
            a.SaveLevelState(board.toString(), board.getLvlNum());
            JOptionPane.showMessageDialog(this, "O ficheiro foi guardado com sucesso", "Guardado!", JOptionPane.INFORMATION_MESSAGE);
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "Erro ao guardar o seu ficheiro. \n\n" + ex.getMessage(), "Erro!", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_saveBtnActionPerformed

    private void undoBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_undoBtnActionPerformed
        board.setWorld(board.getGameStatesUndo());
        buttonStateFloater();
        this.repaint();
    }//GEN-LAST:event_undoBtnActionPerformed

    private void redoBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_redoBtnActionPerformed
        board.setWorld(board.getGameStatesRedo());
        buttonStateFloater();
        this.repaint();
    }//GEN-LAST:event_redoBtnActionPerformed

    private void formKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_formKeyPressed
        if (board.isComplete() && evt.getKeyCode() != 27) {
            Object[] options = {"Sim!", "Não."};
            int choice = JOptionPane.showOptionDialog(this, "Tem a certeza que deseja voltar ao menu inicial?", "Ganhou!!!", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, options, options[1]);

            if (choice == 0) {
                this.dispose();
            }
        } else if (!board.isComplete()) {
            switch (evt.getKeyCode()) {
                case 37:
                    board.moveLeft();
                    board.player.setImage("PlayerSprites/" + level.getLevelId() + "_Left" + changer);
                    board.setGameStates(board.toString());
                    break;
                case 39:
                    board.moveRight();
                    board.player.setImage("PlayerSprites/" + level.getLevelId() + "_Right" + changer);
                    board.setGameStates(board.toString());
                    break;
                case 38:
                    board.moveUp();
                    board.player.setImage("PlayerSprites/" + level.getLevelId() + "_Up" + changer);
                    board.setGameStates(board.toString());
                    break;
                case 40:
                    board.moveDown();
                    board.player.setImage("PlayerSprites/" + level.getLevelId() + "_Down" + changer);
                    board.setGameStates(board.toString());
                    break;
                case 27:
                    board.setWorld(boardLevel.gameResetState);
                    board.setGameStatesToNull(boardLevel.gameResetState);
                    buttonStateFloater();
                    this.repaint();
                    break;
                default:
                    break;
            }
            if (changer == 1) {
                changer = 2;
            } else {
                changer = 1;
            }
            if (board.getUndoRedoFalse()) {
                board.setGameStatesToNull(board.toString());
                board.setUndoRedoFalse();
            }
            buttonStateFloater();
            board.repaint();
        }
    }//GEN-LAST:event_formKeyPressed

    private void formKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_formKeyReleased
        switch (evt.getKeyCode()) {
            case 37:
                board.player.setImage("PlayerSprites/" + level.getLevelId() + "_Left");
                break;
            case 39:
                board.player.setImage("PlayerSprites/" + level.getLevelId() + "_Right");
                break;
            case 38:
                board.player.setImage("PlayerSprites/" + level.getLevelId() + "_Up");
                break;
            case 40:
                board.player.setImage("PlayerSprites/" + level.getLevelId() + "_Down");
                break;
        }
        board.repaint();
    }//GEN-LAST:event_formKeyReleased

    private void boardMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_boardMouseReleased
        int h = this.getHeight() / 3 + ((this.getHeight() / 3) / 2);
        int w = this.getWidth() / 3 + ((this.getWidth() / 3) / 2);

        if (evt.getX() >= (w - (w / 3)) && evt.getX() <= (w + (w / 3))) {
            if (evt.getY() >= (this.getHeight() / 2)) {
                board.player.setImage("PlayerSprites/" + level.getLevelId() + "_Down");

            } else {
                board.player.setImage("PlayerSprites/" + level.getLevelId() + "_Up");
            }
        } else if (evt.getY() >= (h - (h / 3)) && evt.getY() <= (h + (h / 3))) {
            if (evt.getX() >= (this.getWidth() / 2)) {
                board.player.setImage("PlayerSprites/" + level.getLevelId() + "_Right");
            } else {
                board.player.setImage("PlayerSprites/" + level.getLevelId() + "_Left");
            }
        }
        board.repaint();
    }//GEN-LAST:event_boardMouseReleased

    private void boardMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_boardMousePressed
        if (board.isComplete()) {
            Object[] options = {"Sim!", "Não."};
            int choice = JOptionPane.showOptionDialog(this, "Tem a certeza que deseja voltar ao menu inicial?", "Ganhou!!!", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, options, options[1]);

            if (choice == 0) {
                this.dispose();
            }
        } else {
            int h = this.getHeight() / 3 + ((this.getHeight() / 3) / 2);
            int w = this.getWidth() / 3 + ((this.getWidth() / 3) / 2);

            if (evt.getX() >= (w - (w / 3)) && evt.getX() <= (w + (w / 3))) {
                if (evt.getY() >= (this.getHeight() / 2)) {
                    board.moveDown();
                    board.player.setImage("PlayerSprites/" + level.getLevelId() + "_Down" + changer);
                    board.setGameStates(board.toString());

                } else {
                    board.moveUp();
                    board.player.setImage("PlayerSprites/" + level.getLevelId() + "_Up" + changer);
                    board.setGameStates(board.toString());
                }
            } else if (evt.getY() >= (h - (h / 3)) && evt.getY() <= (h + (h / 3))) {
                if (evt.getX() >= (this.getWidth() / 2)) {
                    board.moveRight();
                    board.player.setImage("PlayerSprites/" + level.getLevelId() + "_Right" + changer);
                    board.setGameStates(board.toString());
                } else {
                    board.moveLeft();
                    board.player.setImage("PlayerSprites/" + level.getLevelId() + "_Left" + changer);
                    board.setGameStates(board.toString());
                }
            }

            if (changer == 1) {
                changer = 2;
            } else {
                changer = 1;
            }
            if (board.getUndoRedoFalse()) {
                board.setGameStatesToNull(board.toString());
                board.setUndoRedoFalse();
            }
            buttonStateFloater();
            board.repaint();
        }
    }//GEN-LAST:event_boardMousePressed

    private void menuBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuBtnActionPerformed
        Object[] options = {"Sim!", "Não."};
        int choice = JOptionPane.showOptionDialog(this, "Tem a certeza que deseja voltar ao menu inicial?", "Menu Inicial", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, options, options[1]);

        if (choice == 0) {
            this.dispose();
        }
    }//GEN-LAST:event_menuBtnActionPerformed

    private void buttonStateFloater() {
        int a = board.getGameStatesSize();
        int b = board.getGameStateIter() + 1;
        if (a == 1 || board.getGameStateIter() == 0) {
            undoBtn.setEnabled(false);
        } else {
            undoBtn.setEnabled(true);
        }
        if (a == b) {
            redoBtn.setEnabled(false);
        } else {
            redoBtn.setEnabled(true);
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private model.Board board;
    private javax.swing.JButton exitBtn;
    private javax.swing.JPanel jPanel;
    private javax.swing.JButton menuBtn;
    private javax.swing.JButton redoBtn;
    private javax.swing.JButton resetBtn;
    private javax.swing.JButton saveBtn;
    private javax.swing.JButton undoBtn;
    // End of variables declaration//GEN-END:variables
}
