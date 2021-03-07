/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.iwansyy.ticketview.entity;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author iwansy
 */
@Entity
@Table(name = "files")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Files.findAll", query = "SELECT f FROM Files f")
    , @NamedQuery(name = "Files.findByFileId", query = "SELECT f FROM Files f WHERE f.fileId = :fileId")
    , @NamedQuery(name = "Files.findByFileName", query = "SELECT f FROM Files f WHERE f.fileName = :fileName")})
public class Files implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "file_id")
    private String fileId;
    @Basic(optional = false)
    @Column(name = "fileName")
    private String fileName;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "ticketId", fetch = FetchType.LAZY)
    private List<Files> filesList;
    @JoinColumn(name = "ticket_id", referencedColumnName = "file_id")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Files ticketId;

    public Files() {
    }

    public Files(String fileId) {
        this.fileId = fileId;
    }

    public Files(String fileId, String fileName) {
        this.fileId = fileId;
        this.fileName = fileName;
    }

    public String getFileId() {
        return fileId;
    }

    public void setFileId(String fileId) {
        this.fileId = fileId;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    @XmlTransient
    public List<Files> getFilesList() {
        return filesList;
    }

    public void setFilesList(List<Files> filesList) {
        this.filesList = filesList;
    }

    public Files getTicketId() {
        return ticketId;
    }

    public void setTicketId(Files ticketId) {
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
