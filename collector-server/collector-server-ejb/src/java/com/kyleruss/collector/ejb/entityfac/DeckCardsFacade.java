/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.kyleruss.collector.ejb.entityfac;

import com.kyleruss.collector.ejb.entity.Cards;
import com.kyleruss.collector.ejb.entity.DeckCards;
import com.kyleruss.collector.ejb.entity.Decks;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.PersistenceContext;

/**
 *
 * @author denker
 */
@Stateless
public class DeckCardsFacade extends AbstractFacade<DeckCards> {

    @PersistenceContext(unitName = "collector-server-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager()
    {
        return em;
    }

    public DeckCardsFacade() 
    {
        super(DeckCards.class);
    }
    
    public boolean addCardsToDeck(Decks deck, List<Cards> cards)
    {
        boolean status  =   true;
        EntityTransaction transaction   =   em.getTransaction();
        
        for(Cards card : cards)
        {
            DeckCards deckCard  =   new DeckCards();
            deckCard.setDecks(deck);
            deckCard.setCards(card);
            create(deckCard);

            if(!em.contains(deckCard))
            {
                status  =   false;
                break;
            }
        }
        
        if(status)
            transaction.commit();
        else
            transaction.rollback();
        
        return status;
    }
}
