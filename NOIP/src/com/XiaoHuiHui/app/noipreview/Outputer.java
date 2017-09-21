package com.XiaoHuiHui.app.noipreview;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;
import java.util.logging.Level;

//输出并记录信息，工具类
public class Outputer {
	private static FileWriter fw;

	private static boolean isInit = false;

	public static void init() {
		File file = new File("reviewer.log");
		try {
			fw = new FileWriter(file);
		} catch (IOException e) {
			e.printStackTrace();
		}
		isInit = true;
		System.out.println("Outputer is ready...");
		log(Level.INFO, "Start to record...");
	}

	@SuppressWarnings("deprecation")
	public static void log(Level level, String msg) {
		if (!isInit)
			throw new IllegalArgumentException("Outputer class is not  an initialization!");
		Date date = new Date();
		String data = date.toGMTString() + " [" + level.getLocalizedName() + "]" + msg;
		try {
			fw.write(data + "\n");
			fw.flush();
		} catch (IOException e) {
			e.printStackTrace();
		}
		System.out.println(data);
	}

	public static void logError(Throwable e) {
		PrintWriter pw = new PrintWriter(fw);
		e.printStackTrace(pw);
		pw.close();
	}

	public static void shutdown() {
		try {
			fw.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	// Constract
	private Outputer() {
		throw new IllegalArgumentException("Unbelievable!!!");
	}
}
