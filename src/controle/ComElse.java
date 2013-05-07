/*
 * Generated by classgen, version 1.3
 * 24/09/10 22:45
 */
package controle;

public class ComElse extends Com {

	private Decla decla;

	public ComElse(Decla decla) {
		this.decla = decla;
	}

	public Decla getDecla() {
		return decla;
	}

	public void setDecla(Decla decla) {
		this.decla = decla;
	}

	public String toString(String tab) {
		StringBuffer buffer = new StringBuffer();
		buffer.append(tab);
		buffer.append("ComElse(\n");
		if (decla != null)
			buffer.append(decla.toString("  " + tab));
		else
			buffer.append(tab + "  null");
		buffer.append("\n");
		buffer.append(tab);
		buffer.append(") [ComElse]");
		return buffer.toString();
	}

	@Override
	public void type_check() {
		decla.type_check();
	}

	@Override
	public void gen() {
		decla.gen();
		Quad.use_label(this.next);
	}

}