class Solution {
    public int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<>();
        for(String t:tokens){
            if(!t.equals("+")&&!t.equals("-")&&!t.equals("*")&&!t.equals("/")){
                stack.push(Integer.parseInt(t));
            }else{
                int one = stack.pop();
                int two = stack.pop();

                if(t.equals("+")){
                    stack.push(two+one);
                }else if(t.equals("/")){
                    stack.push(two/one);
                }else if(t.equals("*")){
                    stack.push(two*one);
                }else{
                    stack.push(two-one);
                }
            }
        }
        return stack.peek();
    }
}
