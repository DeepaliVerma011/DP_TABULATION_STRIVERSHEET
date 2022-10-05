package StockBuyNSell;

public class InfiniteTransactionWithCooldown {
    public static void main(String args[]) {

        int n =5;
        int Arr[] = {4,9,0,4,10};

        System.out.println("The maximum profit that can be generated is "+getMaximumProfit(Arr, n));
    }

    private static int getMaximumProfit(int[] arr, int n) {
        int[][] dp=new int[n][2];

        for(int i=0;i<dp.length;i++){
            for(int j=0;j<dp[0].length;j++){
                dp[i][j]=-1;
            }
        }
        if(n==0) return 0;
        int ans=findprofit(arr,0,0,dp,n);
        return ans;
    }

    private static int findprofit(int[] arr, int i, int buy, int[][] dp, int n) {
        if(i>=n) return 0;

        if(dp[i][buy]!=-1) return dp[i][buy];
        int profit=0;

        if(buy==0){
            profit=Math.max(0+findprofit(arr,i+1,0,dp,n),-arr[i]+findprofit(arr,i+1,1,dp,n));
        }

        if(buy==1){
            profit=Math.max(0+findprofit(arr,i+1,1,dp,n),arr[i]+findprofit(arr,i+2,0,dp,n));
        }

        return dp[i][buy]=profit;
    }
}
