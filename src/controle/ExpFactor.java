/*
 * Generated by classgen, version 1.3
 * 24/09/10 22:45
 */
package controle;

import principal.goo;
import type.ArrayType;
import type.Type;

public class ExpFactor extends Exp {

	private String prec;
	private Exp exp;

	public ExpFactor(String prec, Exp exp) {
		this.prec = prec;
		this.exp = exp;
	}

	public String getPrec() {
		return prec;
	}

	public void setPrec(String prec) {
		this.prec = prec;
	}

	public Exp getExp() {
		return exp;
	}

	public void setExp(Exp exp) {
		this.exp = exp;
	}

	public String toString(String tab) {
		StringBuffer buffer = new StringBuffer();
		buffer.append(tab);
		buffer.append("ExpFactor(\n");
		buffer.append("  " + tab + prec);
		buffer.append("\n");
		if (exp != null)
			buffer.append(exp.toString("  " + tab));
		else
			buffer.append(tab + "  null");
		buffer.append("\n");
		buffer.append(tab);
		buffer.append(") [ExpFactor]");
		return buffer.toString();
	}

	@Override
	public boolean check_const() {
		if (exp.check_const()) {
			cvalue = exp.cvalue;
			cvalue = calc(prec, cvalue);
			return true;
		} else {
			return false;
		}
	}

	@Override
	public StringBuffer to_postfix() {
		StringBuffer ret = new StringBuffer();
		ret.append(prec);
		ret.append(exp.to_postfix());
		return ret;
	}

	@Override
	public Type type_check() {
		_type = exp.type_check();
		if (_type instanceof ArrayType) {
			_type = ((ArrayType) _type).getType();
		}
		if (_type != ERROR) {
			if (((prec.equals("-") || prec.equals("+")) && _type == INT)
					|| (prec.equals("NOT") && _type == BOOL)) {
				return _type;
			}
		}
		System.out.println("error:invalid type in unary expression");
		goo.podeContinuar = false;
		return _type = ERROR;

	}

	public boolean equals(Object obj) {
		return this.toString().equals(obj.toString());
	}

	@Override
	public void gen() {
		exp.t_label = this.t_label;
		exp.f_label = this.f_label;
		Temporarios tmp = new Temporarios();
		exp.gen();
		this.addr = "T" + tmp.getNumeroTemp();
		Quad q = new Quad(prec, exp.addr, "", "T" + tmp.getNumeroTemp());
	}

}