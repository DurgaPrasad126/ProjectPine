class Solution {
    public List<Integer> lexicalOrder(int n) {
        int number  = 1;
        List<Integer> lexicalNums = new ArrayList<>();

        for(int i=0;i<n;i++){
            lexicalNums.add(number);
            if(number * 10 <= n) {
                number*=10;
            }
            else {
                while(number%10 == 9 || number >= n) number/=10;
                number+=1;
            }
        }
        return lexicalNums;
    }
}