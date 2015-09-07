package medium;

public class DecodeWays {
	/**
	 * 递归：砍头法，复杂度O(N*N)，超时
	 */
    public int numDecodings1(String s) {
    	if(s==null || s.equals("")){
    		return 0;
    	}
        int[] cnt=new int[1];
        helper(s,cnt);
        return cnt[0];
    }
    public void helper(String s,int[] cnt){
    	if(s.equals("")){
    		cnt[0]++;
    	}
    	for (int i = 1; i <= 2 && i<=s.length(); i++) {
			if(isValid(s.substring(0,i))){
				helper(s.substring(i),cnt);
			}
		}
    }
    public boolean isValid(String s){
    	if(s.equals("")){
    		return false;
    	}
    	if(s.startsWith("0")){
    		return s.equals("0");
    	}else{
    		return Integer.parseInt(s)>=1 && Integer.parseInt(s)<=26;
    	}
    }
    /**
     * 分治方法：会重复
     */
    public int numDecodings2(String s) {
    	if(s==null || s.equals("")){
    		return 1;
    	}
    	int res=0;
    	for (int i = 0; i < s.length(); i++) {
			for (int j = 1; j <=2 && i+j<=s.length(); j++) {
				if(isValid(s.substring(i,i+j))){
					res+=numDecodings2(s.substring(0,i))*numDecodings2(s.substring(i+j,s.length()));
				}
			}
		}
    	return res;
    }
    /**
     * 求数量的方法都可以动态规划，求具体方案的要用递归
     */
    public int numDecodings(String s) {
    	int N=s.length();
    	int[] dp=new int[N];
    	dp[0]=1;
    	dp[1]=isValid(s.substring(0,2))?2:1;
    	for (int i = 2; i < N; i++) {
			dp[i]=isValid(s.substring(i-1,i+1))?dp[i-1]+dp[i-2]:dp[i-1];
		}
    	return dp[N-1];
    }
    public static void main(String[] args) {
    	String s="1323232324";
		System.out.println(new DecodeWays().numDecodings(s));
		System.out.println(new DecodeWays().numDecodings1(s));
	}
}
