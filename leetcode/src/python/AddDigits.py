class Solution(object):
    def addDigits(self, num):
        """
        :type num: int
        :rtype: int
        """
        if not num:
            return 0
        return (num-1)%9+1
if __name__=='__main__':
    s=Solution()
    print s.addDigits(83)