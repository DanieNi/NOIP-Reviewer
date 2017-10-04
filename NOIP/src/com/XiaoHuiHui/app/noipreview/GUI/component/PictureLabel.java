package com.XiaoHuiHui.app.noipreview.GUI.component;

import java.awt.Color;
import java.awt.Graphics;
import java.net.URL;
import java.util.logging.Level;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

import com.XiaoHuiHui.app.noipreview.tools.Outputer;

public class PictureLabel extends JLabel{
	private static final long serialVersionUID = -4907073641583366787L;
	
	ImageIcon icon;
	
	public PictureLabel(ImageIcon icon) {
		super();
		this.icon=icon;
	}
	
	public PictureLabel(URL url) {
		super();
		ImageIcon icon = new ImageIcon(url);
		Outputer.log(Level.INFO, "Read file:image/2.png");
		this.icon=icon;
	}
	
	public ImageIcon getIcon() {
		return icon;
	}

	public void setIcon(ImageIcon icon) {
		this.icon = icon;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((icon == null) ? 0 : icon.hashCode());
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
		PictureLabel other = (PictureLabel) obj;
		if (icon == null) {
			if (other.icon != null)
				return false;
		} else if (!icon.equals(other.icon))
			return false;
		return true;
	}

	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.setColor(Color.getHSBColor(0f, 0f, 0.95f));
		g.fillRect(0, 0, getWidth(), getHeight());
		g.drawImage(icon.getImage(), 0, 0, getWidth(), getHeight(), icon.getImageObserver());
	}
}
