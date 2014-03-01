package panel.csv;

import java.awt.Graphics;
import java.awt.Image;
import java.util.ArrayList;

import keys.Keys;
import adapter.csv.AbstractCSVFileAdapter;
import adapter.csv.CSVButtonImageAdapter;
import adapter.csv.CSVSimpleImageAdapter;
import core.MyButton;
import core.MyPanel;

public class CSVButtonImagePanel extends MyPanel {
	private ArrayList<ArrayList<Image>> imageList = new ArrayList<ArrayList<Image>>();
	private ArrayList<CSVSimpleImageAdapter> simpleImageAdapterList = new ArrayList<CSVSimpleImageAdapter>();
	private ArrayList<ArrayList<MyButton>> buttonList = new ArrayList<ArrayList<MyButton>>();
	private ArrayList<CSVButtonImageAdapter> buttonImageAdapterList = new ArrayList<CSVButtonImageAdapter>();

	public CSVButtonImagePanel(int width, int height) {
		super(width, height);

	}

	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);

		for (int i = 0; i < simpleImageAdapterList.size(); i++) {
			AbstractCSVFileAdapter adapter = simpleImageAdapterList.get(i);

			ArrayList<Image> childImageList = imageList.get(i);
			for (int ii = 0; ii < childImageList.size(); ii++) {
				Image img = (Image) childImageList.get(ii);
				g.drawImage(img, adapter.getPositionXList().get(ii), adapter.getPositionYList().get(ii), this);
			}
		}
	}

	public void allLoadSimpleImage(String csvFileStr) {
		CSVSimpleImageAdapter adapter;

		adapter = new CSVSimpleImageAdapter(csvFileStr);
		simpleImageAdapterList.add(adapter);

		ArrayList<Image> childImageList = new ArrayList<Image>();
		imageList.add(childImageList);

		for (int i = 0; i < adapter.getFilenameList().size(); i++) {
			Image image = loadImage(Keys.IMAGE_DIR + adapter.getFilenameList().get(i));
			childImageList.add(image);
		}
	}

	public void allLoadButtonImage(String csvFileStr) {
		CSVButtonImageAdapter adapter;

		adapter = new CSVButtonImageAdapter(csvFileStr);
		buttonImageAdapterList.add(adapter);

		ArrayList<MyButton> childButtonList = new ArrayList<MyButton>();
		buttonList.add(childButtonList);

		// ボタンをnewしてArrayListに詰める
		for (int i = 0; i < adapter.getFilenameList().size(); i++) {
			String buttonName = adapter.getButtonNameList().get(i);
			MyButton button = new MyButton(adapter.getFilenameList().get(i), buttonName);

			// ボタンをパネルにセット
			childButtonList.add(button);
			int x = adapter.getPositionXList().get(i);
			int y = adapter.getPositionYList().get(i);
			setComponent(button, x, y);
		}
	}

}
