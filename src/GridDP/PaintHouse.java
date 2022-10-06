package GridDP;

public class PaintHouse {
    public static void main(String[] args){
        int[][] arr={{1,5,7},{5,8,4},{3,2,9},{1,2,4}};
        int ans=findMinCost(arr);
        System.out.println(ans);
    }

    private static int findMinCost(int[][] arr) {
        int[][] dp=new int[arr.length][arr[0].length];

        for(int i=0;i<arr[0].length;i++){
            dp[0][i]=arr[0][i];
        }

        for(int i=1;i< arr.length;i++){
            for(int j=0;j<arr[0].length;j++){
                int ans=Integer.MAX_VALUE;
                for(int k=0;k<arr[0].length;k++){
                    if(k!=j){
                        ans=Math.min(ans,dp[i-1][k]);
                    }
                }
                dp[i][j]=arr[i][j]+ans;
            }
        }
        int anss=Integer.MAX_VALUE;
        for(int i=0;i<arr[0].length;i++){
            anss=Math.min(anss,dp[dp.length-1][i]);
        }
        return anss;
    }
}
