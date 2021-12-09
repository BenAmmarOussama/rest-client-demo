package org.eniso.oussama.resources;

import org.eclipse.microprofile.rest.client.inject.RestClient;
import org.eniso.oussama.models.User;
import org.eniso.oussama.services.UsersRemoteService;
import org.jboss.resteasy.annotations.jaxrs.PathParam;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import java.util.List;

@Path("/users")
public class UsersResource {

    @Inject
    @RestClient
    UsersRemoteService usersRemoteService;

    @GET
    public List<User> getUsers(){
        return usersRemoteService.getUsers();
    };

    @GET
    @Path("/{id}")
    public User getUser(@PathParam long id){
        return usersRemoteService.getUser(id);
    };

    @POST
    @Path("/technician")
    public User addTechnician(User user){
        return usersRemoteService.addTechnician(user);
    };

}
