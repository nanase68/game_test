package core;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

import javax.swing.JPanel;

public class MainPanel extends JPanel implements MouseListener {
	// パネルサイズ
	private static final int WIDTH = 240;
	private static final int HEIGHT = 240;
	private static final int SIZE = 50;

	private ArrayList<Point> pointList = new ArrayList<Point>();

	public MainPanel() {
		// パネルの推奨サイズを設定、pack()するときに必要
		setPreferredSize(new Dimension(WIDTH, HEIGHT));
		// 変数などの初期化

		// MouseListenerを登録
		addMouseListener(this);
	}

	public void paintComponent(Graphics g) {
		super.paintComponent(g);

		// 盤面を描いたり、フィールドを描いたりする
		// pointListに入っている点の場所に点を描く
		for (int i = 0; i < pointList.size(); i++) {
			Point p = (Point) pointList.get(i);
			g.fillOval(p.x - SIZE / 2, p.y - SIZE / 2, SIZE, SIZE);
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
}