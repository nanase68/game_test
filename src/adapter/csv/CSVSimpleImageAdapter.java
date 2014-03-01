package adapter.csv;

import java.util.ArrayList;

import keys.Keys;

public class CSVSimpleImageAdapter extends AbstractCSVFileAdapter {
	public CSVSimpleImageAdapter(String csvFileStr) {
		readCSV(Keys.CSV_SIMPLE_IMAGE_DIR + csvFileStr);

		ArrayStringToInteger(csv.get(1), positionX);
		ArrayStringToInteger(csv.get(2), positionY);
	}

	@Override
	public ArrayList<String> getFilenameList() {
		return csv.get(0); // csvの0項目はファイルの名前
	}

	@Override
	public ArrayList<Integer> getPositionXList() {
		return positionX;
	}

	@Override
	public ArrayList<Integer> getPositionYList() {
		return positionY;
	}
}
