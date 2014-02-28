package core;

import java.awt.Container;

import javax.swing.JFrame;

public class MainFrame extends JFrame {
	public MainFrame() {
		// タイトルを設定
		setTitle("Hello Worldを表示する");

		// メインパネルを作成してフレームに追加
		MainPanel panel = new MainPanel();
		Container contentPane = getContentPane();
		contentPane.add(panel);

		// パネルサイズに合わせてフレームサイズを自動設定
		pack();
	}

	public static void main(String[] args) {
		MainFrame frame = new MainFrame();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
	}
}