using Microsoft.Owin;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;
using System.Web;
using BusinessLayer;
using DomainModel;
using DataAccessLayer;

namespace CardProcessing_Api.Middleware
{
    public class TokenMiddleware: OwinMiddleware
    {
        private BusinessLayer.BusinessLayer g_BusinessLayer;
        public TokenMiddleware(OwinMiddleware next) : base(next)
        {
            g_BusinessLayer = new BusinessLayer.BusinessLayer();
        }

        public async override Task Invoke(IOwinContext context)
        {
            //await Next.Invoke(context);


            string v_strPath = context.Request.Path.ToString();
            string v_strMethod = context.Request.Method;
            var token = context.Request.Headers.ContainsKey("Authorization");
        
           
            if (!v_strPath.Contains("api"))// lan dau tien
            {
                await Next.Invoke(context);
            }
            else
            {
                string v_value = context.Request.Headers.GetValues("token").FirstOrDefault().ToString();
                if(Check_Fuction(v_value,v_strPath))
                {
                    await Next.Invoke(context);
                }
                else
                {
                    context.Response.StatusCode = 401;
                    await context.Response.WriteAsync("Unauthorized");
                }
             
            }
          


        }


        public Dictionary<string,int> getLisPhanQuyen()
        {
            Dictionary<string, int> v_dicPhanQuyen = new Dictionary<string,int>();
            //Quyen Phan He Master
            v_dicPhanQuyen.Add( "api/merchant/getall",1);
            v_dicPhanQuyen.Add("api/merchant/search",1);
            v_dicPhanQuyen.Add("api/merchant/addmerchant/type",1);
            v_dicPhanQuyen.Add("api/merchant/updatemerchant",1);
            v_dicPhanQuyen.Add("api/merchant/deletemerchant",1);
            v_dicPhanQuyen.Add("api/merchant/deletemerchant/ids",1);
            v_dicPhanQuyen.Add("api/merchant/getmerchant/ids",1);
            return getLisPhanQuyen();
        }
        public bool Check_Fuction(string p_strtoken,string p_path)
        {
            bool v_result = false;
            token v_objToken = g_BusinessLayer.getToken(p_strtoken);
            if(v_objToken!=null)
            {
                user v_objuser = g_BusinessLayer.getUserByKey(v_objToken.auther_id);
                if(v_objuser!=null)
                {
                    var check = getLisPhanQuyen().Where(x =>x.Key==p_path).FirstOrDefault();
                  

                }
            }
            return v_result;
        }






    }





}