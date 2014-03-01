package core;

import java.awt.Component;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

public abstract class MyPanel extends JPanel {
	public MyPanel(int width, int height) {
		// 絶対座標配置
		setLayout(null);
		setSize(new Dimension(width, height));

	}

	public void paintComponent(Graphics g) {
		super.paintComponent(g);
	}

	/**
	 * イメージをロードする
	 */
	public Image loadImage(String pass) {
		// イメージを読み込む
		// ImageIconを使うとMediaTrackerを使わなくてすむ
		ImageIcon icon = loadIcon(pass);
		Image image = icon.getImage();

		return image;
	}

	public ImageIcon loadIcon(String pass) {
		return new ImageIcon(getClass().getClassLoader().getResource(pass));
	}

	/*
	 * コンポーネント c を 座標 (x, y) に配置する
	 */
	public void setComponent(Component c, int x, int y) {
		c.setBounds(x, y, c.getWidth(), c.getHeight());
		add(c);
	}
}
