package easy;

public class IndexOfSubString {
	/**
	 * �ַ���ƥ����ʵ���ǲ�ƥ��ʱ���ƶ���λ������ BF�㷨����������ƶ�һλ
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
	 * ���ַ��㷨����������˲�ƥ�䣬�ƶ�ʹ�û��ַ�ƥ���ִ��е�ǰ������Ļ��ַ� �򵥻��ַ��㷨����ʹ��ʱ�������ѭ��
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
	 * �ú�׺������ƥ��ĺ�׺���ִ��к�׺�ĳ���λ�ö���
	 * ����ִ��Ƚϳ����ͻ���ɹ����׺��ʱ��ܳ�
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
	 * ���ִ�hashֵ��ĸ�����бȽ�
	 * ���⣺���ϼ���ĸ����ȡ��hashֵ���ͽ�������Ƚϣ�������ʡʱ��
	 * �����ԣ��������Ǳ����㷨
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
	 * KMP�㷨��ǰ��ƥ�䣬����Ѿ�ƥ��Ĳ��ֲ����ں�׺��ǰ׺��ȵĲ�����ô i+1 j=0��������ں�׺����ǰ׺��ֻ�ܽ�ǰ׺�ƶ����ͺ�׺��Ե�λ��
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
	 * �����׺��ǰ׺�����ƥ�䣬�õ���̬�滮��˼�룬jָ�����ƥ��ǰ׺�ĺ�һ���ַ���iָ����Ǻ�һ���ַ���
	 * 1. �����ȣ���ôǰ׺�ͺ�׺ƥ�䳤�ȼ�һ��
	 * 2. ������ȣ�jָ��ǰһ�����ƥ��ǰ׺�ĺ��棬
	 * �ؼ����룺j = next[j-1] Ѱ�����ǰ׺Ҳ������˼�룬�����һ����ƥ��ʱ���ҵ�j֮ǰ�ĺ�׺��ǰ׺�����ƥ�䣬
	 * j�ƶ�������棬��֤��j֮ǰ��ǰ׺�ͺ�׺��ƥ���
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
