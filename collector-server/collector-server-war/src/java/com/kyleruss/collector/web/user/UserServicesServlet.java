//=========================================
//  KYLE RUSSELL
//  AUT UNIVERSITY 2016
//  https://github.com/denkers/collector-app
//=========================================

package com.kyleruss.collector.web.user;

import com.kyleruss.collector.ejb.entity.Users;
import com.kyleruss.collector.ejb.entityfac.ActiveUserBean;
import com.kyleruss.collector.ejb.entityfac.UsersFacade;
import com.kyleruss.collector.web.util.ActionResponse;
import com.kyleruss.collector.web.util.ServletUtils;
import java.io.IOException;
import java.util.Map;
import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "UserServicesServlet", urlPatterns = {"/user/login", "/user/register", "/user/logout"})
public class UserServicesServlet extends HttpServlet
{
    @EJB
    private UsersFacade usersBean;
    
    @EJB
    private ActiveUserBean activeUserBean;
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
    {
        String path =   request.getServletPath();
        
        if(path.equals("/user/login"))
            postLogin(request, response);
        
        else if(path.equals("/user/register"))
            postRegister(request, response);
    }
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        getLogout(request, response);
    }
    
    private void postLogin(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        String username     =   request.getParameter("login_username");
        String password     =   request.getParameter("login_password");
        
        Map.Entry<Users, String> attempt    =   usersBean.loginUser(username, password);
        request.getSession().setAttribute("activeUser", attempt.getKey());
        activeUserBean.setActiveUser(attempt.getKey());
        
        ActionResponse result   =   new ActionResponse(attempt.getValue(), attempt.getKey() != null);
        ServletUtils.jsonResponse(response, result);
    }
    
    private void postRegister(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        String username     =   request.getParameter("register_username");
        String password     =   request.getParameter("register_password");
        String rePassword   =   request.getParameter("register_re_password");
        String email        =   request.getParameter("register_email");
        
        Map.Entry<Boolean, String> result   =   usersBean.createUserAccount(username, password, rePassword, email);
        ServletUtils.jsonResponse(response, new ActionResponse(result.getValue(), result.getKey()));
    }
    
    private void getLogout(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        if(activeUserBean.isActive())
        {
            activeUserBean.setActiveUser(null);
            request.getSession().removeAttribute("activeUser");
            ServletUtils.jsonResponse(response, new ActionResponse("Successfully logged out", true));
        }

        else
            ServletUtils.jsonResponse(response, new ActionResponse("You are not logged in", false));
    }
}
