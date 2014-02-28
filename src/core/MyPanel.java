package core;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.MediaTracker;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

import keys.Keys;
import util.Log;
import adapter.csv.AbstractCSVFileAdapter;
import adapter.csv.CSVButtonImageAdapter;
import adapter.csv.CSVSimpleImageAdapter;

public abstract class MyPanel extends JPanel {
	private ArrayList<ArrayList<Image>> imageList = new ArrayList<ArrayList<Image>>();
	private ArrayList<AbstractCSVFileAdapter> adapterList = new ArrayList<AbstractCSVFileAdapter>();

	public void paintComponent(Graphics g) {
		super.paintComponent(g);

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
}
