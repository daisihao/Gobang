package ui;

import java.awt.Cursor;
import java.awt.Image;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
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
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JProgressBar;

public class MyJFrame extends JFrame{
	static JComponent layeredPane = null;

	static Icon icon1;
	static Icon icon2;
	static Icon icon3;
	static Icon icon4;
	static Icon icon5;
	static Icon icon6;
	static Icon icon7;
	static Icon icon8;
	static Icon icon9;
	static Icon icon10;


	static JLabel lblImg1;
	static JLabel lblImg2;
	static JLabel lblImg3;
	static JLabel lblImg4;
	static JLabel lblImg5;
	static JLabel lblImg6;
	static JLabel lblImg7;
	static JLabel lblImg8;
	static JLabel lblImg9;
	static JLabel lblImg10;

	
	//¹¹Ôì·½·¨
	public MyJFrame() {


		this.setTitle("»¶ÀÖÎå×ÓÆå");
		this.setSize(500, 400);

		this.addGlassPane();
		this.addContentPane();
		this.addLayeredPane();



		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		this.setResizable(false);
		this.setVisible(true);
		

	}

	
	
	
	// ²£Á§°å ÊµÏÖ¿ªÊ¼¶¯»­
	public void addGlassPane() {

		
		final JComponent comp = (JComponent) getGlassPane();
		comp.setLayout(null);
		final JProgressBar bar = new JProgressBar();
		bar.setBounds(20, 330, 450, 20);
		comp.add(bar);
		
		//±³¾°Í¼Æ¬10
		icon10=new ImageIcon(getClass().getResource("/image/blb.jpg"));
		lblImg10 = new JLabel(icon10);
		lblImg10.setSize(icon10.getIconWidth(), icon10.getIconHeight());
		comp.add(lblImg10, new Integer(Integer.MIN_VALUE));

		new Thread() {
			public void run() {
				for (int i = 0; i < 101; i++) {

					bar.setValue(i);
					try {
						Thread.sleep(10);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
				comp.setVisible(false);
			}
		}.start();

		comp.setOpaque(true);
		comp.setVisible(true);
	}

	// ²ã°å£¬ÔÙÆäÖÐÌí¼Ó±³¾°Í¼Æ¬
	public void addLayeredPane() {
		layeredPane = (JComponent) getLayeredPane();
		layeredPane.setLayout(null);

		// ±³¾°Í¼Æ¬1
		icon1 = new ImageIcon(getClass().getResource("/image/bg1.jpg"));
		lblImg1 = new JLabel(icon1);
		lblImg1.setBounds(0, 0, icon1.getIconWidth(), icon1.getIconHeight());
		layeredPane.add(lblImg1, new Integer(Integer.MIN_VALUE));

		// ±³¾°Í¼Æ¬2
		icon2 = new ImageIcon(getClass().getResource("/image/bg2.jpg"));
		lblImg2 = new JLabel(icon2);
		lblImg2.setBounds(0, 0, icon2.getIconWidth(), icon2.getIconHeight());

		// ±³¾°Í¼Æ¬3
		icon3 = new ImageIcon(getClass().getResource("/image/bg3.jpg"));
		lblImg3 = new JLabel(icon3);
		lblImg3.setBounds(0, 0, icon3.getIconWidth(), icon3.getIconHeight());

		// ±³¾°Í¼Æ¬4
		icon4 = new ImageIcon(getClass().getResource("/image/bg4.jpg"));
		lblImg4 = new JLabel(icon4);
		lblImg4.setBounds(0, 0, icon4.getIconWidth(), icon4.getIconHeight());

		// ±³¾°Í¼Æ¬5
		icon5 = new ImageIcon(getClass().getResource("/image/bg5.jpg"));
		lblImg5 = new JLabel(icon5);
		lblImg5.setBounds(0, 0, icon5.getIconWidth(), icon5.getIconHeight());

		// ±³¾°Í¼Æ¬6
		icon6 = new ImageIcon(getClass().getResource("/image/bg6.jpg"));
		lblImg6 = new JLabel(icon6);
		lblImg6.setBounds(0, 0, icon6.getIconWidth(), icon6.getIconHeight());

		// ±³¾°Í¼Æ¬7
		icon7 = new ImageIcon(getClass().getResource("/image/bg7.jpg"));
		lblImg7 = new JLabel(icon7);
		lblImg7.setBounds(0, 0, icon7.getIconWidth(), icon7.getIconHeight());

		// ±³¾°Í¼Æ¬8
		icon8 = new ImageIcon(getClass().getResource("/image/bg8.jpg"));
		lblImg8 = new JLabel(icon8);
		lblImg8.setBounds(0, 0, icon8.getIconWidth(), icon8.getIconHeight());

		// ±³¾°Í¼Æ¬9
		icon9 = new ImageIcon(getClass().getResource("/image/bg9.jpg"));
		lblImg9 = new JLabel(icon9);
		lblImg9.setBounds(0, 0, icon9.getIconWidth(), icon9.getIconHeight());

	}

	// ÄÚÈÝ°æ £¬ÔÙÆäÖÐÌí¼ÓchessBoard
	public void addContentPane() {
		JComponent contentPane = (JComponent) getContentPane();
		contentPane.add(new ChessBoard());

		contentPane.setOpaque(false);
		contentPane.setVisible(true);

	}

	
	// Ö÷·½·¨ ³ÌÐòÈë¿Ú
	public static void main(String[] args) {
		new MyJFrame();
		new Tray();
	}
}
