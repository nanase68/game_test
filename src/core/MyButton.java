package core;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JButton;

public abstract class MyButton extends JButton implements MouseListener {

	public MyButton() {
		/* MouseListenerを登録 */
		addMouseListener(this);

	}

	/* 以下、マウス制御 */
	// マウスをクリックしたとき呼ばれる
	public void mouseClicked(MouseEvent e) {

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
