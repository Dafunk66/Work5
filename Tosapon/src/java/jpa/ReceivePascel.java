/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jpa;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Dafunk
 */
@Entity
@Table(name = "receive_pascel")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ReceivePascel.findAll", query = "SELECT r FROM ReceivePascel r"),
    @NamedQuery(name = "ReceivePascel.findByReceiveID", query = "SELECT r FROM ReceivePascel r WHERE r.receiveID = :receiveID"),
    @NamedQuery(name = "ReceivePascel.findByReceiveDate", query = "SELECT r FROM ReceivePascel r WHERE r.receiveDate = :receiveDate")})
public class ReceivePascel implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "Receive_ID")
    private String receiveID;
    @Column(name = "Receive_Date")
    @Temporal(TemporalType.DATE)
    private Date receiveDate;
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "receivePascel")
    private ReceiveDetail receiveDetail;
    @JoinColumn(name = "Agent_ID", referencedColumnName = "Agent_ID")
    @ManyToOne
    private Agent agentID;
    @JoinColumn(name = "Pers_ID", referencedColumnName = "Pers_ID")
    @ManyToOne
    private Personnel persID;
    @OneToMany(mappedBy = "receiveID")
    private Collection<PurchaseDetail> purchaseDetailCollection;

    public ReceivePascel() {
    }

    public ReceivePascel(String receiveID) {
        this.receiveID = receiveID;
    }

    public String getReceiveID() {
        return receiveID;
    }

    public void setReceiveID(String receiveID) {
        this.receiveID = receiveID;
    }

    public Date getReceiveDate() {
        return receiveDate;
    }

    public void setReceiveDate(Date receiveDate) {
        this.receiveDate = receiveDate;
    }

    public ReceiveDetail getReceiveDetail() {
        return receiveDetail;
    }

    public void setReceiveDetail(ReceiveDetail receiveDetail) {
        this.receiveDetail = receiveDetail;
    }

    public Agent getAgentID() {
        return agentID;
    }

    public void setAgentID(Agent agentID) {
        this.agentID = agentID;
    }

    public Personnel getPersID() {
        return persID;
    }

    public void setPersID(Personnel persID) {
        this.persID = persID;
    }

    @XmlTransient
    public Collection<PurchaseDetail> getPurchaseDetailCollection() {
        return purchaseDetailCollection;
    }

    public void setPurchaseDetailCollection(Collection<PurchaseDetail> purchaseDetailCollection) {
        this.purchaseDetailCollection = purchaseDetailCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (receiveID != null ? receiveID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ReceivePascel)) {
            return false;
        }
        ReceivePascel other = (ReceivePascel) object;
        if ((this.receiveID == null && other.receiveID != null) || (this.receiveID != null && !this.receiveID.equals(other.receiveID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "jpa.ReceivePascel[ receiveID=" + receiveID + " ]";
    }
    
}
