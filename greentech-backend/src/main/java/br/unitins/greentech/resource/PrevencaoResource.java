package br.unitins.greentech.resource;

import java.util.List;

import org.jboss.logging.Logger;

import br.unitins.greentech.dto.PrevencaoDTO;
import br.unitins.greentech.model.Prevencao;
import br.unitins.greentech.service.PrevencaoService;
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

@Path("/prevencoes")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class PrevencaoResource {
    
    @Inject
    PrevencaoService prevencaoService;

    private static final Logger LOG = Logger.getLogger(PrevencaoResource.class);

    @GET
    public List<Prevencao> getAll() {
        LOG.info("Buscando todos as prevencaos.");
        LOG.debug("ERRO DE DEBUG.");
        return prevencaoService.getAll();
    }

    @GET
    @Path("/paginado")
    public List<Prevencao> getAll(
                            @QueryParam("page") @DefaultValue("0") int page,
                            @QueryParam("pageSize") @DefaultValue("10") int pageSize) {
        LOG.infof("Buscando todas as prevencaos");
        LOG.debug("ERRO DE DEBUG.");

        try {
            return prevencaoService.getAll(page, pageSize);
        } catch (Exception e) {

            LOG.error(e);

            return null;
        }
    }

    @GET
    @Path("/{id}")
    public Prevencao getById(@PathParam("id") Long id) throws NotFoundException {
        LOG.info("Buscando prevencao por ID: " + id);
        LOG.debug("ERRO DE DEBUG.");
        return prevencaoService.getById(id);
    }

    @POST
    public Response insert(PrevencaoDTO prevencaoDTO) {
        
        LOG.infof("Inserindo uma prevencao: %s", prevencaoDTO.nome());

        Prevencao prevencao = prevencaoService.insert(prevencaoDTO);

        LOG.infof("prevencao (%d) criado com sucesso.", prevencao.getId());

        return Response.status(Status.CREATED).entity(prevencao).build();
    }

    @PUT
    @Path("/{id}")
    public Response update(@PathParam("id") Long id, PrevencaoDTO prevencaoDTO) {
        
        prevencaoService.update(id, prevencaoDTO);
        LOG.infof("prevencao (%d) atualizado com sucesso.", id);
        return Response
                .status(Status.NO_CONTENT) // 204
                .build();
    }

    @DELETE
    @Path("/{id}")
    public Response delete(@PathParam("id") Long id) throws IllegalArgumentException, NotFoundException {

        try {
            prevencaoService.delete(id);
            LOG.infof("prevencao (%d) excluído com sucesso.", id);
            return Response
                    .status(Status.NO_CONTENT)
                    .build();
        } catch (IllegalArgumentException e) {
            LOG.error("Erro ao deletar prevencao: parâmetros inválidos.", e);
            throw e;
        } catch (NotFoundException e) {
            LOG.errorf("prevencao (%d) não encontrado.", id);
            throw e;
        }
    }

    @GET
    @Path("/search/{nome}")
    public List<Prevencao> search(
            @PathParam("nome") String nome,
            @QueryParam("page") @DefaultValue("0") int page,
            @QueryParam("pageSize") @DefaultValue("10") int pageSize) {
                
        return prevencaoService.getByNome(nome, page, pageSize);
    }

    @GET
    @Path("/count")
    public long count(){

        return prevencaoService.count();
    }

    @GET
    @Path("/search/{nome}/count")
    public long count(@PathParam("nome") String nome){

        return prevencaoService.countByNome(nome);
    }
}
