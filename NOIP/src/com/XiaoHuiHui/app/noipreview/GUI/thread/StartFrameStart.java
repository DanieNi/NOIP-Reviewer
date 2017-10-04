package com.XiaoHuiHui.app.noipreview.GUI.thread;

import com.XiaoHuiHui.app.noipreview.Main;
import com.XiaoHuiHui.app.noipreview.GUI.frame.StartFrame;

public class StartFrameStart implements Runnable{
	@Override
	public void run() {
		try {
			StartFrame frame = new StartFrame();
			frame.setVisible(true);
		} catch (Throwable e) {
			Main.error(e);
		}
	}
}
