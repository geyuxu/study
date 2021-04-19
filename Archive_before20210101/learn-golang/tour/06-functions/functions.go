package main

import "fmt"

func add(x int, y int) int {
	return x + y
}

func sub(x, y int) int {
	return x - y
}

func swap(x, y string) (string, string) {
	return y, x
}

func main() {
	fmt.Println(add(3, 6))
	fmt.Println(sub(3, 6))
	x, y := swap("AAA", "BBB")
	fmt.Println(x, y)
}
