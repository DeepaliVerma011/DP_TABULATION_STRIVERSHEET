package JumpVariations;

public class ClimbingStairs_MinimumCost {
    public static void main(String[] args){
        int[] arr={10,15,20};
        int ans=minCostClimbingStairs(arr);
        System.out.println(ans);
    }
    public static int minCostClimbingStairs(int[] cost) {
        for (int i = 2; i < cost.length; i ++) {
            cost[i] += Math.min(cost[i - 1], cost[i - 2]);
        }
        return Math.min(cost[cost.length - 1], cost[cost.length - 2]);
    }

}
