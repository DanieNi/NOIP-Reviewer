package com.XiaoHuiHui.app.noipreview.GUI.frame;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.XiaoHuiHui.app.noipreview.data.Database;
import com.XiaoHuiHui.app.noipreview.data.unit.Point;
import com.XiaoHuiHui.app.noipreview.tools.Outputer;

import javax.swing.JTextArea;

import java.awt.Font;
import javax.swing.JTree;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.logging.Level;

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

	private static final int scale = 1;

	private static final int frameWidth = 1280 * scale;
	private static final int frameHeight = 960 * scale;
	private static final int framePositionLeft = 100;
	private static final int framePositionTop = 100;

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
		Outputer.log(Level.INFO, "Start Loading frame: TREE_FRAME");
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
		Outputer.log(Level.INFO, "Loading complete...");
	}

	private void spTreeScreenInit() {
		Outputer.log(Level.INFO, "Loading ScrollPanel: spTreeScreen");
		spTreeScreen = new JScrollPane(jtChooser, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,
				JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		spTreeScreen.setBounds(6, 76, 280, 358);
		contentPane.add(spTreeScreen);
	}

	private void lbConstractInit() {
		Outputer.log(Level.INFO, "Loading Label: lbConstract");
		lbConstract = new JLabel("结构检索：");
		lbConstract.setFont(new Font("等线", Font.PLAIN, 15));
		lbConstract.setBounds(6, 51, 171, 15);
		contentPane.add(lbConstract);
	}

	private void lbNameIndexInit() {
		Outputer.log(Level.INFO, "Loading Label: lbNameIndex");
		lbNameIndex = new JLabel("名称检索：");
		lbNameIndex.setFont(new Font("等线", Font.PLAIN, 15));
		lbNameIndex.setBounds(6, 444, 171, 15);
		contentPane.add(lbNameIndex);
	}

	private void spListScreenInit() {
		Outputer.log(Level.INFO, "Loading ScrollPanel: spListScreen");
		spListScreen = new JScrollPane(jlChooser, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,
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
		Outputer.log(Level.INFO, "Registering events to Tree: jtChooser");
		jtChooser.addTreeSelectionListener(new TreeSelectionListener() {
			public void valueChanged(TreeSelectionEvent arg0) {
				Outputer.log(Level.INFO, "Tree jtChooser value changed on treeFrame");
				Point p = (Point) jtChooser.getLastSelectedPathComponent();
				if (p == null)
					return;
				taMainScreen.setText(p.getInScreen());
				taMainScreen.setCaretPosition(0);
			}
		});
	}

	private void jlChooserEventsRegister() {
		Outputer.log(Level.INFO, "Registering events to List: jlChooser");
		jlChooser.addListSelectionListener(new ListSelectionListener() {
			public void valueChanged(ListSelectionEvent arg0) {
				Outputer.log(Level.INFO, "List jlChooser value changed on treeFrame");
				Point p = Database.getInstance().getMap2().get(jlChooser.getSelectedValue());
				if (p == null)
					return;
				taMainScreen.setText(p.getInScreen());
				taMainScreen.setCaretPosition(0);
			}
		});
	}

	private void windowsEventsRegister(MainFrame frame) {
		Outputer.log(Level.INFO, "Registering events to Frame: mainFrame");
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent arg0) {
				Outputer.log(Level.INFO, "Clicked Button FRAME_CLOSE_BUTTON on treeFrame");
				frame.setEnabled(true);
			}
		});
	}

	private void jtChooserInit() {
		Outputer.log(Level.INFO, "Loading Tree: jtChooser");
		jtChooser = new JTree(Database.getInstance().getRoot());
		jtChooser.setFont(new Font("等线", Font.PLAIN, 15));
		jtChooser.getSelectionModel().setSelectionMode(TreeSelectionModel.SINGLE_TREE_SELECTION);
	}

	private void jlChooserInit() {
		Outputer.log(Level.INFO, "Loading List: jlChooser");
		String temp[] = Database.getInstance().getList().toArray(new String[Database.getInstance().getList().size()]);
		jlChooser = new JList<String>(temp);// TODO
		jlChooser.setFont(new Font("等线", Font.PLAIN, 15));
	}

	private void spMainScreenInit() {
		Outputer.log(Level.INFO, "Loading ScrollPanel: spMainScreen");
		spMainScreen = new JScrollPane(taMainScreen, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,
				JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		spMainScreen.setBounds(296, 10, 968, 910);
		contentPane.add(spMainScreen);
	}

	private void taMainScreenInit() {
		Outputer.log(Level.INFO, "Loading TextArea: taMainScreen");
		taMainScreen = new JTextArea();
		taMainScreen.setWrapStyleWord(true);
		taMainScreen.setTabSize(2);
		taMainScreen.setLineWrap(true);
		taMainScreen.setFont(new Font("等线", Font.PLAIN, 17));
		taMainScreen.setEditable(false);
	}

	private void bSearcherInit() {
		Outputer.log(Level.INFO, "Loading Button: bSearcher");
		bSearcher = new JButton("查询");
		bSearcher.setFont(new Font("等线", Font.PLAIN, 15));
		bSearcher.setBounds(201 * scale, 10 * scale, 85 * scale, 31 * scale);
		contentPane.add(bSearcher);
	}

	private void bSearcherEventsRegister() {
		Outputer.log(Level.INFO, "Registering events to Button: bSearcher");
		bSearcher.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent arg0) {
				Outputer.log(Level.INFO, "Clicked Button bSearcher on treeFrame");
				nodeFind();
			}
		});
	}

	private void tfSearcherInit() {
		Outputer.log(Level.INFO, "Loading TextField: tfSearcher");
		tfSearcher = new JTextField();
		tfSearcher.setFont(new Font("等线", Font.PLAIN, 15));
		tfSearcher.setBounds(6 * scale, 10 * scale, 185 * scale, 31 * scale);
		tfSearcher.setColumns(10);
		contentPane.add(tfSearcher);
	}

	private void tfSearcherEventsRegister() {
		Outputer.log(Level.INFO, "Registering events to TextField: tfSearcher");
		tfSearcher.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent arg0) {
				if (arg0.getKeyCode() != KeyEvent.VK_ENTER) {
					return;
				}
				Outputer.log(Level.INFO, "Key Enter was pressed...");
				nodeFind();
			}
		});
	}

	private void treeFrameInit() {
		Outputer.log(Level.INFO, "Loading Frame: treeFrame");
		setTitle("知识图谱");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(framePositionTop, framePositionLeft, frameWidth, frameHeight);
		setResizable(false);
		setLocationRelativeTo(null);
		setContentPane(contentPane);
	}

	private void nodeFind() {
		String name = tfSearcher.getText();
		Outputer.log(Level.INFO, "Search for "+name);
		if (name == null || name.isEmpty()) {
			Outputer.log(Level.WARNING, "name is null...");
			JOptionPane.showMessageDialog(contentPane, "请输入查询关键字！", "提示", JOptionPane.WARNING_MESSAGE);
			tfSearcher.requestFocus();
			return;
		}
		Point p = Database.getInstance().getMap2().get(name);
		if (p == null) {
			Outputer.log(Level.INFO, name+" not found...");
			JOptionPane.showMessageDialog(contentPane, "没有找到\"" + name + "\"关键字", "提示", JOptionPane.WARNING_MESSAGE);
			tfSearcher.requestFocus();
		} else {
			taMainScreen.setText(p.getInScreen());
			Point root = (Point) jtChooser.getModel().getRoot();
			TreePath treePath = new TreePath(root);
			treePath = findInPath(treePath, name);
			Outputer.log(Level.INFO, name+" has been found...");
			jtChooser.setSelectionPath(treePath);
		}
	}

	private TreePath findInPath(TreePath treePath, String str) {
		Object obj = treePath.getLastPathComponent();
		if (obj == null) {
			return null;
		}
		Point object = (Point) obj;
		String value = object.toString();
		if (str.equals(value)) {
			return treePath;
		} else {
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
