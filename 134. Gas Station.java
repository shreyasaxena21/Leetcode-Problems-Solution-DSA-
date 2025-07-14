class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int totalSurplus = 0;  // Total net fuel balance
        int currentSurplus = 0;  // Current fuel surplus from a starting point
        int startingPoint = 0;

        for (int i = 0; i < gas.length; i++) {
            int netGain = gas[i] - cost[i];
            totalSurplus += netGain;
            currentSurplus += netGain;

            if (currentSurplus < 0) {
                // Can't go from current startingPoint to i
                startingPoint = i + 1;
                currentSurplus = 0;
            }
        }

        return totalSurplus >= 0 ? startingPoint : -1;
    }
}
