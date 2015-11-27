/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jpa;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Dafunk
 */
@Entity
@Table(name = "receive_detail")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ReceiveDetail.findAll", query = "SELECT r FROM ReceiveDetail r"),
    @NamedQuery(name = "ReceiveDetail.findByReceiveID", query = "SELECT r FROM ReceiveDetail r WHERE r.receiveID = :receiveID"),
    @NamedQuery(name = "ReceiveDetail.findByReceiveQty", query = "SELECT r FROM ReceiveDetail r WHERE r.receiveQty = :receiveQty")})
public class ReceiveDetail implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "Receive_ID")
    private String receiveID;
    @Column(name = "ReceiveQty")
    private Integer receiveQty;
    @JoinColumn(name = "Receive_ID", referencedColumnName = "Receive_ID", insertable = false, updatable = false)
    @OneToOne(optional = false)
    private ReceivePascel receivePascel;

    public ReceiveDetail() {
    }

    public ReceiveDetail(String receiveID) {
        this.receiveID = receiveID;
    }

    public String getReceiveID() {
        return receiveID;
    }

    public void setReceiveID(String receiveID) {
        this.receiveID = receiveID;
    }

    public Integer getReceiveQty() {
        return receiveQty;
    }

    public void setReceiveQty(Integer receiveQty) {
        this.receiveQty = receiveQty;
    }

    public ReceivePascel getReceivePascel() {
        return receivePascel;
    }

    public void setReceivePascel(ReceivePascel receivePascel) {
        this.receivePascel = receivePascel;
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
        if (!(object instanceof ReceiveDetail)) {
            return false;
        }
        ReceiveDetail other = (ReceiveDetail) object;
        if ((this.receiveID == null && other.receiveID != null) || (this.receiveID != null && !this.receiveID.equals(other.receiveID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "jpa.ReceiveDetail[ receiveID=" + receiveID + " ]";
    }
    
}
