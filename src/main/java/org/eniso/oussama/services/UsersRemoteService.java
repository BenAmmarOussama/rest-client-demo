package org.eniso.oussama.services;

import org.eclipse.microprofile.rest.client.annotation.RegisterProvider;
import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;
import org.eniso.oussama.ExceptionHandler.MyExceptionMapper;
import org.eniso.oussama.models.User;
import org.jboss.resteasy.annotations.jaxrs.PathParam;

import javax.enterprise.context.ApplicationScoped;
import javax.ws.rs.*;
import java.util.List;

@Path("/users")
@RegisterProvider(MyExceptionMapper.class)
@RegisterRestClient(configKey = "crud-api")
public interface UsersRemoteService {

    @GET
    List<User> getUsers();

    @GET
    @Path("/{id}")
    User getUser(@PathParam String id);

    @POST
    User addUser(User user);

}
