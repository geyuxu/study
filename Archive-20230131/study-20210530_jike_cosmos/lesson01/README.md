1. gcc分步编译过程

gcc -E ./helloworld.c -o helloworld.i
gcc -S helloworld.i -o helloworld.s
gcc -c helloworld.s -o helloworld.o
gcc helloworld.o -o helloworld

2. 源文件反编译 
    1） gcc -c -s helloworld 报错
        clang: warning: helloworld: 'linker' input unused 
        
        [-Wunused-command-line-argument]
        clang: warning: argument unused during compilation: '-s' [-Wunused-command-line-argument]

    2） objdump -d helloworld > hellowolrd.dump