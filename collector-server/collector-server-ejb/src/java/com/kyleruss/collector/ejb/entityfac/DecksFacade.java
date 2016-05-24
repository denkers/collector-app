//=========================================
//  KYLE RUSSELL
//  AUT UNIVERSITY 2016
//  https://github.com/denkers/collector-app
//=========================================

package com.kyleruss.collector.ejb.entityfac;

import com.kyleruss.collector.ejb.entity.Decks;
import com.kyleruss.collector.ejb.entity.Users;
import java.util.List;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

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
    
    public List<Decks> getDecksForUser(Users user)
    {
        CriteriaBuilder builder     =   em.getCriteriaBuilder();
        CriteriaQuery<Decks> query  =   builder.createQuery(entityClass);
        Root<Decks> from            =   query.from(entityClass);
        query.select(from);
        
        query.where(builder.equal(from.get("users"), user));
        try { return em.createQuery(query).getResultList(); }
        catch(NoResultException e)
        {
            return null;
        }
    }
    
    public boolean addDeck(String name, String description, Users user)
    {
        Decks deck  =   new Decks();
        deck.setName(name);
        deck.setDescription(description);
        deck.setUsers(user);
        
        create(deck);
        return em.contains(deck);
    }
}
