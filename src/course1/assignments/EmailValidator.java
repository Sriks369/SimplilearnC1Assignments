package course1.assignments;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class EmailValidator {
	
	 public static String verifyTheEmailInTheList(String email, List<String> emailList) {
		 
		   for(String s: emailList) {
			   
			   if(s.equalsIgnoreCase(email)) {
				  return "Entered Email Exists in the List";
			   }
			   } 
		   		  return "Entered Email Doesn't Exist in the List";			  
		   	 
	 }
	 public static void main(String[] args) {
		 Scanner s = new Scanner(System.in);
		   System.out.println("Enter the email to be checked in the list");
		   String email = s.next();
		   List<String> emailList = new ArrayList();
		    emailList.add("abc@gmail.com");
			emailList.add("xyz@hotmail.com");
			emailList.add("qwe@outlook.com");
			emailList.add("xyz@yahoo.com");
			
			String result = verifyTheEmailInTheList(email,emailList);
			System.out.println(result);			
		   
	}		
	 }


