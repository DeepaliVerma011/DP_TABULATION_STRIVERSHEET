package subsequence;

public class PartitionSubsetWithMinimumAbsoluteDifference {
    public static void main(String[] args){
        int[] arr={8,6,5};
        int ans=findAns(arr);
        System.out.println(ans);
    }

    private static int findAns(int[] arr) {
        int totSum=0;
        int n=arr.length;
        for(int i=0;i<arr.length;i++){
            totSum+=arr[i];
        }

        boolean[][] dp=new boolean[n][totSum+1];
        for(int i=0;i<n;i++){
            dp[i][0]=true;
        }

        if(arr[0]<=totSum){
            dp[0][arr[0]]=true;
        }
        for(int i=1;i<n;i++){
            for(int j=1;j<=totSum;j++){
                boolean notTaken= dp[i-1][j];

                boolean taken=false;
                if(arr[i]<=totSum && j>arr[i]){
                    taken=dp[i-1][j-arr[i]];
                }
                dp[i][j]=taken||notTaken;
            }


        }

        int mini = (int)Math.pow(10,9)+1;
        for (int i = 0; i <= totSum; i++) {
            if (dp[n - 1][i] == true) {
                int diff = Math.abs(i - (totSum - i));
                mini = Math.min(mini, diff);
            }
        }
       return mini;
    }
}
