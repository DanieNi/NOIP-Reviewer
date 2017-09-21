package com.XiaoHuiHui.app.noipreview.GUI;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.XiaoHuiHui.app.noipreview.Main;
import com.XiaoHuiHui.app.noipreview.Outputer;

import java.awt.EventQueue;
import java.awt.Graphics;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.net.URL;
import java.util.logging.Level;
import java.awt.Font;

public class StartFrame extends JFrame {

	private static final long serialVersionUID = 434628657012947289L;
	
	private static final String name="StartFrame";
	
	private JPanel contentPane;
	private JButton bStart;
	private JButton bAbout;
	private JButton bExit;
	private JLabel lbIcon;

	/**
	 * Create the frame.
	 */
	public StartFrame() {
		Outputer.log(Level.INFO, "Start Loading frame: START_FRAME");
		contentPaneInit();
		startFrameInit();
		bStartInit();
		bAboutInit();
		bExitInit();
		lbIconInit();

		startFrameEventsRegister();
		bStartEventsRegister();
		bAboutEventsRegister();
		bExitEventsRegister();
		Outputer.log(Level.INFO, "Loading complete...");
		Main.thread.start();
	}

	private void startFrameEventsRegister() {
		Outputer.log(Level.INFO, "Registering events to Frame: startFrame");
		addWindowListener(new ExitWindowAdapter(name));
	}

	private void lbIconInit() {
		Outputer.log(Level.INFO, "Loading Label: lbIcon");
		URL url = this.getClass().getResource("image/2.png");
		ImageIcon icon = new ImageIcon(url);
		Outputer.log(Level.INFO, "Read file:image/2.png");
		lbIcon = new JLabel("") {

			private static final long serialVersionUID = -4907073641583366787L;

			public void paintComponent(Graphics g) {
				super.paintComponent(g);
				g.drawImage(icon.getImage(), 0, 0, getWidth(), getHeight(), icon.getImageObserver());
			}
		};
		lbIcon.setBounds(35, 21, 144, 144);
		contentPane.add(lbIcon);
	}

	private void bExitEventsRegister() {
		Outputer.log(Level.INFO, "Registering events to Button: bExit");
		bExit.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent arg0) {
				Outputer.log(Level.INFO,"Clicked Button bExit on startFrame");
				Outputer.log(Level.INFO,"StartFrame Closed...");
				Main.exit();
			}
		});
	}

	private void bExitInit() {
		Outputer.log(Level.INFO, "Loading Button: bExit");
		bExit = new JButton("Exit");
		bExit.setFont(new Font("Consolas", Font.BOLD, 14));
		bExit.setBounds(35, 262, 146, 27);
		contentPane.add(bExit);
	}

	private void bAboutEventsRegister() {
		Outputer.log(Level.INFO, "Registering events to Button: bAbout");
		bAbout.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent e) {
				Outputer.log(Level.INFO,"Clicked Button bAbout on startFrame");
				JOptionPane.showMessageDialog(contentPane,
						"               NOIP Reviewer v1.0.\n"
								+ "        Made by DanieNi&XiaoHuihui\nCopyright © XingTai NO.1 Middle School",
						"About", JOptionPane.PLAIN_MESSAGE);
			}
		});
	}

	private void bAboutInit() {
		Outputer.log(Level.INFO, "Loading Button: bAbout");
		bAbout = new JButton("About");
		bAbout.setFont(new Font("Consolas", Font.BOLD, 14));
		bAbout.setBounds(35, 225, 146, 27);
		contentPane.add(bAbout);
	}

	private void bStartEventsRegister() {
		Outputer.log(Level.INFO, "Registering events to Button: bStart");
		bStart.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Outputer.log(Level.INFO,"Click bStart Button on startFrame");
				EventQueue.invokeLater(new Runnable() {
					public void run() {
						try {
							MainFrame frame = new MainFrame();
							frame.setLocationRelativeTo(StartFrame.this);
							frame.setVisible(true);
							setVisible(false);
						} catch (Throwable e) {
							Main.error(e);
						}
					}
				});
			}
		});
	}

	private void bStartInit() {
		Outputer.log(Level.INFO, "Loading Button: bStart");
		bStart = new JButton("Start");
		bStart.setFont(new Font("Consolas", Font.BOLD, 14));
		bStart.setBounds(35, 188, 146, 27);
		contentPane.add(bStart);
	}

	private void contentPaneInit() {
		Outputer.log(Level.INFO, "Loading Panel: contentPane");
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(null);
	}

	private void startFrameInit() {
		Outputer.log(Level.INFO, "Loading Frame: startFrame");
		setResizable(false);
		setTitle("Launcher");
		setBounds(50, 50, 225, 346);
		setContentPane(contentPane);
	}
}
