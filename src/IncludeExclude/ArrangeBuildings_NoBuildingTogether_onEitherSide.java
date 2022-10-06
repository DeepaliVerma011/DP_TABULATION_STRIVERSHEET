package IncludeExclude;

public class ArrangeBuildings_NoBuildingTogether_onEitherSide {
    public static void main(String[] args){
        int n=6;
        int ans=findans(n);
        System.out.println(ans);
    }

    private static int findans(int n) {
        int os=1;
        int ob=1;

        for(int i=2;i<=n;i++){
            int ns=os+ob;
            int nb=os;

            os=ns;
            ob=nb;
        }
        int total=os+ob;
        //bcoz n on either side
        return total*total;
    }
}
