package controle;

import java.util.ArrayList;

import SymbolTable.Info;
import SymbolTable.SymbolTable;

public class Quad {

	private String op, arg1, arg2, res;
	private static ArrayList<String[]> listaQ = new ArrayList<String[]>();
	private static ArrayList<String[]> Qcontrole = new ArrayList<String[]>();
	public static ArrayList<ControleDead> dead = new ArrayList<ControleDead>();
	public static String pen;
	public static StringBuffer volta = new StringBuffer();
	public static StringBuffer volta64 = new StringBuffer();
	public static ArrayList<Variaveis> DV = new ArrayList<Variaveis>();
	private ArrayList<String> available_registers = new ArrayList<String>();
	private ArrayList<Registradores> dr = new ArrayList<Registradores>();
	private String Rz = "", Ry = "", Rx = "";
	// private String Rz,Ry,Rx;
	private int NOT_ALIVE = 0;
	private int ALIVE_ON_EXIT = -1;
	private String NO_REGISTER = "ASDASDASDASDASDASD";

	public static String pending() {
		return pen;
	}

	public Quad(String op, String arg1, String arg2, String res) {
		super();
		this.op = op;
		this.arg1 = arg1;
		this.arg2 = arg2;
		this.res = res;
		String[] tmp = new String[4];
		tmp[0] = op;
		tmp[1] = arg1;
		tmp[2] = arg2;
		tmp[3] = res;
		listaQ.add(tmp);
	}

	public Quad(String op, String arg1, String arg2, String res, int pos) {
		super();
		this.op = op;
		this.arg1 = arg1;
		this.arg2 = arg2;
		this.res = res;
		String[] tmp = new String[4];
		tmp[0] = op;
		tmp[1] = arg1;
		tmp[2] = arg2;
		tmp[3] = res;
		listaQ.remove(pos);
		listaQ.add(pos, tmp);
	}

	public static int QuadPos() {
		return listaQ.size() - 1;
	}

	private int ateOndeLimite;

	public void killWalkingDead() {

		Qcontrole = new ArrayList<String[]>(listaQ.size());
		for (int i = 0; i < listaQ.size(); i++) {
			String[] s = null;
			Qcontrole.add(s);
		}
		ateOndeLimite = listaQ.size() - 1;
		int t = listaQ.size() - 1;
		while (t != 0) {

			String[] s = listaQ.get(t);
			if (s[0].contains("ATRI")) {
				String controle[] = new String[3];
				controle[0] = "-";
				controle[1] = "-";
				controle[2] = "-";
				if (!s[1].equals("")) {
					ControleDead cd = new ControleDead();
					cd.setVar(s[1]);
					int i = dead.indexOf(cd);
					controle[0] = dead.get(i).getInfo();
					dead.get(i).setInfo("0");
				}
				if (!s[2].equals("")) {
					ControleDead cdindex = new ControleDead();
					cdindex.setVar(s[2]);
					if (!(dead.indexOf(cdindex) > -1)) {
						ControleDead cd = new ControleDead();
						cd.setVar(s[2]);
						cd.setInfo(Integer.toString(t));
						dead.add(cd);
						controle[1] = "0";
					} else {
						int i = dead.indexOf(cdindex);
						dead.get(i).setInfo(Integer.toString(t));
						;
					}
				}
				if (!s[3].equals("")) {
					ControleDead cdindex = new ControleDead();
					cdindex.setVar(s[3]);
					if (!(dead.indexOf(cdindex) > -1)) {
						ControleDead cd = new ControleDead();
						cd.setVar(s[3]);
						cd.setInfo(Integer.toString(t));
						dead.add(cd);
						controle[2] = "0";
					} else {
						int i = dead.indexOf(cdindex);
						dead.get(i).setInfo(Integer.toString(t));
						;
					}
				}
				Qcontrole.remove(t);
				Qcontrole.add(t, controle);
			} else if (s[0].contains("+") || s[0].contains("-")
					|| s[0].contains("*") || s[0].contains("/")) {
				String controle[] = new String[3];
				controle[0] = "-";
				controle[1] = "-";
				controle[2] = "-";
				if (!s[3].equals("")) {
					ControleDead cd = new ControleDead();
					cd.setVar(s[3]);
					int i = dead.indexOf(cd);
					controle[0] = dead.get(i).getInfo();
					dead.get(i).setInfo("0");
				}
				if (!s[2].equals("")) {
					ControleDead cdindex = new ControleDead();
					cdindex.setVar(s[2]);
					if (!(dead.indexOf(cdindex) > -1)) {
						ControleDead cd = new ControleDead();
						cd.setVar(s[2]);
						cd.setInfo(Integer.toString(t));
						dead.add(cd);
						controle[2] = Integer.toString(t);
					} else {
						int i = dead.indexOf(cdindex);
						controle[2] = dead.get(i).getInfo();
						dead.get(i).setInfo(Integer.toString(t));
						;
					}
				}
				if (!s[1].equals("")) {
					ControleDead cdindex = new ControleDead();
					cdindex.setVar(s[1]);
					if (!(dead.indexOf(cdindex) > -1)) {
						ControleDead cd = new ControleDead();
						cd.setVar(s[1]);
						cd.setInfo(Integer.toString(t));
						dead.add(cd);
						controle[1] = Integer.toString(t);
					} else {
						int i = dead.indexOf(cdindex);
						controle[1] = dead.get(i).getInfo();
						dead.get(i).setInfo(Integer.toString(t));
						;
					}
				}
				Qcontrole.remove(t);
				Qcontrole.add(t, controle);
			}
			if (s[0].contains("F") || s[3].contains("F")) {
				codX64(t);
				for (ControleDead d : dead) {
					if (d.getVar().contains("id")) {
						d.setInfo("-1");
					}
				}
			}
			t--;
		}
		codX64(t);
	}

	public Quad() {
		super();
	}

	public String getOp() {
		return op;
	}

	public void setOp(String op) {
		this.op = op;
	}

	public String getArg1() {
		return arg1;
	}

	public void setArg1(String arg1) {
		this.arg1 = arg1;
	}

	public String getArg2() {
		return arg2;
	}

	public void setArg2(String arg2) {
		this.arg2 = arg2;
	}

	public String getRes() {
		return res;
	}

	public void setRes(String res) {
		this.res = res;
	}

	public static ArrayList<String[]> getListaQ() {
		return listaQ;
	}

	public static void setListaQ(ArrayList<String[]> listaQ) {
		Quad.listaQ = listaQ;
	}

	@Override
	public String toString() {
		StringBuffer volta = new StringBuffer();
		for (int i = 0; i < listaQ.size(); i++) {
			String[] s = listaQ.get(i);
			if (s[0].equals("goto")) {
				volta.append(s[0] + " " + s[1] + "\n");
			} else if (s[3].contains("F")) {
				volta.append("IF " + s[1] + " " + s[0] + " " + s[2] + " goto "
						+ s[3] + "\n");
			} else if (s[1].contains(":")) {
				volta.append(s[0] + s[1] + " ");
			} else if (s[0].equals("ATRI")) {
				volta.append(s[1] + " = " + s[2] + "   |");
				String[] controle = Qcontrole.get(i);
				volta.append(controle[0] + "|" + controle[1] + "|"
						+ controle[2] + "\n");
			} else if (s[0].equals("exit")) {
				volta.append(s[0] + "\n");
			} else if (s[0].contains("local")) {
				volta.append(s[0] + " " + s[1] + " " + s[2] + "\n");
			} else if (s[0].contains("global")) {
				volta.append(s[0] + " " + s[1] + " " + s[2] + "\n");
			} else if (s[0].contains("Proc")) {
				volta.append(s[0] + s[1] + s[2] + s[3] + ":\n");
			} else if (s[0].equals("return")) {
				volta.append(s[0] + " " + s[1] + "\n");
			} else {
				volta.append(s[3] + " = " + s[1] + " " + s[0] + " " + s[2]
						+ "   |");
				String[] controle = Qcontrole.get(i);
				volta.append(controle[0] + "|" + controle[1] + "|"
						+ controle[2] + "\n");
			}

		}
		return volta.toString();
	}

	public static String codIntermediario() {
		StringBuffer volta = new StringBuffer();
		for (int i = 0; i < listaQ.size(); i++) {
			String[] s = listaQ.get(i);
			if (s[0].equals("goto")) {
				volta.append(s[0] + " " + s[1] + "\n");
			} else if (s[3].contains("F")) {
				volta.append("IF " + s[1] + " " + s[0] + " " + s[2] + " goto "
						+ s[3] + "\n");
			} else if (s[1].contains(":")) {
				volta.append(s[0] + s[1] + " ");
			} else if (s[0].equals("ATRI")) {
				volta.append(s[1] + " = " + s[2] + "   |");
				String[] controle = Qcontrole.get(i);
				volta.append(controle[0] + "|" + controle[1] + "|"
						+ controle[2] + "\n");
			} else if (s[0].equals("exit")) {
				volta.append(s[0] + "\n");
			} else if (s[0].contains("local")) {
				volta.append(s[0] + " " + s[1] + " " + s[2] + "\n");
			} else if (s[0].contains("global")) {
				volta.append(s[0] + " " + s[1] + " " + s[2] + "\n");
			} else if (s[0].contains("Proc")) {
				volta.append(s[0] + s[1] + s[2] + s[3] + ":\n");
			} else if (s[0].equals("return")) {
				volta.append(s[0] + " " + s[1] + "\n");
			} else if (s[0].equals("main")) {
				// volta.append(s[0]+" "+s[1]+"\n");
			} else if (s[0].equals("IO")) {
				// volta.append("")
			} else {
				volta.append(s[3] + " = " + s[1] + " " + s[0] + " " + s[2]
						+ "   |");
				String[] controle = Qcontrole.get(i);
				volta.append(controle[0] + "|" + controle[1] + "|"
						+ controle[2] + "\n");
			}

		}
		return volta.toString();
	}

	public String codX64(int n) {

		available_registers.add("%r8");
		available_registers.add("%r9");
		available_registers.add("%r10");
		available_registers.add("%r11");
		available_registers.add("%r12");
		available_registers.add("%r13");
		available_registers.add("%r14");

		volta = new StringBuffer();

		Registradores rr = new Registradores();
		for (int i = 8; i < 15; i++) {
			rr.reg = "%r" + i;
			dr.add(rr);
			rr = new Registradores();
		}

		boolean pode = false;
		// for (int i = 0; i < listaQ.size(); i++) {
		for (int i = n; i < ateOndeLimite; i++) {
			String[] s = listaQ.get(i);
			if (s[0].equals("goto")) {
				volta.append("jmp ." + s[1] + "\n");
			} else if (s[3].contains("F")) {
				Variaveis v = new Variaveis();
				for (Variaveis vv : DV) {
					if (vv.getV().equals(s[2])) {
						v = vv;
					}
				}
				String tempZ = "";

				if (v.isMem()) {
					if (v.getV().contains("$")) {
						volta.append("movl " + v.getV() + ",%edx\n");
					} else
						volta.append("movl _" + v.getV()
								+ "@GOTPCREL(%rip),%edx\n");
					tempZ = "%edx";
				} else {
					tempZ = v.getReg().get(0);
					volta.append("movq " + tempZ + ",_" + v.getV()
							+ "@GOTPCREL(%rip)\n");
					volta.append("movl _" + v.getV() + "@GOTPCREL(%rip),%edx\n");
					tempZ = "%edx";
					v.getReg().clear();
					v.setMem(true);
				}

				v = new Variaveis();
				for (Variaveis vv : DV) {
					if (vv.getV().equals(s[1])) {
						v = vv;
					}
				}

				String tempY = "";

				if (v.isMem()) {
					if (v.getV().contains("$")) {
						volta.append("movl " + v.getV() + ",%edx\n");
					} else
						volta.append("movl _" + v.getV()
								+ "@GOTPCREL(%rip),%eax\n");
					tempY = "%eax";
				} else {
					tempY = v.getReg().get(0);
					volta.append("movq " + tempY + ",_" + v.getV()
							+ "@GOTPCREL(%rip)\n");
					volta.append("movl _" + v.getV() + "@GOTPCREL(%rip),%eax\n");
					tempY = "%eax";
					v.getReg().clear();
					v.setMem(true);
				}

				volta.append("cmpl " + tempY + "," + tempZ + "\n");
				volta.append(oper_x64(s[0]) + "." + s[3] + "\n");

			} else if (s[1].contains(":")) {
				// volta.append(s[0]+s[1]+" ");
				volta.append("." + s[0] + ":\n");
			} else if (s[0].equals("ATRI")) {
				if (s[2].contains("$")) {
					volta.append("movl " + s[2] + ",_" + s[1]
							+ "@GOTPCREL(%rip)\n");
					Variaveis dvx = new Variaveis();
					for (Variaveis v : DV) {
						if (v.getV().equals(s[1])) {
							v.getReg().clear();
							v.setMem(true);
						}
					}
				} else {
					if (s[2].contains("T")) {
						Ry = Rx;
					} else {
						Rx = Ry;
					}
					Variaveis dvx = new Variaveis();
					Variaveis dvy = new Variaveis();
					for (Variaveis v : DV) {
						if (v.getV().equals(s[1])) {
							dvx = v;
						}
						if (v.getV().equals(s[2])) {
							dvy = v;
						}
					}
					dvx.setReg(Rx);
					dvx.setMem(false);
					for (Registradores r : dr) {
						if (r.reg.equals(Rx)) {
							r.lista.add(s[1]);
						}
					}
				}
			} else if (s[0].equals("exit")) {
				// volta.append(s[0]+"\n");
			} else if (s[0].contains("local")) {
				// volta.append(s[0]+" "+s[1]+" "+s[2]+"\n");
			} else if (s[0].contains("global")) {
				// volta.append(s[0]+" "+s[1]+" "+s[2]+", 3\n");
				volta.append(".comm _" + s[1] + ", " + Integer.toString(4)
						+ ", 3\n");
				pode = true;
			} else if (s[0].contains("Proc")) {
				if (pode) {
					volta.append(".LC0:\n");
					volta.append(".string \"%i/\n \"" + "\n");
					volta.append(".text\n");
					pode = false;
				}
				// volta.append(s[0]+s[1]+s[2]+s[3]+":\n");
			} else if (s[0].equals("return")) {
				// volta.append(s[0]+" "+s[1]+"\n");
			} else if (s[0].equals("main")) { // nao funciona se tiver proc
				if (pode) {
					volta.append(".LC0:\n");
					volta.append(".string \"%i\\n\"" + "\n");
					volta.append(".text\n");
					volta.append(".global main\nmain: \n");
					pode = false;
				}
				// volta.append(s[0]+" "+s[1]+"\n");
			} else if (s[0].equals("IO")) {
				Variaveis dvx = new Variaveis();
				for (Variaveis v : DV) {
					if (v.getV().equals(s[1])) {
						dvx = v;
					}
				}
				if (dvx.isMem()) {
					volta.append("movl _" + s[1] + "@GOTPCREL(%rip)"
							+ ",%edx\n");
					volta.append("movl $.LC0, %eax\n");
					volta.append("movl %edx, %esi\n");
					volta.append("movq %rax, %rdi\n");
					volta.append("movl $0, %eax\n");
					volta.append("call printf\n");
				} else {
					volta.append("movq "
							+ dvx.getReg().get(dvx.getReg().size() - 1) + ",_"
							+ s[1] + "@GOTPCREL(%rip)\n");
					volta.append("movl _" + s[1] + "@GOTPCREL(%rip)"
							+ ",%edx\n");
					volta.append("movl $.LC0, %eax\n");
					volta.append("movl %edx, %esi\n");
					volta.append("movq %rax, %rdi\n");
					volta.append("movl $0, %eax\n");
					volta.append("call printf\n");
					dvx.setMem(true);
					dvx.getReg().clear();
				}
			} else {
				get_reg(s[0], s[3], s[1], s[2], i);
				if (!Rx.equals(Ry)) {
					volta.append("movq " + Ry + "," + Rx + "\n");
				}
				if (Rz.equals(NO_REGISTER)) {
					volta.append(oper_x64(s[0]) + var_address(s[2]) + "," + Rx
							+ "\n");
				} else {
					volta.append(oper_x64(s[0]) + Rz + "," + Rx + "\n");
					Variaveis v = new Variaveis();
					for (Variaveis vv : DV) {
						if (vv.getV().equals(s[3])) {
							vv.setReg(Rx);
						}
					}
				}
				if (Rx.equals(Ry)) {
					Variaveis dvx = new Variaveis();
					Variaveis dvy = new Variaveis();
					int remove = 0;
					int contRemove = -1;
					for (Variaveis v : DV) {
						if (v.getV().equals(s[3])) {
							dvx = v;
						}
						if (v.getV().equals(s[1])) {
							dvy = v;
							contRemove = remove;
						}
						remove++;
					}
					// dvy.getReg().remove(0);
					dvx.getReg().add(Rx);
					dvx.setMem(false);
					for (Registradores r : dr) {
						if (r.reg.equals(Rx)) {
							r.lista.add(s[3]);
						}
					}
				}
			}

		}
		for (Variaveis vv : DV) {
			if (!vv.isMem()) {
				if (vv.getV().contains("id")) {
					volta.append("movq " + vv.getReg().get(0) + ",_"
							+ vv.getV() + "@GOTPCREL(%rip)\n");
					vv.setMem(true);
				}
			}
		}
		ateOndeLimite = n;
		volta.append(volta64);
		volta64 = new StringBuffer();
		volta64.append(volta);
		return volta.toString();
	}

	private String oper_x64(String string) {
		if (string.equals("+"))
			return "addq ";
		if (string.equals("-"))
			return "subq ";
		if (string.equals("*"))
			return "imulq ";
		if (string.equals("/"))
			return "idivq ";
		if (string.equals(">="))
			return "jge ";
		if (string.equals(">"))
			return "jg ";
		if (string.equals("<"))
			return "jl ";
		if (string.equals("<="))
			return "jle ";
		if (string.equals("=="))
			return "je ";
		if (string.equals("!="))
			return "jne ";
		return "PLUS ";
	}

	private String controleR15;

	private String var_address(String v) {
		if (global(v)) {
			volta.append("movq _" + v + "@GOTPCREL(%rip),%r15\n");
			controleR15 = v;
			return "%r15";
		} else {
			if (v.contains("%"))
				return offset(v);
			if (v.contains("$"))
				return v;
			if (v.contains("T")) {
				Variaveis v1 = new Variaveis();
				for (Variaveis vv : DV) {
					if (vv.getV().equals(v)) {
						v1 = vv;
					}
				}
				return v1.getReg().get(v1.getReg().size() - 1);
			}
			return offset(v) + "(%rbp)";
		}
	}

	private String offset(String v) {
		String[] temp = v.split("id");
		if (temp.length > 1) {
			SymbolTable ts = new SymbolTable();
			Info i = ts.get_info(Integer.valueOf(temp[1]));
			return Integer.toString(i.getOffsets());
		}
		return v;
	}

	private boolean global(String v) {
		String[] temp = v.split("id");
		if (temp.length > 1) {
			// arrumar
			return true;
		}
		return false;
	}

	private void gen_load(String var, String reg) {
		volta.append("movq " + var_address(var) + "," + reg + "\n");
		/*
		 * if (var.equals("(%r15)")) var = controleR15;
		 */
		for (Variaveis v : DV) {
			if (v.getV().equals(var)) {
				v.setReg(reg);
			}
		}
		for (Registradores rg : dr) {
			if (rg.reg.equals(reg)) {
				rg.lista.add(var);
			}
		}
	}

	private void gen_store(String reg, String var) {
		volta.append("movq " + reg + "," + var_address(var) + "\n");
		for (Variaveis v : DV) {
			if (v.getV().equals(var)) {
				v.setMem(true);
			}
		}
	}

	private void get_reg(String op, String x, String y, String z, int idIntru) {
		// otimiza acesso para OP comutativa
		Variaveis dv = new Variaveis();
		for (Variaveis v : DV) {
			if (v.getV().equals(y)) {
				dv = v;
				break;
			}
		}

		int status_op1 = Integer.valueOf(Qcontrole.get(idIntru)[1]);
		int status_op2 = Integer.valueOf(Qcontrole.get(idIntru)[2]);
		/*
		 * if(op.equals("+") && op.equals("*") || dv.reg_empty() || status_op1 >
		 * 0 || status_op2 > 0){ System.out.println("instr.swap_operands()"); }
		 */

		// aloca registrador Ry para y
		if (dv.reg_empty()) {
			Ry = new_reg(Rz, "");
			gen_load(var_address(y), Ry);
		} else {
			Ry = dv.getReg().get(0); // ta errado :P tem q pegar o PRIMEIRO e
										// remover
		}

		dv = new Variaveis();
		for (Variaveis v : DV) {
			if (v.getV().equals(z)) {
				dv = v;
				break;
			}
		}

		// aloca registrador Rz para z
		if (dv.reg_empty()) {
			if (status_op2 >= 0) {
				Rz = new_reg(Ry, "");
				gen_load(var_address(z), Rz);
			} else {
				Rz = NO_REGISTER;
			}
		} else {
			Rz = dv.getReg().get(0); // ERRADO.
		}

		for (Variaveis v : DV) {
			if (v.getV().equals(y)) {
				dv = v;
				break;
			}
		}

		// aloca registrador Rx para x
		if (status_op1 >= 0) {
			Rx = new_reg(Ry, Rz);
		} else {
			if (dv.getMem() == false)
				gen_store(Ry, var_address(y));
			Rx = Ry;
		}
	}

	public String new_reg(String ry, String rz) {

		for (int i = 0; i < available_registers.size(); i++) {
			Registradores DR = new Registradores();
			for (Registradores rg : dr) {
				if (rg.reg.equals(available_registers.get(i))) {
					DR = rg;
				}
			}
			if (!available_registers.get(i).equals(ry)
					&& !available_registers.get(i).equals(rz)
					&& DR.lista.isEmpty()) {
				// available_registers.remove(i);
				return available_registers.get(i);
			}
		}

		for (int i = 0; i < available_registers.size(); i++) {
			Registradores DR = new Registradores();
			for (Registradores rg : dr) {
				if (rg.reg.equals(available_registers.get(i))) {
					DR = rg;
				}
			}
			boolean may_use_reg;
			if (!available_registers.get(i).equals(ry)
					&& !available_registers.get(i).equals(rz)) {
				may_use_reg = true;
				Variaveis dv = new Variaveis();
				for (int s = 0; s < DR.lista.size(); s++) {
					for (Variaveis v : DV) {
						if (v.getV().equals(DR.lista.get(s))) {
							dv = v;
							break;
						}
					}
					may_use_reg = may_use_reg || dv.getMem();
					if (may_use_reg)
						return available_registers.get(i);
				}
			}
		}

		int min_cost = Integer.MAX_VALUE;
		int best_reg = 0;
		for (int i = 0; i < available_registers.size(); i++) {
			if (!available_registers.get(i).equals(ry)
					&& !available_registers.get(i).equals(rz)) {
				int c = cost(available_registers.get(i));
				if (c < min_cost) {
					best_reg = i;
					min_cost = c;
				}
			}
		}

		Registradores DR = dr.get(best_reg);
		for (String var : DR.lista) {

		}

		return null;
	}

	private int cost(String string) {
		return string.hashCode();
	}

	public static void use_label(String arg) {
		if (pen == null) {
			pen = arg;
		} else {
			String[] tmp = new String[4];
			tmp[0] = arg;
			tmp[1] = ":";
			tmp[2] = "";
			tmp[3] = "";
			boolean pode = true;
			for (String[] s : listaQ) {
				if (s[0] == arg)
					pode = false;
			}
			if (pode) {
				listaQ.add(tmp);
			}
			// pen=arg;
		}

	}

}
