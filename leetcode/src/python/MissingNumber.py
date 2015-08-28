class Solution(object):
    def missingNumber(self, nums):
        """
        :type nums: List[int]
        :rtype: int
        """
        sum=0
        i=1
        for num in nums:
            sum^=num
            sum^=i
            i+=1
        return sum
    def missingNumber1(self,nums):
        sum=0
        for num in nums:
            sum+=num
        return 0.5*len(nums)*(1+len(nums))-sum
if __name__=="__main__":
    nums=[1,2,3,4]
    s=Solution()
    print s.missingNumber1(nums)