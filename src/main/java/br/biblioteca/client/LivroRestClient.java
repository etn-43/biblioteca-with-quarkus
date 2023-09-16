package br.biblioteca.client;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;

import java.util.List;

@Path("/api")
@RegisterRestClient
public interface LivroRestClient {

    @Path("/livros")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Livro> obterLivros();


}
