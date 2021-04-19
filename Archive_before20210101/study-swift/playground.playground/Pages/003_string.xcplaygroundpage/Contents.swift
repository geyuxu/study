
// String Character

var hi = "hello"

let someSql = """
    select *
        from student s
        inner join (
            select * from aaa
        ) a on s.id = a.id
    """

//print(hi)
//print(someSql)
//
//for c in someSql{
//    print(c)
//}

someSql.count

someSql[someSql.startIndex]
someSql.startIndex
someSql[someSql.index(before: someSql.endIndex)]
someSql[someSql.index(after: someSql.startIndex)]
someSql[someSql.index(someSql.startIndex,offsetBy:7)]
someSql.firstIndex(of: "i")
someSql.index(of:"i")

