package modulo.aferidor;

import java.util.List;

import modulo.blackboard.RequestData;


public class AferidorRecovarable {
	@SuppressWarnings("deprecation")
	public static Boolean aferir(List<RequestData> dados) {
		
		System.out.print("Recovarable: ");
		Long time1 = System.nanoTime();
		
		if (dados.isEmpty()){
			Long time2 = System.nanoTime();
			double print = (time2-time1)/1000000.0;
			System.out.println(print);
			
			return true;
		}
		int hora = dados.get(0).getTimeStamp().getHours();
		boolean achei = false;
		for (RequestData meta : dados) {
			if(meta.getTimeStamp().getHours() != hora){
				break;
			}
			if(meta.isAvailable() && achei){
				Long time2 = System.nanoTime();
				double print = (time2-time1)/1000000.0;
				System.out.println(print);
				
				return true;
			}else if(!meta.isAvailable() && !achei){
				achei = true;
			}
		}
		
		Long time2 = System.nanoTime();
		double print = (time2-time1)/1000000.0;
		System.out.println(print);
		
		return false;
	}
}
