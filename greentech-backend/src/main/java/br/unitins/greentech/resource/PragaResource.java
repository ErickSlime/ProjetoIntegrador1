package br.unitins.greentech.resource;

import java.util.List;

import org.jboss.logging.Logger;

import br.unitins.greentech.dto.PragaDTO;
import br.unitins.greentech.model.Praga;
import br.unitins.greentech.service.PragaService;
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

@Path("/pragas")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class PragaResource {
    
    @Inject
    PragaService pragaService;

    private static final Logger LOG = Logger.getLogger(PragaResource.class);

    @GET
    public List<Praga> getAll() {
        LOG.info("Buscando todos as pragas.");
        LOG.debug("ERRO DE DEBUG.");
        return pragaService.getAll();
    }

    @GET
    @Path("/paginado")
    public List<Praga> getAll(
                            @QueryParam("page") @DefaultValue("0") int page,
                            @QueryParam("pageSize") @DefaultValue("10") int pageSize) {
        LOG.infof("Buscando todas as pragas");
        LOG.debug("ERRO DE DEBUG.");

        try {
            return pragaService.getAll(page, pageSize);
        } catch (Exception e) {

            LOG.error(e);

            return null;
        }
    }

    @GET
    @Path("/{id}")
    public Praga getById(@PathParam("id") Long id) throws NotFoundException {
        LOG.info("Buscando praga por ID: " + id);
        LOG.debug("ERRO DE DEBUG.");
        return pragaService.getById(id);
    }

    @POST
    public Response insert(PragaDTO pragaDTO) {
        
        LOG.infof("Inserindo uma praga: %s", pragaDTO.nome());

        Praga praga = pragaService.insert(pragaDTO);

        LOG.infof("praga (%d) criado com sucesso.", praga.getId());

        return Response.status(Status.CREATED).entity(praga).build();
    }

    @PUT
    @Path("/{id}")
    public Response update(@PathParam("id") Long id, PragaDTO pragaDTO) {
        
        pragaService.update(id, pragaDTO);
        LOG.infof("praga (%d) atualizado com sucesso.", id);
        return Response
                .status(Status.NO_CONTENT) // 204
                .build();
    }

    @DELETE
    @Path("/{id}")
    public Response delete(@PathParam("id") Long id) throws IllegalArgumentException, NotFoundException {

        try {
            pragaService.delete(id);
            LOG.infof("praga (%d) excluído com sucesso.", id);
            return Response
                    .status(Status.NO_CONTENT)
                    .build();
        } catch (IllegalArgumentException e) {
            LOG.error("Erro ao deletar praga: parâmetros inválidos.", e);
            throw e;
        } catch (NotFoundException e) {
            LOG.errorf("praga (%d) não encontrado.", id);
            throw e;
        }
    }

    @GET
    @Path("/search/{nome}")
    public List<Praga> search(
            @PathParam("nome") String nome,
            @QueryParam("page") @DefaultValue("0") int page,
            @QueryParam("pageSize") @DefaultValue("10") int pageSize) {
                
        return pragaService.getByNome(nome, page, pageSize);
    }

    @GET
    @Path("/count")
    public long count(){

        return pragaService.count();
    }

    @GET
    @Path("/search/{nome}/count")
    public long count(@PathParam("nome") String nome){

        return pragaService.countByNome(nome);
    }
}
