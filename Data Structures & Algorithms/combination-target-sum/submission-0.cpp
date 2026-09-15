class Solution {
public:
    vector<vector<int>> combinationSum(vector<int>& nums, int target) {
        vector<vector<int>> res;
        vector<int> comb;
        backtrack(0, target, comb, nums, res);
        return res;
    }

private:
    void backtrack(int i, int target, vector<int>& comb, vector<int>& nums, vector<vector<int>>& res) {
        if (target == 0) {
            res.push_back(comb);
            return;
        }
        if (i >= nums.size() || target < 0) {
            return;
        }

        // Decision 1: Include the current element
        comb.push_back(nums[i]);
        backtrack(i, target - nums[i], comb, nums, res);
        comb.pop_back();

        // Decision 2: Skip the current element
        backtrack(i + 1, target, comb, nums, res);
    }
};