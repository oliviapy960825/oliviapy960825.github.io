
public class Company implements Rated {
	
	private String name;
	private int rating;
	
	public Company(String name, int rating) {
		this.name = name;
		this.rating = rating;
	}
	
	public String getName() {
		return this.name;
	}
	
	public int getRating() {
		return this.rating;
	}

}
