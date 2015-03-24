
public class LongestCommonPrefix {
	/**
	 * ˼·1���ǰ׺�Ϊstrs[0]�ĳ��ȣ��Ƚ������ַ����Ķ�Ӧ�ַ��Ƿ����
	 * ˼·2���ֱ��������ַ�����strs[0]�Ĺ���ǰ׺���ȣ�ȡ��С�ġ�
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
