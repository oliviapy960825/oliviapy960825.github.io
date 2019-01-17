
public class Video implements Comparable<Video> {
	
	private String name;
	private int length;
	
	public Video(String name, int length) {
		this.name = name;
		this.length = length;
	}
	
	public String getName() {
		return this.name;
	}
	
	public int getLength() {
		return this.length;
	}
	
	@Override
	public int compareTo(Video other) {
		if (this.length > other.length) {
			return 1;
		}
		else if (this.length < other.length) {
			return -1;
		}
		return 0;
	}

}
