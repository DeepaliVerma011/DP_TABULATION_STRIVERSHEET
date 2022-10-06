package McmPartitionDp;

public class BooleanParenthesization {
    public static void main(String[] args){
        String s="T|T&F";
        String s1="";
        String s2="";

        for(int i=0;i<s.length();i++){
            if(s.charAt(i)=='T' || s.charAt(i)=='F'){
                s1+=s.charAt(i);
            }
            else{
                s2+=s.charAt(i);
            }
        }

        int ans=evaluateExp(s1,s2);
        System.out.println(ans);
    }

    private static int evaluateExp(String s1, String s2) {
        int n=s1.length();
        int m=s2.length();
        int[][] dpt=new int[n][m];
        int[][] dpf=new int[n][m];

        for(int g=0;g<dpt.length;g++){
            for(int i=0,j=g;j<dpt[0].length;i++,j++){
                if(g==0){
                    char ch= s1.charAt(i);
                    if(ch=='T'){
                        dpt[i][j]=1;
                        dpf[i][j]=0;
                    }
                    else{
                        dpt[i][j]=0;
                        dpf[i][j]=1;
                    }
                }
                else{
                    for(int k=i;k<=j;k++){
                        char ch=s2.charAt(k);
                        int ltc=dpt[i][k];
                        int rtc=dpt[k+1][j];
                        int lfc=dpf[i][k];
                        int rfc=dpf[k+1][j];
                        if(ch=='&'){
                          dpt[i][j]+=ltc*rtc;
                        }
                        else if(ch=='|'){
                            dpt[i][j]+=(ltc*rtc)+(ltc*rfc)+(lfc*rtc);
                        }
                        else{
                            dpt[i][j]+=(ltc*rfc)+(lfc*rtc);
                        }
                    }
                }

            }
        }
        return dpt[0][dpt[0].length-1];
    }
}
