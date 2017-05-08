using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using DomainModel;
using DataAccessLayer;

namespace BusinessLayer
{
    public interface IBusinessLayer
    {
        // device
        IList<device> GetAllDevice();
        device GetDeviceByName(string name);
        void AddDevice(params device[] device);
        void UpdateDevice(params device[] device);
        void RemoveDevice(params device[] device);

        // device_status
        IList<device_status> GetDevice_Status(string name);
        void AddDevice_status(params device_status[] device_status);
        void UpdateDevice_status(params device_status[] device_status);
        void RemoveDevice_status(params device_status[] device_status);
        //master
        IList<master> GetAllMaster();
        device GetMaterByName(string name);
        void AddMater(params master[] masters);
        void UpdateMaster(params master[] masters);
        void RemoveMaster(params device[] masters);
        //mercharnt
        IList<merchant> GetAllMerchant();
        device GetMerchantByName(string name);
        void AddMerchant(params merchant[] Merchant);
        void UpdMerchant(params merchant[] Merchant);
        void RemoveMerchant(params merchant[] Merchant);
        //Parameter
        IList<parameter> GetAllParameter();
        device GetParameterByName(string name);
        void AddParameter(params parameter[] Parameter);
        void UpdParameter(params parameter[] Parameter);
        void RemoveParameter(params parameter[] Parameter);
        //trasation
        IList<transaction> GetAllTransaction();
        device GetTransactionByName(string name);
        void AddTransactionr(params transaction[] Transaction);
        void UpdTransaction(params transaction[] Transaction);
        void RemoveTransaction(params transaction[] Transaction);


    }
}
