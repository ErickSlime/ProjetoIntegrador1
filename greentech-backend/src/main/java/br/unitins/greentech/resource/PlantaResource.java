package br.unitins.greentech.resource;

import java.util.List;

import org.jboss.logging.Logger;

import br.unitins.greentech.dto.PlantaDTO;
import br.unitins.greentech.model.Planta;
import br.unitins.greentech.service.PlantaService;
import jakarta.inject.Inject;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.DefaultValue;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.NotFoundException;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.PUT;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.QueryParam;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.core.Response.Status;

@Path("/plantas")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class PlantaResource {
    
    @Inject
    PlantaService plantaService;

    private static final Logger LOG = Logger.getLogger(PlantaResource.class);

    @GET
    public List<Planta> getAll() {
        LOG.info("Buscando todos as plantas.");
        LOG.debug("ERRO DE DEBUG.");
        return plantaService.getAll();
    }

    @GET
    @Path("/paginado")
    public List<Planta> getAll(
                            @QueryParam("page") @DefaultValue("0") int page,
                            @QueryParam("pageSize") @DefaultValue("10") int pageSize) {
        LOG.infof("Buscando todas as plantas");
        LOG.debug("ERRO DE DEBUG.");

        try {
            return plantaService.getAll(page, pageSize);
        } catch (Exception e) {

            LOG.error(e);

            return null;
        }
    }

    @GET
    @Path("/{id}")
    public Planta getById(@PathParam("id") Long id) throws NotFoundException {
        LOG.info("Buscando planta por ID: " + id);
        LOG.debug("ERRO DE DEBUG.");
        return plantaService.getById(id);
    }

    @POST
    public Response insert(PlantaDTO plantaDTO) {
        
        LOG.infof("Inserindo uma planta: %s", plantaDTO.nome());

        Planta planta = plantaService.insert(plantaDTO);

        LOG.infof("planta (%d) criado com sucesso.", planta.getId());

        return Response.status(Status.CREATED).entity(planta).build();
    }

    @PUT
    @Path("/{id}")
    public Response update(@PathParam("id") Long id, PlantaDTO plantaDTO) {
        
        plantaService.update(id, plantaDTO);
        LOG.infof("planta (%d) atualizado com sucesso.", id);
        return Response
                .status(Status.NO_CONTENT) // 204
                .build();
    }

    @DELETE
    @Path("/{id}")
    public Response delete(@PathParam("id") Long id) throws IllegalArgumentException, NotFoundException {

        try {
            plantaService.delete(id);
            LOG.infof("planta (%d) excluído com sucesso.", id);
            return Response
                    .status(Status.NO_CONTENT)
                    .build();
        } catch (IllegalArgumentException e) {
            LOG.error("Erro ao deletar planta: parâmetros inválidos.", e);
            throw e;
        } catch (NotFoundException e) {
            LOG.errorf("planta (%d) não encontrado.", id);
            throw e;
        }
    }

    @GET
    @Path("/search/{nome}")
    public List<Planta> search(
            @PathParam("nome") String nome,
            @QueryParam("page") @DefaultValue("0") int page,
            @QueryParam("pageSize") @DefaultValue("10") int pageSize) {
                
        return plantaService.getByNome(nome, page, pageSize);
    }

    @GET
    @Path("/count")
    public long count(){

        return plantaService.count();
    }

    @GET
    @Path("/search/{nome}/count")
    public long count(@PathParam("nome") String nome){

        return plantaService.countByNome(nome);
    }
}
