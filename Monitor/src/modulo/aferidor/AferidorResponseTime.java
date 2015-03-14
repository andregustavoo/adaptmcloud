package modulo.aferidor;

import java.util.List;

import modulo.blackboard.RequestData;

public class AferidorResponseTime {
	public static Long aferir(List<RequestData> dados){
		
		System.out.print("Response Time: ");
		Long time1 = System.nanoTime();
		
		int cont = 0;
		Long responseTimeTotal = new Long(0);
		for (RequestData dado : dados){
			if(dado.isAvailable()){
				responseTimeTotal += dado.getResponseTime();
				cont++;
			}
				
			
		}
		
		if(cont == 0){
			Long time2 = System.nanoTime();
			double print = (time2-time1)/1000000.0;
			System.out.println(print);
			
			return new Long(-1);
		}
		
		Long time2 = System.nanoTime();
		double print = (time2-time1)/1000000.0;
		System.out.println(print);
		return (responseTimeTotal/cont);
	}
}
