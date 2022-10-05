package subsequence;

public class WaysToCoinChange {
    public static void main(String args[]) {

        int arr[] ={1,2,3};
        int target=4;

        int n =arr.length;

        System.out.println("The total number of ways is "+countWaysToMakeChange(arr,n,
                target));
    }

    private static long countWaysToMakeChange(int[] arr, int n, int target) {

        long[][]dp=new long[n][target+1];

        for(int i=0;i<=target;i++){
            if(i%arr[0]==0){
                dp[0][i]=1;
            }
        }


        for(int i=1;i<n;i++){
            for(int j=0;j<=target;j++){
                long notTake=dp[i-1][j];
                long take=0;

                if(arr[i]<=j){
                    take=dp[i][j-arr[i]];
                }

                dp[i][j]=notTake+take;
            }
        }

        return dp[n-1][target];
    }
}
