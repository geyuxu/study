/* $NetBSD: echo.c,v 1.19 2016/09/05 01:00:07 sevan Exp $	*/

//BSD 许可证 
//https://zh.wikipedia.org/wiki/BSD%E8%AE%B8%E5%8F%AF%E8%AF%81

/*
 * Copyright (c) 1989, 1993
 *	The Regents of the University of California.  All rights reserved.
 *
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions
 * are met:
 * 1. Redistributions of source code must retain the above copyright
 *    notice, this list of conditions and the following disclaimer.
 * 2. Redistributions in binary form must reproduce the above copyright
 *    notice, this list of conditions and the following disclaimer in the
 *    documentation and/or other materials provided with the distribution.
 * 3. Neither the name of the University nor the names of its contributors
 *    may be used to endorse or promote products derived from this software
 *    without specific prior written permission.
 *
 * THIS SOFTWARE IS PROVIDED BY THE REGENTS AND CONTRIBUTORS ``AS IS'' AND
 * ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE
 * IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE
 * ARE DISCLAIMED.  IN NO EVENT SHALL THE REGENTS OR CONTRIBUTORS BE LIABLE
 * FOR ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR CONSEQUENTIAL
 * DAMAGES (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS
 * OR SERVICES; LOSS OF USE, DATA, OR PROFITS; OR BUSINESS INTERRUPTION)
 * HOWEVER CAUSED AND ON ANY THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT
 * LIABILITY, OR TORT (INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY
 * OUT OF THE USE OF THIS SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF
 * SUCH DAMAGE.
 */

/*
引用操作系统中/usr/include/sys/cdefs.h
如果没有定义lint,则调用__COPYRIGHT函数 
调用__RCSID函数
    #if 0使得static char sccsid[] ...这行不会被编译进去
(我不是很熟悉c语言,以上为猜测,待验证)
*/
#include <sys/cdefs.h>
#ifndef lint
__COPYRIGHT(
"@(#) Copyright (c) 1989, 1993\
 The Regents of the University of California.  All rights reserved.");
#endif /* not lint */

#ifndef lint
#if 0
static char sccsid[] = "@(#)echo.c	8.1 (Berkeley) 5/31/93";
#else
__RCSID("$NetBSD: echo.c,v 1.19 2016/09/05 01:00:07 sevan Exp $");
#endif
#endif /* not lint */

/*
在操作系统 /usr/include文件夹中可以找到头文件
*/
#include <locale.h>
#include <stdio.h>
#include <stdlib.h>
#include <string.h>

/* ARGSUSED */
int
main(int argc, char *argv[])
{
	int nflag;

    //stdlib.h
    //取出第一个参数,调用setprogname函数设置为程序名称
	setprogname(argv[0]);
    //locale.h
    //LC_ALL也在头文件locale.h中,我机器上的值为0
	(void)setlocale(LC_ALL, "");

	/* This utility may NOT do getopt(3) option parsing. */
    /*
    ++argv,数组指针向后移动一个char
    *取值,判断值是不是0
    strcmp 函数判断当前参数是否为 -n,相等为0

    判断条件为:argv有值,并且是 -n
    则将argv指针向后移动一个char
    nflag变量设置为1
    不满足条件,nflag设置为0
    */
	if (*++argv && !strcmp(*argv, "-n")) {
		++argv;
		nflag = 1;
	}
	else
		nflag = 0;

    /*
    循环取参数,打印参数,如果有下一个参数则打印空格
    将传入参数原样打印
    */
	while (*argv) {
		(void)printf("%s", *argv);
		if (*++argv)
			(void)putchar(' ');
	}

    /*
    如果传入第一个参数不是-n,如 echo hello world
    则打印换行
    */
	if (nflag == 0)
		(void)putchar('\n');

    
    //清除缓冲区
	fflush(stdout);

    //如果出现错误,则退出返回1
	if (ferror(stdout))
		exit(1);
	exit(0);
	/* NOTREACHED */
}