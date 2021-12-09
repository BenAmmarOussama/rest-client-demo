package org.eniso.oussama.consumer;

import io.vertx.core.json.JsonObject;
import org.eclipse.microprofile.reactive.messaging.Channel;
import org.eclipse.microprofile.reactive.messaging.Emitter;
import org.eclipse.microprofile.reactive.messaging.Incoming;
import org.eclipse.microprofile.rest.client.inject.RestClient;
import org.eniso.oussama.models.Message;
import org.eniso.oussama.models.User;
import org.eniso.oussama.services.EquipmentRemoteService;
import org.eniso.oussama.services.UsersRemoteService;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;

@ApplicationScoped
public class AddUserMqConsumer {

    @Channel("spring-quarkus-out")
    Emitter<Long> enableAccountMqEmitter;

    @Inject
    @RestClient
    UsersRemoteService usersRemoteService;

    @Incoming("spring-quarkus-in")
    public void consume(JsonObject m){
        User user = m.mapTo(User.class);

        // If Student, add user to DB then put id in queue to enable his account
        if(user.getRole().equals("STUDENT")){
            usersRemoteService.addStudent(user);
            enableAccountMqEmitter.send(user.getId());
        }

        // If Technician, check if user exists in DB, if Yes put id in queue
        // to enable his account
        if (user.getRole().equals("TECHNICIAN")){
            if(usersRemoteService.getUser(user.getId()) != null){
                enableAccountMqEmitter.send(user.getId());
            }
        }

    }
}
