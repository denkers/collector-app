package com.kyleruss.collector.mobile.comms;

public class ServiceResponse
{
    private boolean status;
    private String message;

    public ServiceResponse()
    {
        this("", false);
    }

    public ServiceResponse(String message, boolean status)
    {
        this.message    =   message;
        this.status     =   status;
    }

    public String getMessage()
    {
        return message;
    }

    public boolean getStatus()
    {
        return status;
    }

    public void setMessage(String message)
    {
        this.message    =   message;
    }

    public void setStatus(boolean status)
    {
        this.status =   status;
    }
}
