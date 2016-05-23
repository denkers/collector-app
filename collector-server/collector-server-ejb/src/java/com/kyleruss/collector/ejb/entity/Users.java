//=========================================
//  KYLE RUSSELL
//  AUT UNIVERSITY 2016
//  https://github.com/denkers/collector-app
//=========================================

package com.kyleruss.collector.ejb.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name = "users")
public class Users implements Serializable 
{
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 16)
    @Column(name = "username")
    private String username;
    
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "password")
    private String password;
    
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "email")
    private String email;
    
    @Size(max = 255)
    @Column(name = "picture")
    private String picture;
    
    @Column(name = "register_date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date registerDate;
    
    @Size(max = 35)
    @Column(name = "country")
    private String country;
    
    @Column(name = "points")
    private Integer points;
    
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "users", fetch = FetchType.LAZY)
    private List<Decks> decksList;
    
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "userA", fetch = FetchType.LAZY)
    private List<Friends> friendsList;
    
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "userB", fetch = FetchType.LAZY)
    private List<Friends> friendsList1;

    public Users() {}

    public Users(String username)
    {
        this.username   =   username;
    }

    public Users(String username, String password, String email) 
    {
        this.username   =   username;
        this.password   =   password;
        this.email      =   email;
    }

    public String getUsername() 
    {
        return username;
    }

    public void setUsername(String username) 
    {
        this.username = username;
    }

    public String getPassword() 
    {
        return password;
    }

    public void setPassword(String password) 
    {
        this.password = password;
    }

    public String getEmail()
    {
        return email;
    }

    public void setEmail(String email) 
    {
        this.email = email;
    }

    public String getPicture() 
    {
        return picture;
    }

    public void setPicture(String picture) 
    {
        this.picture = picture;
    }

    public Date getRegisterDate()
    {
        return registerDate;
    }

    public void setRegisterDate(Date registerDate) 
    {
        this.registerDate = registerDate;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) 
    {
        this.country = country;
    }

    public Integer getPoints() 
    {
        return points;
    }

    public void setPoints(Integer points)
    {
        this.points = points;
    }

    public List<Decks> getDecksList() 
    {
        return decksList;
    }

    public void setDecksList(List<Decks> decksList) 
    {
        this.decksList = decksList;
    }

    public List<Friends> getFriendsList() 
    {
        return friendsList;
    }

    public void setFriendsList(List<Friends> friendsList) 
    {
        this.friendsList = friendsList;
    }

    public List<Friends> getFriendsList1()
    {
        return friendsList1;
    }

    public void setFriendsList1(List<Friends> friendsList1)
    {
        this.friendsList1 = friendsList1;
    }

    @Override
    public int hashCode()
    {
        int hash = 0;
        hash += (username != null ? username.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) 
    {
        if (!(object instanceof Users)) 
            return false;
        
        Users other = (Users) object;
        return !this.username.equals(other.username);
    }

    @Override
    public String toString()
    {
        return "com.kyleruss.collector.ejb.entity.Users[ username=" + username + " ]";
    }
}
