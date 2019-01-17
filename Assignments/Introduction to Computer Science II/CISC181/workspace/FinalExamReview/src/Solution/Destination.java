package Solution;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Destination implements Comparable<Destination> {
	
	private String city;
	private String country;

	public Destination(String city, String country) {
		this.city = city;
		this.country = country;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}
	
	public int compareTo(Destination other) {
		if (this.country.compareTo(other.country) == 0) {
			return this.city.compareTo(other.city);
		}
		else {
			return this.country.compareTo(other.country);
		}
	}
	
	public String toString() {
		return "(" + city + ", " + country + ")";
	}
	
	public static void main(String args[]) {
		List<Destination> bucketList = new ArrayList<Destination>();
		bucketList.add(new Destination("Paris", "France"));
		bucketList.add(new Destination("Rome", "Italy"));
		bucketList.add(new Destination("Venice", "Italy"));
		bucketList.add(new Destination("Florence", "Italy"));
		bucketList.add(new Destination("Perth", "Australia"));
		bucketList.add(new Destination("Perth", "UK"));
		Collections.sort(bucketList);
		System.out.println(bucketList);
	}

}
