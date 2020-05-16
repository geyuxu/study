import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class S2{
	public static MyWindowDemo mw1;
	public static MyWindowDemo mw2;
	public static void main(String[] args){
		JButton btn1 = new JButton("苟利国家");
		String name1 = "生死以";
		String name2 = "其因祸福";
		mw1 = new MyWindowDemo(name1,btn1,Color.blue,350,450);
		mw1.setVisible(true);
		JButton btn2 = new JButton("避趋");
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