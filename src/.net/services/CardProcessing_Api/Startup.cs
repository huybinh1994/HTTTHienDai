using System;
using System.Collections.Generic;
using System.Linq;
using Microsoft.Owin;
using Owin;
using CardProcessing_Api.Middleware;
using Microsoft.Owin.Extensions;

[assembly: OwinStartup(typeof(CardProcessing_Api.Startup))]

namespace CardProcessing_Api
{
    public partial class Startup
    {
        public void Configuration(IAppBuilder app)
        {
           
            ConfigureAuth(app);
            app.UseCors(Microsoft.Owin.Cors.CorsOptions.AllowAll);
            //ehoadonbhapp.Use<TokenMiddleware>();

        }
    }
}
