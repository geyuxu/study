package main

import (
	"fmt"
	"os"
)

func main() {

	//args:=append(os.Args[1:])
	args := os.Args[1:]

	var nflag bool
	if len(args) > 0 && args[0] == "-n" {
		nflag = true
		//args=append(args[1:])
		args = args[1:]
	} else {
		nflag = false
	}

	for idx, arg := range args {
		fmt.Printf("%s", arg)
		if idx < len(args)-1 {
			fmt.Print(" ")
		}

	}

	if !nflag {
		fmt.Print("\n")
	}

}
