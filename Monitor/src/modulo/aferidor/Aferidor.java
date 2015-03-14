package modulo.aferidor;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import repositorio.metadados.Metadado;
import repositorio.metadados.RepositorioMetadados;
import repositorio.servico.Servico;
import modulo.blackboard.RequestData;

public class Aferidor {
	private static RepositorioMetadados repositorioMetadados;

	public Aferidor() {
		repositorioMetadados = RepositorioMetadados.getInstance();
	}

	public void aferir(List<RequestData> datas, Long totalTime, Long requestTime) {
		List<Metadado> jaCadastrou = new ArrayList<Metadado>();
		Servico servico = datas.get(0).getService();

		jaCadastrou = repositorioMetadados.listarPorServico(datas.get(0)
				.getService());

		//if (jaCadastrou.isEmpty()) {
			Metadado metadado = new Metadado();
			metadado.setErrorRate(AferidorErrorRate.aferir(datas, new Float(
					totalTime), requestTime));
			metadado.setLatency(AferidorResponseTime.aferir(datas));
			metadado.setMtbf(AferidorMTBF.aferir(datas, new Float(totalTime)));
			metadado.setMttr(AferidorMTTR.aferir(datas, requestTime));
			metadado.setRecoverable(AferidorRecovarable.aferir(datas));
			metadado.setResponseTime(metadado.getLatency());
			metadado.setTimeStamp(new Date());
			metadado.setService(datas.get(0).getService());

			// {Medindo o tempo}
			
			System.out.print("Up Time: ");
			Long time1 = System.nanoTime();
			
			Double t = (100.0 - metadado.getErrorRate());
			BigDecimal big = new BigDecimal(t).setScale(2,
					RoundingMode.HALF_DOWN);
			

			metadado.setUpTime(big.floatValue());
			
			Long time2 = System.nanoTime();
			double print = (time2-time1)/1000000.0;
			System.out.println(print);

			if (servico.getContexto()) {
				metadado.setFreshness(AferidorFreshness.aferir(datas,
						requestTime));
			} else {
				metadado.setFreshness(null);
			}
			repositorioMetadados.cadastrarMetadado(metadado);
			System.out.println(metadado.toString());

		//} 
		/*else {
			Metadado metadado = jaCadastrou.get(0);
			metadado.setErrorRate(AferidorErrorRate.aferir(datas, new Float(
					totalTime), requestTime));
			metadado.setLatency(AferidorResponseTime.aferir(datas));
			metadado.setMtbf(AferidorMTBF.aferir(datas, new Float(totalTime)));
			metadado.setMttr(AferidorMTTR.aferir(datas, requestTime));
			metadado.setRecoverable(AferidorRecovarable.aferir(datas));
			metadado.setResponseTime(metadado.getLatency());
			metadado.setService(datas.get(0).getService());
			metadado.setTimeStamp(new Date());
			if (servico.getContexto()) {
				metadado.setFreshness(AferidorFreshness.aferir(datas,
						requestTime));
			} else {
				metadado.setFreshness(null);
			}
			Double t = (100.0 - metadado.getErrorRate());

			// {Medindo o tempo}

			System.out.print("Up Time: ");
			Long time1 = System.nanoTime();
			
			BigDecimal big = new BigDecimal(t).setScale(2,
					RoundingMode.HALF_DOWN);

			metadado.setUpTime(big.floatValue());

			Long time2 = System.nanoTime();
			double print = (time2-time1)/1000000.0;
			System.out.println(print);
			
			repositorioMetadados.atualizarMetadado(metadado);
			
			System.out.println(metadado.toString());
			
		}*/

	}
}
