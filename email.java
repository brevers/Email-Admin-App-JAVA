package emailApp;

import java.util.Scanner;

public class email {
	private String firstName;
	private String lastName;
	private String password;
	private String department;
	private int mailboxCap = 500;
	private int defaultPasswordLength = 8;
	private String alternateEmail;
	private String email;
	private String companySuffix ="myAMcompany.com";
	
	//Constructor first name and last name
	public email(String firstName, String lastName) {
		this.firstName = firstName;
		this.lastName = lastName;
		
		
		//call method asking for the department - return the department
		this.department = setDepartment();
		
	
		//call a method that returns a random password
		this.password = randomPassword(defaultPasswordLength);
		System.out.print("\nYour Password is: "+ this.password);
	
		//Combine elements to generate email
		email = firstName.toLowerCase() + "." + lastName.toLowerCase() + "@" + department + "-" + companySuffix;
		
	}
	
	
	// Ask for the department
	private String setDepartment() {
		System.out.print("Worker:"+ firstName + "\nENTER DEPARTMENT CODES\n1 for Sales\n2 for Development\n3 for Accounting\n0 for none\n Enter department code: ");
		Scanner in = new Scanner(System.in);
		int depChoice = in.nextInt();
		if(depChoice == 1) {
			return "sales";
		}else if (depChoice == 2) {
			return "dev";
		}else if(depChoice == 3) {
			return "acct";
		}else {return "";}
	}
	
	// Generate a random password
	private String randomPassword(int length) {
		String passwordSet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789!@#$%";
		char[] password = new char[length];
		for(int i=0; i<length ;i++) {
			int rand = (int) (Math.random() * passwordSet.length());
			password[i] = passwordSet.charAt(rand);
		}
		return new String (password);
		
	}
	
	// Set the mailbox
	public void setMailboxCapacity(int capacity) {
		this.mailboxCap = capacity;	
	}
	
	// Set the alternative email
	public void setAlternateEmail(String altEmail) {
		this.alternateEmail = altEmail;
	}
	// Change the password
	public void changePassword(String password) {
		this.password = password;
	}
	public int getMailboxCapacity() {return mailboxCap;}
	public String getAlternateEmail(){return alternateEmail;}
	public String getPassword() {return password;}
	
	public String showInfo() {
		return "\nDISPLAY NAME: " + firstName + " " + lastName + "\nCOMPANT NAME: " + email + "\nMAILBOX CAPACITY: " + mailboxCap + "mb" ; 
	}
}
