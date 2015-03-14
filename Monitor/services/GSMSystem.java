/*
 =============================================================================
 FILE...............: GSMSystem.java
 COMMENTS...........: It is responsible for providing communication services,
 					  that send alert messages about the patient's medical
 					  state to his doctor and relatives through SMS (short
 					  messages).
 					  Together other similar services, it can have
 					  many services (e.g. sending SMS, recorded messages to a
 					  voicemail, e-mail etc.) available to perform the same
 					  task, allowing different workflows and one of them being
 					  chosen according its QoS (Quality of Service).
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
import java.util.Hashtable;

import model.Cellphone;
import model.Doctor;
import model.Person;
import model.Relative;
import model.SMS;


/* ========================================================================= */
/* CLASS GSMSystem                                           				 */
/* ------------------------------------------------------------------------- */
/**
 * It is responsible for providing communication services, that send alert
 * messages about the patient's medical state to his doctor and relatives
 * through SMS (short messages).<br>
 * Together other similar services, they can have many services (<em>e.g.</em>
 * sending SMS, recorded messages to a voicemail, e-mail etc.) available to
 * perform the same task, allowing different workflows and one of them being
 * chosen according its QoS (Quality of Service).
 * @author Everton Ranielly de Sousa Cavalcante
 */
public class GSMSystem
{
	/* Structure to simulate an access to a legacy system, as if there is a
	 * system which provides these informations. As it is a simulation, instead
	 * of build the whole system, the services are created with these information
	 * statically
	 */
	private static Hashtable<String, Cellphone> devices;
	static Person person;

	static
	{
		devices = new Hashtable<String, Cellphone>();

		person = new Relative("Carlos da Silva", "carloss@example.com", null);
		devices.put(person.getPersonName(), new Cellphone(null, "001", person, "+558488777543"));

		person = new Relative("Joao Garcia", "jgarcia@example.com", null);
		devices.put(person.getPersonName(), new Cellphone(null, "002", person, "+552189986525"));

		person = new Relative("Dickson Sousa", "ds@example.com", null);
		devices.put(person.getPersonName(), new Cellphone(null, "003", person, "+558479882135"));

		person = new Relative("Maria Braga", "mbr@example.com", null);
		devices.put(person.getPersonName(), new Cellphone(null, "004", person, "+558479882135"));

		person = new Doctor("Filipe Lopes", "flopes@example.com", null);
		devices.put(person.getPersonName(), new Cellphone(null, "005", person, "+552189986525"));

		person = new Doctor("Laura Imbra", "laura.imbra@example.com", null);
		devices.put(person.getPersonName(), new Cellphone(null, "006", person, "+558479882135"));

		person = new Doctor("Cirley Duarte", "duarte@example.com", null);
		devices.put(person.getPersonName(), new Cellphone(null, "007", person, "+558488777543"));
	}


	/**
	 * Sends SMS to one person.
	 * @param message Message to be sent.
	 * @param receiver Message receiver.
	 * @return String representing the service execution
	 */
	private String sendSMSService(SMS message, Person receiver)
	{ return "Sending SMS to " + receiver.getPersonName() + "..."; }


	/**
	 * Sends SMS to a group of people (can be relatives or doctors).
	 * @param message Message to be sent.
	 * @param personGroup Group of people (can be relatives or doctors)
	 * @return String representing the service execution
	 */
	public String sendSMSGroupService(SMS message, Person[] personGroup)
	{
		for (int i = 0; i < personGroup.length; i++)
			System.out.println(sendSMSService(message, personGroup[i]));
		
		return "A SMS has sent to " + personGroup.length + " people.";
	}
}
