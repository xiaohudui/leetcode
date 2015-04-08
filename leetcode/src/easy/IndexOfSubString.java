package easy;

public class IndexOfSubString {
	/**
	 * 字符串匹配其实就是不匹配时后移多少位的问题 BF算法，最基本，移动一位
	 */
	public int strStr(String haystack, String needle) {
		if (needle == null || haystack == null) {
			return -1;
		}
		int subLen = needle.length();
		int sourceLen = haystack.length();
		int pSub = subLen;
		int pSource = subLen;
		if (subLen == 0) {
			return 0;
		}
		if (subLen > sourceLen) {
			return -1;
		}
		while (pSource <= sourceLen) {
			pSub = subLen;
			while (needle.charAt(--pSub) == haystack.charAt(--pSource)) {
				if (pSub == 0) {
					return pSource;
				}
			}
			pSource += (subLen - pSub) + 1;
		}
		return -1;
	}
	/**
	 * 坏字符算法：如果出现了不匹配，移动使得坏字符匹配字串中的前面最近的坏字符 简单坏字符算法单独使用时会造成死循环
	 */
	public int badCharIndexOf(String haystack, String needle) {
		int[] badChar = generateBadChar(needle);
		if (needle == null || haystack == null) {
			return -1;
		}
		int subLen = needle.length();
		int sourceLen = haystack.length();
		int pSub = subLen;
		int pSource = subLen;
		if (subLen == 0) {
			return 0;
		}
		if (subLen > sourceLen) {
			return -1;
		}
		while (pSource <= sourceLen) {
			pSub = subLen;
			while (needle.charAt(--pSub) == haystack.charAt(--pSource)) {
				if (pSub == 0) {
					return pSource;
				}
			}
			if (badChar[haystack.charAt(pSource)] < pSub) {
				pSource += subLen - badChar[haystack.charAt(pSource)];
			} else {
				pSource += (subLen - pSub) + 1;
			}
		}
		return -1;
	}
	public int[] generateBadChar(String sub) {
		int CHARSET_LEN = 256;
		int[] badChar = new int[CHARSET_LEN];
		for (int i = 0; i < badChar.length; i++) {
			badChar[i] = -1;
		}
		for (int i = 0; i < sub.length(); i++) {
			badChar[sub.charAt(i)] = i;
		}
		return badChar;
	}
	/**
	 * 好后缀法：已匹配的后缀与字串中后缀的出现位置对齐
	 * 如果字串比较长，就会造成构造后缀表时间很长
	 */
	public int goodSuffixIndexOf(String haystack, String needle) {
		if (needle == null || haystack == null) {
			return -1;
		}
		int subLen = needle.length();
		int sourceLen = haystack.length();
		int pSub = subLen;
		int pSource = subLen;
		if (subLen == 0) {
			return 0;
		}
		if (subLen > sourceLen) {
			return -1;
		}
		int[] goodSuffix = generateGoodSuffix(needle);
		while (pSource <= sourceLen) {
			pSub = subLen;
			while (needle.charAt(--pSub) == haystack.charAt(--pSource)) {
				if (pSub == 0) {
					return pSource;
				}
			}
			if(subLen-1 - goodSuffix[pSub]>0){
			    pSource += (subLen-pSub)+(subLen-1 - goodSuffix[pSub]);
			}else{
			     pSource += (subLen-pSub)+1;
			}
		}
		return -1;
	}
	public int[] generateGoodSuffix(String sub) {
		int N = sub.length();
		String temp = sub.substring(0, N - 1);
		int[] goodSuffix = new int[N];
		goodSuffix[N-1]=N-2;
		for (int i = 0; i < sub.length()-1; i++) {
			int last = temp.lastIndexOf(sub.substring(i+1));
			if(last!=-1){
			    last+=(N-i-2); 
			}
			int size = suffixSize(sub.substring(i+1), sub);
			goodSuffix[i] = last > size ? last : size;
		}
		return goodSuffix;
	}
	public int suffixSize(String suffix, String str) {
		for (int i = suffix.length(); i > 0; i--) {
			if (suffix.substring(suffix.length()-i).equals(str.substring(0, i))) {
				return i - 1;
			}
		}
		return -1;
	}
	/**
	 * 将字串hash值与母串进行比较
	 * 问题：不断计算母串截取的hash值，和进行逐个比较，并不会省时间
	 * 经测试，基本还是暴力算法
	 */
	public int IndexOfRK(String haystack,String needle){
		if (needle.length() == 0) {
			return 0;
		}
		if (needle.length() > haystack.length()) {
			return -1;
		}
		long subHash=hashCode(needle);
		long hash=0;
		for (int i = 0; i <= haystack.length()-needle.length(); i++) {
			if(i<1){
				hash=hashCode(haystack.substring(0,needle.length()));
			}else{
				hash=(hash/41-haystack.charAt(i-1)+haystack.charAt(i+needle.length()-1))*41;
			}
			if(hash==subHash && needle.equals(haystack.substring(i,i+needle.length()))){
				return i;
			}
		}
		return -1;
	}
	public long hashCode(String str){
		int R=41;
		long hash=0;
		for (int i = 0; i < str.length(); i++) {
			hash+=str.charAt(i);
		}
		return hash*R;
	}
	/**
	 * KMP算法：前向匹配，如果已经匹配的部分不存在后缀和前缀相等的部分那么 i+1 j=0，如果存在后缀等于前缀，只能将前缀移动到和后缀相对的位置
	 */
	public int indexOfKMP(String haystack,String needle){
		if (needle.length() == 0) {
			return 0;
		}
		if (needle.length() > haystack.length()) {
			return -1;
		}
		int[] next=generateNext(needle);
		for(int i=0,j=0;i<haystack.length();i++){
			while (j > 0 && haystack.charAt(i) != needle.charAt(j)) {
				j = next[j-1];
			}
			if(haystack.charAt(i)==needle.charAt(j)){
				j++;
			}
			if(j==needle.length()){
				return i-j+1;
			}
		}
		return -1;
	}
	/**
	 * 计算后缀与前缀的最大匹配，用到动态规划的思想，j指向的是匹配前缀的后一个字符，i指向的是后一个字符，
	 * 1. 如果相等，那么前缀和后缀匹配长度加一，
	 * 2. 如果不等，j指向前一个最大匹配前缀的后面，
	 * 关键代码：j = next[j-1] 寻找最大前缀也用上述思想，当最后一个不匹配时，找到j之前的后缀与前缀的最大匹配，
	 * j移动到其后面，保证了j之前的前缀和后缀是匹配的
	 */
	public int[] generateNext(String str){
		int[] next=new int[str.length()];
		next[0]=0;
		for(int i=1,j=0;i<str.length();i++){
			while (j > 0 && str.charAt(i) != str.charAt(j)) {
				j = next[j-1];
			}
			if(str.charAt(i)==str.charAt(j)){
				j++;
			}
			next[i]=j;
		}
		return next;
	}
}
