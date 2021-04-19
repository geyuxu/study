package simplemath

import "testing"

func TestSqrt1(t *testing.T){
	r:= Sqrt(5)
	if r!=2{
		t.Error("failed")
	}
}
