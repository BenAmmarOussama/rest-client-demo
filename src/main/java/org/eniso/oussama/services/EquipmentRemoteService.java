package org.eniso.oussama.services;

import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;
import org.eniso.oussama.models.Equipment;
import org.jboss.resteasy.annotations.jaxrs.PathParam;

import javax.ws.rs.*;
import java.util.List;

@Path("/equipments")
@RegisterRestClient(configKey = "crud-api")
public interface EquipmentRemoteService {

    @GET
    List<Equipment> getEquipments();

    @GET
    @Path("/{id}")
    Equipment getEquipment(@PathParam long id);

    @POST
    Equipment createEquipment(Equipment equipment);

    @PUT
    @Path("/{id}")
    Equipment updateEquipment(@PathParam long id);

    @DELETE
    @Path("/{id}")
    Equipment deleteEquipment(@PathParam long id);

}
