#print(abs(-100))

def is_prime(n):
    if n<2:
        return False
    if n == 2:
        return True
    for m in range(2,int(n**0.5)+1):
        if(n%m)==0:
            return False
    else:
        return True

print(is_prime(3))

for n in range(80,110):
    if is_prime(n):
        print(n)
