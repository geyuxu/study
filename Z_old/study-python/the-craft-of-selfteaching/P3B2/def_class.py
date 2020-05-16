import datetime

class Person:
    def __init__(self, name=None):
        self.name = name
        self.birthday = datetime.date.today().year
    def say_hi(self):
        print('Wa~~~')

a = Person('Yaas')
print(a.name)
print(a.birthday)
a.say_hi()

class C_Person(Person):
    def pay(self):
        print("...")

rr = C_Person('Cla')
rr.pay()
rr.say_hi()