package br.ufrn.bb.model;

import java.util.List;

import sun.awt.windows.ThemeReader;

public class PermutationSet {
	
	private FeatureModel featureModel;
	
	
	
	public PermutationSet(FeatureModel featureModel) {
		this.featureModel=featureModel;
	}
	
	public FeatureModel getFeatureModel(){
		return this.featureModel;
	}
	private double getMax(int feature,String propertyName){
		List<Feature> features=featureModel.getFeatures().get(feature);
		double max=Double.MIN_VALUE;
		double value;
		for(Feature f:features){
			value=(double)f.getProperties().get(propertyName).getValue();
			if(value>max)
				max=value;
		}
		return max;
		
	}
	
	private double getMaxDist(int feature,String propertyName,double threshold){
		List<Feature> features=featureModel.getFeatures().get(feature);
		double max=Double.MIN_VALUE;
		double value,norm;
		for(Feature f:features){
			value=(double)f.getProperties().get(propertyName).getValue();
			norm=getDiff(value, threshold);
			if(norm>max)
				max=norm;
		}
		return max;
	}
	private double getMinDist(int feature,String propertyName,double threshold){
		List<Feature> features=featureModel.getFeatures().get(feature);
		double min=Double.MAX_VALUE;
		double value,norm;
		for(Feature f:features){
			value=(double)f.getProperties().get(propertyName).getValue();
			norm=getDiff(value, threshold);
			if(norm<min)
				min=norm;
		}
		return min;
	}
	
	public double getMin(int feature, String propertyName){
		List<Feature> features=featureModel.getFeatures().get(feature);
		double max=Double.MAX_VALUE;
		double value;
		for(Feature f:features){
			value=(double)f.getProperties().get(propertyName).getValue();
			if(value<max)
				max=value;
		}
		return max;
	}
	/* Fun��o Min(Persistence.responseTime) and Min(FileStorage.responseTime)
	 * double propValue=(double)s.getFeatures().get(0).getProperties().get("responseTime").getValue();
		double normPRT=(getMax(0, "responseTime")-propValue)/(getMax(0, "responseTime")-getMin(0, "responseTime"));
		double propValueFileStorage=(double)s.getFeatures().get(1).getProperties().get("responseTime").getValue();
		double normFRT=(getMax(1, "responseTime")-propValueFileStorage)/(getMax(1, "responseTime")-getMin(1, "responseTime"));
	 * 
	 * */
	//Fun��o: Max(Log.responseTime)+Max(FileStorage.responseTime)
	public double evaluateSolution(Solution s){
		//double propValue=(double)s.getFeatures().get(2).getProperties().get("responseTime").getValue();
		//double normPRT=(propValue-getMin(2, "responseTime"))/(getMax(2, "responseTime")-getMin(2, "responseTime"));
		
		double propValue=(double)s.getFeatures().get(1).getProperties().get("responseTime").getValue();
		double normLRT=(getMax(1, "responseTime")-propValue)/(getMax(1, "responseTime")-getMin(1, "responseTime"));
		
		double propValuePersistence=(double)s.getFeatures().get(0).getProperties().get("responseTime").getValue();
		double normPRT=(getMaxDist(0, "responseTime",1.8)-getDiff(propValuePersistence,1.8))/(getMaxDist(0, "responseTime",1.8)-getMinDist(0, "responseTime",1.8));
		
		double propValueFileStorage=(double)s.getFeatures().get(2).getProperties().get("responseTime").getValue();
		double normFRT=(getMaxDist(2, "responseTime",1.05)-getDiff(propValueFileStorage,1.05))/(getMaxDist(2, "responseTime",1.05)-getMinDist(2, "responseTime",1.05));
		
		s.setUFValue(normLRT+normPRT+normFRT);

		return normLRT+normPRT+normFRT;
	}
	
	private double getDiff(double value,double threshold){
		if (value>threshold)
			return threshold+(value-threshold);
		else
			return threshold-value;
	}
	

	
	public Solution getNextSolution(Solution currentSolution,short conf[]){
		try {
			Solution nextSolution=(Solution)currentSolution.clone();
			for(int i=0;i<conf.length;i++)
				nextSolution.swapFeature(featureModel.getFeature(i, conf[i]), i);
			return nextSolution;
		} catch (CloneNotSupportedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}
	
	public Solution getSolution(short position[]){
		Solution sol=new Solution();
		for(int i=0;i<position.length;i++){
			sol.getFeatures().add(featureModel.getFeatures().get(i).get(position[i]));
		}
		return sol;
	}
	
	public Solution getNexSolution(short conf[]){
		Solution solution=new Solution();
		
		for(int i=0;i<conf.length;i++){
			solution.getFeatures().add(featureModel.getFeature(i, conf[i]));
		}
		
		return  solution;
	}
}
