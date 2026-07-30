class Solution:
    def twoSum(self, numbers: List[int], target: int) -> List[int]:
        l = 0
        r= len(numbers) -1
        max = 0
        placeholder = 0

        while l < r:

            max = numbers[l]+numbers[r]
            if max == target:
                return [l+1,r+1]
            if max > target:
                r-=1
            else:
                l+=1

            
