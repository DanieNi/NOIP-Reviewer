package com.XiaoHuiHui.app.noipreview.data.tools;

import java.text.Collator;
import java.util.Comparator;

public class MyComparator<T> implements Comparator<T>{
	@Override
	public int compare(T o1, T o2) {
		Comparator<Object> com = Collator.getInstance(java.util.Locale.CHINA);
		return com.compare(o1, o2);
	}
}
