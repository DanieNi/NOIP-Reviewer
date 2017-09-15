package com.XiaoHuiHui.app.noipreview.GUI;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class MainFrame extends JFrame {

	private static final long serialVersionUID = 3992464077921404112L;
	
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
		
		bSignEventsRegister();
		bKnowledgeEventsRegister();
		bExitEventsRegister();
	}

	private void bExitEventsRegister() {
		bExit.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent arg0) {
				System.exit(-1);
			}
		});
	}

	private void bKnowledgeEventsRegister() {
		bKnowledge.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				MainFrame.this.setEnabled(false);
				EventQueue.invokeLater(new Runnable() {
					public void run() {
						try {
							TreeFrame frame = new TreeFrame(MainFrame.this);
							frame.setVisible(true);
						} catch (Exception e) {
							e.printStackTrace();
						}
					}
				});
			}
		});
	}

	private void bSignEventsRegister() {
		bSign.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				EventQueue.invokeLater(new Runnable() {
					public void run() {
						try {
							SignFrame frame = new SignFrame();
							frame.setVisible(true);
						} catch (Exception e) {
							e.printStackTrace();
						}
					}
				});
			}
		});
	}

	private void lbVersionInit() {
		lbVersion = new JLabel("Version:1.0 BETA");
		lbVersion.setHorizontalAlignment(SwingConstants.RIGHT);
		lbVersion.setFont(new Font("Dialog", Font.BOLD, 12));
		lbVersion.setBounds(80, 298, 135, 16);
		contentPane.add(lbVersion);
	}

	private void bExitInit() {
		bExit = new JButton("退出");
		bExit.setFont(new Font("Dialog", Font.BOLD, 14));
		bExit.setBounds(38, 246, 146, 27);
		contentPane.add(bExit);
	}

	private void bCheckInit() {
		bCheck = new JButton("对拍程序");
		bCheck.setFont(new Font("Dialog", Font.BOLD, 14));
		bCheck.setBounds(38, 133, 146, 27);
		contentPane.add(bCheck);
	}

	private void bKnowledgeInit() {
		bKnowledge = new JButton("知识图谱");
		bKnowledge.setFont(new Font("Dialog", Font.BOLD, 14));
		bKnowledge.setBounds(38, 59, 146, 27);
		contentPane.add(bKnowledge);
	}

	private void bGitInit() {
		bGit = new JButton("代码仓库");
		bGit.setFont(new Font("Dialog", Font.BOLD, 14));
		bGit.setBounds(38, 96, 146, 27);
		contentPane.add(bGit);
	}

	private void bHelpInit() {
		bHelp = new JButton("帮助");
		bHelp.setFont(new Font("Dialog", Font.BOLD, 14));
		bHelp.setBounds(38, 207, 146, 27);
		contentPane.add(bHelp);
	}

	private void bApiInit() {
		bApi = new JButton("官方API");
		bApi.setFont(new Font("Dialog", Font.BOLD, 14));
		bApi.setBounds(38, 170, 146, 27);
		contentPane.add(bApi);
	}

	private void bSignInit() {
		bSign = new JButton("每日打卡");
		bSign.setFont(new Font("Dialog", Font.BOLD, 14));
		bSign.setBounds(38, 20, 146, 27);
		contentPane.add(bSign);
	}

	private void contantPaneInit() {
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(null);
	}

	private void mainFrameInit() {
		setTitle("Menu");
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 225, 346);
		setContentPane(contentPane);
	}
}
