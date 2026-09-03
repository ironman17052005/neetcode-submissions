class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        // Ensure nums1 is the smaller array to optimize the binary search
        if (nums1.length > nums2.length) {
            return findMedianSortedArrays(nums2, nums1);
        }

        int m = nums1.length;
        int n = nums2.length;
        int low = 0;
        int high = m;
        int totalLength = m + n;

        while (low <= high) {
            int i = low + (high - low) / 2; // Partition for nums1
            int j = (totalLength + 1) / 2 - i; // Partition for nums2

            // Edge cases for boundaries
            int nums1Left = (i == 0) ? Integer.MIN_VALUE : nums1[i - 1];
            int nums1Right = (i == m) ? Integer.MAX_VALUE : nums1[i];
            int nums2Left = (j == 0) ? Integer.MIN_VALUE : nums2[j - 1];
            int nums2Right = (j == n) ? Integer.MAX_VALUE : nums2[j];

            // Check if the partition is valid
            if (nums1Left <= nums2Right && nums2Left <= nums1Right) {
                // If total length is odd
                if (totalLength % 2 != 0) {
                    return Math.max(nums1Left, nums2Left);
                }
                // If total length is even
                return (Math.max(nums1Left, nums2Left) + Math.min(nums1Right, nums2Right)) / 2.0;
            } else if (nums1Left > nums2Right) {
                // Move towards the left in nums1
                high = i - 1;
            } else {
                // Move towards the right in nums1
                low = i + 1;
            }
        }

        return 0.0;
    }
}