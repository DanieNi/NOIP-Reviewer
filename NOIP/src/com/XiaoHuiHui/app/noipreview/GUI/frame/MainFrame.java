package com.XiaoHuiHui.app.noipreview.GUI.frame;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.XiaoHuiHui.app.noipreview.Main;
import com.XiaoHuiHui.app.noipreview.GUI.adapter.CloseFrameWindowAdapter;
import com.XiaoHuiHui.app.noipreview.GUI.adapter.ExitMouseAdapter;
import com.XiaoHuiHui.app.noipreview.GUI.adapter.ExitWindowAdapter;
import com.XiaoHuiHui.app.noipreview.tools.Outputer;

import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.util.logging.Level;

public class MainFrame extends JFrame {

	private static final long serialVersionUID = 3992464077921404112L;
	
	private static final String name="MainFrame";

	private JPanel contentPane;
	private JButton bSign;
	private JButton bApi;
	private JButton bHelp;
	private JButton bGit;
	private JButton bKnowledge;
	private JButton bCheck;
	private JButton bExit;
	private JLabel lbVersion;

	/**
	 * Create the frame.
	 */
	public MainFrame() {
		Outputer.log(Level.INFO, "Start Loading frame: MAIN_FRAME");
		CloseFrameWindowAdapter.main=this;
		contantPaneInit();
		mainFrameInit();
		bSignInit();
		bApiInit();
		bHelpInit();
		bGitInit();
		bKnowledgeInit();
		bCheckInit();
		bExitInit();
		lbVersionInit();

		mainFrameEventsRegister();
		bSignEventsRegister();
		bKnowledgeEventsRegister();
		bApiEventsRegister();
		bExitEventsRegister();
		Outputer.log(Level.INFO, "Loading complete...");
	}

	private void mainFrameEventsRegister() {
		Outputer.log(Level.INFO, "Registering events to Frame: mainFrame");
		addWindowListener(new ExitWindowAdapter(name));
	}

	private void bExitEventsRegister() {
		Outputer.log(Level.INFO, "Registering events to Button: bExit");
		bExit.addMouseListener(new ExitMouseAdapter(name));
	}

	private void bKnowledgeEventsRegister() {
		Outputer.log(Level.INFO, "Registering events to Button: bKnowledge");
		bKnowledge.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				Outputer.log(Level.INFO, "Clicked Button bKnowledge on mainFrame");
				MainFrame.this.setEnabled(false);
				EventQueue.invokeLater(new Runnable() {
					public void run() {
						try {
							TreeFrame frame = new TreeFrame(MainFrame.this);
							frame.setVisible(true);
							setEnabled(false);
						} catch (Throwable e) {
							Main.error(e);
						}
					}
				});
			}
		});
	}

	private void bSignEventsRegister() {
		Outputer.log(Level.INFO, "Registering events to Button: bSign");
		bSign.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Outputer.log(Level.INFO, "Clicked Button bSign on mainFrame");
				EventQueue.invokeLater(new Runnable() {
					public void run() {
						try {
							SignFrame frame = new SignFrame(MainFrame.this);
							frame.setVisible(true);
							setEnabled(false);
						} catch (Throwable e) {
							Main.error(e);
						}
					}
				});
			}
		});
	}

	private void lbVersionInit() {
		Outputer.log(Level.INFO, "Loading Label: lbVersion");
		lbVersion = new JLabel("Version:1.0");
		lbVersion.setHorizontalAlignment(SwingConstants.RIGHT);
		lbVersion.setFont(new Font("Dialog", Font.BOLD, 12));
		lbVersion.setBounds(80, 298, 135, 16);
		contentPane.add(lbVersion);
	}

	private void bExitInit() {
		Outputer.log(Level.INFO, "Loading Button: bExit");
		bExit = new JButton("退出");
		bExit.setFont(new Font("Dialog", Font.BOLD, 14));
		bExit.setBounds(38, 246, 146, 27);
		contentPane.add(bExit);
	}

	private void bCheckInit() {
		Outputer.log(Level.INFO, "Loading Button: bCheck");
		bCheck = new JButton("对拍程序");
		bCheck.setFont(new Font("Dialog", Font.BOLD, 14));
		bCheck.setBounds(38, 133, 146, 27);
		contentPane.add(bCheck);
	}

	private void bKnowledgeInit() {
		Outputer.log(Level.INFO, "Loading Button: bKnowledge");
		bKnowledge = new JButton("知识图谱");
		bKnowledge.setFont(new Font("Dialog", Font.BOLD, 14));
		bKnowledge.setBounds(38, 59, 146, 27);
		contentPane.add(bKnowledge);
	}

	private void bGitInit() {
		Outputer.log(Level.INFO, "Loading Button: bGit");
		bGit = new JButton("代码仓库");
		bGit.setFont(new Font("Dialog", Font.BOLD, 14));
		bGit.setBounds(38, 96, 146, 27);
		contentPane.add(bGit);
	}

	private void bHelpInit() {
		Outputer.log(Level.INFO, "Loading Button: bHelp");
		bHelp = new JButton("帮助");
		bHelp.setFont(new Font("Dialog", Font.BOLD, 14));
		bHelp.setBounds(38, 207, 146, 27);
		contentPane.add(bHelp);
	}

	private void bApiInit() {
		Outputer.log(Level.INFO, "Loading Button: bApi");
		bApi = new JButton("官方API");
		bApi.setFont(new Font("Dialog", Font.BOLD, 14));
		bApi.setBounds(38, 170, 146, 27);
		contentPane.add(bApi);
	}

	private void bApiEventsRegister() {
		bApi.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent arg0) {
				EventQueue.invokeLater(new Runnable() {
					public void run() {
						try {
							APIFrame frame = new APIFrame(MainFrame.this);
							frame.setVisible(true);
							setEnabled(false);
						} catch (Throwable e) {
							Main.error(e);
						}
					}
				});
			}
		});
	}

	private void bSignInit() {
		Outputer.log(Level.INFO, "Loading Button: bSign");
		bSign = new JButton("每日打卡");
		bSign.setFont(new Font("Dialog", Font.BOLD, 14));
		bSign.setBounds(38, 20, 146, 27);
		contentPane.add(bSign);
	}

	private void contantPaneInit() {
		Outputer.log(Level.INFO, "Loading Panel: contentPane");
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(null);
	}

	private void mainFrameInit() {
		Outputer.log(Level.INFO, "Loading Frame: mainFrame");
		setTitle("Menu");
		setResizable(false);
		setBounds(100, 100, 225, 346);
		setContentPane(contentPane);
	}
}
