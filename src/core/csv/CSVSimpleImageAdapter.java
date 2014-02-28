package core.csv;

import java.util.ArrayList;

public class CSVSimpleImageAdapter extends AbstractCSVFileAdapter {
	private ArrayList<Integer> positionX = new ArrayList<Integer>();
	private ArrayList<Integer> positionY = new ArrayList<Integer>();

	public CSVSimpleImageAdapter(String csvFileStr) {
		readCSV(csvFileStr);

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
