package Solution.Distances;

public class Location {
	
	private float latitude; private float longtitude;
	
	public Location(float latitude, float longtitude) { 
		this.latitude = latitude; 
		this.longtitude = longtitude;
	}
	
	public float getLatitude() {
		return latitude;
	}
	public float getLongtitude() {
		return longtitude;
	}
	
	// returns the distance between this Location and other in miles
	public float distance(Location other) { 
		return (float) Math.sqrt(Math.pow((this.longtitude - other.longtitude), 2) +
				Math.pow((this.latitude- other.latitude), 2));
	}

}
