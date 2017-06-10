using System;
using System.Collections.Generic;
using System.Linq;
using System.Net;
using System.Net.Http;
using System.Web.Http;
using BusinessLayer;
using DomainModel;

namespace CardProcessing_Api.Controllers
{
   
    public class MerchantController : ApiController
    {
        private BusinessLayer.BusinessLayer g_BusinessLayer;
        public MerchantController()
        {
            g_BusinessLayer = new BusinessLayer.BusinessLayer();
        }
        [Route("api/merchant/getall")]
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
        [Route("api/merchant/getmerchant/ids")]
        [HttpGet]
        public HttpResponseMessage GetMerchantByID([FromUri] string id)
        {
            object obj;
            try
            {

                obj = new { StatusCode = 200, data = g_BusinessLayer.getMerchantByID(Convert.ToInt32(id))};

            }
            catch (Exception ex)
            {
                obj = new { StatusCode = 500, data = g_BusinessLayer.GetAllmerchant() };
            }
            return Request.CreateResponse(obj);
        }
        [Route("api/merchant/search/{Name}/{Type}/{Provice}/{District}/{Ward}")]
        [HttpGet]
        public HttpResponseMessage searchMerchant(string Name,int Type,int Provice,int District,int Ward)
        {
            object obj = null;
            try
            {
                  
                    obj = new { StatusCode = 200, data = g_BusinessLayer.getSearchMerchant(Name,Type,Provice,District,Ward) };
                
            }
            catch (Exception ex)
            {
                obj = new { StatusCode = 500, data = g_BusinessLayer.GetAllmerchant() };
            }
            return Request.CreateResponse(obj);
        }
        // loai quy dinh merchant hay agent
        [Route("api/merchant/addmerchant/type")]
        [HttpPost]
        public HttpResponseMessage AddMerchant([FromBody] merchant entities,[FromUri] int type )
        {
            object obj = null;
            try
            {
                if (ModelState.IsValid)
                {
                    g_BusinessLayer.Addmerchant(entities);
                    obj = new { StatusCode = 200, data = entities };
                }

            }
            catch (Exception ex)
            {
                obj = new { StatusCode = 500, data = ModelState };
            }
            return Request.CreateResponse(obj);
        }
        [Route("api/merchant/updatemerchant")]
        [HttpPut]
        public HttpResponseMessage UpdateMerchant([FromBody] merchant entites)

        {
            object obj = null;
            try
            {
                if (ModelState.IsValid)
                {
                    g_BusinessLayer.Updatemerchant(entites);
                    obj = new { StatusCode = 200, data = entites };
                }


            }
            catch (Exception ex)
            {
                obj = new { StatusCode = 500, data = ModelState };
            }
            return Request.CreateResponse(obj);
        }
               
        [Route("api/merchant/deletemerchant")]
        [HttpDelete]
        public HttpResponseMessage DeleteMerchant([FromBody] merchant entities)
        {
            object obj = null;
            try
            {
                if (ModelState.IsValid)
                {
                    g_BusinessLayer.Removemerchant(entities);
                    obj = new { StatusCode = 200, data = entities };
                }
            }
            catch (Exception ex)
            {
                obj = new { StatusCode = 500, data = ModelState };
            }
            return Request.CreateResponse(obj);
        }
        [Route("api/merchant/deletemerchant/ids")]
        [HttpDelete]     
        public HttpResponseMessage DeleteMerchantByID([FromUri] string id)
        {
            object obj = null;
            try
            {

                merchant v_obj = g_BusinessLayer.getMerchantByID(Convert.ToInt32(id));
                if (v_obj != null)
                {
                    g_BusinessLayer.Removemerchant(v_obj);
                    obj = new { StatusCode = 200, data =v_obj };
                }
            }
            catch (Exception ex)
            {
                obj = new { StatusCode = 500, data = ModelState };
            }
            return Request.CreateResponse(obj);
        }


    }
}
