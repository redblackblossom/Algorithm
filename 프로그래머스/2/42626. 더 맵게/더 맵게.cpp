#include <string>
#include <vector>
#include <queue>
#include <iostream>

using namespace std;

int solution(vector<int> scoville, int K) {
    int answer = 0;
    priority_queue<long long, vector<long long>, greater<int>> pq;
    
    for(int i =0; i<scoville.size(); ++i) {
        pq.push(scoville[i]);
    }
    int cnt = 0;
    while(true){
        long long top1 = pq.top();
        //cout<<top1<<endl;
        pq.pop();
        if(top1 >= K) {
            answer = cnt;
            break;
        } else if(pq.empty()){
            answer = -1;
            break;
        } else {
            long long top2 = pq.top();
            pq.pop();
            pq.push(top1 + top2 *2);
        }
        cnt++;
    }
    
    
    return answer;
}