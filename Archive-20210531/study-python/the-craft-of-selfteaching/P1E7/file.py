f = open('hello.txt','w')
print(f.name)

s = []
for n in range(0,10):
    if n < 2 : 
#        s.append('1')
        s.append(1)
    else:
       # s.append(str(int(s[n-2])+int(s[n-1])))
        s.append(s[n-2]+s[n-1])
f.writelines(s)
f.close()

f = open('hello.txt','r')
print(f.read())
f.close()