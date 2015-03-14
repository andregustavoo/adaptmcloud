package br.ufrn.aspectcomposer.model;

import java.util.ArrayList;
import java.util.List;

public class AspectModel {
	
	private String classname;
	
	private String name;
	
	private List<AdviceModel> advices;
	
	public AspectModel(){
		advices=new ArrayList<AdviceModel>();
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public List<AdviceModel> getAdvices(){
		return this.advices;
	}
	
	public String getClassname() {
		return classname;
	}
	public void setClassname(String classname) {
		this.classname = classname;
	}
	

}
