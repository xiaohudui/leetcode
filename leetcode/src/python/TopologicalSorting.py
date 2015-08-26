# 与CourseSchedule相关，拓扑排序
def sortDFS(edgs):
    res=[]
    degrees={}
    children={}
    for pair in edgs:
        if pair[0] in degrees:
            degrees[pair[0]]+=1
        else:
            degrees[pair[0]]=1
        if pair[1] in children:
            children[pair[1]].append(pair[0])
        else:
            children[pair[1]]=[pair[0]]
    s=set()
    for pair in edgs:
        if pair[1] not in degrees:
            s.add(pair[1])
        if pair[0] not in children:
            children[pair[0]]=[]
    mark={}
    for node in s:
        visit(node,children,mark,res)
    return res
    
def visit(node,children,mark,res):
    if node not in mark:
        mark[node]=1
        for n in children[node]:
            visit(n,children,mark,res)
        res.append(node)

def sortkahn(edgs):
    degrees={}
    parents={}
    for pair in edgs:
        if pair[0] in parents:
            parents[pair[0]].append(pair[1])
        else:
            parents[pair[0]]=[pair[1]]
        if pair[1] in degrees:
            degrees[pair[1]]+=1
        else:
            degrees[pair[1]]=1
    s=set()
    for pair in edgs:
        if pair[0] not in degrees:
            s.add(pair[0])
        if pair[1] not in parents:
            parents[pair[1]]=[]
    res=[]
    while s:
        node=s.pop()
        res.append(node)
        for parent in parents[node]:
            degrees[parent]-=1;
            edgs.remove([node,parent])
            if not degrees[parent]:
                s.add(parent)
    if edgs:
        print edgs
        return None
    else:
        return res

def issorted(res,edgs):
    for pair in edgs:
        if res.index(pair[0])>res.index(pair[1]):
            return False
    return True
edgs=[[0,1],[0,5],[0,6],[2,0],[2,3],[3,5],[5,4],[6,4],[6,9],[7,6],[8,7],[9,10],[9,11],[9,12],[11,12]]
res=sortkahn(edgs)
print issorted(res, edgs)