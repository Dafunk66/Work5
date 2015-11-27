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
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Dafunk
 */
@Entity
@Table(name = "purchase_detail")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "PurchaseDetail.findAll", query = "SELECT p FROM PurchaseDetail p"),
    @NamedQuery(name = "PurchaseDetail.findByPurchNo", query = "SELECT p FROM PurchaseDetail p WHERE p.purchNo = :purchNo"),
    @NamedQuery(name = "PurchaseDetail.findByPurchQty", query = "SELECT p FROM PurchaseDetail p WHERE p.purchQty = :purchQty"),
    @NamedQuery(name = "PurchaseDetail.findByCost", query = "SELECT p FROM PurchaseDetail p WHERE p.cost = :cost"),
    @NamedQuery(name = "PurchaseDetail.findByNetTotal", query = "SELECT p FROM PurchaseDetail p WHERE p.netTotal = :netTotal")})
public class PurchaseDetail implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "PurchNo")
    private String purchNo;
    @Column(name = "PurchQty")
    private Integer purchQty;
    @Size(max = 40)
    @Column(name = "Cost")
    private String cost;
    @Size(max = 40)
    @Column(name = "NetTotal")
    private String netTotal;
    @JoinColumn(name = "Receive_ID", referencedColumnName = "Receive_ID")
    @ManyToOne
    private ReceivePascel receiveID;

    public PurchaseDetail() {
    }

    public PurchaseDetail(String purchNo) {
        this.purchNo = purchNo;
    }

    public String getPurchNo() {
        return purchNo;
    }

    public void setPurchNo(String purchNo) {
        this.purchNo = purchNo;
    }

    public Integer getPurchQty() {
        return purchQty;
    }

    public void setPurchQty(Integer purchQty) {
        this.purchQty = purchQty;
    }

    public String getCost() {
        return cost;
    }

    public void setCost(String cost) {
        this.cost = cost;
    }

    public String getNetTotal() {
        return netTotal;
    }

    public void setNetTotal(String netTotal) {
        this.netTotal = netTotal;
    }

    public ReceivePascel getReceiveID() {
        return receiveID;
    }

    public void setReceiveID(ReceivePascel receiveID) {
        this.receiveID = receiveID;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (purchNo != null ? purchNo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PurchaseDetail)) {
            return false;
        }
        PurchaseDetail other = (PurchaseDetail) object;
        if ((this.purchNo == null && other.purchNo != null) || (this.purchNo != null && !this.purchNo.equals(other.purchNo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "jpa.PurchaseDetail[ purchNo=" + purchNo + " ]";
    }
    
}
