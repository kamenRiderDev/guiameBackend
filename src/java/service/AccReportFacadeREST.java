/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import facade.AccReportFacade;
import facade.PlaceFacade;
import facade.UserFacade;
import java.math.BigDecimal;
import java.util.List;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.PathSegment;
import model.AccReport;
import model.AccReportPK;


/**
 *
 * @author user
 */
@Stateless
@Path("accreport")
public class AccReportFacadeREST extends AbstractFacade<AccReport> {
    @PersistenceContext(unitName = "guiameBackendPU")
    private EntityManager em;
    
    @Inject
    PlaceFacade placeFacade;
    @Inject
    UserFacade userFacade;

    private AccReportPK getPrimaryKey(PathSegment pathSegment) {
        /*
         * pathSemgent represents a URI path segment and any associated matrix parameters.
         * URI path part is supposed to be in form of 'somePath;placeIdplace=placeIdplaceValue;userIduser=userIduserValue'.
         * Here 'somePath' is a result of getPath() method invocation and
         * it is ignored in the following code.
         * Matrix parameters are used as field names to build a primary key instance.
         */
        model.AccReportPK key = new model.AccReportPK();
        javax.ws.rs.core.MultivaluedMap<String, String> map = pathSegment.getMatrixParameters();
        java.util.List<String> placeIdplace = map.get("placeIdplace");
        if (placeIdplace != null && !placeIdplace.isEmpty()) {
            key.setPlaceIdplace(placeIdplace.get(0));
        }
        java.util.List<String> userIduser = map.get("userIduser");
        if (userIduser != null && !userIduser.isEmpty()) {
            key.setUserIduser(userIduser.get(0));
        }
        return key;
    }

    public AccReportFacadeREST() {
        super(AccReport.class);
    }

    @POST
    @Override
    @Consumes({"application/json"})
    public void create(AccReport entity) {
        
        if (placeFacade.find(entity.getPlace().getIdplace()) == null)
        {
            placeFacade.create(entity.getPlace());
        }
        if (userFacade.find(entity.getUser().getIduser()) == null)
        {
            userFacade.create(entity.getUser());
        }
        AccReportPK accReportPK = new AccReportPK(entity.getPlace().getIdplace(), entity.getUser().getIduser());
        entity.setAccReportPK(accReportPK);
        super.create(entity);
    }

    @PUT
    @Path("{id}")
    @Consumes({"application/xml", "application/json"})
    public void edit(@PathParam("id") PathSegment id, AccReport entity) {
        super.edit(entity);
    }

    @DELETE
    @Path("{id}")
    public void remove(@PathParam("id") PathSegment id) {
        model.AccReportPK key = getPrimaryKey(id);
        super.remove(super.find(key));
    }

    @GET
    @Path("{id}")
    @Produces({"application/json"})
    public AccReport find(@PathParam("id") String id) {
       Query query = getEntityManager().createNativeQuery("select round(avg(has_ramps)), round(avg(has_elevators)), round(avg(has_escalators)), \n" +
       "round(avg(is_onefloor)), round(avg(has_accparking)), round(avg(has_brailemap)), round(avg(has_brailelabels)), \n" +
       "round(avg(has_humansupport)), round(avg(has_accbathroom)) from accReport where place_idplace = '"
       + id
       + "'");
       
       Object result = query.getSingleResult();
       Object[] resultArray = (Object[]) result;
       
       int[] valuesArray = new int[resultArray.length];
       
       if (resultArray[0] == null)
       {
           for (int i = 0; i < valuesArray.length; i++)
           {
               valuesArray[i] = -1;
           }
       }
       else
       {
           int i = 0;
           for (Object value : resultArray)
           {
               BigDecimal bdval = (BigDecimal) value;
               valuesArray[i] =  bdval.intValue();
               i++;
           }
       }
       
       return new AccReport(valuesArray[0],valuesArray[1],valuesArray[2],valuesArray[3],
       valuesArray[4],valuesArray[5],valuesArray[6],valuesArray[7],
       valuesArray[8]);
    }

    @GET
    @Override
    @Produces({"application/json"})
    public List<AccReport> findAll() {
        return super.findAll();
    }

    @GET
    @Path("{from}/{to}")
    @Produces({"application/xml", "application/json"})
    public List<AccReport> findRange(@PathParam("from") Integer from, @PathParam("to") Integer to) {
        return super.findRange(new int[]{from, to});
    }

    @GET
    @Path("count")
    @Produces("text/plain")
    public String countREST() {
        return String.valueOf(super.count());
    }

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }
    
}
