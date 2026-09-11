class Solution {
    /**
     * @param {number[]} nums
     * @param {number} k
     * @return {number[]}
     */
    maxSlidingWindow(nums: number[], k: number): number[] {const res: number[] = [];
const q: number[] = []; // Stores the indices, not the actual numbers
let l = 0;
let r = 0;

while (r < nums.length) {
    // Destroy the weak: pop smaller numbers from the back of the queue
    while (q.length > 0 && nums[q[q.length - 1]] < nums[r]) {
        q.pop();
    }
    
    // Add the new guy's index
    q.push(r);

    // Kick out the expired guy if the window slid past him
    if (l > q[0]) {
        q.shift();
    }

    // Record the winner once our window reaches size k
    if (r + 1 >= k) {
        res.push(nums[q[0]]);
        l++;
    }
    
    // Move the front of the window forward
    r++;
}

return res;}
}
