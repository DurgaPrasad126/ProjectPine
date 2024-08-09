class FizzBuzz {
    private int n;
    private int i;

    public FizzBuzz(int n) {
        this.n = n;
        this.i = 1;
    }

    // printFizz.run() outputs "fizz".
    public synchronized void fizz(Runnable printFizz) throws InterruptedException {
        while(i<=n){
            if(i%3 == 0 && i%5 !=0) {
                printFizz.run();
                i++;
                notifyAll();
            }
            else{
                waitForTurn();
            }

        }
    }

    // printBuzz.run() outputs "buzz".
    public synchronized void buzz(Runnable printBuzz) throws InterruptedException {
        while(i<=n){
            if(i%3 != 0 && i%5 ==0) {
                printBuzz.run();
                i++;
                notifyAll();
            }
            else{
                waitForTurn();
            }

        }
    }

    // printFizzBuzz.run() outputs "fizzbuzz".
    public synchronized void fizzbuzz(Runnable printFizzBuzz) throws InterruptedException {
         while(i<=n){
            if(i%3 == 0 && i%5 ==0) {
                printFizzBuzz.run();
                i++;
                notifyAll();
            }
            else{
                waitForTurn();
            }

        }
    }

    // printNumber.accept(x) outputs "x", where x is an integer.
    public synchronized void number(IntConsumer printNumber) throws InterruptedException {
         while(i<=n){
            if(i%3 != 0 && i%5 !=0) {
                printNumber.accept(i);
                i++;
                notifyAll();
            }
            else{
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