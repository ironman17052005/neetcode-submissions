class Solution {
public:
    int maxProfit(vector<int>& prices) {
        int l = 0;
        int r = 1;
        int max = 0;
        if(prices.size() == 2 && prices[l]>prices[r]){
            return 0;
        }
        while(r<prices.size()){
            if(prices[l]>prices[r]){//acount for the lower right
                l=r;
            }
            if(prices[r]-prices[l] > max){
                max = prices[r]- prices[l];

            }
            

        r++;
        }




        return max;
    }
};
