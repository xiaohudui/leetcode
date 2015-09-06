package medium;

public class HIndexII {
    public int hIndex(int[] citations) {
    	int N=citations.length;
    	for(int i=N; i>0;i--){
    		if(citations[N-i]>=i){
    			return i;
    		}
    	}
    	return 0;
    }
}
