package org.eniso.pmfwk.resources;

import org.eclipse.microprofile.rest.client.inject.RestClient;
import org.eniso.pmfwk.models.Equipment;
import org.eniso.pmfwk.services.EquipmentRemoteService;
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
    public Equipment getEquipment(@PathParam int id){
        return equipmentRemoteService.getEquipment(id);
    };

    @POST
    public Equipment createEquipment(Equipment equipment){
        return equipmentRemoteService.createEquipment(equipment);
    };

    @PUT
    @Path("/{id}")
    public Equipment updateEquipment(@PathParam int id){
        return equipmentRemoteService.updateEquipment(id);
    };

    @DELETE
    @Path("/{id}")
    public Equipment deleteEquipment(@PathParam int id){
        return equipmentRemoteService.deleteEquipment(id);
    };

}
