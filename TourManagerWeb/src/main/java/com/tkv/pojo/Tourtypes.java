/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.tkv.pojo;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Admin
 */
@Entity
@Table(name = "tourtypes")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Tourtypes.findAll", query = "SELECT t FROM Tourtypes t"),
    @NamedQuery(name = "Tourtypes.findByTypeid", query = "SELECT t FROM Tourtypes t WHERE t.typeid = :typeid"),
    @NamedQuery(name = "Tourtypes.findByTypename", query = "SELECT t FROM Tourtypes t WHERE t.typename = :typename"),
    @NamedQuery(name = "Tourtypes.findByDescription", query = "SELECT t FROM Tourtypes t WHERE t.description = :description")})
public class Tourtypes implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "typeid")
    private Integer typeid;
    @Size(max = 45)
    @Column(name = "typename")
    private String typename;
    @Size(max = 45)
    @Column(name = "description")
    private String description;
    @OneToMany(mappedBy = "tourtypes")
    private List<Tour> tourList;

    public Tourtypes() {
    }

    public Tourtypes(Integer typeid) {
        this.typeid = typeid;
    }

    public Integer getTypeid() {
        return typeid;
    }

    public void setTypeid(Integer typeid) {
        this.typeid = typeid;
    }

    public String getTypename() {
        return typename;
    }

    public void setTypename(String typename) {
        this.typename = typename;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @XmlTransient
    public List<Tour> getTourList() {
        return tourList;
    }

    public void setTourList(List<Tour> tourList) {
        this.tourList = tourList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (typeid != null ? typeid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Tourtypes)) {
            return false;
        }
        Tourtypes other = (Tourtypes) object;
        if ((this.typeid == null && other.typeid != null) || (this.typeid != null && !this.typeid.equals(other.typeid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.tkv.pojo.Tourtypes[ typeid=" + typeid + " ]";
    }
    
}
