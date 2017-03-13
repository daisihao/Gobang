package ui;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JProgressBar;

public class ChessBoard extends JPanel implements MouseListener {
	int x;
	int y;
	
	int chess[][] = new int[20][20];
	int zyouxian[][] = new int[20][20];
	int youxian[][] = new int[20][20];
	
	int hqx;
	int hqy;
	int bgIndex = 1;
	int i = 1;
	int j6index;
	
	boolean canPlay = false;
	boolean isBlack = true;
	boolean winflag;
	
	MusicThread mt;

	JButton j1 = null;
	JButton j2 = null;
	JButton j3 = null;
	JButton j4 = null;
	JButton j5 = null;
	JButton j6 = null;
	JButton j7 = null;

	
	Image img1;
	Image img2;
	
	
	// 构造方法，其中有Button监听器
	public ChessBoard() {

		// 棋盘的大小
		final int WIDTH = 500;
		final int HEIGHT = 400;
		this.addMouseListener(this);
		this.setLayout(null);
		this.setOpaque(false);
		
		//加入进度条
		final JProgressBar timeBar = new JProgressBar();
		timeBar.setBounds(20, 365, 450, 10);
		this.add(timeBar);
		
/*		new Thread() {
			public void run() {
				for (int i = 0; i < 101; i++) {

					timeBar.setValue(i);
					try {
						Thread.sleep(500);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
				timeBar.setVisible(false);
			}
		}.start();*/

		// 按钮图片
		final Icon icon11 = new ImageIcon(getClass().getResource("/image/00001.png"));
		final Icon icon12 = new ImageIcon(getClass().getResource("/image/00002.png"));
		final Icon icon13 = new ImageIcon(getClass().getResource("/image/00003.png"));
		final Icon icon14 = new ImageIcon(getClass().getResource("/image/00004.png"));
		final Icon icon15 = new ImageIcon(getClass().getResource("/image/00005.png"));
		final Icon icon16 = new ImageIcon(getClass().getResource("/image/00006.png"));
		final Icon icon17 = new ImageIcon(getClass().getResource("/image/00007.png"));

		// 第一个按钮 开始游戏
		j1 = new JButton(icon11);
		j1.setOpaque(false);
		j1.setBorder(null);
		j1.setFocusPainted(false);
		j1.setContentAreaFilled(false);
		j1.setBounds(380, 10, 100, 50);
		j1.addMouseListener(new MouseListener() {
			
			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO 自动生成的方法存根
				
			}
			
			@Override
			public void mousePressed(MouseEvent e) {
				// TODO 自动生成的方法存根
				
			}
			
			@Override
			public void mouseExited(MouseEvent e) {
				j1.setIcon(icon11);
				
			}
			
			@Override
			public void mouseEntered(MouseEvent e) {
				j1.setIcon(icon17);
			
			}
			
			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO 自动生成的方法存根
				
			}
		});
		
		j1.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(j1, "现在可以开始游戏了");
				canPlay = true;
			}
		});
		this.add(j1);
		
		// 第二个按钮 悔棋
		j2 = new JButton(icon12);
		j2.setOpaque(false);
		j2.setBorder(null);
		j2.setFocusPainted(false);
		j2.setContentAreaFilled(false);
		j2.setBounds(380, 70, 100, 50);
		j2.addMouseListener(new MouseListener() {
			
			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO 自动生成的方法存根
				
			}
			
			@Override
			public void mousePressed(MouseEvent e) {
				// TODO 自动生成的方法存根
				
			}
			
			@Override
			public void mouseExited(MouseEvent e) {
				j2.setIcon(icon12);
				
			}
			
			@Override
			public void mouseEntered(MouseEvent e) {
				j2.setIcon(icon17);
				
			}
			
			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO 自动生成的方法存根
				
			}
		});
		j2.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				chess[hqx][hqy] = 0;


				repaint();
			}
		});
		this.add(j2);

		// 第三个按钮 重新开始
		j3 = new JButton(icon13);
		j3.setOpaque(false);
		j3.setBorder(null);
		j3.setFocusPainted(false);
		j3.setContentAreaFilled(false);
		j3.setBounds(380, 130, 100, 50);
		j3.addMouseListener(new MouseListener() {
			
			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO 自动生成的方法存根
				
			}
			
			@Override
			public void mousePressed(MouseEvent e) {
				// TODO 自动生成的方法存根
				
			}
			
			@Override
			public void mouseExited(MouseEvent e) {
				j3.setIcon(icon13);
				
			}
			
			@Override
			public void mouseEntered(MouseEvent e) {
				j3.setIcon(icon17);
				
			}
			
			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO 自动生成的方法存根
				
			}
		});
		j3.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				int result = JOptionPane.showConfirmDialog(j3, "是否重新开始游戏");
				if (result == 0) {
					for (int i = 0; i < 11; i++) {
						for (int j = 0; j < 11; j++) {
							chess[i][j] = 0;
						}
					}
					repaint();
					isBlack = true;
					canPlay=true;
				}
			}
		});
		this.add(j3);

		// 第四个按钮 换棋盘
		j4 = new JButton(icon14);
		j4.setOpaque(false);
		j4.setBorder(null);
		j4.setFocusPainted(false);
		j4.setContentAreaFilled(false);
		j4.setBounds(380, 250, 100, 50);
		j4.addMouseListener(new MouseListener() {
			
			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO 自动生成的方法存根
				
			}
			
			@Override
			public void mousePressed(MouseEvent e) {
				// TODO 自动生成的方法存根
				
			}
			
			@Override
			public void mouseExited(MouseEvent e) {
				j4.setIcon(icon14);
				
			}
			
			@Override
			public void mouseEntered(MouseEvent e) {
				j4.setIcon(icon17);
				
			}
			
			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO 自动生成的方法存根
				
			}
		});
		j4.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				i++;
				bgIndex++;
				if (i <= 9) {
					if (i == 2) {
						MyJFrame.layeredPane.add(MyJFrame.lblImg2, new Integer(
								Integer.MIN_VALUE + bgIndex));
						MyJFrame.layeredPane.repaint();
					}

					if (i == 3) {
						MyJFrame.layeredPane.add(MyJFrame.lblImg3, new Integer(
								Integer.MIN_VALUE + bgIndex));
						MyJFrame.layeredPane.repaint();
					}

					if (i == 4) {
						MyJFrame.layeredPane.add(MyJFrame.lblImg4, new Integer(
								Integer.MIN_VALUE + bgIndex));
						MyJFrame.layeredPane.repaint();
					}

					if (i == 5) {
						MyJFrame.layeredPane.add(MyJFrame.lblImg5, new Integer(
								Integer.MIN_VALUE + bgIndex));
						MyJFrame.layeredPane.repaint();
					}
					if (i == 6) {
						MyJFrame.layeredPane.add(MyJFrame.lblImg6, new Integer(
								Integer.MIN_VALUE + bgIndex));
						MyJFrame.layeredPane.repaint();
					}
					if (i == 7) {
						MyJFrame.layeredPane.add(MyJFrame.lblImg7, new Integer(
								Integer.MIN_VALUE + bgIndex));
						MyJFrame.layeredPane.repaint();
					}
					if (i == 8) {
						MyJFrame.layeredPane.add(MyJFrame.lblImg8, new Integer(
								Integer.MIN_VALUE + bgIndex));
						MyJFrame.layeredPane.repaint();
					}
					if (i == 9) {
						MyJFrame.layeredPane.add(MyJFrame.lblImg9, new Integer(
								Integer.MIN_VALUE + bgIndex));
						MyJFrame.layeredPane.repaint();
					}
				} else {
					i = 1;
				}

			}
		});
		this.add(j4);

		// 第五个按钮 退出按钮
		j5 = new JButton(icon15);
		j5.setOpaque(false);
		j5.setBorder(null);
		j5.setFocusPainted(false);
		j5.setContentAreaFilled(false);
		j5.setBounds(380, 310, 100, 50);
		j5.addMouseListener(new MouseListener() {
			
			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO 自动生成的方法存根
				
			}
			
			@Override
			public void mousePressed(MouseEvent e) {
				// TODO 自动生成的方法存根
				
			}
			
			@Override
			public void mouseExited(MouseEvent e) {
				j5.setIcon(icon15);
				
			}
			
			@Override
			public void mouseEntered(MouseEvent e) {
				j5.setIcon(icon17);
				
			}
			
			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO 自动生成的方法存根
				
			}
		});
		j5.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				int value = JOptionPane.showConfirmDialog(j5, "再玩会儿嘛！");
				if (value == 1) {
					System.exit(0);
				}

			}
		});
		this.add(j5);

		// 第六个按钮  音乐按钮
		j6 = new JButton(icon16);
		j6.setOpaque(false);
		j6.setBorder(null);
		j6.setFocusPainted(false);
		j6.setContentAreaFilled(false);
		j6.setBounds(380, 190, 100, 50);
		j6.addMouseListener(new MouseListener() {
			
			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO 自动生成的方法存根
				
			}
			
			@Override
			public void mousePressed(MouseEvent e) {
				// TODO 自动生成的方法存根
				
			}
			
			@Override
			public void mouseExited(MouseEvent e) {
				j6.setIcon(icon16);
				
			}
			
			@Override
			public void mouseEntered(MouseEvent e) {
				j6.setIcon(icon17);
				
			}
			
			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO 自动生成的方法存根
				
			}
		});
		j6.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {

				j6index++;
				if (j6index % 2 == 1) {
					int value = JOptionPane.showConfirmDialog(j6, "是否开启音乐");
					if (value == 0) {
						mt = new MusicThread();
						mt.start();
					}
				} else if (j6index % 2 == 0) {
					int value = JOptionPane.showConfirmDialog(j6, "是否关闭音乐");
					if (value == 0) {
						mt.suspend();
					}
				}
			}

		});
		this.add(j6);

	}

	// 画线条，初始化棋盘
	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);

		
		img1= new ImageIcon(getClass().getClassLoader().getResource("image/Black.png")).getImage();
		img2= new ImageIcon(getClass().getClassLoader().getResource("image/White.png")).getImage();

		// 绘制线条
		for (int i = 0; i <= 10; i++) {
			g.drawLine(10, 10 + 35 * i, 360, 10 + 35 * i);
			g.drawLine(10 + 35 * i, 10, 10 + 35 * i, 360);
		}

		// 初始化棋子
		for (int i = 0; i <= 10; i++) {
			for (int j = 0; j <= 10; j++) {
				if (chess[i][j] == 1) {
					int tempX = i * 35 + 10;
					int tempY = j * 35 + 10;
					g.drawImage(img1, tempX - 10, tempY - 10, this);
				}
				if (chess[i][j] == 2) {
					int tempX = i * 35 + 10;
					int tempY = j * 35 + 10;
					g.drawImage(img2, tempX - 10, tempY - 10, this);
				}

			}
		}
	}

	// 得到鼠标的位置，绘制棋子
	@Override
	public void mousePressed(MouseEvent e) {

		// 得到鼠标点击的位置，并以此为依据下棋
		x = e.getX();
		y = e.getY();
		if (canPlay) {
			if (x >= 0 && x <= 370 && y >= 0 && y <= 370) {
				x = (x - 10) / 32;
				y = (y - 10) / 32;

				hqx = x;
				hqy = y;
				if (chess[hqx][hqy] == 0) {
					if (isBlack) {
						chess[x][y] = 1;
					}
					repaint();
					winflag = this.checkWin();
					if (winflag == true) {
						JOptionPane.showMessageDialog(this, "游戏结束,"
								+ (chess[x][y] == 1 ? "黑方" : "机器人") + "胜利");
						canPlay = false;
					}

					if (canPlay) {
						this.zuiyouBaiqi();
						this.repaint();
						winflag = this.checkWin();
						if (winflag == true) {
							JOptionPane.showMessageDialog(this, "游戏结束,"
									+ (chess[x][y] == 1 ? "黑方" : "机器人") + "胜利");
							canPlay = false;
						}

					}
				} else {
					JOptionPane.showMessageDialog(this, "不能重复下棋");
				}
			} else {
				JOptionPane.showMessageDialog(this, "请在棋盘内部下棋");
			}
		}

	}

	@Override
	public void mouseClicked(MouseEvent e) {
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO 自动生成的方法存根

	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO 自动生成的方法存根

	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO 自动生成的方法存根

	}

	// 判断胜利的方法
	public boolean checkWin() {
		boolean flag = false;
		int color = chess[x][y];
		// 判断横向
		int count1 = 1;
		int i1 = 1;
		while (color == chess[x + i1][y] && (x + i1) <= 10) {
			count1++;
			i1++;
		}
		i1 = 1;
		while (color == chess[Math.abs(x - i1)][y] && (x - i1) >= 0) {
			count1++;
			i1++;
		}
		if (count1 >= 5) {
			flag = true;
		}
		// 判断纵向
		int count2 = 1;
		int i2 = 1;
		while (color == chess[x][y + i2] && (y + i2) <= 10) {
			count2++;
			i2++;
		}
		i2 = 1;
		while (color == chess[x][Math.abs(y - i2)] && (y - i2) >= 0) {
			count2++;
			i2++;
		}
		if (count2 >= 5) {
			flag = true;
		}
		// 判断斜向上方向
		int count3 = 1;
		int i3 = 1;
		while (color == chess[x + i3][Math.abs(y - i3)] && (x + i3) <= 10
				&& (y - i3) >= 0) {
			count3++;
			i3++;
		}
		i3 = 1;
		while (color == chess[Math.abs(x - i3)][y + i3] && (y + i3) <= 10
				&& (x - i3) >= 0) {
			count3++;
			i3++;
		}
		if (count3 >= 5) {
			flag = true;
		}
		// 判断斜向下方向
		int count4 = 1;
		int i4 = 1;
		while (color == chess[x + i4][y + i4] && (x + i4) <= 10
				&& (y + i4) <= 10) {
			count4++;
			i4++;
		}
		i4 = 1;
		while (color == chess[Math.abs(x - i4)][Math.abs(y - i4)]
				&& (x - i4) >= 0 && (y - i4) >= 0) {
			count4++;
			i4++;
		}
		if (count4 >= 5) {
			flag = true;
		}
		return flag;
	}

	// 智能AI
	public void zuiyouBaiqi() {
		int jishu = 0;
		int pdflage = 0;
		int i3 = 0;
		boolean m = false;
		for (int i = 2; i < 9; i++) {
			for (int j = 2; j < 9; j++) {
				if (chess[i][j] == 0) {
					int count1 = 0, count2 = 0, count3 = 0, count4 = 0, count5 = 0, count6 = 0, count7 = 0, count8 = 0;
					int color = 1;

					int i1 = 1;
					while (chess[i + i1][j] == color && (x + i1) < 11) {
						count1++;
						i1++;
					}

					i1 = 1;
					while (chess[i - i1][j] == color && (x - i1) >= 0) {
						count2++;
						i1++;
					}

					i1 = 1;
					while (chess[i][j + i1] == color && (j + i1) < 11) {
						count3++;
						i1++;
					}

					i1 = 1;
					while (chess[i][j - i1] == color && (j - i1) > 0) {
						count4++;
						i1++;
					}

					i1 = 1;
					while (chess[i + i1][j - i1] == color && (j - i1) > 0
							&& (i + i1) < 11) {
						count5++;
						i1++;
					}

					i1 = 1;
					while (chess[i - i1][j + i1] == color && (x - i1) > 0
							&& (j + i1) < 11) {
						count6++;
						i1++;
					}

					i1 = 1;
					while (chess[i + i1][j + i1] == color && (x + i1) < 11
							&& (j + i1) < 11) {
						count7++;
						i1++;
					}

					i1 = 1;
					while (chess[i - i1][j - i1] == color && (x - i1) > 0
							&& (j - i1) > 0) {
						count8++;
						i1++;
					}

					if (count1 >= 1) {
						jishu++;
					}

					if (count2 >= 1) {
						jishu++;
					}

					if (count3 >= 1) {
						jishu++;
					}

					if (count4 >= 1) {
						jishu++;
					}

					if (count5 >= 1) {
						jishu++;
					}

					if (count6 >= 1) {
						jishu++;
					}

					if (count7 >= 1) {
						jishu++;
					}

					if (count8 >= 1) {
						jishu++;
					}

					if (count1 >= 2 || count2 >= 2 || count3 >= 2
							|| count4 >= 2 || count5 >= 2 || count6 >= 2
							|| count7 >= 2 || count8 >= 2) {
						pdflage++;
					} else {
						zyouxian[i][j] = 0;
					}

					if (count1 == 2 || count2 == 2 || count3 == 2
							|| count4 == 2 || count5 == 2 || count6 == 2
							|| count7 == 2 || count8 == 2) {
						zyouxian[i][j] = 2;
					}

					if (count1 == 3 || count2 == 3 || count3 == 3
							|| count4 == 3 || count5 == 3 || count6 == 3
							|| count7 == 3 || count8 == 3) {
						zyouxian[i][j] = 3;
					}

					if (count1 == 4 || count2 == 4 || count3 == 4
							|| count4 == 4 || count5 == 4 || count6 == 4
							|| count7 == 4 || count8 == 4) {
						zyouxian[i][j] = 4;
					}

					youxian[i][j] = jishu;
					jishu = 0;
				} else {
					youxian[i][j] = -1;
				}
			}
		}
		if (pdflage > 0) {
			if (m == false) {
				a2: for (i3 = 0; i3 < 11; i3++) {
					for (int j4 = 0; j4 < 11; j4++) {
						if (zyouxian[i3][j4] == 4 && chess[i3][j4] == 0) {
							chess[i3][j4] = 2;
							m = true;
							x = i3;
							y = j4;
							break a2;
						}
					}
				}
			}
			if (m == false) {
				a3: for (i3 = 0; i3 < 11; i3++) {
					for (int j4 = 0; j4 < 11; j4++) {
						if (zyouxian[i3][j4] == 3 && chess[i3][j4] == 0) {
							chess[i3][j4] = 2;
							m = true;
							x = i3;
							y = j4;
							break a3;
						}

					}
				}
			}
			if (m == false) {
				a1: for (i3 = 0; i3 < 11; i3++) {
					for (int j4 = 0; j4 < 11; j4++) {
						if (zyouxian[i3][j4] == 2 && chess[i3][j4] == 0) {
							chess[i3][j4] = 2;
							m = true;
							x = i3;
							y = j4;
							break a1;
						}
					}

				}
			}
		} else {
			if (m == false) {
				b1: for (i3 = 0; i3 < 11; i3++) {
					for (int j3 = 0; j3 < 11; j3++) {
						if (youxian[i3][j3] == 8) {
							chess[i3][j3] = 2;
							m = true;
							x = i3;
							y = j3;
							break b1;
						}
					}
				}

			}

			if (m == false) {
				b2: for (i3 = 0; i3 < 11; i3++) {
					for (int j3 = 0; j3 < 11; j3++) {
						if (youxian[i3][j3] == 7) {
							chess[i3][j3] = 2;
							m = true;
							x = i3;
							y = j3;
							break b2;
						}
					}
				}
			}

			if (m == false) {
				b3: for (i3 = 0; i3 < 11; i3++) {
					for (int j3 = 0; j3 < 11; j3++) {
						if (youxian[i3][j3] == 6) {
							chess[i3][j3] = 2;
							m = true;
							x = i3;
							y = j3;
							break b3;

						}
					}

				}

			}
			if (m == false) {
				b4: for (i3 = 0; i3 < 11; i3++) {
					for (int j3 = 0; j3 < 11; j3++) {
						if (youxian[i3][j3] == 5) {
							chess[i3][j3] = 2;
							m = true;
							x = i3;
							y = j3;
							break b4;
						}

					}

				}

			}
			if (m == false) {
				b5: for (i3 = 0; i3 < 11; i3++) {
					for (int j3 = 0; j3 < 11; j3++) {
						if (youxian[i3][j3] == 4) {
							chess[i3][j3] = 2;
							m = true;
							x = i3;
							y = j3;
							break b5;
						}

					}

				}

			}
			if (m == false) {
				b6: for (i3 = 0; i3 < 11; i3++) {
					for (int j3 = 0; j3 < 11; j3++) {
						if (youxian[i3][j3] == 3) {
							chess[i3][j3] = 2;
							m = true;
							x = i3;
							y = j3;
							break b6;
						}
					}
				}
			}
			if (m == false) {
				b7: for (i3 = 0; i3 < 11; i3++) {
					for (int j3 = 0; j3 < 11; j3++) {
						if (youxian[i3][j3] == 2) {
							chess[i3][j3] = 2;
							m = true;
							x = i3;
							y = j3;
							break b7;
						}
					}

				}
			}
			if (m == false) {
				b8: for (i3 = 0; i3 < 11; i3++) {
					for (int j3 = 0; j3 < 11; j3++) {
						if (youxian[i3][j3] == 1) {
							chess[i3][j3] = 2;
							m = true;
							x = i3;
							y = j3;
							break b8;
						}
					}
				}
			}
			if (m == false) {
				b9: for (i3 = 0; i3 < 11; i3++) {
					for (int j3 = 0; j3 < 11; j3++) {
						if (youxian[i3][j3] == 0) {
							chess[i3][j3] = 2;
							m = true;
							x = i3;
							y = j3;
							break b9;
						}
					}
				}
			}
		}
	}

}
