/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.kyleruss.collector.ejb.entityfac;

import com.kyleruss.collector.ejb.entity.DeckCards;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
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
    protected EntityManager getEntityManager() {
        return em;
    }

    public DeckCardsFacade() {
        super(DeckCards.class);
    }
    
}
