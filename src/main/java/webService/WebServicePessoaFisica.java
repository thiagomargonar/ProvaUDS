package webService;

import java.util.ArrayList;

import javax.ws.rs.GET;
import javax.ws.rs.HeaderParam;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

import dao.PessoaFisicaDAO;
import model.Pessoa;
import model.PessoaFisica;

@Path("/pessoa")
public class WebServicePessoaFisica {

	@GET
	@Path("/listaPessoasFisica")
	@Produces(MediaType.APPLICATION_JSON)
	public String buscarTodasPessoasFisica() {
		ArrayList<PessoaFisica> pessoas = new ArrayList<>();
		pessoas = new PessoaFisicaDAO().buscarTodasPessoasFisicas();
		JsonArray jarray = new JsonArray();
		for (PessoaFisica pessoa : pessoas) {
			JsonObject j = new JsonObject();
			j.addProperty("id", pessoa.getId());
			j.addProperty("nome", pessoa.getPessoa().getNome());
			j.addProperty("email", pessoa.getPessoa().getEmail());
			j.addProperty("telefone", pessoa.getPessoa().getTelefone());
			j.addProperty("cpf", pessoa.getCpf());
			jarray.add(j);
		}
		return jarray.toString();
	}

	@GET
	@Path("/pessoaFisica")
	@Produces(MediaType.APPLICATION_JSON)
	public String buscarPessoaFisicaPorID(@HeaderParam("id") long id) {
		PessoaFisica pessoa = new PessoaFisicaDAO().buscarPessoaPorID(id);
		JsonObject j = new JsonObject();
		j.addProperty("id", pessoa.getId());
		j.addProperty("nome", pessoa.getPessoa().getNome());
		j.addProperty("email", pessoa.getPessoa().getEmail());
		j.addProperty("telefone", pessoa.getPessoa().getTelefone());
		j.addProperty("cpf", pessoa.getCpf());
		return j.toString();
	}
	
	@POST
	@Path("/adicionarPessoaFisica")
	@Produces(MediaType.APPLICATION_JSON)
	public Response adicionarPessoaFisica(@HeaderParam("nome") String nome,
			@HeaderParam("email") String email,
			@HeaderParam("telefone") String telefone,
			@HeaderParam("cpf") String cpf) {
		
		PessoaFisica pessoa = new PessoaFisica();
		Pessoa p1 = new Pessoa();
		
		pessoa.setCpf(cpf);
		p1.setEmail(email);
		p1.setNome(nome);
		p1.setTelefone(telefone);
		
		pessoa.setPessoa(p1);
		
		try {
			new PessoaFisicaDAO().SalvarPessoa(pessoa);
			
			return Response.status(200)
			.entity("Pessoa Fisica Adicionada")
			.build();
		} catch (Exception e) {
			return Response.status(401)
					.entity("Problema em remover: "+e.getMessage())
					.build();
		}
	}
	
	
	@POST
	@Path("/removerPessoaFisica")
	@Produces(MediaType.APPLICATION_JSON)
	public Response removerPessoaFisicaPorId(@HeaderParam("id") long id){
		
		PessoaFisica pessoa = new PessoaFisicaDAO().buscarPessoaPorID(id);
		
		try {
			new PessoaFisicaDAO().removePessoaFisica(pessoa);
			return Response.status(200)
			.entity("Pessoa Fisica Removida")
			.build();
		} catch (Exception e) {
			return Response.status(401)
					.entity("Problema em remover: "+e.getMessage())
					.build();
		}
	}

}
