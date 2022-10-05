package subsequence;

public class PartitionEqualSumSubset {
    static boolean canPartition(int n,int[] arr){

        int totSum=0;

        for(int i=0; i<n;i++){
            totSum+= arr[i];
        }

        if (totSum%2==1) return false;

        else{
            int k = totSum/2;
            boolean dp[][]=new boolean[n][k+1];

            for(int i=0; i<n; i++){
                dp[i][0] = true;
            }

            if(arr[0]<=k)
                dp[0][arr[0]] = true;

            for(int ind = 1; ind<n; ind++){
                for(int target= 1; target<=k; target++){

                    boolean notTaken = dp[ind-1][target];

                    boolean taken = false;
                    if(arr[ind]<=target)
                        taken = dp[ind-1][target-arr[ind]];

                    dp[ind][target]= notTaken||taken;
                }
            }

            return dp[n-1][k];

        }
    }

    public static void main(String args[]) {

        int arr[] = {2,3,3,3,4,5};
        int n = arr.length;

        if(canPartition(n,arr))
            System.out.println("The Array can be partitioned into two equal subsets");
        else
            System.out.println("The Array cannot be partitioned into two equal subsets");
    }
}
