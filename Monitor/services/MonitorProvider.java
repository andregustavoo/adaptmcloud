/*
 =============================================================================
 FILE...............: MonitorProvider.java
 COMMENTS...........: Provides information about the patient's current state;
 					  more specifically, it is responsible for providing the
 					  blood pressure value of the patient that is being 
 					  monitoring.
 =============================================================================
 AUTHOR(S)..........: Everton Ranielly de Sousa Cavalcante
 					  Department of Informatics and Applied Mathematics
 					  Federal University of Rio Grande do Norte
 LAST MODIFICATION..: January 29th, 2011
 ============================================================================= 					  
*/


/* ========================================================================= */
/* PACKAGES			                                                         */
/* ------------------------------------------------------------------------- */
package services;


/* ========================================================================= */
/* IMPORTS			                                                         */
/* ------------------------------------------------------------------------- */
import model.BloodPressure;
import model.Monitor;
import model.Patient;


/* ========================================================================= */
/* CLASS MonitorProvider	                                                 */
/* ------------------------------------------------------------------------- */
/** 
 * Provides information about the patient's current state; more specifically, 
 * it is responsible for providing the blood pressure value of the patient 
 * that is being monitored.
 * @author Everton Ranielly de Sousa Cavalcante
 */
public class MonitorProvider 
{
	/**
	 * Provides, synchronously, the blood pressure value.
	 * @param mt Blood pressure monitor
	 * @param pt Patient
	 * @return <code>BloodPressure</code> object with systole and
	 * 		   diastole values
	 */
	public BloodPressure getBloodPressureService(Monitor mt, Patient pt)
	{ 
		/* TODO 
		 * Implement syncronous service (polling) to Context Toolkit.
		 * The service must consult systole and diastole value and return
		 * a BloodPressure object with both values.
		 */
		BloodPressure bt = new BloodPressure();
		return bt;
	}
	
	
	/**
	 * Provides, asynchronously, the blood pressure value.
	 * @param mt BloodPressureMonitor
	 * @param pt Patient
	 * @return <code>BloodPressure</code> object with systole and
	 * 		   diastole values
	 */
	public BloodPressure subscribeBloodPressureService(Monitor mt, Patient pt)
	{
		/* TODO */
		BloodPressure bt = new BloodPressure();
		return bt;  
	}
}
