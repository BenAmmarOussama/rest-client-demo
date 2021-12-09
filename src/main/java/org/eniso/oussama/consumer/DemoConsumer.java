package org.eniso.oussama.consumer;

import org.eclipse.microprofile.reactive.messaging.Incoming;

import javax.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class DemoConsumer {

    @Incoming("demo-in")
    public void consume(String message){
        System.out.println(">>>   "+message);
    }
}
