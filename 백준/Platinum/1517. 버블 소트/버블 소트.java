import java.util.*;
import java.io.*;

public class Main {

    static long res = 0;

    public static void main(String args[]) throws Exception {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];

        for(int i=0; i<n;++i){
            arr[i] = sc.nextInt();
        }

        recursive(arr, 0, n - 1);

        System.out.println(res);
    }

    static void recursive(int[] arr, int start, int end) {
        if (start == end) {
            return;
        } else {
            int mid = (start + end) / 2;
            recursive(arr, start, mid);
            recursive(arr, mid + 1, end);

            int startN = mid - start + 1;
            int endN = end - mid;

            int[] left = new int[startN];
            int[] right = new int[endN];

            for (int i = 0; i < startN; ++i) {
                left[i] = arr[start + i];
            }
            for (int i = 0; i < endN; ++i) {
                right[i] = arr[mid + 1 + i];
            }

            int cntLeft = 0;
            int cntRight = 0;
            int idx = start;

            while (cntLeft < startN && cntRight < endN) {
                if (left[cntLeft] <= right[cntRight]) {
                    arr[idx++] = left[cntLeft++];
                } else {
                    arr[idx++] = right[cntRight++];
                    res += startN - cntLeft;
                }
            }

            while (cntLeft < startN) {
                arr[idx++] = left[cntLeft++];
            }

            while (cntRight < endN) {
                arr[idx++] = right[cntRight++];

            }
        }
    }
}