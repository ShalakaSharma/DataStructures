package FileHandling;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class FileHandling {

	public void readFileStream(String fileName) throws IOException {

		File file = new File(fileName);

		FileInputStream fin = null;

		try {

			fin = new FileInputStream(file);

			int c;

			while ((c = fin.read()) != -1) {
				System.out.print((char) c);
			}
			System.out.println();

		} finally {
			if (fin != null) {
				fin.close();
			}
		}

	}

	public void writeFileStream(String fileName, String content)
			throws IOException {

		File file = new File(fileName);

		FileOutputStream fo = null;
		try {

			fo = new FileOutputStream(file);

			for (int i = 0; i < content.length(); i++) {
				int c = content.charAt(i);
				fo.write(c);
			}
		} finally {
			if (fo != null) {
				fo.close();
			}
		}
	}

	public void readFileLineByLine(String fileName) throws IOException {

		File file = new File(fileName);

		FileReader fileReader = null;
		BufferedReader bufferedReader = null;

		try {
			fileReader = new FileReader(file);
			bufferedReader = new BufferedReader(fileReader);
			String s = "";
			while ((s = bufferedReader.readLine()) != null) {
				System.out.println(s);
			}
		} finally {
			if (fileReader != null) {
				fileReader.close();
			}
		}
	}

	public void writeFileLineByLine(String fileName, String content)
			throws IOException {

		File file = new File(fileName);

		FileWriter fileWriter = null;
		BufferedWriter bufferedWriter = null;

		try {
			fileWriter = new FileWriter(file);
			bufferedWriter = new BufferedWriter(fileWriter);

			String[] contentArr = content.split("\n");
			
			for (String s : contentArr) {
				bufferedWriter.write(s);
				bufferedWriter.newLine();
			}
			bufferedWriter.flush();

		} finally {
			if (fileWriter != null) {
				fileWriter.close();
			}
			if (bufferedWriter != null) {
				bufferedWriter.close();
			}
		}
	}
	
	public void appendToFile(String fileName, String content) throws IOException {
		File file = new File(fileName);

		FileWriter fileWriter = null;
		BufferedWriter bufferedWriter = null;

		try {
			fileWriter = new FileWriter(file,true);
			bufferedWriter = new BufferedWriter(fileWriter);
			String[] contentArr;
			if(content.contains("\n")) {
				contentArr = content.split("\n");
				for (String s : contentArr) {
					bufferedWriter.write(s);
					bufferedWriter.newLine();
				}
			} else{
				bufferedWriter.write(content);
			}
			bufferedWriter.flush();

		} finally {
			if (fileWriter != null) {
				fileWriter.close();
			}
			if (bufferedWriter != null) {
				bufferedWriter.close();
			}
		}
	}


}
