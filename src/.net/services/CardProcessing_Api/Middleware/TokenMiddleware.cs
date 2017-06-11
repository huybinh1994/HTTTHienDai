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

            await Next.Invoke(context);

            //string v_strPath = context.Request.Path.ToString();
            //string v_strMethod = context.Request.Method;
            //var token = context.Request.Headers.ContainsKey("Authorization");
            //string  v_value = context.Request.Headers["Authorization"];
            //if(!v_strPath.Contains("api"))// lan dau tien
            //{
            //    await Next.Invoke(context);
            //}
            //else
            //{
            //    using (var context1 = new card_processingEntities())


            //        if(true)
            //        {
            //            await Next.Invoke(context);//ok vay di, sang mai tui nghien cuu tiep
            //        }
            //        else
            //        {
            //            context.Response.StatusCode = 403;
            //            await context.Response.WriteAsync("abc");
            //        }
            //        //khi gởi request sẽ vào đây
            //        //sau đó check quyền
            //        //
            //        //    // vi du kiem tra quyen thanh cong
            //        //if(true)
            //        //{
            //        //    await Next.Invoke(context);

            //        //}
            //        //else
            //        //{ 

            //        //    context.Response.StatusCode = 403;
            //        //    await context.Response.WriteAsync("abc");
            //        //}
            //        //neu ko có quyền thì mình

            //        //List<merchant> v_objToken = context1.merchants.ToList();

            //    }



        }


        public bool checkPermission(int rule)

        {
            return true;
        }






    }
    //public Dictionary<int,string>getLisPhanQuyen()
    //{
    //    Dictionary<int, string> v_dicPhanQuyen = new Dictionary<int, string>();
    //    v_dicPhanQuyen.Add(1, "/api/merchant");
    //    return getLisPhanQuyen();
    //}

    


}