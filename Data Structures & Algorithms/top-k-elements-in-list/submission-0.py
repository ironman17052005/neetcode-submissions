class Solution:
    def topKFrequent(self, nums: List[int], k: int) -> List[int]:
        counts = {}
        for i in nums:
            counts[i] = counts.get(i, 0) + 1
        sorted_counts = dict(sorted(counts.items(), key=lambda  item: item[1], reverse=True))


        result = list(sorted_counts.keys())[:k]
        return(result)



