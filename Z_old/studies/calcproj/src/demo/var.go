package demo

func main() {

	var v1 int = 10
	var v2 string = "hello"
	var v3 [3]int
	var v4 []int
	var v5 struct {
		f int
		d string
	}
	var v6 *int
	var v7 map[int]int
	var v8 func(a int) int

	var (
		v9 int
		v10 float64
	)

	var a int = 1
	var b int = 2

	a,b = b,a

	println(v1,v2,v3,v4,v5.d,v5.f,v6,v7,v8,v9,v10)

}