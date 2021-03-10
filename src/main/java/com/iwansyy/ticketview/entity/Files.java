/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.iwansyy.ticketview.entity;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author iwansy
 */
@Entity
@Table(name = "files")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Files.findAll", query = "SELECT f FROM Files f")
    , @NamedQuery(name = "Files.findByFileId", query = "SELECT f FROM Files f WHERE f.fileId = :fileId")})
public class Files implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "file_id")
    private String fileId;
    @Basic(optional = false)
    @Lob
    @Column(name = "binaryfile")
    private byte[] binaryfile;
    @JoinColumn(name = "ticket_id", referencedColumnName = "ticket_id")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Ticket ticketId;

    public Files() {
    }

    public Files(String fileId) {
        this.fileId = fileId;
    }

    public Files(String fileId, byte[] binaryfile) {
        this.fileId = fileId;
        this.binaryfile = binaryfile;
    }

    public String getFileId() {
        return fileId;
    }

    public void setFileId(String fileId) {
        this.fileId = fileId;
    }

    public byte[] getBinaryfile() {
        return binaryfile;
    }

    public void setBinaryfile(byte[] binaryfile) {
        this.binaryfile = binaryfile;
    }

    public Ticket getTicketId() {
        return ticketId;
    }

    public void setTicketId(Ticket ticketId) {
        this.ticketId = ticketId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (fileId != null ? fileId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Files)) {
            return false;
        }
        Files other = (Files) object;
        if ((this.fileId == null && other.fileId != null) || (this.fileId != null && !this.fileId.equals(other.fileId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.iwansyy.ticketview.entity.Files[ fileId=" + fileId + " ]";
    }
    
}
