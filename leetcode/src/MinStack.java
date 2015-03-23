/**
 * 用空间换时间：维护一个最小值栈，和minStack一起更新，时间复杂度O(1)
 * @author xiaohu
 *
 */
class MinStack {
	int[] data=new int[100];
	int[] minStack=new int[100];
	int p=0;
    public void push(int x) {
    	int[] temp1=null;
    	int[] temp2=null;
        if(p==data.length){
        	temp1=data;
        	temp2=minStack;
        	data = new int[p+100];
        	minStack = new int[p+100];
        	System.arraycopy(temp1, 0, data, 0, temp1.length);
        	System.arraycopy(temp2, 0, minStack, 0, temp2.length);
        }
        if(p==0 || x<minStack[p-1]){
        	minStack[p]=x;
        }else{
        	minStack[p]=minStack[p-1];
        }
        data[p]=x;
        p++;
        
    }

    public void pop() {
    	if(p>0){
    		p--;
    	}
    }

    public int top() {
    	if(p>0){
    		return data[p-1];
    	}else{
    		return 0;
    	}
    }

    public int getMin() {
        return minStack[p-1];
    }
    public static void main(String[] args) {
    	MinStack test=new MinStack();
		test.push(-2);
		test.push(0);
		test.push(-1);
		System.out.println(test.getMin());
	}
}