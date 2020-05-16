def say_hi(*names):
    for name in names:
        print(f'Hi,{name}')

#say_hi()
#say_hi('ann')
#say_hi('geyuxu','xiaolai','yasin')

names = ('mike','john','zeo')
say_hi(*names)

a_string = 'Python'
say_hi(*a_string)

a_range = range(10)
say_hi(*a_range)

a_list = list(range(10,0,-1))
say_hi(*a_list)

a_dictionary = {'ann':2323,'mike':3234,'jj':6633}
say_hi(*a_dictionary)