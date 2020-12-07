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
	
	MySnake mySnake = new MySnake(100, 100);//蛇
	Food food = new Food();//食物
	Image background = ImageUtil.images.get("background");//背景图片
	Image fail = ImageUtil.images.get("fail");//游戏结束的文字
	public static boolean isWrite = false;
	
	@Override
	public void loadFrame() {
		super.loadFrame();
		//添加键盘监听器，处理键盘按下事件
		addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				mySnake.keyPressed(e);//委托给mysnake
			}
		});
	}
	/**
	 * 绘制界面
	 */
	@Override
	public void paint(Graphics g) {
		g.drawImage(background, 0, 0, null);//绘制背景
		if(mySnake.live){//如果蛇活着，就绘制
			mySnake.draw(g);
			if(food.live){//如果食物活着，就绘制
				food.draw(g);
				food.eaten(mySnake);//判断是否被吃
			}else{//否则，产生新食物
				food = new Food();
			}
		}else{//蛇死亡，弹出游戏结束字样
			g.drawImage(fail, (background.getWidth(null)-fail.getWidth(null))/2, (background.getHeight(null)-fail.getHeight(null))/2, null);
			if(isWrite) {
				inputScore(mySnake.score);
				isWrite = false;
			}
		}
		drawScore(g);//绘制分数
	}
	/**
	 * 绘制分数
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
//		snakeclient.loadFrame();//加载窗体
//		
//	}
}
