class Solution {
public:
    bool isAnagram(string s, string t) {
        int array[26];
            if(s.size() != t.size()){
                return false;
            }

            bool isEmpty = true;
        for(int i = 0; i < s.size(); i++){
            array[s[i]-'a']++;
            array[t[i]-'a']--;


        }
        

      
        for(int i = 0; i < 26; i++){
            if(array[i]){
                isEmpty = false;
break;
            } 
        }
        if(isEmpty){
            return true;
        }


        return 0;
        
    }
};
