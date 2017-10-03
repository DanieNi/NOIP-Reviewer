package com.XiaoHuiHui.app.noipreview.GUI.frame;


import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.XiaoHuiHui.app.noipreview.GUI.adapter.CloseFrameWindowAdapter;
import com.XiaoHuiHui.app.noipreview.tools.Outputer;

import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import java.awt.Font;
import java.util.logging.Level;

import javax.swing.JLabel;

public class APIFrame extends JFrame {

	private static final long serialVersionUID = -5934336601941115277L;
	
	private static final String name="APIFrame";
	
	private JPanel contentPane;
	private JScrollPane scrollPane;
	private JTextArea thisIsJustTextArea;
	private JLabel lbJustOne;
	
	/**
	 * Create the frame.
	 */
	public APIFrame(MainFrame main) {
		Outputer.log(Level.INFO, "Start Loading frame: API_FRAME");
		contentPaneInit();
		apiFrameInit();
		thisIsJustTextAreaInit();
		scrollPaneInit();
		lbJustOneInit();
		
		apiFrameEventsRegister();
		Outputer.log(Level.INFO, "Loading complete...");
	}

	private void apiFrameEventsRegister() {
		Outputer.log(Level.INFO, "Registering events to Frame: APIFrame");
		addWindowListener(new CloseFrameWindowAdapter(name));
	}

	private void lbJustOneInit() {
		Outputer.log(Level.INFO, "Loading Label: lbJustOne");
		lbJustOne = new JLabel("请将以下网址复制到浏览器打开：");
		lbJustOne.setFont(new Font("Lucida Grande", Font.PLAIN, 16));
		lbJustOne.setBounds(26, 17, 267, 16);
		contentPane.add(lbJustOne);
	}

	private void scrollPaneInit() {
		Outputer.log(Level.INFO, "Loading ScrollPane: scrollPane");
		scrollPane = new JScrollPane(thisIsJustTextArea);
		scrollPane.setBounds(26, 45, 294, 97);
		contentPane.add(scrollPane);
	}

	private void thisIsJustTextAreaInit() {
		Outputer.log(Level.INFO, "Loading TextArea: thisIsJustTextArea");
		thisIsJustTextArea = new JTextArea();
		thisIsJustTextArea.setEditable(false);
		thisIsJustTextArea.setFont(new Font("Lucida Grande", Font.PLAIN, 18));
		thisIsJustTextArea.setText("http://www.cplusplus.com/\nhttp://en.cppreference.com/w/");
	}

	private void apiFrameInit() {
		Outputer.log(Level.INFO, "Loading Frame: APIFrame");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 348, 193);
		setContentPane(contentPane);
	}

	private void contentPaneInit() {
		Outputer.log(Level.INFO, "Loading Panel: contentPane");
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(null);
	}
}
