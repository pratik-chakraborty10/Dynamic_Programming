public class LCS_Memoization {
    public static int lcs(String str1,String str2,int n,int m,int dp[][]){
        if(n==0 || m==0) return 0;
        //checking if value is stored
        if(dp[n][m]!=-1){
            return dp[n][m];
        }
        if(str1.charAt(n-1)==str2.charAt(m-1)){
            dp[n][m]=lcs(str1, str2, n-1, m-1, dp)+1;
        }else{
            int ans1=lcs(str1,str2,n-1,m,dp);
            int ans2=lcs(str1,str2,n,m-1,dp);
            return dp[n][m] = Math.max(ans1,ans2);
        }

    }
    public static void main(String[] args) {
        String str1="ABCDGH";
        String str2="AEDFHR";
        int n=str1.length();
        int m=str2.length();
        //dp array declarartion
        int dp[][]=new int[n+1][m+1];
        //initialize dp array with -1
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                dp[i][j]=-1;
            }
        }
        System.out.println(lcs(str1, str2, n, m, dp));
    }
    
}
