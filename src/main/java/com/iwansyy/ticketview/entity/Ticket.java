/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.iwansyy.ticketview.entity;

import java.io.Serializable;
import java.util.Date;
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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author iwansy
 */
@Entity
@Table(name = "ticket")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Ticket.findAll", query = "SELECT t FROM Ticket t")
    , @NamedQuery(name = "Ticket.findByTicketId", query = "SELECT t FROM Ticket t WHERE t.ticketId = :ticketId")
    , @NamedQuery(name = "Ticket.findByResults", query = "SELECT t FROM Ticket t WHERE t.results = :results")
    , @NamedQuery(name = "Ticket.findByDescriptions", query = "SELECT t FROM Ticket t WHERE t.descriptions = :descriptions")
    , @NamedQuery(name = "Ticket.findByRequestName", query = "SELECT t FROM Ticket t WHERE t.requestName = :requestName")
    , @NamedQuery(name = "Ticket.findByEmailRequest", query = "SELECT t FROM Ticket t WHERE t.emailRequest = :emailRequest")
    , @NamedQuery(name = "Ticket.findByRegisDate", query = "SELECT t FROM Ticket t WHERE t.regisDate = :regisDate")
    , @NamedQuery(name = "Ticket.findByAssignTo", query = "SELECT t FROM Ticket t WHERE t.assignTo = :assignTo")
    , @NamedQuery(name = "Ticket.findByDueDate", query = "SELECT t FROM Ticket t WHERE t.dueDate = :dueDate")
    , @NamedQuery(name = "Ticket.findByNoteAdd", query = "SELECT t FROM Ticket t WHERE t.noteAdd = :noteAdd")
    , @NamedQuery(name = "Ticket.findByResponseTime", query = "SELECT t FROM Ticket t WHERE t.responseTime = :responseTime")
    , @NamedQuery(name = "Ticket.findByResolutionTime", query = "SELECT t FROM Ticket t WHERE t.resolutionTime = :resolutionTime")
    , @NamedQuery(name = "Ticket.findByResolveTime", query = "SELECT t FROM Ticket t WHERE t.resolveTime = :resolveTime")
    , @NamedQuery(name = "Ticket.findByChangeDate", query = "SELECT t FROM Ticket t WHERE t.changeDate = :changeDate")
    , @NamedQuery(name = "Ticket.findByIssue", query = "SELECT t FROM Ticket t WHERE t.issue = :issue")
    , @NamedQuery(name = "Ticket.findByPriority", query = "SELECT t FROM Ticket t WHERE t.priority = :priority")
    , @NamedQuery(name = "Ticket.findByServices", query = "SELECT t FROM Ticket t WHERE t.services = :services")
    , @NamedQuery(name = "Ticket.findByResponseStatus", query = "SELECT t FROM Ticket t WHERE t.responseStatus = :responseStatus")
    , @NamedQuery(name = "Ticket.findByResolutionStatus", query = "SELECT t FROM Ticket t WHERE t.resolutionStatus = :resolutionStatus")
    , @NamedQuery(name = "Ticket.findByResolutionCount", query = "SELECT t FROM Ticket t WHERE t.resolutionCount = :resolutionCount")
    , @NamedQuery(name = "Ticket.findByResponseCount", query = "SELECT t FROM Ticket t WHERE t.responseCount = :responseCount")
    , @NamedQuery(name = "Ticket.findByResolveCount", query = "SELECT t FROM Ticket t WHERE t.resolveCount = :resolveCount")})
public class Ticket implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "ticket_id")
    private String ticketId;
    @Column(name = "results")
    private String results;
    @Basic(optional = false)
    @Column(name = "descriptions")
    private String descriptions;
    @Basic(optional = false)
    @Column(name = "request_name")
    private String requestName;
    @Basic(optional = false)
    @Column(name = "email_request")
    private String emailRequest;
    @Column(name = "regis_date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date regisDate;
    @Column(name = "assign_to")
    private String assignTo;
    @Column(name = "due_date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dueDate;
    @Column(name = "note_add")
    private String noteAdd;
    @Column(name = "response_time")
    @Temporal(TemporalType.TIMESTAMP)
    private Date responseTime;
    @Column(name = "resolution_time")
    @Temporal(TemporalType.TIMESTAMP)
    private Date resolutionTime;
    @Column(name = "resolve_time")
    @Temporal(TemporalType.TIMESTAMP)
    private Date resolveTime;
    @Column(name = "change_date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date changeDate;
    @Basic(optional = false)
    @Column(name = "issue")
    private String issue;
    @Basic(optional = false)
    @Column(name = "priority")
    private String priority;
    @Basic(optional = false)
    @Column(name = "services")
    private String services;
    @Column(name = "response_status")
    private String responseStatus;
    @Column(name = "resolution_status")
    private String resolutionStatus;
    @Column(name = "resolution_count")
    private Integer resolutionCount;
    @Column(name = "response_count")
    private Integer responseCount;
    @Column(name = "resolve_count")
    private Integer resolveCount;
    @JoinColumn(name = "employee_id", referencedColumnName = "employee_id")
    @ManyToOne(fetch = FetchType.LAZY)
    private Employee employeeId;
    @JoinColumn(name = "status_id", referencedColumnName = "status_id")
    @ManyToOne(fetch = FetchType.LAZY)
    private Status statusId;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "ticketId", fetch = FetchType.LAZY)
    private List<Files> filesList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "ticketId", fetch = FetchType.LAZY)
    private List<Logticket> logticketList;

    public Ticket() {
    }

    public Ticket(String ticketId) {
        this.ticketId = ticketId;
    }

    public Ticket(String ticketId, String descriptions, String requestName, String emailRequest, String issue, String priority, String services) {
        this.ticketId = ticketId;
        this.descriptions = descriptions;
        this.requestName = requestName;
        this.emailRequest = emailRequest;
        this.issue = issue;
        this.priority = priority;
        this.services = services;
    }

    public String getTicketId() {
        return ticketId;
    }

    public void setTicketId(String ticketId) {
        this.ticketId = ticketId;
    }

    public String getResults() {
        return results;
    }

    public void setResults(String results) {
        this.results = results;
    }

    public String getDescriptions() {
        return descriptions;
    }

    public void setDescriptions(String descriptions) {
        this.descriptions = descriptions;
    }

    public String getRequestName() {
        return requestName;
    }

    public void setRequestName(String requestName) {
        this.requestName = requestName;
    }

    public String getEmailRequest() {
        return emailRequest;
    }

    public void setEmailRequest(String emailRequest) {
        this.emailRequest = emailRequest;
    }

    public Date getRegisDate() {
        return regisDate;
    }

    public void setRegisDate(Date regisDate) {
        this.regisDate = regisDate;
    }

    public String getAssignTo() {
        return assignTo;
    }

    public void setAssignTo(String assignTo) {
        this.assignTo = assignTo;
    }

    public Date getDueDate() {
        return dueDate;
    }

    public void setDueDate(Date dueDate) {
        this.dueDate = dueDate;
    }

    public String getNoteAdd() {
        return noteAdd;
    }

    public void setNoteAdd(String noteAdd) {
        this.noteAdd = noteAdd;
    }

    public Date getResponseTime() {
        return responseTime;
    }

    public void setResponseTime(Date responseTime) {
        this.responseTime = responseTime;
    }

    public Date getResolutionTime() {
        return resolutionTime;
    }

    public void setResolutionTime(Date resolutionTime) {
        this.resolutionTime = resolutionTime;
    }

    public Date getResolveTime() {
        return resolveTime;
    }

    public void setResolveTime(Date resolveTime) {
        this.resolveTime = resolveTime;
    }

    public Date getChangeDate() {
        return changeDate;
    }

    public void setChangeDate(Date changeDate) {
        this.changeDate = changeDate;
    }

    public String getIssue() {
        return issue;
    }

    public void setIssue(String issue) {
        this.issue = issue;
    }

    public String getPriority() {
        return priority;
    }

    public void setPriority(String priority) {
        this.priority = priority;
    }

    public String getServices() {
        return services;
    }

    public void setServices(String services) {
        this.services = services;
    }

    public String getResponseStatus() {
        return responseStatus;
    }

    public void setResponseStatus(String responseStatus) {
        this.responseStatus = responseStatus;
    }

    public String getResolutionStatus() {
        return resolutionStatus;
    }

    public void setResolutionStatus(String resolutionStatus) {
        this.resolutionStatus = resolutionStatus;
    }

    public Integer getResolutionCount() {
        return resolutionCount;
    }

    public void setResolutionCount(Integer resolutionCount) {
        this.resolutionCount = resolutionCount;
    }

    public Integer getResponseCount() {
        return responseCount;
    }

    public void setResponseCount(Integer responseCount) {
        this.responseCount = responseCount;
    }

    public Integer getResolveCount() {
        return resolveCount;
    }

    public void setResolveCount(Integer resolveCount) {
        this.resolveCount = resolveCount;
    }

    public Employee getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(Employee employeeId) {
        this.employeeId = employeeId;
    }

    public Status getStatusId() {
        return statusId;
    }

    public void setStatusId(Status statusId) {
        this.statusId = statusId;
    }

    @XmlTransient
    public List<Files> getFilesList() {
        return filesList;
    }

    public void setFilesList(List<Files> filesList) {
        this.filesList = filesList;
    }

    @XmlTransient
    public List<Logticket> getLogticketList() {
        return logticketList;
    }

    public void setLogticketList(List<Logticket> logticketList) {
        this.logticketList = logticketList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (ticketId != null ? ticketId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Ticket)) {
            return false;
        }
        Ticket other = (Ticket) object;
        if ((this.ticketId == null && other.ticketId != null) || (this.ticketId != null && !this.ticketId.equals(other.ticketId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.iwansyy.ticketview.entity.Ticket[ ticketId=" + ticketId + " ]";
    }
    
}
