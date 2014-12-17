/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author user
 */
@Entity
@Table(name = "place", catalog = "guiame_backend", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Place.findAll", query = "SELECT p FROM Place p"),
    @NamedQuery(name = "Place.findByIdplace", query = "SELECT p FROM Place p WHERE p.idplace = :idplace"),
    @NamedQuery(name = "Place.findByPlaceName", query = "SELECT p FROM Place p WHERE p.placeName = :placeName"),
    @NamedQuery(name = "Place.findByPlaceCategory", query = "SELECT p FROM Place p WHERE p.placeCategory = :placeCategory"),
    @NamedQuery(name = "Place.findByPlaceAddr", query = "SELECT p FROM Place p WHERE p.placeAddr = :placeAddr"),
    @NamedQuery(name = "Place.findByPlaceLatlng", query = "SELECT p FROM Place p WHERE p.placeLatlng = :placeLatlng"),
    @NamedQuery(name = "Place.findByPlacePhone", query = "SELECT p FROM Place p WHERE p.placePhone = :placePhone"),
    @NamedQuery(name = "Place.findByPlaceIsigac", query = "SELECT p FROM Place p WHERE p.placeIsigac = :placeIsigac")})
public class Place implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 200)
    @Column(name = "idplace")
    private String idplace;
    @Size(max = 500)
    @Column(name = "place_name")
    private String placeName;
    @Size(max = 500)
    @Column(name = "place_category")
    private String placeCategory;
    @Size(max = 500)
    @Column(name = "place_addr")
    private String placeAddr;
    @Size(max = 500)
    @Column(name = "place_latlng")
    private String placeLatlng;
    @Size(max = 500)
    @Column(name = "place_phone")
    private String placePhone;
    @Size(max = 2)
    @Column(name = "place_isigac")
    private String placeIsigac;
    @Size(max = 100)
    @Column(name = "place_city")
    private String placeCity;
    
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "place")
    private Collection<AccReport> accReportCollection;

    public Place() {
    }

    public Place(String idplace) {
        this.idplace = idplace;
    }
    
    

    public String getIdplace() {
        return idplace;
    }

    public void setIdplace(String idplace) {
        this.idplace = idplace;
    }

    public String getPlaceName() {
        return placeName;
    }

    public void setPlaceName(String placeName) {
        this.placeName = placeName;
    }

    public String getPlaceCategory() {
        return placeCategory;
    }

    public void setPlaceCategory(String placeCategory) {
        this.placeCategory = placeCategory;
    }

    public String getPlaceAddr() {
        return placeAddr;
    }

    public void setPlaceAddr(String placeAddr) {
        this.placeAddr = placeAddr;
    }

    public String getPlaceLatlng() {
        return placeLatlng;
    }

    public void setPlaceLatlng(String placeLatlng) {
        this.placeLatlng = placeLatlng;
    }

    public String getPlacePhone() {
        return placePhone;
    }

    public void setPlacePhone(String placePhone) {
        this.placePhone = placePhone;
    }

    public String getPlaceIsigac() {
        return placeIsigac;
    }

    public void setPlaceIsigac(String placeIsigac) {
        this.placeIsigac = placeIsigac;
    }

    public String getPlaceCity() {
        return placeCity;
    }

    public void setPlaceCity(String placeCity) {
        this.placeCity = placeCity;
    }

    @XmlTransient
    public Collection<AccReport> getAccReportCollection() {
        return accReportCollection;
    }

    public void setAccReportCollection(Collection<AccReport> accReportCollection) {
        this.accReportCollection = accReportCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idplace != null ? idplace.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Place)) {
            return false;
        }
        Place other = (Place) object;
        if ((this.idplace == null && other.idplace != null) || (this.idplace != null && !this.idplace.equals(other.idplace))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.Place[ idplace=" + idplace + " ]";
    }
    
}
