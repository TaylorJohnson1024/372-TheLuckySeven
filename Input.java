package GroupProject1;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFileChooser;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

/**
 * Call the class and the file chooser should open, once a JSON file is chosen
 * the file is read and parsed into a JSONObject. Call the get method to return
 * the JSON object.
 * 
 * @author Taylor Johnson
 * @see https://examples.javacodegeeks.com/core-java/json/java-json-parser-example/
 * @see https://www.geeksforgeeks.org/parse-json-java/
 */
public class Input {
    private String path;
    private FileReader reader;
    private JSONParser jsonParser;
    private JSONObject selectedJSONObject;
    
    /**
     * Constructor method for Input.
     * Creates the JFileChooser and the JSONObject.
     */
    public Input() {
        // Create and open JFileChooser
        // Sets path of JSON file
        JFileChooser fc = new JFileChooser();
        fc.showOpenDialog(null);
        this.path = fc.getSelectedFile().getAbsolutePath();
        
        // Reads and parses the file from the path provided
        try {
            this.reader = new FileReader(path);
            this.jsonParser = new JSONParser();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Input.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        // Turns contents of JSON file into a JSONObject
        try {
            this.selectedJSONObject = (JSONObject) jsonParser.parse(reader);
        } catch (IOException | ParseException ex) {
            Logger.getLogger(Input.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    /**
     * Get the JSONObject from the file selected.
     * 
     * @return JSONObject from file selected
     */
    public JSONObject getJSONObject() {
        return selectedJSONObject;
    }
}
