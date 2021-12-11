package org.eniso.oussama.services;

import org.eclipse.microprofile.rest.client.annotation.RegisterProvider;
import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;
import org.eniso.oussama.ExceptionHandler.MyExceptionMapper;
import org.eniso.oussama.models.Equipment;
import org.jboss.resteasy.annotations.jaxrs.PathParam;

import javax.ws.rs.*;
import java.util.List;

@Path("/equipments")
@RegisterProvider(MyExceptionMapper.class)
@RegisterRestClient(configKey = "crud-api")
public interface EquipmentRemoteService {

    @GET
    List<Equipment> getEquipments();

    @GET
    @Path("/{id}")
    Equipment getEquipment(@PathParam("id") int id);

    @POST
    Equipment createEquipment(Equipment equipment);

    @PUT
    @Path("/{id}")
    Equipment updateEquipment(@PathParam int id);

    @DELETE
    @Path("/{id}")
    Equipment deleteEquipment(@PathParam int id);

}
