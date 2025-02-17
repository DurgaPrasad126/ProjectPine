class ProductOfNumbers {
    int[] product;
    int pos;
    public ProductOfNumbers() {
        product = new int[40000];
        pos = 0;
    }
    
    public void add(int num) {
        if(num == 0) {
            product = new int[40000];
            pos = 0;
        }
        else {
            if(pos == 0) {
                product[pos++]=num;
            }
            else {
                product[pos]=product[pos-1]*num;
                pos++;
            }
        }
    }
    
    public int getProduct(int k) {
        if(k > pos) return 0;
        else if(k==pos) {
            return product[k-1];
        }
        else return product[pos-1]/product[pos-k-1];
    }
}

/**
 * Your ProductOfNumbers object will be instantiated and called as such:
 * ProductOfNumbers obj = new ProductOfNumbers();
 * obj.add(num);
 * int param_2 = obj.getProduct(k);
 */