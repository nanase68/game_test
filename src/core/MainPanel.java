package core;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import keys.Keys;
import panel.csv.CSVButtonImagePanel;

public class MainPanel extends MyPanel implements KeyListener {
	public MainPanel(int width, int height) {
		super(width, height);
		// パネルの推奨サイズを設定、pack()するときに必要
		setPreferredSize(new Dimension(Keys.WINDOW_WIDTH, Keys.WINDOW_HEIGHT));

		/* KeyListenerを登録 */
		// パネルがキーボードを受け付けるようにする（必須）
		setFocusable(true);
		// キーリスナーを登録（忘れやすい）
		addKeyListener(this);

		// パネル表示テスト
		CSVButtonImagePanel panel = new CSVButtonImagePanel(400, 300);
		panel.allLoadSimpleImage("image.csv");
		setComponent(panel, 0, 0);

		CSVButtonImagePanel panel2 = new CSVButtonImagePanel(400, 300);
		panel2.allLoadButtonImage("image.csv");
		setComponent(panel2, 0, 300);
	}

	public void paintComponent(Graphics g) {
		super.paintComponent(g);

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