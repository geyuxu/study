# 读取hamlet.txt
# 记录每个单词出现的个数，并把出现的位置（行号，列号）记录下来
# 如 单词Elsinore一共有6处，记录为 Elsinore:6:<4,10><470,27>...
# 单词统计不区分大小,忽略标点符号
# 单词需要排序
# 每个单词记录占一行
# 标号从1开始计数
# 结果输出到out.txt中

#import collections
#d = collections.OrderedDict()

import os

dIndex = {}
dCount = {}

f = open('hamlet.txt','r')
idxLine=1
for line in f.readlines():
    line = line.upper()
    word = ''
    for idx in range(1,len(line)):
        w = line[idx]

        if(ord(w)>=65 and ord(w)<=90):
            word += w
        
        else:
            if word.strip() == '':
                continue
            if dIndex.get(word) == None:
                dIndex[word] = ''
                dCount[word] = 0
            dIndex[word] += '<' + str(idxLine) +','+ str(idx-len(word)) +'>'
            dCount[word] += 1
            word = ''
    idxLine+=1

f.close()

f = open('out.txt','w')
for a in sorted(dIndex.keys()):
    print(a,dCount[a],dIndex[a],sep=':',file=f)

f.close()