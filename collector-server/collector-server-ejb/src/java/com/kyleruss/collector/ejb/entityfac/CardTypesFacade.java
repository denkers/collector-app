//=========================================
//  KYLE RUSSELL
//  AUT UNIVERSITY 2016
//  https://github.com/denkers/jforum
//=========================================

package com.kyleruss.collector.ejb.entityfac;

import com.kyleruss.collector.ejb.entity.CardTypes;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Stateless
@LocalBean
public class CardTypesFacade extends AbstractFacade<CardTypes>
{
    @PersistenceContext(unitName = "collector-server-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() 
    {
        return em;
    }

    public CardTypesFacade() 
    {
        super(CardTypes.class);
    }
}
