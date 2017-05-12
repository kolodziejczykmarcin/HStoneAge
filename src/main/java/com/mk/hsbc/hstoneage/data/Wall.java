/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.mk.hsbc.hstoneage.data;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Marcin Kolodziejczyk
 */
@Entity
@Table(name = "WALL")
@XmlRootElement
public class Wall implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected WallPK wallPK;
    @Size(max = 140)
    @Column(name = "MESSAGE")
    private String message;
    @JoinColumn(name = "USERID", referencedColumnName = "ID", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Persons persons;

    public Wall() {
    }

    public Wall(WallPK wallPK) {
        this.wallPK = wallPK;
    }

    public Wall(int userid, long timestamp) {
        this.wallPK = new WallPK(userid, timestamp);
    }

    public WallPK getWallPK() {
        return wallPK;
    }

    public void setWallPK(WallPK wallPK) {
        this.wallPK = wallPK;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Persons getPersons() {
        return persons;
    }

    public void setPersons(Persons persons) {
        this.persons = persons;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (wallPK != null ? wallPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Wall)) {
            return false;
        }
        Wall other = (Wall) object;
        if ((this.wallPK == null && other.wallPK != null) || (this.wallPK != null && !this.wallPK.equals(other.wallPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mk.hsbc.hstoneage.data.Wall[ wallPK=" + wallPK + " ]";
    }

}
