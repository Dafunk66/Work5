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
@Table(name = "personnel")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Personnel.findAll", query = "SELECT p FROM Personnel p"),
    @NamedQuery(name = "Personnel.findByPersID", query = "SELECT p FROM Personnel p WHERE p.persID = :persID"),
    @NamedQuery(name = "Personnel.findByPersName", query = "SELECT p FROM Personnel p WHERE p.persName = :persName"),
    @NamedQuery(name = "Personnel.findByPersAddress", query = "SELECT p FROM Personnel p WHERE p.persAddress = :persAddress"),
    @NamedQuery(name = "Personnel.findByPersTel", query = "SELECT p FROM Personnel p WHERE p.persTel = :persTel"),
    @NamedQuery(name = "Personnel.findByPersPosition", query = "SELECT p FROM Personnel p WHERE p.persPosition = :persPosition")})
public class Personnel implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "Pers_ID")
    private String persID;
    @Size(max = 40)
    @Column(name = "PersName")
    private String persName;
    @Size(max = 40)
    @Column(name = "PersAddress")
    private String persAddress;
    @Size(max = 40)
    @Column(name = "PersTel")
    private String persTel;
    @Size(max = 40)
    @Column(name = "PersPosition")
    private String persPosition;
    @OneToMany(mappedBy = "persID")
    private Collection<ReceivePascel> receivePascelCollection;

    public Personnel() {
    }

    public Personnel(String persID) {
        this.persID = persID;
    }

    public String getPersID() {
        return persID;
    }

    public void setPersID(String persID) {
        this.persID = persID;
    }

    public String getPersName() {
        return persName;
    }

    public void setPersName(String persName) {
        this.persName = persName;
    }

    public String getPersAddress() {
        return persAddress;
    }

    public void setPersAddress(String persAddress) {
        this.persAddress = persAddress;
    }

    public String getPersTel() {
        return persTel;
    }

    public void setPersTel(String persTel) {
        this.persTel = persTel;
    }

    public String getPersPosition() {
        return persPosition;
    }

    public void setPersPosition(String persPosition) {
        this.persPosition = persPosition;
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
        hash += (persID != null ? persID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Personnel)) {
            return false;
        }
        Personnel other = (Personnel) object;
        if ((this.persID == null && other.persID != null) || (this.persID != null && !this.persID.equals(other.persID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "jpa.Personnel[ persID=" + persID + " ]";
    }
    
}
