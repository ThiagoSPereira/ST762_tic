package br.unicamp.st672.classes;

public class Resumo {
	private String resumo;
	
	/**
	 * Construtor. Recebe o resumo/abstract do artigo.
	 * @param resumo
	 */
	public Resumo(String resumo) {
		this.resumo = resumo;
	}
	
	public String getResumo() {
		return resumo;
	}
	
	@Override
	public String toString() {
		return this.resumo;
	}
}
