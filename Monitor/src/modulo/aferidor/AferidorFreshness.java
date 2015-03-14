package modulo.aferidor;

import java.util.List;

import modulo.blackboard.RequestData;

public class AferidorFreshness {
	public static Long aferir(List<RequestData> dados, Long tempoRequisicao) {
		System.out.print("Freshness: ");
		Long time1 = System.nanoTime();
		
		int cont = 1;
		int max = 0;

		for (int i = 0; i < dados.size(); i++) {
			if ((i + 1) == dados.size()) {
				break;
			}

			if (dados.get(i).isAvailable()) {
				if (dados.get(i).getFreshness() != null
						&& dados.get(i + 1).getFreshness() != null) {
					if (dados.get(i).getFreshness()
							.compareTo(dados.get(i + 1).getFreshness()) == 0) {
						cont++;
					} else {
						cont = 1;
						if (cont > max) {
							max = cont;
						}
					}
				}
			}

		}
		if (cont > max) {
			max = cont;
		}
		
		Long time2 = System.nanoTime();
		double print = (time2-time1)/1000000.0;
		System.out.println(print);
		return (new Long(max * tempoRequisicao));

	}
}
