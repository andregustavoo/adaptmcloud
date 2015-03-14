package hibernate;

import java.io.Serializable;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;


@SuppressWarnings("unchecked")
public class DAOGenericoJPA<T> implements DAOGenerico<T> {
	
	private Class<T> classEntity;
	protected static final EntityManagerFactory factory = Persistence.createEntityManagerFactory("myManager");
	
	public DAOGenericoJPA(Class<T> classe){
			this.classEntity = classe;
	}

	@Override
	public void addEntity(T entidade){
		EntityManager manager = factory.createEntityManager();
		
		try{
			manager.getTransaction().begin();
			manager.persist(entidade);
			manager.getTransaction().commit();
		}catch(Exception e){
			manager.getTransaction().rollback();
		}finally{
			manager.close();
		}
	}
	
	@Override
	public void removeEntity(T entidade){
		EntityManager manager = factory.createEntityManager();
		
		try{
			EntityTransaction trans = manager.getTransaction();	//add 
			trans.begin(); 	//add
			//manager.getTransaction().begin();
			T e = manager.merge(entidade); 	//add
			manager.remove(e);
			manager.getTransaction().commit();			
		}catch (Exception e) {
			manager.getTransaction().rollback();
			
		}finally{
			manager.close();
		}
		
	}

	@Override
	public void updateEntity(T entidade){
		EntityManager manager = factory.createEntityManager();
		
		try{
			manager.getTransaction().begin();
			manager.merge(entidade);
			manager.getTransaction().commit();
		}catch(Exception e){
			manager.getTransaction().rollback();
		}finally{
			manager.close();
		}
		
	}

	@Override
	public List<T> listAll() {
		EntityManager manager = factory.createEntityManager();
		
		try{
			Session session = (Session) manager.getDelegate();
			Criteria criteria = session.createCriteria(classEntity).setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);;
			return criteria.list();
		}catch (Exception e) {
			return null;
		}finally{
			manager.close();
		}
	}
	
	@Override
	public List<T> listOrderedByField(String campo, String ordenacao){
		EntityManager manager = factory.createEntityManager();
		
		Order order;
		if(ordenacao.equals("desc"))
			order = Order.desc(campo);
		else
			order = Order.asc(campo);
		
		try{
			Session session = (Session) manager.getDelegate();
			Criteria criteria = session.createCriteria(classEntity);
			criteria.addOrder(order);
			return criteria.list();
		}catch (Exception e) {
			return null;
		}finally{
			manager.close();
		}
	}
	
	@Override
	public T getById(Serializable id) {
		EntityManager manager = factory.createEntityManager();
		
		try{
			return manager.find(classEntity, id);
		}catch (Exception e) {
			return null;
		}finally{
			manager.close();
		}
	}
	
	@Override
	public List<T> getByField(String campo, Object value) {
		EntityManager manager = factory.createEntityManager();
		
		try{
			Session session = (Session) manager.getDelegate();
			Order order = Order.desc("id");
			Criteria criteria = session.createCriteria(classEntity);
			criteria.add(Restrictions.eq(campo, value));
			criteria.addOrder(order);
			return criteria.list();
		}catch (Exception e) {
			return null;
		}finally{
			manager.close();
		}
	}
}
