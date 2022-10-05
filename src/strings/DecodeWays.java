package strings;

public class DecodeWays {
    public static void main(String[] args){
        String a="12";
        int n=numDecodings(a);
        System.out.println(n);
    }

    private static int numDecodings(String s) {

            int[] dp=new int[s.length()+1];
            dp[0]=1;

            if(s.charAt(0)=='0') return 0;
            else dp[1]=1;
            for(int i=2;i<=s.length();i++){

                int lenOne=Integer.parseInt(s.substring(i-1,i));
                if(lenOne>=1 && lenOne<=9){
                    dp[i]+=dp[i-1];
                }

                int lenTwo=Integer.parseInt(s.substring(i-2,i));
                if(lenTwo>=10 && lenTwo<=26){
                    dp[i]+=dp[i-2];
                }
            }

            return dp[dp.length-1];
        }
    }

