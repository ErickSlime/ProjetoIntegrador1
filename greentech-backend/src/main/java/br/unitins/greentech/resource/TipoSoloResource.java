package br.unitins.greentech.resource;

import java.util.List;

import org.jboss.logging.Logger;

import br.unitins.greentech.dto.TipoSoloDTO;
import br.unitins.greentech.model.TipoSolo;
import br.unitins.greentech.service.TipoSoloService;
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

@Path("/solos")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class TipoSoloResource {
   
    @Inject
    TipoSoloService tipoSoloService;

    private static final Logger LOG = Logger.getLogger(TipoSoloResource.class);

    @GET
    public List<TipoSolo> getAll() {
        LOG.info("Buscando todos as tipoSolos.");
        LOG.debug("ERRO DE DEBUG.");
        return tipoSoloService.getAll();
    }

    @GET
    @Path("/paginado")
    public List<TipoSolo> getAll(
                            @QueryParam("page") @DefaultValue("0") int page,
                            @QueryParam("pageSize") @DefaultValue("10") int pageSize) {
        LOG.infof("Buscando todas as tipoSolos");
        LOG.debug("ERRO DE DEBUG.");

        try {
            return tipoSoloService.getAll(page, pageSize);
        } catch (Exception e) {

            LOG.error(e);

            return null;
        }
    }

    @GET
    @Path("/{id}")
    public TipoSolo getById(@PathParam("id") Long id) throws NotFoundException {
        LOG.info("Buscando tipoSolo por ID: " + id);
        LOG.debug("ERRO DE DEBUG.");
        return tipoSoloService.getById(id);
    }

    @POST
    public Response insert(TipoSoloDTO tipoSoloDTO) {
        
        LOG.infof("Inserindo uma tipoSolo: %s", tipoSoloDTO.nome());

        TipoSolo tipoSolo = tipoSoloService.insert(tipoSoloDTO);

        LOG.infof("tipoSolo (%d) criado com sucesso.", tipoSolo.getId());

        return Response.status(Status.CREATED).entity(tipoSolo).build();
    }

    @PUT
    @Path("/{id}")
    public Response update(@PathParam("id") Long id, TipoSoloDTO tipoSoloDTO) {
        
        tipoSoloService.update(id, tipoSoloDTO);
        LOG.infof("tipoSolo (%d) atualizado com sucesso.", id);
        return Response
                .status(Status.NO_CONTENT) // 204
                .build();
    }

    @DELETE
    @Path("/{id}")
    public Response delete(@PathParam("id") Long id) throws IllegalArgumentException, NotFoundException {

        try {
            tipoSoloService.delete(id);
            LOG.infof("tipoSolo (%d) excluído com sucesso.", id);
            return Response
                    .status(Status.NO_CONTENT)
                    .build();
        } catch (IllegalArgumentException e) {
            LOG.error("Erro ao deletar tipoSolo: parâmetros inválidos.", e);
            throw e;
        } catch (NotFoundException e) {
            LOG.errorf("tipoSolo (%d) não encontrado.", id);
            throw e;
        }
    }

    @GET
    @Path("/search/{nome}")
    public List<TipoSolo> search(
            @PathParam("nome") String nome,
            @QueryParam("page") @DefaultValue("0") int page,
            @QueryParam("pageSize") @DefaultValue("10") int pageSize) {
                
        return tipoSoloService.getByNome(nome, page, pageSize);
    }

    @GET
    @Path("/count")
    public long count(){

        return tipoSoloService.count();
    }

    @GET
    @Path("/search/{nome}/count")
    public long count(@PathParam("nome") String nome){

        return tipoSoloService.countByNome(nome);
    }
}
