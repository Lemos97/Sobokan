/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlers;

import java.util.List;
import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.logging.Logger;
import model.Level;

/**
 *
 * @author Alexandre
 */
public class FileReader {

    ArrayList<Level> Levels = new ArrayList();
    private Level _level = new Level();
    private List<String> levels;

    public  ArrayList<Level> GetAllLevels() throws URISyntaxException {
        try {
            levels = Files.readAllLines(Paths.get(getClass().getResource("/Resources/levels.txt").toURI()), StandardCharsets.UTF_8);
            for (String line : levels) {
                String[] tokens = line.split("-");
                String a = tokens[0];
                _level.setLevelLayout(a);
                Levels.add(_level);
            }
            return Levels;
        } catch (IOException ex) {
            Logger.getLogger(FileReader.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        return new ArrayList();
    }
}


