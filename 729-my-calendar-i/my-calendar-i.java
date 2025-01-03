class MyCalendar {
    List<int[]> slots;
    public MyCalendar() {
        slots = new ArrayList<>();
    }
    
    public boolean book(int start, int end) {
        for(int[] slot : slots) {
            if(slot[0] < end && slot[1] > start) return false;
        }
        slots.add(new int[]{start,end});
        return true;
        
    }
}

/**
 * Your MyCalendar object will be instantiated and called as such:
 * MyCalendar obj = new MyCalendar();
 * boolean param_1 = obj.book(start,end);
 */