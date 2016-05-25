package com.kyleruss.collector.mobile.comms;


import java.util.HashMap;
import java.util.Map;

public class ServiceRequest
{
    private String url;
    private Map params;

    public ServiceRequest()
    {
        url     =   "";
        params  =   new HashMap();
    }

    public ServiceRequest(String url, Map params)
    {
        this.url    =   url;
        this.params =   params;
    }

    public String getUrl()
    {
        return url;
    }

    public Map getParams()
    {
        return params;
    }

    public void addParam(String name, Object value)
    {
        params.put(name, value);
    }
}
