
public class SilentMovie extends Movie {
	
	public SilentMovie(String name, int length) {
		super(name, length);
	}
	
	@Override
	public int getRating() {
		return 1;
	}

}
