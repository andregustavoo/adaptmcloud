package healthwatcher.aspects.testbed;

import br.ufrn.aspectcomposer.handler.AOPHandlerJBOSS;
import br.ufrn.aspectcomposer.model.AdviceModel;
import br.ufrn.aspectcomposer.model.AspectModel;
import br.ufrn.aspectcomposer.model.PointcutModel;

public class TestBed {
	private AOPHandlerJBOSS composer;
	
	public TestBed(){
		composer=new AOPHandlerJBOSS();
	}
	//Equivale ao Produto 01 Persistence - AWS - Storage -AWS
	public void testBed01(){
		
		long time1=System.nanoTime();
		
		composer.clear();

		/*String persistencePointcut="execution(public  java.lang.Object lib.persistence.PersistenceMechanism->getCommunicationChannel())";
		String aspectPersistenceClassName="healthwatcher.aspects.persistence.AspectPersistenceAWS";
		String aspectName="paws";
		String adviceName="access";
		PointcutModel pc01=new PointcutModel();
		pc01.setDescription(persistencePointcut);
		AspectModel as01=new AspectModel();
		as01.setClassname(aspectPersistenceClassName);
		as01.setName(aspectName);
		AdviceModel adv01=new AdviceModel();
		adv01.setName(adviceName);
		adv01.setType("BEFORE");
		composer.addAdvice(as01, adv01);
		composer.bindAdvice(pc01, adv01, "pc01");
		*/
		
		
		String storagePointCut="execution(public java.lang.String healthwatcher.storage.Storage->load(java.lang.String))";
		String aspectStorageClassName="healthwatcher.aspects.storage.AspectStorageAWS";
		String aspectName="saws";
		String adviceName="load";
		
		PointcutModel pc02=new PointcutModel();
		pc02.setDescription(storagePointCut);
		AspectModel as02=new AspectModel();
		as02.setClassname(aspectStorageClassName);
		as02.setName(aspectName);
		AdviceModel adv02=new AdviceModel();
		adv02.setName(adviceName);
		adv02.setType("AROUND");
		composer.addAdvice(as02, adv02);
		composer.bindAdvice(pc02, adv02, "storage");	
		
		long time2=System.nanoTime();
		
		System.out.println("Reconf01:"+(time2-time1));
		
	}
	//TestBed 02 - Persistence - AWS - Storage HP
	public void testBed02(){
		
		long time1=System.nanoTime();
		
		/*composer.clear();
		
		String persistencePointcut="execution(public  java.lang.Object lib.persistence.PersistenceMechanism->getCommunicationChannel())";
		String aspectPersistenceClassName="healthwatcher.aspects.persistence.AspectPersistenceAWS";
		String aspectName="paws";
		String adviceName="access";
		PointcutModel pc01=new PointcutModel();
		pc01.setDescription(persistencePointcut);
		AspectModel as01=new AspectModel();
		as01.setClassname(aspectPersistenceClassName);
		as01.setName(aspectName);
		AdviceModel adv01=new AdviceModel();
		adv01.setName(adviceName);
		adv01.setType("BEFORE");
		composer.addAdvice(as01, adv01);
		composer.bindAdvice(pc01, adv01, "pc01");
		PointcutModel pc=new PointcutModel();
		pc.setDescription("execution(public static java.lang.String healthwatcher.Constants->getPass())");
		composer.bindAdvice(pc, adv01, "pc02");*/
		
		String storagePointCut="execution(public java.lang.String healthwatcher.storage.Storage->load(java.lang.String))";
		String aspectStorageClassName="healthwatcher.aspects.storage.AspectStorageDropbox";
		String aspectName="sdropbox";
		String adviceName="load";
		
		PointcutModel pc02=new PointcutModel();
		pc02.setDescription(storagePointCut);
		AspectModel as02=new AspectModel();
		as02.setClassname(aspectStorageClassName);
		as02.setName(aspectName);
		AdviceModel adv02=new AdviceModel();
		adv02.setName(adviceName);
		adv02.setType("AROUND");
		composer.addAdvice(as02, adv02);
		composer.bindAdvice(pc02, adv02, "storage");
		
		long time2=System.nanoTime();
		
		System.out.println("Reconf02:"+(time2-time1));
		
	}
	//TesBed 03 - Persistence - HP - Storage - AWS
	public void testBed03(){
		
		long time1=System.nanoTime();
		
		composer.clear();
		
		/*String persistencePointcut="execution(public  java.lang.Object lib.persistence.PersistenceMechanism->getCommunicationChannel())";
		String aspectPersistenceClassName="healthwatcher.aspects.persistence.AspectPersistenceHP";
		String aspectName="pehp";
		String adviceName="access";
		PointcutModel pc01=new PointcutModel();
		pc01.setDescription(persistencePointcut);
		AspectModel as01=new AspectModel();
		as01.setClassname(aspectPersistenceClassName);
		as01.setName(aspectName);
		AdviceModel adv01=new AdviceModel();
		adv01.setName(adviceName);
		adv01.setType("BEFORE");
		composer.addAdvice(as01, adv01);
		composer.bindAdvice(pc01, adv01, "pc01");
		PointcutModel pc=new PointcutModel();
		pc.setDescription("execution(public java.lang.String healthwatcher.Constants->getPass())");
		composer.bindAdvice(pc, adv01, "pc02");*/
		
		String storagePointCut="execution(public java.lang.String healthwatcher.storage.Storage->load(java.lang.String))";
		String aspectStorageClassName="healthwatcher.aspects.storage.AspectStorageRackspace";
		String aspectName="srackspace";
		String adviceName="load";
		
		PointcutModel pc02=new PointcutModel();
		pc02.setDescription(storagePointCut);
		AspectModel as02=new AspectModel();
		as02.setClassname(aspectStorageClassName);
		as02.setName(aspectName);
		AdviceModel adv02=new AdviceModel();
		adv02.setName(adviceName);
		adv02.setType("AROUND");
		composer.addAdvice(as02, adv02);
		composer.bindAdvice(pc02, adv02, "storage");
		
		long time2=System.nanoTime();
		System.out.println("Reconf03:"+(time2-time1));
		
	}
}
