public class ReverseInteger {
	public static int reverse(int x) {
		long res = 0;         //long ��ֹ����������
		while (x != 0) {
			res = res * 10 + x % 10;  //���������������������Ǹ������ɱ����������������Կ��Զ�
			x = x / 10;               //ȡ���λ
		}
		if (res > Integer.MAX_VALUE || res<Integer.MIN_VALUE) {
			return 0;
		} else {
			return (int)res;
		}
	}
	public static void main(String[] args) {
		System.out.println(reverse(-123));
		System.out.println(-123%-10);
		System.out.println(-123/-10);
	}
}
