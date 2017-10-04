package com.XiaoHuiHui.app.noipreview.GUI.adapter;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.logging.Level;

import javax.swing.JOptionPane;
import javax.swing.JPanel;

import com.XiaoHuiHui.app.noipreview.tools.Outputer;

public class AboutMouseAdapter extends MouseAdapter{
	JPanel pane;
	
	public AboutMouseAdapter(JPanel pane) {
		super();
		this.pane=pane;
	}
	
	@Override
	public void mouseReleased(MouseEvent e) {
		Outputer.log(Level.INFO,"Clicked Button bAbout on startFrame");
		JOptionPane.showMessageDialog(pane,
				"               NOIP Reviewer v1.0.\n"
						+ "        Made by DanieNi&XiaoHuihui\nCopyright © XingTai NO.1 Middle School",
				"About", JOptionPane.PLAIN_MESSAGE);
	}
}
