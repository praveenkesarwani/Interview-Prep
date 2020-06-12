class ValidParenthesis {
public:
	bool isValid(string s) {
		//hashmap to store parenthesis pair
		unordered_map<char,char> parenthesis_pair;
		parenthesis_pair[')'] = '(';
		parenthesis_pair['}'] = '{';
		parenthesis_pair[']'] = '[';

		stack<char>st;
		for(int  i = 0;i < s.size();i++){
			char c = s[i];
			if(parenthesis_pair.count(c) > 0){ // closing parenthesis
				char top_element = st.empty()?'#':st.top(); // #: add dummy char
				st.pop();
				if(top_element != parenthesis_pair[c])
					return false; //no matching parenthesis found on stack
			}
			else			// opening parenthesis
				st.push(c); // Add to stack
		}
		return st.empty();	//if not empty, failure 
	}
};
/*
Time Complexity: O(N), N is the length of the string 
Space Complexity: O(N), since we may have to store up to N chars in the worst case
*/
