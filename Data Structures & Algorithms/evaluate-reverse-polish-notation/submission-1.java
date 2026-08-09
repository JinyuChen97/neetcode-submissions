class Solution {
    public int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<>();
        int res = 0;
        for(String t : tokens){
            if(t.matches("-?\\d+")){
                stack.push(Integer.parseInt(t));
            }else{
                if(stack.isEmpty()){
                    return 0;
                }
                if(t.equals("+")){
                    int one = stack.pop();
                    int two = stack.pop();
                    int sum = one+two;
                    stack.push(sum);
                }else if(t.equals("*")){
                    int one = stack.pop();
                    int two = stack.pop();
                    int pro = one*two;                   
                    stack.push(pro);
                }else if(t.equals("-")){
                    int one = stack.pop();
                    int two = stack.pop();
                    int min = two-one;
                    stack.push(min);
                }else if(t.equals("/")){
                    int one = stack.pop();
                    int two = stack.pop();
                    int div = two/one;
                    stack.push(div);
                }
            }
        }
        return stack.peek();
    }
}
