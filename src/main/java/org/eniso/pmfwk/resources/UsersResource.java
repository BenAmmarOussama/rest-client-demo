package org.eniso.pmfwk.resources;

import org.eclipse.microprofile.rest.client.inject.RestClient;
import org.eniso.pmfwk.models.User;
import org.eniso.pmfwk.services.UsersRemoteService;
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
    public User getUser(@PathParam String id){
        return usersRemoteService.getUser(id);
    };

    @POST
    public User addUser(User user){
        return usersRemoteService.addUser(user);
    };

}
