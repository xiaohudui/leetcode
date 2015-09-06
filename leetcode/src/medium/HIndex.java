package medium;

public class HIndex {
	/**
	 * O(N*N)
	 */
    public int hIndex(int[] citations) {
    	int h=citations.length;
    	while(h>0){
    		int cnt=0;
    		for (int i = 0; i < citations.length; i++) {
				if(citations[i]>=h){
					cnt++;
				}
			}
    		if(cnt>=h){
    			return h;
    		}else{
    			h--;
    		}
    	}
    	return h;
    }
    public int hIndex1(int[] citations){
    	int N=citations.length;
    	int[] cnts=new int[N+1];
    	for (int c : citations) {
			cnts[c>N?N:c]++;
		}
    	int sum=0;
    	for (int i = N; i >=0; i--) {
			sum+=cnts[i];
			if(sum>=i){
				return i; 
			}
		}
    	return 0;
    }
    public static void main(String[] args) {
		int[] citations={1};
		System.out.println(new HIndex().hIndex(citations));
	}
}
