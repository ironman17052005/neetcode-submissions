class Solution {
    func threeSum(_ nums: [Int]) -> [[Int]] {
        var nums = nums.sorted()
        var result = [[Int]]()
        let n = nums.count
        
        for i in 0..<n - 2 {
            // If the current smallest number is greater than 0, 
            // no three numbers can sum up to 0.
            if nums[i] > 0 { break }
            
            // Skip duplicate values for the first element
            if i > 0 && nums[i] == nums[i - 1] { continue }
            
            var left = i + 1
            var right = n - 1
            
            while left < right {
                let sum = nums[i] + nums[left] + nums[right]
                
                if sum == 0 {
                    result.append([nums[i], nums[left], nums[right]])
                    
                    // Skip duplicates for the second element
                    while left < right && nums[left] == nums[left + 1] { left += 1 }
                    // Skip duplicates for the third element
                    while left < right && nums[right] == nums[right - 1] { right -= 1 }
                    
                    // Move both pointers inward
                    left += 1
                    right -= 1
                } else if sum < 0 {
                    left += 1 // Need a larger value
                } else {
                    right -= 1 // Need a smaller value
                }
            }
        }
        
        return result
    }
}
