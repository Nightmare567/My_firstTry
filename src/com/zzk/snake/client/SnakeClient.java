package com.zzk.snake.client;

import java.awt.Color;	
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.Reader;
import java.io.Writer;

import com.zzk.snake.constant.Constant;
//import com.zzk.snake.core.Music;
import com.zzk.snake.core.Food;
import com.zzk.snake.core.MyFrame;
import com.zzk.snake.core.MySnake;
import com.zzk.snake.util.ImageUtil;

import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;

public class SnakeClient extends MyFrame{
	
	MySnake mySnake = new MySnake(100, 100);//��
	Food food = new Food();//ʳ��
	Image background = ImageUtil.images.get("background");//����ͼƬ
	Image fail = ImageUtil.images.get("fail");//��Ϸ����������
	public static boolean isWrite = false;
	
	@Override
	public void loadFrame() {
		super.loadFrame();
		//��Ӽ��̼�������������̰����¼�
		addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				mySnake.keyPressed(e);//ί�и�mysnake
			}
		});
	}
	/**
	 * ���ƽ���
	 */
	@Override
	public void paint(Graphics g) {
		g.drawImage(background, 0, 0, null);//���Ʊ���
		if(mySnake.live){//����߻��ţ��ͻ���
			mySnake.draw(g);
			if(food.live){//���ʳ����ţ��ͻ���
				food.draw(g);
				food.eaten(mySnake);//�ж��Ƿ񱻳�
			}else{//���򣬲�����ʳ��
				food = new Food();
			}
		}else{//��������������Ϸ��������
			g.drawImage(fail, (background.getWidth(null)-fail.getWidth(null))/2, (background.getHeight(null)-fail.getHeight(null))/2, null);
			if(isWrite) {
				inputScore(mySnake.score);
				isWrite = false;
			}
		}
		drawScore(g);//���Ʒ���
	}
	/**
	 * ���Ʒ���
	 * @param g
	 */
	public void drawScore(Graphics g){
		g.setFont(new Font("Courier New", Font.BOLD, 40));
		g.setColor(Color.WHITE);
		g.drawString("SCORE:"+mySnake.score,700,100);
	}
	
	public void inputScore(int score) {
		try {
			File file = new File(Constant.RANK_PRE);
			
			BufferedWriter bufferWrite = new BufferedWriter(new FileWriter(file,true));
			
			String str = Integer.toString(score);
			bufferWrite.write(str);
            bufferWrite.newLine();
            
			bufferWrite.close();
		}
		catch (IOException e) {
			e.printStackTrace();
		}	
	}
//	public static void main(String[] args) {
//		Media pick = new Media("BGM.wav");
//		MediaPlayer mediaplayer = new MediaPlayer(pick);
//		mediaplayer.play();
//		SnakeClient snakeclient = new SnakeClient();
//		snakeclient.loadFrame();//���ش���
//
//	}
}
