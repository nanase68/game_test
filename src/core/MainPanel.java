package core;

import java.awt.Dimension;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import keys.Keys;

public class MainPanel extends MyPanel implements KeyListener {
	public MainPanel() {
		// パネルの推奨サイズを設定、pack()するときに必要
		setPreferredSize(new Dimension(Keys.WINDOW_WIDTH, Keys.WINDOW_HEIGHT));

		/* KeyListenerを登録 */
		// パネルがキーボードを受け付けるようにする（必須）
		setFocusable(true);
		// キーリスナーを登録（忘れやすい）
		addKeyListener(this);

		allLoadImage("simple", "image.csv");
		allLoadImage("button", "image.csv");
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