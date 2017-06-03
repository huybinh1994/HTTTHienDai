using System;
using System.Collections.Generic;
using System.Linq;
using System.Net;
using System.Net.Http;
using System.Web.Http;
using DomainModel;
using BusinessLayer;


namespace WebApi.Controllers
{

    public class MerchantController : ApiController
    {
        private BusinessLayer.BusinessLayer g_BusinessLayer;
        public MerchantController()
        {
            g_BusinessLayer = new BusinessLayer.BusinessLayer();
        }
        [HttpGet]
        [Route("api/merchant")]
        public HttpResponseMessage GetAllMerchant()
        {
            object obj;
            try
            {

                obj = new { StatusCode = 200, data = g_BusinessLayer.GetAllmerchant() };


            }
            catch (Exception ex)
            {
                obj = new { StatusCode = 500, data = g_BusinessLayer.GetAllmerchant() };
            }
            return Request.CreateResponse(obj);



        }
    }
}
