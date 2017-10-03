package com.XiaoHuiHui.app.noipreview.data;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;

import org.yaml.snakeyaml.Yaml;

import com.XiaoHuiHui.app.noipreview.data.tools.MyComparator;
import com.XiaoHuiHui.app.noipreview.data.unit.Point;
import com.XiaoHuiHui.app.noipreview.tools.Outputer;

//数据存储和处理类，这是一个单例类
public class Database {
	private static boolean isInit = false;
	private static Database instance;

	public static void init() {
		instance = new Database();
		isInit = true;
		Outputer.log(Level.INFO, "Database enabled...");
	}

	public static Database getInstance() {
		if (!isInit)
			throw new IllegalArgumentException("Database class is not an initialization!");
		return instance;
	}

	// Construct
	private Database() {
	}

	public static final int BUFF = 1000; // 缓冲区

	// 不同系统的不同文件分隔符
	// public static final String sp=System.getProperty("file.separator");
	public static final String sp = "/";

	private Point root; // 根节点

	// 通过章节检索数据
	private Hashtable<int[], Point> map = new Hashtable<int[], Point>();

	// 通过名称检索数据
	private HashMap<String, Point> map2 = new HashMap<String, Point>();

	// 名称列表
	private List<String> list = new ArrayList<String>();

	// 读取根节点的数据
	public void read() {
		read(null, "data" + sp, -1);
		Collections.sort(list, new MyComparator<String>());
		Outputer.log(Level.INFO, "Read completely...");
	}

	// 读取某一节点的数据
	@SuppressWarnings("rawtypes")
	public void read(Point p, String path, int floor) {
		Outputer.log(Level.INFO, "Search index:" + path);
		if (floor >= Point.floorNum) {
			throw new IllegalArgumentException("Floor " + floor + " can't be over " + Point.floorNum);
		}
		int sonsNum = 0, i;
		if (p != null) {
			sonsNum = p.getSonNodeNum();
			i = 1;
		} else {
			i = 0;
		}
		for (; i <= sonsNum; ++i) {
			int temp[] = { 0, 0, 0, 0, 0 };
			if (p != null) {
				temp = p.getChapter();
				temp[floor] = i;
			}
			Yaml yaml = new Yaml();
			Map map = null;
			Outputer.log(Level.INFO, "Reading yaml file:" + path + i + sp + "conf.yml");
			InputStream is = Database.class.getResourceAsStream(path + i + sp + "conf.yml");
			Object obj = yaml.load(is);
			map = (Map) obj;
			String nodeName = (String) map.get("nodeName");
			String inScreenPath = (String) map.get("inScreen");
			String inScreen = null;
			String codesPath = (String) map.get("codes");
			String codes = null;
			String txtContentPath = (String) map.get("txtContent");
			String txtContent = null;
			try {
				if (codesPath != null && !codesPath.equals(""))
					codes = readFile(path + i + sp + codesPath, i);
				if (txtContentPath != null && !txtContentPath.equals(""))
					txtContent = readFile(path + i + sp + txtContentPath, i);
				if (inScreenPath != null && !inScreenPath.equals(""))
					inScreen = readFile(path + i + sp + inScreenPath, i);
			} catch (IOException e) {
				e.printStackTrace();
			}
			Point te = new Point(temp, nodeName, (int) map.get("sonNodeNum"), inScreen, txtContent, codes, p);
			if (p != null) {
				p.getSons().add(te);
				Outputer.log(Level.INFO, "Constract Point: " + te.getNodeName());
			} else {
				root = te;
				Outputer.log(Level.INFO, "Constract Root");
			}
			this.map.put(temp, te);
			map2.put(nodeName, te);
			if (te.isLeaf()) {
				list.add(nodeName);
			}
			read(te, path + i + sp, floor + 1);
		}
	}

	// 读取某一个文件的文本信息
	public String readFile(String path, int i) throws IOException {
		Outputer.log(Level.INFO, "Reading data file:" + path + " with UTF-8");
		StringBuffer codes = new StringBuffer("");
		InputStream is = this.getClass().getResourceAsStream(path);
		InputStreamReader fr = new InputStreamReader(is, "UTF-8");
		char buff[] = new char[Database.BUFF];
		while (fr.read(buff) != -1) {
			codes.append(buff);
		}
		fr.close();
		return codes.toString();
	}

	public Point getRoot() {
		return root;
	}

	public void setRoot(Point root) {
		this.root = root;
	}

	public Hashtable<int[], Point> getMap() {
		return map;
	}

	public void setMap(Hashtable<int[], Point> map) {
		this.map = map;
	}

	public HashMap<String, Point> getMap2() {
		return map2;
	}

	public void setMap2(HashMap<String, Point> map2) {
		this.map2 = map2;
	}

	public List<String> getList() {
		return list;
	}

	public void setList(List<String> list) {
		this.list = list;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((root == null) ? 0 : root.hashCode());
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
		Database other = (Database) obj;
		if (root == null) {
			if (other.root != null)
				return false;
		} else if (!root.equals(other.root))
			return false;
		return true;
	}
}
