package week4;

public class ChristmasTree {
	private Ornament[] ornaments;
	
	private ChristmasTree(Ornament... ornaments) {
		this.ornaments = ornaments;		
	}

	public String toString() {
		StringBuilder sb = new StringBuilder();
		for (Ornament orn : ornaments) {
			sb.append(orn.getColor()+" "+orn.getClass().getSimpleName()+", ");
		}
		return sb.toString();
	}
	
	public void light() {
		for (Ornament orn : ornaments) {
			// not polymorphic
			if (orn instanceof LED) {
				((LED)orn).turnOn();
			}
			// polymorphic
//			orn.turnOn();
		}
		
		
	}
	
	public static void main(String[] args) {
		ChristmasTree tree = new ChristmasTree(new LED("red"), new LED("blue"),
				new Star(), new GingerbreadMan());
		System.out.println(tree);
		tree.light();
		System.out.println(tree);
	}
}
