//=========================================
//  KYLE RUSSELL
//  AUT UNIVERSITY 2016
//  https://github.com/denkers/collector-app
//=========================================

package com.kyleruss.collector.ejb.entity;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Size;

@Entity
@Table(name = "decks")
public class Decks implements Serializable
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    
    @Size(max = 30)
    @Column(name = "name")
    private String name;
    
    @Size(max = 80)
    @Column(name = "description")
    private String description;
    
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "decks", fetch = FetchType.LAZY)
    private List<DeckCards> deckCardsList;
    
    @JoinColumn(name = "owner", referencedColumnName = "username")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Users users;

    public Decks() {}

    public Decks(Integer id)
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

    public String getName() 
    {
        return name;
    }

    public void setName(String name) 
    {
        this.name = name;
    }

    public String getDescription() 
    {
        return description;
    }

    public void setDescription(String description) 
    {
        this.description = description;
    }

    public List<DeckCards> getDeckCardsList()
    {
        return deckCardsList;
    }

    public void setDeckCardsList(List<DeckCards> deckCardsList)
    {
        this.deckCardsList = deckCardsList;
    }

    public Users getUsers()
    {
        return users;
    }

    public void setUsers(Users users) 
    {
        this.users = users;
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
        if (!(object instanceof Decks)) 
            return false;
        
        Decks other = (Decks) object;
        return this.id.equals(other.id);
    }

    @Override
    public String toString() 
    {
        return "com.kyleruss.collector.ejb.entity.Decks[ id=" + id + " ]";
    }
    
}
