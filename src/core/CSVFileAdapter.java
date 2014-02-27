package core;

import java.util.ArrayList;

import util.CSVFileReader;

public class CSVFileAdapter {
	private String csvPass = "data/csv/";
	private ArrayList<ArrayList<String>> csv;
	private ArrayList<Integer> positionX = new ArrayList<Integer>();
	private ArrayList<Integer> positionY = new ArrayList<Integer>();

	public CSVFileAdapter(String csvFileStr) {
		CSVFileReader reader = new CSVFileReader(csvPass + csvFileStr);
		csv = reader.readCSV();

		ArrayStringToInteger(csv.get(1), positionX);
		ArrayStringToInteger(csv.get(2), positionY);

	}

	public void ArrayStringToInteger(ArrayList<String> arrayStr, ArrayList<Integer> arrayInt) {
		try {
			for (int i = 0; i < arrayStr.size(); i++) {
				arrayInt.add(Integer.parseInt(arrayStr.get(i)));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
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
