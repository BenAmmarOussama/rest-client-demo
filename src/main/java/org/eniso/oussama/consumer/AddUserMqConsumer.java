package org.eniso.oussama.consumer;

import io.vertx.core.json.JsonObject;
import org.eclipse.microprofile.reactive.messaging.Channel;
import org.eclipse.microprofile.reactive.messaging.Emitter;
import org.eclipse.microprofile.reactive.messaging.Incoming;
import org.eclipse.microprofile.rest.client.inject.RestClient;
import org.eniso.oussama.models.User;
import org.eniso.oussama.services.UsersRemoteService;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;

@ApplicationScoped
public class AddUserMqConsumer {

    @Channel("spring-quarkus-out")
    Emitter<String> enableAccountMqEmitter;

    @Inject
    @RestClient
    UsersRemoteService usersRemoteService;

    @Incoming("spring-quarkus-in")
    public void consume(JsonObject m){
        User user = m.mapTo(User.class);

        try {
            // If Student, add user to DB then put id in queue to enable his account
            if(user.getRole().equals("STUDENT")){
                User newUser = usersRemoteService.addUser(user);
                System.out.println(">>>>> This is a STUDENT with ID " + user.getId());
                enableAccountMqEmitter.send(user.getId());
            }

            // If Technician, check if user exists in DB, if Yes put id in queue
            // to enable his account
            if (user.getRole().equals("TECHNICIAN")){
                if(usersRemoteService.getUser(user.getId()) != null){
                    enableAccountMqEmitter.send(user.getId());
                }
            }
        } catch (Exception e){
            e.printStackTrace();
        }

        // enableAccountMqEmitter.send(user.getId());

        System.out.println(">>> received user= " + user);

    }
}
