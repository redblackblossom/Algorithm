#include <vector>
#include <iostream>
#include <deque>

using namespace std;

vector<int> solution(vector<int> arr) 
{
    vector<int> answer;
    
    deque<int> dq;

    for(int i =0; i<arr.size(); ++i) {
        if(dq.empty()) {
            dq.push_back(arr[i]);
        } else {
            int back = dq.back();
            if(back != arr[i]) {
                dq.push_back(arr[i]);
            }
        }
    }
    for(int i =0; i<dq.size();++i) {
        answer.push_back(dq[i]);
    }
    
    return answer;
}