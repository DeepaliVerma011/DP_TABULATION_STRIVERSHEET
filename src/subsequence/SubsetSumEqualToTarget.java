package subsequence;

public class SubsetSumEqualToTarget {
    public static void main(String[] args){
        int arr[] = {1,2,3,4};
        int k=4;
        int n = arr.length;

        if(subsetSumToK(n,k,arr))
            System.out.println("Subset with given target found");
        else
            System.out.println("Subset with given target not found");

    }

    private static boolean subsetSumToK(int n, int k, int[] arr) {
        boolean[][] dp=new boolean[n][k+1];

        for(int i=0;i<n;i++){
            dp[i][0]=true;
        }

        if(arr[0]<=k){
            dp[0][arr[0]]=true;
        }

        for(int i=1;i<dp.length;i++){
            for(int j=1;j<dp[0].length;j++){
                boolean notTaken= dp[i-1][k];

                boolean taken=false;

                if(arr[i]<=k){
                    taken=dp[i-1][k-arr[i]];
                }

                dp[i][k]= notTaken||taken;
            }
        }
        return dp[n-1][k];
    }

}
