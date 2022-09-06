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
@Table(name = "rates")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Rates.findAll", query = "SELECT r FROM Rates r"),
    @NamedQuery(name = "Rates.findByRateid", query = "SELECT r FROM Rates r WHERE r.rateid = :rateid"),
    @NamedQuery(name = "Rates.findByRate", query = "SELECT r FROM Rates r WHERE r.rate = :rate"),
    @NamedQuery(name = "Rates.findByComment", query = "SELECT r FROM Rates r WHERE r.comment = :comment"),
    @NamedQuery(name = "Rates.findByRatingdate", query = "SELECT r FROM Rates r WHERE r.ratingdate = :ratingdate")})
public class Rates implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "rateid")
    private Integer rateid;
    @Column(name = "rate")
    private Integer rate;
    @Size(max = 45)
    @Column(name = "comment")
    private String comment;
    @Column(name = "ratingdate")
    @Temporal(TemporalType.TIMESTAMP)
    private Date ratingdate;
    @JoinColumn(name = "tourid", referencedColumnName = "tourid")
    @ManyToOne
    @JsonIgnore
    private Tour tour;
    @JoinColumn(name = "userid", referencedColumnName = "userid")
    @ManyToOne
    @JsonIgnore
    private Users users;

    public Rates() {
    }

    public Rates(Integer rateid) {
        this.rateid = rateid;
    }

    public Integer getRateid() {
        return rateid;
    }

    public void setRateid(Integer rateid) {
        this.rateid = rateid;
    }

    public Integer getRate() {
        return rate;
    }

    public void setRate(Integer rate) {
        this.rate = rate;
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

    public Tour getTour() {
        return tour;
    }

    public void setTour(Tour tour) {
        this.tour = tour;
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
        hash += (rateid != null ? rateid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Rates)) {
            return false;
        }
        Rates other = (Rates) object;
        if ((this.rateid == null && other.rateid != null) || (this.rateid != null && !this.rateid.equals(other.rateid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.tkv.pojo.Rates[ rateid=" + rateid + " ]";
    }
    
}
