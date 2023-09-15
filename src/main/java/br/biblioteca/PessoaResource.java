package br.biblioteca;

import jakarta.inject.Inject;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
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

    @Path("/pessoa")
    @POST
    @Produces(MediaType.APPLICATION_JSON)
    public Pessoa adicionarPessoa(Pessoa p){ return service.adicionar(p); }

}
