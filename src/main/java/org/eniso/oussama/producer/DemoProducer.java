package org.eniso.oussama.producer;

import org.eclipse.microprofile.reactive.messaging.Outgoing;
import org.eclipse.microprofile.reactive.streams.operators.PublisherBuilder;
import org.eclipse.microprofile.reactive.streams.operators.ReactiveStreams;

import javax.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class DemoProducer {

    @Outgoing("demo-out")
    public PublisherBuilder<String> send(){
        System.out.println("Sent to Queue");
        return ReactiveStreams.of("Hello World!!");
    }   

}
