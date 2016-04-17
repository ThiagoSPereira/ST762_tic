package br.unicamp.st762.utils;

import java.io.File;

public class Util {

	public static void ListaDir(String dir) {

		File diretorio = new File(dir);
		File[] listaArquivos = diretorio.listFiles();

		for (File file : listaArquivos) {
			if (file.getName().endsWith(".txt")) {
			}
		}

	}

}
