package GridDP;

public class NinjaTraining {
    public static void main(String[] args){
        int[][] points = {{10,40,70},
                {20,50,80},
                {30,60,90}};

        int n = points.length;
        int ans=findmaximum(points,n);
        System.out.println(ans);
    }

    private static int findmaximum(int[][] points, int n) {
        int[][] dp=new int[points.length][points[0].length];


        for(int i=0;i<points[0].length;i++){
            dp[0][i]=points[0][i];
        }

        for(int i=1;i<points.length;i++){
            for(int j=0;j<points[0].length;j++){
                int ans=Integer.MIN_VALUE;
                for(int k=0;k<points[0].length;k++){
                    if(k!=j){
                         ans=Math.max(ans,dp[i-1][k]);
                    }
                }
                dp[i][j]=points[i][j]+ans;
            }
        }

        int anss=Integer.MIN_VALUE;
        for(int i=0;i<points[0].length;i++){
            anss=Math.max(anss,dp[n-1][i]);
        }
        return anss;
    }
}
