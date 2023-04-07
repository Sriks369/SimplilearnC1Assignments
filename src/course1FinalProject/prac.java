package course1FinalProject;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class prac {
	static Scanner s = new Scanner(System.in);
	static List<String> fileslist;
	static File dir;
	public static void main(String[] args) {
		System.out.println("Please enter the file name. We will add your file to the existing file directory");
		String str = s.nextLine();
		StringBuilder sb = new StringBuilder(str.toLowerCase());
		sb.setCharAt(0, String.valueOf(sb.charAt(0)).toUpperCase().charAt(0));
		File file = new File("./FilesDirectory/"+sb+".txt");
		try {
			file.createNewFile();
		} catch (IOException e) {
			System.out.println("Directory location is not found");
		}
		System.out.println("Your file is successfully added!");
	     
	}

}
