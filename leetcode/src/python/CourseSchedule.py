class Solution:
    """
	注意点一：在for 循环迭代数组过程中对数组进行 remove,等原地算法会造成指针位置错乱
	注意点二：重复使用列表记得清空
	注意点三：[0]*5 结果 [0,0,0,0,0] 而 [[] for x in range(5)]可产生列表的列表
    """
    def canFinish(self, numCourses, prerequisites):
        courses=range(numCourses)
        degrees=[0]*numCourses
        parents=[[] for x in range(numCourses)]
        for pair in prerequisites:
            degrees[pair[1]]+=1
            parents[pair[0]].append(pair[1])
        flag=True
        while flag and courses:
            flag=False
            removed=[]
            for x in courses:
                if degrees[x]==0:
                    removed.append(x)
                    for parent in parents[x]:
                        degrees[parent]-=1
                        flag=True
            for x in removed:
                courses.remove(x)
        return not courses
s=Solution()
print s.canFinish(2, [])