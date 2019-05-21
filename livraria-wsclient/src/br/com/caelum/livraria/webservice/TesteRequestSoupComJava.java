package br.com.caelum.livraria.webservice;

import java.rmi.RemoteException;

public class TesteRequestSoupComJava {

	public static void main(String[] args) throws RemoteException {

		LivrariaWS ws = new LivrariaWSProxy();
		Livro[] livros = ws.getLivrosPeloNome("s");
		
		for (Livro livro : livros) {
			System.out.println(livro.getTitulo() + " - " + livro.getAutor().getNome());
		}
		
		
	}

}
