class Solution {
    public boolean lemonadeChange(int[] bills) {
        int[] change = new int[3];
        
        for(int bill : bills) {
            if(bill == 5){
                change[0]++;
                //System.out.println(change[0] + " --- " + change[1] + " --- " + change[2]);
            }
            else if(bill == 10) {
                if(change[0] <= 0) return false;
                change[0]--; 
                change[1]++;
                //System.out.println(change[0] + " --- " + change[1] + " --- " + change[2]);

            }
            else {
                if((change[1] >= 1 && change[0] >= 1) || change[0] >= 3) 
                {
                    if(change[1] >= 1 && change[0] >= 1) {
                        change[1]--;
                        change[0]--;
                    }
                    else if(change[1] < 1 && change[0] >= 3) change[0]-=3;
                    change[2]++;
                    //System.out.println(change[0] + " --- " + change[1] + " --- " + change[2]);
                }
                else return false;
            }
        }
        return true;
    }
}