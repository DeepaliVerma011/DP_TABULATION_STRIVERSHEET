package JumpVariations;

public class JumpGame_WaysToClimbStairWithVariableJumps {
    public static void main(String[] args){
        int[] arr={3,2,1,0,4};
        int ans=findans(arr);
        System.out.println("The number of ways to reach the end are"+ ans);
    }

    private static int findans(int[] arr) {
        int n=arr.length;
        int[] dp = new int[n + 1];
        dp[n] = 1;

        for (int i = n - 1; i >= 0; i--) {
            if (arr[i] > 0) {
                for (int j = 1; j <= arr[i] && i + j < dp.length; j++) {
                    dp[i] += dp[i + j];
                }
            }
        }

        return dp[0];
    }
}
