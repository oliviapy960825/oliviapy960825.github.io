
public abstract class Movie extends Video implements Rated {

	public Movie(String name, int length) {
		super(name, length);
	}
	
	@Override
	public int getLength() {
		return 5 + super.getLength();
	}
	
	public int CompareTo(Rated other) {
		if (this.getRating() > other.getRating()) {
			return 1;
		}
		else if (this.getRating() < other.getRating()) {
			return -1;
		}
		return 0;
	}

}
