package com.zzk.snake.core;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import com.zzk.snake.client.SnakeClient;

public class MyBeginListener implements ActionListener{
	public void actionPerformed(ActionEvent e) {					//���˳���ť����ʾȷ�϶Ի���ȷ�����˳�����
		SnakeClient snakeclient = new SnakeClient();
		snakeclient.loadFrame();//���ش���
		SnakeClient.isWrite = true;
		//My.setVisible(false);
	}
}
