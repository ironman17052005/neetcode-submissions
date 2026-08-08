class Solution:
    def validPalindrome(self, s: str) -> bool:
        l = 0
        r = len(s) -1

        while l < r:
            if s[l] != s[r]:
                return (self.isPal(s, l+1, r) or self.isPal(s,l,r-1))
            l+=1
            r-=1
        return True



    def isPal(self,s, l, r):
        while l < r:
            if s[l] == s[r]:
                l+=1
                r-=1
            else:
                return False
        return True