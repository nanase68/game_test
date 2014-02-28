package panel.csv;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.util.ArrayList;

import keys.Keys;
import util.Log;
import adapter.csv.AbstractCSVFileAdapter;
import adapter.csv.CSVButtonImageAdapter;
import adapter.csv.CSVSimpleImageAdapter;
import core.MyPanel;

public class CSVPanel extends MyPanel {
	private ArrayList<ArrayList<Image>> imageList = new ArrayList<ArrayList<Image>>();
	private ArrayList<AbstractCSVFileAdapter> adapterList = new ArrayList<AbstractCSVFileAdapter>();

	public CSVPanel() {
		super();

		setSize(new Dimension(Keys.WINDOW_WIDTH, Keys.WINDOW_HEIGHT));
	}

	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);

		g.setColor(Color.blue);
		g.fillRect(10, 10, 100, 100);

		for (int i = 0; i < adapterList.size(); i++) {
			AbstractCSVFileAdapter adapter = adapterList.get(i);

			ArrayList<Image> childImageList = imageList.get(i);
			for (int ii = 0; ii < childImageList.size(); ii++) {
				Image img = (Image) childImageList.get(ii);
				g.drawImage(img, adapter.getPositionX().get(ii), adapter.getPositionY().get(ii), this);

				Log.d("set:" + img + "\tto x:" + adapter.getPositionX().get(ii) + "\ty:"
						+ adapter.getPositionY().get(ii));
			}
		}
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

		Log.d("allLoadImage:" + "\tmode:" + mode + "\tcsvFileStr:" + csvFileStr);

		adapterList.add(adapter);
		ArrayList<Image> childImageList = new ArrayList<Image>();
		imageList.add(childImageList);

		for (int i = 0; i < adapter.getFilename().size(); i++) {
			loadImage(Keys.IMAGE_DIR + adapter.getFilename().get(i), childImageList);
		}

		repaint();
	}
}
