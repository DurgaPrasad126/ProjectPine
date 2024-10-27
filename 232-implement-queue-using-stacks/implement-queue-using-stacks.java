class MyQueue {
    Stack<Integer> s1;
    Stack<Integer> s2;
    int peek;
    public MyQueue() {
        s1 = new Stack<>();
        s2 = new Stack<>();

    }
    
    public void push(int x) {
        if(s1.isEmpty()) peek = x;
        s1.push(x);

    }
    
    public int pop() {
        while(s1.size() > 1) {
            s2.push(s1.pop());
        }
        int remEle = s1.pop();
        while(!s2.isEmpty()) {
            int rem = s2.pop();
            if(s1.isEmpty()) peek = rem;
            s1.push(rem);
        }
        
        return remEle;
    }
    
    public int peek() {
        return peek;
    }
    
    public boolean empty() {
        return s1.isEmpty();
    }
}

/**
 * Your MyQueue object will be instantiated and called as such:
 * MyQueue obj = new MyQueue();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.peek();
 * boolean param_4 = obj.empty();
 */