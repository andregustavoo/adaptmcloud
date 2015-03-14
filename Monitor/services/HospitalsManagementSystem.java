/*
 =============================================================================
 FILE...............: HospitalsManagementSystem.java
 COMMENTS...........: System that manages information related to the hospitals
 					  (e.g. availability, specialization etc.).
 =============================================================================
 AUTHOR(S)..........: Everton Ranielly de Sousa Cavalcante
 					  Department of Informatics and Applied Mathematics
 					  Federal University of Rio Grande do Norte
 LAST MODIFICATION..: December 8th, 2010
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
import java.util.Enumeration;
import java.util.Hashtable;

import model.Ambulance;
import model.BloodPressure;
import model.Hospital;
import model.Location;
import model.MedicalProfile;
import model.Patient;


/* ========================================================================= */
/* CLASS HospitalsManagementSystem                                           */
/* ------------------------------------------------------------------------- */
/** 
 * System that manages information related to the hospitals (<em>e.g.</em> 
 * availability, specialization etc.).
 * @author Everton Ranielly de Sousa Cavalcante
 */
public class HospitalsManagementSystem
{
	/* Structure to simulate an access to a legacy system, as if there is a 
	 * system which provides these informations. As it is a simulation, instead
	 * of build the whole system, the services are created with these information
	 * statically
	 */
	private static Hashtable<String, Hospital> hospitals;
	static Hospital hospital;
	
	static
	{
		hospitals = new Hashtable<String, Hospital>();
		
		hospital = new Hospital("Hospital do Coracao de Natal", new Location("Natal-RN", "30", "10"),
								"Generic hospital");
		hospitals.put(hospital.getNameHospital(), hospital);
		
		hospital = new Hospital("Hospital e Maternidade Promater", new Location("Natal-RN", "30", "10"),
								"Generic hospital");
		hospitals.put(hospital.getNameHospital(), hospital);
		
		hospital = new Hospital("Hospital Memorial", new Location("Natal-RN", "30", "10"),
								"Generic hospital");
		hospitals.put(hospital.getNameHospital(), hospital);
		
		hospital = new Hospital("Casa de Saude Sao Lucas", new Location("Natal-RN", "30", "10"),
								"Generic hospital");
		hospitals.put(hospital.getNameHospital(), hospital);
		
		hospital = new Hospital("Hospital Naval de Natal", new Location("Natal-RN", "30", "10"),
								"Generic hospital");
		hospitals.put(hospital.getNameHospital(), hospital);
		
		hospital = new Hospital("Hospital de Guarnicao de Natal", new Location("Natal-RN", "30", "10"),
								"Generic hospital");
		hospitals.put(hospital.getNameHospital(), hospital);
	}
	
	
	/**
	 * Returns the localization of a hospital.
	 * @param hpname Hospital (given by its name)
	 * @return Localization of the hospital whose name is <code>hpname</code>, received as 
	 * 		   parameter.
	 */
	public Location getHospitalLocalizationService(String hpname)
	{ 
		Hospital hp = hospitals.get(hpname);
		return hp.getLocation();
	}
	
	
	/**
	 * Calculates the distance between two locations.
	 * @param l1 Location A
	 * @param l2 Location B
	 * @return Distance between locations A and B, received as parameters.
	 */
	private double calculateDistance(Location l1, Location l2)
	{
		double latitudeDistance, longitudeDistance;
		
		latitudeDistance = Double.parseDouble(l1.getLatitude()) - 
						   Double.parseDouble(l2.getLatitude());
						   
		longitudeDistance = Double.parseDouble(l1.getLongitude()) - 
						    Double.parseDouble(l2.getLongitude());
		
		return Math.sqrt(Math.pow(latitudeDistance, 2) + Math.pow(longitudeDistance, 2));
	}
	
	
	/**
	 * Since hospitals are fixed points (<em>i.e.</em>, their localization is
	 * beforehand known), a database can be consulted in order to obtain
	 * information about their availability and specialization; this services
	 * returns the list of available hospitals which are closest to the patient 
	 * in question.
	 * @param pt Patient
	 * @return List of closest and available hospitals regarding to <code>pt</code>
	 */
	// TODO Deal with hospitals specialization
	public Hospital[] searchHospitalsService(Patient pt)
	{
		// Available hospitals
		ArrayList<Hospital> temp = new ArrayList<Hospital>();
		Enumeration<Hospital> allHospitals = hospitals.elements();
		while (allHospitals.hasMoreElements())
		{
			Hospital h = allHospitals.nextElement();
			if (h.isAvailable()) temp.add(h);
		}
		
		Hospital availableHospitals[] = new Hospital[temp.size()];
		for (int i = 0; i < temp.size(); i++)
			availableHospitals[i] = temp.get(i);
		
		// Two closest hospitals
		Hospital[] closestHospitals = new Hospital[2];
		closestHospitals[0] = availableHospitals[0];
		closestHospitals[1] = availableHospitals[1];
		
		for (int i = 2; i < availableHospitals.length; i++)
		{
			Hospital h = availableHospitals[i];
			if (calculateDistance(closestHospitals[0].getLocation(), pt.getLocation()) >
				calculateDistance(h.getLocation(), pt.getLocation()))
			{
				if (calculateDistance(closestHospitals[1].getLocation(), pt.getLocation()) >
					calculateDistance(h.getLocation(), pt.getLocation()))
					closestHospitals[0] = h;
				else
					closestHospitals[1] = h;
			}
			else
			{
				if (calculateDistance(closestHospitals[1].getLocation(), pt.getLocation()) >
					calculateDistance(h.getLocation(), pt.getLocation()))
					closestHospitals[1] = h;
			}
		}
		
		return closestHospitals;
	}
	
	
	/**
	 * Chooses a hospital for the case in question, considering the patient's localization
	 * and his/her medical profile and current health state, as well as the localization
	 * of the emergency staff responsible for providing aid to the patient.
	 * @param hosps The closest and available hospitals regarding to the patient
	 * @param amb Emergency staff (ambulance) responsible for providing aid to the patient
	 * @param mp Patient's medical profile
	 * @param bp Patient's current blood pressure
	 * @return Selected hospital
	 */
	public Hospital selectHospitalService(Hospital[] hosps, Ambulance amb, MedicalProfile mp, BloodPressure bp)
	{
		/* TODO Change this in future, taking into account also the patient's medical profile
		 * and his/her current health state, the localization of the emergency staff responsible
		 * for providing aid to the patient.
		 */
		return hosps[0];
	}
	
	
	/**
	 * Informs the selected hospital that a patient is being conducted to there
	 * (something like a patient <em>X</em>, with a problem <em>Y</em>, is being 
	 * taken to the hospital).
	 * @param h Hospital to be triggered
	 * @return String representing the service execution
	 */
	public String callHospitalService(Hospital h)
	{ 
		// TODO Make better this return information
		return "Hospital " + h.getNameHospital() + " triggered.";
	}
}
