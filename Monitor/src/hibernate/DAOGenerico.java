package hibernate;

import java.io.Serializable;
import java.util.List;


public interface DAOGenerico<T> {
	
	public void addEntity(T entity);
	public void removeEntity(T entity);
	public void updateEntity(T entity);	
	public List<T> listAll();
	public List<T> listOrderedByField(String campo, String ordenacao);
	public T getById(Serializable id);
	public List<T> getByField(String campo, Object value);
}
