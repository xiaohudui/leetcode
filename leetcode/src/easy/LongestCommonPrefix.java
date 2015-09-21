package easy;

public class LongestCommonPrefix {
    public String longestCommonPrefix(String[] strs) {
    	if(strs == null || strs.length==0){
    		return "";
    	}
        int cnt=0;
        while(true){
        	for (int i = 0; i < strs.length; i++) {
				if(strs[i].length()<=cnt || strs[i].charAt(cnt)!=strs[0].charAt(cnt)){
					return strs[0].substring(0,cnt);
				}
			}
        	cnt++;
        }
    }
    public static void main(String[] args) {
		String[] strs={"hello","helloworld"};
		System.out.println(new LongestCommonPrefix().longestCommonPrefix(strs));
	}
}
