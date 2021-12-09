package org.eniso.oussama.producer;

import org.eclipse.microprofile.reactive.messaging.Channel;
import org.eclipse.microprofile.reactive.messaging.Emitter;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/demo")
public class DemoResource {


    @Channel("demo-requests")
    Emitter<String> demoEmitter;

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String sendToMq(){
        demoEmitter.send("This is a demo message");
        return "Demo resource works!";
    }


}
