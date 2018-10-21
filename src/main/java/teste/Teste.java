package teste;

import java.util.ArrayList;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import dao.PessoaFisicaDAO;
import model.Pessoa;
import model.PessoaFisica;

public class Teste {

	public static void main(String[] args) {
		/*//teste de inserção de pessoa
		createPessoaFisica();
		
		//busca pessoa por id
		PessoaFisica pessoaFisisca = new PessoaFisicaDAO().buscarPessoaPorID((long) 2);
		
		//Lista todas pessoas
		listagemPessoaFisica();
		
		//teste de update de pessoa fisica
		pessoaFisisca.getPessoa().setEmail("teste123456@gmail.com");
		updatePessoaFisica(pessoaFisisca);
		listagemPessoaFisica();
		
		//testa exclusão de pessoa
		new PessoaFisicaDAO().removePessoaFisica(new PessoaFisicaDAO().buscarPessoaPorID((long) 2));
		listagemPessoaFisica();*/
		
		
	}
	
	
	
	
	
	
	
	
	
	public static void updatePessoaFisica(PessoaFisica p1) {
		new PessoaFisicaDAO().UpdatePessoa(p1);
	}
	
	public static void createPessoaFisica() {
		PessoaFisica p1 = new PessoaFisica();
		p1.setCpf("06762256910");

		Pessoa pessoa = new Pessoa();
		pessoa.setEmail("teste@gmail.com");
		pessoa.setNome("teste");
		pessoa.setTelefone("456123456");
		
		p1.setPessoa(pessoa);
		
		new PessoaFisicaDAO().SalvarPessoa(p1);
	}
	
	public static void listagemPessoaFisica() {
		ArrayList<PessoaFisica> p1 = new ArrayList<>();
		p1 = new PessoaFisicaDAO().buscarTodasPessoasFisicas();
		
		for (PessoaFisica pessoaFisica : p1) {
			System.out.println(pessoaFisica.getPessoa().getEmail());
		}
	}

}
