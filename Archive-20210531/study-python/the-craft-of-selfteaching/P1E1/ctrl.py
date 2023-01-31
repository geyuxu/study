#import random
#
#for r in [random.randrange(1,1000) for i in range(10)]:
#    #r=random.randrange(1,1000)
#    if r%2 == 0:
#        print(r,'is even')
#    else:
#        print(r,'is odd')

#for n in range(2,100):
#    if n==2:
#        print(n)
#        continue
#    for i in range(2,n):
#        if(n%i)==0:
#            break
#    else:
#        print(n)

for n in range(2,100):
    if n==2:
        print(n)
        continue
    for i in range(2,int(n ** 0.5)+1):
        if(n%i) == 0:
            break
    else:
        print(n)
