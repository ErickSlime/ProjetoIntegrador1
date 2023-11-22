package br.unitins.greentech.resource;

import java.util.List;

import org.jboss.logging.Logger;

import br.unitins.greentech.dto.FamiliaDTO;
import br.unitins.greentech.model.Familia;
import br.unitins.greentech.service.FamiliaService;
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

@Path("/familias")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class FamiliaResource {
    
    @Inject
    FamiliaService familiaService;

    private static final Logger LOG = Logger.getLogger(FamiliaResource.class);

    @GET
    public List<Familia> getAll() {
        LOG.info("Buscando todos as familias.");
        LOG.debug("ERRO DE DEBUG.");
        return familiaService.getAll();
    }

    @GET
    @Path("/paginado")
    public List<Familia> getAll(
                            @QueryParam("page") @DefaultValue("0") int page,
                            @QueryParam("pageSize") @DefaultValue("10") int pageSize) {
        LOG.infof("Buscando todas as familias");
        LOG.debug("ERRO DE DEBUG.");

        try {
            return familiaService.getAll(page, pageSize);
        } catch (Exception e) {

            LOG.error(e);

            return null;
        }
    }

    @GET
    @Path("/{id}")
    public Familia getById(@PathParam("id") Long id) throws NotFoundException {
        LOG.info("Buscando familia por ID: " + id);
        LOG.debug("ERRO DE DEBUG.");
        return familiaService.getById(id);
    }

    @POST
    public Response insert(FamiliaDTO familiaDTO) {
        
        LOG.infof("Inserindo uma familia: %s", familiaDTO.nome());

        Familia familia = familiaService.insert(familiaDTO);

        LOG.infof("familia (%d) criado com sucesso.", familia.getId());

        return Response.status(Status.CREATED).entity(familia).build();
    }

    @PUT
    @Path("/{id}")
    public Response update(@PathParam("id") Long id, FamiliaDTO familiaDTO) {
        
        familiaService.update(id, familiaDTO);
        LOG.infof("familia (%d) atualizado com sucesso.", id);
        return Response
                .status(Status.NO_CONTENT) // 204
                .build();
    }

    @DELETE
    @Path("/{id}")
    public Response delete(@PathParam("id") Long id) throws IllegalArgumentException, NotFoundException {

        try {
            familiaService.delete(id);
            LOG.infof("familia (%d) excluído com sucesso.", id);
            return Response
                    .status(Status.NO_CONTENT)
                    .build();
        } catch (IllegalArgumentException e) {
            LOG.error("Erro ao deletar familia: parâmetros inválidos.", e);
            throw e;
        } catch (NotFoundException e) {
            LOG.errorf("familia (%d) não encontrado.", id);
            throw e;
        }
    }

    @GET
    @Path("/search/{nome}")
    public List<Familia> search(
            @PathParam("nome") String nome,
            @QueryParam("page") @DefaultValue("0") int page,
            @QueryParam("pageSize") @DefaultValue("10") int pageSize) {
                
        return familiaService.getByNome(nome, page, pageSize);
    }

    @GET
    @Path("/count")
    public long count(){

        return familiaService.count();
    }

    @GET
    @Path("/search/{nome}/count")
    public long count(@PathParam("nome") String nome){

        return familiaService.countByNome(nome);
    }
}
