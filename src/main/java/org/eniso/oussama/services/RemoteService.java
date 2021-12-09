package org.eniso.oussama.services;

import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;
import org.eniso.oussama.models.Message;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;

@Path("/hello")
@RegisterRestClient(configKey = "nodejs-api")
public interface RemoteService {

    @GET
    Message getMessage();

    @POST
    void postMessage(Message message);
}
