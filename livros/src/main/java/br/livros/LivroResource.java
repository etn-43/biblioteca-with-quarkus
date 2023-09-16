package br.livros;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;

import java.util.List;

@Path("/api")
@ApplicationScoped
public class LivroResource {
    @Inject
    LivroService livroService;

    @Path("/livros")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Livro> obterLivros(){
        return  livroService.obterLivros();
    }

    @Path("/livro")
    @PUT
    @Produces(MediaType.APPLICATION_JSON)
    public String atualizarLivro(Livro l){
        return livroService.atualizarLivro(l);
    }


}
