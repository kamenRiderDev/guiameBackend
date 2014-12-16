/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author user
 */
@Embeddable
public class AccReportPK implements Serializable {
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 200)
    @Column(name = "place_idplace")
    private String placeIdplace;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 200)
    @Column(name = "user_iduser")
    private String userIduser;

    public AccReportPK() {
    }

    public AccReportPK(String placeIdplace, String userIduser) {
        this.placeIdplace = placeIdplace;
        this.userIduser = userIduser;
    }

    public String getPlaceIdplace() {
        return placeIdplace;
    }

    public void setPlaceIdplace(String placeIdplace) {
        this.placeIdplace = placeIdplace;
    }

    public String getUserIduser() {
        return userIduser;
    }

    public void setUserIduser(String userIduser) {
        this.userIduser = userIduser;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (placeIdplace != null ? placeIdplace.hashCode() : 0);
        hash += (userIduser != null ? userIduser.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof AccReportPK)) {
            return false;
        }
        AccReportPK other = (AccReportPK) object;
        if ((this.placeIdplace == null && other.placeIdplace != null) || (this.placeIdplace != null && !this.placeIdplace.equals(other.placeIdplace))) {
            return false;
        }
        if ((this.userIduser == null && other.userIduser != null) || (this.userIduser != null && !this.userIduser.equals(other.userIduser))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.AccReportPK[ placeIdplace=" + placeIdplace + ", userIduser=" + userIduser + " ]";
    }
    
}
