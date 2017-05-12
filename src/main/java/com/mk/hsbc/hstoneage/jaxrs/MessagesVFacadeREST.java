package com.mk.hsbc.hstoneage.jaxrs;

import com.mk.hsbc.hstoneage.data.MessagesV;
import com.mk.hsbc.hstoneage.data.Persons;
import com.mk.hsbc.hstoneage.data.Wall;
import java.util.LinkedList;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

/**
 * This is RESTful Web API for https://github.com/HStoneAge/code-challenge task.
 * This is small task with very limited interface with no authentication, authorizationa and accounting features.
 * Users can't delete their messages (it's easy to add delete method, but it's not in scope).
 * To distinquish users, sername is in the REST query, it can be replaced in the future for HMAC or sth. else.
 * Example URL is here:
 * http://localhost:8080/HSBC_HStoneAge/jaxrs/Bob/messages/my
 * There is common pattern for URL: [PREFIX_WITH_HOST_NAME_PORT_ETC]/jaxrs/[USERNAME]/messages/[COMMAND]
 * where [COMMAND] can be:<br>
 * <ul>
 *  <li>add - valid only for POST method, use it for adding new messages</li>
 *  <li>my - valid only for GET method, use it for reading only your messages</li>
 *  <li>all - valid only for GET method, use it for reading all messages, posted by any user</li>
 *  <li>follow - valid only for GET method, use it for your messages and messages sent by followed users</li>
 * </ul>
 *
 * @author Marcin Kolodziejczyk
 */
@Stateless
@Path("{name}/messages")
public class MessagesVFacadeREST {

    @PersistenceContext(unitName = "com.mk_HSBC_HStoneAge_war_1.0PU")
    private EntityManager em;

    @POST
    @Path("add")
    @Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public void create(@PathParam("name") String name, String message) {
        List<Persons> lp = em.createNamedQuery("Persons.findByName").setParameter("name", name).getResultList();
        int id;
        if (lp.size()==1) {
            id = lp.get(0).getId();
        } else {
            em.createNativeQuery("INSERT INTO Persons(id, name) VALUES((select max(id)+1 from Persons), ?)").setParameter(1, name).executeUpdate();
            id = (Integer) em.createNativeQuery("SELECT max(id) from Persons").getSingleResult();
        }
        Wall w = new Wall(id, System.currentTimeMillis());
        w.setMessage(message);
        em.persist(w);
    }

    @GET
    @Path("my")
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public List<MessagesV> find(@PathParam("name") String name) {
        return em.createNamedQuery("MessagesV.findByName").setParameter("name", name).getResultList();
    }

    @GET
    @Path("all")
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public List<MessagesV> findAll() {
        return em.createNamedQuery("MessagesV.findAll").getResultList();
    }

    @GET
    @Path("follow")
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public List<MessagesV> findFollowed(@PathParam("name") String name) {
        List<Persons> p = em.createNamedQuery("Persons.findByName").setParameter("name", name).getResultList();
        if (p.size()==1) {
            int id = p.get(0).getId();
            return em.createNamedQuery("MessagesV.findFollowed").setParameter("id", id).getResultList();
        } else
            return new LinkedList<MessagesV>();
    }

}
