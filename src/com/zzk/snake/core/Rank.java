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
	String first = "�޼�¼";
    String second = "�޼�¼";
    String third = "�޼�¼";

	Rank(JFrame f,String s) { 				//���췽��	
	       super(f,s);
	       outScore();
	       String first = readList.get(0);
	       String second = readList.get(1);
	       String third = readList.get(2);
	       
	       setBounds(512, 290, 400, 330);		//���ô�С��Ҫ����֤ͼƬƥ��
	       label0 = new JLabel("���а�");
	       label1 = new JLabel("��һ��:" + first);
	       label2 = new JLabel("�ڶ���:" + second);
	       label3 = new JLabel("������:" + third);
	       
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
