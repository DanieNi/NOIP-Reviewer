package com.XiaoHuiHui.app.noipreview.GUI;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.logging.Level;

import com.XiaoHuiHui.app.noipreview.tools.Outputer;
import com.XiaoHuiHui.app.noipreview.GUI.frame.MainFrame;

public class CloseFrameWindowAdapter extends WindowAdapter{
	public static MainFrame main;
	
	String name;
	
	public CloseFrameWindowAdapter(String name) {
		super();
		this.name=name;
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ExitWindowAdapter other = (ExitWindowAdapter) obj;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}
	
	@Override
	public void windowClosing(WindowEvent arg0) {
		Outputer.log(Level.INFO, "Clicked Button FRAME_CLOSE_BUTTON on "+name);
		Outputer.log(Level.INFO, name+" Closed...");
		main.setEnabled(true);
	}

}
