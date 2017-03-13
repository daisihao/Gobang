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

		MenuItem exit = new MenuItem("�˳���Ϸ");
		popup.add(exit);
		exit.addActionListener(this);
		try {
			tray.add(new TrayIcon(image, "������", popup));
		} catch (AWTException e) {
			e.printStackTrace();
		}
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		int value=JOptionPane.showConfirmDialog(null, "��ȷ���˳���Ϸô��");
		if(value==0){
		System.exit(0);
		}
	}
}
