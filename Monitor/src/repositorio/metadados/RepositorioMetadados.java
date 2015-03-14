package repositorio.metadados;


import java.util.List;

import repositorio.servico.Servico;
import hibernate.DAOGenericoJPA;

public class RepositorioMetadados {
	private static RepositorioMetadados singleton;
	private DAOGenericoJPA<Metadado> dao;
	
	private RepositorioMetadados(){
		this.dao = new DAOGenericoJPA<Metadado>(Metadado.class);
	}
	
	public static RepositorioMetadados getInstance(){
		if (singleton == null){
			singleton = new RepositorioMetadados();
		}
		
		return singleton;
	}
	
	public void cadastrarMetadado(Metadado metadado){
		dao.addEntity(metadado);
	}
	
	public void atualizarMetadado(Metadado metadado){
		dao.updateEntity(metadado);
	}
	
	public List<Metadado> listarPorServico(Servico servico){
		return dao.getByField("service", servico);
	}
	
	public Metadado getById(Long id){
		return dao.getById(id);
	}
}
