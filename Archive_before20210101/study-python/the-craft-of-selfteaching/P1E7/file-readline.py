f = open('test-file.txt','w')
f.write('first line\nsecond line\nthird line\n')
f.close()

f = open('test-file.txt','r')
print(f.readline())
print(f.readline().strip())
print(f.readline().strip())
f.close()


f = open('test-file.txt','r')
for line in f.readlines():
    print(line.strip())
f.close()