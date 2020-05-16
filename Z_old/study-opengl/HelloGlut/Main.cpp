
#include<stdio.h>
#include<GL/freeglut.h>
#include"DrawSquare.h"
#include "DrawSth.h"

DrawSth *drawSth;

void display(void){

	drawSth->display();
}

void init(void) {
	drawSth->init();
}

int main(int argc,char** argv) 
{
	DrawSquare ds;
	drawSth = &ds;
	glutInit(&argc, argv);
	glutInitDisplayMode(GLUT_SINGLE | GLUT_RGB);
	glutInitWindowSize(250, 250);
	glutInitWindowPosition(100, 100);
	glutCreateWindow("hello world");

	init();

	glutDisplayFunc(display);
	glutMainLoop();
	
	return 0;
}