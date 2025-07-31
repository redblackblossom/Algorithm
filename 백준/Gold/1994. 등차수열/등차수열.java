import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        int[] arr = new int[n];

        for(int i =0; i<n;++i){
            arr[i] = sc.nextInt();
        }

        Map<Integer, Integer> map = new HashMap<>();

        for(int i =0; i<n;++i){
            if(map.containsKey(arr[i])){
                map.put(arr[i], map.get(arr[i]) + 1);
            } else {
                map.put(arr[i], 1);
            }
        }

        n = map.size();
        int[] uniqueArr = new int[n];
        int idx = 0;
        int answer = 1;
        for(int i : map.keySet()){
            uniqueArr[idx] = i;
            idx++;
            if(map.get(i) > answer){
                answer = map.get(i);
            }
        }

        Arrays.sort(uniqueArr);
        int[][] ch = new int[2002][2002];

        for(int i =0; i<n;++i){
            for(int j = i+1; j<n;++j) {
                int diff = uniqueArr[j] - uniqueArr[i];
                int second = uniqueArr[j];
                int secondIdx = i;
                int tmp = 2;
                while(true) {
                    int nextKey = Arrays.binarySearch(uniqueArr, second + diff);
                    if(nextKey >= 0 && ch[secondIdx][nextKey] == 0 ) {
                        ch[secondIdx][nextKey] = 1;
                        second += diff;
                        tmp++;

                    } else {
                        answer = Math.max(answer, tmp);
                        break;
                    }
                }
            }
        }

        System.out.println(answer);
    }
}