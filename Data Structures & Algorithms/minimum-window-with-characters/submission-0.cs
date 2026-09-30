public class Solution {
    public string MinWindow(string s, string t) {
        if (string.IsNullOrEmpty(s) || string.IsNullOrEmpty(t) || s.Length < t.Length) {
            return "";
        }

        // Map to store character frequencies of string t
        int[] tCounts = new int[128];
        foreach (char c in t) {
            tCounts[c]++;
        }

        int left = 0, right = 0;
        int minLen = int.MaxValue;
        int startIdx = 0;
        int requiredChars = t.Length;

        // Sliding window
        while (right < s.Length) {
            // Expand the window by including the character at the right pointer
            char rightChar = s[right];
            if (tCounts[rightChar] > 0) {
                requiredChars--;
            }
            tCounts[rightChar]--;
            right++;

            // Shrink the window from the left if it contains all required characters
            while (requiredChars == 0) {
                // Update the minimum window if a smaller one is found
                if (right - left < minLen) {
                    minLen = right - left;
                    startIdx = left;
                }

                char leftChar = s[left];
                tCounts[leftChar]++;
                // If a required character is completely pushed out of the window
                if (tCounts[leftChar] > 0) {
                    requiredChars++;
                }
                left++;
            }
        }

        return minLen == int.MaxValue ? "" : s.Substring(startIdx, minLen);
    }
}
