/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.tkv.pojo;

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
import javax.persistence.Lob;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;
import org.springframework.web.multipart.MultipartFile;

/**
 *
 * @author Admin
 */
@Entity
@Table(name = "news")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "News.findAll", query = "SELECT n FROM News n"),
    @NamedQuery(name = "News.findByNewsid", query = "SELECT n FROM News n WHERE n.newsid = :newsid"),
    @NamedQuery(name = "News.findByNewsname", query = "SELECT n FROM News n WHERE n.newsname = :newsname"),
    @NamedQuery(name = "News.findByImage", query = "SELECT n FROM News n WHERE n.image = :image")})
public class News implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "newsid")
    private Integer newsid;
    @Size(max = 45)
    @Column(name = "newsname")
    private String newsname;
    @Lob
    @Size(max = 2147483647)
    @Column(name = "content")
    private String content;
    @Size(max = 100)
    @Column(name = "image")
    private String image;
    @OneToMany(cascade = CascadeType.ALL,mappedBy = "news",fetch = FetchType.EAGER)
    private List<Ratesofnews> ratesofnewsList;

    @Transient
    private MultipartFile NewsImage;
    public News() {
    }

    public News(Integer newsid) {
        this.newsid = newsid;
    }

    public Integer getNewsid() {
        return newsid;
    }

    public void setNewsid(Integer newsid) {
        this.newsid = newsid;
    }

    public String getNewsname() {
        return newsname;
    }

    public void setNewsname(String newsname) {
        this.newsname = newsname;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    @XmlTransient
    public List<Ratesofnews> getRatesofnewsList() {
        return ratesofnewsList;
    }

    public void setRatesofnewsList(List<Ratesofnews> ratesofnewsList) {
        this.ratesofnewsList = ratesofnewsList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (newsid != null ? newsid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof News)) {
            return false;
        }
        News other = (News) object;
        if ((this.newsid == null && other.newsid != null) || (this.newsid != null && !this.newsid.equals(other.newsid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.tkv.pojo.News[ newsid=" + newsid + " ]";
    }

    /**
     * @return the NewsImage
     */
    public MultipartFile getNewsImage() {
        return NewsImage;
    }

    /**
     * @param NewsImage the NewsImage to set
     */
    public void setNewsImage(MultipartFile NewsImage) {
        this.NewsImage = NewsImage;
    }
    
}
