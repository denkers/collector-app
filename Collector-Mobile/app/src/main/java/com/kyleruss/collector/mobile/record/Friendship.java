package com.kyleruss.collector.mobile.record;

import org.json.JSONObject;

import java.util.Date;

public class Friendship implements RecordTranslator<Friendship>
{
    private int id;
    private User friendA;
    private User friendB;
    private Date friendshipDate;

    public int getId()
    {
        return id;
    }

    public void setId(int id)
    {
        this.id = id;
    }

    public User getFriendA()
    {
        return friendA;
    }

    public void setFriendA(User friendA)
    {
        this.friendA = friendA;
    }

    public Date getFriendshipDate()
    {
        return friendshipDate;
    }

    public void setFriendshipDate(Date friendshipDate)
    {
        this.friendshipDate = friendshipDate;
    }

    public User getFriendB()
    {
        return friendB;
    }

    public void setFriendB(User friendB)
    {
        this.friendB = friendB;
    }

    @Override
    public Friendship mapToRecord(JSONObject obj)
    {
        return null;
    }

    @Override
    public JSONObject serializeRecord()
    {
        return null;
    }
}
