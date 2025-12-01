import java.util.*;

public class Main {
	static int MIN = Integer.MAX_VALUE;
	static int MAX = Integer.MIN_VALUE;

	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);
		String s = sc.nextLine();

		Node result = recursion(s);
		System.out.println(result.min + " " + result.max);

	}

	static Node recursion(String s) {
		int nowCnt = 0;
		for(int i =0; i< s.length();++i) {
			if(Integer.parseInt(s.charAt(i)+"")%2==1) {
				nowCnt++;
			}
		}

		if(s.length() == 1) {
			return new Node(nowCnt, nowCnt);
		} else if(s.length() == 2) {

			Node node = recursion(Integer.toString(Integer.parseInt( s.charAt(0)+"")  + Integer.parseInt( s.charAt(1)+"")) );
			node.max =  node.max + nowCnt;
			node.min = node.min + nowCnt;
			return node;
		} else {
			Node now = new Node(Integer.MAX_VALUE, Integer.MIN_VALUE);

			for(int i =1; i<s.length();++i) {
				for(int j =i+1; j<s.length();++j) {

					String a = s.substring(0, i);
					String b = s.substring(i, j);
					String c = s.substring(j);
					if(a.isEmpty() || b.isEmpty() || c.isEmpty()) continue;

					String next = Integer.toString( Integer.parseInt(a) + Integer.parseInt(b) + Integer.parseInt(c) );

					Node temp = recursion(next);
					now.min = Math.min(now.min, temp.min + nowCnt);
					now.max = Math.max(now.max, temp.max + nowCnt);
				}
			}

			return now;
		}

	}

	static class Node {
		int min;
		int max;
		Node(int min, int max) {
			this.min = min;
			this.max = max;
		}
	}

}
