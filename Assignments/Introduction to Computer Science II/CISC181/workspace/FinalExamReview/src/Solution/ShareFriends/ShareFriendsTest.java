package Solution.ShareFriends;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import junit.framework.TestCase;

public class ShareFriendsTest extends TestCase {

	public static boolean shareFriends(Map<String, Set<String>> friendMap,
			String person1, String person2) {
		
		Set<String> friendsList1 = new HashSet<String>();
		friendsList1.addAll(friendMap.get(person1));
		
		Set<String> friendsList2 = new HashSet<String>();
		friendsList2.addAll(friendMap.get(person2));
		
		friendsList1.retainAll(friendsList2);
		
		return !(friendsList1.isEmpty());
		
	}
	
	public void test_shareFriends() {
		Map<String, Set<String>> friendMap = new HashMap<String, Set<String>>();
		String[] friends1 = {"Fred", "Sally"};
		String[] friends2 = {"Burt", "Sally"};
		String[] friends3 = {"Pam", "Kelly"};
		friendMap.put("Burt", new HashSet<String>(Arrays.asList(friends1)));
		friendMap.put("Fred", new HashSet<String>(Arrays.asList(friends2)));
		friendMap.put("Wayne", new HashSet<String>(Arrays.asList(friends3)));
		
		assertTrue(shareFriends(friendMap, "Burt", "Fred"));
		assertFalse(shareFriends(friendMap, "Wayne", "Fred"));
	}
}
