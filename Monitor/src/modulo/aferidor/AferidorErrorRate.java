package modulo.aferidor;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.List;

import modulo.blackboard.RequestData;


public class AferidorErrorRate {
	@SuppressWarnings("deprecation")
	public static Float aferir(List<RequestData> dados, Float tempoTotal, Long tempoRequisicao){
		System.out.print("Error Rate: ");
		Long time1 = System.nanoTime();
		if (dados.isEmpty()){
			return new Float(0);
		}
		int hora = dados.get(0).getTimeStamp().getHours();
		double totalSemFuncionar = 0;
		boolean aux = false;
		for (RequestData meta : dados) {
			if(meta.getTimeStamp().getHours() != hora){
				break;
			}
			if (!meta.isAvailable()) {
				totalSemFuncionar += tempoRequisicao;
				aux = true;
			} else {
				if (aux) {
					aux = false;
				}
			}
		}
		
		Double t = (totalSemFuncionar/tempoTotal);
		BigDecimal big = new BigDecimal(t).setScale(2, RoundingMode.HALF_DOWN);
		Long time2 = System.nanoTime();
		double print = (time2-time1)/1000000.0;
		System.out.println(print);
		return big.floatValue();
		
	}
}
