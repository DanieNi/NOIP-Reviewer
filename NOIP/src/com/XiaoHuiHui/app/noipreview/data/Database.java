package com.XiaoHuiHui.app.noipreview.data;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.text.Collator;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.List;
import java.util.Map;

import org.yaml.snakeyaml.Yaml;

//数据存储和处理类，这是一个工具类
public class Database {
	//Construct
	private Database() {
		throw new IllegalArgumentException("Unbelievable!!!!!");
	}

	public static final int BUFF=1000; //缓冲区
	
	//不同系统的不同文件分隔符
	public static final String sp=System.getProperty("file.separator");
	
	public static Point root; //根节点
	
	//通过章节检索数据
	public static Hashtable<int[],Point> map=new Hashtable<int[],Point>();
	
	//通过名称检索数据
	public static HashMap<String,Point> map2=new HashMap<String,Point>();
	
	//名称列表
	public static List<String> list=new ArrayList<String>();
	
	//读取根节点的数据
	public static void read() {
		read(null,"data"+sp,-1);
		 Collections.sort(list, new Comparator<String>() {  
	            @Override  
	            public int compare(String o1, String o2) {  
	                Comparator<Object> com = Collator.
	                		getInstance(java.util.Locale.CHINA);  
	                return com.compare(o1, o2);  
	  
	            }  
	        });  
	}
	
	//读取某一节点的数据
	@SuppressWarnings("rawtypes")
	public static void read(Point p,String path,int floor) {
		System.out.println(path);//TODO
		if(floor >= Point.floorNum) {
			throw new IllegalArgumentException(
					"Floor "+floor+" can't be over "+Point.floorNum);
		}
		int sonsNum=0,i;
				if(p!=null) {
					sonsNum=p.getSonNodeNum();
					i=1;
				}else {
					i=0;
				}
		for(;i<=sonsNum;++i) {
	        int temp[]= {0,0,0,0,0};
	        if(p!=null) {
	        	temp=p.getChapter();
		        temp[floor]=i;
	        }
			Yaml yaml = new Yaml();
			Map map=null;
	        try {  
	            Object obj = yaml.load(new FileInputStream(path+i+sp+"conf.yml"));
	            map=(Map)obj;
	        } catch (FileNotFoundException e) {
	            e.printStackTrace();  
	        }
	        String nodeName=(String)map.get("nodeName");
	        String inScreenPath=(String)map.get("inScreen");
	        String inScreen=null;
	        String codesPath=(String)map.get("codes");
	        String codes = null;
	        String txtContentPath=(String)map.get("txtContent");
	        String txtContent = null;
			try {
				if(codesPath!=null && !codesPath.equals(""))
					codes = readFile(path+i+sp+codesPath,i);
				if(txtContentPath!=null && !txtContentPath.equals(""))
					txtContent = readFile(path+i+sp+txtContentPath,i);
				if(inScreenPath!=null && !inScreenPath.equals(""))
					inScreen = readFile(path+i+sp+inScreenPath,i);
			} catch (IOException e) {
				e.printStackTrace();
			}
			Point te = new Point(temp,nodeName,
					(int)map.get("sonNodeNum"),
					inScreen,txtContent,codes,p);
			if(p!=null)p.getSons().add(te);
			else root=te;
			Database.map.put(temp, te);
			Database.map2.put(nodeName, te);
			if(te.isLeaf()) {
				Database.list.add(nodeName);
			}
			read(te,path+i+sp,floor+1);
		}
	}
	
	//读取某一个文件的文本信息
	public static String readFile(String path,int i) throws IOException {
		System.out.println(path); //TODO
        StringBuffer codes=new StringBuffer("");
        FileReader fr=new FileReader(path);
        char buff[]=new char[Database.BUFF];
        while(fr.read(buff)!=-1) {
        	codes.append(buff);
        }
        fr.close();
        return codes.toString();
	}
	
}
