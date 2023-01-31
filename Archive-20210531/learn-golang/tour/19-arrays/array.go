package main

import "fmt"

func main() {
	//slice()

	slice_literals()
}

func slice_literals() {
	q := []int{2, 3, 5, 6, 1, 33}
	fmt.Println(q)

	r := []bool{true, false, true, true, false}
	fmt.Println(r)

	s := []struct {
		i int
		b bool
	}{
		{2, true},
		{3, false},
		{5, true},
	}
	fmt.Println(s)

}

func slice() {
	var a [2]string
	a[0] = "Hello"
	a[1] = "World"

	fmt.Println(a[0], a[1])
	fmt.Println(a)

	//primes := [6]int{2, 3, 4, 5, 6, 77,33}
	primes := [6]int{2, 3, 4, 5, 6, 77}
	fmt.Println(primes)

	var s []int = primes[1:4]
	fmt.Println(s)

	s[0] = 99
	fmt.Println(s)
	fmt.Println(primes)
}
