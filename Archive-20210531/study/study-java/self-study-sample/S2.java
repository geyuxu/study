import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class S2{
	public static MyWindowDemo mw1;
	public static MyWindowDemo mw2;
	public static void main(String[] args){
		JButton btn1 = new JButton("��������");
		String name1 = "������";
		String name2 = "�������";
		mw1 = new MyWindowDemo(name1,btn1,Color.blue,350,450);
		mw1.setVisible(true);
		JButton btn2 = new JButton("����");
		mw2 = new MyWindowDemo(name2,btn2,Color.blue,300,400);
		mw2.setVisible(true);
	}
	
}
class MyWindowDemo extends JFrame{
	public MyWindowDemo(String name,JButton btn,Color c,int w,int h){
		super();
		setTitle(name);
		setSize(w,h);
		Container contentPane = getContentPane();
		contentPane.add(btn);
		contentPane.setBackground(c);
	}
	
}