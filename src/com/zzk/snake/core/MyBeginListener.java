package com.zzk.snake.core;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import com.zzk.snake.client.SnakeClient;

public class MyBeginListener implements ActionListener{
	public void actionPerformed(ActionEvent e) {					//按退出按钮，显示确认对话框，确认则退出程序
		SnakeClient snakeclient = new SnakeClient();
		snakeclient.loadFrame();//加载窗体
		SnakeClient.isWrite = true;
		//My.setVisible(false);
	}
}
