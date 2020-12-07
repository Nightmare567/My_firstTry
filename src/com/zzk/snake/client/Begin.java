package com.zzk.snake.client;

import com.zzk.snake.constant.Constant;
import com.zzk.snake.core.MyBegin;
import com.zzk.snake.core.MyFrame;

public class Begin extends MyBegin{

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MyBegin mybegin = new Begin();
		mybegin.setSize(Constant.GAME_WIDTH, Constant.GAME_HEIGHT);
		//mybegin.setBounds(600, 100, 800, 720);								//设置大小位置
		mybegin.setTitle("开始游戏");									//标题
	}

}
