class Solution {
    public int[] xorQueries(int[] arr, int[][] queries) {
        int ar[]=new int[queries.length];
        int sum=0;
        for(int i=0;i<queries.length;i++)
        {
            sum=0;
           for(int j=queries[i][0];j<=queries[i][1];j++)
           {
               
              sum^=arr[j];
           }
          ar[i]= sum;
            System.out.print(sum);
        }
        return ar;
    }
}