package setup;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class CriadorBanco {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		EntityManagerFactory emf  = Persistence.createEntityManagerFactory("myManager");
		emf.close();

	}

}
