package com.XiaoHuiHui.app.noipreview.data.unit;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Enumeration;
import java.util.Iterator;
import java.util.List;

import javax.swing.tree.TreeNode;

public class Point implements TreeNode {
	public static final int floorNum = 5;// 章节层数 以备扩展使用

	int Chapter[] = new int[Point.floorNum]; // 章节
	String nodeName; // 名称
	int sonNodeNum; // 儿子的个数
	String inScreen; // 屏幕显示的介绍
	String txtContent; // 新窗口显示的内容
	String codes; // 代码
	List<Point> sons; // 儿子们
	Point parent; // 爸爸

	// Constructor
	public Point(int Chapter[], String nodeName, int sonNodeNum, String inScreen, String txtContent, String codes,
			Point parent) {
		if (Chapter.length > Point.floorNum) {
			StringBuffer sb = new StringBuffer("编号：");
			for (int i = 0; i < Chapter.length; ++i) {
				sb.append(Chapter[i]);
				sb.append(".");
			}
			sb.append("不存在！");
			throw new IllegalArgumentException(sb.toString());
		}
		this.Chapter = Chapter;
		this.nodeName = nodeName;
		this.inScreen = inScreen;
		this.codes = codes;
		this.txtContent = txtContent;
		this.sonNodeNum = sonNodeNum;
		sons = new ArrayList<Point>();
		this.parent = parent;
	}

	// getter and setter
	public int getSonNodeNum() {
		return sonNodeNum;
	}

	public void setSonNodeNum(int sonNodeNum) {
		this.sonNodeNum = sonNodeNum;
	}

	public String getInScreen() {
		return inScreen;
	}

	public void setInScreen(String inScreen) {
		this.inScreen = inScreen;
	}

	public String getTxtContent() {
		return txtContent;
	}

	public void setTxtContent(String txtContent) {
		this.txtContent = txtContent;
	}

	public String getCodes() {
		return codes;
	}

	public void setCodes(String codes) {
		this.codes = codes;
	}

	public List<Point> getSons() {
		return sons;
	}

	public void setSons(List<Point> sons) {
		this.sons = sons;
	}

	public int[] getChapter() {
		return Chapter;
	}

	public String getNodeName() {
		return nodeName;
	}

	// hash and equal
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + Arrays.hashCode(Chapter);
		result = prime * result + ((nodeName == null) ? 0 : nodeName.hashCode());
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
		Point other = (Point) obj;
		if (!Arrays.equals(Chapter, other.Chapter))
			return false;
		if (nodeName == null) {
			if (other.nodeName != null)
				return false;
		} else if (!nodeName.equals(other.nodeName))
			return false;
		return true;
	}

	// 覆写TreeNode接口
	@Override
	public Enumeration<Point> children() {
		Iterator<Point> it = sons.iterator();
		Enumeration<Point> enu = new Enumeration<Point>() {

			@Override
			public boolean hasMoreElements() {
				return it.hasNext();
			}

			@Override
			public Point nextElement() {
				return it.next();
			}

		};
		return enu;
	}

	@Override
	public boolean getAllowsChildren() {
		return sonNodeNum == 0;
	}

	@Override
	public TreeNode getChildAt(int arg0) {
		return sons.get(arg0);
	}

	@Override
	public int getChildCount() {
		return sonNodeNum;
	}

	@Override
	public int getIndex(TreeNode arg0) {
		return sons.indexOf(arg0);
	}

	@Override
	public TreeNode getParent() {
		return parent;
	}

	@Override
	public boolean isLeaf() {
		return sonNodeNum == 0;
	}

	// TreeNode接口以toString()的结果作为名称
	@Override
	public String toString() {
		return nodeName;
	}

}
