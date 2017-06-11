package dao;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;
import org.hibernate.transform.Transformers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import model.MasterDTO;
import model.MasterReportDTO;
import model.TransactionDTO;
import model.UserDTO;
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
	@Override
	public List<TransactionDTO> getAll() {
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		try {
			

			Query q = session.createQuery("select e from [transaction] e");
			List<TransactionDTO> li = q.list();

			session.getTransaction().commit();
			return li;
		} catch (Exception e) {
			e.printStackTrace();
			session.getTransaction().rollback();
			return null;
		}

	}
	
	@Override
	public TransactionDTO Statistic_Follow_MerchantName(String Merchant_code) {
		
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();

		
		String hql = "select t from transactions t where t.merchant_code=?";
//		try {
			Query query = session.createQuery(hql);
			query.setString(0, Merchant_code);
			List<TransactionDTO> li = query.list();
			session.getTransaction().commit();
			TransactionDTO tran = li.get(0);
			String a = tran.getTransaction_id();
			String mercode = tran.getMerchant_code();
			return li.get(0);
//		} catch (Exception e) {
//			e.printStackTrace();
//			session.getTransaction().rollback();
//			return 0;
//		}
	
	}

	@Override
	public List<TransactionDTO> Statistic_Follow_Time_Range(String startDate , String endDate) throws Exception {
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS");
		Date fromDate = df.parse(startDate);
		Date toDate = df.parse(endDate);
		Criteria criteria = session.createCriteria(TransactionDTO.class)
				   .add(Restrictions.between("transaction_date", fromDate , toDate ));
		List<TransactionDTO> li = criteria.list();
		
		return li;
		
	
	}

	
	@Override
	public TransactionDTO Statistic_Follow_Specific_Time(String time) throws Exception {
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		try {
			SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS");
			Date DATE = df.parse(time);
			Query q = session.createQuery("from transactions  where transaction_date = ?");
			q.setTimestamp(0, DATE);
			TransactionDTO a = (TransactionDTO) q.list().get(0);
			session.getTransaction().commit();
			return a;
		
		} catch (Exception e) {
			e.printStackTrace();
			session.getTransaction().rollback();
			return null;
		}
		
	
	}

	@Override
	public List<MasterReportDTO> callMasterReport(Date fromTime, Date toTime) {
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		try {
			String qu="exec master_report '','','2017-01-07 07:47:45.220','2017-04-07 07:47:45.220'";	
			Query query = session.createSQLQuery(qu).setResultTransformer(
                    Transformers.aliasToBean(MasterReportDTO.class));
			return query.list();
		
		} catch (Exception e) {
			e.printStackTrace();
			session.getTransaction().rollback();
			return null;
		}	
	}

	@Override
	public List<MasterReportDTO> callMastetReportCardtype(Date fromtime, Date totime) {
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		try {
			String qu="exec master_report '','','2017-01-07 07:47:45.220','2017-04-07 07:47:45.220'";	
			Query query = session.createSQLQuery(qu).setResultTransformer(
                    Transformers.aliasToBean(MasterReportDTO.class));
			return query.list();
		
		} catch (Exception e) {
			e.printStackTrace();
			session.getTransaction().rollback();
			return null;
		}	
	}

}
