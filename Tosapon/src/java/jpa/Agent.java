/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jpa;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Dafunk
 */
@Entity
@Table(name = "agent")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Agent.findAll", query = "SELECT a FROM Agent a"),
    @NamedQuery(name = "Agent.findByAgentID", query = "SELECT a FROM Agent a WHERE a.agentID = :agentID"),
    @NamedQuery(name = "Agent.findByAgentName", query = "SELECT a FROM Agent a WHERE a.agentName = :agentName"),
    @NamedQuery(name = "Agent.findByAgentAddress", query = "SELECT a FROM Agent a WHERE a.agentAddress = :agentAddress"),
    @NamedQuery(name = "Agent.findByAgebtTel", query = "SELECT a FROM Agent a WHERE a.agebtTel = :agebtTel")})
public class Agent implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "Agent_ID")
    private String agentID;
    @Size(max = 40)
    @Column(name = "Agent_Name")
    private String agentName;
    @Size(max = 40)
    @Column(name = "Agent_Address")
    private String agentAddress;
    @Size(max = 20)
    @Column(name = "Agebt_Tel")
    private String agebtTel;
    @OneToMany(mappedBy = "agentID")
    private Collection<ReceivePascel> receivePascelCollection;

    public Agent() {
    }

    public Agent(String agentID) {
        this.agentID = agentID;
    }

    public String getAgentID() {
        return agentID;
    }

    public void setAgentID(String agentID) {
        this.agentID = agentID;
    }

    public String getAgentName() {
        return agentName;
    }

    public void setAgentName(String agentName) {
        this.agentName = agentName;
    }

    public String getAgentAddress() {
        return agentAddress;
    }

    public void setAgentAddress(String agentAddress) {
        this.agentAddress = agentAddress;
    }

    public String getAgebtTel() {
        return agebtTel;
    }

    public void setAgebtTel(String agebtTel) {
        this.agebtTel = agebtTel;
    }

    @XmlTransient
    public Collection<ReceivePascel> getReceivePascelCollection() {
        return receivePascelCollection;
    }

    public void setReceivePascelCollection(Collection<ReceivePascel> receivePascelCollection) {
        this.receivePascelCollection = receivePascelCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (agentID != null ? agentID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Agent)) {
            return false;
        }
        Agent other = (Agent) object;
        if ((this.agentID == null && other.agentID != null) || (this.agentID != null && !this.agentID.equals(other.agentID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "jpa.Agent[ agentID=" + agentID + " ]";
    }
    
}
