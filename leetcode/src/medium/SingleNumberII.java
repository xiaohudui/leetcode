package medium;
/**
 * 将整数看做二进制的32位数
 * 位操作：
 * 取i位：num>>i&1
 * 将i位置一：num |=1<<i;
 * @author xiaohu
 *
 */
public class SingleNumberII {
	/**
	 * 思路二：把整数当做一个32位的二进制数来看待
	 * 前面出现过：找出一个数组中的众数（超过二分一的数）：统计每一位，超过二分之一的数必然属于众数
	 * 本题思路：对每一位，如果出现三次那么除3余0，所以取余非零的位就是要找的数的非零位
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
	 * 思路一：排序，然后统计，时间复杂度O(NlogN),空间复杂度O(N)
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
     * 归并排序：时间复杂度O(NlogN),空间复杂度O(N),归并需要时间
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
