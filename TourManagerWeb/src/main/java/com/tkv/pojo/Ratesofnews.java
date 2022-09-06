/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.tkv.pojo;

import com.fasterxml.jackson.annotation.JsonIgnore;
import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Admin
 */
@Entity
@Table(name = "ratesofnews")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Ratesofnews.findAll", query = "SELECT r FROM Ratesofnews r"),
    @NamedQuery(name = "Ratesofnews.findByRatesofnewsid", query = "SELECT r FROM Ratesofnews r WHERE r.ratesofnewsid = :ratesofnewsid"),
    @NamedQuery(name = "Ratesofnews.findByRating", query = "SELECT r FROM Ratesofnews r WHERE r.rating = :rating"),
    @NamedQuery(name = "Ratesofnews.findByComment", query = "SELECT r FROM Ratesofnews r WHERE r.comment = :comment"),
    @NamedQuery(name = "Ratesofnews.findByRatingdate", query = "SELECT r FROM Ratesofnews r WHERE r.ratingdate = :ratingdate")})
public class Ratesofnews implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ratesofnewsid")
    private Integer ratesofnewsid;
    @Size(max = 45)
    @Column(name = "rating")
    @JsonIgnore
    private String rating;
    @Size(max = 45)
    @Column(name = "comment")
    private String comment;
    @Column(name = "ratingdate")
    @Temporal(TemporalType.TIMESTAMP)
    private Date ratingdate;
    @JoinColumn(name = "newsid", referencedColumnName = "newsid")
    @ManyToOne
    @JsonIgnore
    private News news;
    @JoinColumn(name = "userid", referencedColumnName = "userid")
    @ManyToOne
    private Users users;

    public Ratesofnews() {
    }

    public Ratesofnews(Integer ratesofnewsid) {
        this.ratesofnewsid = ratesofnewsid;
    }

    public Integer getRatesofnewsid() {
        return ratesofnewsid;
    }

    public void setRatesofnewsid(Integer ratesofnewsid) {
        this.ratesofnewsid = ratesofnewsid;
    }

    public String getRating() {
        return rating;
    }

    public void setRating(String rating) {
        this.rating = rating;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public Date getRatingdate() {
        return ratingdate;
    }

    public void setRatingdate(Date ratingdate) {
        this.ratingdate = ratingdate;
    }

    public News getNews() {
        return news;
    }

    public void setNews(News news) {
        this.news = news;
    }

    public Users getUsers() {
        return users;
    }

    public void setUsers(Users users) {
        this.users = users;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (ratesofnewsid != null ? ratesofnewsid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Ratesofnews)) {
            return false;
        }
        Ratesofnews other = (Ratesofnews) object;
        if ((this.ratesofnewsid == null && other.ratesofnewsid != null) || (this.ratesofnewsid != null && !this.ratesofnewsid.equals(other.ratesofnewsid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.tkv.pojo.Ratesofnews[ ratesofnewsid=" + ratesofnewsid + " ]";
    }
    
}
