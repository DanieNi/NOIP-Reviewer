package com.XiaoHuiHui.app.noipreview.GUI;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.XiaoHuiHui.app.noipreview.data.Database;
import com.XiaoHuiHui.app.noipreview.data.Point;

import javax.swing.JTextArea;

import java.awt.Font;
import javax.swing.JTree;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.event.ListSelectionListener;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.TreeSelectionListener;
import javax.swing.tree.TreeModel;
import javax.swing.tree.TreePath;
import javax.swing.tree.TreeSelectionModel;
import javax.swing.event.TreeSelectionEvent;
import javax.swing.JScrollPane;
import javax.swing.JLabel;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class TreeFrame extends JFrame {

	private static final long serialVersionUID = -2557396141968806156L;
	
	private static final int scale=1;
	
	private static final int frameWidth=1280*scale;
	private static final int frameHeight=960*scale;
	private static final int framePositionLeft=100;
	private static final int framePositionTop=100;
	
	private JPanel contentPane;
	private JTextField tfSearcher;
	private JButton bSearcher;
	private JTextArea taMainScreen;
	private JList<String> jlChooser;
	private JTree jtChooser;
	private JScrollPane spMainScreen;
	private JScrollPane spTreeScreen;
	private JScrollPane spListScreen;
	private JLabel lbNameIndex;
	private JLabel lbConstract;
	
	/**
	 * Create the frame.
	 */
	public TreeFrame(MainFrame frame) {
		contentPaneInit();
		treeFrameInit();
		tfSearcherInit();
		bSearcherInit();
		taMainScreenInit();
		spMainScreenInit();
		jlChooserInit();
		spListScreenInit();
		jtChooserInit();
		spTreeScreenInit();
		lbNameIndexInit();
		lbConstractInit();
		
		windowsEventsRegister(frame);
		jlChooserEventsRegister();
		jtChooserEventsRegister();
		tfSearcherEventsRegister();
		bSearcherEventsRegister();
	}

	private void spTreeScreenInit() {
		spTreeScreen=new JScrollPane(jtChooser,
				JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,
				JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		spTreeScreen.setBounds(6, 76, 280, 358);
		contentPane.add(spTreeScreen);
	}

	private void lbConstractInit() {
		lbConstract = new JLabel("结构检索：");
		lbConstract.setBounds(6, 51, 171, 15);
		contentPane.add(lbConstract);
	}

	private void lbNameIndexInit() {
		lbNameIndex = new JLabel("名称检索：");
		lbNameIndex.setBounds(6, 444, 171, 15);
		contentPane.add(lbNameIndex);
	}

	private void spListScreenInit() {
		spListScreen=new JScrollPane(jlChooser,
				JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,
				JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		spListScreen.setBounds(6, 469, 280, 451);
		contentPane.add(spListScreen);
	}

	private void contentPaneInit() {
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(null);
	}

	private void jtChooserEventsRegister() {
		jtChooser.addTreeSelectionListener(new TreeSelectionListener() {
			public void valueChanged(TreeSelectionEvent arg0) {
				Point p=(Point)jtChooser.getLastSelectedPathComponent();
				if(p==null )return;
				taMainScreen.setText(p.getInScreen());
				taMainScreen.setCaretPosition(0);
			}
		});
	}

	private void jlChooserEventsRegister() {
		jlChooser.addListSelectionListener(new ListSelectionListener() {
			public void valueChanged(ListSelectionEvent arg0) {
				Point p=Database.map2.get(jlChooser.getSelectedValue());
				if(p==null )return;
				taMainScreen.setText(p.getInScreen());
				taMainScreen.setCaretPosition(0);
			}
		});
	}

	private void windowsEventsRegister(MainFrame frame) {
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent arg0) {
				frame.setEnabled(true);
			}
		});
	}

	private void jtChooserInit() {
		jtChooser = new JTree(Database.root);
		jtChooser.getSelectionModel().setSelectionMode(
				TreeSelectionModel.SINGLE_TREE_SELECTION);
	}

	private void jlChooserInit() {
		String temp[]=Database.list.toArray(
				new String[Database.list.size()]);
		jlChooser = new JList<String>(temp);//TODO
	}

	private void spMainScreenInit() {
		spMainScreen = new JScrollPane(taMainScreen,
				JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,
				JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		spMainScreen.setBounds(296, 10, 968, 910);
		contentPane.add(spMainScreen);
	}

	private void taMainScreenInit() {
		taMainScreen = new JTextArea();
		taMainScreen.setWrapStyleWord(true);
		taMainScreen.setTabSize(2);
		taMainScreen.setLineWrap(true);
		taMainScreen.setFont(new Font("等线", Font.PLAIN, 15));
		taMainScreen.setEditable(false);
	}

	private void bSearcherInit() {
		bSearcher = new JButton("查询");
		bSearcher.setBounds(201*scale, 10*scale, 85*scale, 31*scale);
		contentPane.add(bSearcher);
	}

	private void bSearcherEventsRegister() {
		bSearcher.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent arg0) {
				nodeFind();
			}
		});
	}

	private void tfSearcherInit() {
		tfSearcher = new JTextField();
		tfSearcher.setBounds(6*scale, 10*scale, 185*scale, 31*scale);
		tfSearcher.setColumns(10);
		contentPane.add(tfSearcher);
	}

	private void tfSearcherEventsRegister() {
		tfSearcher.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent arg0) {
				if(arg0.getKeyCode()!=KeyEvent.VK_ENTER) {
					return;
				}
				nodeFind();
			}
		});
	}

	private void treeFrameInit() {
		setTitle("知识图谱");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(framePositionTop,framePositionLeft,
				frameWidth,frameHeight);
		setResizable(false);
		setLocationRelativeTo(null);
		setContentPane(contentPane);
	}
	
	private void nodeFind() {
		String name=tfSearcher.getText();
		if(name==null || name.isEmpty()) {
			JOptionPane.showMessageDialog( contentPane,
				"请输入查询关键字！","提示",JOptionPane.WARNING_MESSAGE);
			tfSearcher.requestFocus();
			return;
		}
		Point p=Database.map2.get(name);
		if(p==null) {
			JOptionPane.showMessageDialog( contentPane,
				"没有找到\""+name+"\"关键字","提示",JOptionPane.WARNING_MESSAGE);
				tfSearcher.requestFocus();
		}else {
			taMainScreen.setText(p.getInScreen());
	        Point root = (Point)jtChooser.getModel().getRoot();  
	        TreePath treePath = new TreePath(root);
	        treePath = findInPath(treePath, name);
	        jtChooser.setSelectionPath(treePath);
		}
	}
	
	 private TreePath findInPath(TreePath treePath, String str){
		 Object obj = treePath.getLastPathComponent();
		 if (obj == null) {
			 return null;
		 }
		 Point object = (Point)obj;
		 String value = object.toString();
		 if (str.equals(value)) {
			 return treePath;
		 }else {
			 TreeModel model = jtChooser.getModel();
			 int n = model.getChildCount(object);
			 for (int i = 0; i < n; i++) {
				 Object child = model.getChild(object, i);
				 TreePath path = treePath.pathByAddingChild(child);
				 path = findInPath(path, str);
				 if (path != null) {
					 return path;
				 }
			 }
			 return null;
		 }
	 }
}
