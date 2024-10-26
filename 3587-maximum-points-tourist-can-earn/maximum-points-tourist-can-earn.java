class Solution {
    public int maxScore(int n, int k, int[][] stayScore, int[][] travelScore) {
        
        int[][] cityDayMemo = new int[n][k];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < k; j++) {
                cityDayMemo[i][j] = -1;
            }
        }
        int ans =-1;
        for(int i=0;i<n;i++){
            int chance = findMax(stayScore,travelScore,n,k,cityDayMemo,i,0);
            if(chance>ans){
                ans = chance;
            }
        }
        return ans;
    }

    public int findMax(int[][] stayScore,int[][] travelScore,int n,int k,int[][]cityDayMemo,int city,int day){
        if(day==k-1){
            int ans = stayScore[day][city];
            for(int i=0;i<n;i++){
                int chance = travelScore[city][i];
                if(chance>ans) ans= chance;
            }
            cityDayMemo[city][day] = ans;
        }else if(cityDayMemo[city][day]==-1){
            int ans = -1;
            for(int i=0;i<n;i++){
                int chance = findMax(stayScore,travelScore,n,k,cityDayMemo,i,day+1);
                if(i==city){
                    chance += stayScore[day][city];
                }else{
                    chance += travelScore[city][i];
                }
                if(chance>ans) ans= chance;
            }
            cityDayMemo[city][day] = ans;
        }
        return cityDayMemo[city][day];
    }
}