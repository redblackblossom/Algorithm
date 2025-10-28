import java.util.*;

class Solution {
    public int[] solution(String[] gems) {
        int[] answer = new int[2];
        answer[0] = 0;
        answer[1] = gems.length - 1;
        int n = gems.length;

        Map<String, Integer> m = new HashMap<>();
        for (int i = 0; i < n; ++i) m.put(gems[i], i);
        int size = m.size();

        int start = 0, end = 0;
        Map<String, Integer> tmp = new HashMap<>();
        tmp.put(gems[0], 1);

        while (true) {
            if (tmp.size() == size) {
                if (end - start < answer[1] - answer[0]) {
                    answer[0] = start;
                    answer[1] = end;
                }
                String gs = gems[start];
                int c = tmp.get(gs) - 1;
                if (c == 0) tmp.remove(gs);
                else tmp.put(gs, c);
                start++;
            } else {
                if (end == n - 1) break;
                end++;
                String ge = gems[end];
                tmp.put(ge, tmp.getOrDefault(ge, 0) + 1);
            }
        }

        answer[0]++;
        answer[1]++;
        return answer;
    }
}
