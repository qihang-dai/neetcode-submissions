class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {

        int validstart = 0;
        int tank = 0;
        int totalGasAvailability = 0;
        for(int i = 0; i <  gas.length; i++){
            tank += gas[i] - cost[i];
            totalGasAvailability += gas[i] - cost[i];

            if (tank < 0) {
                tank = 0;
                validstart = i + 1;
                continue;
            }
        }
        return totalGasAvailability >= 0? validstart : -1;
    }
}
