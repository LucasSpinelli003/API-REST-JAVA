package br.com.fiap.solutech.resource;

import java.sql.SQLException;
import java.util.List;

import br.com.fiap.solutech.exception.BadInfoException;
import br.com.fiap.solutech.exception.IdNotFoundException;
import br.com.fiap.solutech.model.Segurado;
import br.com.fiap.solutech.service.SeguradoService;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.PUT;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.QueryParam;
import jakarta.ws.rs.core.Context;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.core.Response.Status;
import jakarta.ws.rs.core.UriBuilder;
import jakarta.ws.rs.core.UriInfo;

@Path("/segurado") //http://localhost:8080/Solutech/api/segurado
public class SeguradoResource {

	private SeguradoService service;
	
	public SeguradoResource() throws ClassNotFoundException, SQLException {
		service = new SeguradoService();
	}
	
	//GET //http://localhost:8080/Solutech/api/segurado/query?nome=aaa(Pesquisar por nome)
	@GET
	@Path("/query")
	@Produces(MediaType.APPLICATION_JSON)
	public List<Segurado> pesquisar(@QueryParam("nome") String pesquisa) throws SQLException{
		return service.pesquisarPorNome(pesquisa);
	}
	
	//GET //http://localhost:8080/Solutech/api/segurado (Listar todos os produtos)
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<Segurado> lista() throws ClassNotFoundException, SQLException {
		return service.listar();
	}
	
	//GET //http://localhost:8080/Solutech/api/segurado/1 (Pesquisar pelo Id)
	@GET
	@Path("/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response busca(@PathParam("id") int id) throws ClassNotFoundException, SQLException {
		try {
			return Response.ok(service.pesquisar(id)).build();
		} catch (IdNotFoundException e) {
			return Response.status(Status.NOT_FOUND).build();
		}
	}
	
	//POST //http://localhost:8080/Solutech/api/segurado/ (Cadastrar um produto)
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	public Response cadastrar(Segurado segurado, @Context UriInfo uri) throws ClassNotFoundException, SQLException {
		try {
			service.cadastrar(segurado);
			UriBuilder uriBuilder = uri.getAbsolutePathBuilder();
			uriBuilder.path(String.valueOf(segurado.getId()));
			return Response.created(uriBuilder.build()).build();
		} catch (BadInfoException e) {
			e.printStackTrace();
			return Response.status(Status.BAD_REQUEST)
								.entity(e.getMessage()).build();
		}
	}

	
	//PUT http://localhost:8080/Solutech/api/segurado/1 (Atualizar um produto)
	@PUT
	@Path("/{id}")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response atualizar(Segurado segurado, @PathParam("id") int id) throws ClassNotFoundException, SQLException {
		try {
			segurado.setId(id);
			service.atualizar(segurado);
			return Response.ok().build();
		} catch (IdNotFoundException e) {
			return Response.status(Status.NOT_FOUND).build();
		} catch (BadInfoException e) {
			return Response.status(Status.BAD_REQUEST).entity(e.getMessage()).build();
		}
	}
	
	//DELETE http://localhost:8080/Solutech/api/segurado/1 (Apagar um produto)
	@DELETE
	@Path("/{id}")
	public Response remover(@PathParam("id") int id) throws ClassNotFoundException, SQLException {
		try {
			service.remover(id);
			return Response.noContent().build();
		} catch (IdNotFoundException e) {
			return Response.status(Status.NOT_FOUND).build();
		}
	}
	
}





