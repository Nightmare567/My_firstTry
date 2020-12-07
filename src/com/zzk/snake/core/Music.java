package com.zzk.snake.core;

import com.zzk.snake.constant.Constant;

public class Music {
	private String musicPath = Constant.MUSIC_PRE;
	public Music(String musicName) {
		this.musicPath=musicPath + musicName;		
	}
	
	public String getMusicPath() {
		return musicPath;
	}
}
