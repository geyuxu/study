package main

import "fmt"

func main() {
	a := make([]int, 10)
	s := a[0:0]
	printSlice(s)
	printSlice(a)

	s = append(s, 0)
	printSlice(s)
	printSlice(a)

	s = append(s, 1)
	printSlice(s)
	printSlice(a)

	s = append(s, 2, 3, 4)
	printSlice(s)
	printSlice(a)

}

func printSlice(s []int) {
	fmt.Printf("len=%d cap=%d %v %p\n", len(s), cap(s), s, &s)
}
