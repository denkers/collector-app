package com.kyleruss.collector.mobile.record;

public class Card
{
    private int id;
    private String name;
    private String picture;
    private CardType cardType;

    public int getId()
    {
        return id;
    }

    public void setId(int id)
    {
        this.id = id;
    }

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public String getPicture()
    {
        return picture;
    }

    public void setPicture(String picture)
    {
        this.picture = picture;
    }

    public CardType getCardType()
    {
        return cardType;
    }

    public void setCardType(CardType cardType)
    {
        this.cardType = cardType;
    }
}
