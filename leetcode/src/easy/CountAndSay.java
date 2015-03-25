package easy;

public class CountAndSay {
	/**
	 * 结果中的字符只可能是1,2,3三种情况
	 * @param n
	 * @return
	 */
    public String countAndSay(int n) {
        StringBuilder prev=new StringBuilder();
        prev.append(1);
        StringBuilder last=new StringBuilder();
        for (int i = 1; i < n; i++) {
        	char c=prev.charAt(0);
        	int count=1;
			for (int j = 1; j < prev.length();j++) {
				if(c == prev.charAt(j)){
					count++;
				}else{
					last.append(count).append(c);
					c=prev.charAt(j);
					count=1;
				}
			}
			last.append(count).append(c);
			prev = last;
			last = new StringBuilder();
		}
        return prev.toString();
    }
    public static void main(String[] args) {
		System.out.println(new CountAndSay().countAndSay(25));
	}
}
