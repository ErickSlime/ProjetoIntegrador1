package br.unitins.greentech.resource;

import java.util.List;

import org.jboss.logging.Logger;

import br.unitins.greentech.dto.VideoDTO;
import br.unitins.greentech.model.Video;
import br.unitins.greentech.service.VideoService;
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

@Path("/videos")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class VideoResource {
    
    @Inject
    VideoService videoService;

    private static final Logger LOG = Logger.getLogger(VideoResource.class);

    @GET
    public List<Video> getAll() {
        LOG.info("Buscando todos as videos.");
        LOG.debug("ERRO DE DEBUG.");
        return videoService.getAll();
    }

    @GET
    @Path("/paginado")
    public List<Video> getAll(
                            @QueryParam("page") @DefaultValue("0") int page,
                            @QueryParam("pageSize") @DefaultValue("10") int pageSize) {
        LOG.infof("Buscando todas as videos");
        LOG.debug("ERRO DE DEBUG.");

        try {
            return videoService.getAll(page, pageSize);
        } catch (Exception e) {

            LOG.error(e);

            return null;
        }
    }

    @GET
    @Path("/{id}")
    public Video getById(@PathParam("id") Long id) throws NotFoundException {
        LOG.info("Buscando video por ID: " + id);
        LOG.debug("ERRO DE DEBUG.");
        return videoService.getById(id);
    }

    @POST
    public Response insert(VideoDTO videoDTO) {
        
        LOG.infof("Inserindo uma video: %s", videoDTO.nome());

        Video video = videoService.insert(videoDTO);

        LOG.infof("video (%d) criado com sucesso.", video.getId());

        return Response.status(Status.CREATED).entity(video).build();
    }

    @PUT
    @Path("/{id}")
    public Response update(@PathParam("id") Long id, VideoDTO videoDTO) {
        
        videoService.update(id, videoDTO);
        LOG.infof("video (%d) atualizado com sucesso.", id);
        return Response
                .status(Status.NO_CONTENT) // 204
                .build();
    }

    @DELETE
    @Path("/{id}")
    public Response delete(@PathParam("id") Long id) throws IllegalArgumentException, NotFoundException {

        try {
            videoService.delete(id);
            LOG.infof("video (%d) excluído com sucesso.", id);
            return Response
                    .status(Status.NO_CONTENT)
                    .build();
        } catch (IllegalArgumentException e) {
            LOG.error("Erro ao deletar video: parâmetros inválidos.", e);
            throw e;
        } catch (NotFoundException e) {
            LOG.errorf("video (%d) não encontrado.", id);
            throw e;
        }
    }

    @GET
    @Path("/search/{nome}")
    public List<Video> search(
            @PathParam("nome") String nome,
            @QueryParam("page") @DefaultValue("0") int page,
            @QueryParam("pageSize") @DefaultValue("10") int pageSize) {
                
        return videoService.getByNome(nome, page, pageSize);
    }

    @GET
    @Path("/count")
    public long count(){

        return videoService.count();
    }

    @GET
    @Path("/search/{nome}/count")
    public long count(@PathParam("nome") String nome){

        return videoService.countByNome(nome);
    }
}
