public class canCompleteCircuit {
    public int Solution(int[] gas, int[] cost) {
        // Naive solution is O(N^2) in time
        // One pass O(N) time and O(1) space
        // Two variables: One tracks total sum(gas[i]-cost[i]) to check if eventually sol
        // is reached, second
        int total_tank = 0, curr_tank = 0, ans = 0;
        for (int i=0; i<gas.length; i++){
            total_tank += gas[i]-cost[i];
            curr_tank += gas[i]-cost[i];
            if (curr_tank<0){
                ans = i+1; // choose next index as the potential start point
                curr_tank = 0;
            }

        }
        return total_tank>=0 ? ans : -1;
    }
}
