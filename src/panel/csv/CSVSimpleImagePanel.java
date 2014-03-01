package panel.csv;

import java.awt.Graphics;
import java.awt.Image;
import java.util.ArrayList;

import keys.Keys;
import util.Log;
import adapter.csv.AbstractCSVFileAdapter;
import adapter.csv.CSVButtonImageAdapter;
import adapter.csv.CSVSimpleImageAdapter;
import core.MyPanel;

public class CSVSimpleImagePanel extends MyPanel {
	private ArrayList<ArrayList<Image>> imageList = new ArrayList<ArrayList<Image>>();
	private ArrayList<AbstractCSVFileAdapter> adapterList = new ArrayList<AbstractCSVFileAdapter>();

	public CSVSimpleImagePanel(int width, int height) {
		super(width, height);

	}

	@Override
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
			Image image = loadImage(Keys.IMAGE_DIR + adapter.getFilename().get(i));
			childImageList.add(image);
		}
	}
}
