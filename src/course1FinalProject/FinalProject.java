package course1FinalProject;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class FinalProject {

	static List<String> fileslist;
	static File dir;

	public static void main(String[] args) {

		System.out.println("==================================================");
		System.out.println("Welcome to LockedMe.com UI.Here, you can manage your files in a user friendly way.");
		System.out.println("Developed By,");
		System.out.println("Lockers Pvt. Ltd.");
		System.out.println("==================================================");
		loadFiles();
		mainOptions();

	}

	public static void mainOptions() {
	  //Here are the main options for the user's action
	  String[] mo = {"1: Retrieve the Existing Files",
	                 "2: Manage My Files",
	                 "3: Close the Application"};
	  System.out.println("Here are your main options. Please input your choice eg: 1 or 2 etc.,\n");
	 
	  Scanner smo = new Scanner(System.in);
	  
	  for(String str: mo) {
		  System.out.println(str);
	  }
	  try {
	  switch(smo.nextInt()) {
	  case 1: 
		  retrieveFiles();
		  break;
	  case 2:
		  manageFiles();
		  break;
	  case 3:
		  closeApp();
		  break;
	  default:
		  System.out.println("You entered an incorrect input. Please try again\n");
		  mainOptions();
	  }
	  }catch(InputMismatchException e) {
		  System.out.println("You entered invalid input. Please read the instructions carefully and enter valid input\n");
		  mainOptions();
	  }
		
	}

	public static void retrieveFiles() {
		//Here we are retrieving the files in ascending order by below code
		System.out.println("Below are the files that currently exist in the files Directory\n");
		if(fileslist.size()==0) {
			System.out.println("Currently there are no files in the files directory.");
		}
		//Now the list is sorted
		Collections.sort(fileslist);
		fileslist.forEach(x->System.out.println(x));
		System.out.println();
		mainOptions();
	}
	
	public static void loadFiles() {
		dir = new File("./FilesDirectory");
		fileslist = Arrays.asList(dir.list());		
	}
	
	public static void manageFiles() {	
		System.out.println("Here are the more options for you. Kindly input your choice eg: 1 or 2 etc\n");
		String[] so = {"1: Add a File to the Existing Files",
                "2: Delete a File",
                "3: Search for a File",
                "4: Navigate to Main Menu"};
		for(String str: so) {
			System.out.println(str);
		}
		Scanner smf = new Scanner(System.in);
		try {
		switch(smf.nextInt()) {
		case 1: 
			addFile();
			break;
		case 2:
			deleteFile();
			break;
		case 3:
			searchFile();
			break;
		case 4:
			navigateToMainMenu();
			break;
		default:
			System.out.println("You entered an incorrect input. Please try again\n");
			manageFiles();		
	}}
		catch(InputMismatchException e) {
			System.out.println("You entered invalid input. Please read the instructions carefully and enter valid input\n");
			manageFiles();
		}
	}

	public static void closeApp() {
		System.out.println("Application has been closed!");
		System.exit(0);
	
	}
	
	public static void addFile() {
		System.out.println("Please enter the file name. We will add your file to the existing file directory");
		Scanner saf = new Scanner(System.in);
		String str = saf.nextLine();
		StringBuilder sb = new StringBuilder(str.toLowerCase());
		sb.setCharAt(0, String.valueOf(sb.charAt(0)).toUpperCase().charAt(0));
		File file = new File("./FilesDirectory/"+sb+".txt");
		if(file.exists()) {
		System.out.println("File already exists!");
		}else {
		try {
			file.createNewFile();
			loadFiles();
		} catch (IOException e) {
			System.out.println("Directory location is not found\n");
		}
		System.out.println("Your file is successfully added!\n");
		}
		
		manageFiles();
		
	}
	public static void deleteFile() {
		System.out.println("Enter the filename that you want to delete. Note that Filenames are Case Sensitive");
		 Scanner sdf = new Scanner(System.in);
	     String temp = sdf.nextLine()+".txt";
	     if(fileslist.contains(temp)) {	
		    	File deletefile = new File("./FilesDirectory/"+temp);
		    	if(deletefile.delete()) {
		    		System.out.println("File deleted successfully!\n");
		    		loadFiles();
		    	}else
		    		System.out.println("File could not be deleted. File may be opened or being used by another program\n");
		     }	else 
		    	 System.out.println("File Not Found. Enter the correct Filename\n");	
	     manageFiles();
	}
	
	public static void searchFile() {
		System.out.println("Enter the filename that you want to search in the files directory. Note that Filenames are Case Sensitive");
		Scanner ssf = new Scanner(System.in);
		String temp = ssf.nextLine()+".txt";
	     if(fileslist.contains(temp)) {
	    	 System.out.println("Yes, the file you are searching for exists in the files directory\n");
	     }else
	    	 System.out.println("File that you are searching is not found\n");
	     manageFiles();
	}
	public static void navigateToMainMenu() {
	
		mainOptions();
	
	}
	

}
