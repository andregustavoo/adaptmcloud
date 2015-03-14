/*
 =============================================================================
 FILE...............: AmbulancesManagementSystem.java
 COMMENTS...........: System that manages/integrates ambulances.
 =============================================================================
 AUTHOR(S)..........: Everton Ranielly de Sousa Cavalcante
 					  Department of Informatics and Applied Mathematics
 					  Federal University of Rio Grande do Norte
 LAST MODIFICATION..: December 12th, 2010
 ============================================================================= 					  
*/


/* ========================================================================= */
/* PACKAGES			                                                         */
/* ------------------------------------------------------------------------- */
package services;


/* ========================================================================= */
/* IMPORTS			                                                         */
/* ------------------------------------------------------------------------- */
import model.Ambulance;
import model.BloodPressure;
import model.MedicalProfile;


/* ========================================================================= */
/* CLASS AmbulancesManagementSystem                                          */
/* ------------------------------------------------------------------------- */
/** 
 * System that manages/integrates ambulances.
 * @author Everton Ranielly de Sousa Cavalcante
 */
public class AmbulancesManagementSystem
{
	/**
	 * Chooses an ambulance (emergency staff) with basis on the patient's medical
	 * profile and his/her current health state
	 * @param ambs The closest ambulances regarding to the patient
	 * @param mp Patient's medical profile
	 * @param bp Patient's current blood pressure
	 * @return Selected ambulance 
	 */
	public Ambulance selectAmbulanceService(Ambulance[] ambs, MedicalProfile mp, BloodPressure bp)
	{ 
		/* TODO Change this in future, taking into account also the patient's medical profile
		 * and his/her current medical state. 
		 */
		return ambs[0]; 
	}
	
	
	/**
	 * Triggers an emergency staff.
	 * @param amb Emergency staff to be triggered
	 * @return String representing the service execution
	 */
	public String callAmbulanceService(Ambulance amb)
	{ return "Ambulance " + amb.getIdAmbulance() + " triggered."; }
}
