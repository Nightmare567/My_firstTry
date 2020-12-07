package com.zzk.snake.core;


import java.awt.*;
import java.awt.image.BufferedImage;

import javax.swing.*;

import com.zzk.snake.constant.Constant;
import com.zzk.snake.core.Rank;
import com.zzk.snake.util.ImageUtil;




public class MyBegin extends JFrame{
	JButton button1,button2;
	JPanel panel0,panel1,panel2;
	JLabel label;
	Container con;
	public static Rank dialog;
	private static final BufferedImage IMG_BACKGROUND = (BufferedImage) ImageUtil.images.get("background");
	
	public MyBegin() {
		init();
		this.setTitle("��ʼ��Ϸ");//���ô������
		this.setSize(Constant.GAME_WIDTH, Constant.GAME_HEIGHT);//���ô����С
		this.setBackground(Color.BLACK);//���ñ���
		this.setLocationRelativeTo(null);//����
		this.setVisible(true);	//���ÿɼ�
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);	
		this.setResizable(false);									//���ܸı��¼���ڵĴ�С
	}
	
	
	void init(){
		ImageIcon icon = new ImageIcon(IMG_BACKGROUND);
		label = new JLabel();
		label.setIcon(icon);
		
		Dimension preferredSize = new Dimension(150,37);			//��ť��С������setBounds()����
		button1 = new JButton("��ʼ��Ϸ");
		button1.setPreferredSize(preferredSize);
		button1.setBackground(Color.blue);
		button1.setForeground(Color.white);	//�ı䰴ť������������ɫ
		
		button2 = new JButton("���а�");
		button2.setPreferredSize(preferredSize);
		button2.setBackground(Color.blue);
		button2.setForeground(Color.white);	//�ı䰴ť������������ɫ
		
		panel0 = new JPanel();
		panel0.setBounds(0, 0, Constant.GAME_WIDTH, Constant.GAME_HEIGHT);
		
		panel1 = new JPanel();
		panel1.setBounds(400,300,200,40);
		
		panel2 = new JPanel();
		panel2.setBounds(400,400,200,40);
		panel2.setVisible(true);
		
		panel0.add(label);
		panel1.add(button1);
		panel2.add(button2);
		
		con = getContentPane();
		con.setLayout(null);
		con.add(panel0);
		con.add(panel1);
		con.add(panel2);
		
		MyBeginListener begin = new MyBeginListener();	//������ʼ������
		setMyBeginListener(begin);						//ע�Ὺʼ������
		
		MyRankListener rank = new MyRankListener();	//������ʼ������
		setMyRankListener(rank);						//ע�Ὺʼ������
		
		dialog=new Rank(null,"���а�");  	//�����Ի���
		dialog.setModal(true);   						//��ģʽ�Ի���
	}
	
	void setMyBeginListener(MyBeginListener begin) {
		button1.addActionListener(begin);					//���˳���ť����Ӧ	
	}	
	void setMyRankListener(MyRankListener rank) {
		button2.addActionListener(rank);
	}
}
