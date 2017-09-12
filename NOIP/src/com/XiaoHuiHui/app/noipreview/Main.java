package com.XiaoHuiHui.app.noipreview;

import java.awt.EventQueue;

import com.XiaoHuiHui.app.noipreview.GUI.StartFrame;
import com.XiaoHuiHui.app.noipreview.data.Database;

//入口类
public class Main {
	//入口
	public static void main(String[] args) {
		Database.read();
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					StartFrame frame = new StartFrame();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
}
