package com.test.myswing;

/*
 * 	��Ϊ��java��swing �Ĳ���
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
		//	��ȡ���ݴ���,���в���
		Container contentPane = getContentPane();
		contentPane.setLayout(new FlowLayout());
		
		//	����¼����
		
		JButton jb = new JButton("TEST");
		jb.setActionCommand("France");
		jb.addActionListener((ActionListener) this);
		contentPane.add(jb);
		
		jtf = new JTextField(15);
		contentPane.add(jtf);
		
		
		
		//	����label
		//JLabel jl = new JLabel("Test!", JLabel.CENTER);
		
		//	��ӵ�����
		//jtf = new JTextField();
		//contentPane.add(jtf);
	}
	
	public void actionPerformed(ActionEvent ae)
	{
		//	�������������¼�����Ҫ���
		jtf.setText(ae.getActionCommand());
	}
	
}
