//=========================================
//  KYLE RUSSELL
//  AUT UNIVERSITY 2016
//  https://github.com/denkers/collector-app
//=========================================

package com.kyleruss.collector.ejb.entity;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "deck_cards")
public class DeckCards implements Serializable
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    
    @Column(name = "deck_pos")
    private Integer deckPos;
    
    @JoinColumn(name = "card_id", referencedColumnName = "id")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Cards cards;
    
    @JoinColumn(name = "deck_id", referencedColumnName = "id")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Decks decks;

    public DeckCards() {}

    public DeckCards(Integer id) 
    {
        this.id = id;
    }

    public Integer getId()
    {
        return id;
    }

    public void setId(Integer id) 
    {
        this.id = id;
    }

    public Integer getDeckPos() 
    {
        return deckPos;
    }

    public void setDeckPos(Integer deckPos)
    {
        this.deckPos = deckPos;
    }

    public Cards getCards() 
    {
        return cards;
    }

    public void setCards(Cards cards) 
    {
        this.cards = cards;
    }

    public Decks getDecks() 
    {
        return decks;
    }

    public void setDecks(Decks decks) 
    {
        this.decks = decks;
    }

    @Override
    public int hashCode() 
    {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) 
    {
        if (!(object instanceof DeckCards)) 
            return false;
        
        DeckCards other = (DeckCards) object;
        return this.id.equals(other.id);
    }

    @Override
    public String toString()
    {
        return "com.kyleruss.collector.ejb.entity.DeckCards[ id=" + id + " ]";
    }
    
}
