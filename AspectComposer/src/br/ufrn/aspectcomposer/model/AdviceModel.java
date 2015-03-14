package br.ufrn.aspectcomposer.model;

public class AdviceModel {
	
	private String type;
	
	private String name;
	
	private AspectModel aspect;
	
	public AspectModel getAspect() {
		return aspect;
	}
	
	public void setAspect(AspectModel aspect) {
		this.aspect = aspect;
	}
	
	public String getType() {
		return type;
	}
	
	public void setType(String type) {
		this.type = type;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	public String getCompositionName(){
		return aspect.getName()+"."+getName();
	}

}
