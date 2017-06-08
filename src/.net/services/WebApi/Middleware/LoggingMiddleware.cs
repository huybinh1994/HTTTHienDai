using Microsoft.Owin;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;
using System.Web;
using Microsoft.Owin.Extensions;
using System.Threading.Tasks;

namespace WebApi.Middleware
{
    public class LoggingMiddleware : OwinMiddleware
    {
        public LoggingMiddleware(OwinMiddleware next)
            :base(next)
        {
        }

        public async override Task Invoke(IOwinContext context)
        {
            try
            {


                if (context.Request.Headers.ContainsKey("Authorization"))
                {
                    string token = context.Request.Headers["Authorization"];
                    if(token!=null)
                    {

                    }
                    else
                    {
                        context.Response.StatusCode = 401;
                    }
                  
                }
                await Next.Invoke(context);
            }
            catch(Exception ex)
            {
                context.Response.StatusCode = 401;
                
            }
        


            Console.WriteLine("End Request");
        }
    }
}