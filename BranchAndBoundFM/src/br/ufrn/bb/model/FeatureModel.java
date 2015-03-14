package br.ufrn.bb.model;

import java.util.ArrayList;
import java.util.List;

public class FeatureModel {
	private List<List<Feature>> features;
	
	public FeatureModel(int commonNumber){
		features=new ArrayList<List<Feature>>();
		for(int i=0;i<commonNumber;i++){
			features.add(new ArrayList<Feature>());
		}
	}
	public int getProductCount(){
		int prod=1;
		for(int i=0;i<features.size();i++){
			prod*=features.get(i).size();
		}
		return prod;
	}
	public Feature getFeature(int parentFeature,int childFeature){
		return features.get(parentFeature).get(childFeature);
	}
	public List<List<Feature>> getFeatures() {
		return features;
	}
	
}
