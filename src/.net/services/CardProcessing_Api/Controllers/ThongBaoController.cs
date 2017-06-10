using System;
using System.Collections.Generic;
using System.Linq;
using System.Net;
using System.Net.Http;
using System.Web.Http;
using DomainModel;

namespace CardProcessing_Api.Controllers
{
    public class ThongBaoController : ApiController
    {
        private BusinessLayer.BusinessLayer g_BusinessLayer;
        public ThongBaoController()
        {
            g_BusinessLayer = new BusinessLayer.BusinessLayer();
        }
        [Route("api/thongbao/getall")]
        [HttpGet]
        public HttpResponseMessage GetAllThongBao()
        {
            object obj;
            try
            {

                obj = new { StatusCode = 200, data = g_BusinessLayer.GetAllThongBao() };

            }
            catch (Exception ex)
            {
                obj = new { StatusCode = 500 };
            }
            return Request.CreateResponse(obj);
        }
        [Route("api/thongbao/search/{fDate}/{tDate}")]
        [HttpGet]
        public HttpResponseMessage searchThongBao(string Name, int Type, int Provice, int District, int Ward)
        {
            object obj = null;
            try
            {

                obj = new { StatusCode = 200, data = g_BusinessLayer.getSearchMerchant(Name, Type, Provice, District, Ward) };

            }
            catch (Exception ex)
            {
                obj = new { StatusCode = 500, data = g_BusinessLayer.GetAllmerchant() };
            }
            return Request.CreateResponse(obj);
        }
        //// loai quy dinh merchant hay agent
        [Route("api/merchant/addthongbao")]
        [HttpPost]
        public HttpResponseMessage AddThongBao([FromBody] thongbao entities)
        {
            object obj = null;
            try
            {
                if (ModelState.IsValid)
                {
                    g_BusinessLayer.Addthongbao(entities);
                    obj = new { StatusCode = 200, data = entities };
                }

            }
            catch (Exception ex)
            {
                obj = new { StatusCode = 500, data = ModelState };
            }
            return Request.CreateResponse(obj);
        }
        [Route("api/merchant/updatethongbao")]
        [HttpPut]
        public HttpResponseMessage UpdateThongBao([FromBody] thongbao entites)

        {
            object obj = null;
            try
            {
                if (ModelState.IsValid)
                {
                    g_BusinessLayer.Updatethongbao(entites);
                    obj = new { StatusCode = 200, data = entites };
                }


            }
            catch (Exception ex)
            {
                obj = new { StatusCode = 500, data = ModelState };
            }
            return Request.CreateResponse(obj);
        }

        [Route("api/merchant/deletethongbao")]
        [HttpDelete]
        public HttpResponseMessage DeleteThongBao([FromBody] thongbao entities)
        {
            object obj = null;
            try
            {
                if (ModelState.IsValid)
                {
                    g_BusinessLayer.Removethongbao(entities);
                    obj = new { StatusCode = 200, data = entities };
                }
            }
            catch (Exception ex)
            {
                obj = new { StatusCode = 500, data = ModelState };
            }
            return Request.CreateResponse(obj);
        }
        [Route("api/thongbao/deletethongbao/ids")]
        [HttpDelete]
        public HttpResponseMessage DeleteThongBaoByID([FromUri] string id)
        {
            object obj = null;
            try
            {

                thongbao v_obj = g_BusinessLayer.getThongBaoByID(Convert.ToInt32(id));
                if (v_obj != null)
                {
                    g_BusinessLayer.Removethongbao(v_obj);
                    obj = new { StatusCode = 200, data = v_obj };
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
