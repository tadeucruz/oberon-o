/*
 * Generated by classgen, version 1.3
 * 24/09/10 22:45
 */
package controle;

import type.Type;
import SymbolTable.FunInfo;
import SymbolTable.ParamInfo;
import SymbolTable.SymbolTable;

public class DeclaProcBody extends Decla {

	private Decla decla;
	private Decla decla2;
	private int id;

	public DeclaProcBody(Decla decla, Decla decla2, int id) {
		this.decla = decla;
		this.decla2 = decla2;
		this.id = id;
	}

	public Decla getDecla() {
		return decla;
	}

	public void setDecla(Decla decla) {
		this.decla = decla;
	}

	public Decla getDecla2() {
		return decla2;
	}

	public void setDecla2(Decla decla2) {
		this.decla2 = decla2;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String toString(String tab) {
		StringBuffer buffer = new StringBuffer();
		buffer.append(tab);
		buffer.append("DeclaProcBody(\n");
		if (decla != null)
			buffer.append(decla.toString("  " + tab));
		else
			buffer.append(tab + "  null");
		buffer.append("\n");
		if (decla2 != null)
			buffer.append(decla2.toString("  " + tab));
		else
			buffer.append(tab + "  null");
		buffer.append("\n");
		buffer.append("  " + tab + id);
		buffer.append("\n");
		buffer.append(tab);
		buffer.append(") [DeclaProcBody]");
		return buffer.toString();
	}

	@Override
	public void type_check() {
		// MUDEI
		if (decla != null)
			decla.type_check();
		if (decla2 != null)
			decla2.type_check();
		SymbolTable ts = new SymbolTable();
		FunInfo pi = (FunInfo) ts.get_info(id);
		if (pi.getTypeOld().equals("INTEGER")) {
			pi.setType(INT);
			ts.edit_info(id, pi);
		} else if (pi.getTypeOld().equals("BOOLEAN")) {
			pi.setType(BOOL);
			ts.edit_info(id, pi);
		} else {
			pi.setType(VOID);
			ts.edit_info(id, pi);
		}
	}

	@Override
	public void gen() {
		SymbolTable ts = new SymbolTable();
		Type volta = ts.get_info(id).getType();
		int controle = id + 1;
		while (ts.get_info(controle) instanceof ParamInfo) {
			controle = controle + 1;
		}
		new Quad("local", "id" + controle, "" + contDesloca++ * 4, "");
		if (decla != null)
			decla.gen();
		if (decla2 != null)
			decla2.gen();
		new Quad("return", "id" + controle, "", "");
		globalOuLocal = "global";
	}

}
