package br.ufrn.bb.model;

import java.util.ArrayList;
import java.util.List;

public class Solution implements Cloneable {
	private List<Feature> features;
	private double UFValue;
	public Solution(){
		features=new ArrayList<Feature>();
	}
	public Solution(List<Feature> features){
		this.features=features;
	}
	public List<Feature> getFeatures() {
		return features;
	}
	public void swapFeature(Feature feature, int position){
		features.set(position, feature);
	}
	//TODO: Precisa ser autom�tico esse processo
	//Fun��o de teste= min(Persistence.responseTime) and min(FileStorage.responseTime)
	
	
	@Override
	public Object clone() throws CloneNotSupportedException {
		Solution clone=new Solution(this.features);
		return clone;
	}
	@Override
	public String toString() {
		String s="";
		for(Feature f:features){
			s+=f.getName()+",";
			s+=f.getProperties().get("responseTime").getValue()+",";
		}
		s+="UFValue="+Double.toString(UFValue);
		return s;
	}
	public double getUFValue() {
		return UFValue;
	}
	public void setUFValue(double uFValue) {
		UFValue = uFValue;
	}
}
