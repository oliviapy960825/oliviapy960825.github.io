
public class ThreeDMovie extends Movie{
	
	int rating;
	
	public ThreeDMovie(String title, int length, int rating) {
		super(title, length);
		this.rating = rating;
	}
	
	@Override
	public int getRating() {
		return this.rating;
	}
	

}
