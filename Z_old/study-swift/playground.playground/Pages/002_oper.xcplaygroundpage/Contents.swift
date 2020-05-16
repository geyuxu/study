// == !=
// + - * / %

let a=1,b=2

a+b
a-b
a*b
a/b
a%b

-a

// string 中 + 表示关联
"hello" + "world"

var i = 0
i += 1

// == != > < >= <=
a == b
// a!=b报错,a!在swift中是特殊含义
a != b
a > b
a >= b
a < b
a <= b

!false

// question ? answer1 : answer2
let contentHeight = 40
let hasHeader = true
var rowHeight = contentHeight + (hasHeader ?50:20)

// ??
var readColorFormSomeWhere: String?
//readColorFormSomeWhere = "blue"
var color = readColorFormSomeWhere ?? "red"
print(color)

// ...
1 ... 5
for index in 1...5{
    print(index)
}
for index in 1..<5{
    print(index)
}

let names = ["Ali","Bob","Cll","Huu","Wuj"]
//for name in names[2...]{
//    print(name)
//}
//for name in names[...3]{
//    print(name)
//}
for name in names[..<3]{
    print(name)
}
