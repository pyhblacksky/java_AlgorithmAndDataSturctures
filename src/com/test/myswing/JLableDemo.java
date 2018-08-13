package com.test.myswing;

/*
 * 	作为对java的swing 的测试
 * 
 * */

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class JLableDemo extends JApplet implements ActionListener{
	JTextField jtf;
	
	public void init()
	{
		//	获取内容窗格,进行布局
		Container contentPane = getContentPane();
		contentPane.setLayout(new FlowLayout());
		
		//	点击事件监控
		
		JButton jb = new JButton("TEST");
		jb.setActionCommand("France");
		jb.addActionListener((ActionListener) this);
		contentPane.add(jb);
		
		jtf = new JTextField(15);
		contentPane.add(jtf);
		
		
		
		//	创建label
		//JLabel jl = new JLabel("Test!", JLabel.CENTER);
		
		//	添加到窗格
		//jtf = new JTextField();
		//contentPane.add(jtf);
	}
	
	public void actionPerformed(ActionEvent ae)
	{
		//	对于所监听的事件，需要入口
		jtf.setText(ae.getActionCommand());
	}
	
}
