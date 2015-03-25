package easy;

public class ExcelSheetColumnTitle {
	/**
	 * ����ת����˼�룺���Ϊÿһλ��˼������������ǣ�1-25�� -1%26�������0����Ϊ25���̼�һ���պÿ����ȼ�һ
	 * �õ�һλ��ڶ�λ�ظ���һλ����
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
