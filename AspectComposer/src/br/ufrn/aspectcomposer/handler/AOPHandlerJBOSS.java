package br.ufrn.aspectcomposer.handler;

import java.util.ArrayList;
import java.util.List;

import org.jboss.aop.AspectManager;
import org.jboss.aop.advice.AdviceBinding;
import org.jboss.aop.advice.AdviceFactory;
import org.jboss.aop.advice.AdviceType;
import org.jboss.aop.advice.AspectDefinition;
import org.jboss.aop.advice.GenericAspectFactory;
import org.jboss.aop.advice.Scope;


import br.ufrn.aspectcomposer.model.AdviceModel;
import br.ufrn.aspectcomposer.model.AspectModel;
import br.ufrn.aspectcomposer.model.PointcutModel;

public class AOPHandlerJBOSS implements IAOPHandler {
	
	
	private List<AspectDefinition> aspects;
	private List<AdviceFactory> advices;
	private List<String> bindingsNames;
	
	public void clear(){
		for(AspectDefinition ad:aspects){
			AspectManager.instance().removeAspectDefinition(ad.getName());
		}
		
		for(String name:bindingsNames){
			AspectManager.instance().removeBinding(name);
		}
		
		aspects=new ArrayList<AspectDefinition>();
		advices=new ArrayList<AdviceFactory>();
		bindingsNames=new ArrayList<String>();
	
	}
	
	public AOPHandlerJBOSS(){
		aspects=new ArrayList<AspectDefinition>();
		advices=new ArrayList<AdviceFactory>();
		bindingsNames=new ArrayList<String>();
	}
	
	private AspectDefinition getAspectDefinition(String aspectName){
		for (AspectDefinition ad:aspects){
			if (ad.getName().equals(aspectName))
				return ad;
		}
		return null;
	}
	
	@Override
	public void addAdvice(AspectModel aspect, AdviceModel advice) {
		
		AspectDefinition ad=getAspectDefinition(aspect.getName());
		if (ad==null){
			ad=new AspectDefinition(aspect.getName(), Scope.PER_VM, 
					new GenericAspectFactory(aspect.getClassname(), null));
			AspectManager.instance().addAspectDefinition(ad);
		}
		//TODO: Implementar mœltiplos tipos de advices
		AdviceFactory adviceJBoss;
		if (advice.getType().equals("BEFORE")){
			adviceJBoss=new AdviceFactory(ad, advice.getName(),AdviceType.BEFORE);
		}else{
			adviceJBoss=new AdviceFactory(ad, advice.getName(),AdviceType.AROUND);
		}
		
		aspect.getAdvices().add(advice);
		advice.setAspect(aspect);
		advices.add(adviceJBoss);
		
		

	}

	@Override
	public void bindAdvice(PointcutModel poincut, AdviceModel advice, String featureName) {
		
		AspectManager.instance().removeBinding(featureName);
		try {
			AdviceBinding binding=new AdviceBinding(poincut.getDescription(), null);
			binding.setName(featureName);
			for(AdviceFactory ad:advices){
				if (ad.getName().equals(advice.getCompositionName())){
					binding.addInterceptorFactory(ad);
					break;
				}
			}
			AspectManager.instance().addBinding(binding);
			bindingsNames.add(featureName);
		} catch (Exception e) {
			e.printStackTrace();
		}
		

	}

}
