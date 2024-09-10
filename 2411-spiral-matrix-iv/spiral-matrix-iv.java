/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public int[][] spiralMatrix(int m, int n, ListNode head) {
        int i=0, j=0, cur_d = 0;
        int[][] direction = {{0,1}, {1,0}, {0,-1}, {-1,0}};

        int[][] res = new int[m][n];
        for(int[] wor : res) Arrays.fill(wor, -1);

        while(head != null) {
            res[i][j] = head.val;
            int new_i = i + direction[cur_d][0];
            int new_j = j + direction[cur_d][1];

            if( new_i < 0 || new_j < 0
                || new_i >= m
                || new_j >= n
                || res[new_i][new_j] != -1) cur_d = (cur_d+1)%4;
            
            i+=direction[cur_d][0];
            j+=direction[cur_d][1];

            head = head.next;
        }
        return res;
    }
}