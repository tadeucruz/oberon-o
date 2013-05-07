package SymbolTable;

public class ConstInfo extends Info {

	private int const_value;

	public int category() {
		return 2;
	}

	public int getConst_value() {
		return const_value;
	}

	public void setConst_value(int const_value) {
		this.const_value = const_value;
	}

	@Override
	public String toString() {
		StringBuffer sb = new StringBuffer();
		sb.append(super.toString());
		sb.append("Cont_value: " + getConst_value() + "\n");
		return sb.toString();
	}

}
