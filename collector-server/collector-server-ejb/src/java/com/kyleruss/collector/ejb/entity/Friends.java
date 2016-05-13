//=========================================
//  KYLE RUSSELL
//  AUT UNIVERSITY 2016
//  https://github.com/denkers/collector-app
//=========================================

package com.kyleruss.collector.ejb.entity;

import java.io.Serializable;
import java.util.Date;
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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "friends")
public class Friends implements Serializable
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    
    @Column(name = "confirmed")
    private Boolean confirmed;
    
    @Column(name = "friendship_date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date friendshipDate;
    
    @JoinColumn(name = "friend_a", referencedColumnName = "username")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Users users;
    
    @JoinColumn(name = "friend_b", referencedColumnName = "username")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Users users1;

    public Friends() {}

    public Friends(Integer id) 
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

    public Boolean getConfirmed()
    {
        return confirmed;
    }

    public void setConfirmed(Boolean confirmed) 
    {
        this.confirmed = confirmed;
    }

    public Date getFriendshipDate() 
    {
        return friendshipDate;
    }

    public void setFriendshipDate(Date friendshipDate)
    {
        this.friendshipDate = friendshipDate;
    }

    public Users getUsers() 
    {
        return users;
    }

    public void setUsers(Users users) 
    {
        this.users = users;
    }

    public Users getUsers1() 
    {
        return users1;
    }

    public void setUsers1(Users users1) 
    {
        this.users1 = users1;
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
        if (!(object instanceof Friends)) 
            return false;
        
        Friends other = (Friends) object;
        return this.id.equals(other.id);
    }

    @Override
    public String toString() 
    {
        return "com.kyleruss.collector.ejb.entity.Friends[ id=" + id + " ]";
    }
    
}
