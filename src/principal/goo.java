package principal;

import io.arquivos;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import laxer.Scanner;
import laxer.parser;
import controle.Module;
import controle.Quad;

public class goo {

	public static boolean podeContinuar;

	public static void main(String[] args) {
		// System.out.println("");
		if (args.length == 0) {
			System.out.println("Nome do arquivo fonte n�o fornecido");
			System.exit(-1);
		} else {
			podeContinuar = true;
			parser p;
			try {
				p = new parser(new Scanner(new FileReader(args[0])));
				arquivos a = new arquivos();
				a.setPathGravar(args[0]);
				Object result = p.parse().value;
				Module m = (Module) result;
				if (podeContinuar) {

					m.type_check();
				}
				if (podeContinuar) {
					m.codigoInter();
				}

				if (podeContinuar) {
					Quad q = new Quad();
					q.killWalkingDead();
					System.out.println(q.codIntermediario());
					a.gravarArquiS(q.volta64.toString());
				}
				a.gravarArquiAST(result);
				a.gravarArquivoSintatico();
				a.gravarArquivoTs();
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (OError e) {
				// TODO: handle exception
				e.printStackTrace();
			} catch (Exception e) {
				// DEBUG
				e.printStackTrace();
			}
		}
	}

}
