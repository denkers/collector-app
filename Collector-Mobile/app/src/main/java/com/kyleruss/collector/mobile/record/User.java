package com.kyleruss.collector.mobile.record;

import org.json.JSONObject;

import java.util.Date;

public class User implements RecordTranslator<User>
{
    private String username;
    private String password;
    private String picture;
    private String email;
    private String country;
    private Date registerDate;

    public Date getRegisterDate()
    {
        return registerDate;
    }

    public void setRegisterDate(Date registerDate)
    {
        this.registerDate = registerDate;
    }

    public String getCountry()
    {
        return country;
    }

    public void setCountry(String country)
    {
        this.country = country;
    }

    public String getEmail()
    {
        return email;
    }

    public void setEmail(String email)
    {
        this.email = email;
    }

    public String getPicture()
    {
        return picture;
    }

    public void setPicture(String picture)
    {
        this.picture = picture;
    }

    public String getPassword()
    {
        return password;
    }

    public void setPassword(String password)
    {
        this.password = password;
    }

    public String getUsername()
    {
        return username;
    }

    public void setUsername(String username)
    {
        this.username = username;
    }

    @Override
    public User mapToRecord(JSONObject obj)
    {
        return null;
    }

    @Override
    public JSONObject serializeRecord()
    {
        return null;
    }
}
