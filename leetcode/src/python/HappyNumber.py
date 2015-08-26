class Solution:
    # @param {integer} n
    # @return {boolean}
    def squre(self,x):
        return x*x
    def isHappy(self, n):
        s=set()
        while n!=1:
            if n in s:
                break
            s.add(n)
            digits=str(n)
            lst=map(self.squre,[int(x) for x in digits])
            n=reduce(lambda x,y:x+y,lst)
        else:
            return True
        return False
s=Solution()
print s.isHappy(19)