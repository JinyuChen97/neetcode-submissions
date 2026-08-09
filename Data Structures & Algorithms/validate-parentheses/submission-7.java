class Solution {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        for(char sc : s.toCharArray()){
            if(sc == '(' || sc=='['||sc=='{'){
                stack.push(sc);
            }else{
                if(stack.isEmpty()){
                    return false;
                }

                if((sc == ')' && stack.pop()!='(') ||  (sc == ']' && stack.pop()!='[') || (sc == '}' && stack.pop()!='{')){
                    return false;
                }   
            }
    }
    return stack.size() == 0? true:false;
}
}
