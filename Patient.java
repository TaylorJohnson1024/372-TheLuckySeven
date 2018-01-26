package GroupProject1;

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
	
	
	public Patient(int id, boolean inTrial){
		this.setId(id);
		this.setInTrial(inTrial);
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
	
	
}
	