# OBJS= progA.o progB.o
# OBJS-ADD= $(OBJS) progC.o

#OBJS2 = $(OBJS1) progC.o
#OBJS1 = progA.o progB.o

# SRCS := progA.c progB.c
# SRCS += progC.c
# OBJS := $(SRCS:%.c=%.o)
# #SRCS += progC.c

# all: 
# 	@echo "SRCS: " $(SRCS)
# 	@echo "OBJS: " $(OBJS)

# target1: TARGET1-SRCS := progD.c progB.c
# target1:
# 	@echo "SRCS: " $(SRCS)
# 	@echo "SRCS: " $(TARGET1-SRCS)

# target2:
# 	@echo "SRCS: " $(SRCS)
# 	@echo "SRCS: " $(TARGET1-SRCS)

#CC = gcc
#CFLAGS = -Wall -Werror -Wmissing-prototypes

main.o: main.c prog.h
progA.o: progA.c prog.h
progB.o: progB.c prog.h
progC.o: progC.c prog.h
progD.o: progD.c prog.h

all: progA.o progB.o progC.o progD.o main.o
#cc progA.o progB.o progC.o progD.o main.o -o i.o
	cc *.o -o i.out

clean:
	rm -f *~ *.o sysstatd