

public class User {

  //set object variables
  private String username;
  private String password;
  private Float balance;

  //default constructor
  public User(){
    
  }

  //user creation constructor
  public User (String username, String password, Float balance){
    this.username = username;
    this.password = password;
    this.balance = balance;
  }

  //getter for username variable
  public String getUsername() {
  	return username;
  }

  //setter for username variable
  public void setUsername(String username) {
  	this.username = username;
  }

  //getter for password variable
  public String getPassword() {
  	return password;
  }

  //setter for password variable
  public void setPassword(String password) {
  	this.password = password;
  }

  //getter for balance variable
  public Float getBalance() {
  	return balance;
  }

  //setter for balance variable
  public void setBalance(Float balance) {
  	this.balance = balance;
  }

  //tostring methods prints user object / all arguments as a string 
  @Override
  public String toString(){
    return "User [username= " + username + ", password = " + password + ", balance = " + balance + "]";
  }
  
}
