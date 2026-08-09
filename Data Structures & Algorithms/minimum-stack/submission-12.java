class MinStack {
    long min;
    Stack<Long> stack;
    public MinStack() {
        stack = new Stack<>();
    }
    
    public void push(int val) {
        if(stack.isEmpty()){
            stack.push(0L);
            min = val;
        }else{
            stack.push(val-min);
            if(val<min) min = val;
        }
        

    }
    
    public void pop() {
        if (stack.isEmpty()) return;
        long top = stack.pop();
        if(top<0){
            min = min-top;
        }

    }
    
    public int top() {
        long top = stack.peek();
        if(top>0){
            return (int)(min+top);
        }else{
            return (int)min;
        }
    }
    
    public int getMin() {
        return (int)min;
    }
}

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

// class MinStack {
//     Stack<Integer> stack;
//     Stack<Integer> minStack;
//     public MinStack() {
//         stack = new Stack<>();
//         minStack = new Stack<>();
//     }
    
//     public void push(int val) {
//         stack.push(val);
//         if(minStack.isEmpty() || minStack.peek()>=val){
//             minStack.push(val);
//         }
//     }
    
//     public void pop() {
//         int top = stack.pop();
//         if(minStack.peek() == top){
//             minStack.pop();
//         }
//     }
    
//     public int top() {
//         return stack.peek();
//     }
    
//     public int getMin() {
//         return minStack.peek();
//     }
// }
