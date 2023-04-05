package course1.assignments;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class FixingBugsOfTheApplication {
	
	 //I have moved below expenses variable to class level(static) to hold the values at session level for a user
	  static ArrayList<Integer> expenses = new ArrayList<Integer>();
	  //I have initialized the options variable to 1 i.e by default the user will have the exp values as 1000,2300,45000,32000,110
	  static int options=1;
	  //If user deliberately erases his exp values. Then system should show blank list to such user if user reviews his exp after erasing,
	  //this is achieved using below variable.
	  static int clear=0;
	
  public static void main(String[] args) {
      /*System.out.println("Hello World!");*/
      System.out.println("\n**************************************\n");
      System.out.println("\tWelcome to TheDesk \n");
      System.out.println("**************************************");
      optionsSelection();

  }
  private static void optionsSelection() {
      String[] arr = {"1. I wish to review my expenditure",
              "2. I wish to add my expenditure",
              "3. I wish to delete my expenditure",
              "4. I wish to sort the expenditures",
              "5. I wish to search for a particular expenditure",
              "6. Close the application"
      };
      int[] arr1 = {1,2,3,4,5,6};
      int  slen = arr1.length;
      for(int i=0; i<slen;i++){
          System.out.println(arr[i]);
          // display the all the Strings mentioned in the String array
      }
     if(options==1&&expenses.size()==0&&clear!=1) {        
      expenses.add(1000);
      expenses.add(2300);
      expenses.add(45000);
      expenses.add(32000);
      expenses.add(110);
      
     }
      System.out.println("\nEnter your choice:\t");
      Scanner sc = new Scanner(System.in);
      options =  sc.nextInt();
    
              switch (options){
                  case 1:
                      System.out.println("Your saved expenses are listed below: \n");
                      System.out.println(expenses+"\n");
                      optionsSelection();
                      break;
                  case 2:
                      System.out.println("Enter the value to add your Expense: \n");
                      expenses.add(sc.nextInt());
                      clear=0;
                      System.out.println("Your value is updated\n");
                      System.out.println(expenses+"\n");
                      optionsSelection();

                      break;
                  case 3:
                      System.out.println("You are about the delete all your expenses! \nConfirm again by selecting the same option...\n");
                      int con_choice = sc.nextInt();
                      if(con_choice==options){
                             expenses.clear();                           
                             clear=1;
                          System.out.println(expenses+"\n");
                          System.out.println("All your expenses are erased!\n");
                      } else {
                          System.out.println("Oops... try again!");
                      }
                      optionsSelection();
                      break;
                  case 4:
                      sortExpenses(expenses);
                      optionsSelection();
                      break;
                  case 5:
                      searchExpenses(expenses);
                      optionsSelection();
                      break;
                  case 6:
                      closeApp();
                      break;
                  default:
                      System.out.println("You have made an invalid choice!");
                      break;
              }
   

  }
  private static void closeApp() {
      System.out.println("Closing your application... \nThank you!");
          }
  private static void searchExpenses(ArrayList<Integer> arrayList) {
      int leng = arrayList.size();
      System.out.println("Enter the expense you need to search:\t");
      //Complete the method
      Scanner s = new Scanner(System.in);
      int expense = s.nextInt();      	
      	if(arrayList.contains(expense)) {
      		System.out.println("\nYes, the expense you entered exists in the system records\n");
      	}else        
      System.out.println("\nSorry, the expsense you entered does not exist in the system records\n");
  }
  private static void sortExpenses(ArrayList<Integer> arrayList) {
      int arrlength =  arrayList.size();
     //Complete the method. The expenses should be sorted in ascending order.
      Collections.sort(arrayList);
      System.out.println("\nYour expenses are sorted and here is the sorted list\n\n"+arrayList+"\n");
      
  }

}
