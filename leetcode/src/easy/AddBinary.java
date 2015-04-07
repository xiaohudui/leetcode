package easy;
/**
 * 不要为了非数量级的性能牺牲代码可读性
 * @author xiaohu
 *
 */
public class AddBinary {
	public String addBinary(String a, String b) {
		int i=a.length()-1;
		int j=b.length()-1;
		StringBuilder res=new StringBuilder();
		int carry=0;
		while(i>=0 && j>=0){
			int digit=(a.charAt(i)-'0'+b.charAt(j)-'0'+carry)%2;
			carry=(a.charAt(i)-'0'+b.charAt(j)-'0'+carry)/2;
			res.append(digit);
			i--;
			j--;
		}
		while(i>=0){
			int digit=(a.charAt(i)-'0'+carry)%2;
			carry=(a.charAt(i)-'0'+carry)/2;
			res.append(digit);
			i--;
		}
		while(j>=0){
			int digit=(b.charAt(j)-'0'+carry)%2;
			carry=(b.charAt(j)-'0'+carry)/2;
			res.append(digit);
			j--;
		}
		if(carry==1){
			res.append(1);
		}
		return res.reverse().toString();
	}
}
