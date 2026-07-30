class Solution:
    def maxProfit(self, prices: List[int]) -> int:
        l = 0
        r = 1
        max_total = 0
        profit = 0
        

        while r < len(prices):
        
            if prices[l]<prices[r]:
                max_total = prices[r]-prices[l]
                if profit < max_total:
                    profit = max_total

            if prices[l]>prices[r]:
                l=r                   
            r+=1        

        return profit