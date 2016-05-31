package com.kyleruss.collector.mobile.user;

import com.kyleruss.collector.mobile.record.User;

public class ActiveUser
{
    private User user;
    private static ActiveUser instance;

    private ActiveUser() {}

    public User getUser()
    {
        return user;
    }

    public void setUser(User user)
    {
        this.user   =   user;
    }

    public boolean userIsActive()
    {
        return user != null;
    }

    public void resetUser()
    {
        user    =   null;
    }

    public static ActiveUser getInstance()
    {
        if(instance == null) instance = new ActiveUser();
        return instance;
    }
}
