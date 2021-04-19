print("Hello world")
//❌print('Hello world')

// var 是变量，let是常量
var myVariable = 33
myVariable = 34
let myCons = 655
//❌myCons = 333

let imp = 70
let impd = 70.78
let empd:Double = 70.33

print(empd)

UInt32.max

Int.max

Int64.max

Int8.max

print("hello")

Int64(33)

let three = 3
let pointOneFourOne = 0.14159
let pi = Double(three) + pointOneFourOne
//❌ let pi2 = three + pointOneFourOne

typealias AudioSample = UInt16
AudioSample.max

let turnipsAreDelicious = true
if turnipsAreDelicious {
    print("Mmm,tasty turnips!")
} else {
    print("Eww,turnips are horrible")
}


let httpState = (404,"Not Found")
let (stateCode,stateMessage) = httpState
stateCode

print("The status code is \(stateCode)")
print("The status code is \(httpState.0)")

let httpState200 = (statusCode:200,description:"OK")


//let possibleNumber = "123"
//let convertedNumber = Int(possibleNumber)
//
//if convertedNumber != nil {
//    print("convertedNumber contains some integer value of \(convertedNumber!).")
//}

//var convertedNumber:Int? = 400
//convertedNumber=nil
////if convertedNumber != nil {
//    print("convertedNumber contains some integer value of \(convertedNumber!).")
////}

//func makeASands() throws{
//    // some code
//    print("hello")
//}
//
//do{
//    try makeASands()
//}
