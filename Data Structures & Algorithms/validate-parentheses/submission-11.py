class Solution:
    def isValid(self, s: str) -> bool:
        stack = []
        if len(s) % 2 == 1:
            return False
        
        for c in s:
            
            if c == "(" or c == "{" or c == "[":
                stack.append(c)
            elif stack and( c == ")" and stack[-1] == "(" or c == "}" and stack[-1] == "{" or c == "]" and stack[-1] == "["):
                    stack.pop()

            else:
                    return False

        return not stack
            
    
