class Solution {
    public String fractionAddition(String expression) {
       
       String[] split = expression.split("/");

       int n = split.length-1;

       int[] numer = new int[n];
       int[] denom = new int[n];

       numer[0] = Integer.parseInt(split[0]);
       denom[n-1] = Integer.parseInt(split[n]);

       for(int i=1;i<n;i++){

            if(split[i].contains("+")){
                //System.out.println(split[i]);
                String[] sub = split[i].split("\\+");
                denom[i-1] = Integer.parseInt(sub[0]);
                numer[i] = Integer.parseInt(sub[1]);
            }else{
                String[] sub = split[i].split("\\-");
                denom[i-1] = Integer.parseInt(sub[0]);
                numer[i] = -1*Integer.parseInt(sub[1]);
            }
       }

       long denominator = 1;
       for(int i : denom){
            denominator *= i;
       }

       long numerator =0;

        for(int i =0;i<n;i++){

            numerator += 1l*(numer[i])*(denominator/denom[i]);

        }

        int[] prime = {2,3,5,7};

        for(int i : prime){

            while(numerator%i==0 && denominator%i==0){
                numerator/=i;
                denominator/=i;
            }
        }

        return String.valueOf(numerator)+"/"+String.valueOf(denominator);

    }
}