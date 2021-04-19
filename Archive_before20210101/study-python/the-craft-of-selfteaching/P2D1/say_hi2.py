#def say_hi(greeting,*names):
#    for name in names:
#        print(f'{greeting},{name.capitalize()}!')
def say_hi(greeting,*names,capitalize=False):
    for name in names:
        if(capitalize):
            name = name.capitalize()
        print(f'{greeting},{name}!')

say_hi('Hello','mike','Yasin','gEn')
say_hi('Hello','mike','Yasin','gEn',capitalize=True)