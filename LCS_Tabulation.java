public class LCS_Tabulation {

    public static int lcsTabulation(String s1,String s2){
        int n=s1.length();
        int m=s2.length();
       //table create
        int dp[][]=new int [n+1][m+1];
        //initialize
        for(int i=0;i<n+1;i++){
            for(int j=0;j<m+1;j++){
                if(i==0 || j==0){
                    dp[i][j]=0;
                }
            }
        }
        //bottom up
        for(int i=1;i<n+1;i++){
            for(int j=1;j<m+1;j++){
                if(s1.charAt(i-1)==s2.charAt(j-1)){
                    dp[i][j]=dp[i-1][j-1]+1;
                }else{
                    int ans1=dp[i-1][j];
                    int ans2=dp[i][j-1];
                    dp[i][j]=Math.max(ans1,ans2);
                }
            }
        }
        return dp[n][m];
    }
    public static void main(String[] args) {
        String str1="ABCDGH";
        String str2="AEDFHR";
        System.out.println(lcsTabulation(str1, str2));
    }
}
