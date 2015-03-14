package repositorio.cliente;

import java.util.List;
import hibernate.DAOGenericoJPA;

public class RepositorioCliente {
	private static RepositorioCliente singleton;
	private DAOGenericoJPA<Cliente> dao;
	
	public static RepositorioCliente getInstance(){
		if (singleton == null){
			singleton = new RepositorioCliente();
		}
		return singleton;
	}
	
	private RepositorioCliente(){
		this.dao = new DAOGenericoJPA<Cliente>(Cliente.class);
	}
	
	public void cadastrarCliente(Cliente cliente){
		this.dao.addEntity(cliente);
	}
	
	public Cliente getById(Long id){
		return this.dao.getById(id);
	}
	
	public List<Cliente> getByField(String campo, Object value){
		return this.dao.getByField(campo, value);
	}
	
	public List<Cliente> listAll(){
		return this.dao.listAll();
	}
}
