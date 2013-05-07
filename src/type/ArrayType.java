package type;

import controle.Decla;
import controle.Exp;

public class ArrayType extends Type {

	public static Type INT = Decla.INT;

	private Type type;
	private int size;
	private Exp exp;

	public Type getType() {
		return type;
	}

	public void setType(Type type) {
		this.type = type;
	}

	public int getSize() {
		return size;
	}

	public void setSize(int size) {
		this.size = size;
	}

	public Exp getExp() {
		return exp;
	}

	public void setExp(Exp exp) {
		this.exp = exp;
	}

	public ArrayType(Type type, Exp exp) {
		super();
		this.type = type;
		this.exp = exp;
	}

	public int size() {
		return size;
	}

	public boolean is_array() {
		return true;
	}

	@Override
	public boolean correct() {
		if (type.correct()) {
			if (exp.check_const()) {
				if (exp.type() == INT) {
					if (exp.cvalue > 0) {
						return true;
					} else {
						System.err.println("array size must be positive");
					}
				} else {
					System.err.println("array size must be integer");
				}
			} else {
				System.err.println("array size must be constant");
			}
		}
		return false;
	}

}
