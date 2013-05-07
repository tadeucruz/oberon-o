package SymbolTable;

import java.util.ArrayList;

import type.Type;
import controle.Decla;

public class Info {
	private String name;
	private String typeOld;
	private Type type = Decla.ERROR;
	private int scope_level;
	private int declared_line;
	private ArrayList<Integer> used_lines;
	private int offsets;

	public int getOffsets() {
		return offsets;
	}

	public void setOffsets(int offsets) {
		this.offsets = offsets;
	}

	public int category() {
		return 0;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getTypeOld() {
		return typeOld;
	}

	public void setTypeOld(String typeOld) {
		this.typeOld = typeOld;
	}

	public Type getType() {
		return type;
	}

	public void setType(Type type) {
		this.type = type;
	}

	public int getScope_level() {
		return scope_level;
	}

	public void setScope_level(int scopeLevel) {
		scope_level = scopeLevel;
	}

	public int getDeclared_line() {
		return declared_line;
	}

	public void setDeclared_line(int declaredLine) {
		declared_line = declaredLine;
	}

	public ArrayList<Integer> getUsed_lines() {
		return used_lines;
	}

	public void setUsed_lines(ArrayList<Integer> usedLines) {
		used_lines = usedLines;
	}

	public void insert_line(int i) {
		used_lines.add(i);
	}

	public String toString() {
		StringBuffer sb = new StringBuffer();
		sb.append(getName() + "\n");
		sb.append(getClass() + "\n");
		sb.append(getType() + "\n");
		sb.append(getTypeOld() + "\n");
		sb.append(getOffsets() + "\n");
		return sb.toString();
	}

}
