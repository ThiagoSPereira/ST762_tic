package br.unicamp.st672.classes;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Artigos {

	private List<Artigo> artigos = new ArrayList<Artigo>();

	/** instancia unica */
	private static Artigos inst = null;

	public static Artigos getInstance() {
		if (inst == null) {
			inst = new Artigos();
		}
		return inst;
	}
	
	@Override
	public String toString() {
		return artigos.toString();
	}

	/**
	 * Construtor da classe Carregador Recebe como parâmetro um diretório e cria
	 * um vetor com o nome dos arquivos do diretório. A partir dos arquivos no
	 * array cria objetos do tipo Artigo e adiciona no atributo List<Artigo> artigos.
	 * 
	 * @param dir
	 * @throws IOException
	 */
	private Artigos() {

		File diretorio = new File("./artigos");
		File[] listaArquivos = diretorio.listFiles();

		for (File file : listaArquivos) {
			if (file.getName().endsWith(".txt")) {
				List<Autor> autores = new ArrayList<Autor>();
				Scanner scanner;
				try {
					scanner = new Scanner(new FileInputStream(file));

					Titulo titulo = new Titulo(scanner.nextLine());

					/*
					 * O método split da string recebe um parâmetro e o utiliza
					 * como separador, gerando um array de Strings. O método
					 * Arrays.asList recebe esse array e devolve uma lista. Com
					 * um laço do foreach percorremos a lista e utilizamos cada
					 * elemento para gerar um objeto do tipo Autor e adicioná-lo
					 * à lista de autores do artigo que será passada como
					 * parâmetro para o construtor do artigo.
					 */
					for (String item : Arrays.asList(scanner.nextLine().split("[,]"))) {
						autores.add(new Autor(item));
					}

					Resumo resumo = new Resumo(scanner.nextLine());
					Arquivo pdf = new Arquivo(scanner.nextLine());

					artigos.add(new Artigo(titulo, autores, resumo, pdf));

					scanner.close();
				} catch (FileNotFoundException e) {
					e.printStackTrace();
				}
			}
		}
	}

	public List<Artigo> getListaArtigos() {
		return artigos;
	}
}
