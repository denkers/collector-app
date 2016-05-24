//=========================================
//  KYLE RUSSELL
//  AUT UNIVERSITY 2016
//  https://github.com/denkers/collector-app
//=========================================

package com.kyleruss.collector.web.util;

import com.google.gson.Gson;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletResponse;

public class ServletUtils 
{
    public static void jsonResponse(HttpServletResponse response, Object responseData) throws ServletException, IOException
    {
        Gson gson           =   new Gson();
        String jsonResponse =   gson.toJson(responseData);
        response.setContentType("application/json");        
        response.getWriter().write(jsonResponse);
    }
}
