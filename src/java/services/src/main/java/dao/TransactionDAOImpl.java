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
import model.MasterReportCardtype;
import model.MasterReportDTO;
import model.Statistic_Follow_MerchantInfo_DTO;
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
	public TransactionDTO Statistic_Follow_MerchantCode(String Merchant_code) {

		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();

		String hql = "select t from transactions t where t.merchant_code=?";
		// try {
		Query query = session.createQuery(hql);
		query.setString(0, Merchant_code);
		List<TransactionDTO> li = query.list();
		session.getTransaction().commit();
		TransactionDTO tran = li.get(0);
		String a = tran.getTransaction_id();
		String mercode = tran.getMerchant_code();
		return li.get(0);
		// } catch (Exception e) {
		// e.printStackTrace();
		// session.getTransaction().rollback();
		// return 0;
		// }

	}

	@Override
	public List<TransactionDTO> Statistic_Follow_Time_Range(String startDate, String endDate) throws Exception {
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS");
		if (startDate == "" && endDate == "") {
			Criteria criteria_null = session.createCriteria(TransactionDTO.class);
			criteria_null.setMaxResults(10);
			List<TransactionDTO> li_null = criteria_null.list();
			return li_null;
		} else if (startDate == "") {
			Date fromDate = new Date(new Date().getTime());
			Date toDate = df.parse(endDate);
			Criteria criteria_sta = session.createCriteria(TransactionDTO.class)
					.add(Restrictions.lt("transaction_date", toDate));
			criteria_sta.setMaxResults(10);
			List<TransactionDTO> li_sta = criteria_sta.list();
			return li_sta;
		} else if (endDate == "") {
			Date fromDate = df.parse(startDate);
			Date toDate = df.parse((new Date()).toString());
			Criteria criteria_end = session.createCriteria(TransactionDTO.class)
					.add(Restrictions.between("transaction_date", fromDate, toDate));
			criteria_end.setMaxResults(10);
			List<TransactionDTO> li_end = criteria_end.list();
			return li_end;
		}

		Date fromDate = df.parse(startDate);
		Date toDate = df.parse(endDate);
		Criteria criteria = session.createCriteria(TransactionDTO.class)
				.add(Restrictions.between("transaction_date", fromDate, toDate));
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
	public List<TransactionDTO> Statistic_Follow_MasterCode(String masterCode) {

		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();

		String hql = "select t from transactions t where t.merchant_code LIKE ?";
		// try {
		Query query = session.createQuery(hql);
		// query.setParameter("code", masterCode);
		query.setString(0, masterCode + "%");
		query.setMaxResults(10);
		List<TransactionDTO> li = query.list();
		session.getTransaction().commit();
		return li;
		// } catch (Exception e) {
		// e.printStackTrace();
		// session.getTransaction().rollback();
		// return 0;
		// }

	}

	@Override
	public List<TransactionDTO> Statistic_Follow_Time_Range_OnStart(String startDate) throws Exception {
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS");
		Date fromDate = df.parse(startDate);
		Date toDate = df.parse((new Date()).toString());
		Criteria criteria_end = session.createCriteria(TransactionDTO.class)
				.add(Restrictions.between("transaction_date", fromDate, toDate));
		criteria_end.setMaxResults(10);
		List<TransactionDTO> li_end = criteria_end.list();
		return li_end;
	}

	@Override
	public List<TransactionDTO> Statistic_Follow_Time_Range_OnEnd(String endDate) throws Exception {
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS");
		Date fromDate = new Date(new Date().getTime());
		Date toDate = df.parse(endDate);
		Criteria criteria_sta = session.createCriteria(TransactionDTO.class)
				.add(Restrictions.lt("transaction_date", toDate));
		criteria_sta.setMaxResults(10);
		List<TransactionDTO> li_sta = criteria_sta.list();
		return li_sta;

	}

	@Override
	public List<Statistic_Follow_MerchantInfo_DTO> Statistic(String merchant, int mertype, String region, String code,int reportType, String startDate,
			String endDate) {
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS");

		try {
//			String qu="exec master_report '','','2017-01-07 07:47:45.220','2017-04-07 07:47:45.220'";	
//			Query query = session.createSQLQuery(qu).setResultTransformer(
//                    Transformers.aliasToBean(MasterReportDTO.class));
//			return query.list();
//			Query query = session.createSQLQuery(
//					"CALL sp_sel_list_Transaction_By_MerchantInfo(:merchantInfo,:merchantType,:region,:level,:code,:fromDate,:toDate)");
//			if(merchant==""){
//				query.setParameter("merchantInfo", "");
//
//			}
//			else if(merchant!=null){
//				query.setParameter("merchantInfo", merchant);
//
//			}
//			if(mertype==0){
//				query.setParameter("merchantType", "0");
//			}
//			else if(mertype!=0){
//				query.setParameter("merchantType", mertype);
//
//			}
//			if(region==""){
//				query.setParameter("region", "");
//
//			}
//			else if(region!=""){
//				query.setParameter("region", region);
//
//			}
//			 if (startDate == "") {
//				
//				Date fromDate = new Date(new Date().getTime());
//				Date toDate = df.parse(endDate);
//				query.setParameter("fromDate", "1970-01-01 00:00:00");
//				query.setParameter("toDate", toDate);
//
//			} else if (endDate == "") {
//				Date fromDate = df.parse(startDate);
//				Date toDate = df.parse((new Date()).toString());
//				query.setParameter("fromDate", fromDate);
//				query.setParameter("toDate", toDate);
//			}
//			else if(startDate!="" && endDate!=""){
//				query.setParameter("fromDate", startDate);
//				query.setParameter("toDate", endDate);
//			}
//			query.setParameter("region", region);
//			query.setParameter("level", level);
//			query.setParameter("code", code);
//			
//			 Not sure how to register out parameters...??
			String qu="EXEC sp_sel_rpt_master_info ?,?,?,?,?,?,?";	
			Query query = session.createSQLQuery(qu).setResultTransformer(
                    Transformers.aliasToBean(Statistic_Follow_MerchantInfo_DTO.class));
			query.setString(0, merchant);
			query.setInteger(1, mertype);
			query.setString(2, region);
			query.setString(3, code);
			query.setInteger(4, reportType);
			query.setString(5, startDate);
			query.setString(6, endDate);
			List<Statistic_Follow_MerchantInfo_DTO> li = query.list();
//			for(int i =0 ; i<= li.size() ; i++ ){
//				System.out.println(li.get(i).toString());
//			}
			session.getTransaction().commit();

			return li;
			
			
		} catch (Exception e) {
			e.printStackTrace();
			session.getTransaction().rollback();
			return null;
		}
	}

	@Override
	public List<MasterReportCardtype> Statistic_Follow_CardType(String merchant, int mertype, String region, int level, int code,
			String fromDate, String toDate) {
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS");
		try{
		String qu="EXEC sp_sel_list_Transaction_By_Merchantinfo_Cardtype '',0,'',1,1,'2017-01-10 19:45:15.327','2017-06-10 19:45:41.850'";	
		Query query = session.createSQLQuery(qu).setResultTransformer(
                Transformers.aliasToBean(MasterReportCardtype.class));
		List<MasterReportCardtype> li = query.list();
//		for(int i =0 ; i<= li.size() ; i++ ){
//			System.out.println(li.get(i).toString());
//		}
		session.getTransaction().commit();

		return li;
		
		
	} catch (Exception e) {
		e.printStackTrace();
		session.getTransaction().rollback();
		return null;
	}
		
	}
	@Override
	public List<MasterReportDTO> callMasterReport(String search,String merchan_type, String region ,String level,String code,String fromTime, String toTime) {
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		try {
			String qu="EXEC sp_sel_list_Transaction_By_MerchantInfo ?,?,?,?,?,?,?";	
			Query query = session.createSQLQuery(qu)
					.setString(0, search)
					.setString(1, merchan_type)
					.setString(2, region)
					.setString(3, level)
					.setString(4, code)
					.setString(5, fromTime)
					.setString(6, toTime)
					.setResultTransformer(
                    Transformers.aliasToBean(MasterReportDTO.class));
			return query.list();
		
		} catch (Exception e) {
			e.printStackTrace();
			session.getTransaction().rollback();
			return null;
		}	
	}

	@Override
	public List<MasterReportCardtype> callMastetReportCardtype(String search,String merchan_type, String region ,String level,String code,String fromTime, String toTime) {
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		try {
			String qu="EXEC sp_sel_list_Transaction_By_Merchantinfo_Cardtype ?,?,?,?,?,?,?";	
			Query query = session.createSQLQuery(qu)
					.setString(0, search)
					.setString(1, merchan_type)
					.setString(2, region)
					.setString(3, level)
					.setString(4, code)
					.setString(5, fromTime)
					.setString(6, toTime)
					.setResultTransformer(
                    Transformers.aliasToBean(MasterReportCardtype.class));
			return query.list();
		
		} catch (Exception e) {
			e.printStackTrace();
			session.getTransaction().rollback();
			return null;
		}	
	}

}
