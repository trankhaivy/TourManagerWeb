/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.tkv.pojo;

import java.io.Serializable;
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
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Admin
 */
@Entity
@Table(name = "tourimage")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Tourimage.findAll", query = "SELECT t FROM Tourimage t"),
    @NamedQuery(name = "Tourimage.findByTourimageid", query = "SELECT t FROM Tourimage t WHERE t.tourimageid = :tourimageid"),
    @NamedQuery(name = "Tourimage.findByImage", query = "SELECT t FROM Tourimage t WHERE t.image = :image")})
public class Tourimage implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "tourimageid")
    private Integer tourimageid;
    @Size(max = 100)
    @Column(name = "image")
    private String image;
    @JoinColumn(name = "tourid", referencedColumnName = "tourid")
    @ManyToOne
    private Tour tour;

    public Tourimage() {
    }

    public Tourimage(Integer tourimageid) {
        this.tourimageid = tourimageid;
    }

    public Integer getTourimageid() {
        return tourimageid;
    }

    public void setTourimageid(Integer tourimageid) {
        this.tourimageid = tourimageid;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public Tour getTour() {
        return tour;
    }

    public void setTour(Tour tour) {
        this.tour = tour;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (tourimageid != null ? tourimageid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Tourimage)) {
            return false;
        }
        Tourimage other = (Tourimage) object;
        if ((this.tourimageid == null && other.tourimageid != null) || (this.tourimageid != null && !this.tourimageid.equals(other.tourimageid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.tkv.pojo.Tourimage[ tourimageid=" + tourimageid + " ]";
    }
    
}
