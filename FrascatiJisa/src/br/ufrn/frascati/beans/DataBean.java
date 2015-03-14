package br.ufrn.frascati.beans;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;

import org.apache.cxf.jaxrs.client.JAXRSClientFactory;
import org.objectweb.fractal.api.Component;
import org.objectweb.fractal.api.Fractal;
import org.objectweb.fractal.api.factory.InstantiationException;
import org.ow2.frascati.FraSCAti;
import org.ow2.frascati.remote.introspection.Deployment;
import org.ow2.frascati.remote.introspection.Reconfiguration;
import org.ow2.frascati.remote.introspection.RemoteScaDomain;
import org.ow2.frascati.util.FrascatiException;

import br.ufrn.frascati.dao.IDAOProduct;
import br.ufrn.frascati.model.Product;


public class DataBean implements Serializable {

	private static final long serialVersionUID = 1L;
	private FraSCAti frascati;
	private Component composite;
	private IDAOProduct dao;
	private static final String BINDING_URI = "http://localhost:8009";
	@PostConstruct
	public void init(){
		try {
			frascati=FraSCAti.newFraSCAti();
			composite= frascati.getComposite("database");
			dao=frascati.getService(composite, "databaseService", IDAOProduct.class);
		} catch (FrascatiException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public List<Product> getProducts(){
		return dao.getProducts();
	}
	 public void buttonAction(ActionEvent actionEvent) {
	     reconf();
	     //frascati.getCompositeManager().
	 }
	public void reconf(){
		RemoteScaDomain introspection = JAXRSClientFactory.create(BINDING_URI+"/introspection", RemoteScaDomain.class);
		//Reconfiguration reconfiguration = JAXRSClientFactory.create(BINDING_URI+"/reconfig", Reconfiguration.class);
		//Deployment deployment = JAXRSClientFactory.create(BINDING_URI+"/deploy", Deployment.class);
		String msg="";
		for(org.ow2.frascati.remote.introspection.resources.Component c:introspection.getDomainComposites()){
			msg+=c.getName();
		}
		
		
		FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, msg,  null);
        FacesContext.getCurrentInstance().addMessage(null, message);
	}

}
