import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class S3{
	public static void main(String[] args){
		ButtonDemo myBtnGui = new ButtonDemo();
		myBtnGui.setVisible(true);
	}
}

class ButtonDemo extends JFrame implements ActionListener{
	public static final int WIDTH = 250;
	public static final int HEIGHT = 200;
	
	ButtonDemo(){
		setSize(WIDTH,HEIGHT);
		Container conPane = getContentPane();
		conPane.setBackground(Color.BLUE);
		conPane.setLayout(new FlowLayout());
		JButton btnRed = new JButton("RED");
		btnRed.addActionListener(this);
		conPane.add(btnRed);
		JButton btnGreen = new JButton("GREEN");
		btnGreen.addActionListener(this);
		conPane.add(btnGreen);
	}
	
	public void actionPerformed(ActionEvent e){
		Container conPane = getContentPane();
		if(e.getActionCommand().equals("RED"))
			conPane.setBackground(Color.RED);
		else if(e.getActionCommand().equals("GREEN"))
			conPane.setBackground(Color.GREEN);
		
	}
	
}