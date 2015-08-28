package medium;

import java.util.HashMap;
import java.util.Map;

public class FractiontoRecurringDecimal {
	public String fractionToDecimal(int numerator, int denominator) {
		String res = "";
		boolean flag=(numerator<0)^(denominator<0);
		if(flag && numerator!=0){
			res="-"+res;
		}
		long numer=Math.abs((long)numerator);
		long denomin=Math.abs((long)denominator);
		res += numer / denomin;
		if (numer % denomin == 0) {
			return res;
		}
		long remainder = numer % denomin;
		res += ".";
		Map<Long,Integer> map=new HashMap<Long,Integer>();
		int i=res.length();
		while (remainder != 0 ) {
			if(!map.containsKey(remainder)){
				map.put(remainder, i++);
			}else{
				i=map.get(remainder);
				res=res.substring(0,i)+"("+res.substring(i,res.length())+")";
				break;
			}
			remainder*=10;
			res += remainder / denomin;
			remainder = remainder % denomin;
		}
		return res;
	}
	public static void main(String[] args) {
		System.out.println(new FractiontoRecurringDecimal().fractionToDecimal(Integer.MIN_VALUE,1));
		System.out.println(Integer.MIN_VALUE<0);
	}
}
