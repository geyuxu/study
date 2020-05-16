def is_leap(year):
    leap = False
    if year % 4 == 0:
        leap = True
        if year % 100 == 0 and year % 400 != 0:
            leap = False
    return leap

print(is_leap(1989))
print(is_leap(2000))
print(is_leap(2009))
print(is_leap(2020))