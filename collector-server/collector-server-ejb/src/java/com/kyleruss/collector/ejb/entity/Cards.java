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
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name = "cards")
public class Cards implements Serializable 
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    
    @Size(max = 35)
    @Column(name = "name")
    private String name;
    
    @Size(max = 100)
    @Column(name = "description")
    private String description;
    
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "picture")
    private String picture;
    
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "cards", fetch = FetchType.LAZY)
    private List<DeckCards> deckCardsList;

    public Cards() {}

    public Cards(Integer id) 
    {
        this.id = id;
    }

    public Cards(Integer id, String picture) 
    {
        this.id         =   id;
        this.picture    =   picture;
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

    public String getPicture()
    {
        return picture;
    }

    public void setPicture(String picture) 
    {
        this.picture = picture;
    }

    public List<DeckCards> getDeckCardsList() 
    {
        return deckCardsList;
    }

    public void setDeckCardsList(List<DeckCards> deckCardsList) 
    {
        this.deckCardsList = deckCardsList;
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
        if (!(object instanceof Cards)) 
            return false;
        
        Cards other = (Cards) object;
        return this.id.equals(other.id);
    }

    @Override
    public String toString()
    {
        return "com.kyleruss.collector.ejb.entity.Cards[ id=" + id + " ]";
    }
    
}
