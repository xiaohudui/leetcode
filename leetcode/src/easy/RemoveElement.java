package easy;

public class RemoveElement {
	/**
	 * 思路一：快慢两个指针，慢的遇到相同的不再移动，快的继续移动，快指针指向的数前移
	 * 思路二：头指针指向和elem相同的，尾指针指向不同的，找到后就将尾指针的值赋值给头指针，知道两指针相遇结束
	 * 思路二比思路一优点：避免大量数据前移
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
