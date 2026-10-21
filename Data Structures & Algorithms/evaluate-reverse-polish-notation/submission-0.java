class Solution {
    public int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<>();
        for(String token : tokens){
            if(token.equals("+")){
                stack.push(stack.pop() + stack.pop());
            }else if (token.equals("-")){
                int last = stack.pop();
                stack.push(stack.pop() - last);
            }else if (token.equals("*")){
                stack.push(stack.pop() * stack.pop());
            }else if (token.equals("/")){
                int last = stack.pop();
                stack.push(stack.pop() /last);
            }else{
                stack.push(Integer.parseInt(token));
            }
        }
        return stack.pop();
    }
}
