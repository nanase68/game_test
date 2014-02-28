package core;

import java.awt.Component;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.MediaTracker;
import java.util.ArrayList;

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
	public void loadImage(String pass, ArrayList<Image> childImageList) {
		// プレイヤーのイメージを読み込む
		// ImageIconを使うとMediaTrackerを使わなくてすむ
		ImageIcon icon = new ImageIcon(getClass().getClassLoader().getResource(pass));
		Image image = icon.getImage();

		// MediaTrackerに登録
		MediaTracker tracker = new MediaTracker(this);
		tracker.addImage(image, 0);

		// イメージ読み込み完了まで待機
		try {
			tracker.waitForID(0);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		childImageList.add(image);
	}

	/*
	 * コンポーネント c を 座標 (x, y) に配置する
	 */
	public void setComponent(Component c, int x, int y) {
		c.setBounds(x, y, c.getWidth(), c.getHeight());
		add(c);
	}
}
