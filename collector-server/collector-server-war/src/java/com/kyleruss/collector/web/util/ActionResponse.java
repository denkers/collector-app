//=========================================
//  KYLE RUSSELL
//  AUT UNIVERSITY 2016
//  https://github.com/denkers/collector-app
//=========================================

package com.kyleruss.collector.web.util;

public class ActionResponse 
{
    private String message;
    private boolean actionStatus;
    private Object data;
    
    public ActionResponse()
    {
        message         =   "";
        actionStatus    =   false;
        data            =   null;
    }
    
    public ActionResponse(String message, boolean actionStatus)
    {
        this(message, actionStatus, null);
    }
    
    public ActionResponse(String message, boolean actionStatus, Object data)
    {
        this.message        =   message;
        this.actionStatus   =   actionStatus;
        this.data           =   data;
    }

    public String getMessage() 
    {
        return message;
    }

    public void setMessage(String message)
    {
        this.message = message;
    }

    public boolean isActionStatus()
    {
        return actionStatus;
    }

    public void setActionStatus(boolean actionStatus)
    {
        this.actionStatus = actionStatus;
    }

    public Object getData() 
    {
        return data;
    }

    public void setData(Object data)
    {
        this.data = data;
    }
}
