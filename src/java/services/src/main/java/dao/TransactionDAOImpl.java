package dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import model.TransactionDTO;
//@Transactional
@Repository
public class TransactionDAOImpl implements TransactionDAO {
	private SessionFactory sessionFactory;

	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	@Autowired
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@Override
	public void SaveTran(TransactionDTO dto) {
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		try {
		
			session.saveOrUpdate(dto);

			session.getTransaction().commit();
		
		} catch (Exception e) {
			e.printStackTrace();
			session.getTransaction().rollback();
		
		}
		
	}

}
