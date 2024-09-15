class Solution {
    public int findTheLongestSubstring(String s) {
        // storing the vowels for checking
		HashSet<Character> set= new HashSet<>();
        set.add('a');
        set.add('e');
        set.add('i');
        set.add('o');
        set.add('u');
		
		// hash map to maintain the xor and their respective first occurence index
        HashMap<Integer, Integer> map= new HashMap<>();
		
		// for the substrings for which it starts from 0
        map.put(0, -1);
		
		// initially all the vowels are 0count which is even
        int xor=0;
		
        // longest substring initailly is 0
		int maxLen=0;
        
		// traversing the array
		for(int i=0; i<s.length(); i++){
		
		    // checking if the character is vowel or not
            if(set.contains(s.charAt(i))){
				// if it is vowel then we xor(trigger) the respective bit of the vowel and we ignore for the consonent as xor=xor^0=xor
                xor^=(s.charAt(i)-'a'+1);   
            }
			
			// if we didnt come across the same xor that means there are no even valued vowels as of now
            if(!map.containsKey(xor)){
				// we encounter the xor first time so we put their first index of occurence
                map.put(xor, i);
            }
			
			// NOTE: we could have put this in else part but if we have no even valued vowels so the maxlength will be i-i=0
			// here we update if we had any xor value that we encountered before then 
			// we check the longest substring which have even counts of vowels.
            maxLen=Math.max(maxLen, i-map.get(xor));
        }
        
        return maxLen;
    }
}