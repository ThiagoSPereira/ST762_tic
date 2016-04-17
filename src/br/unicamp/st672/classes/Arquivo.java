package br.unicamp.st672.classes;

public class Arquivo {
	private String arquivo;

	/**
	 * Construtor. Recebe como parâmetro o nome do arquivo PDF do artigo.
	 * @param arquivo
	 */
	public Arquivo(String arquivo) {
		this.arquivo = arquivo;
	}

	public String getArquivo() {
		return arquivo;
	}
	
	@Override
	public String toString() {
		return this.arquivo;
	}

	@Override
	public int hashCode() {
		return this.getArquivo().hashCode();
	}

	@Override
	public boolean equals(Object obj) {
		return this.arquivo.equals(((Arquivo)obj).arquivo);
	}
	
}
