/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.mk.hsbc.hstoneage.data;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.validation.constraints.NotNull;

/**
 *
 * @author Marcin Kolodziejczyk
 */
@Embeddable
public class WallPK implements Serializable {

    @Basic(optional = false)
    @NotNull
    @Column(name = "USERID")
    private int userid;
    @Basic(optional = false)
    @NotNull
    @Column(name = "TIMESTAMP")
    private long timestamp;

    public WallPK() {
    }

    public WallPK(int userid, long timestamp) {
        this.userid = userid;
        this.timestamp = timestamp;
    }

    public int getUserid() {
        return userid;
    }

    public void setUserid(int userid) {
        this.userid = userid;
    }

    public long getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(long timestamp) {
        this.timestamp = timestamp;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) userid;
        hash += (int) timestamp;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof WallPK)) {
            return false;
        }
        WallPK other = (WallPK) object;
        if (this.userid != other.userid) {
            return false;
        }
        if (this.timestamp != other.timestamp) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mk.hsbc.hstoneage.data.WallPK[ userid=" + userid + ", timestamp=" + timestamp + " ]";
    }

}
