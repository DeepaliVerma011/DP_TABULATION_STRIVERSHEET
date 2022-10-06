package IncludeExclude;

public class PaintFence_NotMoreThan2HaveSameColor {
    public static void main(String[] args){
        int n=8;
        int k=3;
        long ans=findwaystoPaintFence(n,k);
        System.out.println(ans);
    }

    private static long findwaystoPaintFence(int n, int k) {
        long same= k;
        long diff=k*(k-1);

        long total=same+diff;

        for(int i=3;i<=n;i++) {
            same = diff;
            diff = total * (k - 1);

            total = same + diff;


        }
      return total;
    }
}
