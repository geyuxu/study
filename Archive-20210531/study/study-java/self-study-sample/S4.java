import java.applet.*;
import javax.swing.*;

class MyPanel extends JPanel{
	
	JButton btn1,btn2;
	JLabel lbl;
	
	MyPanel(String s1,String s2,String s3){
		btn1 = new JButton(s1);
		btn2 = new JButton(s2);
		lbl = new JLabel(s3);
		add(btn1);
		add(btn2);
		add(lbl);
	}
	
}

public class S4 extends Applet{
	MyPanel pan1,pan2;
	JButton btn;
	
	public void init(){
		pan1 = new MyPanel("ȷ��","ȡ��","��ǩ1");
		pan2 = new MyPanel("ȷ��","ȡ��","��ǩ2");
		btn = new JButton("����Panel��");
		add(pan1);
		add(pan2);
		add(btn);
		setSize(300,200);
	}
	
}