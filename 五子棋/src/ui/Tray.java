package ui;

import java.awt.AWTException;
import java.awt.Image;
import java.awt.MenuItem;
import java.awt.PopupMenu;
import java.awt.SystemTray;
import java.awt.TrayIcon;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

public class Tray implements ActionListener {
	private SystemTray tray;
	private Image image;
	private PopupMenu popup = new PopupMenu();

	public Tray() {
		tray = SystemTray.getSystemTray();

		image = new ImageIcon(getClass().getClassLoader().getResource("image/Trayicon.png")).getImage();

		MenuItem exit = new MenuItem("退出游戏");
		popup.add(exit);
		exit.addActionListener(this);
		try {
			tray.add(new TrayIcon(image, "五子棋", popup));
		} catch (AWTException e) {
			e.printStackTrace();
		}
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		int value=JOptionPane.showConfirmDialog(null, "您确认退出游戏么？");
		if(value==0){
		System.exit(0);
		}
	}
}
