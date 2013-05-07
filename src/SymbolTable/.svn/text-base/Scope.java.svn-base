package SymbolTable;

import java.util.HashMap;
import java.util.Map;

public class Scope {

	private Map<String, Integer> idlist = new HashMap<String, Integer>();

	public Scope() {

	}

	public int lookup(String id) {
		return idlist.get(id);
	}

	public void insert(String id, int index) {
		idlist.put(id, index);
	}

	public boolean contains(String id) {
		return idlist.containsKey(id);
	}

	public int[] get_values() {
		Integer[] i = idlist.values().toArray(new Integer[0]);
		int[] i2 = new int[idlist.size()];
		for (int x = 0; x < i.length; x++)
			i2[x] = i[x];
		return i2;
	}
}
