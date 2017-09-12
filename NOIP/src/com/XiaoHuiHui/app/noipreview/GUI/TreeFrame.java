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
import javax.swing.event.ListSelectionListener;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.TreeSelectionListener;
import javax.swing.event.TreeSelectionEvent;
import javax.swing.JScrollPane;

public class TreeFrame extends JFrame {

	private static final long serialVersionUID = -2557396141968806156L;
	private JPanel contentPane;
	private JTextField textField;
	@SuppressWarnings("unused")
	private MainFrame frame;

	/**
	 * Create the frame.
	 */
	public TreeFrame(MainFrame frame) {
		setTitle("知识图谱");
		this.frame=frame;
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent arg0) {
				frame.setEnabled(true);
			}
		});
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 1280,  960);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		setResizable(false);
		setLocationRelativeTo(null);
		
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(296, 10, 968, 911);
		contentPane.add(scrollPane);
		scrollPane.setHorizontalScrollBarPolicy( 
		JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED); 
		scrollPane.setVerticalScrollBarPolicy( 
		JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED); 
		
		JTree tree = new JTree(Database.root);
		tree.addTreeSelectionListener(new TreeSelectionListener() {
			public void valueChanged(TreeSelectionEvent arg0) {
			}
		});
		tree.setBounds(6, 51, 280, 326);
		contentPane.add(tree);
		
		textField = new JTextField();
		textField.setBounds(6, 10, 185, 31);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JButton btnNewButton = new JButton("查询");
		btnNewButton.setBounds(201, 10, 85, 31);
		contentPane.add(btnNewButton);
		
		JTextArea textArea = new JTextArea();
		textArea.setWrapStyleWord(true);
		textArea.setTabSize(2);
		textArea.setLineWrap(true);
		textArea.setFont(new Font("等线", Font.PLAIN, 15));
		textArea.setEditable(false);
		textArea.setBounds(0, 0, 968, 911);
		scrollPane.add(textArea);
		
		String temp[]=Database.list.toArray(new String[Database.list.size()]);
		JList<String> list = new JList<String>(temp);
		list.addListSelectionListener(new ListSelectionListener() {
			public void valueChanged(ListSelectionEvent arg0) {
				Point p=Database.map2.get(list.getSelectedValue());
				if(p==null )return;
				textArea.setText(p.getInScreen());
			}
		});
		list.setBounds(6, 387, 280, 534);
		contentPane.add(list);
	}
}
