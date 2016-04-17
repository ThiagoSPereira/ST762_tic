
package br.unicamp.st762.testes;

import java.io.IOException;
import java.util.Scanner;

import br.unicamp.st672.classes.Artigo;
import br.unicamp.st672.classes.Autor;
import br.unicamp.st672.classes.Artigos;
import br.unicamp.st672.classes.Autores;

public class TestaCarregadorres {
	public static void main(String[] args) throws IOException {
		
		Scanner scanner = new Scanner(System.in);

		System.out.println("Pressione qualquer tecla para imprimir os artigos");
		scanner.nextLine();
		for (Artigo artigo : Artigos.getInstance().getListaArtigos()) {
			System.out.println(artigo);
			artigo.geraHTML(); 
		}
		
		
		System.out.println("\n\n");
		System.out.println("Pressione qualquer tecla para continuar com a impressão dos autores");
		scanner.nextLine();
		for (Autor autor : Autores.getInstance().getAutores() ) {
			System.out.println(autor + " - " + autor);
		}

	
		scanner.close();
	}
}
