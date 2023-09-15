package br.biblioteca;

import jakarta.inject.Inject;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;

import java.util.List;

@Path("/api")
public class PessoaResource {
    @Inject
    PessoaService service;

    @Path("/pessoas")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Pessoa> obterPessoas(){ return service.obter(); }

}
