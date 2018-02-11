package groupproject1;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import org.json.simple.JSONObject;
import org.json.simple.JSONArray;


/**
 * Contains main. Gets the input from Input as a JSONArray,
 * and adds the given readings to the appropriate patient in 
 * the patientList ArrayList. New patients are added to patientList
 * if there is not already a patient with a matching id.
 * 
 * @GroupName:					The Lucky Seven
 * @MainClassAuthor:                            Christopher Neuman
 * @InputAuthor: 				Taylor Johnson
 * @PatientAuthor: 				Jacob Fulton
 * @ExportAllReadingsAuthor:                    Zinet Kemal
 * 
 */
public class GroupProject1 {

    /*
     * Used to keep track of the patients in the trial.
     */
    static ArrayList<Patient> patientList = new ArrayList<Patient>();
	
    /**
     * 
     * main Class, calls getInput and setOutput.
     * 
     * @param args the command line arguments
     */
    public static void main(String[] args) throws FileNotFoundException
    {
    	getInputAndExportAllReadings();
    }
    
    /**
     * Instantiates new Input object,
     * then gets a JSONArray from 
     * Input. Each JSON object in
     * the JSONArray is traversed and
     * passed to addReading.
     * finally call parseJSONAndExportAllReadings method to export all readings
     */
    public static void getInputAndExportAllReadings() throws FileNotFoundException
    {
    	Input in = new Input();
    	JSONArray patientReadings = in.getJSONArray();
    	
    	for(Object rawReading: patientReadings)
    	{
            JSONObject reading = (JSONObject) rawReading;
            addReading(reading);
    	}
        
        //export all readings 
        ExportAllReadings out = new ExportAllReadings("output.json");
        out.parseJSONAndExportAllReadings(in.getJSONArray());
    }
    
    /**
     * Adds the given reading to the correct patient.
     * A new patient is added if none with the id from
     * the given JSONObject match any existing id in
     * patientList.
     * 
     * @param reading
     */
    public static void addReading(JSONObject reading)
    {
    	/*
    	 * checks if the patientList is empty
    	 * if it is it adds a new patient to it
    	 * with the reading as its parameter.
    	 * Otherwise it cycles through patientList
    	 * looking for a patient with a matching ID.
    	 * If none is found with the same id it adds
    	 * a new patient. The patients are added with
    	 * there id's sorted from least to greatest. 
    	 */
    	if(patientList.isEmpty())
    	{
            addPatient(0, reading);
    	}
        else
    	{
            for(int i = 0; i < patientList.size(); i++)
            {
                int patient_id;
                patient_id = Integer.parseInt((String) reading.get("patient_id"));    
                if(patientList.get(i).getId() == patient_id)
                {
                        patientList.get(i).addReading(reading);
                        i = patientList.size();
                }
                else if(patientList.get(i).getId() < patient_id)
                {
                    addPatient(i, reading);
                    i = patientList.size();

                    /*
                     * adds a new patient to the end of 
                     * patientList if all of patientList
                     * has been checked and readings id 
                     * is greater than every other id in
                     * patientList.
                     */
                }
                else if(i == patientList.size()-1) 
                {
                   addPatient(-1, reading);
                }
            }
    	}
    }
    
    /**
     * Adds a new patient with the JSONObject at the given index.
     * the new patient is added to the end of patientList if the
     * index is less than 0 (usually -1).
     * 
     * @param index
     * @param reading
     */
    public static void addPatient(int index, JSONObject reading)
    {
    	Patient newP = new Patient(index, true);
    	newP.addReading(reading);
    	
    	if(index < 0)
    	{
            patientList.add(newP);
    	}else
    	{
            patientList.add(index, newP);
    	}
    	
    }
}
