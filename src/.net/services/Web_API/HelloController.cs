using Newtonsoft.Json;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Net;
using System.Net.Http;
using System.Web.Http;

namespace WebApi.Controllers
{
    public class HelloController : ApiController
    {
        [HttpGet]
        [Route("api/hello/index")]
        public HttpResponseMessage Test()
        {
            var obj = new { StatusCode = 200, data = new { HoTen = "Binh", Lop = "15HCB2" } };

            //string json = JsonConvert.SerializeObject(obj);



            return Request.CreateResponse(HttpStatusCode.Created, obj);
        }

    }
}
