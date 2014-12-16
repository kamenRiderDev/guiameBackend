/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package facade;

import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import model.AccReport;

/**
 *
 * @author user
 */
@Stateless
public class AccReportFacade extends AbstractFacade<AccReport> {
    @PersistenceContext(unitName = "guiameBackendPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public AccReportFacade() {
        super(AccReport.class);
    }

    
}
