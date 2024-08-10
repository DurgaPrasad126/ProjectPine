class ZeroEvenOdd {
    private int n;
    private int i;
    
    public ZeroEvenOdd(int n) {
        this.n = n;
        this.i = 1;
    }

    // printNumber.accept(x) outputs "x", where x is an integer.
    public synchronized void zero(IntConsumer printNumber) throws InterruptedException {
        while(i<=2*n){
            if(i%2==1){
                printNumber.accept(0);
                i++;
                notifyAll();
            }
            else waitTillTurn();
        }
    }

    public synchronized void even(IntConsumer printNumber) throws InterruptedException {
        while(i<=2*n){
            int k = i/2;
            if(i%2==0 && (k)%2 == 0){
                printNumber.accept(k);
                i++;
                notifyAll();
            }
            else waitTillTurn();
        }
    }

    public synchronized void odd(IntConsumer printNumber) throws InterruptedException {
        while(i<=2*n){
            int k = i/2;
            if(i%2==0 && (k)%2 == 1){
                printNumber.accept(k);
                i++;
                notifyAll();
            }
            else waitTillTurn();
        }
    }

    public void waitTillTurn(){
        try{
            wait();
        }
        catch(InterruptedException e){
            Thread.currentThread().interrupt();
        }
    }
}