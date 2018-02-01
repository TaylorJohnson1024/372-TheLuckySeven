package GroupProject1;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.JSONValue;

/**
 * Class to Export All Readings in to JSON file
 * @author Zinet
 * @Date Sun Jan, 28 2018
 */
public class ExportAllReadings 
{
    //readings export filename 
    private static String EXPORT_FILE_NAME = "readings_export.json";
    //string to store main JSON string 
    private String JSONContent;
    
    /**
    * Constructor
    * @param JSONFileName filename to export all readings from
    */
    public ExportAllReadings(String JSONFileName)
    {
        String fileContent;
        try
        {
            fileContent = new Scanner(new File(JSONFileName)).useDelimiter("\\Z").next();
            this.setJSONContent(fileContent);
            this.parseJSONAndExportAllReadings();
        }
        catch(FileNotFoundException e)
        {
            //throw exception here 
        }
    }
    
    /**
    * Method to set the JSONContent class variable
    * @param content String content from the file
    */
    public void setJSONContent(String content)
    {
        this.JSONContent = content;
    }
    
    /**
    * Method to set the JSONContent class variable
    * @return String JSON Data
    */
    public String getJSONContent()
    {
        return this.JSONContent;
    }
    
    /**
    * Method to read patient record and generates all readings export data
    */
    public void parseJSONAndExportAllReadings() throws FileNotFoundException
    {
        Object stdObj = JSONValue.parse(this.getJSONContent()); 
        
        // creating JSON Object
        JSONObject stdObj2 = new JSONObject();
        // creating JSON Array 
        JSONArray jsonArray = new JSONArray();
        //define LinkedHashMap variable 
        Map lhm = new LinkedHashMap();
        
        // typecasting stdObj to JSONObject
        JSONObject jsonObject = (JSONObject) stdObj;
        
        //get patient readings
        JSONArray patient_readings = (JSONArray) jsonObject.get("patient_readings");
        
        // iterating patient readings
        Iterator itr2 = patient_readings.iterator();
        Iterator<Map.Entry> itr1;
        while (itr2.hasNext()) 
        {
            itr1 = ((Map) itr2.next()).entrySet().iterator();
            lhm = new LinkedHashMap(4);
            while (itr1.hasNext()) {
                Map.Entry pair = itr1.next();
                //add only selected fields to the array 
                if(pair.getKey().equals("reading_id") 
                    || pair.getKey().equals("reading_type")
                    || pair.getKey().equals("reading_value")
                    || pair.getKey().equals("reading_date")
                )
                {
                    //add the object key and value to the map variable
                    lhm.put(pair.getKey(), pair.getValue());
                    //add the map variable to the array
                    jsonArray.add(lhm);
                }
            }
        }
        // putting readings to JSONObject
        stdObj2.put("readings", jsonArray);
        PrintWriter pw = new PrintWriter(ExportAllReadings.EXPORT_FILE_NAME);
        //write the export out put to the file 
        pw.write(stdObj2.toJSONString());
        //close the writer
        pw.flush();
        
    }          
}