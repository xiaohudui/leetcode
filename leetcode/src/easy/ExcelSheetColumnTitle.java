package easy;

public class ExcelSheetColumnTitle {
	/**
	 * 进制转换，思想：拆分为每一位来思考，如果余数是（1-25） -1%26，如果是0，变为25，商减一，刚好可以先减一
	 * 得到一位后第二位重复第一位即可
	 * @param n
	 * @return
	 */
    public static String convertToTitle(int n) {
        String res = "";
        while(n>0){
        	n-=1;
        	res =(char)(n%26+'A')+res;
        	n/=26;
        }
        return res;
    }	
    public static void main(String[] args) {
		System.out.println(convertToTitle(26*26));
	}
}
