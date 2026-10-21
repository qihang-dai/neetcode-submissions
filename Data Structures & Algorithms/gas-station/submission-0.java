class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int allgas = 0;
        int allcost = 0;
        for(int g : gas){
            allgas += g;
        }
        for(int c : cost){
            allcost += c;
        }
        if(allgas < allcost) return -1;

        int validstart = 0;
        int tank = 0;
        for(int i = 0; i < 2 * gas.length; i++){
            tank += gas[i % gas.length] - cost[i%gas.length];
            if (tank < 0) {
                tank = 0;
                validstart = i + 1;
                continue;
            }
        }
        return tank >= 0 ? validstart : -1;
    }
}
