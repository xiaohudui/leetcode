package easy;

public class RemoveElement {
	/**
	 * ˼·һ����������ָ�룬����������ͬ�Ĳ����ƶ�����ļ����ƶ�����ָ��ָ�����ǰ��
	 * ˼·����ͷָ��ָ���elem��ͬ�ģ�βָ��ָ��ͬ�ģ��ҵ���ͽ�βָ���ֵ��ֵ��ͷָ�룬֪����ָ����������
	 * ˼·����˼·һ�ŵ㣺�����������ǰ��
	 */
    public int removeElement(int[] A, int elem) {
        int start=0,end=A.length;
        while(end>start){
        	while(end>start && A[end-1]==elem){
        		end--;
        	}
        	while(end>start && A[start]!=elem){
        		start++;
        	}
        	if(end>start){
        		A[start]=A[end-1];
        		end--;
        		start++;
        	}
        }
        return end;
    }
}
