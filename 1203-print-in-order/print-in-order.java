class Foo {
    private int i;
    public Foo() {
        this.i=1;
    }

    public synchronized void first(Runnable printFirst) throws InterruptedException {
        while(i<=3){
            if(i==1){
                printFirst.run();
                i++;
                notifyAll();
            }
            else {
                waitForTurn();
            }
        }
        // printFirst.run() outputs "first". Do not change or remove this line.
    }

    public synchronized void second(Runnable printSecond) throws InterruptedException {
        while(i<=3){
            if(i==2){
                printSecond.run();
                i++;
                notifyAll();
            }
            else {
                waitForTurn();
            }
        }
    }

    public synchronized void third(Runnable printThird) throws InterruptedException {
       while(i<=3){
            if(i==3){
                printThird.run();
                i++;
                notifyAll();
            }
            else {
                waitForTurn();
            }
        }
    }

    public void waitForTurn(){
        try{
            wait();

        }
        catch(InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}