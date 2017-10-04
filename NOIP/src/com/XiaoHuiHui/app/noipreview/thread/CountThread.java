package com.XiaoHuiHui.app.noipreview.thread;

import java.util.logging.Level;

import com.XiaoHuiHui.app.noipreview.tools.Outputer;

public class CountThread extends Thread{
	private int count = 0;

	@Override
	public void run() {
		Outputer.log(Level.FINE, "-------- Start Count Thread --------");
		while (!isInterrupted()) {
			try {
				Outputer.log(Level.FINE, "--------- Count Thread #" + ++count + " ----------");
				sleep(5000);
				
			} catch (InterruptedException e) {
				Thread.currentThread().interrupt();
				break;
			}
		}
	}
}
