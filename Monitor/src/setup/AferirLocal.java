package setup;

import java.rmi.RemoteException;

import modulo.blackboard.Blackboard;

import repositorio.servico.Servico;

import fachada.servidor.FachadaServidor;

public class AferirLocal {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Blackboard b = Blackboard.getInstance(new Long(10), new Long(5));
		b.aferir();
	}

}
