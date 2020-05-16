package main

import "fmt"

const Pi = 3.1415926535897936

func main() {
	const World = "world"
	fmt.Println("hello", World)
	fmt.Println("Happy", Pi, "day")

	//Pi = 334.44444

	const Truth = true
	fmt.Println("Go rules?", true)
}
