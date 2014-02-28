package core.csv;

import java.util.ArrayList;

import keys.Keys;
import util.CSVFileReader;

public abstract class AbstractCSVFileAdapter {
	protected ArrayList<ArrayList<String>> csv;

	protected void readCSV(String csvFileStr) {
		CSVFileReader reader = new CSVFileReader(Keys.csvDir + csvFileStr);
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
