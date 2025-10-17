import java.util.*;

public class Main {
	static int[] arr;
	static int[] ch;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int r = sc.nextInt();

		arr = new int[r];
		ch = new int[n+1];

		recursive(n,r,0);
	}

	static void recursive(int n, int r, int depth) {
		if(depth == r) {
			for(int i = 0; i < r; i++) {
				System.out.print(arr[i] + " ");
			}
			System.out.println();
		} else {
			for(int i = 1; i<=n;++i) {
				if(ch[i] ==0) {
					ch[i] =1;
					arr[depth] = i;
					recursive(n,r,depth+1);
					ch[i] =0;
				}
			}
		}
	}
}
