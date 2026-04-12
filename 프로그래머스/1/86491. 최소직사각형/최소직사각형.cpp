#include <string>
#include <vector>
#include <algorithm>

using namespace std;

int solution(vector<vector<int>> sizes) {
    int answer = 0;
    int w = 0;
    int h = 0;
    
    for(int i =0; i<sizes.size(); ++i){
        int a = sizes[i][0];
        int b = sizes[i][1];
        if(a > b) {
            w = max(a,w);
            h = max(b,h);
        } else {
            w = max(b,w);
            h = max(a,h); 
        }
    }
    
    answer = w * h;
    
    return answer;
}