class Solution {
    public boolean judgeSquareSum(int c) {
        int left = 0;
        int right = (int)Math.ceil(Math.sqrt(c));

        while(left <= right) {
            long rightProduct = (long)right*right;
            long sumSq = (long)(left*left) + rightProduct;
            System.out.println(sumSq);
            if(c==sumSq) return true;
            else if(sumSq > c) right--;
            else left++;
        }
        return false;
    }
}