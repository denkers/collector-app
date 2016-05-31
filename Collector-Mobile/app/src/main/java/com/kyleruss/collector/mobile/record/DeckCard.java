package com.kyleruss.collector.mobile.record;

import org.json.JSONObject;

public class DeckCard implements RecordTranslator<DeckCard>
{
    private int id;
    private Card card;
    private Deck deck;
    private int position;

    public Card getCard()
    {
        return card;
    }

    public void setCard(Card card)
    {
        this.card = card;
    }

    public int getId()
    {
        return id;
    }

    public void setId(int id)
    {
        this.id = id;
    }

    public Deck getDeck()
    {
        return deck;
    }

    public void setDeck(Deck deck)
    {
        this.deck = deck;
    }

    public int getPosition()
    {
        return position;
    }

    public void setPosition(int position)
    {
        this.position = position;
    }

    @Override
    public DeckCard mapToRecord(JSONObject obj)
    {
        return null;
    }

    @Override
    public JSONObject serializeRecord()
    {
        return null;
    }
}
