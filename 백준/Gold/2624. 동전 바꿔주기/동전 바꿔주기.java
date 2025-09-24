import java.util.*;

public class Main {
	static int[] arr;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		arr = new int[n+1];
		int k = sc.nextInt();

		for(int i = 0; i < k; i++) {
			int a =  sc.nextInt();
			int b = sc.nextInt();

			for(int j = n; j>=0; --j){
				for(int q =1; q <=b;++q) {
					int tmp = a * q;
					if(j - tmp>0 && j - tmp<=n &&arr[j-tmp] != 0) {
						arr[j] += arr[j - tmp];
					}
				}
			}


			for(int q =1; q <=b;++q) {
				int tmp = a * q;
				if(tmp <=n){
					arr[tmp] +=1;
				}
				
			}

		}
		System.out.println(arr[n]);
	}
}
