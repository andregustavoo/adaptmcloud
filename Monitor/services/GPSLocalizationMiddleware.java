/*
 =============================================================================
 FILE...............: GPSLocalizationMiddleware.java
 COMMENTS...........: It is responsible for providing services related to the
 					  localization of people and ambulances, for example; it
 					  has a QoC (Quality of Context) value which is considered
 					  when a workflow is being built.
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
import java.util.Hashtable;
import java.util.NoSuchElementException;

import model.Ambulance;
import model.Doctor;
import model.Hospital;
import model.IntensiveCare;
import model.Location;
import model.Patient;
import model.PatientTransport;
import model.Relative;
import model.RescueUnit;
import model.Route;


/* ========================================================================= */
/* CLASS GPSLocalizationMiddleware                                           */
/* ------------------------------------------------------------------------- */
/** 
 * It is responsible for providing services related to the localization of 
 * people and ambulances, for example; it has a QoC (Quality of Context) value 
 * which is considered when a workflow is being built.
 * @author Everton Ranielly de Sousa Cavalcante
 */
public class GPSLocalizationMiddleware 
{
	/* Structure to simulate an access to a legacy system, as if there is a 
	 * system which provides these informations. As it is a simulation, instead
	 * of build the whole system, the services are created with these information
	 * statically.
	 */
	static Hashtable<String, Relative[]> relatives;
	static Hashtable<String, Doctor[]> doctors;
	
	static ArrayList<Relative> rels;
	static Relative r;
	
	static ArrayList<Doctor> docs;
	static Doctor   d;
	
	static ArrayList<Ambulance> ambulances;
	static Ambulance a;
	
	static
	{
		relatives = new Hashtable<String, Relative[]>();
		rels = new ArrayList<Relative>();
		
		r = new Relative("Maria Braga", "mbr@example.com", new Location("40", "80"));
		rels.add(r);
		
		r = new Relative("Filipe Lopes", "flopes@example.com", new Location("60", "60"));
		rels.add(r);
		
		r = new Relative("Samara Silva", "ssilva@example.com", new Location("80", "40"));
		rels.add(r);
		
		Relative[] rls = new Relative[rels.size()];
		for (int i = 0; i < rels.size(); i++)
			rls[i] = rels.get(i);
		relatives.put("Laura Imbra", rls);
		
		
		doctors = new Hashtable<String, Doctor[]>();
		docs = new ArrayList<Doctor>();
		
		d = new Doctor("Ana Claudia Oliveira", "acoliveira@example.com", new Location("50", "50"));
		docs.add(d);
		
		d = new Doctor("Maria de Fatima Souza", "mfsouza.fatima@example.com", new Location("30", "40"));
		docs.add(d);
		
		Doctor[] dcs = new Doctor[docs.size()];
		for (int i = 0; i < docs.size(); i++)
			dcs[i] = docs.get(i);
		doctors.put("Laura Imbra", dcs);
		
		ambulances = new ArrayList<Ambulance>();
		
		a = new IntensiveCare("IC001", new Location("20", "10"));
		ambulances.add(a);
		
		a = new PatientTransport("PT001", new Location("10", "20"));
		ambulances.add(a);
		
		a = new RescueUnit("RU001", new Location("15", "15"));
		ambulances.add(a);
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
	 * Search for the closest doctor(s) regarding to a patient.
	 * @param pt Patient.
	 * @return Array containing the closest doctor(s) to the patient <code>pt</code>.
	 */
	public Doctor[] searchClosestDoctorsGPSService(Patient pt)
	{	
		// Two closest patient's doctors
		Doctor[] closestDoctors = new Doctor[2];
		
		try
		{
			// Search for doctors regarding to the patient
			if (doctors.containsKey(pt.getPersonName()))
			{
				// Patient's doctors
				Doctor[] docs = doctors.get(pt.getPersonName());
				closestDoctors[0] = docs[0];
				closestDoctors[1] = docs[1];
				
				for (int i = 2; i < docs.length; i++)
				{
					Doctor d = docs[i];
					if (calculateDistance(closestDoctors[0].getLocation(), pt.getLocation()) >
						calculateDistance(d.getLocation(), pt.getLocation()))
					{
						if (calculateDistance(closestDoctors[1].getLocation(), pt.getLocation()) >
							calculateDistance(d.getLocation(), pt.getLocation()))
							closestDoctors[0] = d;
						else
							closestDoctors[1] = d;
					}
					else
					{
						if (calculateDistance(closestDoctors[1].getLocation(), pt.getLocation()) >
							calculateDistance(d.getLocation(), pt.getLocation()))
							closestDoctors[1] = d;
					}
				}
				return closestDoctors;
			}
			else throw new NoSuchElementException();		// Patient not found
		}
		catch (NoSuchElementException ex) 
		{ 
			System.err.println("Patient " + pt.getPersonName() + " not found.");
			return null;
		}
	}
	
	
	/**
	 * Search for the closest ambulances regarding to a patient.
	 * @param pt Patient.
	 * @return Array containing the closest ambulances to the patient <code>pt</code>.
	 */
	public Ambulance[] searchClosestAmbulancesGPSService(Patient pt)
	{
		// Two closest ambulances
		Ambulance[] closestAmbulances = new Ambulance[2];
		
		closestAmbulances[0] = ambulances.get(0);
		closestAmbulances[1] = ambulances.get(1);
				
		for (int i = 2; i < ambulances.size(); i++)
		{
			Ambulance a = ambulances.get(i);
			if (calculateDistance(closestAmbulances[0].getLocation(), pt.getLocation()) >
				calculateDistance(a.getLocation(), pt.getLocation()))
			{
				if (calculateDistance(closestAmbulances[1].getLocation(), pt.getLocation()) >
					calculateDistance(a.getLocation(), pt.getLocation()))
					closestAmbulances[0] = a;
				else
					closestAmbulances[1] = a;
			}
			else
			{
				if (calculateDistance(closestAmbulances[1].getLocation(), pt.getLocation()) >
					calculateDistance(a.getLocation(), pt.getLocation()))
					closestAmbulances[1] = a;
			}
		}
		return closestAmbulances;
	}
	
	
	/**
	 * Determinate the best route (in terms of distance (the shortest route) or in terms
	 * of time (the fastest route) for the emergency staff to reach the patient and take
	 * him from his current location to the hospital that will provide aid for him.
	 * @param pt  Patient
	 * @param hp  Hospital to where the patient <code>pt</code> will be taken
	 * @param amb Closest ambulance nearby the patient <code>pt</code>
	 * @return The best route in terms of distance (the shortest route) or in terms of
	 * 		   time (the fastest route).
	 */
	// TODO Place this service in an appropriated service provider.
	public Route determineRouteService(Patient pt, Hospital hp, Ambulance amb)
	{		
		ArrayList<Location> waypoints = new ArrayList<Location>();
		waypoints.add(amb.getLocation());
		waypoints.add(pt.getLocation());
		waypoints.add(hp.getLocation());
		
		String course = "";
		course += "Leave current location\n";
		course += "Go to " + pt.getPersonName() + "'s house\n";
		course += "Leave " + pt.getPersonName() + "'s house\n";
		course += "Go to " + hp.getNameHospital() + "\n";
		
		Location[] wps = new Location[waypoints.size()];
		for (int i = 0; i < waypoints.size(); i++)
			wps[i] = waypoints.get(i);
		
		Route r = new Route(pt.getLocation(), hp.getLocation());
		r.setWaypoints(wps);
		r.setCourseDescription(course);
		
		return r;
	}
}
