package io;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.util.Set;

import SymbolTable.SymbolTable;

public class arquivos {

	private static InputStream in;
	private static BufferedWriter out;
	private static String pathGravar;
	private static StringBuffer conteudo = new StringBuffer();

	public static InputStream getIn() {
		return in;
	}

	public static void setIn(InputStream in) {
		arquivos.in = in;
	}

	public static BufferedWriter getOut() {
		return out;
	}

	public static void setOut(BufferedWriter out) {
		arquivos.out = out;
	}

	public static String getPathGravar() {
		return pathGravar;
	}

	public static void setPathGravar(String pathGravar) {
		arquivos.pathGravar = pathGravar;
	}

	public static StringBuffer getConteudo() {
		return conteudo;
	}

	public static void setConteudo(StringBuffer conteudo) {
		arquivos.conteudo = conteudo;
	}

	public InputStream retornInputArquivo(String path)
			throws FileNotFoundException {
		in = new FileInputStream(path);
		pathGravar = path;
		return in;
	}

	public void gravarArquivoLexico() throws IOException {
		File f = new File(pathGravar);
		String[] tmp = f.getName().split("\\.");
		if (tmp.length > 0) {
			pathGravar = tmp[0];
		}
		String a = f.getAbsolutePath().replace(f.getName(), "");
		if (conteudo.length() != 0) {
			out = new BufferedWriter(new FileWriter(a + pathGravar + ".lexico"));
			out.write(conteudo.toString());
			out.close();
		}
	}

	public void gravarArquivoSintatico() throws IOException {
		File f = new File(pathGravar);
		String[] tmp = f.getName().split("\\.");
		if (tmp.length > 0) {
			pathGravar = tmp[0];
		}
		String a = f.getAbsolutePath().replace(f.getName(), "");
		if (conteudo.length() != 0) {
			out = new BufferedWriter(new FileWriter(a + pathGravar
					+ ".sintatico"));
			out.write(conteudo.toString());
			out.close();
		}
	}

	public void gravarArquivoTs() throws IOException {
		File f = new File(pathGravar);
		String[] tmp = f.getName().split("\\.");
		if (tmp.length > 0) {
			pathGravar = tmp[0];
		}
		String a = f.getAbsolutePath().replace(f.getName(), "");
		if (conteudo.length() != 0) {
			out = new BufferedWriter(new FileWriter(a + pathGravar + ".ts"));
			SymbolTable ts = new SymbolTable();
			Set<Integer> controle = SymbolTable.getTab().keySet();
			for (Integer i : controle) {
				out.write(SymbolTable.getTab().get(i).toString() + "\n");

			}
			out.close();
		}
	}

	public void gravarArquiAST(Object result) throws IOException {
		File f = new File(pathGravar);
		String[] tmp = f.getName().split("\\.");
		if (tmp.length > 0) {
			pathGravar = tmp[0];
		}
		String a = f.getAbsolutePath().replace(f.getName(), "");
		out = new BufferedWriter(new FileWriter(a + pathGravar + ".ast"));
		out.write(result.toString());
		out.close();
	}

	public void gravarArquiS(String result) throws IOException {
		File f = new File(pathGravar);
		String[] tmp = f.getName().split("\\.");
		if (tmp.length > 0) {
			pathGravar = tmp[0];
		}
		String a = f.getAbsolutePath().replace(f.getName(), "");
		out = new BufferedWriter(new FileWriter(a + pathGravar + ".s"));
		out.write(".file " + "\"" + pathGravar + ".s" + "\"" + "\n");
		out.write(result);
		out.close();
	}

	public void addConteudo(String s) {
		conteudo.append(s);
	}

}
