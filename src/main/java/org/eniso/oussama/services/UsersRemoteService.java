package org.eniso.oussama.services;

import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;
import org.eniso.oussama.models.User;
import org.jboss.resteasy.annotations.jaxrs.PathParam;

import javax.ws.rs.*;
import java.util.List;

@Path("/users")
@RegisterRestClient(configKey = "crud-api")
public interface UsersRemoteService {

    @GET
    List<User> getUsers();

    @GET
    @Path("/{id}")
    User getUser(@PathParam long id);

    @POST
    @Path("/technician")
    User addTechnician(User user);

    @POST
    @Path("/student")
    User addStudent(User user);

}
