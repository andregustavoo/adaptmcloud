package br.ufrn.bb.model;

import java.util.HashMap;
import java.util.Map;

public class Feature {
	private String name;
	private Feature related;
	private Map<String, FeatureProperty> properties;
	
	public Feature(){
		properties=new HashMap<String,FeatureProperty>();
	}
	public Feature(String name){
		this.name=name;
		properties=new HashMap<String,FeatureProperty>();
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Feature getRelated() {
		return related;
	}
	public void setRelated(Feature related) {
		this.related = related;
	}
	public Map<String, FeatureProperty> getProperties() {
		return properties;
	}
	
	
}
