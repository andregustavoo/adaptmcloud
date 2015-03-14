package repositorio.servico;

import hibernate.DAOGenericoJPA;

import java.util.List;

public class RepositorioServico {
	private static RepositorioServico singleton;
	private DAOGenericoJPA<Servico> dao;
	
	private RepositorioServico(){
		this.dao = new DAOGenericoJPA<Servico>(Servico.class);
	}
	
	public static RepositorioServico getInstance(){
		if(singleton == null){
			singleton = new RepositorioServico();
		}
		return singleton;
	}
	
	public void cadastrarServico(Servico servico){
		dao.addEntity(servico);
	}
	
	public Servico getById(Long id){
		return dao.getById(id);
	}
	
	public List<Servico> getByField(String campo, Object value){
		return dao.getByField(campo, value);
	}
	
	public List<Servico> listarServicos(){
		return dao.listAll();
	}
	
}
