package br.ufrn.bb.algorithm;

import br.ufrn.bb.model.PermutationSet;
import br.ufrn.bb.model.Solution;

public class FeatureModelSolver {
	private PermutationSet solutionSpace;
	private short flags[];
	private short backupFlags[];
	private short perm[];
	private int contInteractions,contSucessInteractions;
	private int currentFeature,currentVariability;
	private boolean cuttoff[][];//N de fetures x Maior espa�o de subfeature
	public FeatureModelSolver(PermutationSet solutionSpace) {
		this.solutionSpace=solutionSpace;
		flags=new short[solutionSpace.getFeatureModel().getFeatures().size()];
		backupFlags=new short[flags.length];
		perm=new short[flags.length];
		//Initial set
		int maxDimension=Short.MIN_VALUE;
		for(int i=0;i<flags.length;i++){
			flags[i]=0;
			perm[i]=(short)solutionSpace.getFeatureModel().getFeatures().get(i).size();
			if(perm[i]>maxDimension)
				maxDimension=perm[i];
		}
		contInteractions=0;
		contSucessInteractions=0;
		cuttoff=new boolean[solutionSpace.getFeatureModel().getFeatures().size()][maxDimension];//Recuperar automaticamente
	}
	
	public void setInitalPosition(short positions[]){
		for(int i=0;i<positions.length;i++){
			flags[i]=positions[i];
		}
	}
	
	private void resumeFlag(){
		for(int i=0;i<flags.length;i++)
			flags[i]=backupFlags[i];
	}
	
	private void nextFlag(){
		int x=0;
		int nextFeature;
		//backup das flags
		for(int i=0;i<flags.length;i++)
			backupFlags[i]=flags[i];
		//Loop que gira avaliando as solu��es ainda dispon�veis dentro do espa�o de solu��o
		while(true){
			if(flags[x]+1==solutionSpace.getFeatureModel().getFeatures().get(x).size()){
				if(!cuttoff[x][0]){
					flags[x]=0;
				}
				x++;
			}else if((nextFeature=getNextAvailableSubFeature(x))!=-1){
				flags[x]=(short)nextFeature;
				currentFeature=x;
				currentVariability=flags[x];
				break;
			}else{
				x++;
			}
			if(x==flags.length)
				x=0;
		}
		
	}
	private int getNextAvailableSubFeature(int x){
		int cont=0;
		int actualFeature=flags[x];
		while(cont<solutionSpace.getFeatureModel().getFeatures().get(x).size()-1){
			
			if(actualFeature+1==solutionSpace.getFeatureModel().getFeatures().get(x).size()){
				actualFeature=0;
			}else{
				actualFeature++;
			}
			
			if(!cuttoff[x][actualFeature])
				return actualFeature;
			cont++;
		}
		return -1;
	}
	//Conta o n�mero de combina��es
	public boolean isOver(){
		int prod=1;
		for(int i=0;i<perm.length;i++){
			prod*=perm[i];
		}
		if (prod==1 || prod==0)
			return true;
		return false;
	}
	public Solution solve(Solution solution){
		contInteractions++;
		if(!isOver()){
			nextFlag();
			if (solutionSpace.evaluateSolution(solution)>=
			solutionSpace.evaluateSolution(solutionSpace.getNextSolution(solution, flags))){
				cuttoff[currentFeature][currentVariability]=true;
				perm[currentFeature]--;
				resumeFlag();
				contSucessInteractions++;
			}else{//Se eu deixe, � porque a anterior n�o presta, mas n�o preciso voltar(resumeFlag)
				cuttoff[currentFeature][currentVariability]=true;
				perm[currentFeature]--;
				contSucessInteractions=0;
			}
			return solve(solutionSpace.getNextSolution(solution, flags));	
		}else{
			return solution;
		}
		
		
	}
	public int getContInteractions(){
		return contInteractions;
	}
	public int getContSuccessInteractions(){
		return contSucessInteractions;
	}
	
}
