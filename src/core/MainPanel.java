package core;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.MediaTracker;
import java.awt.Point;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

public class MainPanel extends JPanel implements MouseListener, KeyListener {
	// パネルサイズ
	private static final int WIDTH = 240;
	private static final int HEIGHT = 240;
	private static final int SIZE = 50;

	private ArrayList<Point> pointList = new ArrayList<Point>();
	private ArrayList<Image> imageList = new ArrayList<Image>();

	public Image image;

	public MainPanel() {
		// パネルの推奨サイズを設定、pack()するときに必要
		setPreferredSize(new Dimension(WIDTH, HEIGHT));
		// 変数などの初期化

		/* MouseListenerを登録 */
		addMouseListener(this);

		/* KeyListenerを登録 */
		// パネルがキーボードを受け付けるようにする（必須）
		setFocusable(true);
		// キーリスナーを登録（忘れやすい）
		addKeyListener(this);

		// loadImage("resource/image/reimu001-2.png");
		loadImage("reimu001-2.png");
	}

	public void paintComponent(Graphics g) {
		super.paintComponent(g);

		// 盤面を描いたり、フィールドを描いたりする
		// pointListに入っている点の場所に点を描く
		for (int i = 0; i < pointList.size(); i++) {
			Point p = (Point) pointList.get(i);
			g.fillOval(p.x - SIZE / 2, p.y - SIZE / 2, SIZE, SIZE);
		}

		for (int i = 0; i < imageList.size(); i++) {
			Image img = (Image) imageList.get(i);
			g.drawImage(img, 0, 0, this);
		}
	}

	/**
	 * イメージをロードする
	 */
	public void loadImage(String pass) {
		// プレイヤーのイメージを読み込む
		// ImageIconを使うとMediaTrackerを使わなくてすむ
		ImageIcon icon = new ImageIcon(getClass().getResource(pass));
		image = icon.getImage();

		// MediaTrackerに登録
		MediaTracker tracker = new MediaTracker(this);
		tracker.addImage(image, 0);

		// イメージ読み込み完了まで待機
		try {
			tracker.waitForID(0);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		imageList.add(image);
	}

	/* 以下、マウス制御 */
	// マウスをクリックしたとき呼ばれる
	public void mouseClicked(MouseEvent e) {
		// クリックした座標を得る
		int x = e.getX();
		int y = e.getY();
		// pointListに登録
		pointList.add(new Point(x, y));

		repaint();
	}

	// マウスがウィンドウ内に入ったとき呼ばれる
	public void mouseEntered(MouseEvent e) {
	}

	// マウスがウィンドウ外に出たとき呼ばれる
	public void mouseExited(MouseEvent e) {
	}

	// マウスボタンが押されたとき呼ばれる
	public void mousePressed(MouseEvent e) {
	}

	// マウスボタンが離されたとき呼ばれる
	public void mouseReleased(MouseEvent e) {
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