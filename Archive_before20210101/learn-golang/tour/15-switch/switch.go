package main

import (
	"fmt"
	"runtime"
	"time"
)

func s1(){
	fmt.Print("Go runs on ")
	switch os:=runtime.GOOS;os{
	case "darwin":
		fmt.Print("OS X.")
	case "linux":
		fmt.Print("Linux")
	default:
		fmt.Printf("%s.\n",os)
	}
}
func s2(){
	fmt.Println("When's Saturday?")
	today := time.Now().Weekday()
	switch time.Saturday {
	case today+0:
		fmt.Println("Today.")
	case today+1:
		fmt.Println("Tommorow.")
	case today+2:
		fmt.Println("In two days.")
	default:
		fmt.Println("Too far away.")
	}

}
func s3(){
	t := time.Now()
	switch{
	case t.Hour() < 12:
		fmt.Println("Good morning!")
	case t.Hour() < 17:
		fmt.Println("Good afternoon!")
	default:
		fmt.Println("Good evening!")
	}
}
func main(){
	//s1()
	//s2()
	s3()
}