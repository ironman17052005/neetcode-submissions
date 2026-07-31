class Solution:
    def lengthOfLongestSubstring(self, s: str) -> int:
        l = 0
        r = 0
        max = 0
        hash ={}

        while r<len(s):
            if s[r] in hash and hash[s[r]] >= l:
                l=hash[s[r]]+1

            hash[s[r]] = r

            count = r-l+1
            if count>max:
                max = count

            r+=1
        
        return max