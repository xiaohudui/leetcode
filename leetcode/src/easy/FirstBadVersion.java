package easy;

public class FirstBadVersion {
	boolean isBadVersion(int version){
		return version>=1702766719;
	}
    public int firstBadVersion(int n) {
        int l=1;
        int r=n;
        while(l<=r){
        	int mid=(int)(((long)l+r)/2);
        	if(isBadVersion(mid) && (mid-1<1 || !isBadVersion(mid-1))){
        		return mid;
        	}else if(isBadVersion(mid) && isBadVersion(mid-1)){
        		r=mid-1;
        	}else if(!isBadVersion(mid)){
        		l=mid+1;
        	}
        }
        return n+1;
    }
    public static void main(String[] args) {
		System.out.println(new FirstBadVersion().firstBadVersion(2126753390));
	}
}
