package core;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;

import logic.LogicManager;

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

	public MyButton(String pass, String name) {
		super();
		changeIcon(pass);
		setName(name);
		setBorderPainted(false);

		/* MouseListenerを登録 */
		addMouseListener(this);
	}

	public void changeIcon(String pass) {
		ImageIcon icon = new ImageIcon(getClass().getClassLoader().getResource(pass));
		setIcon(icon);
		int width = icon.getIconWidth();
		int height = icon.getIconHeight();
		setSize(width, height);
	}

	/* 以下、マウス制御 */
	// マウスをクリックしたとき呼ばれる
	public void mouseClicked(MouseEvent e) {
		LogicManager.actionMouseClicked(this);
		repaint();
	}

	// マウスがウィンドウ内に入ったとき呼ばれる
	public void mouseEntered(MouseEvent e) {
		LogicManager.actionMouseEntered(this);
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
