import java.util.*;

public class Main {

	public static void main(String[] args) {
		//-------여기에 해결 코드를 작성하세요.
		
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int m = sc.nextInt();
		
		int[] arr = new int[n + 1];
		
		
		for(int i =1; i<=n;++i) {
			arr[i] = i;
		}
		
		for(int i =0; i<m;++i) {
			int a = sc.nextInt();
			int b = sc.nextInt();
			reverse(arr, a, b);
		}
		
		for(int i =1; i<=n;++i) {
			System.out.print(arr[i] + " ");
		}
	}
	
	static void reverse(int[] arr, int start, int end) {
		int n =arr.length-1;
		int[] reversed = new int[n+1];
		
		for(int i =1; i<=n;++i) {
			reversed[i] = arr[i];
		}
		int s = start;
		int e = end;
		for(int i = 0; i<end - start+1;++i) {
			reversed[s] = arr[e];
			s++;
			e--;
		}
		
		for(int i =1; i<=n;++i) {
			arr[i] = reversed[i];
		}
	}

}