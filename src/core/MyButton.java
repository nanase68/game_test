package core;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.Icon;
import javax.swing.JButton;

import logic.LogicAdapter;

public class MyButton extends JButton implements MouseListener {

	public MyButton(Icon icon, int x, int y, String name) {
		super(icon);
		setSize(x, y);
		setName(name);
		setBorderPainted(false);

		/* MouseListenerを登録 */
		addMouseListener(this);
	}

	public MyButton(Icon icon, int x, int y) {
		this(icon, x, y, "");
	}

	/* 以下、マウス制御 */
	// マウスをクリックしたとき呼ばれる
	public void mouseClicked(MouseEvent e) {
		LogicAdapter.actionMouseClicked(this);
		repaint();
	}

	// マウスがウィンドウ内に入ったとき呼ばれる
	public void mouseEntered(MouseEvent e) {
		LogicAdapter.actionMouseEntered(this);
		repaint();
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
