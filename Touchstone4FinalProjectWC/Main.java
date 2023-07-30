import java.util.Scanner;

class Main {
  public static void main(String[] args) {

    //set global variables
    Scanner scan = new Scanner(System.in);
    User u = new User();
    Boolean done = false;
    Boolean loggedIn = false;

    //application loop - not 'done' until user exits 
    while (!done){
      System.out.println("Welcome! Please press '1' to create account, '2' for login, or '3' to exit.");
      //store user selection
      int choiceOne = scan.nextInt();

      //account creation block - completes and returns to first options
      if (choiceOne==1){
        System.out.println("Plese enter a username: ");
        String username = scan.next();
        System.out.println("Please enter a password: ");
        String password = scan.next();
        System.out.println("Please enter a starting balance: ");
        Float balance = scan.nextFloat();

        //save new user object 
        u = new User(username, password, balance);
        System.out.println("Thank you! Account created, returning you to home screen...");
      } 

      //logged in block - user must 'log out' to return to first options
      else if(choiceOne==2){
        System.out.println("Please enter your username: ");
        String username = scan.next();
        System.out.println("Please enter your password: ");
        String password = scan.next();

        //check if input matches saved values in user object
        if (username.equals(u.getUsername()) && password.equals(u.getPassword())){
          //if credentials match - loggedIn is set to true for loggged in options loop
          loggedIn = true;
          System.out.println("Welcome, " + username);

          //logged in options
          while (loggedIn){
            System.out.println("Please press '1' for deposit, press '2' for withdrawal, or press '3' to log out.");
            int choiceTwo = scan.nextInt();

            //deposit option - completes and returns to logged in options
            if (choiceTwo==1){
              System.out.println("Please enter your deposit amount: ");
              Float deposit = scan.nextFloat();
              //adding deposit input to existing balance
              u.setBalance(u.getBalance()+deposit);
              System.out.println("Your new balance is: "+u.getBalance());
              System.out.println("Returning you to account home screen...");
            }

            //withdrawal option - returns user to logges in options
            else if (choiceTwo==2){
              System.out.println("Please enter your withdrawal amount: ");
              Float withdrawal = scan.nextFloat();
              //subtracting withdrawal input from existing balance
              u.setBalance(u.getBalance()-withdrawal);
              System.out.println("Your new balance is: "+u.getBalance());
              System.out.println("Returning you to account home screen...");
            }

            //exit option - sets loggedIn to false which exits logged in options loop - returns user to first options
            //also catches user input error
            else{
              loggedIn = false;
              System.out.println("Returning you to home screen...");
            }
          } 
        }
      }

      //exit block - sets done to true - exits application loop
      //also catches user input error
      else{
        System.out.println("Goodbye!");
        done=true;
      }
    }
    //close scanner to avoid resource leak - probably not neccessary - force of habit
    scan.close();
  }
}