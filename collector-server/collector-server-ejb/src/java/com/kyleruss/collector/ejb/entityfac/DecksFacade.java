//=========================================
//  KYLE RUSSELL
//  AUT UNIVERSITY 2016
//  https://github.com/denkers/collector-app
//=========================================

package com.kyleruss.collector.ejb.entityfac;

import com.kyleruss.collector.ejb.entity.Decks;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Stateless
@LocalBean
public class DecksFacade extends AbstractFacade<Decks> 
{

    @PersistenceContext(unitName = "collector-server-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() 
    {
        return em;
    }

    public DecksFacade() 
    {
        super(Decks.class);
    }
    
}
