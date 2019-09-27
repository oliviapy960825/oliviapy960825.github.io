package week1;

public class Unique {
	public static String unique(String s) {
		for (char c : s.toCharArray()) {
			for (char t : s.toCharArray()) {
				if (c == t) {
					// c is not unique
				}
			}
		}
		return "";
	}
	
	public static void main(String[] args) {
		System.out.println(unique("ffifkmi"));
		System.out.println(unique("test"));
		System.out.println(unique("confuse"));
	}



}
