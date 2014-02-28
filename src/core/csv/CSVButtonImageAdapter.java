package core.csv;

import java.util.ArrayList;

import keys.Keys;

public class CSVButtonImageAdapter extends AbstractCSVFileAdapter {
	public CSVButtonImageAdapter(String csvFileStr) {
		readCSV(Keys.CSV_BUTTON_IMAGE_DIR + csvFileStr);

		ArrayStringToInteger(csv.get(1), positionX);
		ArrayStringToInteger(csv.get(2), positionY);
	}

	public ArrayList<String> getFilename() {
		return csv.get(0); // csvの0項目はファイルの名前
	}

	public ArrayList<Integer> getPositionX() {
		return positionX;
	}

	public ArrayList<Integer> getPositionY() {
		return positionY;
	}
}
