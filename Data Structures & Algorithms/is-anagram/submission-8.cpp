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


        }
        for(int j = 0; j < t.size(); j++){
            array[t[j]-'a']--;


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
