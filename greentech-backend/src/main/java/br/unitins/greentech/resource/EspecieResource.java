package br.unitins.greentech.resource;

import java.util.List;

import org.jboss.logging.Logger;

import br.unitins.greentech.dto.EspecieDTO;
import br.unitins.greentech.model.Especie;
import br.unitins.greentech.service.EspecieService;
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

@Path("/especies")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class EspecieResource {
    
    @Inject
    EspecieService especieService;

    private static final Logger LOG = Logger.getLogger(EspecieResource.class);

    @GET
    public List<Especie> getAll() {
        LOG.info("Buscando todos as especies.");
        LOG.debug("ERRO DE DEBUG.");
        return especieService.getAll();
    }

    @GET
    @Path("/paginado")
    public List<Especie> getAll(
                            @QueryParam("page") @DefaultValue("0") int page,
                            @QueryParam("pageSize") @DefaultValue("10") int pageSize) {
        LOG.infof("Buscando todas as especies");
        LOG.debug("ERRO DE DEBUG.");

        try {
            return especieService.getAll(page, pageSize);
        } catch (Exception e) {

            LOG.error(e);

            return null;
        }
    }

    @GET
    @Path("/{id}")
    public Especie getById(@PathParam("id") Long id) throws NotFoundException {
        LOG.info("Buscando especie por ID: " + id);
        LOG.debug("ERRO DE DEBUG.");
        return especieService.getById(id);
    }

    @POST
    public Response insert(EspecieDTO especieDTO) {
        
        LOG.infof("Inserindo uma especie: %s", especieDTO.nome());

        Especie especie = especieService.insert(especieDTO);

        LOG.infof("especie (%d) criado com sucesso.", especie.getId());

        return Response.status(Status.CREATED).entity(especie).build();
    }

    @PUT
    @Path("/{id}")
    public Response update(@PathParam("id") Long id, EspecieDTO especieDTO) {
        
        especieService.update(id, especieDTO);
        LOG.infof("especie (%d) atualizado com sucesso.", id);
        return Response
                .status(Status.NO_CONTENT) // 204
                .build();
    }

    @DELETE
    @Path("/{id}")
    public Response delete(@PathParam("id") Long id) throws IllegalArgumentException, NotFoundException {

        try {
            especieService.delete(id);
            LOG.infof("especie (%d) excluído com sucesso.", id);
            return Response
                    .status(Status.NO_CONTENT)
                    .build();
        } catch (IllegalArgumentException e) {
            LOG.error("Erro ao deletar especie: parâmetros inválidos.", e);
            throw e;
        } catch (NotFoundException e) {
            LOG.errorf("especie (%d) não encontrado.", id);
            throw e;
        }
    }

    @GET
    @Path("/search/{nome}")
    public List<Especie> search(
            @PathParam("nome") String nome,
            @QueryParam("page") @DefaultValue("0") int page,
            @QueryParam("pageSize") @DefaultValue("10") int pageSize) {
                
        return especieService.getByNome(nome, page, pageSize);
    }

    @GET
    @Path("/count")
    public long count(){

        return especieService.count();
    }

    @GET
    @Path("/search/{nome}/count")
    public long count(@PathParam("nome") String nome){

        return especieService.countByNome(nome);
    }
}
