/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jpa.session;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import jpa.PurchaseDetail;

/**
 *
 * @author Dafunk
 */
@Stateless
public class PurchaseDetailFacade extends AbstractFacade<PurchaseDetail> {

    @PersistenceContext(unitName = "TosaponPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public PurchaseDetailFacade() {
        super(PurchaseDetail.class);
    }
    
}
