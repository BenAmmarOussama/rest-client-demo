package org.eniso.oussama.resources;

import org.eclipse.microprofile.rest.client.inject.RestClient;
import org.eniso.oussama.models.Message;
import org.eniso.oussama.services.RemoteService;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;

@Path("/remote")
public class RemoteResource {

    @Inject
    @RestClient
    RemoteService remoteService;

    @GET
    public Message getMessage(){
        return remoteService.getMessage();
    }

    @POST
    public Message postMessage(Message message){
        try{
            remoteService.postMessage(message);
            return new Message("Message sent successfully");
        } catch (Exception e) {
            e.printStackTrace();
            return new Message("Error: " + e.getMessage());
        }
    }
}
