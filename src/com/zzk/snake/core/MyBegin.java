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
		this.setTitle("开始游戏");//设置窗体标题
		this.setSize(Constant.GAME_WIDTH, Constant.GAME_HEIGHT);//设置窗体大小
		this.setBackground(Color.BLACK);//设置背景
		this.setLocationRelativeTo(null);//居中
		this.setVisible(true);	//设置可见
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);	
		this.setResizable(false);									//不能改变登录窗口的大小
	}
	
	
	void init(){
		ImageIcon icon = new ImageIcon(IMG_BACKGROUND);
		label = new JLabel();
		label.setIcon(icon);
		
		Dimension preferredSize = new Dimension(150,37);			//按钮大小不能用setBounds()调整
		button1 = new JButton("开始游戏");
		button1.setPreferredSize(preferredSize);
		button1.setBackground(Color.blue);
		button1.setForeground(Color.white);	//改变按钮背景和字体颜色
		
		button2 = new JButton("排行榜");
		button2.setPreferredSize(preferredSize);
		button2.setBackground(Color.blue);
		button2.setForeground(Color.white);	//改变按钮背景和字体颜色
		
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
		
		MyBeginListener begin = new MyBeginListener();	//创建开始监视器
		setMyBeginListener(begin);						//注册开始监视器
		
		MyRankListener rank = new MyRankListener();	//创建开始监视器
		setMyRankListener(rank);						//注册开始监视器
		
		dialog=new Rank(null,"排行榜");  	//创建对话框
		dialog.setModal(true);   						//有模式对话框
	}
	
	void setMyBeginListener(MyBeginListener begin) {
		button1.addActionListener(begin);					//按退出按钮可响应	
	}	
	void setMyRankListener(MyRankListener rank) {
		button2.addActionListener(rank);
	}
}
