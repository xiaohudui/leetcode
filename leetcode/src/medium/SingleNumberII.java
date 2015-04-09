package medium;
/**
 * ���������������Ƶ�32λ��
 * λ������
 * ȡiλ��num>>i&1
 * ��iλ��һ��num |=1<<i;
 * @author xiaohu
 *
 */
public class SingleNumberII {
	/**
	 * ˼·��������������һ��32λ�Ķ�������������
	 * ǰ����ֹ����ҳ�һ�������е���������������һ��������ͳ��ÿһλ����������֮һ������Ȼ��������
	 * ����˼·����ÿһλ���������������ô��3��0������ȡ������λ����Ҫ�ҵ����ķ���λ
	 */
	public int singleNumber1(int[] A){
		int[] cnt=new int[32];
		int res=0;
		for (int i = 0; i < 32; i++) {
			for (int j = 0; j < A.length; j++) {
				cnt[i]+=(A[j]>>i&1);
			}
			if(cnt[i]%3!=0){
				res|=(1<<i);
			}
		}
		return res;
	}
	/**
	 * ˼·һ������Ȼ��ͳ�ƣ�ʱ�临�Ӷ�O(NlogN),�ռ临�Ӷ�O(N)
	 * @param A
	 * @return
	 */
    public int singleNumber(int[] A) {
        sort(A);
        int cnt=1;
        for (int i = 1; i < A.length; i++) {
			if(A[i]==A[i-1]){
				cnt++;
			}else{
				if(cnt<3){
					return A[i-1];
				}else{
					cnt=1;
				}
			}
		}
        return A[A.length-1];
    }
    /**
     * �鲢����ʱ�临�Ӷ�O(NlogN),�ռ临�Ӷ�O(N),�鲢��Ҫʱ��
     * @param A
     */
    public void sort(int[] A){
    	int i=1;
    	while(i<A.length){
    		for (int j = 0; j < A.length; j+=i*2) {
    			if(j+i<A.length){
    				if(j+2*i<A.length){
    					merge(A,j,j+i,j+2*i);
    				}else{
    					merge(A,j,j+i,A.length);
    				}
    			}
			}
    		i*=2;
    	}
    }
    public void merge(int[] A,int start,int medium,int end){
    	int m=medium-start;
    	int n=end-medium;
    	int[] a=new int[m+1];
    	int[] b=new int[n+1];
    	System.arraycopy(A, start, a, 0, m);
    	System.arraycopy(A, medium, b, 0, n);
    	int i=0,j=0,k=start;
    	while(i<m && j<n){
    		if(a[i]<b[j]){
    			A[k++]=a[i++];
    		}else{
    			A[k++]=b[j++];
    		}
    	}
    	while(i<m){
    		A[k++]=a[i++];
    	}
    	while(j<n){
    		A[k++]=b[j++];
    	}
    }
}
