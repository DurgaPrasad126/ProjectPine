class FooBar {
    private int n;
    private int i;

    public FooBar(int n) {
        this.n = n;
        this.i = 0;
    }

    public synchronized void foo(Runnable printFoo) throws InterruptedException {
        
        while(i<2*n) {
            
        	// printFoo.run() outputs "foo". Do not change or remove this line.
        	if(i%2==0){
                printFoo.run();
                i++;
                notifyAll();
            }
            else {
                waitTillTurn();
            }
            
        }
    }

    public synchronized void bar(Runnable printBar) throws InterruptedException {
        
        while(i<2*n) {
            
            // printBar.run() outputs "bar". Do not change or remove this line.
        	if(i%2==1){
                printBar.run();
                i++;
                notifyAll();
            }
            else {
                waitTillTurn();
            }
            
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