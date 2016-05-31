package com.kyleruss.collector.mobile.record;

import org.json.JSONException;
import org.json.JSONObject;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class User implements RecordTranslator<User>
{
    private String username;
    private String password;
    private String picture;
    private String email;
    private String country;
    private Date registerDate;

    public User() {}

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
        try
        {
            User user       =   new User();
            user.setUsername(obj.getString("username"));
            user.setPassword(obj.getString("password"));
            user.setEmail(obj.getString("email"));
            user.setPicture(obj.getString("picture"));

            if(obj.has("country"))
                user.setCountry(obj.getString("country"));

            DateFormat formatter    =   new SimpleDateFormat("MMMM d, yyyy h:m:s a");

            try
            {
                user.setRegisterDate((formatter.parse(obj.getString("registerDate"))));
            }

            catch(ParseException e)
            {
                e.printStackTrace();
            }

            return user;
        }

        catch(JSONException e)
        {
            System.out.println(e.getMessage());
            return null;
        }
    }

    @Override
    public JSONObject serializeRecord()
    {
        return null;
    }
}
