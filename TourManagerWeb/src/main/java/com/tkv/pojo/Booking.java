/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.tkv.pojo;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
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
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;
import org.springframework.format.annotation.DateTimeFormat;

/**
 *
 * @author Admin
 */
@Entity
@Table(name = "booking")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Booking.findAll", query = "SELECT b FROM Booking b"),
    @NamedQuery(name = "Booking.findByBookingid", query = "SELECT b FROM Booking b WHERE b.bookingid = :bookingid"),
    @NamedQuery(name = "Booking.findByNumberofadult", query = "SELECT b FROM Booking b WHERE b.numberofadult = :numberofadult"),
    @NamedQuery(name = "Booking.findByNumberofchild", query = "SELECT b FROM Booking b WHERE b.numberofchild = :numberofchild"),
    @NamedQuery(name = "Booking.findByTotalprice", query = "SELECT b FROM Booking b WHERE b.totalprice = :totalprice"),
    @NamedQuery(name = "Booking.findByBookingdate", query = "SELECT b FROM Booking b WHERE b.bookingdate = :bookingdate")})
public class Booking implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "bookingid")
    private Integer bookingid;
    @Column(name = "numberofadult")
    private Integer numberofadult;
    @Column(name = "numberofchild")
    private Integer numberofchild;
    @Column(name = "totalprice")
    private Long totalprice;
    @Column(name = "bookingdate")
    @Temporal(TemporalType.DATE)
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date bookingdate;
    @JoinColumn(name = "tourid", referencedColumnName = "tourid")
    @ManyToOne
    private Tour tour;
    @JoinColumn(name = "userid", referencedColumnName = "userid")
    @ManyToOne
    private Users users;
    @OneToMany(mappedBy = "booking")
    private List<Payment> paymentList;

    public Booking() {
        bookingdate = new Date();
    }

    public Booking(Integer bookingid) {
        this.bookingid = bookingid;
    }

    public Integer getBookingid() {
        return bookingid;
    }

    public void setBookingid(Integer bookingid) {
        this.bookingid = bookingid;
    }

    public Integer getNumberofadult() {
        return numberofadult;
    }

    public void setNumberofadult(Integer numberofadult) {
        this.numberofadult = numberofadult;
    }

    public Integer getNumberofchild() {
        return numberofchild;
    }

    public void setNumberofchild(Integer numberofchild) {
        this.numberofchild = numberofchild;
    }

    public Long getTotalprice() {
        return totalprice;
    }

    public void setTotalprice(Long totalprice) {
        this.totalprice = totalprice;
    }

    public Date getBookingdate() {
        return bookingdate;
    }

    public void setBookingdate(Date bookingdate) {
        this.bookingdate = bookingdate;
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

    @XmlTransient
    public List<Payment> getPaymentList() {
        return paymentList;
    }

    public void setPaymentList(List<Payment> paymentList) {
        this.paymentList = paymentList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (bookingid != null ? bookingid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Booking)) {
            return false;
        }
        Booking other = (Booking) object;
        if ((this.bookingid == null && other.bookingid != null) || (this.bookingid != null && !this.bookingid.equals(other.bookingid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.tkv.pojo.Booking[ bookingid=" + bookingid + " ]";
    }
    
}
