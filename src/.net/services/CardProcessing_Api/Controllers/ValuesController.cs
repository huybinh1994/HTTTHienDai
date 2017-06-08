using System;
using System.Collections.Generic;
using System.Linq;
using System.Net;
using System.Net.Http;
using System.Web.Http;
using BusinessLayer;

namespace CardProcessing_Api.Controllers
{
    
    public class ValuesController : ApiController
    {
        private BusinessLayer.BusinessLayer g_BusinessLayer;
        public ValuesController()
        {
            g_BusinessLayer = new BusinessLayer.BusinessLayer();
        }
        [HttpGet]
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
      

        // GET api/values/5
        public string Get(int id)
        {
            return "value";
        }

        // POST api/values
        public void Post([FromBody]string value)
        {
        }

        // PUT api/values/5
        public void Put(int id, [FromBody]string value)
        {
        }

        // DELETE api/values/5
        public void Delete(int id)
        {
        }
    }
}
