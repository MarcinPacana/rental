package pl.rentalcar.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import pl.rentalcar.HibernateCfg;

import java.util.List;
import java.util.Map;
import java.util.Set;

public class JpaDAO<E> {

    protected static final SessionFactory sessionFactory;

    static {
        sessionFactory = HibernateCfg.getSessionFactory();
    }

    public E create(E entity) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.getTransaction();
        transaction.begin();
        session.persist(entity);
        session.flush();
        session.refresh(entity);
        transaction.commit();
        session.close();
        return entity;
    }

    public E update(E entity) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.getTransaction();
        transaction.begin();
        session.update(entity);
        transaction.commit();
        session.close();
        return entity;
    }

    public E find(Class<E> type, int id) {
        Session session = sessionFactory.openSession();
        E entity = session.find(type, id);
        session.close();
        return entity;
    }

    public void delete(Class<E> type, int id) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.getTransaction();
        transaction.begin();
        E reference = session.getReference(type, id);
        session.remove(reference);
        transaction.commit();
        session.close();
    }

    public List<E> findWithNameQuery(String nameQuery) {
        Session session = sessionFactory.openSession();
        Query query = session.createNamedQuery(nameQuery);
        List<E> resultList = query.getResultList();
        session.close();
        return resultList;
    }

    public List<E> findWithNameQuery(String nameQuery,String paramName, Object paramValue) {
        Session session = sessionFactory.openSession();
        Query query = session.createNamedQuery(nameQuery);
        query.setParameter(paramName,paramValue);
        List<E> resultList = query.getResultList();
        session.close();
        return resultList;
    }

    public List<E> findWithNameQuery(String nameQuery, Map<String,Object> paramsMap) {
        Session session = sessionFactory.openSession();
        Query query = session.createNamedQuery(nameQuery);
        Set<Map.Entry<String, Object>> setParameters = paramsMap.entrySet();
        for (Map.Entry<String,Object> entry : setParameters){
            query.setParameter(entry.getKey(), entry.getValue());
        }
        List<E> resultList = query.getResultList();
        session.close();
        return resultList;
    }





    public void close(){
        if (sessionFactory != null){
            sessionFactory.close();
        }
    }

}
