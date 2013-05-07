/*
 * Generated by classgen, version 1.3
 * 24/09/10 22:45
 */
package controle;

public class DeclaStatements extends Decla {

	private Decla decla;
	private Com com;

	public DeclaStatements(Decla decla, Com com) {
		this.decla = decla;
		this.com = com;
	}

	public Decla getDecla() {
		return decla;
	}

	public void setDecla(Decla decla) {
		this.decla = decla;
	}

	public Com getCom() {
		return com;
	}

	public void setCom(Com com) {
		this.com = com;
	}

	public String toString(String tab) {
		StringBuffer buffer = new StringBuffer();
		buffer.append(tab);
		buffer.append("DeclaStatements(\n");
		if (decla != null)
			buffer.append(decla.toString("  " + tab));
		else
			buffer.append(tab + "  null");
		buffer.append("\n");
		if (com != null)
			buffer.append(com.toString("  " + tab));
		else
			buffer.append(tab + "  null");
		buffer.append("\n");
		buffer.append(tab);
		buffer.append(") [DeclaStatements]");
		return buffer.toString();
	}

	@Override
	public void type_check() {
		if (decla != null)
			decla.type_check();
		if (com != null)
			com.type_check();
	}

	@Override
	public void gen() {
		if (decla != null)
			decla.gen();
		if (com != null)
			com.gen();
	}

}