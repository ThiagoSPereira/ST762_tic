package br.unicamp.st672.classes;

import java.util.Collection;
import java.util.HashMap;

public class Autores {

	private HashMap<Autor, Autor> autores = new HashMap<Autor, Autor>();

	public static Autores inst = null;

	public static Autores getInstance() {
		if (inst == null) {
			inst = new Autores();
		}
		return inst;
	}
	
	/**
	 * Cria, a partir de uma lista de Artigos, um HashSet com objetos do tipo
	 * Autor. Preenche a lista de artigos escrito por aquele autor.
	 * 
	 * @param artigos
	 */
	public Autores() {
		for (Artigo artigo : Artigos.getInstance().getListaArtigos()) {
			for (Autor autor : artigo.getAutores()) {
				if(!autores.containsKey(autor)){
					autores.put(autor, autor);
				}
				autores.get(autor).adiconaArtigo(artigo);
				System.out.println(this);
			}
		}
	}

	public Collection<Autor> getAutores() {
		return autores.values();
	}
	
	public String toString(){
		String ret="";
		for (Autor autor : autores.values()) {
			ret+=autor.toString()+"----\n";
		}
		return ret;
	}

}
