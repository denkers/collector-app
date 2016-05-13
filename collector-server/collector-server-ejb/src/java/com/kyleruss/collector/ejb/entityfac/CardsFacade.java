//=========================================
//  KYLE RUSSELL
//  AUT UNIVERSITY 2016
//  https://github.com/denkers/collector-app
//=========================================

package com.kyleruss.collector.ejb.entityfac;

import com.kyleruss.collector.ejb.entity.Cards;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Stateless
@LocalBean
public class CardsFacade extends AbstractFacade<Cards> 
{
    @PersistenceContext(unitName = "collector-server-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() 
    {
        return em;
    }

    public CardsFacade() 
    {
        super(Cards.class);
    }
}
