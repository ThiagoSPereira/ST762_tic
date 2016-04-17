package br.unicamp.st672.classes;

import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

public class Carregador {

	/**
	 * Cria duas listas, uma contendo todos os artigos e outra contendo todos os
	 * autores. A lista de autores é na verdade um mapa com que relaciona um
	 * autor à uma lista de artigos. O próprio mapa é utilizado para alterar os
	 * objetos do tipo Autor adicionando a lista de artigos ao próprio objeto.
	 * 
	 * 
	 * a partir da lista de artigos construimos um Set de autores. a lista
	 * contém objetos do tipo autor, que por sua vez possuem uma lista de
	 * artigos.
	 * 
	 * para cada artigo da lista de artigos verifica-se se o autor(es) já existe
	 * no Set. caso exista o artigo é adicionado, caso não, adiciona-se o autor
	 * e então o artigo.
	 * 
	 * 
	 * @param _diretorio
	 * @throws IOException
	 */
	public Carregador(String diretorio) throws IOException {

		Artigos listaArtigos = Artigos.getInstance();
		Autores listaAutores = Autores.getInstance();
		Set<Autor> conjunto = new HashSet<Autor>();

		for (Artigo artigo : listaArtigos.getListaArtigos()) { // percorre a lista de artigos
			for (Autor autor : artigo.getAutores()) { // percorre a lista de autores em cada artigo
				if( !conjunto.contains(autor) ) {
					conjunto.add(autor);
				}
			}
		}
		
//		for (Autor autor : listaAutores.getMapaAutores().keySet()) {
//			autor.setListaArtigos(listaAutores.getMapaAutores().get(autor));
//		}

	}
}
