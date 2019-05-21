package br.com.caelum.livraria.dao;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import br.com.caelum.livraria.modelo.Autor;

@Stateless
//@Interceptors({LogInterceptador.class})
public class AutorDao {

	@PersistenceContext
	private EntityManager manager;
	
	@PostConstruct
	void aposCriacao() {
	    System.out.println("AutorDao foi criado");
	}

	public void salva(Autor autor) {
		manager.persist(autor);
		//throw new RuntimeException("Deu pau");
	}
	
	public List<Autor> todosAutores() {
		return manager.createQuery("select a from Autor a", Autor.class).getResultList();
	}

	public Autor buscaPelaId(Integer autorId) {
		return manager.find(Autor.class, autorId);
	}
	
}
