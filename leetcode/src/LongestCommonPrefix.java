
public class LongestCommonPrefix {
	/**
	 * 思路1：最长前缀最长为strs[0]的长度，比较所有字符串的对应字符是否相等
	 * 思路2：分别求所有字符串和strs[0]的公共前缀长度，取最小的。
	 * @param strs
	 * @return
	 */
    public String longestCommonPrefix(String[] strs) {
    	if(strs.length == 0){
    		return "";
    	}
    	int i = 0;
        for (i = 0; i < strs[0].length(); i++) {
			char ch=strs[0].charAt(i);
			int j=0;
			for (j=0;j<strs.length;j++) {
				if(strs[j].length()<=i || strs[j].charAt(i)!=ch){
					break;
				}
			}
			if(j<strs.length){
				return strs[0].substring(0,i);
			}
		}
        return strs[0].substring(0,i);
    }
    public static void main(String[] args) {
		String[] strs={"hello","helloworld"};
		System.out.println(new LongestCommonPrefix().longestCommonPrefix(strs));
	}
}
