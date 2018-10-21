package dao;

import java.io.Serializable;
import java.util.ArrayList;

import javax.persistence.EntityManager;

import Utilitarios.Utils;
import model.PessoaFisica;

public class PessoaFisicaDAO implements Serializable {
	
	private static final long serialVersionUID = 1L;

	public ArrayList<PessoaFisica> buscarTodasPessoasFisicas() {
		EntityManager entityTX = new Utils().getEntityManager();
		ArrayList<PessoaFisica> resultList = new ArrayList<>();
		try {
			resultList = (ArrayList<PessoaFisica>) entityTX.createQuery("from PessoaFisica")
					.getResultList();
		} catch (Exception e) {
			// TODO: handle exception
		} finally {
			entityTX.close();
			entityTX.getEntityManagerFactory().close();
		}

		return resultList;
	}
	
	public void SalvarPessoa(PessoaFisica pessoa) {
		EntityManager entityTX = new Utils().getEntityManager();
		
		try {
			entityTX.getTransaction().begin();
			entityTX.persist(pessoa);
			entityTX.getTransaction().commit();
		
		} catch (Exception e) {
			// TODO: handle exception
		} finally {
			entityTX.getEntityManagerFactory().close();
		}
	}
	
	public PessoaFisica buscarPessoaPorID(Long id) {
		EntityManager entityTX = new Utils().getEntityManager();
		PessoaFisica pessoa = new PessoaFisica();
		try {
			entityTX.getTransaction().begin();
			pessoa = entityTX.find(PessoaFisica.class, id);
			entityTX.getTransaction().commit();
			
		} catch (Exception e) {
			// TODO: handle exception
		} finally {
			entityTX.getEntityManagerFactory().close();
		}
		
		return pessoa;
	}
	
	public void UpdatePessoa(PessoaFisica pessoa) {
		EntityManager entityTX = new Utils().getEntityManager();
		
		try {
			entityTX.getTransaction().begin();
			entityTX.merge(pessoa);
			entityTX.getTransaction().commit();
		
		} catch (Exception e) {
			// TODO: handle exception
		} finally {
			entityTX.getEntityManagerFactory().close();
		}
	}
	
	public void removePessoaFisica(PessoaFisica pessoa) {
		EntityManager entityTX = new Utils().getEntityManager();
		
		try {
			entityTX.getTransaction().begin();
			PessoaFisica c = entityTX.merge(pessoa);
			entityTX.remove(c);
			entityTX.getTransaction().commit();
		
		} catch (Exception e) {
			// TODO: handle exception
		} finally {
			entityTX.getEntityManagerFactory().close();
		}
	}
	
	
	
	

}
