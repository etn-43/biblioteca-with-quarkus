package br.biblioteca.client;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;

import java.util.List;

@Path("/api")
@RegisterRestClient
public interface LivroRestClient {
    @Path("/livros")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<LivroDto> obterLivros();

    @Path("/livro")
    @PUT
    @Produces(MediaType.APPLICATION_JSON)
    public String atualizarLivro(LivroDto l);


}
