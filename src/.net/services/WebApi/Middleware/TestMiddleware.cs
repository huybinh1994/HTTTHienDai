using Microsoft.Owin;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;
using System.Web;
 namespace WebApi.Middleware
{
    public class TestMiddleware : OwinMiddleware
    {
        public TestMiddleware(OwinMiddleware next) : base(next)
        {
        }

        public async override Task Invoke(IOwinContext context)// chỗ này ko truyền context mà truyền cái rule vào thoi
        {
            var a = context.Request.Headers.ContainsKey("Authorization");
            if(a)
            {
                var b = context.Request.Headers.GetValues("Authorization");
                context.Response.StatusCode = 403;
                await context.Response.WriteAsync("abc");
            }
            else
            {
                await Next.Invoke(context);
            }
        }
    }
}