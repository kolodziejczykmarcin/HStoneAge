/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.mk.hsbc.hstoneage.data;

import java.io.Serializable;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Marcin Kolodziejczyk
 */
@Entity
@Table(name = "FOLLOWERS")
@XmlRootElement
public class Followers implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected FollowersPK followersPK;

    public Followers() {
    }

    public Followers(FollowersPK followersPK) {
        this.followersPK = followersPK;
    }

    public Followers(int id, int follows) {
        this.followersPK = new FollowersPK(id, follows);
    }

    public FollowersPK getFollowersPK() {
        return followersPK;
    }

    public void setFollowersPK(FollowersPK followersPK) {
        this.followersPK = followersPK;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (followersPK != null ? followersPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Followers)) {
            return false;
        }
        Followers other = (Followers) object;
        if ((this.followersPK == null && other.followersPK != null) || (this.followersPK != null && !this.followersPK.equals(other.followersPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mk.hsbc.hstoneage.data.Followers[ followersPK=" + followersPK + " ]";
    }

}
