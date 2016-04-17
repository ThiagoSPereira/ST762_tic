package br.unicamp.st762.testes;

import java.io.IOException;

import br.unicamp.st762.gerador.ArtigosHTML;

public class TestaCriarHtml {
	
	public static void main(String[] args) throws IOException {
		ArtigosHTML artigo = new ArtigosHTML();
		
		artigo.geraHTML();
		
	}

}
