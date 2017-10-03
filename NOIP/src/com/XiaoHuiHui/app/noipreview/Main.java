package com.XiaoHuiHui.app.noipreview;

import java.awt.EventQueue;
import java.io.File;
import java.util.logging.Level;

import javax.swing.JOptionPane;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

import com.XiaoHuiHui.app.noipreview.GUI.thread.StartFrameStart;
import com.XiaoHuiHui.app.noipreview.data.Database;
import com.XiaoHuiHui.app.noipreview.thread.CountThread;
import com.XiaoHuiHui.app.noipreview.tools.Outputer;

//入口类
public class Main {
	public static boolean isError = false;

	public static CountThread thread;

	// 入口
	public static void main(String[] args) {
		try {
			System.out.println("Start running...");
			Outputer.init();
			setUI();
			Database.init();
			Database.getInstance().read();
			EventQueue.invokeLater(new StartFrameStart());
			thread = new CountThread();
		} catch (Throwable e) {
			error(e);
		}
	}

	public static void error(Throwable e) {
		Outputer.log(Level.SEVERE, "An error occured:");
		Outputer.logError(e);
		e.printStackTrace();
		JOptionPane.showMessageDialog(null, "An error occured: " + e.getLocalizedMessage(), "Warning",
				JOptionPane.ERROR_MESSAGE);
		Main.isError = true;
		System.exit(1);
	}

	private static void setUI() throws ClassNotFoundException, InstantiationException, IllegalAccessException, UnsupportedLookAndFeelException {
		String lookAndFeel = UIManager.getSystemLookAndFeelClassName();
		UIManager.setLookAndFeel(lookAndFeel);
		Outputer.log(Level.INFO, "UI looking and feeling has been set...");
	}

	public static void exit() {
		if (Main.isError)
			return;
		Outputer.log(Level.INFO, "Stopping...");
		thread.interrupt();
		File file = new File("reviewer.log");
		if (file.exists()) {
			Outputer.shutdown();
			file.delete();
		}
		System.exit(0);
	}
}
