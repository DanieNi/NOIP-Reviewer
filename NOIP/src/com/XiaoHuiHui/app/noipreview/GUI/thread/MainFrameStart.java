package com.XiaoHuiHui.app.noipreview.GUI.thread;

import com.XiaoHuiHui.app.noipreview.Main;
import com.XiaoHuiHui.app.noipreview.GUI.frame.MainFrame;
import com.XiaoHuiHui.app.noipreview.GUI.frame.StartFrame;

public class MainFrameStart implements Runnable{
	StartFrame startFrame;
	
	public MainFrameStart(StartFrame startFrame) {
		super();
		this.startFrame=startFrame;
	}
	
	@Override
	public void run() {
		try {
			MainFrame frame = new MainFrame();
			frame.setLocationRelativeTo(startFrame);
			frame.setVisible(true);
			startFrame.setVisible(false);
		} catch (Throwable e) {
			Main.error(e);
		}
	}
}
