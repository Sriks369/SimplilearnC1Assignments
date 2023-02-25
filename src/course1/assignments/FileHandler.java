package course1.assignments;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class FileHandler {
	
	public static void writeToFile(String content, String filename) {		
		try {
		FileWriter fw = new FileWriter(filename);
		fw.write(content);
		fw.close();
		}
		catch(IOException e) {
			e.printStackTrace();
		}
		}
	public static void readFromFile(String filename) {
		try {
		FileReader fr = new FileReader(filename);
		BufferedReader br = new BufferedReader(fr);
		String temp;
		while((temp = br.readLine())!=null) {
			System.out.println(temp);
		}
		}
		catch(IOException e) {
			e.printStackTrace();
		}
		}
	public static void appendToFile(String content, String filename) {		
		try {
		FileWriter fw = new FileWriter(filename,true);
		fw.append("\n"+content);
		fw.close();
		}
		catch(IOException e) {
			e.printStackTrace();
		}
		}
	
	public static void main(String[] args) {
		
		//Creating a file first
		String filepath = "./text.txt";
		File file = new File(filepath);
		try {
		file.createNewFile();		
	    }catch(IOException e) {
	    	e.printStackTrace();
	    }
		//Calling the write method that we created to write to specified file
		writeToFile("I have joined java full stack developer course", filepath);
		//Appending the existing file with more content
		appendToFile("And iam happy about it", filepath);
		//Reading the filecontent and displaying in console
		readFromFile(filepath);
		
		
}

}
