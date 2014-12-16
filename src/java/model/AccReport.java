/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author user
 */
@Entity
@Table(name = "accReport", catalog = "guiame_backend", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "AccReport.findAll", query = "SELECT a FROM AccReport a"),
    @NamedQuery(name = "AccReport.findByPlaceIdplace", query = "SELECT a FROM AccReport a WHERE a.accReportPK.placeIdplace = :placeIdplace"),
    @NamedQuery(name = "AccReport.findByUserIduser", query = "SELECT a FROM AccReport a WHERE a.accReportPK.userIduser = :userIduser"),
    @NamedQuery(name = "AccReport.findByDate", query = "SELECT a FROM AccReport a WHERE a.date = :date"),
    @NamedQuery(name = "AccReport.findByHasRamps", query = "SELECT a FROM AccReport a WHERE a.hasRamps = :hasRamps"),
    @NamedQuery(name = "AccReport.findByHasElevators", query = "SELECT a FROM AccReport a WHERE a.hasElevators = :hasElevators"),
    @NamedQuery(name = "AccReport.findByHasEscalators", query = "SELECT a FROM AccReport a WHERE a.hasEscalators = :hasEscalators"),
    @NamedQuery(name = "AccReport.findByIsOnefloor", query = "SELECT a FROM AccReport a WHERE a.isOnefloor = :isOnefloor"),
    @NamedQuery(name = "AccReport.findByHasAccparking", query = "SELECT a FROM AccReport a WHERE a.hasAccparking = :hasAccparking"),
    @NamedQuery(name = "AccReport.findByHasBrailemap", query = "SELECT a FROM AccReport a WHERE a.hasBrailemap = :hasBrailemap"),
    @NamedQuery(name = "AccReport.findByHasBrailelabels", query = "SELECT a FROM AccReport a WHERE a.hasBrailelabels = :hasBrailelabels"),
    @NamedQuery(name = "AccReport.findByHasHumansupport", query = "SELECT a FROM AccReport a WHERE a.hasHumansupport = :hasHumansupport"),
    @NamedQuery(name = "AccReport.findByHasAccbathroom", query = "SELECT a FROM AccReport a WHERE a.hasAccbathroom = :hasAccbathroom"),
    @NamedQuery(name = "AccReport.findByComments", query = "SELECT a FROM AccReport a WHERE a.comments = :comments")})
public class AccReport implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected AccReportPK accReportPK;
    @Column(name = "date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date date;
    @Basic(optional = false)
    @NotNull
    @Column(name = "has_ramps")
    private int hasRamps;
    @Basic(optional = false)
    @NotNull
    @Column(name = "has_elevators")
    private int hasElevators;
    @Basic(optional = false)
    @NotNull
    @Column(name = "has_escalators")
    private int hasEscalators;
    @Basic(optional = false)
    @NotNull
    @Column(name = "is_onefloor")
    private int isOnefloor;
    @Basic(optional = false)
    @NotNull
    @Column(name = "has_accparking")
    private int hasAccparking;
    @Basic(optional = false)
    @NotNull
    @Column(name = "has_brailemap")
    private int hasBrailemap;
    @Basic(optional = false)
    @NotNull
    @Column(name = "has_brailelabels")
    private int hasBrailelabels;
    @Basic(optional = false)
    @NotNull
    @Column(name = "has_humansupport")
    private int hasHumansupport;
    @Basic(optional = false)
    @NotNull
    @Column(name = "has_accbathroom")
    private int hasAccbathroom;
    @Size(max = 500)
    @Column(name = "comments")
    private String comments;
    @JoinColumn(name = "place_idplace", referencedColumnName = "idplace", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Place place;
    @JoinColumn(name = "user_iduser", referencedColumnName = "iduser", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private User user;

    public AccReport() {
    }

    public AccReport(AccReportPK accReportPK) {
        this.accReportPK = accReportPK;
    }

    public AccReport(int hasRamps, int hasElevators, int hasEscalators, int isOnefloor, int hasAccparking, int hasBrailemap, int hasBrailelabels, int hasHumansupport, int hasAccbathroom) {
        this.hasRamps = hasRamps;
        this.hasElevators = hasElevators;
        this.hasEscalators = hasEscalators;
        this.isOnefloor = isOnefloor;
        this.hasAccparking = hasAccparking;
        this.hasBrailemap = hasBrailemap;
        this.hasBrailelabels = hasBrailelabels;
        this.hasHumansupport = hasHumansupport;
        this.hasAccbathroom = hasAccbathroom;
    }


    public AccReport(AccReportPK accReportPK, int hasRamps, int hasElevators, int hasEscalators, int isOnefloor, int hasAccparking, int hasBrailemap, int hasBrailelabels, int hasHumansupport, int hasAccbathroom) {
        this.accReportPK = accReportPK;
        this.hasRamps = hasRamps;
        this.hasElevators = hasElevators;
        this.hasEscalators = hasEscalators;
        this.isOnefloor = isOnefloor;
        this.hasAccparking = hasAccparking;
        this.hasBrailemap = hasBrailemap;
        this.hasBrailelabels = hasBrailelabels;
        this.hasHumansupport = hasHumansupport;
        this.hasAccbathroom = hasAccbathroom;
    }
    
    

    public AccReport(String placeIdplace, String userIduser) {
        this.accReportPK = new AccReportPK(placeIdplace, userIduser);
    }

    public AccReportPK getAccReportPK() {
        return accReportPK;
    }

    public void setAccReportPK(AccReportPK accReportPK) {
        this.accReportPK = accReportPK;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public int getHasRamps() {
        return hasRamps;
    }

    public void setHasRamps(int hasRamps) {
        this.hasRamps = hasRamps;
    }

    public int getHasElevators() {
        return hasElevators;
    }

    public void setHasElevators(int hasElevators) {
        this.hasElevators = hasElevators;
    }

    public int getHasEscalators() {
        return hasEscalators;
    }

    public void setHasEscalators(int hasEscalators) {
        this.hasEscalators = hasEscalators;
    }

    public int getIsOnefloor() {
        return isOnefloor;
    }

    public void setIsOnefloor(int isOnefloor) {
        this.isOnefloor = isOnefloor;
    }

    public int getHasAccparking() {
        return hasAccparking;
    }

    public void setHasAccparking(int hasAccparking) {
        this.hasAccparking = hasAccparking;
    }

    public int getHasBrailemap() {
        return hasBrailemap;
    }

    public void setHasBrailemap(int hasBrailemap) {
        this.hasBrailemap = hasBrailemap;
    }

    public int getHasBrailelabels() {
        return hasBrailelabels;
    }

    public void setHasBrailelabels(int hasBrailelabels) {
        this.hasBrailelabels = hasBrailelabels;
    }

    public int getHasHumansupport() {
        return hasHumansupport;
    }

    public void setHasHumansupport(int hasHumansupport) {
        this.hasHumansupport = hasHumansupport;
    }

    public int getHasAccbathroom() {
        return hasAccbathroom;
    }

    public void setHasAccbathroom(int hasAccbathroom) {
        this.hasAccbathroom = hasAccbathroom;
    }

    public String getComments() {
        return comments;
    }

    public void setComments(String comments) {
        this.comments = comments;
    }

    public Place getPlace() {
        return place;
    }

    public void setPlace(Place place) {
        this.place = place;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (accReportPK != null ? accReportPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof AccReport)) {
            return false;
        }
        AccReport other = (AccReport) object;
        if ((this.accReportPK == null && other.accReportPK != null) || (this.accReportPK != null && !this.accReportPK.equals(other.accReportPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.AccReport[ accReportPK=" + accReportPK + " ]";
    }
    
}
