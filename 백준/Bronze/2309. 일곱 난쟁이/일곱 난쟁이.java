import java.util.*;


public class Main {
	
	static int[] arr;
	static int[] ch;

	static boolean flag = false;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		arr = new int[9];
		ch = new int[9];
		
		for(int i =0; i<9;++i) {
			arr[i] = sc.nextInt();
		}
		
		DFS(0,9,2);
	}
	
	static void DFS(int l, int n, int canMinus) {
		if(flag) return;
		if(canMinus == 0) {
			int acc =0;
			for(int i =0; i<9;++i) {
				if(ch[i] == 0) {
					acc += arr[i];
				}
			}
			
			if(acc ==100) {
				int[] ans = new int[7];
				int idx = 0;
				
				for(int i =0; i<9;++i) {
					if(ch[i] == 0) {
						ans[idx] = arr[i];
						idx++;
					}
				}
				
				Arrays.sort(ans);
				
				for(int i =0; i<ans.length; ++i) {
					System.out.println(ans[i]);
				}
				flag = true;
			}

		} else {
			for(int i =l; i<n;++i) {
				ch[i] = 1;
				canMinus--;
				DFS(i+1, n, canMinus);
				ch[i] = 0;
				canMinus++;
				
				 //DFS(i+1,n, canMinus);
			}
		}
	}
	
}
