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

	/**
	 * Create the frame.
	 */
	public MainFrame() {
		setTitle("Menu");
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 225, 346);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton button = new JButton("每日打卡");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		button.setFont(new Font("Dialog", Font.BOLD, 14));
		button.setBounds(38, 20, 146, 27);
		contentPane.add(button);
		
		JButton btnapi = new JButton("官方API");
		btnapi.setFont(new Font("Dialog", Font.BOLD, 14));
		btnapi.setBounds(38, 170, 146, 27);
		contentPane.add(btnapi);
		
		JButton button_2 = new JButton("帮助");
		button_2.setFont(new Font("Dialog", Font.BOLD, 14));
		button_2.setBounds(38, 207, 146, 27);
		contentPane.add(button_2);
		
		JButton button_3 = new JButton("代码仓库");
		button_3.setFont(new Font("Dialog", Font.BOLD, 14));
		button_3.setBounds(38, 96, 146, 27);
		contentPane.add(button_3);
		
		JButton button_4 = new JButton("知识图谱");
		button_4.addMouseListener(new MouseAdapter() {
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
		button_4.setFont(new Font("Dialog", Font.BOLD, 14));
		button_4.setBounds(38, 59, 146, 27);
		contentPane.add(button_4);
		
		JButton button_5 = new JButton("对拍程序");
		button_5.setFont(new Font("Dialog", Font.BOLD, 14));
		button_5.setBounds(38, 133, 146, 27);
		contentPane.add(button_5);
		
		JButton button_1 = new JButton("退出");
		button_1.setFont(new Font("Dialog", Font.BOLD, 14));
		button_1.setBounds(38, 246, 146, 27);
		button_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent arg0) {
				System.exit(-1);
			}
		});
		contentPane.add(button_1);
		
		JLabel lblNewLabel = new JLabel("Version:1.0 BETA");
		lblNewLabel.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel.setFont(new Font("Dialog", Font.BOLD, 12));
		lblNewLabel.setBounds(80, 298, 135, 16);
		contentPane.add(lblNewLabel);
		
	}
}
