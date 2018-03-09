
package rest;

import com.google.gson.Gson;
import entity.Person;
import entity.PersonFacade;
import static entity.PersonFacade.persons;
import java.util.ArrayList;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Consumes;
import javax.ws.rs.DefaultValue;
import javax.ws.rs.Produces;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PUT;
import javax.ws.rs.PathParam;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import jsonmessages.JSONMessage;
import jsonmessages.PersonMessage;


@Path("person")
public class RestPerson {

    Gson gson = new Gson();
    PersonFacade pf = new PersonFacade();
    
    @Context
    private UriInfo context;


    public RestPerson() {
    }


    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public String getJson() {
        
         ArrayList<JSONMessage> messages = new ArrayList<>();
        
        for(Person p : PersonFacade.persons.values()){
            messages.add(new PersonMessage(p));
        }
        
        return gson.toJson(messages);
        
    }

    @Path("/{id}")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public String getSpecificJson(@PathParam("id") Integer id) {
       
       Person p = PersonFacade.persons.get(id);
       System.out.println(p);
       return  gson.toJson(p);
    }
    
    
    @Path("p/{id}")
    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public String putJson(String json, @PathParam("id") int id) {
        
        System.out.println("conent: " + json);
        
        System.out.println("ContextPathParameters: " + context.getPathParameters());
        
        Person p = new Gson().fromJson(json, Person.class);
        System.out.println(p);
        
        pf.createPerson(p);
        System.out.println(p);
        
        System.out.println("PersonJavaObject: " + p);
        
        return new Gson().toJson(p);
        
    }
}
