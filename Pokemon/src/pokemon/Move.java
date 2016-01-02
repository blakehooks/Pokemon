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

}
