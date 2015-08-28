class Solution(object):
    def singleNumber(self, nums):
        """
        :type nums: List[int]
        :rtype: List[int]
        """
        sum=0
        for num in nums:
            sum^=num
        i=0
        while not sum>>i&1:
            i+=1
        A1=[]
        A2=[]
        for num in nums:
            if num>>i&1:
                A1+=num,
            else:
                A2+=num,
        res=[]
        temp=0
        for num in A1:
            temp^=num
        res+=temp,
        temp=0
        for num in A2:
            temp^=num
        res+=temp,
        return res
if __name__=="__main__":
    nums=[1,1,2,3]
    s=Solution()
    print s.singleNumber(nums)