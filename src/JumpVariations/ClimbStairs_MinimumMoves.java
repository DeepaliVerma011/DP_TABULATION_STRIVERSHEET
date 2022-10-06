package JumpVariations;

public class ClimbStairs_MinimumMoves {
    public static void main(String[] args){
        int[] arr={3,3,0,2,1,2,4,2,0,0};
        int ans=findans(arr);
        System.out.println("The minimum moves to reach the end are"+ ans);
    }

    private static int findans(int[] arr) {
        int n=arr.length;
        Integer[] dp = new Integer[n + 1];
        dp[n] = 0;

        for (int i = n - 1; i >= 0; i--) {
            if (arr[i] > 0) {
                int min = Integer.MAX_VALUE;

                for (int j = 1; j <= arr[i] && i + j < dp.length; j++) {
                    if(dp[i + j] != null){
                        min = Math.min(min, dp[i + j]);
                    }
                }

                if(min != Integer.MAX_VALUE){
                    dp[i] = min + 1;
                }
            }
        }

        return dp[0];
    }

}
