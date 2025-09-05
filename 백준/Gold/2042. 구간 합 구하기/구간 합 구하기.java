import java.util.*;

public class Main {
	static long[] tree;
	static long[] arr;

	static long init(int node, int start, int end) {
		if (start == end) return tree[node] = arr[start];
		int mid = (start + end) / 2;
		long leftVal = init(node * 2, start, mid);
		long rightVal = init(node * 2 + 1, mid + 1, end);
		return tree[node] = leftVal + rightVal;
	}

	// [left, right] 구간 합
	static long query(int node, int start, int end, int left, int right) {
		if (right < start || end < left) return 0; // 겹치지 않음
		if (left <= start && end <= right) return tree[node]; // 완전 포함
		int mid = (start + end) / 2;
		long l = query(node * 2, start, mid, left, right);
		long r = query(node * 2 + 1, mid + 1, end, left, right);
		return l + r;
	}

	// index 위치 값을 value로 변경 (set)
	static long update(int node, int left, int right, int index, long value) {
		if (index < left || right < index) return tree[node];
		if (left == right) return tree[node] = value;
		int mid = (left + right) / 2;
		long l = update(node * 2, left, mid, index, value);
		long r = update(node * 2 + 1, mid + 1, right, index, value);
		return tree[node] = l + r;
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int m = sc.nextInt();
		int k = sc.nextInt();

		tree = new long[4 * n];
		arr = new long[n];
		for (int i = 0; i < n; ++i) arr[i] = sc.nextLong();
		init(1, 0, n - 1);

		for (int i = 0; i < m + k; ++i) {
			int a = sc.nextInt();
			if (a == 1) {
				int b = sc.nextInt();      // index (1-based)
				long c = sc.nextLong();    // value (long으로!)
				update(1, 0, n - 1, b - 1, c);
			} else {
				int b = sc.nextInt();      // left (1-based)
				int c = sc.nextInt();      // right (1-based)
				System.out.println(query(1, 0, n - 1, b - 1, c - 1));
			}
		}
	}
}
