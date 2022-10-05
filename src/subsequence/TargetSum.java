package subsequence;

public class TargetSum {
    static int mod =(int)(Math.pow(10,9)+7);

    static int findWays(int []num, int tar){
        int n = num.length;

        int[][] dp=new int[n][tar+1];

        if(num[0] == 0) dp[0][0] =2;  // 2 cases -pick and not pick
        else dp[0][0] = 1;  // 1 case - not pick

        if(num[0]!=0 && num[0]<=tar) dp[0][num[0]] = 1;  // 1 case -pick

        for(int ind = 1; ind<n; ind++){
            for(int target= 0; target<=tar; target++){

                int notTaken = dp[ind-1][target];

                int taken = 0;
                if(num[ind]<=target)
                    taken = dp[ind-1][target-num[ind]];

                dp[ind][target]= (notTaken + taken)%mod;
            }
        }
        return dp[n-1][tar];
    }

    static int targetSum(int n, int target,int[] arr){
        int totSum = 0;
        for(int i=0; i<n;i++){
            totSum += arr[i];
        }

        //Checking for edge cases
        if(totSum-target <0 || (totSum-target)%2==1 ) return 0;

        return findWays(arr,(totSum-target)/2);
    }


    public static void main(String args[]) {

        int arr[] = {1,2,3,1};
        int target=3;

        int n = arr.length;
        System.out.println("The number of ways found is "+targetSum(n,target,arr));
    }
}
