class FooBar {
    private int n;
    private boolean isFoo;
    private int i;

    public FooBar(int n) {
        this.n = n;
        this.isFoo = true;
        this.i = 0;
    }

    public synchronized void foo(Runnable printFoo) throws InterruptedException {
        
        while(i<2*n) {
            
        	// printFoo.run() outputs "foo". Do not change or remove this line.
        	if(isFoo){
                printFoo.run();
                i++;
                isFoo=false;
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
        	if(!isFoo){
                printBar.run();
                i++;
                isFoo=true;
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