package FileHandling;

import java.io.IOException;

public class FileHandlingMain {

	public static void main(String[] args) throws IOException {
		FileHandling fh = new FileHandling();

		fh.readFileStream("src/files/input.txt");

		String content = "ShalakaSharma is practicing hard to clear Amazon Phone Interview";

		fh.writeFileStream("src/files/output.txt", content);
		
		fh.readFileLineByLine("src/files/inputLineByLine.txt");
		
		content =  "This is first line\nThis is second line\nThis is third line\nThis is fourth line\nThis is fifth line";
		
		fh.writeFileLineByLine("src/files/outputLineByLine.txt", content);
		
		content = "ShalakaSharma is practicing hard to clear Amazon Phone Interview";
		
		fh.appendToFile("src/files/outputLineByLine.txt", content);
		
		
	}
}
