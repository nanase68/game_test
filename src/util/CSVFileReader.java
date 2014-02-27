package util;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class CSVFileReader {
	private String csvFile;
	private ArrayList<ArrayList<String>> csv = new ArrayList<ArrayList<String>>();

	public CSVFileReader(String csvFile) {
		this.csvFile = csvFile;
	}

	public ArrayList<ArrayList<String>> readCSV() {

		try {
			// ファイルを読み込む
			FileReader fr = new FileReader(csvFile);
			BufferedReader br = new BufferedReader(fr);

			// 読み込んだファイルを１行ずつ処理する
			String line;
			StringTokenizer token;

			Boolean firstFlag = true;
			while ((line = br.readLine()) != null) {
				// 区切り文字","で分割する
				token = new StringTokenizer(line, ",");

				// ２次元ArrayListに保存
				int i = 0;
				while (token.hasMoreTokens()) {
					if (firstFlag) {
						csv.add(new ArrayList<String>());
					}
					csv.get(i).add(token.nextToken());

					i++;
				}

				firstFlag = false;
			}

			// 終了処理
			br.close();

			return csv;
		} catch (IOException ex) {
			// 例外発生時処理
			ex.printStackTrace();
			return null;
		}
	}

}
