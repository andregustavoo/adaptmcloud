package modulo.blackboard;

import hibernate.DAOGenericoJPA;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.lang.Long;

import modulo.aferidor.Aferidor;

import repositorio.servico.RepositorioServico;
import repositorio.servico.Servico;

import fachada.servidor.FachadaServidor;

public class Blackboard implements Runnable {
	private static Blackboard singleton;
	private FachadaServidor fachada;
	private RepositorioServico repositorioServico;
	private DAOGenericoJPA<RequestData> dao;
	private static Long totalTime;
	private static Long requestTime;

	private Blackboard() {
		fachada = FachadaServidor.getInstance();
		repositorioServico = RepositorioServico.getInstance();
		dao = new DAOGenericoJPA<RequestData>(RequestData.class);
	}

	static public Blackboard getInstance(Long _totalTime, Long _requestTime) {
		if (singleton == null) {
			singleton = new Blackboard();
		}
		totalTime = _totalTime;
		requestTime = _requestTime;
		return singleton;
	}

	public void monitorar() {
		List<Servico> servicos = repositorioServico.listarServicos();
		for (Servico servico : servicos) {
			RequestData dado = new RequestData();
			try {
				List<RequestData> lista = dao.getByField("service", servico);
				dado.setResponseTime(fachada.callService(servico));
				if (servico.getContexto()) {
					if (lista.size() % servico.getId() == 0) {
						dado.setFreshness(new Date());
					} else {
						dado.setFreshness(lista.get(0).getFreshness());
					}
				} else {
					dado.setFreshness(null);
				}
				dado.setAvailable(new Boolean(true));
				dado.setService(servico);
				dado.setTimeStamp(new Date());

			} catch (Exception e) {
				// TODO Auto-generated catch block
				dado.setAvailable(false);
				dado.setResponseTime(new Long(-1));
				dado.setService(servico);
				dado.setTimeStamp(new Date());
				dado.setFreshness(null);
			}
			dao.addEntity(dado);
		}
	}

	public void aferir() {
		List<Servico> servicos = new ArrayList<Servico>();
		servicos = repositorioServico.listarServicos();
		for (Servico servico : servicos) {
			System.out.print("Servico: ");
			System.out.println(servico.getNome());
			Aferidor aferidor = new Aferidor();
			aferidor.aferir(dao.getByField("service", servico), totalTime,
					requestTime);
			System.out.println("<<<<<<<<<<<<<<<<<<>>>>>>>>>>>>>>>>");
		}

	}

	@Override
	public void run() {
		int cont = 0;
		// TODO Auto-generated method stub
		while (cont < (totalTime / requestTime)) {
			monitorar();
			aferir();
			cont++;
			try {
				Thread.sleep(requestTime * 1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
