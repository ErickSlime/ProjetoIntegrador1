package br.unitins.greentech.resource;

import java.util.List;

import org.jboss.logging.Logger;

import br.unitins.greentech.dto.DicaDTO;
import br.unitins.greentech.dto.DicaResponseDTO;
import br.unitins.greentech.model.Dica;
import br.unitins.greentech.service.DicaService;
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

@Path("/dicas")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class DicaResource {
    
    @Inject
    DicaService dicaService;

    private static final Logger LOG = Logger.getLogger(DicaResource.class);

    @GET
    public List<Dica> getAll() {
        LOG.info("Buscando todos as dicas.");
        LOG.debug("ERRO DE DEBUG.");
        return dicaService.getAll();
    }

    @GET
    @Path("/paginado")
    public List<Dica> getAll(
                            @QueryParam("page") @DefaultValue("0") int page,
                            @QueryParam("pageSize") @DefaultValue("10") int pageSize) {
        LOG.infof("Buscando todas as dicas");
        LOG.debug("ERRO DE DEBUG.");

        try {
            return dicaService.getAll(page, pageSize);
        } catch (Exception e) {

            LOG.error(e);

            return null;
        }
    }

    @GET
    @Path("/{id}")
    public Dica getById(@PathParam("id") Long id) throws NotFoundException {
        LOG.info("Buscando dica por ID: " + id);
        LOG.debug("ERRO DE DEBUG.");
        return dicaService.getById(id);
    }

    @POST
    public Response insert(DicaDTO dicaDTO) {
        
        LOG.infof("Inserindo uma dica: %s", dicaDTO.nome());

        DicaResponseDTO dica = dicaService.insert(dicaDTO);

        LOG.infof("dica (%d) criado com sucesso.", dica.id());

        return Response.status(Status.CREATED).entity(dica).build();
    }

    @PUT
    @Path("/{id}")
    public Response update(@PathParam("id") Long id, DicaDTO dicaDTO) {
        
        dicaService.update(id, dicaDTO);
        LOG.infof("dica (%d) atualizado com sucesso.", id);
        return Response
                .status(Status.NO_CONTENT) // 204
                .build();
    }

    @DELETE
    @Path("/{id}")
    public Response delete(@PathParam("id") Long id) throws IllegalArgumentException, NotFoundException {

        try {
            dicaService.delete(id);
            LOG.infof("dica (%d) excluído com sucesso.", id);
            return Response
                    .status(Status.NO_CONTENT)
                    .build();
        } catch (IllegalArgumentException e) {
            LOG.error("Erro ao deletar dica: parâmetros inválidos.", e);
            throw e;
        } catch (NotFoundException e) {
            LOG.errorf("dica (%d) não encontrado.", id);
            throw e;
        }
    }

    @GET
    @Path("/search/{nome}")
    public List<Dica> search(
            @PathParam("nome") String nome,
            @QueryParam("page") @DefaultValue("0") int page,
            @QueryParam("pageSize") @DefaultValue("10") int pageSize) {
                
        return dicaService.getByNome(nome, page, pageSize);
    }

    @GET
    @Path("/count")
    public long count(){

        return dicaService.count();
    }

    @GET
    @Path("/search/{nome}/count")
    public long count(@PathParam("nome") String nome){

        return dicaService.countByNome(nome);
    }
}
