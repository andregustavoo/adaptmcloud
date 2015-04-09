package healthwatcher.model.healthguide;

import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import lib.exceptions.ObjectNotFoundException;
import lib.exceptions.ObjectNotValidException;
import lib.exceptions.RepositoryException;
import lib.exceptions.TransactionException;
import lib.patterns.observer.Observer;
import lib.patterns.observer.Subject;

@SuppressWarnings("serial")
public class MedicalSpeciality implements java.io.Serializable, Subject {
	

	private Long id;


	private String descricao;


	private int teste;
	
	//#if relacional
	private List subscribers = new ArrayList();
	//#endif
	
	public MedicalSpeciality(String descricao) {
		this.descricao = descricao;
	}
	
	public void setCode(int codigo){	
		this.teste = codigo;
	}
	
	public int getCode(){
		return this.teste;
	}
	
	public void setId(Long code){
		this.id = code;
	}
	
	public Long getId() {
		return this.id;
	}

	public String getDescricao() {
		return this.descricao;
	}


	public void setDescricao(String descricao) {
		this.descricao = descricao;
		//#if relacional
		notifyObservers(); //thiago alterou aqui
		//#endif
		
	}

	public String toString() {
		return descricao;
	}

	
	
	//#if relacional
	public void addObserver(Observer observer) {
		subscribers.add(observer);
	}

	public void removeObserver(Observer observer) {
		subscribers.remove(observer);
	}

	public void notifyObservers() {
		for (Iterator it = subscribers.iterator(); it.hasNext();) {
			Observer observer = (Observer) it.next();
			try {
				observer.notify(this);
			} catch (RemoteException e) {
				e.printStackTrace();
			} catch (ObjectNotValidException e) {
				e.printStackTrace();
			} catch (ObjectNotFoundException e) {
				e.printStackTrace();
			} catch (TransactionException e) {
				e.printStackTrace();
			} catch (RepositoryException e) {
				e.printStackTrace();
			}
		}
	}
	//#endif
}
