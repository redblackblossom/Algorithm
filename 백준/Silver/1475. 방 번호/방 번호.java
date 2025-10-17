import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();

		String s = Integer.toString(n);

		Map<Character, Integer> map = new HashMap<>();

		for(int i =0; i<10;++i){
			map.put((char)('0'+i), 0);
		}

		for(int i =0; i<s.length(); ++i){
			char c = s.charAt(i);
			if(c=='6' || c=='9') {
				if (map.get('6') <= map.get('9')) {
					map.put('6', map.get('6') + 1);
				} else {
					map.put('9', map.get('9') + 1);
				}
			}
			else {
				map.put(c, map.get(c) + 1);
			}
		}
		int ans = 0;
		for(char c :map.keySet()) {
			ans = Math.max(ans, map.get(c));
		}
		System.out.println(ans);
	}
}
