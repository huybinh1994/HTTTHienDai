using System;
using System.Collections.Generic;
using System.Linq;
using System.Net;
using System.Net.Http;
using System.Web.Http;

namespace CardProcessing_Api.Controllers
{
    public class Merchant_TypeController : ApiController
    {
        private BusinessLayer.BusinessLayer g_BusinessLayer;
        public Merchant_TypeController()
        {
            g_BusinessLayer = new BusinessLayer.BusinessLayer();
        }
        [Route("api/merchant_status/getall")]
        [HttpGet]
        public HttpResponseMessage GetAllMerchant_Type()
        {
            object obj;
            try
            {

                obj = new { StatusCode = 200, data = g_BusinessLayer.GetAllMerchan_type() };

            }
            catch (Exception ex)
            {
                obj = new { StatusCode = 500, data = g_BusinessLayer.GetAllmerchant() };
            }
            return Request.CreateResponse(obj);
        }
    }
}
