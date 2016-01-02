package items;

import java.util.ArrayList;

public class ItemList {
	private ArrayList<Item> items;

	public ItemList() {
		items = new ArrayList<Item>();
	}
	
	public boolean contains(Item i) {
		for (int j = 0; j < items.size(); j++) {
			if (items.get(j).getName().equals(i.getName())) {
				return true;
			}
		}
		return false;
	}
	
	public ArrayList<Item> getItems() {
		return items;
	}
	
	public String toString() {
		String s = "";
		for (int i = 0; i < items.size(); i++) {
			s += items.get(i).getName() + ": " + items.get(i).getQuantity() + "\n";
		}
		return s;
	}

}
