package br.ufrn.aspectcomposer.handler;

import br.ufrn.aspectcomposer.model.AdviceModel;
import br.ufrn.aspectcomposer.model.AspectModel;
import br.ufrn.aspectcomposer.model.PointcutModel;

public interface IAOPHandler {

	public void addAdvice(AspectModel aspect, AdviceModel advice);
	public void bindAdvice(PointcutModel poincut, AdviceModel advice,String featureName);
	
}
