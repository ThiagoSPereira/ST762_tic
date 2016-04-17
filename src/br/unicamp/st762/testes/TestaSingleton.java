package br.unicamp.st762.testes;

import br.unicamp.st672.classes.Artigos;
import br.unicamp.st672.classes.Autores;

public class TestaSingleton {

	public static void main(String[] args) {

		System.out.println("inicio");
		System.out.println(Artigos.getInstance());
		System.out.println(Autores.getInstance());
		System.out.println("fim");

	}
}
