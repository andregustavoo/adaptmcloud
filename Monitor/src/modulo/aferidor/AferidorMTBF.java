package modulo.aferidor;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.List;

import modulo.blackboard.RequestData;


public class AferidorMTBF {
	@SuppressWarnings("deprecation")
	public static Long aferir(List<RequestData> dados, Float tempoTotal) {
		System.out.print("MTBF: ");
		Long time1 = System.nanoTime();
		if (dados.isEmpty()){
			return new Long(0);
		}
		
		int hora = dados.get(0).getTimeStamp().getHours();
		double contDeFalhas = 0;
		boolean aux = false;
		for (RequestData meta : dados) {
			if(meta.getTimeStamp().getHours() != hora){
				break;
			}
			if (!meta.isAvailable()) {
				aux = true;
			} else {
				if (aux) {
					aux = false;
					contDeFalhas++;
				}
			}
		}
		
		if (contDeFalhas==0){
			Long time2 = System.nanoTime();
			double print = (time2-time1)/1000000.0;
			System.out.println(print);
			
			return new Long(0);
		}
		
		Double t = (tempoTotal / contDeFalhas);
		BigDecimal big = new BigDecimal(t).setScale(0, RoundingMode.HALF_DOWN);
		Long retorno = big.longValue();
		
		Long time2 = System.nanoTime();
		double print = (time2-time1)/1000000.0;
		System.out.println(print);
		
		return retorno;
	}
}
