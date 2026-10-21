class Solution {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        Map<Character, Character> match = new HashMap<>();
        match.put(')','(');
        match.put('}', '{');
        match.put(']', '[');


        for(char c : s.toCharArray()){
            if(c == '(' || c == '{' || c == '[') {
                stack.push(c);
            }else{
                if(stack.isEmpty() || stack.pop() != match.get(c)){
                    return false;
                }
            }
        }

        return stack.isEmpty();
    }
}
