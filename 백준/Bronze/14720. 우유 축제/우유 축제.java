import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int n ;
		n = sc.nextInt();
		int[] arr = new int[n];
		for(int i = 0; i < n; i++) {
			arr[i] = sc.nextInt();
		}

		System.out.println(solve(arr, 0, 0));

	}

	static int solve(int[] arr, int idx, int want) {
		if(idx == arr.length) {
			return 0;
		}
		if(arr[idx] == want) {
			return solve(arr, idx +1, next(want))+1;
		} else {
			return  solve(arr, idx +1, want);
		}
	}

	static int next(int value){
		value++;
		if(value==3){
			value = 0;
		}
		return value;
	}
}
