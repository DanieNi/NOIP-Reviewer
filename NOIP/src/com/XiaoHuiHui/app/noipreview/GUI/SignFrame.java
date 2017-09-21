package com.XiaoHuiHui.app.noipreview.GUI;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.XiaoHuiHui.app.noipreview.Main;

import javax.swing.JLabel;

import java.awt.Font;

import javax.swing.JButton;
import java.util.Random;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class SignFrame extends JFrame {

	private static final long serialVersionUID = -1483569055933898774L;
	
	private static final String name="SignFrame";
	
	private static final char nullStar='☆';
	private static final char fullStar='★';

	private JPanel contentPane;
	private JPanel contentPane2;
	private JButton bCard1;
	private JButton bCard2;
	private JButton bCard3;
	private JLabel lbChooseCard;
	private JLabel lbToday;
	private JLabel lbSign;
	private JPanel pShould;
	private JPanel pShouldNot;
	private JLabel lbMsg;
	private StringBuffer todayLuck;
	private int i2,i3,i4,days;

	/**
	 * Create the frame.
	 */
	public SignFrame(MainFrame main) {
		contantPaneInit();
		signFrameInit();
		contantPane2Init();
		
		signFrameEventsRegister(main);

		


		bCard1 = new JButton("New button");
		bCard1.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent arg0) {
				rand();
			}

			@Override
			public void mouseEntered(MouseEvent e) {
				bCard1.setBounds(13, 34, 183, 263);
			}

			@Override
			public void mouseExited(MouseEvent e) {
				bCard1.setBounds(23, 44, 163, 243);
			}
		});
		bCard1.setBounds(23, 44, 163, 243);
		contentPane.add(bCard1);

		bCard2 = new JButton("New button");
		bCard2.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent arg0) {
				rand();
			}
			
			@Override
			public void mouseEntered(MouseEvent e) {
				bCard2.setBounds(203, 34, 183, 263);
			}

			@Override
			public void mouseExited(MouseEvent e) {
				bCard2.setBounds(213, 44, 163, 243);
			}
		});
		bCard2.setBounds(213, 44, 163, 243);
		contentPane.add(bCard2);

		bCard3 = new JButton("New button");
		bCard3.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent arg0) {
				rand();
			}
			
			@Override
			public void mouseEntered(MouseEvent e) {
				bCard3.setBounds(396, 34, 183, 263);
			}

			@Override
			public void mouseExited(MouseEvent e) {
				bCard3.setBounds(406, 44, 163, 243);
			}
		});
		bCard3.setBounds(406, 44, 163, 243);
		contentPane.add(bCard3);

		lbChooseCard = new JLabel("请从下面三张牌中选(%%%)一张");
		lbChooseCard.setFont(new Font("等线", Font.PLAIN, 17));
		lbChooseCard.setBounds(23, 10, 237, 16);
		contentPane.add(lbChooseCard);
		
	}

	private void contantPane2Init() {
		contentPane2 = new JPanel();
		contentPane2.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane2.setLayout(null);
	}

	private void signFrameInit() {
		setResizable(false);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 600, 326);
		setContentPane(contentPane);
	}

	private void contantPaneInit() {
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(null);
	}

	private void signFrameEventsRegister(MainFrame main) {
		addWindowListener(new CloseFrameWindowAdapter(name));
	}

	public void rand() {
		friendlyFrame();
		truelyRand();
		changeFrame();
	}
	
	private void truelyRand() {
		Random rand=new Random(System.currentTimeMillis());
		int i=rand.nextInt(78)+1;
		i%=5;
		todayLuck=new StringBuffer(fullStar);
		for(int j=0;j<=i;++j) {
			todayLuck.append(fullStar);
		}
		for(int j=0;j<4-i;++j) {
			todayLuck.append(nullStar);
		}
		i2=rand.nextInt(99);
		i3=rand.nextInt(9);
		if(i2>=0&&i2<=20) {
			i2=0;
			i3=0;
		}else  if(i2>=21&&i2<=40){
			i2=100;
			i3=0;
		}
		i4=rand.nextInt(60)+20;
	}

	private void friendlyFrame() {
		LoadingPanel glasspane = new LoadingPanel();
        glasspane.setBounds(0,0,600,250);
		setGlassPane(glasspane);
        glasspane.setText("少女祈祷中...");
        glasspane.setFont(new Font("等线", Font.PLAIN, 17));
        glasspane.start();
        new Thread(){ 
        		@Override
        		public void run() {
        			try {
						sleep(1000);
					} catch (InterruptedException e) {
						Main.error(e);
					}
        			glasspane.stop();
        			contentPane2.setVisible(true);
        		}
        }.start();
	}
	
	private void changeFrame() {
		contentPane.setVisible(false);
		setContentPane(contentPane2);
		contentPane2.setVisible(false);
		lbToday = new JLabel("今日运势："+todayLuck.toString()+"   今日人品值："+i2+"."+i3+"    刷题AC率:"+i4+"%",JLabel.CENTER);
		lbToday.setFont(new Font("等线", Font.PLAIN, 17));
		lbToday.setBounds(23, 12, 546, 16);
		contentPane2.add(lbToday);
		
		lbSign = new JLabel("你已经连续签到了"+days+"天，继续保持哦~");
		lbSign.setFont(new Font("Dialog", Font.PLAIN, 17));
		lbSign.setBounds(23, 224, 474, 16);
		contentPane2.add(lbSign);
		
		pShould = new JPanel();
		pShould.setBounds(23, 44, 258, 161);
		contentPane2.add(pShould);
		
		pShouldNot = new JPanel();
		pShouldNot.setBounds(311, 44, 258, 161);
		contentPane2.add(pShouldNot);
		
		lbMsg = new JLabel("本打卡数据由第三方云数据计算得出，准确性不予置评...",JLabel.CENTER);
		lbMsg.setBounds(23, 252, 546, 46);
		contentPane2.add(lbMsg);
	}
}

enum ShouldDo{
	CHICKEN_DINNER,
	PRACTICE,
	CODING_REFACTOR
}

enum ShouldNotDo{
	SURF_XX_WEB,
	PRACTICE,
	SURF_B_WEB,
	GAMING
}
