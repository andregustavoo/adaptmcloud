/*
 =============================================================================
 FILE...............: MedicalProfileDatabase.java
 COMMENTS...........: Responsible for providing information abou the patient's
 					  medical profile, that is a kind of a medical record
 					  containing previous information (e.g. events/diagnoses,
 					  administred therapies and medicines) as well as current
 					  information (e.g., if the patient is obese or not,
 					  hypertensive or not, if he has other diseases and/or
 					  allergies which may influence their treatment or be
 					  correlated to the problem in question) about the patient.
 =============================================================================
 AUTHOR(S)..........: Everton Ranielly de Sousa Cavalcante
 					  Department of Informatics and Applied Mathematics
 					  Federal University of Rio Grande do Norte
 LAST MODIFICATION..: August 31st, 2011
 ============================================================================= 					  
*/


/* ========================================================================= */
/* PACKAGES			                                                         */
/* ------------------------------------------------------------------------- */
package services;


/* ========================================================================= */
/* IMPORTS			                                                         */
/* ------------------------------------------------------------------------- */
import java.util.ArrayList;

import model.Location;
import model.MedicalProfile;
import model.Patient;


/* ========================================================================= */
/* CLASS MedicalProfileDatabase                                              */
/* ------------------------------------------------------------------------- */
/** 
 * Responsible for providing information about the patient's medical profile, 
 * that is a kind of a medical record containing previous information 
 * (<em>e.g.</em> events/diagnoses, administered therapies and medicines) as 
 * well as current information (<em>e.g.</em>, if the patient is obese or not,
 * hypertensive or not, if he has other diseases and/or allergies which may 
 * influence their treatment or be correlated to the problem in question) 
 * about the patient.
 * @author Everton Ranielly de Sousa Cavalcante
 */
public class MedicalProfileDatabase 
{
	/* Structure to simulate an access to a legacy system, as if there is a 
	 * system which provides these informations. As it is a simulation, instead
	 * of build the whole system, the services are created with these information
	 * statically
	 */
	private static ArrayList<MedicalProfile> mprofile;
	static MedicalProfile mp;
	static Patient p;
	static String information;
	
	static
	{
		mprofile = new ArrayList<MedicalProfile>();
		
		p = new Patient("Laura Imbra", "lauraimbra@example.com", new Location("20", "30"), null, null);
		
		information = "";
		information += "Hypertensive\n";
		information += "Obese\n";
		information += "Smoker\n";
		
		mp = new MedicalProfile(p, information);
		mprofile.add(mp);
	}
	
	
	/**
	 * Consults the patient's medical profile.
	 * @param pt Patient
	 * @return Patient's medical profile.
	 */
	public MedicalProfile consultMedicalProfileService(Patient pt)
	{ 
		// Searches for the medical profile regarding to the patient pt
		for (int i = 0; i < mprofile.size(); i++)
		{
			MedicalProfile mp = mprofile.get(i);
			if (mp.getPatient().getPersonName().equals(pt.getPersonName()))
				return mp;
		}
		
		// Patient not found
		return null;
	}
	
	
	/**
	 * Updates the patient's medical profile, including the occurred event.
	 * @param pt 	Patient
	 * @param info 	Occurred event
	 * @return Updated patient's medical profile
	 */
	public MedicalProfile updateMedicalProfileService(Patient pt, String info)
	{
		String ump = "";
		
		// Searches for the medical profile regarding to the patient pt
		for (int i = 0; i < mprofile.size(); i++)
		{
			MedicalProfile mp = mprofile.get(i);
			if (mp.getPatient().getPersonName().equals(pt.getPersonName()))
			{
				// Current information into patient's medical profile
				ump = mp.getInformation();
				
				// Adds the occurred event
				ump += info + "\n";
				
				// Updates the patient's medical profile
				mp.setInformation(ump);
				
				return mp;
			}
		}
		
		// Patient not found
		return null;
	}
}
