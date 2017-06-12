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

                obj = new { statusCode = 200, data = g_BusinessLayer.GetAllmerchant() };

            }
            catch (Exception ex)
            {
                obj = new { statusCode = 500, data = ex.Message };
            }
            return Request.CreateResponse(obj);
        }
        [Route("api/merchant/matersearch/{UserId}/{LoaiXem}/{Merchant_code}/{Region}/{Merchant_type}")]
        [HttpGet]
        public HttpResponseMessage matersearchMerchant(int UserId, int LoaiXem, string Merchant_code, string Region, int Merchant_type)
        {
            object obj = null;
            try
            {
                    obj = new { statusCode = 200, data = g_BusinessLayer.mastersearchMerchant(UserId, LoaiXem, Merchant_code, Region, Merchant_type) };
            }
            catch (Exception ex)
            {
                obj = new { statusCode = 500, data = ex.Message };
            }
            return Request.CreateResponse(obj);
        }
        [Route("api/merchant/agentsearch/{UserId}/{LoaiXem}/{Merchant_code}/{Region}/{Merchant_type}")]
        [HttpGet]
        public HttpResponseMessage agentsearchMerchant(int UserId, int LoaiXem, string Merchant_code, string Region, int Merchant_type )
        {
            object obj = null;
            try
            {
                obj = new { statusCode = 200, data = g_BusinessLayer.agentsearchMerchant(UserId, LoaiXem, Merchant_code, Region, Merchant_type) };
            }
            catch (Exception ex)
            {
                obj = new { statusCode = 500, data = ex.Message };
            }
            return Request.CreateResponse(obj);
        }
        [Route("api/merchant/subagentsearch/{UserId}/{LoaiXem}/{Merchant_code}/{Region}/{Merchant_type}")]
        [HttpGet]
        public HttpResponseMessage subagentsearchMerchant(int UserId, int LoaiXem, string Merchant_code, string Region, int Merchant_type)
        {
            object obj = null;
            try
            {
                obj = new { statusCode = 200, data = g_BusinessLayer.subagentsearchMerchant(UserId, LoaiXem, Merchant_code, Region, Merchant_type) };
            }
            catch (Exception ex)
            {
                obj = new { statusCode = 500, data = ex.Message };
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
