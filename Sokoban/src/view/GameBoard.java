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
    ArrayList<Level> Levels;
    private Board boardLevel;

    /**
     * Creates new form GamePanel
     */
    public GameBoard(Level level, ArrayList<Level> levels) {
        this.setUndecorated(true);
        this.setPreferredSize(new Dimension(DEFAULT_WIDTH * SCALE, DEFAULT_HEIGHT * SCALE));
        this.setMinimumSize(new Dimension(DEFAULT_WIDTH * SCALE, DEFAULT_HEIGHT * SCALE));
        this.setMaximumSize(new Dimension(DEFAULT_WIDTH * SCALE, DEFAULT_HEIGHT * SCALE));
        this.setResizable(false);
        this.setLocationRelativeTo(null);
        this.Levels = levels;
        boardLevel = new Board(level, 5, 4);
        initComponents();
        resetBtn.setFocusable(false);
        exitBtn.setFocusable(false);
        saveBtn.setFocusable(false);
        undoBtn.setFocusable(false);
        redoBtn.setFocusable(false);
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
        resetBtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                resetBtnMouseClicked(evt);
            }
        });
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

        javax.swing.GroupLayout jPanelLayout = new javax.swing.GroupLayout(jPanel);
        jPanel.setLayout(jPanelLayout);
        jPanelLayout.setHorizontalGroup(
            jPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelLayout.createSequentialGroup()
                .addComponent(resetBtn)
                .addGap(31, 31, 31)
                .addComponent(undoBtn)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(saveBtn)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(redoBtn)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 74, Short.MAX_VALUE)
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
                    .addComponent(redoBtn))
                .addGap(0, 0, Short.MAX_VALUE))
        );

        getContentPane().add(jPanel, java.awt.BorderLayout.NORTH);

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

    private void formKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_formKeyPressed
        // TODO add your handling code here:
        if (board.isComplete()) {
            Object[] options = {"Yes", "No"};
            int choice = JOptionPane.showOptionDialog(this, "Deseja sair?", "Ganhou!", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, options, options[1]);

            if (choice == 0) {
                this.dispose();
            }
        } else {
            switch (evt.getKeyCode()) {
                case 37:
                    board.moveLeft();
                    board.player.setImage("PlayerSprites/Left" + changer);
                    break;
                case 39:
                    board.moveRight();
                    board.player.setImage("PlayerSprites/Right" + changer);

                    break;
                case 38:
                    board.moveUp();
                    board.player.setImage("PlayerSprites/Up" + changer);
                    break;
                case 40:
                    board.moveDown();
                    board.player.setImage("PlayerSprites/Down" + changer);
                    break;
            }
            if (changer == 1) {
                changer = 2;
            } else {
                changer = 1;
            }
            board.repaint();
        }
    }//GEN-LAST:event_formKeyPressed

    private void resetBtnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_resetBtnMouseClicked
        // TODO add your handling code here:

    }//GEN-LAST:event_resetBtnMouseClicked

    private void resetBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_resetBtnActionPerformed
        board.SetWorld(boardLevel.gameResetState);
        this.repaint();
    }//GEN-LAST:event_resetBtnActionPerformed

    private void exitBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_exitBtnActionPerformed
            System.exit(0);
    }//GEN-LAST:event_exitBtnActionPerformed

    private void saveBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_saveBtnActionPerformed
        a.SaveLevelState(board.toString(), board.getLvlNum());        
    }//GEN-LAST:event_saveBtnActionPerformed

    private void undoBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_undoBtnActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_undoBtnActionPerformed

    private void redoBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_redoBtnActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_redoBtnActionPerformed

    private void formKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_formKeyReleased
        switch (evt.getKeyCode()) {
            case 37:
                board.player.setImage("PlayerSprites/Left");
                break;
            case 39:
                board.player.setImage("PlayerSprites/Right");
                break;
            case 38:
                board.player.setImage("PlayerSprites/Up");
                break;
            case 40:
                board.player.setImage("PlayerSprites/Down");
                break;
        }
        board.repaint();
    }//GEN-LAST:event_formKeyReleased

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private model.Board board;
    private javax.swing.JButton exitBtn;
    private javax.swing.JPanel jPanel;
    private javax.swing.JButton redoBtn;
    private javax.swing.JButton resetBtn;
    private javax.swing.JButton saveBtn;
    private javax.swing.JButton undoBtn;
    // End of variables declaration//GEN-END:variables
}
