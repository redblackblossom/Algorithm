import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        int n,m;
        n = sc.nextInt();
        m = sc.nextInt();
        int[] arr = new int[n];
        int[] acc = new int[n+1];

        for(int i =0; i<n;++i){
            arr[i] = sc.nextInt();
            acc[i+1] = acc[i] + arr[i];
        }

        for(int i =0; i<m;++i){
            int l = sc.nextInt();
            int r = sc.nextInt();
            System.out.println(acc[r] - acc[l-1]);
        }
    }
}