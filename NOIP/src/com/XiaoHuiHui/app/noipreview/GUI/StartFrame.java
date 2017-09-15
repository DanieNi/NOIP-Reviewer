package com.XiaoHuiHui.app.noipreview.GUI;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.border.EmptyBorder;

import java.awt.EventQueue;
import java.awt.Graphics;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.Font;

public class StartFrame extends JFrame {
	
	private static final long serialVersionUID = 434628657012947289L;
	
	private JPanel contentPane;
	private JButton bStart;
	private JButton bAbout;
	private JButton bExit;
	private JLabel lbIcon;

	/**
	 * Create the frame.
	 */
	public StartFrame() {
		contentPaneInit();
		startFrameInit();
		setUI();
		bStartInit();
		bAboutInit();
		bExitInit();
		lbIconInit();
		
		bStartEventsRegister();
		bAboutEventsRegister();
		bExitEventsRegister();
	}

	private void lbIconInit() {
		lbIcon = new JLabel("") {

			private static final long serialVersionUID = -4907073641583366787L;

			public void paintComponent(Graphics g) {
                super.paintComponent(g);
                String sp=System.getProperty("file.separator");
        		ImageIcon icon=new ImageIcon("image"+sp+"2.png");
                g.drawImage(icon.getImage(), 0, 0, getWidth(), getHeight(), icon.getImageObserver());
            }
		};
		lbIcon.setBounds(35, 21, 144, 144);
		contentPane.add(lbIcon);
	}

	private void bExitEventsRegister() {
		bExit.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent arg0) {
				System.exit(-1);
			}
		});
	}

	private void bExitInit() {
		bExit = new JButton("Exit");
		bExit.setFont(new Font("Consolas", Font.BOLD, 14));
		bExit.setBounds(35, 262, 146, 27);
		contentPane.add(bExit);
	}

	private void bAboutEventsRegister() {
		bAbout.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent e) {
				JOptionPane.showMessageDialog(contentPane, "               NOIP Reviewer v1.0.\n"
												+ "        Made by DanieNi&XiaoHuihui\nCopyright © XingTai NO.1 Middle School",
						"About", JOptionPane.PLAIN_MESSAGE);
			}
		});
	}

	private void bAboutInit() {
		bAbout = new JButton("About");
		bAbout.setFont(new Font("Consolas", Font.BOLD, 14));
		bAbout.setBounds(35, 225, 146, 27);
		contentPane.add(bAbout);
	}

	private void bStartEventsRegister() {
		bStart.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				EventQueue.invokeLater(new Runnable() {
					public void run() {
						try {
							MainFrame frame = new MainFrame();
							frame.setLocationRelativeTo(StartFrame.this);
							frame.setVisible(true);
							setVisible(false);
						} catch (Exception e) {
							e.printStackTrace();
						}
					}
				});
			}
		});
	}

	private void bStartInit() {
		bStart = new JButton("Start");
		bStart.setFont(new Font("Consolas", Font.BOLD, 14));
		bStart.setBounds(35, 188, 146, 27);
		contentPane.add(bStart);
	}

	private void setUI() {
		String lookAndFeel = UIManager.getSystemLookAndFeelClassName();
		try {
			UIManager.setLookAndFeel(lookAndFeel);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (InstantiationException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (UnsupportedLookAndFeelException e) {
			e.printStackTrace();
		}
	}

	private void contentPaneInit() {
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(null);
	}

	private void startFrameInit() {
		setResizable(false);
		setTitle("Launcher");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(50, 50, 225, 346);
		setContentPane(contentPane);
	}
}
