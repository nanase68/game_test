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

import panels.csv.AbstractCSVFileAdapter;
import panels.csv.CSVButtonImageAdapter;
import panels.csv.CSVSimpleImageAdapter;

import keys.Keys;
import util.Log;

public class MainPanel extends JPanel implements MouseListener, KeyListener {

	// テスト用円の半径？
	private static final int SIZE = 50;

	private ArrayList<Point> pointList = new ArrayList<Point>();
	private ArrayList<ArrayList<Image>> imageList = new ArrayList<ArrayList<Image>>();
	private ArrayList<AbstractCSVFileAdapter> adapterList = new ArrayList<AbstractCSVFileAdapter>();

	public MainPanel() {
		// パネルの推奨サイズを設定、pack()するときに必要
		setPreferredSize(new Dimension(Keys.WINDOW_WIDTH, Keys.WINDOW_HEIGHT));
		// 変数などの初期化

		/* MouseListenerを登録 */
		addMouseListener(this);

		/* KeyListenerを登録 */
		// パネルがキーボードを受け付けるようにする（必須）
		setFocusable(true);
		// キーリスナーを登録（忘れやすい）
		addKeyListener(this);

		allLoadImage("simple", "image.csv");
		allLoadImage("button", "image.csv");
	}

	public void paintComponent(Graphics g) {
		super.paintComponent(g);

		// 盤面を描いたり、フィールドを描いたりする
		// pointListに入っている点の場所に点を描く
		for (int i = 0; i < pointList.size(); i++) {
			Point p = (Point) pointList.get(i);
			g.fillOval(p.x - SIZE / 2, p.y - SIZE / 2, SIZE, SIZE);
		}

		for (int i = 0; i < adapterList.size(); i++) {
			AbstractCSVFileAdapter adapter = adapterList.get(i);
			ArrayList<Image> childImageList = imageList.get(i);
			for (int ii = 0; ii < childImageList.size(); ii++) {
				Image img = (Image) childImageList.get(ii);
				g.drawImage(img, adapter.getPositionX().get(ii), adapter.getPositionY().get(ii), this);
			}
		}
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

	public void allLoadImage(String mode, String csvFileStr) {
		AbstractCSVFileAdapter adapter;
		if (mode.equals("simple")) {
			adapter = new CSVSimpleImageAdapter(csvFileStr);
		} else if (mode.equals("button")) {
			adapter = new CSVButtonImageAdapter(csvFileStr);
		} else {
			adapter = null;
			Log.f("知らないAdapterです。");
		}

		adapterList.add(adapter);
		ArrayList<Image> childImageList = new ArrayList<Image>();
		imageList.add(childImageList);

		for (int i = 0; i < adapter.getFilename().size(); i++) {
			loadImage(Keys.IMAGE_DIR + adapter.getFilename().get(i), childImageList);
		}
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