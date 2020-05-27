/*
Find index of closing bracket for a given opening bracket in an expression
Input : string = [ABC[23]][89]
        index = 0
Output : 8
*/
#include <iostream>
#include <stack>
#include<unordered_map>
using namespace std;

int findIndex(string s ,int index){
    if(s[index] != '[' && s[index] != '{' && s[index] != '(')
        return -1;
    unordered_map<char,char>pair;
    pair[')'] = '(';
    pair['}'] = '{';
    pair[']'] = '[';
    stack<char>st;
    for(int i = index;i < s.size();i++){
        if(s[i] == '(' || s[i] == '{' || s[i] == '[')
            st.push(s[i]);
        // it also check that the parenthesis are balanced
        else if(pair.count(s[i]) > 0 && st.top() == pair[s[i]]){
            st.pop();
            if(st.size() == 0)
                return i;
        }
    }
    return -1;
}
int main() {
    string s;
    cin>>s;
    int index;
    cin>>index;
    cout<<findIndex(s,index);
}
/*
[ABC{23}][89] 4; // should be 7 
[ABC[23]][89] 4; // should be 7 
[ABC[23]][89] 9; // should be 12 
[ABC[23]][89] 1; // No matching bracket 
[A(B]C[23]][89] 2 // not balanced, -1
*/