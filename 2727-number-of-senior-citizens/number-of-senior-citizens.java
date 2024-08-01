class Solution {
    public int countSeniors(String[] details) {
        int lessThan60 = 0;
        for(String detail : details) {
            
            if((6 == detail.charAt(11)-'0' && (0 < detail.charAt(12)-'0')) 
                    || (6 < detail.charAt(11)-'0')) 
                        lessThan60++;
        }
        return lessThan60;
    }
}