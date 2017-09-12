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

	/**
	 * Create the frame.
	 */
	public StartFrame() {
		setResizable(false);
		setTitle("Launcher");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(50, 50, 225, 346);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		String lookAndFeel = UIManager.getSystemLookAndFeelClassName();
		try {
			UIManager.setLookAndFeel(lookAndFeel);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InstantiationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (UnsupportedLookAndFeelException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		JButton button = new JButton("Start");
		button.setFont(new Font("Consolas", Font.BOLD, 14));
		button.addMouseListener(new MouseAdapter() {
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
		button.setBounds(35, 188, 146, 27);
		contentPane.add(button);
		
		JButton button_1 = new JButton("About");
		button_1.setFont(new Font("Consolas", Font.BOLD, 14));
		button_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent e) {
				JOptionPane.showMessageDialog(contentPane, "               NOIP Reviewer v1.0.\n        Made by DanieNi&XiaoHuihui\nCopyright © XingTai NO.1 Middle School", "About", JOptionPane.PLAIN_MESSAGE);
			}
		});
		button_1.setBounds(35, 225, 146, 27);
		contentPane.add(button_1);
		
		JButton button_2 = new JButton("Exit");
		button_2.setFont(new Font("Consolas", Font.BOLD, 14));
		button_2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent arg0) {
				System.exit(-1);
			}
		});
		button_2.setBounds(35, 262, 146, 27);
		contentPane.add(button_2);
		
		JLabel lblNewLabel = new JLabel("") {
			
			private static final long serialVersionUID = -4907073641583366787L;

			public void paintComponent(Graphics g) {
                super.paintComponent(g);
                String sp=System.getProperty("file.separator");
        		ImageIcon icon=new ImageIcon("image"+sp+"2.png");
                g.drawImage(icon.getImage(), 0, 0, getWidth(), getHeight(), icon.getImageObserver());
            }
		};
		lblNewLabel.setBounds(35, 21, 144, 144);
		contentPane.add(lblNewLabel);
	}
}
