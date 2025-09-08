import java.util.*;

public class Main {

	static int[] ch;
	static int[] output;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int m = sc.nextInt();

		ch = new int[n];
		output = new int[m];
		DFS(n,m,0);
	}

	static void DFS(int n, int r, int depth) {
		if(depth == r) {
			for(int i = 0; i < r; i++) {
				System.out.print(output[i] + " ");
			}
			System.out.println();
		} else {
			for(int i=0; i<n;++i) {
				if(ch[i] == 0) {
					ch[i] = 1;
					output[depth] = i +1;
					DFS(n,r,depth+1);
					ch[i] = 0;
				}
			}
		}
	}
}
