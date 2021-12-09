package org.eniso.oussama.resources;

import org.eclipse.microprofile.rest.client.inject.RestClient;
import org.eniso.oussama.models.Equipment;
import org.eniso.oussama.services.EquipmentRemoteService;
import org.jboss.resteasy.annotations.jaxrs.PathParam;

import javax.inject.Inject;
import javax.ws.rs.*;
import java.util.List;

@Path("/equipments")
public class EquipmentsResource {

    @Inject
    @RestClient
    EquipmentRemoteService equipmentRemoteService;

    @GET
    public List<Equipment> getEquipments(){
        return equipmentRemoteService.getEquipments();
    };

    @GET
    @Path("/{id}")
    public Equipment getEquipment(@PathParam long id){
        return equipmentRemoteService.getEquipment(id);
    };

    @POST
    public Equipment createEquipment(Equipment equipment){
        return equipmentRemoteService.createEquipment(equipment);
    };

    @PUT
    @Path("/{id}")
    public Equipment updateEquipment(@PathParam long id){
        return equipmentRemoteService.updateEquipment(id);
    };

    @DELETE
    @Path("/{id}")
    public Equipment deleteEquipment(@PathParam long id){
        return equipmentRemoteService.deleteEquipment(id);
    };

}
