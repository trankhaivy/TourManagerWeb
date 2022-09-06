/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.tkv.pojo;

import com.fasterxml.jackson.annotation.JsonIgnore;
import java.io.Serializable;
import java.util.Date;
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
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.multipart.MultipartFile;

/**
 *
 * @author Admin
 */
@Entity
@Table(name = "tour")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Tour.findAll", query = "SELECT t FROM Tour t"),
    @NamedQuery(name = "Tour.findByTourid", query = "SELECT t FROM Tour t WHERE t.tourid = :tourid"),
    @NamedQuery(name = "Tour.findByTourname", query = "SELECT t FROM Tour t WHERE t.tourname = :tourname"),
    @NamedQuery(name = "Tour.findByPriceforadult", query = "SELECT t FROM Tour t WHERE t.priceforadult = :priceforadult"),
    @NamedQuery(name = "Tour.findByPriceforchild", query = "SELECT t FROM Tour t WHERE t.priceforchild = :priceforchild"),
    @NamedQuery(name = "Tour.findByImage", query = "SELECT t FROM Tour t WHERE t.image = :image"),
    @NamedQuery(name = "Tour.findByTime", query = "SELECT t FROM Tour t WHERE t.time = :time"),
    @NamedQuery(name = "Tour.findByMaxquantity", query = "SELECT t FROM Tour t WHERE t.maxquantity = :maxquantity"),
    @NamedQuery(name = "Tour.findByIsActive", query = "SELECT t FROM Tour t WHERE t.isActive = :isActive"),
    @NamedQuery(name = "Tour.findByNumberoflikes", query = "SELECT t FROM Tour t WHERE t.numberoflikes = :numberoflikes")})
public class Tour implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "tourid")
    private Integer tourid;
    @Size(max = 150)
    @Column(name = "tourname")
    private String tourname;
    @Column(name = "priceforadult")
    private Long priceforadult;
    @Column(name = "priceforchild")
    private Long priceforchild;
    @Size(max = 100)
    @Column(name = "image")
    private String image;
    @Column(name = "time")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @Temporal(TemporalType.DATE)
    private Date time;
    @Column(name = "maxquantity")
    private Integer maxquantity;
    @Column(name = "is_active")
    private Boolean isActive;
    @Column(name = "numberoflikes")
    private Integer numberoflikes;
    @Lob
    @Size(max = 2147483647)
    @Column(name = "description")
    private String description;
    @OneToMany(mappedBy = "tour")
    private List<Booking> bookingList;
    @OneToMany(mappedBy = "tour")
    private List<Tourimage> tourimageList;
    @OneToMany(cascade = CascadeType.ALL,mappedBy = "tour",fetch = FetchType.EAGER)
    private List<Rates> ratesList;
    @JoinColumn(name = "typeid", referencedColumnName = "typeid")
    @ManyToOne
    private Tourtypes tourtypes;
    
    @Transient
    private MultipartFile file;

    public Tour() {
    }

    public Tour(Integer tourid) {
        this.tourid = tourid;
    }

    public Integer getTourid() {
        return tourid;
    }

    public void setTourid(Integer tourid) {
        this.tourid = tourid;
    }

    public String getTourname() {
        return tourname;
    }

    public void setTourname(String tourname) {
        this.tourname = tourname;
    }

    public Long getPriceforadult() {
        return priceforadult;
    }

    public void setPriceforadult(Long priceforadult) {
        this.priceforadult = priceforadult;
    }

    public Long getPriceforchild() {
        return priceforchild;
    }

    public void setPriceforchild(Long priceforchild) {
        this.priceforchild = priceforchild;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }

    public Integer getMaxquantity() {
        return maxquantity;
    }

    public void setMaxquantity(Integer maxquantity) {
        this.maxquantity = maxquantity;
    }

    public Boolean getIsActive() {
        return isActive;
    }

    public void setIsActive(Boolean isActive) {
        this.isActive = isActive;
    }

    public Integer getNumberoflikes() {
        return numberoflikes;
    }

    public void setNumberoflikes(Integer numberoflikes) {
        this.numberoflikes = numberoflikes;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @XmlTransient
    public List<Booking> getBookingList() {
        return bookingList;
    }

    public void setBookingList(List<Booking> bookingList) {
        this.bookingList = bookingList;
    }

    @XmlTransient
    public List<Tourimage> getTourimageList() {
        return tourimageList;
    }

    public void setTourimageList(List<Tourimage> tourimageList) {
        this.tourimageList = tourimageList;
    }

    @XmlTransient
    public List<Rates> getRatesList() {
        return ratesList;
    }

    public void setRatesList(List<Rates> ratesList) {
        this.ratesList = ratesList;
    }

    public Tourtypes getTourtypes() {
        return tourtypes;
    }

    public void setTourtypes(Tourtypes tourtypes) {
        this.tourtypes = tourtypes;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (tourid != null ? tourid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Tour)) {
            return false;
        }
        Tour other = (Tour) object;
        if ((this.tourid == null && other.tourid != null) || (this.tourid != null && !this.tourid.equals(other.tourid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.tkv.pojo.Tour[ tourid=" + tourid + " ]";
    }

    /**
     * @return the file
     */
    public MultipartFile getFile() {
        return file;
    }

    /**
     * @param file the file to set
     */
    public void setFile(MultipartFile file) {
        this.file = file;
    }
    
}
