// class MinStack {
//     Stack<Integer> stack;
//     public MinStack() {
//         stack = new Stack<>();
//     }
    
//     public void push(int val) {
//         stack.push(val);
//     }
    
//     public void pop() {
//         stack.pop();
//     }
    
//     public int top() {
//         return stack.peek();
//     }
    
//     public int getMin() {
//         int min = Integer.MAX_VALUE;
//         for(int k : stack){
//             min = Math.min(k,min);
//         }
//         return min;
//     }
// }

class MinStack {
    Stack<Integer> stack;
    Stack<Integer> minStack;
    public MinStack() {
        stack = new Stack<>();
        minStack = new Stack<>();
    }
    
    public void push(int val) {
        stack.push(val);
        if(minStack.isEmpty() || minStack.peek()>=val){
            minStack.push(val);
        }
    }
    
    public void pop() {
        int top = stack.pop();
        if(minStack.peek() == top){
            minStack.pop();
        }
    }
    
    public int top() {
        return stack.peek();
    }
    
    public int getMin() {
        return minStack.peek();
    }
}
