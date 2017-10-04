package com.XiaoHuiHui.app.noipreview.GUI.adapter;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.logging.Level;

import com.XiaoHuiHui.app.noipreview.Main;
import com.XiaoHuiHui.app.noipreview.tools.Outputer;

public class ExitMouseAdapter extends MouseAdapter{
	
	String name;
	
	public ExitMouseAdapter(String name) {
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
		ExitMouseAdapter other = (ExitMouseAdapter) obj;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}

	@Override
	public void mouseReleased(MouseEvent arg0) {
		Outputer.log(Level.INFO,"Clicked Button bExit on "+name);
		Outputer.log(Level.INFO,name+" Closed...");
		Main.exit();
	}

}
