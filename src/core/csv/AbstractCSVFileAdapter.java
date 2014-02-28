package core.csv;

import java.util.ArrayList;

import util.CSVFileReader;

public abstract class AbstractCSVFileAdapter {
	protected ArrayList<ArrayList<String>> csv;
	protected ArrayList<Integer> positionX = new ArrayList<Integer>();
	protected ArrayList<Integer> positionY = new ArrayList<Integer>();

	protected void readCSV(String csvFileFullPass) {
		CSVFileReader reader = new CSVFileReader(csvFileFullPass);
		csv = reader.readCSV();
	}

	protected void ArrayStringToInteger(ArrayList<String> arrayStr, ArrayList<Integer> arrayInt) {
		try {
			for (int i = 0; i < arrayStr.size(); i++) {
				arrayInt.add(Integer.parseInt(arrayStr.get(i)));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
