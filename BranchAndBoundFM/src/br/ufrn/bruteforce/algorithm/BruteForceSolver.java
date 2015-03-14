package br.ufrn.bruteforce.algorithm;

import br.ufrn.bb.model.PermutationSet;
import br.ufrn.bb.model.Solution;

public class BruteForceSolver {

	private PermutationSet solutionSpace;
	private short[] flags;
	
	public BruteForceSolver(PermutationSet solutionSpace){
		this.solutionSpace=solutionSpace;
		flags=new short[solutionSpace.getFeatureModel().getFeatures().size()];
		for(int i=0;i<flags.length;i++){
			flags[i]=0;
		}
	}
	
	private void nextFlag(){
		int x=0;
		//Loop que gira avaliando as soluções ainda disponíveis dentro do espaço de solução
		while(x<flags.length){
			if(flags[x]+1==solutionSpace.getFeatureModel().getFeatures().get(x).size()){
					flags[x]=0;
				x++;
			}else {
				flags[x]++;
				break;
			}
		}
	}
	public Solution solve(){
		Solution bestSolution,currentSolution;
		double costBest,costActual;
		bestSolution=solutionSpace.getNexSolution(flags);
		costBest=solutionSpace.evaluateSolution(bestSolution);
		for(int i=0;i<solutionSpace.getFeatureModel().getProductCount();i++){
			nextFlag();
			currentSolution=solutionSpace.getNexSolution(flags);
			costActual=solutionSpace.evaluateSolution(currentSolution);
			if(costActual>costBest){
				try {
					bestSolution=(Solution)currentSolution.clone();
				} catch (CloneNotSupportedException e) {
					
					e.printStackTrace();
				}
			}
		}
		return bestSolution;
	}

}
