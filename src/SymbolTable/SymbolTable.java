package SymbolTable;

import java.util.HashMap;
import java.util.Stack;

public class SymbolTable {
	private static Stack<Scope> scopes = new Stack<Scope>();
	private static HashMap<Integer, Info> tab = new HashMap<Integer, Info>();
	private static int count;

	public static HashMap<Integer, Info> getTab() {
		return tab;
	}

	public SymbolTable() {
		scopes.push(new Scope()); // escopo goblal
		count = 1;
	}

	public void create_scope() {

		Scope scope = new Scope();
		scopes.push(scope);
	}

	public Scope remove_scope() {
		return scopes.pop();
	}

	public Scope current_scope() {
		return scopes.peek();
	}

	public int insert(String id, Info info) {
		// System.out.println("Colocando: "+id);
		if (scopes.peek().contains(id)) // alterar para id
			return 0;
		tab.put(count, info);
		scopes.peek().insert(id, count);
		return count++;
	}

	public boolean at_current_scope(String id) {
		return scopes.peek().contains(id);
	}

	public int lookup(String id) {
		for (int i = 0; i < scopes.size(); i++) {
			if (scopes.get(i).contains(id)) {
				return scopes.get(i).lookup(id);
			}
		}
		return 0; // valor de ID nao existente
	}

	public Info get_info(int index) {
		return tab.get(index);
	}

	public int getScopeLevel() {
		return scopes.size() - 1;
	}

	public void edit_info(int index, Info new_info) {
		tab.remove(index);
		tab.put(index, new_info);
	}
}
