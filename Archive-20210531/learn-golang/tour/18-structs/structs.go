package main

import "fmt"

type Vertex struct {
	X, Y int
}

var (
	v1   = Vertex{1, 2}
	v2   = Vertex{X: 1}
	v2_2 = Vertex{Y: 1, X: 2}
	v3   = Vertex{}
	pv   = &Vertex{1, 2}
	pv_2 = &Vertex{}
)

func main() {
	v := Vertex{1, 2}
	v.X = 4
	fmt.Println(v.X)

	p := &v
	fmt.Println(p)

	(*p).X = 88
	fmt.Println(v)

	p.Y = 1e9
	fmt.Println(v)

	fmt.Println(v1, v2, v2_2, v3, pv, pv_2)
}
