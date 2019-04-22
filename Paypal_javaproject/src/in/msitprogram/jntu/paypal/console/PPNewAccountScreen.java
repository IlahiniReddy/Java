package in.msitprogram.jntu.paypal.console;

import java.io.IOException;
import java.util.Scanner;
import in.msitprogram.jntu.paypal.accounts.PPAccount;
import in.msitprogram.jntu.paypal.accounts.PPBusinessAccount;
import in.msitprogram.jntu.paypal.accounts.PPRestrictedAccount;
import in.msitprogram.jntu.paypal.accounts.Profile;
import in.msitprogram.jntu.paypal.persistance.DataStore;
import in.msitprogram.jntu.paypal.utils.PPToolkit;

public class PPNewAccountScreen {
	Profile profile;
	PPAccount account;
	String email;
	Scanner scan;
	
	public PPNewAccountScreen(String email) {
		profile = new Profile();
		scan = new Scanner(System.in);
		this.email = email;
	}

	public void show() throws Exception 
	{
		profile=createProfile();
		Scanner sc=new Scanner(System.in);
		System.out.println("1.Personal Account\n 2.Student Account\n 3.Business Account\n");
		System.out.println("Enter your choice:");
		int ch=sc.nextInt();
		switch(ch)
		{
			case 1:System.out.println("Personal Account");
				createPersonalAccount();
				completeAccountCreation();
					break;
			case 2:System.out.println("Student Account");
					createStudentAccount();
					break;
			case 3:System.out.println("Business Account ");
					createBusinessAccount();
					break;
			default:System.out.println("Enter your choice:");
		}
		//check if the account with the given email address exists 
		
		//if not create the user profile
		
		//show the account types
		
		//based on the given account type selected create the account object
	}

	private Profile createProfile() {
		// use this for creating the profile
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter name:");
		String name=sc.nextLine();
		profile.setname(name);
		System.out.println("Enter Address:");
		String address=sc.nextLine();
		profile.setaddress(address);
		System.out.println("Enter phone number:");
		String phone=sc.nextLine();
		profile.setphone(phone);
		return profile;
	}

	private void createBusinessAccount() throws IOException
	{
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter Business name:");
		String bname=sc.nextLine();
		System.out.println("Enter pan number:");
		int pan=sc.nextInt();
		//use this for creating the business account
	}

	private void createStudentAccount() throws IOException 
	{
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter date of birth:");
		String dob=sc.nextLine();
		System.out.println("Enter Parent paypal emailid:");
		int p=sc.nextInt();
		//use this for creating the student account 
	}

	/*
	 * this method create the personal account, saves it to the file system	 */
	private void createPersonalAccount() throws IOException 
	{
		Scanner sc=new Scanner(System.in);
		account=new PPAccount(profile);
		account.setEmail(email);
		System.out.println("Enter date of birth:");
		String d=sc.nextLine();
		account.setdate(d);
		System.out.println("Enter pan number:");
		String p=sc.nextLine();
		account.setpan(p);
		System.out.println("Enter initial amount");
		float i=sc.nextFloat();
		account.setintial(i);
		account.setstatus(false);
		//use this for creating the personal account
	}
	
	private void completeAccountCreation() throws Exception
	{
		String code=PPToolkit.generateActivationCode();
		account.activate(code);
		DataStore.writeAccount(account);
		System.out.println("\n 1.Activation\n 2.Mainmenu\n");
		System.out.println("Enter choice:");
		Scanner sc=new Scanner(System.in);
		int ch=sc.nextInt();
		switch(ch)
		{
			case 1:System.out.println("Activation");
			       PPAccountActivationScreen.show(email);
				   break;
			case 2:System.out.println("Mainmenu");
			       PPAccountScreen.show();
				   break;
			default:System.out.println("Enter your choice:");		
		}
		//generate activation code and set it to account
		//send activation code to the phone
		//ask & redirect the user to the activation screen or the main menu
		
	}

}
