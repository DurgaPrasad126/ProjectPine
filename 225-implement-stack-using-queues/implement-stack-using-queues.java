class MyStack {
    Deque<Integer> deq;   
    public MyStack() {
        deq = new ArrayDeque<>();
    }
    
    public void push(int x) {
        deq.addFirst(x);
    }
    
    public int pop() {
        if(!deq.isEmpty()) return deq.pollFirst();
        return -1;
    }
    
    public int top() {
        if(!deq.isEmpty()) return deq.peekFirst();
        return -1;
    }
    
    public boolean empty() {
        return deq.isEmpty();
    }
}

/**
 * Your MyStack object will be instantiated and called as such:
 * MyStack obj = new MyStack();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.top();
 * boolean param_4 = obj.empty();
 */