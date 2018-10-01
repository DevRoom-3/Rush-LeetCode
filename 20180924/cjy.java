class Solution {
    public int minDistance(String word1, String word2) {
        int len_word1 = word1.length();
        int len_word2 = word2.length();
        int dp[][] = new int[len_word1+1][len_word2+1];

        for(int i=0;i<=len_word1;i++){

            for(int j=0;j<=len_word2;j++){
                if(i==0){
                    dp[i][j]=j;//表示source没有字符，则target有j个字符就需要进行j次操作
                }
                    else if(j==0){
                     dp[i][j]=i;//同理  表示 target 没有字符，则source有i个字符就需要进行i次操作

                    }
                          //s[i-1] is the same as t[i-1] i is from 1 to i 
               else{
                   //注意此刻word字符得位置 长度为i 字符串的第i位为i-1 
                 dp[i][j]= Math.min(dp[i-1][j-1]+(word1.charAt(i-1)==word2.charAt(j-1)?0:1),
                 //dp[i-1][j]+1 soure 字符串前i-1 与 target字符串 相同 所以差一个 需要操作1  
                 //dp[i][j-1]+1 soure 字符串前i 与 target 前j-1 字符串 相同 所以差一个 需要操作1  
                Math.min(dp[i-1][j]+1,dp[i][j-1]+1));
               }

            }

        }
        return dp[len_word1][len_word2];
    }
}
