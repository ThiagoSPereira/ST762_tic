package br.unicamp.st672.classes;

public class Titulo {
	private String titulo;

	/**
	 * Construtor. Recebe o título do artigo.
	 * @param titulo
	 */
	public Titulo(String titulo) {
		this.titulo = titulo;
	}

	public String getTitulo() {
		return titulo;
	}

	@Override
	public String toString() {
		return this.titulo;
	}

}