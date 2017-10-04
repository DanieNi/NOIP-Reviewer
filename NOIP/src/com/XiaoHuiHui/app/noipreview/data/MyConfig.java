package com.XiaoHuiHui.app.noipreview.data;

import java.io.Serializable;

public class MyConfig implements Serializable{
	
	private static final long serialVersionUID = -5546790332590375772L;
	
	int days;

	public int getDays() {
		return days;
	}

	public void setDays(int days) {
		this.days = days;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + days;
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
		MyConfig other = (MyConfig) obj;
		if (days != other.days)
			return false;
		return true;
	}
	
}
