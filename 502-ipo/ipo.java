class Solution {
    public int findMaximizedCapital(int k, int w, int[] profits, int[] capital) {
        PriorityQueue<int[]> queue = new PriorityQueue<>((a,b) -> b[0] - a[0]);
        int n = profits.length;
        List<Profit> pro = new ArrayList<>();

        for(int i=0;i<n;i++){
            pro.add(new Profit(profits[i], capital[i]));
            //queue.add(new int[]{profits[i], capital[i]});
        }
        int pos = 0;
        int maxProfit = 0;
        Collections.sort(pro, (a,b) -> a.capitl - b.capitl);
        
        while( k > 0 ) {
            while(pos< n && pro.get(pos).capitl <= w) {
                Profit p = pro.get(pos);
                //System.out.println(p.profit + " --- " + p.capitl);
                queue.add(new int[]{p.profit, p.capitl});
                pos++;
            }
            if(queue.isEmpty()) return w;
            //System.out.println(queue.size());
            int[] max = queue.poll();
            maxProfit+=max[0];
            w+=max[0];
            k--;
        }
        return w;

    }

    public class Profit {
        public int profit;
        public int capitl;

        public Profit(int profit, int capitl) {
            this.profit = profit;
            this.capitl = capitl;
        }
    }
}