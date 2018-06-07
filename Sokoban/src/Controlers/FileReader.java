/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlers;

import java.util.List;
import java.io.IOException;
import java.nio.file.Paths;
import model.Level;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.File;
import java.io.PrintWriter;
import java.net.URISyntaxException;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.logging.Logger;

/**
 *
 * @author Alexandre
 */
public class FileReader {

    public ArrayList<Level> GetAllLevels() {
        try {
            ObjectMapper mapper = new ObjectMapper();
            Path filePath = Paths.get(getClass().getResource("/Resources/levels.json").toURI());
            File from = new File(filePath.toString());
            //JSON from String to List<Level>
            List<Level> myLevels = mapper.readValue(from, mapper.getTypeFactory().constructCollectionType(List.class, Level.class));
            ArrayList<Level> aa = (ArrayList) myLevels;
            return aa;
        } catch (IOException | URISyntaxException ex) {
            return null;
        }
    }

    public Level GetLevel(String path) {
        try {
            ObjectMapper mapper = new ObjectMapper();
            Path filePath = Paths.get(path);
            File from = new File(filePath.toString());
            //JSON from String to List<Level>
            Level mySaveLvl = mapper.readValue(from, mapper.getTypeFactory().constructType(Level.class));
            return mySaveLvl;
        } catch (IOException ex) {
            
            String a = ex.toString();
            
        }
        return null;
    }

    public void SaveLevelState(String gameState, int numLvl) {
        Level a = new Level();
        a.setLevelId(numLvl);
        a.setLevelLayout(gameState);

        ObjectMapper mapper = new ObjectMapper();
        Path filePath;
        try {
            filePath = Paths.get(getClass().getResource("/Resources/").toURI());
            File to = new File(filePath + "/GameSave.json");
            if (!to.exists()) {
                to.createNewFile();
                mapper.writeValue(to, a);
                return;
            }
            PrintWriter writer = new PrintWriter(to);
            writer.print("");
            writer.close();
            mapper.writeValue(to, a);
        } catch (IOException | URISyntaxException ex) {
            Logger.getLogger(FileReader.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
    }
}
