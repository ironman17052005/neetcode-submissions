class Solution:
    def splitArray(self, nums: List[int], k: int) -> int:
        def can_split(largest_sum):
            subarray_count = 1
            current_sum = 0
            for n in nums:
                current_sum += n
                if current_sum > largest_sum:
                    subarray_count += 1
                    current_sum = n
                    if subarray_count > k:
                        return False
            return True

        left, right = max(nums), sum(nums)
        res = right

        while left <= right:
            mid = left + (right - left) // 2
            
            if can_split(mid):
                res = mid
                right = mid - 1
            else:
                left = mid + 1
                
        return res