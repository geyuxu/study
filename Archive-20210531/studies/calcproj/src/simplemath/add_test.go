package simplemath

import "testing"

func TestAdd1(t *testing.T){
	r:= Add(1,3)
	if r!=4{
		t.Error("failed")
	}
}
