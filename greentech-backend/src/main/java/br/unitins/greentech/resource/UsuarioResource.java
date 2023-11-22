package br.unitins.greentech.resource;

import java.util.List;

import org.jboss.logging.Logger;

import br.unitins.greentech.dto.UsuarioDTO;
import br.unitins.greentech.model.Usuario;
import br.unitins.greentech.service.UsuarioService;
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

@Path("/usuarios")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class UsuarioResource {
    
    @Inject
    UsuarioService usuarioService;

    private static final Logger LOG = Logger.getLogger(UsuarioResource.class);

    @GET
    public List<Usuario> getAll() {
        LOG.info("Buscando todos as usuarios.");
        LOG.debug("ERRO DE DEBUG.");
        return usuarioService.getAll();
    }

    @GET
    @Path("/paginado")
    public List<Usuario> getAll(
                            @QueryParam("page") @DefaultValue("0") int page,
                            @QueryParam("pageSize") @DefaultValue("10") int pageSize) {
        LOG.infof("Buscando todas as usuarios");
        LOG.debug("ERRO DE DEBUG.");

        try {
            return usuarioService.getAll(page, pageSize);
        } catch (Exception e) {

            LOG.error(e);

            return null;
        }
    }

    @GET
    @Path("/{id}")
    public Usuario getById(@PathParam("id") Long id) throws NotFoundException {
        LOG.info("Buscando usuario por ID: " + id);
        LOG.debug("ERRO DE DEBUG.");
        return usuarioService.getById(id);
    }

    @POST
    public Response insert(UsuarioDTO usuarioDTO) {
        
        LOG.infof("Inserindo uma usuario: %s", usuarioDTO.nome());

        Usuario usuario = usuarioService.insert(usuarioDTO);

        LOG.infof("usuario (%d) criado com sucesso.", usuario.getId());

        return Response.status(Status.CREATED).entity(usuario).build();
    }

    @PUT
    @Path("/{id}")
    public Response update(@PathParam("id") Long id, UsuarioDTO usuarioDTO) {
        
        usuarioService.update(id, usuarioDTO);
        LOG.infof("usuario (%d) atualizado com sucesso.", id);
        return Response
                .status(Status.NO_CONTENT) // 204
                .build();
    }

    @DELETE
    @Path("/{id}")
    public Response delete(@PathParam("id") Long id) throws IllegalArgumentException, NotFoundException {

        try {
            usuarioService.delete(id);
            LOG.infof("usuario (%d) excluído com sucesso.", id);
            return Response
                    .status(Status.NO_CONTENT)
                    .build();
        } catch (IllegalArgumentException e) {
            LOG.error("Erro ao deletar usuario: parâmetros inválidos.", e);
            throw e;
        } catch (NotFoundException e) {
            LOG.errorf("usuario (%d) não encontrado.", id);
            throw e;
        }
    }

    @GET
    @Path("/search/{nome}")
    public List<Usuario> search(
            @PathParam("nome") String nome,
            @QueryParam("page") @DefaultValue("0") int page,
            @QueryParam("pageSize") @DefaultValue("10") int pageSize) {
                
        return usuarioService.getByNome(nome, page, pageSize);
    }

    @GET
    @Path("/count")
    public long count(){

        return usuarioService.count();
    }

    @GET
    @Path("/search/{nome}/count")
    public long count(@PathParam("nome") String nome){

        return usuarioService.countByNome(nome);
    }
}
