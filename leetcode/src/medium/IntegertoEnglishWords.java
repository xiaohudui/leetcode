package medium;

public class IntegertoEnglishWords {
	public String numberToWords(int num) {
		String res="";
		String[] weight={"","Thousand","Million","Billion"};
		for (int i = 0; i < 4; i++) {
			res=(convertToHundred(num%1000).equals("")?"":convertToHundred(num%1000)+" "+weight[i]+" ")+res;
			num=num/1000;
		}
		return res.trim().equals("")?"Zero":res.trim();
	}
	
	public String convertToHundred(int num){
		String[] v1={"", "One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine", "Ten", "Eleven", 
					"Twelve", "Thirteen", "Fourteen", "Fifteen", "Sixteen", "Seventeen", "Eighteen", "Nineteen"};
		String[] v2={"","","Twenty", "Thirty", "Forty", "Fifty", "Sixty", "Seventy", "Eighty", "Ninety"};
		String res="";
		int a=num/100;
		int b=num%100;
		int c=num%10;
		res+=a>0?v1[a]+" Hundred ":"";
		res+=b<20?"":v2[b/10]+" ";
		res+=b<20?v1[b]:v1[c];
		return res.trim();
	}
	public static void main(String[] args) {
		IntegertoEnglishWords s=new IntegertoEnglishWords();
		System.out.println(s.convertToHundred(50));
		System.out.println(s.numberToWords(50868));
	}
}
