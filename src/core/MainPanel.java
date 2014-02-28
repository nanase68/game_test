package core;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import keys.Keys;
import panel.csv.CSVPanel;

public class MainPanel extends MyPanel implements KeyListener {
	public MainPanel() {
		super();
		// パネルの推奨サイズを設定、pack()するときに必要
		setPreferredSize(new Dimension(Keys.WINDOW_WIDTH, Keys.WINDOW_HEIGHT));

		/* KeyListenerを登録 */
		// パネルがキーボードを受け付けるようにする（必須）
		setFocusable(true);
		// キーリスナーを登録（忘れやすい）
		addKeyListener(this);

		CSVPanel panel = new CSVPanel();
		panel.allLoadImage("simple", "image.csv");
		setComponent(panel, 100, 0);
		repaint();
		// allLoadImage("simple", "image.csv");
		// allLoadImage("button", "image.csv");
	}

	public void paintComponent(Graphics g) {
		super.paintComponent(g);

		g.setColor(Color.red);
		g.fillRect(10, 10, 100, 100);
	}

	/* 以下、キーボード制御 */
	/**
	 * キーがタイプされたとき呼ばれる。 文字入力を検知したい場合はこっちを使う。
	 */
	public void keyTyped(KeyEvent e) {
	}

	/**
	 * キーが押されたとき呼ばれる。 ゲームではたいていはこっちを使う。
	 */
	public void keyPressed(KeyEvent e) {
	}

	/**
	 * キーが離されたとき呼ばれる。
	 */
	public void keyReleased(KeyEvent e) {
	}
}