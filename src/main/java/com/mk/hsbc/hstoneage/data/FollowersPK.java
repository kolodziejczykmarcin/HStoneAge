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
public class FollowersPK implements Serializable {

    @Basic(optional = false)
    @NotNull
    @Column(name = "ID")
    private int id;
    @Basic(optional = false)
    @NotNull
    @Column(name = "FOLLOWS")
    private int follows;

    public FollowersPK() {
    }

    public FollowersPK(int id, int follows) {
        this.id = id;
        this.follows = follows;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getFollows() {
        return follows;
    }

    public void setFollows(int follows) {
        this.follows = follows;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) id;
        hash += (int) follows;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof FollowersPK)) {
            return false;
        }
        FollowersPK other = (FollowersPK) object;
        if (this.id != other.id) {
            return false;
        }
        if (this.follows != other.follows) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mk.hsbc.hstoneage.data.FollowersPK[ id=" + id + ", follows=" + follows + " ]";
    }

}
