//Implement strStr()
class Solution {
    public int strStr(String haystack, String needle) {
        return haystack.indexOf(needle);
    }
}
/*
cpp solution
class Solution {
public:
    int strStr(string haystack, string needle) {
        if(needle.size()==0){
            return 0;
        }
        size_t found = haystack.find(needle);
        if(found!=string::npos){
            return found;
        }
        else{
            return -1;
        }
    }
};
*/