//=========================================
//  KYLE RUSSELL
//  AUT UNIVERSITY 2016
//  https://github.com/denkers/collector-app
//=========================================

package com.kyleruss.collector.web.user;

import java.io.IOException;
import java.util.AbstractMap;
import java.util.Map;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "UserServicesServlet", urlPatterns = {"/user/login", "/user/register"})
public class UserServicesServlet extends HttpServlet
{
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
    {
        
    }
    
    private void postLogin(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        String username     =   request.getParameter("login_username");
        String password     =   request.getParameter("login_password");
        
        Map.Entry<Users, String> attempt    =   usersBean.loginUser(username, password);
        request.getSession().setAttribute("activeUser", attempt.getKey());
        activeUserBean.setActiveUser(attempt.getKey());
        
        Map.Entry<Boolean, String> result   =   new AbstractMap.SimpleEntry(attempt.getKey() != null, attempt.getValue());   
        //send result
    }
    
    private void postRegister(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        String username     =   request.getParameter("register_username");
        String password     =   request.getParameter("register_password");
        String rePassword   =   request.getParameter("register_re_password");
        String email        =   request.getParameter("register_email");
        
        Map.Entry<Boolean, String> result   =   usersBean.createUserAccount(username, password, rePassword, email);
        //send result
    }
    
    private void getLogout(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        if(activeUserBean.isActive())
        {
            activeUserBean.setActiveUser(null);
            request.getSession().removeAttribute("activeUser");
            //send result
        }

        //send failed result
    }
}
