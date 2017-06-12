using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using DomainModel;
using System.Data.SqlClient;

namespace DataAccessLayer
{
    public interface IDeviceRepository : IGenericDataRepository<device> { }
    public interface IDevice_StatusRepository : IGenericDataRepository<device_status> { }
    public interface IMasterRepository : IGenericDataRepository<master> { }
    public interface IMerchantRepository : IGenericDataRepository<merchant>
    {
        merchant getMerchantByID(int id);
        List<merchant> mastersearchMerchant(int UserID, int LoaiXem, string Merchant_code, string Region, int Merchant_type);
        List<merchant> agentsearchMerchant(int UserID, int LoaiXem, string Merchant_code, string Region, int Merchant_type);
        List<merchant> subagentsearchMerchant(int UserID, int LoaiXem, string Merchant_code, string Region, int Merchant_type);
    }
    public interface IParameterRepository : IGenericDataRepository<parameter> { }
    public interface ITransactionRepository : IGenericDataRepository<transaction> { }
    public interface ITokenRepository : IGenericDataRepository<token>
    {
    }
    public interface IUserRepository : IGenericDataRepository<user>
    {
        //user getUserByKey(int p_iKey);
      

    }    
    public interface IMerchant_TypeRepository: IGenericDataRepository<merchant_type> { }
    public interface IThongBaoRepository : IGenericDataRepository<thongbaos> { }
    public interface INotesRepository : IGenericDataRepository<note> {
        List<note> notesearch(DateTime fDate, DateTime tDate,int id, int level , int type);
    }

    public class DeviceRepositoryy : GenericDataRepository<device>, IDeviceRepository { }
    public class Device_StatusRepository : GenericDataRepository<device_status>, IDevice_StatusRepository { }
    public class MasterRepository : GenericDataRepository<master>, IMasterRepository { }
    public class MerchantRepository : GenericDataRepository<merchant>, IMerchantRepository
    {
        public merchant getMerchantByID(int id)
        {
            merchant v_obj = null;
            using (var context = new card_processingEntities())
            {
                v_obj = context.merchants.Where(x => x.id == id).FirstOrDefault();
            }
            return v_obj;
        }
        public List<merchant> mastersearchMerchant(int UserID, int LoaiXem, string Merchant_code, string Region, int Merchant_type)
        {
            List<merchant> v_listMerchant = null;
            using (var context = new card_processingEntities())
            {
                v_listMerchant = context.Database.SqlQuery<merchant>("sp_sel_master_search_merchant @UserID, @LoaiXem, @Merchan_code, @Region, @Merchant_type",
                   new SqlParameter("@UserID", UserID), new SqlParameter("@LoaiXem", LoaiXem), new SqlParameter("@Merchan_code", Merchant_code),
                   new SqlParameter("@Region", Region), new SqlParameter("@Merchant_type", Merchant_type)).ToList();
            }

            return v_listMerchant;
        }
       public List<merchant> agentsearchMerchant(int UserID, int LoaiXem, string Merchant_code, string Region, int Merchant_type)
        {
            List<merchant> v_listMerchant = null;
            using (var context = new card_processingEntities())
            {
                v_listMerchant = context.Database.SqlQuery<merchant>("sp_sel_agent_search_merchant @UserID, @LoaiXem, @Merchan_code, @Region, @Merchant_type",
                   new SqlParameter("@UserID", UserID), new SqlParameter("@LoaiXem", LoaiXem), new SqlParameter("@Merchan_code", Merchant_code),
                   new SqlParameter("@Region", Region), new SqlParameter("@Merchant_type", Merchant_type)).ToList();
            }

            return v_listMerchant;

        }
        public List<merchant> subagentsearchMerchant(int UserID, int LoaiXem, string Merchant_code, string Region, int Merchant_type)
        {
            List<merchant> v_listMerchant = null;
            using (var context = new card_processingEntities())
            {
                v_listMerchant = context.Database.SqlQuery<merchant>("sp_sel_sub_agent_search_merchant @UserID, @LoaiXem, @Merchan_code, @Region, @Merchant_type",
                   new SqlParameter("@UserID", UserID), new SqlParameter("@LoaiXem", LoaiXem), new SqlParameter("@Merchan_code", Merchant_code),
                   new SqlParameter("@Region", Region), new SqlParameter("@Merchant_type", Merchant_type)).ToList();
            }

            return v_listMerchant;

        }

     

    }
    public class ParameterRepository : GenericDataRepository<parameter>, IParameterRepository { }
    public class TransactionRepository : GenericDataRepository<transaction>, ITransactionRepository { }
    public class TokenRepository : GenericDataRepository<token>, ITokenRepository
    {
        

    }
    public class UserRepository : GenericDataRepository<user>, IUserRepository
    {


    }
    public class Merchant_TypeRepository : GenericDataRepository<merchant_type>, IMerchant_TypeRepository
    {


    }
    public class ThongBaoRepository : GenericDataRepository<thongbaos>, IThongBaoRepository
    {


    }
    public class NotesRepository : GenericDataRepository<note>, INotesRepository
    {
        public List<note> notesearch(DateTime fDate, DateTime tDate, int id, int level, int type)

        {
            List<note> v_listMerchant = null;
            using (var context = new card_processingEntities())
            {
                v_listMerchant = context.Database.SqlQuery<note>("sp_sel_list_notes @fDate, @tDate, @id, @level, @type",
                   new SqlParameter("@fDate", fDate), new SqlParameter("@tDate", tDate), new SqlParameter("@id", id),
                   new SqlParameter("@level", level), new SqlParameter("@type", type)).ToList();
            }

            return v_listMerchant;

        }


    }
}
