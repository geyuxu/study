def say_hi(*names):
    """
    say hi
    """    
    for name in names:
        print(f'Hi,{name}')

def is_prime(n):
    """
    判断参数是否为质数,返回bool值
    """
    if n<2:
        return False
    if n == 2:
        return True
    for m in range(2,int(n**0.5)+1):
        if(n%m)==0:
            return False
    else:
        return True