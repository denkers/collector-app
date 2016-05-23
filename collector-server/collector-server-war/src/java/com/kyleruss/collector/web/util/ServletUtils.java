//=========================================
//  KYLE RUSSELL
//  AUT UNIVERSITY 2016
//  https://github.com/denkers/collector-app
//=========================================

package com.kyleruss.collector.web.util;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletResponse;

public class ServletUtils 
{
    public static void jsonResponse(HttpServletResponse response, ActionResponse responseData) throws ServletException, IOException
    {
        String jsonResponse =   responseData.toJSON();
        response.setContentType("application/json");        
        response.getWriter().write(jsonResponse);
    }
}
