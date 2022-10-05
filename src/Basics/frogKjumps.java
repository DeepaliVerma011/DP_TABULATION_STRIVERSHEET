package Basics;

public class frogKjumps {
    public static void main(String[] args){
        int height[]={30,10,60,10,60,50};
        int k=2;
        int ans= frogKjump(height,k);
        System.out.println(ans);
    }

    private static int frogKjump(int[] height, int k) {
        int n=height.length;
        int[] dp=new int[n];
        dp[0]=0;
        for(int i=1;i<n;i++){
            int mmSteps = Integer.MAX_VALUE;

            for(int j=1;j<=k;j++){
                if(i-j>=0){
                    int jump = dp[i-j]+ Math.abs(height[i]- height[i-j]);
                    mmSteps= Math.min(jump, mmSteps);
                }
            }
            dp[i]= mmSteps;
        }
        return dp[n-1];
    }
}
