package br.ufrn.bb.main;


import br.ufrn.bb.model.Feature;
import br.ufrn.bb.model.FeatureModel;
import br.ufrn.bb.model.FeatureProperty;
import br.ufrn.bb.model.PermutationSet;
import br.ufrn.bb.model.Solution;
import br.ufrn.bruteforce.algorithm.BruteForceSolver;

public class MainBruteForceTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		//Features;
		Feature f1,f2,f3,f4,f5,f6;
		Feature frack1,frack2,frack3;
		Feature fMesHP,fMesAWS;
		f1=new Feature("PAWS");
		f1.getProperties().put("responseTime", new FeatureProperty("responseTime", 0.31));
		f2=new Feature("PHP");
		f2.getProperties().put("responseTime", new FeatureProperty("responseTime", 0.17));
		f3=new Feature("SAWS");
		f3.getProperties().put("responseTime", new FeatureProperty("responseTime", 1.38));
		f4=new Feature("SHP");
		f4.getProperties().put("responseTime", new FeatureProperty("responseTime", 4.07));
		f5=new Feature("LAWS");
		f5.getProperties().put("responseTime", new FeatureProperty("responseTime", 0.828));
		f6=new Feature("LHP");
		f6.getProperties().put("responseTime", new FeatureProperty("responseTime", 3.25));
		frack1=new Feature("PRACK");
		frack1.getProperties().put("responseTime", new FeatureProperty("responseTime", 2.15));
		frack2=new Feature("SRACK");
		frack2.getProperties().put("responseTime", new FeatureProperty("responseTime", 3.22));
		frack3=new Feature("LRACK");
		frack3.getProperties().put("responseTime", new FeatureProperty("responseTime", 0.45));
		fMesAWS=new Feature("MAWS");
		fMesAWS.getProperties().put("responseTime", new FeatureProperty("responseTime", 1.25));
		fMesHP=new Feature("MHP");
		fMesHP.getProperties().put("responseTime", new FeatureProperty("responseTime", 3.15));
		FeatureModel fm=new FeatureModel(4);
		fm.getFeatures().get(0).add(f1);
		fm.getFeatures().get(0).add(f2);
		fm.getFeatures().get(0).add(frack1);
		fm.getFeatures().get(1).add(f3);
		fm.getFeatures().get(1).add(f4);
		fm.getFeatures().get(1).add(frack2);
		fm.getFeatures().get(2).add(f5);
		fm.getFeatures().get(2).add(f6);
		fm.getFeatures().get(2).add(frack3);
		fm.getFeatures().get(3).add(fMesAWS);
		fm.getFeatures().get(3).add(fMesHP);
		PermutationSet solutionSpace=new PermutationSet(fm);
		BruteForceSolver solver=new BruteForceSolver(solutionSpace);
		long time1=System.nanoTime();
		Solution s=solver.solve();
		long time2=System.nanoTime();
		System.out.println(time2-time1);
		System.out.println(s.toString());
				

	}

}
