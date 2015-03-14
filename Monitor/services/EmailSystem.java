/*
 =============================================================================
 FILE...............: EmailSystem.java
 COMMENTS...........: It is responsible for providing communication services,
 					  that send alert messages about the patient's medical
 					  state to his doctor and relatives through e-mail
 					  (electronic message).
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

import model.Doctor;
import model.Email;
import model.Person;
import model.Relative;


/* ========================================================================= */
/* CLASS EmailSystem                                           				 */
/* ------------------------------------------------------------------------- */
/** 
 * It is responsible for providing communication services, that send alert 
 * messages about the patient's medical state to his doctor and relatives 
 * through a e-mail (electronic message).<br> 
 * Together other similar services, they can have many services (<em>e.g.</em>
 * sending SMS, recorded messages to a voicemail, e-mail etc.) available to 
 * perform the same task, allowing different workflows and one of them being 
 * chosen according its QoS (Quality of Service).
 * @author Everton Ranielly de Sousa Cavalcante
 */
public class EmailSystem
{
	/* Structure to simulate an access to a legacy system, as if there is a 
	 * system which provides these informations. As it is a simulation, instead
	 * of build the whole system, the services are created with these information
	 * statically
	 */
	private static Hashtable<String, String> email_list;
	static Person person;
	
	static
	{
		email_list = new Hashtable<String, String>();
		
		person = new Relative("Carlos da Silva", "carloss@example.com", null);
		email_list.put(person.getPersonName(), person.getEmailAddress());
		
		person = new Relative("Joao Garcia", "jgarcia@example.com", null);
		email_list.put(person.getPersonName(), person.getEmailAddress());
		
		person = new Relative("Dickson Sousa", "ds@example.com", null);
		email_list.put(person.getPersonName(), person.getEmailAddress());
		
		person = new Relative("Maria Braga", "mbr@example.com", null);
		email_list.put(person.getPersonName(), person.getEmailAddress());
		
		person = new Doctor("Filipe Lopes", "flopes@example.com", null);
		email_list.put(person.getPersonName(), person.getEmailAddress());
		
		person = new Doctor("Laura Imbra", "laura.imbra@example.com", null);
		email_list.put(person.getPersonName(), person.getEmailAddress());
		
		person = new Doctor("Cirley Duarte", "duarte@example.com", null);
		email_list.put(person.getPersonName(), person.getEmailAddress());
	}
	
	
	/**
	 * Sends an e-mail to one person.
	 * @param message Message to be sent.
	 * @param receiver Message receiver.
	 * @return String representing the service execution
	 */
	private String sendEmailService(Email message, Person receiver)
	{ return "Sending e-mail to " + receiver.getPersonName() + "..."; }
	
	
	/**
	 * Sends an e-mail to a group of people (can be relatives or doctors).
	 * @param message Message to be sent.
	 * @param personGroup Group of people (can be relatives or doctors)
	 * @return String representing the service execution
	 */
	public String sendEmailGroupService(Email message, Person[] personGroup)
	{
		for (int i = 0; i < personGroup.length; i++)
			System.out.println(sendEmailService(message, personGroup[i]));

		return "An e-mail has sent to " + personGroup.length + " people.";
	}
}
