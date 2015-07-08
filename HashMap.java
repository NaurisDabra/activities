package sef.module3.activity;

import java.util.ArrayList;
import java.util.List;

public class HashMap {
	List<TableElement> table;
	private final static int HASHSIZE = 6;

	public static void main(String[] args) {
		HashMap table = new HashMap();
		for (int i = 0; i < 10; i++) {
			for (int j = 0; j < 10; j++) {
				table.put(i, i * 11 + j);
			}
		}
		

		for (int i = 0; i < table.table.size(); i++)
			table.table.get(i).print();
		System.out.println("notiek elementa meklesaana");
		System.out.println(table.get(101));
	}

	public HashMap() {

		table = new ArrayList<TableElement>();

	}

	public TableElement2 get(int key) {
		TableElement2 element = null;
		int hash = (key % HASHSIZE);
		for (int i = 0; i < table.size(); i++) {
			if (table.get(i).getHashKey() == hash) {
				element = table.get(i).get(key);

				break;
			}
		}
		return element;

	}

	public void put(int value, int key) {
		boolean flag = false;
		int hash = (key % HASHSIZE);

		for (int i = 0; i < table.size(); i++) {
			if (table.get(i).getHashKey() == hash) {
				table.get(i).put(value, key);
				flag = true;
				break;
			}
		}
		if (!flag) {
			table.add(new TableElement(hash, value, key));
		}
	}

	@Override
	public String toString() {
		String text = "";

		return text;
	}

	class TableElement {
		private List<TableElement2> element;
		private int hashKey;

		public TableElement(int hashKey, int value, int key) {

			this.hashKey = hashKey;
			this.element = new ArrayList<TableElement2>();
			element.add(new TableElement2(value, key));
		}

		public TableElement2 get(int key) {
			TableElement2 elements = null;

			for (int i = 0; i < element.size(); i++) {
				if (element.get(i).getKey() == key) {
					elements = element.get(i);

					break;
				}

			}
			return elements;
		}

		public int getHashKey() {
			return hashKey;
		}

		public void put(int value, int key) {
			boolean flag = false;
			for (int i = 0; i < element.size(); i++) {
				if (element.get(i).getKey() == key) {
					element.get(i).change(value, key);

					flag = true;
					break;
				}

			}
			if (!flag) {
				element.add(new TableElement2(value, key));
			}

		}

		public void print() {
			System.out.println("Hash key is " + hashKey);
			for (int i = 0; i < element.size(); i++) {
				System.out.println(element.get(i));

			}
		}

	}

	class TableElement2 {
		private int element;
		private int key;

		TableElement2(int element, int key) {

			this.element = element;
			this.key = key;

		}

		public void change(int value, int key) {
			this.element = value;
			this.key = key;
		}

		public int getElement() {

			return element;

		}

		public int getKey() {
			return key;
		}

		public String toString() {
			return "atrastaa elementa vertiba ir " + element + " atslega ir " + key;
		}

	}

}
