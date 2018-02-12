package groupproject1;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
/**
 * This class is used for the patient object. 
 * This class allows for the setting and retrieving of a Patient's ID, and whether they're in a trial or not.
 * 
 * @author Jacob Fulton
 *
 */

class Patient 
{
    private int id;
    private boolean inTrial;
    private JSONArray readings;

    public Patient(int id, boolean inTrial){
            this.setId(id);
            this.setInTrial(inTrial);
            readings = new JSONArray();
    }


    public boolean isInTrial() {
            return inTrial;
    }


    public void setInTrial(boolean inTrial) {
            this.inTrial = inTrial;
    }


    public int getId() {
            return id;
    }


    public void setId(int id) {
            this.id = id;
    }

    //Starts a patient's trial.
    public void startTrial(){
            this.inTrial = true; 
    }

    //ends a patient's trial.	
    public void endTrial(){
            this.inTrial = false;
    }


    public JSONArray getReadings() {
            return readings;
    }


    public void setReadings(JSONArray readings) {
            this.readings = readings;
    }

    //adds a JSON object to the JSON array if patient ID matches
    //returns "successful" if the object is added, and "patient id doesn't match" if unsuccessful
    public String addReading(JSONObject obj) 
    {
        int patient_id;
        patient_id = Integer.parseInt((String) obj.get("patient_id"));
        if((patient_id == id)&&(inTrial == true))
        {
            readings.add(obj);
            return ("successful");
        }

        return("Patient ID doesn't match");
    }
}

	
