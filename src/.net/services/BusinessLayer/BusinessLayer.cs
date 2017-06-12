using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using DataAccessLayer;
using DomainModel;

namespace BusinessLayer
{
    public class BusinessLayer
    {
        private readonly IDeviceRepository _devRepository;
        private readonly IDevice_StatusRepository _dev_statusRepository;
        private readonly IMasterRepository _masRepository;
        private readonly IMerchantRepository _mesRespository;
        private readonly IParameterRepository _paraRespository;
        private readonly ITransactionRepository _tranRespository;
        private readonly ITokenRepository _tokenRepository;
        private readonly IUserRepository _userRepository;
        private readonly IMerchant_TypeRepository _merchant_typeRepository;
        private readonly IThongBaoRepository _thongbaoRepository;
        private readonly INotesRepository _notesRepository;


        public BusinessLayer()
        {
            _devRepository = new DeviceRepositoryy();
            _dev_statusRepository = new Device_StatusRepository();
            _masRepository = new MasterRepository();
            _mesRespository = new MerchantRepository();
            _paraRespository = new ParameterRepository();
            _tranRespository = new TransactionRepository();
            _tokenRepository = new TokenRepository();
            _userRepository = new UserRepository();
            _merchant_typeRepository = new Merchant_TypeRepository();
            _thongbaoRepository = new ThongBaoRepository();
            _notesRepository = new NotesRepository();
        }
        #region Device
        public IList<DomainModel.device> GetAllDevice()
        {
            return _devRepository.GetAll();
        }

        public void AddDevice(params device[] devices)
        {
            _devRepository.add(devices);

        }

        public void UpdateDevice(params device[] devices)
        {
            _devRepository.update(devices);
        }

        public void RemoveDevice(params device[] devices)
        {
            _devRepository.remove(devices);
        }
        #endregion
        #region device_status
        public IList<DomainModel.device_status> GetAllDevice_status()
        {
            return _dev_statusRepository.GetAll();
        }

        public void AddDevice_Status(params device_status[] devies_status)
        {
            _dev_statusRepository.add(devies_status);
        }

        public void UpdateDevice_Status(params device_status[] devies_status)
        {
            _dev_statusRepository.update(devies_status);
        }

        public void RemoveDevice_Status(params device_status[] devies_status)
        {
            _dev_statusRepository.remove(devies_status);
        }
        #endregion
        #region Master
        public IList<DomainModel.master> GetAllmaster()
        {

            return _masRepository.GetAll();
        }

        public void Addmaster(params master[] masters)
        {
            _masRepository.add(masters);
        }

        public void Updatemaster(params master[] masters)
        {
            _masRepository.update(masters);
        }

        public void Removemaster(params master[] masters)
        {
            _masRepository.remove(masters);
        }
        #endregion
        #region Merchant

        public IList<DomainModel.merchant> GetAllmerchant()
        {

            return _mesRespository.GetAll();
        }

        public void Addmerchant(params merchant[] merchants)
        {
            _mesRespository.add(merchants);
        }

        public void Updatemerchant(params merchant[] merchants)
        {
            _mesRespository.update(merchants);
        }

        public void Removemerchant(params merchant[] merchants)
        {
            _mesRespository.remove(merchants);
        }
        public merchant getMerchantByID(int id)
        {
            return _mesRespository.getMerchantByID(id);
        }
        public List<merchant> mastersearchMerchant(int UserID, int LoaiXem, string Merchant_code, string Region, int Merchant_type)
        {
            return _mesRespository.mastersearchMerchant(UserID, LoaiXem, Merchant_code, Region, Merchant_type);
        }
        public List<merchant> agentsearchMerchant(int UserID, int LoaiXem, string Merchant_code, string Region, int Merchant_type)
        {
            return _mesRespository.agentsearchMerchant(UserID, LoaiXem, Merchant_code, Region, Merchant_type);

        }
        public List<merchant> subagentsearchMerchant(int UserID, int LoaiXem, string Merchant_code, string Region, int Merchant_type)
        {
            return _mesRespository.subagentsearchMerchant(UserID, LoaiXem, Merchant_code, Region, Merchant_type);

        }
        #endregion
        #region Parameter

        public IList<DomainModel.parameter> GetAllparameter()
        {

            return _paraRespository.GetAll();
        }

        public void Addparameter(params parameter[] parameters)
        {
            _paraRespository.add(parameters);
        }

        public void Updateparameter(params parameter[] parameters)
        {
            _paraRespository.update(parameters);
        }

        public void Removeparameter(params parameter[] parameters)
        {
            _paraRespository.remove(parameters);
        }
        #endregion
        #region Transaction
        public IList<DomainModel.transaction> GetAlltransaction()
        {


            return _tranRespository.GetAll();
        }

        public void Addtransaction(params transaction[] transactions)
        {
            _tranRespository.add(transactions);
        }

        public void Updatetransaction(params transaction[] transactions)
        {
            _tranRespository.update(transactions);
        }

        public void Removetransaction(params transaction[] parameters)
        {
            _tranRespository.remove(parameters);
        }
        #endregion
        #region Token
        public IList<DomainModel.token> GetAlltoken()
        {
            return _tokenRepository.GetAll();
        }

        public void Addtoken(params token[] tokens)
        {
            _tokenRepository.add(tokens);

        }

        public void Updatetoken(params token[] tokens)
        {
            _tokenRepository.update(tokens);
        }

        public void Removetoken(params token[] tokens)
        {
            _tokenRepository.remove(tokens);
        }

        #endregion
        #region User
        public IList<DomainModel.user> GetAlluser()
        {
            return _userRepository.GetAll();
        }

        public void Adduser(params user[] users)
        {
            _userRepository.add(users);

        }

        public void Updateuser(params user[] users)
        {
            _userRepository.update(users);
        }

        public void Removeuser(params user[] users)
        {
            _userRepository.remove(users);

        }
        //public user getUserByKey(int p_iKey)
        //{

        //    return _userRepository.getUserByKey(p_iKey);
        //}
        #endregion
        #region Merchant Type
        public IList<DomainModel.merchant_type> GetAllMerchan_type()
        {
            return _merchant_typeRepository.GetAll();
        }

        public void Addmerchant_type(params merchant_type[] merchant_type)
        {
            _merchant_typeRepository.add(merchant_type);
        }

        public void Updatemerchant_type(params merchant_type[] merchant_type)
        {
            _merchant_typeRepository.update(merchant_type);
        }

        public void Removemerchant_type(params merchant_type[] merchant_type)
        {
            _merchant_typeRepository.remove(merchant_type);
        }
        #endregion
        #region Thong Bao
        public IList<DomainModel.thongbaos> GetAllThongBao()
        {
            return _thongbaoRepository.GetAll();
        }

        public void Addthongbao(params thongbaos [] thongbao)
        {
            _thongbaoRepository.add(thongbao);
        }

        public void Updatethongbao(params thongbaos [] thongbao)
        {
            _thongbaoRepository.update(thongbao);
        }

        public void Removethongbao(params thongbaos [] thongbao)
        {
            _thongbaoRepository.remove(thongbao);
        }
        #endregion
        #region notes
        public IList<DomainModel.note> GetAllNotes()
        {
            return _notesRepository.GetAll();
        }

        public void AddNotes(params note[] thongbao)
        {
            _notesRepository.add(thongbao);
        }

        public void UpdateNotes(params note[] thongbao)
        {
            _notesRepository.update(thongbao);
        }

        public void RemoveNotes(params note [] thongbao)
        {
            _notesRepository.remove(thongbao);
        }
        public List<note> noteserach(DateTime fDate, DateTime tDate, int id,int level,int type)
        {
            return _notesRepository.notesearch(fDate, tDate, id, level, type);
        }

        #endregion

    }
}
