package pokemon;

public class Move {
	String name;
	int uses;
	Type type;

	public Move() {
		// TODO Auto-generated constructor stub 
	}
	
	public Move(String n, int u, Type t) {
		this.name = n;
		this.uses = u;
		this.type = t;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		if (name == null) {
			return "-";
		}
		return name;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the uses
	 */
	public int getUses() {
		return uses;
	}

	/**
	 * @param uses the uses to set
	 */
	public void setUses(int uses) {
		this.uses = uses;
	}
	
	

}
