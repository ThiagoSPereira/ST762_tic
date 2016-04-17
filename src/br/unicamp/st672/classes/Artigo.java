package br.unicamp.st672.classes;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.util.List;

import br.unicamp.st672.interfaces.HTML_Serializable;

public class Artigo implements HTML_Serializable{
	
	private List<Autor> autores;
	private Titulo titulo;
	private Resumo resumo;
	private Arquivo arquivo;
	private static int count = 1;
	private int id = count++;
	
	/**
	 * Construtor. Recebe os objetos que compõem o artigo (Autor, Titulo, Resumo, Arquivo).
	 * 
	 * @param autores
	 * @param titulo
	 * @param resumo
	 * @param arquivo
	 */
	public Artigo(Titulo titulo, List<Autor> autores, Resumo resumo, Arquivo arquivo) {
		this.autores = autores;
		this.titulo = titulo;
		this.resumo = resumo;
		this.arquivo = arquivo;
	}

	@Override
	public String toString() {
		return this.titulo.getTitulo(); // + " - " + arquivo.getArquivo();
	}	

//	@Override
//	public int compareTo(Artigo _artigo) {
//		String s = this.getTitulo().toString();
//		return this.getTitulo().compareTo(_artigo.getTitulo());
//	}

	@Override
	public void geraHTML() throws IOException {
		int count = 0;
		File file = new File(this.arquivo.toString().substring(0, this.arquivo.toString().length()-3));
		PrintStream saida = new PrintStream(new FileOutputStream("paginas/artigos" + id + ".html"));
		saida.println("<meta http-equiv=\"Content-Type\" content=\"text/html; charset=utf-8\">");
		saida.println("<html>");

		saida.println("<head>");
		saida.println("</head>");
		saida.println("<body>");

		saida.println("<h1 style=\"text-align:center;\">");
		saida.print(this.titulo);
		saida.println("</h1>");
		saida.println("<div style=\"text-align:center;\">");
		saida.print("Autores: ");
		for(Autor autor: this.autores){
			count++;
			saida.print(autor.getNome());
			if(this.autores.size()>count+1){
				saida.print(", ");
			}else if(this.autores.size() != count){
				saida.print(" e ");
			}
		}
		saida.println("</div>");
		saida.println("<div style=\"text-align:center;\">");
		saida.println("<h3 style=\"text-align:center;\">Resumo</h3>");
		saida.println("</div>");
		saida.println("<div style=\"text-align:center;border: 2px solid; "
				+ "width: 60%; margin-left: 23% \">");
		saida.print("<p style=\"font-family:courier;\">");
		saida.println(this.resumo);
		saida.print("</p>");
		saida.println("</div>");
		saida.println("<div style=\"text-align:center;\">");
		if(id!= 1){
			saida.print("<a href=artigos"+(id-1)+".html >Anterior</a>");
		}		
		saida.println("<a href=artigos"+(id+1)+".html style=\"margin-left: 500px;\">Próximo</a>");
		saida.println("</div>");
		saida.println("</body>");
		saida.println("</html>");

		saida.close();
		System.out.println("ok\n");		
	}
	
	public List<Autor> getAutores() {
		return autores;
	}

	public Titulo getTitulo() {
		return titulo;
	}

	public Resumo getResumo() {
		return resumo;
	}

	public Arquivo getArquivo() {
		return arquivo;
	}

	public int getId() {
		return id;
	}

}
