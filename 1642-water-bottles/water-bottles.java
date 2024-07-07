class Solution {
    public int numWaterBottles(int numBottles, int numExchange) {
        int numWaterBottles = numBottles;
        while(numBottles >= numExchange) {
            numWaterBottles+=numBottles/numExchange;
            numBottles=numBottles/numExchange + numBottles%numExchange;
        }
        return numWaterBottles;
    }
}