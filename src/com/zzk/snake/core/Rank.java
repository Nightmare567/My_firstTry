package com.zzk.snake.core;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Reader;
import java.io.Writer;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import com.zzk.snake.constant.Constant;

public class Rank extends JDialog{
	JLabel label0,label1,label2,label3;
	JPanel panel;
	ArrayList<String> readList = new ArrayList<String>();
	String first = "无记录";
    String second = "无记录";
    String third = "无记录";

	Rank(JFrame f,String s) { 				//构造方法	
	       super(f,s);
	       outScore();
	       String first = readList.get(0);
	       String second = readList.get(1);
	       String third = readList.get(2);
	       
	       setBounds(512, 290, 400, 330);		//设置大小，要与验证图片匹配
	       label0 = new JLabel("排行榜");
	       label1 = new JLabel("第一名:" + first);
	       label2 = new JLabel("第二名:" + second);
	       label3 = new JLabel("第三名:" + third);
	       
	       panel = new JPanel();
	       
	       panel.add(label0);
	       panel.add(label1);
	       panel.add(label2);
	       panel.add(label3);
	       add(panel);
	}
	
	public void outScore() {
		String str = null;
		try {
			File file = new File(Constant.RANK_PRE);
			
			Reader fin = new FileReader(file);
			
			BufferedReader bufferRead =new BufferedReader(fin);
			while((str=bufferRead.readLine())!=null &&!"".equals(str))
			{
				readList.add(str);
			}

			Collections.sort(readList, new Comparator< String >() {
		    	   @Override
		    	   public int compare(String lhs, String rhs) {
		    	       int a,b;
		    	       a = Integer.parseInt(lhs);
					   b = Integer.parseInt(rhs);
		    	       if ( b > a ) {
		    	    	   return 1;
		    	       } else {
		    	           return -1;
		    	       }
		    	   }
		       });
			
			
            
            bufferRead.close();
			fin.close();
		}
		catch (IOException e) {
			e.printStackTrace();
		}	
	}

}
