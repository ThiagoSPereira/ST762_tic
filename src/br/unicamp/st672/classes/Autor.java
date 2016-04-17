package br.unicamp.st672.classes;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;

import br.unicamp.st672.interfaces.HTML_Serializable;

public class Autor implements HTML_Serializable, Comparable<Autor> {
	private String nome;
	private List<Artigo> listaArtigos;

	public Autor(String nome) {
		this.nome = nome;
		this.listaArtigos = new ArrayList<Artigo>();
	}

	public void adiconaArtigo(Artigo artigo) {
		this.listaArtigos.add(artigo);
	}
	
	public List<Artigo> getListaArtigos() {
		return listaArtigos;
	}

	public String getNome() {
		return nome;
	}

	@Override
	public String toString() {
		String str = "";
		str += this.nome + " - " + this.getListaArtigos().size();		
		return str;
	}

	@Override
	public int hashCode() {
		return this.getNome().hashCode();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Autor other = (Autor) obj;
		if (nome == null) {
			if (other.nome != null)
				return false;
		} else if (!nome.equals(other.nome))
			return false;
		return true;
	}

	@Override
	public int compareTo(Autor other) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void geraHTML() throws IOException {

		PrintStream saida = new PrintStream(new FileOutputStream("autores/" + this.nome + ".html"));

		saida.println("<html>");

		saida.println("<head>");
		saida.println("</head>");
		saida.println("<body>");
		
		saida.println("<h3>");
		saida.println(this.nome);
		saida.println("</h3>");

		for (Artigo artigo : listaArtigos) {
			saida.println("<p>");
			saida.println(artigo);
			saida.println("</p>");			
		}

		saida.println("</body>");
		saida.println("</html>");

		saida.close();

	}

}
