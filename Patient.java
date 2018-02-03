package GroupProject1;
import java.util.ArrayList;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
/**
 * This class is used for the patient object. 
 * This class allows for the setting and retrieving of a Patient's ID, and whether they're in a trial or not.
 * 
 * @author Jacob Fulton
 *
 */

class Patient {
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
	
	//adds a JSON object to the JSON array. 
	public void addReading(JSONObject obj) {
		
		readings.add(obj);
		
		}
	
	
}
	