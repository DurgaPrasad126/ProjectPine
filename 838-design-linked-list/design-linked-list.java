class MyLinkedList {
    Node head, tail;
    int size;

    static class Node {
        int val;
        Node next;
        Node prev;

        Node(int val) {
            this.val = val;
        }
    }

    public MyLinkedList() {
        this.size = 0;
        this.head = new Node(0);
        this.tail = new Node(0);
        head.next = tail;
        tail.prev = head;
        // printList(head);
        
        // System.out.println();
    }
    
    public int get(int index) {
        if(index >= size) {
            return -1;
        }
        Node dummyNode = head;
        while(index > 0) {
            dummyNode = dummyNode.next;
            index--;
        }

        return dummyNode.next.val;
        
    }
    
    public void addAtHead(int val) {
        Node curNode = new Node(val);

        curNode.next = head.next;
        curNode.prev = head;
        head.next.prev = curNode;
        head.next = curNode;
        size++;
        // printList(head);
        
        // System.out.println();
    }
    
    public void addAtTail(int val) {
        Node curNode = new Node(val);
        
        // System.out.println(tail.val);
        tail.prev.next = curNode;
        curNode.prev = tail.prev;
        curNode.next = tail;
        tail.prev = curNode;
        size++;
        // printList(head);
        // System.out.println();
    }
    
    public void addAtIndex(int index, int val) {
        if(index > size) return;
        if(index == size) {
            addAtTail(val);
            return;
        }
        Node dummyHead = head;
        while(index > 0) {
            dummyHead = dummyHead.next;
            index--;
        }
        Node nextNode = dummyHead.next;
        Node curNode = new Node(val);
        dummyHead.next = curNode;
        curNode.prev = dummyHead;
        curNode.next = nextNode;
        nextNode.prev = curNode;
        size++;
        // printList(head);
        
        // System.out.println();
    }
    
    public void deleteAtIndex(int index) {
        if(index >= size) return;
        Node dummyNode = head;
        while(index > 0 ) {
            dummyNode = dummyNode.next;
            index--;
        }
        Node toBeRemoved = dummyNode.next;
        // printList(head);
        
        // System.out.println();

        dummyNode.next = toBeRemoved.next;
        toBeRemoved.next.prev = dummyNode;
        toBeRemoved.next = null;
        toBeRemoved.prev = null;
        size--;
        // System.out.println("deleted " + toBeRemoved.val);
    }

    public void printList(Node head) {
        Node pointer = head;
        while(pointer != null) {
            System.out.print(pointer.val + " --> ");
            pointer = pointer.next;
        }
    }
}

/**
 * Your MyLinkedList object will be instantiated and called as such:
 * MyLinkedList obj = new MyLinkedList();
 * int param_1 = obj.get(index);
 * obj.addAtHead(val);
 * obj.addAtTail(val);
 * obj.addAtIndex(index,val);
 * obj.deleteAtIndex(index);
 */