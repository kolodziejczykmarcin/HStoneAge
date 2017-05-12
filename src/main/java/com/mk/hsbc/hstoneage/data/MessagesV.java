/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.mk.hsbc.hstoneage.data;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Marcin Kolodziejczyk
 */
@Entity
@Table(name = "MESSAGESV")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "MessagesV.findAll", query = "SELECT m FROM MessagesV m ORDER BY m.timestamp DESC")
    , @NamedQuery(name = "MessagesV.findByName", query = "SELECT m FROM MessagesV m WHERE m.name = :name ORDER BY m.timestamp DESC")
    , @NamedQuery(name = "MessagesV.findFollowed", query = "select m from MessagesV m where m.id = :id or m.id in (select f.followersPK.follows from Followers f where f.followersPK.id = :id) ORDER BY m.timestamp DESC")})
public class MessagesV implements Serializable {

    private static final long serialVersionUID = 1L;
    @Size(max = 140)
    @Column(name = "MESSAGE")
    private String message;
    @Size(max = 64)
    @Column(name = "NAME")
    private String name;
    @Basic(optional = false)
    @NotNull
    @Column(name = "TIMESTAMP")
    @Id
    private long timestamp;
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID")
    @Id
    @XmlTransient
    private int id;

    public MessagesV() {
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public long getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(long timestamp) {
        this.timestamp = timestamp;
    }

    @XmlTransient
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

}
