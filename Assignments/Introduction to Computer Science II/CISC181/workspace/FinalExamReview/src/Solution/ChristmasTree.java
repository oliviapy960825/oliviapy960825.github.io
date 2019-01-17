package Solution;

public class ChristmasTree {
	
	private double height;
	private Gift[] giftsUnder;
	
	public ChristmasTree(double height, Gift[] giftsUnder) {
		this.height = height;
		this.giftsUnder = giftsUnder;
	}
	
	public static void main(String[] args) {
		Gift[] gifts = {new Gift("Ginny")};
		ChristmasTree tree = new ChristmasTree(30, gifts);
		
		tree.giftsUnder[0].setRecipientName("Hermione");//gifts[0].setRecipientName("Hermione");
	}
}
