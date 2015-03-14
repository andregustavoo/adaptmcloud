package test;

import java.rmi.RemoteException;

import fachada.servidor.FachadaServidor;

public class Principal {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		try {
			FachadaServidor.getInstance().AmazonS3();
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
