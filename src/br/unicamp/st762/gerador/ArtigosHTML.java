package br.unicamp.st762.gerador;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

import br.unicamp.st672.classes.Artigo;
import br.unicamp.st672.classes.Artigos;
import br.unicamp.st672.interfaces.HTML_Serializable;

public class ArtigosHTML implements HTML_Serializable{

	public static FileWriter arq;
    PrintWriter gravarArq;


	@Override
	public void geraHTML() throws IOException {
		try {
			arq = new FileWriter("Artigos.html");
			gravarArq = new PrintWriter(arq);
			gravarArq.println("<html>");
			gravarArq.println("<body>");
			gravarArq.println("<h1 style=\"text-align:center;\">Artigos publicados</h1>");
			gravarArq.println("<div style=\"text-align:center;\">");
			gravarArq.println("<ul style=\"list-style-type:none;\" >");
			
			for (Artigo artigo : Artigos.getInstance().getListaArtigos()) {
				gravarArq.println("<li>");
				gravarArq.println("<a href=paginas/artigos"+artigo.getId()+".html>"+artigo+"</a></br>");
				gravarArq.println("</li>");
			}
			
			
			gravarArq.println("</ul>");
			gravarArq.println("</div>");
			gravarArq.println("</body>");			
			gravarArq.print("</html>");
			arq.close();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
}
