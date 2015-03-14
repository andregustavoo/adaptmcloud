package br.ufrn.bb.model;

public class FeatureProperty {
	private String name;
	private String type;
	private Object value;
	
	public FeatureProperty(){
		
	}
	
	public FeatureProperty(String name, Object value){
		this.name=name;
		this.value=value;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public Object getValue() {
		return value;
	}
	public void setValue(Object value) {
		this.value = value;
	}
	
	
}
